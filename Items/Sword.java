package Items;


public class Sword extends Items{


	static String type = "Sword";
	int rank = Gen.gen.nextInt(10) + 1;
	public Sword(String s) {
		super(s, type);

	}

}
