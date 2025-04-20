package digiProject;
import java.util.List;
import java.util.Random;

import digiProject.Digivolve.digivolver;

public class battle extends mainDigivice {
	public static void main(String[] args) {
		digimon testDigimon = null;
		digimon testDigimon2 = null;
		digimon testDigimon3 = new digimon(3,"Agumon","Rookie","Dragon",100,0,false,false,false,0,150,220,1);
		digimon testDigimon4 = new digimon(5,"Betamon","Rookie","Aquan",100,0,false,false,false,0,150,150,1);
		Random randomTest = new Random();
        FilePathGen findFilePath = new FilePathGen();
        String filePath = findFilePath.getFilePath("digimonList.txt").toString();
        List<digimon> digiList = digimonReader.getDigiList(filePath);  
        //randomize digimon1
        int randomNum = randomTest.nextInt(23) + 1;
        randomNum = randomTest.nextInt(23) + 1;
        System.out.println(randomNum);
        if (randomNum > 0) {
        	for (digimon d : digiList) {
        	    if (d.getIndex() == randomNum) {
        	    	testDigimon = digiList.get(d.index);
        	        break;
        }
        	}
        }
        //randomize digimon2
        randomNum = randomTest.nextInt(23) + 1;
        System.out.println(randomNum);
        if (randomNum > 0) {
        	for (digimon d : digiList) {
        	    if (d.getIndex() == randomNum) {
        	    	testDigimon2 = digiList.get(d.index);
        	        break;
        }
        	}
        }
        
		battle battle = new battle();
		//BattleInstance newBattle = battle.new BattleInstance(testDigimon);

		//myBattler = initializeDigimon;
		battle.startBattle(testDigimon, testDigimon2); 
	}
	
	/*private class BattleInstance{
		public digimon myBattler = null;
		public digimon theOpp = null;
		
		public BattleInstance(digimon selectedDigimon) {
	        // Initialize myBattler with selectedDigimon's values
	        this.myBattler = new digimon(
	               selectedDigimon.getIndex(),
	               selectedDigimon.getSpecies(),
	               selectedDigimon.getLevel(),
	               selectedDigimon.getAttribute(),
	               selectedDigimon.getHunger(),
	               selectedDigimon.getVictory(),
	               selectedDigimon.isNeedPoop(),
	               selectedDigimon.isInjure(),
	               selectedDigimon.isSick(),
	               selectedDigimon.getReincCounter(),	
	               selectedDigimon.getAtkPwr(),
	               selectedDigimon.getHP(),
	               selectedDigimon.getSpirit()
	            );
	        
	        // Initialize the opponent Digimon with random values or a different Digimon
	        // This can be modified as needed
	        this.theOpp = new digimon(1, "Opponents Species", "Type", null, 100, 50, false, false, true, 5, 50, 100, 1);
	    }
	}*/

    public void startBattle(digimon myBattler, digimon theOpp) {
        int myHitPoints = myBattler.HP;
        int oppHitPoints = theOpp.HP;
        int turnCount = 0;
        double myHitrate = ((myBattler.atkPwr * 100)/(myBattler.atkPwr + theOpp.atkPwr)); //+ attributeAdvantage
        double oppHitrate = ((theOpp.atkPwr * 100)/(theOpp.atkPwr + myBattler.atkPwr));
        System.out.println("Battle Loading... " + myBattler.species + " V.S. " +  theOpp.species + "!!!");
        System.out.println("Ready??? \nFight!!!");

        while (myHitPoints > 0 && oppHitPoints > 0) {
            turnCount++;
            System.out.println("Turn " + turnCount + ":");

            // Your digimon attacks
            System.out.println("Your digimon swings!!!");
            Random random = new Random();
            int randomNumber = random.nextInt(100) + 1;

            // Check if attack is successful (e.g., hit chance)
            if (randomNumber <= myHitrate && myHitPoints > 0) {  
            	System.out.println("The attack was successful!");
                oppHitPoints -= ((myBattler.getAtkPwr() / 3) * attributeAdvantage(myBattler,theOpp) *critical());
                System.out.println("Opponent's HP: " + oppHitPoints);
            } else {
                System.out.println("The attack missed!");
            }
            
            System.out.println("The opponent swings!!!");
            // Opponent attacks (similarly can be improved)
            randomNumber = random.nextInt(100) + 1;
            if (randomNumber <= oppHitrate && oppHitPoints > 0) {
            	System.out.println("The opponent connects!");
                myHitPoints -= ((theOpp.getAtkPwr() / 3) * attributeAdvantage(theOpp,myBattler) *critical());
                System.out.println("Your HP: " + myHitPoints);
            } else {
                System.out.println("The opponent's attack missed!");
            }

            // Check if battle is over
            if (myHitPoints <= 0 && turnCount <4) {
                System.out.println("Your digimon has fainted. You lost!");
                break;
            } else if (oppHitPoints <= 0 && turnCount <4) {
                System.out.println("The opponent's digimon has fainted. You won!");
                break;
            } else if (turnCount == 4) {
            	if ((myHitPoints) >= (oppHitPoints) && myHitPoints > 0) {
                    System.out.println("You won!");
                    break;
            	} else {
                    System.out.println("You lose!");
                    break;
            	}
            }
        }
    }
    
    public double attributeAdvantage(digimon myGuy, digimon theOpp) {
    	if (myGuy.attribute == "Aquan" && theOpp.attribute == "Dragon" 
    			|| myGuy.attribute == "Aquan" && theOpp.attribute == "Machine" 
    			|| myGuy.attribute == "Dragon" && theOpp.attribute == "Beast" 
    			|| myGuy.attribute == "Dragon" && theOpp.attribute == "Insect" 
    			|| myGuy.attribute == "Insect" && theOpp.attribute == "Aquan" 
    			|| myGuy.attribute == "Insect" && theOpp.attribute == "Machine" 
    			|| myGuy.attribute == "Bird" && theOpp.attribute == "Beast" 
    			|| myGuy.attribute == "Bird" && theOpp.attribute == "Insect" 
    			|| myGuy.attribute == "Beast" && theOpp.attribute == "Machine" 
    			|| myGuy.attribute == "Beast" && theOpp.attribute == "Insect" 
    			|| myGuy.attribute == "Machine" && theOpp.attribute == "Bird" 
    			|| myGuy.attribute == "Machine" && theOpp.attribute == "Dragon"
    			|| myGuy.attribute == "Holy" && theOpp.attribute == "Dark"
    			|| myGuy.attribute == "Dark" && theOpp.attribute == "Holy") {
    		return 1.25;
    	} else if (myGuy.attribute == "Aquan" && theOpp.attribute == "Insect" 
    			|| myGuy.attribute == "Dragon" && theOpp.attribute == "Machine" 
    			|| myGuy.attribute == "Dragon" && theOpp.attribute == "Aquan" 
    			|| myGuy.attribute == "Insect" && theOpp.attribute == "Bird" 
    			|| myGuy.attribute == "Insect" && theOpp.attribute == "Beast" 
    			|| myGuy.attribute == "Insect" && theOpp.attribute == "Bird" 
    			|| myGuy.attribute == "Insect" && theOpp.attribute == "Dragon" 
    			|| myGuy.attribute == "Bird" && theOpp.attribute == "Machine" 
    			|| myGuy.attribute == "Beast" && theOpp.attribute == "Bird" 
    			|| myGuy.attribute == "Beast" && theOpp.attribute == "Dragon" 
    			|| myGuy.attribute == "Machine" && theOpp.attribute == "Aquan" 
    			|| myGuy.attribute == "Machine" && theOpp.attribute == "Beast" 
    			|| myGuy.attribute == "Machine" && theOpp.attribute == "Insect") {
    		return 0.75;
    	} else {
    		return 1;
    		
    	}
    		
    	
    }
    
    public double critical() {
    	Random random = new Random();
        int randomNumber = random.nextInt(20) + 1;
        if (randomNumber == 20) {
        	System.out.println("A critical hit!!!");
        	return 2;
        } else if (randomNumber == 1) {
        	System.out.println("Yikes, a critical miss!");
        	return .5;
        }else {
        	return 1;
        }
    }
}
		

