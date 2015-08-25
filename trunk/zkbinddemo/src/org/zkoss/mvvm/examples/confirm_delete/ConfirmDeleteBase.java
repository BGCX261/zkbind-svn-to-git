package org.zkoss.mvvm.examples.confirm_delete;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

public class ConfirmDeleteBase {

	List<String> items = new ArrayList<String>();
	
	String selected;
	
	String message;
	
	public ConfirmDeleteBase(){
		items.add("A");
		items.add("B");
		items.add("C");
	}
	
	public List<String> getItems(){
		return items;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}
	
	public String getMessage() {
		return message;
	}
	
	@Command @NotifyChange({"message","items","selected"})
	public void delete(){
		if(selected==null){
			message = "You have to select an item";
		}else{
			try{
				if(daoDelete(selected)){
					items.remove(selected);
					message = selected + " was deleted";
					selected = null;
				}else{
					message = selected + " wasn't deleted";
				}
			}catch(Exception x){
				message = x.getMessage();
			}
		}
	}
	
	protected boolean daoDelete(String data){
		if("B".equals(selected)){
			throw new RuntimeException("Oops, I simulate delete "+data+" fial here");
		}
		return true;
	}
}
