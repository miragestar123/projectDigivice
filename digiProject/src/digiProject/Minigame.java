/* Minigame
 * Methods for battle / training slider minigame
 * Author: Xandino
*/
package digiProject;
import java.io.IOException;
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
	public interface outputCallback {
		Integer onTaskEnd(int i);
	}
	
	//Task loop for minigame timer
	private class RunAttackMeter extends java.util.TimerTask {
		java.util.ListIterator<Integer> iterator;
		private boolean goFoward = true;
		
		//Constructor for callback sender
		private outputCallback callback;
		private RunAttackMeter(List<Integer> attackMeter, outputCallback callback) {
			this.iterator = attackMeter.listIterator();
			this.callback = callback;
		}
		
		
		public void run() {
			//System.out.println(iterator.nextIndex());
			if (goFoward == true) {
				if (iterator.hasNext()) {
					iterator.next();
				}
				else {
					goFoward = !goFoward;
				}
			}
			if (goFoward == false) {
				if (iterator.hasPrevious()) {
					iterator.previous();
				}
				else {
					goFoward = !goFoward;
				}
			}
			if (callback != null) {
				callback.onTaskEnd(iterator.nextIndex());
			}
		}
	}
	
	//Task for checking user input
	private class InputCheck extends java.util.TimerTask {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		String input;
		boolean inputDetected;
		
		//Task and callback sender constructor
		outputCallback callback;
		private InputCheck(outputCallback callback) {
			this.input = "";
			this.inputDetected = false;
			this.callback = callback;
		}
		
		public void run() {
			input = scan.next();
			if (input.length() != 0) {
				inputDetected = true;
				callback.onTaskEnd(1);
			}
			else {
				callback.onTaskEnd(0);
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
	
	public static void main(String[] args) {
		//Attack Meter Generation
		Minigame minigame = new Minigame();
		FilePathGen f = new FilePathGen();
		Path filePath = f.getFilePath("AM.txt");
		java.util.List<Integer> attackMeter = minigame.getAttackMeter(filePath);
		if (attackMeter.size() == 0) {
			return;
		}
		
		//Callback receivers
		outputCallback output = new outputCallback() {
			@Override
			public Integer onTaskEnd(int i) {
				return i;
			}
		};	
		outputCallback user = new outputCallback() {
			@Override
			public Integer onTaskEnd(int i) {
				return i;
			}
		};
		
		
		//Preparing the minigame
		java.util.Timer timer1 = new java.util.Timer("minigame", false);
		java.util.Timer timer2 = new java.util.Timer("userInput", true);
		RunAttackMeter runMinigame = minigame.new RunAttackMeter(attackMeter, output);
		InputCheck inputCheck = minigame.new InputCheck(user);
		
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
		timer2.schedule(inputCheck, 0, 3);
		System.out.println("GO!!!");
		timer1.scheduleAtFixedRate(runMinigame, 0, 3);
		long start = System.nanoTime();
		while ((System.nanoTime() - start) < 3000000000L && !inputCheck.inputDetected) {
			
		}
		timer1.cancel();
		int result = attackMeter.get(runMinigame.iterator.nextIndex());
		System.out.println("===============================================");
		System.out.println(runMinigame.iterator.nextIndex());
		System.out.println(result);
		System.out.println(inputCheck.inputDetected);
	}

}