package Items;


import Group.Hero;
import Setup.Game;

public class Shop {
	Store shop = new Store();

	public void createItem(){
		System.out.println("Item name");
		String s = Game.input.nextLine();
		System.out.println("Item type");
		for(Types obj: Types.values()){
			System.out.println(obj);
		}
		String a = Game.input.nextLine();
		switch(a){
		case "potion":
			shop.add(new Potion(s));
			break;

		case "book":
			shop.add(new Book(s));
			break;

		case "relic":
			shop.add(new Relic(s));			
			break;

		case "dagger":
			shop.add(new Dagger(s));
			break;

		case "staff":
			shop.add(new Staff(s));
			break;
		case "sword":
			shop.add(new Sword(s));
			break;
		default:
			System.out.println("This shop only has items of the following types");
			for(Types obj: Types.values()){
				System.out.println(obj);
			}
			break;
		}
	}
	public void buyItem(Hero hero){
		String a = "";
		try{
		System.out.println("Choose item to buy.(Enter Item Name)");
		System.out.println("Exit");
		for(Items x: shop.list){
			System.out.println(x.getName() + " Cost: " + x.getValue());
		}
		 a = Game.input.nextLine();
		 if(a.equalsIgnoreCase("Exit")){
			 return;
		 }
		Items b = shop.inventory(a);
		shop.buy(hero, b);
		}
		catch(Exception e){
			System.out.println("Apoligies we do not sell " + a);
		}
	}
	public void enter(Hero hero) {
		while(true){
		System.out.println("\nChoose Action.");
		for(AIS a: AIS.values()){
			System.out.println(a);
		}
		String a = Game.input.nextLine();
		switch(a){
		case "create":
			createItem();
			break;
		case "buy":
			buyItem(hero);
			break;
		case "exit":
			return;
		}
	}
}
}