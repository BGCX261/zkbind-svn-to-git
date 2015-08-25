/* SearchVM.java

	Purpose:
		
	Description:
		
	History:
		2011/10/25 Created by Dennis Chen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.bind.examples.search.mvp;

import org.zkoss.bind.examples.search.FakeSearchService;
import org.zkoss.bind.examples.search.Item;
import org.zkoss.bind.examples.search.SearchService;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
/**
 * An implementation in MVP (Model - View - Presenter)
 * manipulate UI components' presentation by accessing them directly.
 * Comparing to MVVM:
 * Pros:
 * no need getter & setter.
 * 
 * Cons:
 * declare variable for each UI component to manipulate.
 * view formating logic (ex: converter) is hard to reuse.
 * Not do unit test
 * 
 * @author Hawk
 */

@SuppressWarnings("serial")
public class SearchPresenter extends SelectorComposer<Component>{
	//the search result
	private ListModelList<Item> items;

	//the selected item
	private Item selected;
	//UI component
	@Wire("#filterBox")
	private Textbox filterBox;
	@Wire("button")
	private Button searchButton;
	@Wire("listbox")
	private Listbox itemListbox;
	@Wire("groupbox")
	private Groupbox detailBox;
	@Wire("caption")
	private Caption detailCaption;
	@Wire("#descriptionLabel")
	private Label descriptionLabel;
	@Wire("#priceLabel")
	private Label priceLabel;
	@Wire("#quantityLabel")
	private Label quantityLabel;
	@Wire("#totalPriceLabel")
	private Label totalPriceLabel;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		doSearch();
		itemListbox.setModel(items);
		itemListbox.setItemRenderer(new ItemRenderer());
	}
	
	protected SearchService getSearchService(){
		return new FakeSearchService();
	}
	
	@Listen("onClick = button")
	public void doSearch(){
		items = new ListModelList<Item>();
		items.addAll(getSearchService().search(filterBox.getValue()));
		itemListbox.setModel(items);
		detailBox.setVisible(false);
	}
	
	@Listen("onChange = #filterBox")
	public void changeButtonStatus(){
		searchButton.setDisabled(filterBox.getValue().length()==0);
	}
	@Listen("onSelect = listbox")
	public void selectItem(){
		selected = items.get(itemListbox.getSelectedIndex());
		//display item detail
		detailBox.setVisible(true);
		detailCaption.setLabel(selected.getName());
		descriptionLabel.setValue(selected.getDescription());
		priceLabel.setValue(ItemRenderer.priceFormatter.format(selected.getPrice()));
		quantityLabel.setValue(Integer.toString(selected.getQuantity()));
		quantityLabel.setSclass(selected.getQuantity()<3?"red":"");
		totalPriceLabel.setValue(ItemRenderer.priceFormatter.format(selected.getTotalPrice()));
	}
}
