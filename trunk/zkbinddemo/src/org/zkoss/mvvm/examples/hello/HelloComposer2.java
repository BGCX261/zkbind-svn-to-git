/* HelloComposer.java

	Purpose:
		
	Description:
		
	History:
		Sep 22, 2011 10:41:47 AM, Created by henrichen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
*/

package org.zkoss.mvvm.examples.hello;

import org.zkoss.zul.Label;
import org.zkoss.zul.Window;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;

/**
 * Presenter in the MVP design pattern.
 * @author henrichen
 *
 */
public class HelloComposer2 extends GenericForwardComposer {
	private Label win$lbl;
	private Button btn;
	
	private Window win;
	
	public void onClick$btn(Event event) {
		win$lbl.setValue("Hello World!");
		win.doModal();
	}
	
	public void onClose$win(Event event) {
		win.setVisible(false);
		//event.stopPropagation(); //Will not work because it is the ForwardEvent
		Events.getRealOrigin((ForwardEvent)event).stopPropagation();
	}
}
