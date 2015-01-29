package Group;


import java.util.ArrayList;
import java.util.Random;

public class HeroList {

	public static Random gen = new Random();
	protected ArrayList<Hero> list  = new ArrayList<Hero>();
	
	public void add(Hero obj){
		list.add(obj);
	}
	public Hero draw(int i){
		return list.remove(i-1);
	}
	public Hero scry(int i){
		return list.get(i-1);
	}
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		for(Object c: list){
			result.append(c + "\n");
		}
		return result.toString();
	}
	public void shuffle(){
		for(int i = 0; i<list.size(); i++){

			int grab = gen.nextInt(list.size());
			int place = gen.nextInt(list.size());
			Hero temp = list.get(grab);

			list.set(grab, list.get(place));
			list.set(place, temp);
		}
	}
	public Object randomDraw(){
		return draw(gen.nextInt(list.size()));
	}
	public int length(){
		return list.size();
	}
}
