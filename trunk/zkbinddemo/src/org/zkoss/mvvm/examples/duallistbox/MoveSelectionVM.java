package org.zkoss.mvvm.examples.duallistbox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

public class MoveSelectionVM {

	Set<String> selection1;
	List<String> list1;
	Set<String> selection2;
	List<String> list2;
	
	public MoveSelectionVM(){
		list1 = new ArrayList<String>();
		list2 = new ArrayList<String>();
		selection1 = new HashSet<String>();
		selection2 = new HashSet<String>();
		for (int i=0;i<10;i++){
			list1.add("Item "+i);
		}
	}

	public Set<String> getSelection1() {
		return selection1;
	}

	public void setSelection1(Set<String> selection1) {
		this.selection1 = selection1;
	}

	public List<String> getList1() {
		return list1;
	}

	public Set<String> getSelection2() {
		return selection2;
	}

	public void setSelection2(Set<String> selection2) {
		this.selection2 = selection2;
	}

	public List<String> getList2() {
		return list2;
	}
	
	@Command
	@NotifyChange({"list1","list2","selection1","selection2"})
	public void moveToList1(){
		if(selection2!=null && selection2.size()>0){
			list1.addAll(selection2);
			list2.removeAll(selection2);
			selection1.addAll(selection2);
			selection2.clear();
		}
	}
	
	@Command
	@NotifyChange({"list1","list2","selection1","selection2"})
	public void moveToList2(){
		if(selection1!=null && selection1.size()>0){
			list2.addAll(selection1);
			list1.removeAll(selection1);
			selection2.addAll(selection1);
			selection1.clear();
		}
	}
	
	
}
