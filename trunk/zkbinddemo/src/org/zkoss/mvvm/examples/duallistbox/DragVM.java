package org.zkoss.mvvm.examples.duallistbox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

public class DragVM {

	List<Item> list1;
	List<Item> list2;
	
	public DragVM(){
		list1 = new ArrayList<Item>();
		list2 = new ArrayList<Item>();
		for (int i=0;i<10;i++){
			list1.add(new Item("Item "+i));
		}
	}


	public List<Item> getList1() {
		return list1;
	}
	public List<Item> getList2() {
		return list2;
	}
	
	@Command
	@NotifyChange({"list1","list2"})
	public void dropToList1(@BindingParam("item") Item item){
		if(item!=null){
			list1.add(item);
			list2.remove(item);
		}
	}
	
	@Command
	@NotifyChange({"list1","list2"})
	public void dropToList2(@BindingParam("item") Item item){
		if(item!=null){
			list2.add(item);
			list1.remove(item);
		}
	}
	
	@Command
	@NotifyChange({"list1","list2"})
	public void insertToList1(@BindingParam("base") Item base,@BindingParam("item") Item item){
		if(item!=null && base!=null && list1.contains(base) && list2.contains(item)){
			list1.add(list1.indexOf(base),item);
			list2.remove(item);
		}
	}
	
	@Command
	@NotifyChange({"list1","list2"})
	public void insertToList2(@BindingParam("base") Item base,@BindingParam("item") Item item){
		if(item!=null && base!=null && list2.contains(base) && list1.contains(item)){
			list2.add(list2.indexOf(base),item);
			list1.remove(item);
		}
	}
	
	static public class Item{
		String name;
		public Item(String name){
			this.name = name;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
	
	
}
