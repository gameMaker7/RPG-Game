package Setup;
import java.util.Scanner;

import Group.Party;
import Items.Shop;


public class Game {
	public static Scanner input  = new Scanner(System.in);
	Party group = new Party();
	Shop shop = new Shop();
	static String action = "";

	public static void main(String[] args) {
		Game x = new Game();
		x.play();

	}

	private void play() {
		System.out.println("Wlecome to Akatar.");
		group.createHero();
		while(true){
			System.out.println("\nChoose an action.");
			for(AIT a: AIT.values()){
				System.out.println(a);
			}
			action = input.nextLine();
			switch(action){
			case "recruit":
				group.createHero();
				break;
			case "shop":
				System.out.println("Choose a Hero.");
				shop.enter(group.showHeros());
				break;
			case "quit":
				System.exit(0);
				break;
			case "inventory":
				group.inventory(group.showHeros());
				break;
			default:
				System.out.println("Invalid Command.");
				break;
			}
		}
	}
}
