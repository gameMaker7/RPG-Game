package Group;
import Items.Items;
import Setup.Game;


public class Mage extends Hero {
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
			if(item.getType().equalsIgnoreCase("Staff")){
				if(mainHand){
					bag.add(item);
					mainHand = false;
				}
				else{
					System.out.println("Cannot equip item. Main Hand already used.");
					return false;
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
					return false;
				}
			}
			else{
				System.out.println("Mages cannot equip this item.");
				return false;
			}
			System.out.println("Effective Lv: " + effectiveRank());	
		}
		return true;
	}
}
