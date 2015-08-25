/* FullnameComposer.java

	Purpose:
		
	Description:
		
	History:
		Sep 23, 2011 11:17:25 AM, Created by henrichen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
*/

package org.zkoss.mvvm.examples.fullname;

import org.zkoss.bind.BindComposer;
import org.zkoss.bind.annotation.DependsOn;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

/**
 * View model for the examples/fullname/fullnameMVP.zul.
 * Either input first name or last name, the full name will be changed accordingly.
 * 
 * @author henrichen
 *
 */
public class FullnameComposer extends GenericForwardComposer {
	private String firstname;
	private String lastname;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getFullname() {
		return (firstname == null ? "" : firstname)	+ " "
				+ (lastname == null ? "" : lastname);
	}
	
	private Textbox firsttbx;
	private Textbox lasttbx;
	private Label fulllbl;
	
	public void onChange$firsttbx() {
		setFirstname(firsttbx.getValue()); //update model
		fulllbl.setValue(getFullname()); //update fullname label
	}
	
	public void onChange$lasttbx() {
		setLastname(lasttbx.getValue()); //update model
		fulllbl.setValue(getFullname()); //update fullname label
	}
}
