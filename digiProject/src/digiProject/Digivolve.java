package digiProject;

import java.util.List;
import java.util.Scanner;

public class Digivolve extends mainDigivice {
	
			public digimon startDigivolve(digimon myDigimon) {
				Scanner inputCheck = new Scanner(System.in);
				digivolver myDigivolve = null; //initialize blank variable myDigivolve
				digimon digivolvedGuy = null;
				digimon eggie = new digimon(1, "Opponents Species", "Type", null, 100, 50, false, false, true, 5, 50, 100, 1);
				digimon myGuy = myDigimon;
				String findDigivolve = myDigimon.species + ".txt";//sets textfile name equal to species of current digimon
				//Initializes digivolve list
				FilePathGen findDigivolvePath = new FilePathGen();
			    String digivolvePath = findDigivolvePath.getFilePath("/digivolveList/" + findDigivolve).toString();
			    List<Digivolve.digivolver> digivolveList = digimonReader.getDigivolveList(digivolvePath);
			    //initialize digimon list 
		        FilePathGen findFilePath = new FilePathGen();
		        String filePath = findFilePath.getFilePath("digimonList.txt").toString();
		        List<digimon> digiList = digimonReader.getDigiList(filePath);  // Initialize the list
		        
			    //outputs list for view
			    System.out.println(digivolveList);
			    System.out.println("Input the index.");
			    int indexFinder = inputCheck.nextInt();
		        // Check if the index is valid
			    /*while (indexFinder != digivolveList.parts[0]) { digivolvelist.parts needs to call for the nextEvoIndex belonging to each individual list item in digivolveList
			    	
			    }*/
		        if (indexFinder >= 0) {
		            myDigivolve = digivolveList.get(indexFinder);
		            if (myGuy.atkPwr >= myDigivolve.needsAtk && myGuy.HP >= myDigivolve.needsHP && myGuy.spirit >= myDigivolve.needsSpirit) {
		            	digivolvedGuy = digiList.get(myDigivolve.nextEvoIndex);
		            	System.out.println("Your digimon digivolved to " + digivolvedGuy.species + "!!!");
		            	return digivolvedGuy;
		            	
		            }else {
			            System.out.println("Cannot Digivolve.");
			            return digivolvedGuy;
		            }
		             
		            }else {
		            	return eggie;
		            }
		        
		       
			}
			public class digivolver{
				

				int nextEvoIndex;
				 int careMistakeTracker;
				 int needAreaClear;
				 int needsAtk;
				 int needsHP;
				 int needsSpirit;
				 String backupSpecies;
				 
				 public digivolver(int nextEvoIndex, int careMistakeTracker, int needAreaClear, int needsAtk, int needsHP, int needsSpirit) {
						super();
						this.nextEvoIndex = nextEvoIndex;
						this.careMistakeTracker = careMistakeTracker;
						this.needAreaClear = needAreaClear;
						this.needsAtk = needsAtk;
						this.needsHP = needsHP;
						this.needsSpirit = needsSpirit;
					}
				 
				 String mySpecies;
				 public String getMySpecies() {
					return mySpecies;
				}

				public void setMySpecies(String mySpecies) {
					this.mySpecies = mySpecies;
				}

				public int getNextEvoIndex() {
					return nextEvoIndex;
				}

				public void setNextEvoIndex(int nextEvoIndex) {
					this.nextEvoIndex = nextEvoIndex;
				}

				public int getCareMistakeTracker() {
					return careMistakeTracker;
				}

				public void setCareMistakeTracker(int careMistakeTracker) {
					this.careMistakeTracker = careMistakeTracker;
				}

				public int getNeedAreaClear() {
					return needAreaClear;
				}

				public void setNeedAreaClear(int needAreaClear) {
					this.needAreaClear = needAreaClear;
				}

				public int getNeedsAtk() {
					return needsAtk;
				}

				public void setNeedsAtk(int needsAtk) {
					this.needsAtk = needsAtk;
				}

				public int getNeedsHP() {
					return needsHP;
				}

				public void setNeedsHP(int needsHP) {
					this.needsHP = needsHP;
				}

				public int getNeedsSpirit() {
					return needsSpirit;
				}

				public void setNeedsSpirit(int needsSpirit) {
					this.needsSpirit = needsSpirit;
				}

				public String getBackupSpecies() {
					return backupSpecies;
				}

				public void setBackupSpecies(String backupSpecies) {
					this.backupSpecies = backupSpecies;
				}

				@Override
				public String toString() {
					return "digivolver [nextEvoIndex=" + nextEvoIndex + ", careMistakeTracker=" + careMistakeTracker
							+ ", needAreaClear=" + needAreaClear + ", needsAtk=" + needsAtk + ", needsHP=" + needsHP
							+ ", needsSpirit=" + needsSpirit + ", backupSpecies=" + backupSpecies + ", mySpecies="
							+ mySpecies + "]";
				}
		}
			
}
		        
			    
			

				

			