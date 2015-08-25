/* SearchVM.java

	Purpose:
		
	Description:
		
	History:
		2011/10/25 Created by Dennis Chen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.bind.examples;

import java.util.Calendar;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.examples.search.FakeSearchService;
import org.zkoss.bind.examples.search.Item;
/**
 * A experimental case to test "notification on 2nd level property", e.g. item.description.
 * Current specification doesn't support it.
 * @author Hawk
 *
 */
public class Notify2LevelPropertyVM {

	//the selected item
	Item item = new FakeSearchService().search("").get(0);
	
	
	
	@Command @NotifyChange("item")
	public void notify1stLevel(){
		item.setDescription(Calendar.getInstance().getTime().toString());
	}
	
	@Command  @NotifyChange("item.description")
	public void notify2ndLevel(){
		item.setDescription(Calendar.getInstance().getTime().toString());
	}

	@Command 
	public void notifyByApi(){
		BindUtils.postNotifyChange(null, null, item, "item.description");
	}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}
