/* OrderVM.java

	Purpose:
		
	Description:
		
	History:
		2011/10/31 Created by Dennis Chen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
 */
package org.zkoss.zktest.bind.cases.order;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Textbox;

/**
 * @author dennis
 * 
 */
public class OrderBindComposer extends SelectorComposer<Component>{

	//the order list
	ListModelList<Order> orders;
	
	//the selected order
	Order selected;
	
	OrderService service;
	
	@Wire
	Listbox orderList;
	
	@Wire
	Button saveBtn;
	@Wire
	Button deleteBtn1;
	@Wire
	Groupbox editor;
	@Wire
	Label id;
	@Wire
	Textbox desc;
	@Wire
	Intbox quantity;
	@Wire
	Doublebox price;
	@Wire
	Label totalPrice;
	@Wire
	Datebox creationDate;
	@Wire
	Datebox shippingDate;
	
	
//	private static final NumberFormat numberFormat = new DecimalFormat("###,##0.00");
//	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setAttribute("ctrl", this);
	}

	public ListModelList<Order> getOrders() {
		if (orders == null) {
			//init the list
			orders = new ListModelList<Order>(getService().list());
		}
		return orders;
	}

	public Order getSelected() {
		return selected;
	}

	
	public void setSelected(Order selected) {
		this.selected = selected;
//		validationMessages.clear();//clear when another order selected
	}

	@Listen("onSelect=#orderList")
	public void itemSelected(){
		int i = orderList.getSelectedIndex();
		if(i>=0){
			selected = orders.get(i);
		}else{
			selected = null;
		}
		saveBtn.setVisible(selected!=null);
		deleteBtn1.setVisible(selected!=null);
		editor.setVisible(selected!=null);
	}	
	//action command


//	public void newOrder(){
//		Order order = new Order();
//		getOrders().add(order);
//		selected = order;//select the new one
////		validationMessages.clear();//clear message
//	}
//	
//
//	public void saveOrder(){
//		getService().save(selected);
////		validationMessages.clear();//clear message
//	}
//	
//	
//
//	public void deleteOrder(){
//		getService().delete(selected);//delete selected
//		getOrders().remove(selected);
//		selected = null; //clean the selected
////		validationMessages.clear();//clear message
////		deleteMessage = null;
//	}
	
	//validation messages
//	Map<String, String> validationMessages = new HashMap<String,String>();
//	
//	public Map<String,String> getValidationMessages(){
//		return validationMessages;
//	}
//	

	public OrderService getService() {
		if(service==null){
			service = FakeOrderService.getInstance();; 
		}
		return service;
	}
	
//	//validators for prompt
//	public Validator getPriceValidator(){
//		return new Validator(){
//			public void validate(ValidationContext ctx) {
//				Double price = (Double)ctx.getProperty().getValue();
//				if(price==null || price<=0){
//					ctx.setInvalid(); // mark invalid
//					validationMessages.put("price", "must large than 0");
//				}else{
//					validationMessages.remove("price");
//				}
//				//notify messages was changed.
//				ctx.getBindContext().getBinder().notifyChange(validationMessages, "price");
//			}
//		};
//	}
//	
//	public Validator getQuantityValidator(){
//		return new Validator(){
//			public void validate(ValidationContext ctx) {
//				Integer quantity = (Integer)ctx.getProperty().getValue();
//				if(quantity==null || quantity<=0){
//					ctx.setInvalid();// mark invalid
//					validationMessages.put("quantity", "must large than 0");
//				}else{
//					validationMessages.remove("quantity");
//				}
//				//notify messages was changed.
//				ctx.getBindContext().getBinder().notifyChange(validationMessages, "quantity");
//			}
//		};
//	}
//	
//	//validators for command
//	public Validator getCreationDateValidator(){
//		return new Validator(){
//			public void validate(ValidationContext ctx) {
//				Date creation = (Date)ctx.getProperty().getValue();
//				if(creation==null){
//					ctx.setInvalid();// mark invalid
//					validationMessages.put("creationDate", "must not null");
//				}else{
//					validationMessages.remove("creationDate");
//				}
//				//notify messages was changed.
//				ctx.getBindContext().getBinder().notifyChange(validationMessages, "creationDate");
//			}
//		};
//	}
//	public Validator getShippingDateValidator(){
//		return new Validator(){
//			public void validate(ValidationContext ctx) {
//				Date shipping = (Date)ctx.getProperty().getValue();//the main property
//				Date creation = (Date)ctx.getProperties("creationDate")[0].getValue();//the collected
//				//do mixed validation, shipping date have to large than creation more than 3 days.
//				if(!CaldnearUtil.isDayAfter(creation,shipping,3)){
//					ctx.setInvalid();
//					validationMessages.put("shippingDate", "must large than creation date at least 3 days");
//				}else{
//					validationMessages.remove("shippingDate");
//				}
//				//notify the 'price' message in messages was changed.
//				ctx.getBindContext().getBinder().notifyChange(validationMessages, "shippingDate");
//			}
//
//		};
//	}
	
//	static class CaldnearUtil{
//		static public boolean isDayAfter(Date date, Date laterDay , int day) {
//			if(date==null) return false;
//			if(laterDay==null) return false;
//			
//			Calendar cal = Calendar.getInstance();
//			Calendar lc = Calendar.getInstance();
//			
//			cal.setTime(date);
//			lc.setTime(laterDay);
//			
//			int cy = cal.get(Calendar.YEAR);
//			int ly = lc.get(Calendar.YEAR);
//			
//			int cd = cal.get(Calendar.DAY_OF_YEAR);
//			int ld = lc.get(Calendar.DAY_OF_YEAR);
//			
//			return (ly*365+ld)-(cy*365+cd) >= day; 
//		}
//	}
	
	//message for confirming the deletion.
//	String deleteMessage;
//	
//	public String getDeleteMessage(){
//		return deleteMessage;
//	}
//	
//	
//	public void confirmDelete(){
//		//set the message to show to user
//		deleteMessage = "Do you want to delete "+selected.getId()+" ?";
//	}
//	
//	public void cancelDelete(){
//		//clear the message
//		deleteMessage = null;
//	}
}
