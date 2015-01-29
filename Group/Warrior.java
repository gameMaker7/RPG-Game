package Group;

import Items.Items;
import Setup.Game;


public class Warrior extends Hero {
	boolean mainHand = true;
	boolean offHand = true;
	boolean extra = true;

	public Warrior(String s, String a) {
		super(s, a);
		setSpace();
	}
	private void setSpace() {
		// Warriors start with minimum of ten slots
		slots -= 5;
	}
	public int effectiveRank(){
		int x = 0;
		for(int i = 0; i<bag.length(); i ++){
			Items a = (Items) bag.scry(i);
			if(a.isUseable()){
				x += a.getRank();
			}
		}
		return x + this.getRank();
	}
	@Override
	public boolean equip(Items item) {
		System.out.println("Equip Item(Equip) or Store Item(Store)");
		String x = Game.input.nextLine();
		if(x.equalsIgnoreCase("Store")){
			if(slots>= item.getWieght()){
				bag.add(item);
				item.setUseable(false);
				slots-=item.getWieght();
			}else{
				System.out.println("Bag full.");
				return false;
			}
		}
		if(x.equalsIgnoreCase("Equip")){
			if(item.getType().equalsIgnoreCase("Sword")){

				if(mainHand){
					bag.add(item);
					mainHand = false;
				}
				else if(offHand){
					bag.add(item);
					offHand = false;
				}
				else{
					System.out.println("Cannot equip item. Main Hand already used.");
					return false;
				}
			}
			if(item.getType().equalsIgnoreCase("Dagger") || item.getType().equalsIgnoreCase("Relic")){
				if(offHand){
					bag.add(item);
					offHand = false;
				}else if(extra){
					bag.add(item);
					extra = false;
				}else{
					System.out.println("Cannot equip item. Off Hand and extra already used.");
					return false;
				}
			}
			else{
				System.out.println("Warriors cannot equip this item.");
				return false;
			}
			System.out.println("Effective Lv: " + effectiveRank());	
		}
		return true;
	}
}