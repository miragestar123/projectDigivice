/* Minigame
 * Methods for battle / training slider minigame
 * Author: Xandino
*/
package digiProject;
import java.io.IOException;
import java.lang.reflect.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Minigame extends mainDigivice{
	//filename argument points to a text file in the /res directory
	private java.util.List<Integer> getAttackMeter(Path filePath) {
		try {
			java.util.List<String> lines = Files.readAllLines(filePath);
            java.util.List<Integer> attackMeter = new java.util.LinkedList<>();
            for (String line : lines) {
                attackMeter.add(Integer.parseInt(line.trim()));
            }
            return attackMeter;
        }
        
        catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return new java.util.LinkedList<>();
        }
        
	}
	
	//Callback interface for the attack meter
	@FunctionalInterface
	public interface OutputCallback {
		int onTaskEnd(int i);
	}
	
	//Holder class for callbacks
	private class Holder{
		public int value;
		
		public Holder(int value) {
			this.value = value;
		}
	}
	
	//TimerTask manager
	private class ThreadManager implements OutputCallback{
		@SuppressWarnings("unused")
		private int output;
		private java.util.Timer timer;
		
		//Constructor passes class to run as an argument
		private ThreadManager(java.util.TimerTask task, long delay) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
			this.timer = new java.util.Timer(this.toString(), false);
			timer.scheduleAtFixedRate(task, 0, delay);
		}
		
		//Cancels timer thread
		private void stop() {
			timer.cancel();
		}
		
		public int onTaskEnd(int i) {
			return this.output = i;
		}
		
	}
	
	//Task loop for minigame timer
	private class RunAttackMeter extends java.util.TimerTask {
		private OutputCallback callback;
		private java.util.ListIterator<Integer> iterator;
		private boolean goFoward = true;
		private int output;
		
		//Constructor for callback sender
		private RunAttackMeter(List<Integer> attackMeter, OutputCallback callback) {
			this.iterator = attackMeter.listIterator();
			this.callback = callback;
			this.output = 0;
		}
		
		
		public void run() {
			if (goFoward == true) {
				if (iterator.hasNext()) {
					output = iterator.next();
					callback.onTaskEnd(output);
				}
				else {
					goFoward = !goFoward;
				}
			}
			if (goFoward == false) {
				if (iterator.hasPrevious()) {
					output = iterator.previous();
					callback.onTaskEnd(output);
				}
				else {
					goFoward = !goFoward;
				}
			}
			//System.out.println(iterator.nextIndex());
		}
	}
	
	//Task for checking user input
	private class InputCheck extends java.util.TimerTask {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		String input;
		int inputDetected;
		
		//Task and callback sender constructor
		OutputCallback callback;
		private InputCheck(OutputCallback callback) {
			this.input = "";
			this.inputDetected = 0;
			this.callback = callback;
		}
		
		public void run() {
			input = scan.next();
			if (input.length() != 0) {
				inputDetected = 1;
				callback.onTaskEnd(inputDetected);
			}
			else {
				callback.onTaskEnd(inputDetected);
			}
		}
	}
	
	//Method to pause main (not required)
	private static void pause(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		}
		catch (InterruptedException e) {}
	}
	
	//Method for actually running attack meter minigame.
	//Parameters:
	//	Minigame minigame:		Requires an instance of the .class file
	//	int value:				Controls the speed of the slider. Has a range of [1-7]
	//Returns:
	//	0						Method failed to load background tasks
	//	1-4						Attack meter result
	public int sliderMinigame(Minigame minigame, int index, int value) {
		value = Math.max(1, Math.min(value, 7));
		String fileName;
		long start;
		long timeOut = 3000000000L;
		long speed = ((3 * (value - 1)) + 10);
		Holder resultHolder = new Holder(0);
		Holder endHolder = new Holder(0);
		ThreadManager runInput;
		ThreadManager runMinigame;
		
		//Attack Meter Generation
		fileName = "AM.txt";
		FilePathGen f = new FilePathGen();
		Path filePath = f.getFilePath(fileName);
		java.util.List<Integer> attackMeter = minigame.getAttackMeter(filePath);
		if (attackMeter.size() == 0) {
			return 0;
		}
		
		//Preparing the minigame
		OutputCallback resultCallback = result -> resultHolder.value = result;
		OutputCallback userCallback = result -> endHolder.value = result;
		RunAttackMeter runAttackMeter = minigame.new RunAttackMeter(attackMeter, resultCallback);
		InputCheck inputCheck = minigame.new InputCheck(userCallback);
		
		//Running the minigame
		System.out.println("Rules...");
		System.out.println("Enter 'Z' within 3sec to stop the Attack Meter");
		System.out.println("Reday!");
		pause(500L);
		System.out.println("3...");
		pause(1000L);
		System.out.println("2..!");
		pause(1000L);
		System.out.println("1.!!");
		pause(1000L);
		try {	//Starts background key listener
			runInput = minigame.new ThreadManager(inputCheck, (timeOut - 1L));
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return 0;
		}
		
		System.out.println("GO!!! \n");
		
		try {	//Starts background attack meter minigame
			runMinigame = minigame.new ThreadManager(runAttackMeter, speed);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return 0;
		}
		
		start = System.nanoTime();
		while ((System.nanoTime() - start) < 3000000000L && endHolder.value == 0) {
			pause(1L);
		}
		runInput.stop();
		runMinigame.stop();
		
		System.out.println("===============================================");
		System.out.println(runAttackMeter.iterator.nextIndex());
		System.out.println(resultHolder.value);
		System.out.println(endHolder.value + "\n");
		
		return resultHolder.value;
	}
	
	
	//Main for testing purposes only, uncomment to test class
	/*
	public static void main(String[] args) {
		Minigame minigame = new Minigame();
		int output = minigame.sliderMinigame(minigame, 0, 3);
		minigame = null;
		System.out.println("===============================================");
		System.out.println(output);
	}*/

}