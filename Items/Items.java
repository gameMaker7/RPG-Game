
package Items;
public abstract class Items {

	private int value = 0;
	private int wieght = 0;
	String type = "";
	private int rank = Gen.gen.nextInt(10) + 1;
	private String name = "";
	private boolean useable = true;
	
	public Items(String s, String type2){
		type = type2;
		rename(s);
		stats();
		System.out.println("Lv." + rank + " (" + type + ") " + getName());

	}
	/**
	 * determines value and wieght
	 */
	private void stats() {
		if(type.equals("Potion")){
			value += 100 * getRank();
			wieght = 1;
		}
		if(type.equals("Scroll")){
			value += 300 * getRank();
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
	
	public boolean isUseable() {
		return useable;
	}
	public void setUseable(boolean useable) {
		this.useable = useable;
	}
	public int getValue() {
		return value;
	}
	public int getWieght() {
		return wieght;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	private void rename(String s){
		name = s;
	}
	public int getRank() {
		return rank;
	}
	
}
