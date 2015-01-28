
package Items;
public abstract class Items {

	int value = 0;
	int wieght = 0;
	String type = "";
	private int rank = 0;
	String name = "";
	
	public Items(String s){
		rename(s);
		stats();
	}
	/**
	 * determines value and wieght
	 */
	public void stats() {
		if(type.equals("Potion")){
			value += 100 * getRank();
			wieght = 1;
		}
		if(type.equals("Book")){
			value += 50 * getRank();
			wieght += getRank()/2 + 1;
		}
		if(type.equals("Relic")){
			value += 200 * getRank();
			wieght += getRank() + 3;
		}
		if(type.equals("Dagger")){
			value += 300 * getRank();
			wieght = 1;
		}
		if(type.equals("Staff")){
			value += 100 * getRank();
			wieght += getRank();
		}
		if(type.equals("Sword")){
			value += 150 * getRank();
			wieght += getRank() + 3;
		}
	}
	
	public String getType() {
		return type;
	}
	public void rename(String s){
		name = s;
	}
	public int getRank() {
		return rank;
	}
	
}
