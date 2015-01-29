package Group;
import Items.Gen;
import Items.Items;


public abstract class Hero {

	protected Bag bag = new Bag();
	private int gold = 0;
	protected int slots = 0;
	private String type = "";
	private int rank = 0;
	private String name = "";

	public Hero(String s, String a){
		type = a;
		stats();
		rename(s);
		System.out.println("Lv." + rank + " " + type + " " + name + " Gold: " + gold);
	}
	/**
	 * determines gold and bag size
	 */
	protected void stats() {
		rank = Gen.gen.nextInt(10) + 1;
		if(type.equals("warrior")){
			gold += 100 * rank;
			slots += rank + 10;
		}
		if(type.equals("mage")){
			gold += 200 * rank;
			slots += rank + 5;
		}
		if(type.equals("assassin")){
			gold += 500 * rank;
			slots += rank;
		}
	}
	/**
	 * checks if name of hero is same as input
	 */
	public boolean call(String input){
		if(input.endsWith(name)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public Bag getBag() {
		return bag;
	}
	protected void rename(String s){
		name = s;
	}
	
	public int getSlots() {
		return slots;
	}
	public String getType() {
		return type;
	}
	public int getRank() {
		return rank;
	}
	public String getName() {
		return name;
	}
	public void setRank(int rank2) {
		rank += rank2;
	}	
	public int getGold() {
		return gold;
	}
	public void setGold(int gold, int cost) {
		this.gold += gold;
		this.gold -= cost;
	}

	public abstract int effectiveRank();

	public abstract boolean equip(Items item);
	
}

