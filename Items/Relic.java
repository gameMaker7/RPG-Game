package Items;


public class Relic extends Items{


	static String type = "Relic";
	int rank = Gen.gen.nextInt(10) + 1;
	public Relic(String s) {
		super(s, type);

	}

}
