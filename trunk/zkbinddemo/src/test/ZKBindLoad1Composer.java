/* ZKBindLoad1Composer.java

	Purpose:
		
	Description:
		
	History:
		Aug 2, 2011 1:01:07 PM, Created by henrichen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
*/

package test;

import java.util.List;

import org.zkoss.bind.BindComposer;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;

import test.Person.Address;

/**
 * @author henrichen
 *
 */
public class ZKBindLoad1Composer extends BindComposer {
	private Person _selected;
	private List<Person> _persons;
	
	public ZKBindLoad1Composer() {
		_persons = new ListModelList();
		for(int j = 0; j < 4; ++j) {
			_persons.add(new Person("First"+j , "Last"+j));
		}
		_selected = (Person) _persons.get(1); //2nd person
		Address addr = new Address("87 Zhengzhou Road #11F-2 Taipei", "103");
		_selected.setAddress(addr);
	}
	
	public Person getSelected() {
		return _selected;
	}
	@NotifyChange
	public void setSelected(Person p) {
		_selected = p;
	}
	
	public List<Person> getPersons() {
		return _persons;
	}
	
	public Person getP1() {
		return getSelected();
	}
	@NotifyChange("p1")
	public void removeP1() {
		_selected = null;
		_persons.remove(1);
	}
	
	public void myCommand() {
		System.out.println("Execute 'myCommand'");
	}
}
