/* MutualDependentViewModel.java

	Purpose:
		
	Description:
		
	History:
		Sep 23, 2011 4:41:41 PM, Created by henrichen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
*/

package test;

import org.zkoss.bind.BindComposer;
import org.zkoss.bind.annotation.DependsOn;
import org.zkoss.bind.annotation.NotifyChange;

/**
 * test circular DependsOn case.
 * @author henrichen
 *
 */
public class MutualDependentViewModel extends BindComposer {
	private String value;
	
	@DependsOn("b")
	public String getA() {
		return value;
	}
	@NotifyChange
	public void setA(String a) {
		this.value = a;
	}
	
	@DependsOn("a")
	public String getB() {
		return value;
	}
	@NotifyChange
	public void setB(String b) {
		this.value = b;
	}
}
