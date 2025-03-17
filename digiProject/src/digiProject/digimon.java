package digiProject;
//Class for handling digimon specific variables.
public class digimon extends mainDigivice {
	String species = "Dorumon";
	String level = "Rookie";
	String attribute = "Beast";
	double hunger = 100;
	double victory = 0;
	boolean needPoop = false;
	boolean isInjure = false;
	boolean isSick = false;
	int reincCounter = 0;
	int atkPwr = 150;
	int HP = 200;
	
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public double getHunger() {
		return hunger;
	}
	public void setHunger(double hunger) {
		this.hunger = hunger;
	}
	public double getVictory() {
		return victory;
	}
	public void setVictory(double victory) {
		this.victory = victory;
	}
	public boolean isNeedPoop() {
		return needPoop;
	}
	public void setNeedPoop(boolean needPoop) {
		this.needPoop = needPoop;
	}
	public boolean isInjure() {
		return isInjure;
	}
	public void setInjure(boolean isInjure) {
		this.isInjure = isInjure;
	}
	public boolean isSick() {
		return isSick;
	}
	public void setSick(boolean isSick) {
		this.isSick = isSick;
	}
	public int getReincCounter() {
		return reincCounter;
	}
	public void setReincCounter(int reincCounter) {
		this.reincCounter = reincCounter;
	}
	public int getAtkPwr() {
		return atkPwr;
	}
	public void setAtkPwr(int atkPwr) {
		this.atkPwr = atkPwr;
	}
	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		HP = hP;
	}
	/*
	public static void main(String[] args) {
		
	}
	*/
	}

