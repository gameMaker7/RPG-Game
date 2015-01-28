import Items.Gen;
import Items.Items;


public abstract class Hero {


	int gold = 0;
	int slots = 0;
	String type = "";
	int rank = 0;
	String name = "";
	
	public Hero(String s, String a){
		type = a;
		stats();
		rename(s);
	}
	/**
	 * determines gold and bag size
	 */
	protected void stats() {
		rank = Gen.gen.nextInt(10) + 1;
		if(type.equals("Warrior")){
			gold += 100 * rank;
			slots += rank + 10;
		}
		if(type.equals("Mage")){
			gold += 200 * rank;
			slots += rank + 5;
		}if(type.equals("Assassin")){
			gold += 1000 * rank;
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
	protected void rename(String s){
		name = s;
	}
	/**
	 * 
	 * @return
	 */
	public abstract int effectiveRank();
	
	public abstract void equip(Items item);
		
	
		
}
