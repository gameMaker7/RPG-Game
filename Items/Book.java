package Items;


public class Book extends Items{


	static String type = "Book";
	int rank = Gen.gen.nextInt(10) + 1;
	public Book(String s) {
		super(s, type);

	}

}
