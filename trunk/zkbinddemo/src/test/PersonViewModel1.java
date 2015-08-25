/* PersonViewModel1.java

	Purpose:
		
	Description:
		
	History:
		Jun 22, 2011 11:13:54 AM, Created by henrichen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
*/

package test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.BindComposer;
import org.zkoss.bind.BindContext;
import org.zkoss.bind.Converter;
import org.zkoss.bind.Form;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.DependsOn;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zul.Messagebox;

/**
 * The ViewModel to show {@link Person}, example 1.
 * @author henrichen
 * @deprecated we do not maintain this.
 */
public class PersonViewModel1 extends BindComposer {
	private List<Person> persons;
	private Person curPerson; //current person
	private Person newPerson; //new added person
	private Map<String, Converter> converters = new HashMap<String, Converter>(); //_converter map
	private String validMessage; //validation message for form submission

	public PersonViewModel1() {
		converters.put("age", new Converter() {
			//date -> age
			@DependsOn("birthday")
			public Object coerceToUi(Object val, Component component, BindContext ctx) {
				final Person person = (Person) val;
				final Date date = person.getBirthday();
				final Calendar cal1 = Calendar.getInstance();
				cal1.setTime(date);
				final Calendar cal2 = Calendar.getInstance();
				cal2.setTime(new Date());
				return "" + (cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR)); 
			}

			public Object coerceToBean(Object val, Component component, BindContext ctx) {
				//Never call here
				return null;
			}
		});
		converters.put("fullName", new Converter() {
			//person -> fullName
			@DependsOn({"firstName", "lastName"})
			public Object coerceToUi(Object val, Component component, BindContext ctx) {
				if (val instanceof Form) {
					final Form bean = (Form) val;
					return "" + bean.getField("firstName")+ " " + bean.getField("lastName");
				} else {
					final Person person = (Person) val;
					return person.getFirstName() + " " + person.getLastName();
				}
			}

			public Object coerceToBean(Object val, Component component, BindContext ctx) {
				//Never call here
				return null;
			}
		});
		
		persons = new ArrayList<Person>();
		for(int j = 0; j < 30; ++j) {
			persons.add(new Person("FName"+j, "LName"+j));
		}
	}
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
	}
	

 	public List<Person> getPersons() {
		return persons;
	}
	@NotifyChange
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	public Person getCurPerson() {
		return curPerson;
	}
	@NotifyChange
	public void setCurPerson(Person curPerson) {
		this.curPerson = curPerson;
	}
	public Person getNewPerson() {
		if (newPerson == null) {
			newPerson = new Person(null, null);
		}
		return newPerson;
	}
	@NotifyChange
	public void setNewPerson(Person newPerson) {
		this.newPerson = newPerson;
	}
	//address components
	private String[] citys={};
	private String city;
	private String[] districts={};
	private String district;
	private String[] roads;
	private String road;

	//City
	public String[] getCitys() {
		return citys;
	}
	public String getCity() {
		return city;
	}
	@NotifyChange({"city"})
	public void setCity(String city) {
		this.city = city;
		//change districts
	}
	
	//District
	@DependsOn("city")
	public String[] getDistricts() {
		return districts;
	}
	public String getDistrict() {
		return district;
	}
	@NotifyChange({"district"})
	public void setDistrict(String district) {
		this.district = district;
		//change roads
	}
	
	//Road
	@DependsOn("district")
	public String[] getRoads() {
		return roads;
	}
	public String getRoad() {
		return road;
	}
	@NotifyChange({"road"})
	public void setRoad(String road) {
		this.road = road;
		//change roads
	}
	
	public Converter getConverter(String name) {
		return converters.get(name);
	}
	
	//validation
	@NotifyChange("validMessage")
	public boolean validateFirstName(Object bean, Object value, BindContext ctx) {
		//validate firstName and setup the validMessage
		return true; //true means successful validation
	}
	
	@NotifyChange("validMessage")
	public boolean validate(Form form, String commandName, BindContext ctx) {
		//validation and setup the validMessage
		//...
		return true; //true means successful validation
	}
	
	public String getValidMessage() {
		return this.validMessage;
	}
	
	public void setValidMessage(String message) {
		this.validMessage = message;
	}

	//Commands
	@Command
	@NotifyChange("persons")
	public void addPerson() {
		persons.add(newPerson);
		//insert into db
	}
	
	@Command
	@NotifyChange("curPerson")
	public void modifyPerson() {
		//update db
	}
	
	@Command
	@NotifyChange("persons")
	public void removePerson(@BindingParam("person") Person person) {
		persons.remove(person);
		//remove from db
	}
	@Command
	public void selectPerson() {
		//do nothing!
	}
	
/*	
	<window apply="${vm}" title="Are you sure?">
		Form has changed, what do you want to do?
		Press Add button to add a new person.
		Press Modify button to modify the person.
		Press Ignore button to ignore the form contents.
		Press Cancel button to return to previous person.
		<button label="Add" onClick="@{'addPerson'}"/>
		<button label="Modify" onClick="@{'modifyPerson'}"/>
		<button label="Ignore" onClick="@{'Ignore'}"/>
		<button label="Cancel" onClick="@{'Cancel'}"/> <!-- Implicit Command name 'CANCEL' means cancel the command that cause the operaton -->
	</window>
*/	                                      
	public void onConfirm(ForwardEvent event) throws Exception {
		final String btn = event.getOrigin().getTarget().getId();
		//confirmResult
		//	true:
		// 		bind those are triggered by onSelect
		//		execute selectPerson command
		//
		
		//	false:
		//		reverse bind those are triggered by onSelect 
		//		do NOT execute selectPerson command
	}
}
