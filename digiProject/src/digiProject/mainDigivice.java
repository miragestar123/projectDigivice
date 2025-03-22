package digiProject;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
public class mainDigivice {
	
	public static void main(String[] args) {
		Scanner inputCheck = new Scanner(System.in);
		System.out.println("Set the date: \n" + "What month is it? 1 - 12.");
		int month = inputCheck.nextInt();
		System.out.println("And the day?");
		int day = inputCheck.nextInt();
		System.out.println("And what time is it currently? Hour first.");
		int hour = inputCheck.nextInt();
		System.out.println("Last, the minutes.");
		int minutes = inputCheck.nextInt();
		System.out.println("So it's looking like today's date is " + month + "." + day + " and " + hour + ":" + minutes + " is the time.");
		digimon firstGuy = new digimon(null, null, null, minutes, minutes, false, false, false, minutes, minutes, minutes);
		String goforth = "Yes";
		System.out.println("Initializing...");
		System.out.println(firstGuy.getSpecies() + " is the species of the first digimon we're using here.");
		System.out.println ("Dorumon's attack power is "  + firstGuy.atkPwr + ". \n" + "Would you like to train it further? Type Yes to train.");
		String userInput = inputCheck.next();
		if (userInput.equals(goforth)) {
		firstGuy.atkPwr += 100;
		System.out.println ("Attack power is now " + firstGuy.atkPwr);
		//checking changes
		} else {
			System.out.println("Why bother asking then?");
		}
		
	}
}


