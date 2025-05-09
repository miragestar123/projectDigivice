package digiProject;
//Class for handling digimon specific variables.
public class digimon extends mainDigivice {
	int index;
	String species;
	String level;
	String attribute;
	double hunger;
	double victory;
	boolean needPoop;
	boolean isInjure;
	boolean isSick;
	int spirit;
	int reincCounter;
	int atkPwr;
	int HP;
	
	public digimon(int index, String species, String level, String attribute, double hunger, double victory, boolean needPoop,
	            boolean isInjure, boolean isSick, int reincCounter, int atkPwr, int HP, int spirit) {
			this.index = index;
	        this.species = species;
	        this.level = level;
	        this.attribute = attribute;
	        this.hunger = hunger;
	        this.victory = victory;
	        this.needPoop = needPoop;
	        this.isInjure = isInjure;
	        this.isSick = isSick;
	        this.reincCounter = reincCounter;
	        this.atkPwr = atkPwr;
	        this.HP = HP;
	        this.spirit = spirit;
	}
	  
	public int getSpirit() {
		return spirit;
	}

	public void setSpirit(int spirit) {
		this.spirit = spirit;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

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
	
	 @Override
	    public String toString() {
	        return "digimon{" + "index='" + index + '\'' +
	                ", species='" + species + '\'' +
	                ", level='" + level + '\'' +
	                ", attribute='" + attribute + '\'' +
	                ", hunger=" + hunger +
	                ", victory=" + victory +
	                ", needPoop=" + needPoop +
	                ", isInjure=" + isInjure +
	                ", isSick=" + isSick +
	                ", reincCounter=" + reincCounter +
	                ", atkPwr=" + atkPwr +
	                ", HP=" + HP +
	                '}';
	/*
	public static void main(String[] args) {
		
	}
	*/
	}
}

