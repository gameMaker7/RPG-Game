package Group;

import Items.Items;
import Setup.Game;


public class Assassin extends Hero {
	boolean mainHand = true;
	boolean offHand = true;
	boolean extra = true;

	public Assassin(String s, String a) {
		super(s, a);
		setSpace();
	}
	private void setSpace() {
		// Assassin start with minimum of ten slots
		slots -= 2;
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
			if(item.getType().equals("Dagger")){
				if(mainHand){
					bag.add(item);
					mainHand = false;
				}		
				else{
					System.out.println("Cannot equip item. Main Hand already used.");
					return false;
				}
			}
			if(item.getType().equals("Relic")){
				if(extra){
					bag.add(item);
					extra = false;
				}else{
					System.out.println("Cannot equip item. Off Hand and extra already used.");
					return false;
				}
			}
		System.out.println("Effective Lv: " + effectiveRank());	
		}
		else{
			System.out.println("Assassins cannot equip this item.");
			return false;
		}

		return true;
	}
}