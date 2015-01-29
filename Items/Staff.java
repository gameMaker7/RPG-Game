package Items;


public class Staff extends Items{


	static String type = "Staff";
	int rank = Gen.gen.nextInt(10) + 1;
	public Staff(String s) {
		super(s, type);

	}

}
