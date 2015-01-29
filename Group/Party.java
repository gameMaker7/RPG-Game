package Group;
import java.util.Scanner;

import Items.Items;
import Setup.Game;


public class Party {

	private Scanner input = new Scanner(System.in);
	public HeroList heroes = new HeroList();
	public void createHero(){
		System.out.println("Name of Hero");
		String s = input.nextLine();
		System.out.println("Hero type");
		for(Hclasses a: Hclasses.values()){
			System.out.println(a);
		}
		String a = input.nextLine();
		switch(a){
		case "mage":
			heroes.add(new Mage(s, a));
			break;
		case "assassin":
			heroes.add(new Assassin(s, a));
			break;
		case "warrior":
			heroes.add(new Warrior(s, a));
			break;
		default:
			System.out.println("Class invalid.");
			break;
		}
	}
	public void inventory(Hero hero){
		System.out.println("Lv." + hero.getRank() + " " + hero.getType() + " " + hero.getName());
		System.out.println("Gold: " + hero.getGold());
		System.out.println("Bag Space: " + hero.slots);
		System.out.println("Effective Level: " + hero.effectiveRank());
		System.out.println("\nChoose Action");
		for(AIC a: AIC.values()){
			System.out.println(a);
		}
		String x = Game.input.nextLine();
		switch(x){
		case "items":
			for(Items a: hero.bag.list){
				System.out.println("Lv: " + a.getRank() + " " + a.getName() + " Equipped: " + a.isUseable());
			}
			break;
		case "equip": 
			for(Items a: hero.bag.list){
				if(a.isUseable()){
					System.out.println("Lv: " + a.getRank() + " " + a.getName() + " Equipped: " + a.isUseable());
					System.out.println("Unequip: yes or no.");
					String item = Game.input.nextLine();
					if(item.equalsIgnoreCase("yes")){
						a.setUseable(false);
					}
				}
			}
			for(Items a: hero.bag.list){
				if(!a.isUseable()){
					System.out.println("Lv: " + a.getRank() + " " + a.getName() + " Equipped: " + a.isUseable());
					System.out.println("Equip: yes or no.");
					String item = Game.input.nextLine();
					if(item.equalsIgnoreCase("yes")){
						hero.equip(a);
					}
				}
			}
		}
	}
	public void equipItem(Items item){
		System.out.println("Choose Hero.");
		for(int i = 0; i<heroes.length(); i ++){
			Hero s = (Hero) heroes.scry(i);
			System.out.println(s.getType() + " " + s.getName() );
		}
		String x = input.nextLine();
		for(int i = 0; i<heroes.length(); i ++){
			Hero s = (Hero) heroes.scry(i);
			if(s.call(x)){
				s.equip(item);
			}
		}
	}
	public void heroLevel(){
		for(int i = 0; i< heroes.length(); i ++){
			Hero s = (Hero) heroes.scry(i);
			System.out.print(s.getName() + " Level: ");
			System.out.println(s.effectiveRank());
		}
	}
	public Hero showHeros(){
		System.out.println("Choose Hero (Enter name)");
		for(Hero x: heroes.list){
			System.out.println("Lv." + x.getRank() + " " + x.getType() + " " + x.getName() + " Gold: " + x.getGold());
		}
		String x = input.nextLine();
		for(Hero a: heroes.list){
			if(a.getName().endsWith(x)){
				return a;
			}
		}
		return null;
	}
}
