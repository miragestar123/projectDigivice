package digiProject;
import java.util.Random;

public class battle extends mainDigivice {
	public static void main(String[] args) {
		digimon testDigimon = new digimon(7,"Tyranomon","Champion","Dragon",100,0,false,false,false,0,250,250,2);
		digimon testDigimon2 = new digimon(8,"Greymon","Champion","Dragon",100,0,false,false,false,0,260,240,2);
		battle battle = new battle();
		BattleInstance newBattle = battle.new BattleInstance(testDigimon);

		//myBattler = initializeDigimon;
		battle.startBattle(testDigimon, testDigimon2);
	}
	
	private class BattleInstance{
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
	}

    public void startBattle(digimon myBattler, digimon theOpp) {
        int myHitPoints = myBattler.HP;
        int oppHitPoints = theOpp.HP;
        int turnCount = 0;
        double myHitrate = ((myBattler.atkPwr * 100)/(myBattler.atkPwr + theOpp.atkPwr)); //+ attributeAdvantage
        double oppHitrate = ((theOpp.atkPwr * 100)/(theOpp.atkPwr + myBattler.atkPwr));
        System.out.println("Ready???" + "/n" + "Fight!!!");

        while (myHitPoints > 0 && oppHitPoints > 0) {
            turnCount++;
            System.out.println("Turn " + turnCount + ":");

            // Your digimon attacks
            System.out.println("Your digimon swings!!!");
            Random random = new Random();
            int randomNumber = random.nextInt(100) + 1;

            // Check if attack is successful (e.g., hit chance)
            if (randomNumber <= myHitrate) {  // Assuming 75% hit chance for example
                oppHitPoints -= myBattler.getAtkPwr();
                System.out.println("The attack was successful! Opponent's HP: " + oppHitPoints);
            } else {
                System.out.println("The attack missed!");
            }

            // Opponent attacks (similarly can be improved)
            randomNumber = random.nextInt(100) + 1;
            if (randomNumber <= oppHitrate) {
                myHitPoints -= theOpp.getAtkPwr();
                System.out.println("The opponent attacks! Your HP: " + myHitPoints);
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
            	if (myHitPoints >= oppHitPoints) {
                    System.out.println("You won!");
                    break;
            	} else {
                    System.out.println("You lose!");
                    break;
            	}
            }
        }
    }
}
		

