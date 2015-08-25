package org.zkoss.bind.examples.order.richlet;

import org.zkoss.bind.Form;
import org.zkoss.bind.SimpleForm;
import org.zkoss.bind.examples.order.OrderVM3;

/**
 * only for richlet example.
 * @author Hawk
 *
 */
public class OrderVM4 extends OrderVM3 {

	Form myForm = new SimpleForm();

	public Form getMyForm() {
		myForm.setField("init",	"init");
		return myForm;
	}
	
}
