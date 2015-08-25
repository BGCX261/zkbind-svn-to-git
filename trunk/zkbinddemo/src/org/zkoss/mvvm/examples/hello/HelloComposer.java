/* HelloComposer.java

	Purpose:
		
	Description:
		
	History:
		Sep 22, 2011 10:41:47 AM, Created by henrichen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
*/

package org.zkoss.mvvm.examples.hello;

import org.zkoss.zul.Label;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;

/**
 * Presenter in the MVP design pattern.
 * @author henrichen
 *
 */
public class HelloComposer extends GenericForwardComposer {
	private Label lbl;
	private Button btn;
	
	public void onClick$btn(Event event) {
		lbl.setValue("Hello World!");
	}
}
