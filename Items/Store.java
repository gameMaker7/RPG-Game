package Items;


import java.util.ArrayList;
import java.util.Random;

import Group.Hero;

public class Store {

	public static Random gen = new Random();
	protected ArrayList<Items> list  = new ArrayList<Items>();
	
	public void add(Items obj){
		list.add(obj);
	}
	public void buy(Hero hero, Items item){
		if(item.getValue()>hero.getGold()){
			System.out.println("Not Enough Gold");
			return;
		}else{
			hero.setGold(0, item.getValue());
			if(hero.equip(item)){
			list.remove(item);
			}
		}

	}
	
	public Items scry(int i){
		return list.get(i);
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		for(Items c: list){
			result.append(c + "\n");
		}
		return result.toString();
	}
	public void shuffle(){
		for(int i = 0; i<list.size(); i++){

			int grab = gen.nextInt(list.size());
			int place = gen.nextInt(list.size());
			Items temp = list.get(grab);

			list.set(grab, list.get(place));
			list.set(place, temp);
		}
	}
	public int length(){
		return list.size();
	}
	public Items inventory(String s){
		int i = 0;
		for(Items x: list){
			if(x.getName().equals((s))){
				return x;
			}
			else{
				i++;
			}
		}
		return null;
	}
}
