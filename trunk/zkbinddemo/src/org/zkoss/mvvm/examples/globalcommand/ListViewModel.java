package org.zkoss.mvvm.examples.globalcommand;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;

public class ListViewModel {

	private boolean visible = true;

	private List<String> items;
	private Date lastUpdate;
	
	public boolean isVisible() {
		return visible;
	}
	

	@GlobalCommand @NotifyChange({"items","lastUpdate"})
	public void refresh(){
		items = ItemList.getList();
		lastUpdate = Calendar.getInstance().getTime();
	}

	

	@GlobalCommand @NotifyChange("visible")
	public void show(){
		visible = true;
	}
	@GlobalCommand @NotifyChange("visible")
	public void hide(){
		visible =false;
	}


	public List<String> getItems() {
		items = ItemList.getList();
		return items;
	}


	public Date getLastUpdate() {
		return lastUpdate;
	}
}
