package digiProject;

import java.io.*;
import java.util.*;

import digiProject.Digivolve.digivolver;

public class digimonReader {
    public static void main(String[] args) {
        FilePathGen findFilePath = new FilePathGen();
        
        // Creates String reflecting actual file path to be referenced later
        String filePath = findFilePath.getFilePath("digimonList.txt").toString();  
        
        // Initializes new list of digimon Class objects based on parameters from readDigimonFile Class
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
                int index = Integer.parseInt(parts[0]);  
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
                int spirit = Integer.parseInt(parts[12]);
                
                // Create a digimon object with the extracted data
                digimon d = new digimon(index, species, level, attribute, hunger, victory, needPoop, isInjure, isSick, reincCounter, atkPwr, HP, spirit);
                
                // Add the digimon to the list
                digiList.add(d);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return digiList;
    }
    
    public static List<Digivolve.digivolver> readDigivolveFile(String filePath) {
    	Digivolve newDigivolve = new Digivolve();
        List<Digivolve.digivolver> digivolveList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line by commas
                String[] parts = line.split(",");
                
                // Extract values for the digivolve object  
                int nextEvoIndex = Integer.parseInt(parts[0]);
                int careMistakeTracker = Integer.parseInt(parts[1]);
                int needAreaClear = Integer.parseInt(parts[2]);
                int needsAtk = Integer.parseInt(parts[3]);
                int needsHP = Integer.parseInt(parts[4]);
                int needsSpirit = Integer.parseInt(parts[5]);
                
                // Create a digivolve object with the extracted data
                Digivolve.digivolver d = newDigivolve.new digivolver(nextEvoIndex,careMistakeTracker,needAreaClear,needsAtk,needsHP,needsSpirit);
                
                // Add the digivolve to the list
                digivolveList.add(d);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return digivolveList;
    }

    // Method to return the list of digimons
    public static List<digimon> getDigiList(String filePath) {
        return readDigimonFile(filePath);
    }
    
    public static List<Digivolve.digivolver> getDigivolveList(String filePath) {
        return readDigivolveFile(filePath);
    }
}