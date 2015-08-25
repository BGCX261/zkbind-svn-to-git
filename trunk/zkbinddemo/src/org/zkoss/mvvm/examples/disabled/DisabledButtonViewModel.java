/* DisabledButtonViewModel.java

	Purpose:
		
	Description:
		
	History:
		Sep 21, 2011 11:54:49 AM, Created by henrichen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
*/

package org.zkoss.mvvm.examples.disabled;

import org.zkoss.bind.BindComposer;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

/**
 * 1. whenever the textbox is empty, the button is disabled;
 * 2. whenever the textbox is not empty, the button is enabled.
 * 
 * @author henrichen
 *
 */
public class DisabledButtonViewModel extends BindComposer {
	private String symbol;
	private String lastSymbol;

	//properties//
	public String getSymbol() {
		return this.symbol;
	}

	@NotifyChange
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public String getLastSymbol() {
		return this.lastSymbol;
	}

	//commands//
	@Command @NotifyChange("lastSymbol")
	public void subscribe() {
		this.lastSymbol = this.symbol;
	}
}
