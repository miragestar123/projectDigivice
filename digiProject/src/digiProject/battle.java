package digiProject;

public class battle extends mainDigivice {
	public digimon myBattler = null;
	public digimon theOpp = null;
	public static void main(String[] args) {
		digimon myBattler = null;
		digimon theOpp = null;
		int myHitPoints = myBattler.HP;
		 int oppHitPoints = theOpp.HP;
		 int newOppHP = 100;
		
		
		System.out.println("Ready??? /nFight!!!");
		System.out.println ("Your digimon swings!!!");
		//newOppHP = myAttack();
	}
		public int myAttack() {
			int tempOppHP=theOpp.HP;
	tempOppHP -= myBattler.atkPwr;
	return tempOppHP;
	}
}
