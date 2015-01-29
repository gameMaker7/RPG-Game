package Items;


public class Potion extends Items {


	static String type = "Potion";
	int rank = Gen.gen.nextInt(10) + 1;
	public Potion(String s) {
		super(s, type);
	}

}
