package digiProject;


	import java.io.*;
	import java.util.*;

public class digimonReader {
	    public static void main(String[] args) {
	    	
	    	//Creates String reflecting actual file path to be referenced later
	        String filePath = "digimonList.txt";  // Adjust this path to actual file path
	        //Initializes new list of digimon Class objects based on parameters from readDigimonFile Class
	        List<digimon> digiList = readDigimonFile(filePath);
	        
	        // Print out the list of Digimon
	        for (digimon d : digiList) {
	            System.out.println(d);
	        }
	    }

	    public static List<digimon> readDigimonFile(String filePath) {
	        List<digimon> digiList = new ArrayList<>();
	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                // Split the line by commas
	                String[] parts = line.split(",");
	                
	                // Extract values for the digimon object
	                int index = Integer.parseInt(parts[0]);  // This is the index, not used here but could be used
	                String species = parts[1];
	                String level = parts[2];
	                String attribute = parts[3];
	                double hunger = Double.parseDouble(parts[4]);
	                double victory = Double.parseDouble(parts[5]);
	                boolean needPoop = Boolean.parseBoolean(parts[6]);
	                boolean isInjure = Boolean.parseBoolean(parts[7]);
	                boolean isSick = Boolean.parseBoolean(parts[8]);
	                int reincCounter = Integer.parseInt(parts[9]);
	                int atkPwr = Integer.parseInt(parts[10]);
	                int HP = Integer.parseInt(parts[11]);
	                
	                // Create a digimon object with the extracted data
	                digimon d = new digimon(index, species, level, attribute, hunger, victory, needPoop, isInjure, isSick, reincCounter, atkPwr, HP);
	                
	                // Add the digimon to the list
	                digiList.add(d);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return digiList;
	    }
	}

