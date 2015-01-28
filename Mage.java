import Items.CardList;
import Items.Items;


public class Mage extends Hero {
	private CardList bag = new CardList();
	boolean mainHand = true;
	boolean offHand = true;
	boolean extra = true;
	
	public Mage(String s, String a) {
		super(s, a);
		setSpace();
	}
	private void setSpace() {
		// mages start with minimum of five slots
		slots -= 3;
	}
	public int effectiveRank(){
		int x = 0;
		for(int i = 0; i<bag.length(); i ++){
			Items a = (Items) bag.scry(i);
			x += a.getRank();
		}
		return x + this.rank;
	}
	@Override
	public void equip(Items item) {
		if(item.getType().equalsIgnoreCase("Potion")){
			if(slots > 0){
				bag.add(item);
				slots--;
			}else{
				System.out.println("Bag is full.");
			}
		}
		if(item.getType().equalsIgnoreCase("Staff")){
			if(mainHand){
				bag.add(item);
				mainHand = false;
			}
			else{
				System.out.println("Cannot equip item. Main Hand already used.");
			}
		}
		if(item.getType().equalsIgnoreCase("Book") || item.getType().equalsIgnoreCase("Relic")){
			if(offHand){
				bag.add(item);
				offHand = false;
			}else if(extra){
				bag.add(item);
				extra = false;
			}else{
				System.out.println("Cannot equip item. Off Hand and extra already used.");
			}
		}
		else{
			System.out.println("Mages cannot use this item.");
		}

	}

}
