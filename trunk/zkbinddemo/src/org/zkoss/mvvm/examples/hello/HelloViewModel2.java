/* HelloViewModel.java

	Purpose:
		
	Description:
		
	History:
		Sep 20, 2011 3:52:10 PM, Created by henrichen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
*/

package org.zkoss.mvvm.examples.hello;

import org.zkoss.bind.BindComposer;
import org.zkoss.bind.BindContext;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

/**
 * Hello World example of ZK Bind.
 * @author henrichen
 *
 */
public class HelloViewModel2 extends BindComposer {
	private String message;
	
	public String getMessage() {
		return this.message;
	}
	
	@Command @NotifyChange("message")
	public void showHello() {
		this.message = "Hello World!";
	}
	
	@Command @NotifyChange("message")
	public void hideHello(BindContext ctx) {
		this.message = null;
		ctx.getTriggerEvent().stopPropagation();
	}
}
