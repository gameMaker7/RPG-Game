package Items;


public class Dagger extends Items{


	static String type = "Dagger";
	int rank = Gen.gen.nextInt(10) + 1;
	public Dagger(String s) {
		super(s, type);

	}

}
