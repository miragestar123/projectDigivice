package digiProject;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;

public class mainDigivice {

    public static void main(String[] args) {
        Scanner inputCheck = new Scanner(System.in);

        // User input for date and time, now including the year
        System.out.println("Set the date: \nWhat month is it? 1 - 12.");
        int month = inputCheck.nextInt();
        System.out.println("And the day?");
        int day = inputCheck.nextInt();
        System.out.println("What year is it? (Enter in yyyy format)");
        int year = inputCheck.nextInt();
        System.out.println("And what time is it currently? Hour first.");
        int hour = inputCheck.nextInt();
        System.out.println("Last, the minutes.");
        int minutes = inputCheck.nextInt();
        
        // Display the current date and time including the year
        System.out.println("So it's looking like today's date is " + month + "/" + day + "/" + year + " and " + hour + ":" + minutes + " is the time.");
        
        // Initialize the clock and set the date/time with year included
        Clock clock = new Clock(month, day, year, hour, minutes);
        clock.startClock();
        
        // Initialize Digimon with current time (or other initialization logic)
        digimon firstGuy = new digimon(minutes, null, null, null, minutes, minutes, false, false, false, minutes, minutes, minutes);
        
        // Interaction with the Digimon
        String goforth = "Yes";
        System.out.println("Initializing...");
        System.out.println(firstGuy.getSpecies() + " is the species of the first digimon we're using here.");
        System.out.println("Dorumon's attack power is " + firstGuy.atkPwr + ". \nWould you like to train it further? Type Yes to train.");
        String userInput = inputCheck.next();
        
        // User decides whether to train Digimon
        if (userInput.equals(goforth)) {
            firstGuy.atkPwr += 100;
            System.out.println("Attack power is now " + firstGuy.atkPwr);
        } else {
            System.out.println("Why bother asking then?");
        }
    }
}

// Clock class to manage the system time and continuously update it
class Clock {
    private int month, day, year, hour, minute;
    private Timer timer;

    public Clock(int month, int day, int year, int hour, int minute) {
        this.month = month;
        this.day = day;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
        this.timer = new Timer();
    }

    // Start the clock and update it every second
    public void startClock() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // Increment the time by one minute for simplicity (you can adjust this for seconds if you want more precise time simulation)
                updateClock();
                displayTime();
            }
        }, 0, 60000); // Update every minute
    }

    // Increment the clock by one minute
    private void updateClock() {
        minute++;
        if (minute == 60) {
            minute = 0;
            hour++;
            if (hour == 24) {
                hour = 0;
                day++;
                // Handle month overflow (for simplicity, assuming 30 days per month)
                if (day > 30) {
                    day = 1;
                    month++;
                    if (month > 12) {
                        month = 1; // Reset to January after December
                        year++;  // Increment the year after December
                    }
                }
            }
        }
    }

    // Display the current date and time including the year
    private void displayTime() {
        System.out.println("Current Date: " + month + "/" + day + "/" + year);
        System.out.println("Current Time: " + String.format("%02d", hour) + ":" + String.format("%02d", minute));
    }
}