/* ConfirmViewModel.java

	Purpose:
		
	Description:
		
	History:
		Sep 21, 2011 11:54:49 AM, Created by DennisChen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
 */

package org.zkoss.mvvm.examples.confirm;

import java.util.Date;

import org.zkoss.bind.BindComposer;
import org.zkoss.bind.Form;
import org.zkoss.bind.SimpleForm;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;

/**
 * Demo how to use validation to do the confirmation.
 * @author dennis
 */
public class ConfirmViewModel extends BindComposer {
	private ListModelList<City> cityList;
	private City selected;
	private City tobeSelected = null;
	
	private DialogBean dialog; 
	private String message;
	
	private Form form;

	public ConfirmViewModel() {
		//init the fake data
		cityList = new ListModelList<City>();
		cityList.add(new City("New York",30));
		cityList.add(new City("Taipei",40));
		cityList.add(new City("Beijing",50));
		cityList.add(new City("Tokyo",60));
		
		//a bean to help me show dialog
		dialog = new DialogBean();
		
		form = new SimpleForm();
		
		addValidator("dirtyValidator", new Validator(){
			public void validate(ValidationContext ctx) {
				if(selected!=null && form.isDirty()){
					//form is dirty, we keep the object as a to-be-selected obj;
					tobeSelected = (City)ctx.getProperty().getValue();
					//show dialog
					setDialog(true,selected);
					ctx.setInvalid();
				}
			}});
		addValidator("formValidator", new Validator() {
			public void validate(ValidationContext ctx) {
				Integer population = (Integer) ctx.getProperties().get("population")[0].getValue();
				if (population==null || population <= 10) {
					// validation fail
					if (tobeSelected == null) {
						// no tobeSelected, it was from update command;
						setMessage("validation fail");
					} else {
						setMessage("validation and select back to " + selected);
						tobeSelected = null;
						// Don't use send, we are already in command lifecycle
//						getBinder().sendCommand("confirmCancel", null);
						getBinder().postCommand("confirmCancel", null);
					}
					ctx.setInvalid();
				}
			}
		});
	}

	public Form getForm(){
		return form;
	}
	//

	public ListModelList<City> getCityList() {
		return cityList;
	}

	public void setCityList(ListModelList<City> cityList) {
		this.cityList = cityList;
	}

	public City getSelected() {
		return selected;
	}

	@NotifyChange
	public void setSelected(City selected) {
		this.selected = selected;
		tobeSelected = null;
	}

	public String getMessage(){
		return message;
	}
	
	public void setMessage(String message){
		this.message = message;
		//notify by java code, @NotifyChange doesn't work if called internally
		notifyChange(this, "message");
	}

	public DialogBean getDialog() {
		return dialog;
	}
	
	void setDialog(boolean visible,City selected){
		dialog.setVisible(visible);
		dialog.setCity(selected);
		//notify by java code, @NotifyChange doesn't work if called internally
		notifyChange(this, "dialog");
	}

	//commands
	
	@Command @NotifyChange({"selected"})
	public void update(){
		//update selected to database
		setMessage("update "+selected.getName() +"["+new Date()+"]");
	}
	
	@Command @NotifyChange({"selected"})
	public void confirmUpdate(){
		selected = tobeSelected;
		setDialog(false,null);
		setMessage("confirmUpdate "+selected +"["+new Date()+"]");
	}
	
	@Command @NotifyChange({"selected"})
	public void confirmSelectOnly(){
		//change selection to next
		selected = tobeSelected;
		setDialog(false,null);
		setMessage("confirmSelectOnly "+selected +"["+new Date()+"]");
	}
	
	@Command @NotifyChange({"selected"})
	public void confirmCancel(){
		//nothing, clean dialog
		setDialog(false,null);
		setMessage("confirmCancel "+selected +"["+new Date()+"]");
	}

	public static class City {
		String name;
		int population;

		public City(String name,int population) {
			this.name = name;
			this.population = population;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getPopulation() {
			return population;
		}

		public void setPopulation(int population) {
			this.population = population;
		}
		
		public String toString(){
			return new StringBuilder().append("[").append(name).append(",").append(population).append("]").toString();
		}
		
	}

}
