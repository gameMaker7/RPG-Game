package Items;

import Group.Hero;


public class Scroll extends Items {


	static String type = "Scroll";
	int rank = Gen.gen.nextInt(10) + 1;
	public Scroll(String s, Hero hero) {
		super(s, type);
		use(hero);
	}
	private void use(Hero hero){
		hero.setRank(this.rank);
	}

}
