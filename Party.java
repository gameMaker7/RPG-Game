import java.util.Scanner;

import Items.CardList;
import Items.Dagger;
import Items.Items;
import Items.Types;


public class Party {

	Scanner input = new Scanner(System.in);
	CardList heroes = new CardList();
	CardList shop = new CardList();
	public static void main(String[] args) {
		Party game = new Party();
		game.createHero();
		game.heroLevel();
	}
	public void createHero(){
		System.out.println("Name of Hero");
		String s = input.nextLine();
		System.out.println("Hero type");
		String a = input.nextLine();
		switch(a){
		case "Mage":
			heroes.add(new Mage(s, a));
			break;
		}
	}
	public void equipItem(Items item){
		System.out.println("Choose Hero.");
		for(int i = 0; i<heroes.length(); i ++){
			Hero s = (Hero) heroes.scry(i);
			System.out.println(s.type + " " + s.name );
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
			System.out.print(s.name + " Level: ");
			System.out.println(s.effectiveRank());
		}
	}
	public void createItem(){
		System.out.println("Item name");
		String s = input.nextLine();
		System.out.println("Item type");
		String a = input.nextLine();
		switch(a){
		case "Potion":
			break;

		case "Book":
			break;

		case "Relic":
			break;

		case "Dagger":
			shop.add(new Dagger(s));
			break;

		case "Staff":
			break;

		case "Sword":
			break;
		default:
			System.out.println("This shop only has items of the following types");
			for(Types obj: Types.values()){
				System.out.println(obj);
			}
			break;
		}
	}
}
