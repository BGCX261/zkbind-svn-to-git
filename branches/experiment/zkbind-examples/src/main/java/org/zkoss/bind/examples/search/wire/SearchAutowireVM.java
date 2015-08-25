/* SearchVM.java

	Purpose:
		
	Description:
		
	History:
		2011/10/25 Created by Dennis Chen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.bind.examples.search.wire;

import java.text.DecimalFormat;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.Converter;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.examples.search.FakeSearchService;
import org.zkoss.bind.examples.search.Item;
import org.zkoss.bind.examples.search.SearchService;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Popup;
/**
 * An implementation in MVVM pattern with autowire
 * @author Hawk
 */
public class SearchAutowireVM{

	//the search condition
	private String filter = "*";
	
	//the search result
	private ListModelList<Item> items;
	
	private Converter totalPriceConverter;
	//the selected item
	private Item selected;
	//UI component
	@Wire("#msgPopup")
	Popup popup;
	@Wire("#msg")
	Label msg;

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
		Selectors.wireComponents(view, this, false);
		//wire event listener
//		Selectors.wireEventListeners(view, this);
	}
	
	protected SearchService getSearchService(){
		return new FakeSearchService();
	}
	
	public String getFilter() {
		return filter;
	}
	
	public void setFilter(String filter) {
		this.filter = filter;
	}
		
	public ListModel<Item> getItems() {
		if(items==null){
			doSearch();
		}
		return items;
	}

	
	@NotifyChange({"items","selected"})
	@Command
	public void doSearch(){
		items = new ListModelList<Item>();
		items.addAll(getSearchService().search(filter));
		setSelected(null);
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
	
	@Command
	public void popupMessage(@BindingParam("target")Component target, @BindingParam("content")String content){
		msg.setValue(content);
		popup.open(target,"end_before");
	}
}
