/* FullnameViewModel.java

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

/**
 * View model for the examples/fullname/fullnameMVVM.zul.
 * Either input "first name" or "last name", the full name will be changed accordingly.
 * 
 * @author henrichen
 *
 */
public class FullnameViewModel extends BindComposer {
	private String firstname;
	private String lastname;
	public String getFirstname() {
		return firstname;
	}
	@NotifyChange
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	@NotifyChange
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@DependsOn({"firstname", "lastname"})
	public String getFullname() {
		return (firstname == null ? "" : firstname)	+ " "
				+ (lastname == null ? "" : lastname);
	}
}
