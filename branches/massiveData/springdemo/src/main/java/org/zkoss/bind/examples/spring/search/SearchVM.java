/* SearchVM.java

	Purpose:
		
	Description:
		
	History:
		2011/10/25 Created by Dennis Chen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.bind.examples.spring.search;

import java.text.DecimalFormat;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.Converter;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.examples.spring.search.domain.Item;
import org.zkoss.bind.examples.spring.search.domain.ItemService;
import org.zkoss.bind.examples.spring.search.model.MyItemListModel;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
/**
 * a Search View Model
 * @author dennis
 *
 */
public class SearchVM {

	//the search condition
	String filter = "*";
	//the search result
	ListModelList<Item> items;
	
	MyItemListModel itemList;
	//the selected item
	Item selected;
	
	@WireVariable
	private ItemService itemService;
	
	Converter totalPriceConverter = null;
	private String selections;
	
	public SearchVM(){
		itemList = new MyItemListModel();
		itemList.setMultiple(true);
	}
	protected ItemService getSearchService(){
		return itemService;
	}
		
	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public MyItemListModel getItems() {

		return itemList;
	}

	@NotifyChange({"items","selected"})
	@Command
	public void doSearch(){
//		items = new ListModelList<Item>();
//		items.addAll(getSearchService().search(filter));
		if (filter.equals("*") || filter.equals("")){
			itemList.setFilter(null);
		}else{
			itemList.setFilter(filter);
		}
		selected = null;
		
		
	}
	
	@NotifyChange("selected")
	@Command
	public void select(){
		Item[] selection = itemList.getSelection().toArray(new Item[0]);
		if (selection.length >=1){
			selected = selection[0];
		}
		
	}	

	@NotifyChange("selections")
	@Command
	public void print(){
		Item[] selection = itemList.getSelection().toArray(new Item[0]);
		selections = "";
		for (Item s : selection){
			selections += s.getName()+" ";
		}
		
	}	
	
	public Item getSelected() {
		return selected;
	}

	public void setSelected(Item selected) {
		this.selected = selected;
	}
	
	

	
	public Converter getTotalPriceConverter(){
		if(totalPriceConverter!=null){
			return totalPriceConverter;
		}
		return totalPriceConverter = new Converter(){
			public Object coerceToBean(Object val, Component component,
					BindContext ctx) {
				return null;//never called in this example
			}

			public Object coerceToUi(Object val, Component component,
					BindContext ctx) {
				if(val==null) return null;
				String str = new DecimalFormat("$ ###,###,###,##0.00").format((Double)val);
				return str;
			}
			
		};
	}
	public String getSelections() {
		return selections;
	}
	
}
