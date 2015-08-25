package org.zkoss.mvvm.examples.globalcommand;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ItemList {

	private static String[] data ={"Backpack", "Jacket","Bicycle", "Mobile Phone", "Shoes"};
	
	private static List<String> items = new LinkedList<String>();
	
	static{
		items.addAll(Arrays.asList(data));
	}
	
	public static List<String> getList(){
		return items;
	}
	
	public static void add(String i){
		items.add(i);
	}
}
