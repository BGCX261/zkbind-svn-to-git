package org.zkoss.bind.unitest2;

import org.junit.Assert;
import org.junit.Test;
import org.zkoss.zktc.core.junit.TestCaseBase;
import org.zkoss.zktc.core.widget.WidgetDriver;

public class FormTestCase extends TestCaseBase {

	@Test
	public void testLoad() {
		navigate(getTestCaseUrl("/bind/basic/load-form.zul"));

		Assert.assertEquals("First1", findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("Last1", findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("First1 Last1",
				findWidget("$l3").getAttribute("value"));

		Assert.assertEquals("First1", findWidget("$l5").getAttribute("value"));
		Assert.assertEquals("Last1", findWidget("$l6").getAttribute("value"));
		Assert.assertEquals("First1 Last1",
				findWidget("$l7").getAttribute("value"));

		Assert.assertEquals("", findWidget("$l9").getAttribute("value"));
		Assert.assertEquals("", findWidget("$la").getAttribute("value"));
		Assert.assertEquals("", findWidget("$lb").getAttribute("value"));

		findWidget("$l1").clear().keys("XXX");
		findWidget("$btn1").focus();

		Assert.assertEquals("XXX", findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("Last1", findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("XXX Last1", findWidget("$l3")
				.getAttribute("value"));

		// spec change, p1.first change will not effect p1 -> fx
		Assert.assertEquals("First1", findWidget("$l5").getAttribute("value"));
		Assert.assertEquals("Last1", findWidget("$l6").getAttribute("value"));
		Assert.assertEquals("First1 Last1",
				findWidget("$l7").getAttribute("value"));

		Assert.assertEquals("", findWidget("$l9").getAttribute("value"));
		Assert.assertEquals("", findWidget("$la").getAttribute("value"));
		Assert.assertEquals("", findWidget("$lb").getAttribute("value"));

		findWidget("$l5").clear().keys("YYY");
		findWidget("$btn1").focus();

		Assert.assertEquals("XXX", findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("Last1", findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("XXX Last1", findWidget("$l3")
				.getAttribute("value"));

		Assert.assertEquals("YYY", findWidget("$l5").getAttribute("value"));
		Assert.assertEquals("Last1", findWidget("$l6").getAttribute("value"));
		Assert.assertEquals("First1 Last1",
				findWidget("$l7").getAttribute("value"));

		Assert.assertEquals("", findWidget("$l9").getAttribute("value"));
		Assert.assertEquals("", findWidget("$la").getAttribute("value"));
		Assert.assertEquals("", findWidget("$lb").getAttribute("value"));

		findWidget("$btn1").click();

		Assert.assertEquals("YYY", findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("Last1", findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("YYY Last1", findWidget("$l3")
				.getAttribute("value"));

		Assert.assertEquals("YYY", findWidget("$l5").getAttribute("value"));
		Assert.assertEquals("Last1", findWidget("$l6").getAttribute("value"));
		Assert.assertEquals("YYY Last1", findWidget("$l7")
				.getAttribute("value"));

		Assert.assertEquals("YYY", findWidget("$l9").getAttribute("value"));
		Assert.assertEquals("Last1", findWidget("$la").getAttribute("value"));
		Assert.assertEquals("YYY Last1", findWidget("$lb")
				.getAttribute("value"));

	}

	@Test
	public void testIndirect() {
		navigate(getTestCaseUrl("/bind/basic/load-form-indirect.zul"));

		Assert.assertEquals("First1", findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("Last1", findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("First1 Last1",
				findWidget("$l3").getAttribute("value"));
		Assert.assertEquals("First1", findWidget("$l4").getAttribute("value"));
		Assert.assertEquals("First1", findWidget("$l5").getAttribute("value"));

		Assert.assertEquals("", findWidget("$l6").getAttribute("value"));
		Assert.assertEquals("", findWidget("$l7").getAttribute("value"));
		Assert.assertEquals("", findWidget("$l8").getAttribute("value"));

		findWidget("$l1").clear().keys("XXX");
		findWidget("$btn1").focus();

		Assert.assertEquals("XXX", findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("Last1", findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("First1 Last1",
				findWidget("$l3").getAttribute("value"));
		Assert.assertEquals("XXX", findWidget("$l4").getAttribute("value"));
		Assert.assertEquals("First1", findWidget("$l5").getAttribute("value"));

		Assert.assertEquals("", findWidget("$l6").getAttribute("value"));
		Assert.assertEquals("", findWidget("$l7").getAttribute("value"));
		Assert.assertEquals("", findWidget("$l8").getAttribute("value"));

		findWidget("$btn2").click();
		Assert.assertEquals("Last1", findWidget("$l4").getAttribute("value"));
		Assert.assertEquals("Last1", findWidget("$l5").getAttribute("value"));
		Assert.assertEquals("", findWidget("$l8").getAttribute("value"));

		findWidget("$btn3").click();
		Assert.assertEquals("First1 Last1", findWidget("$l4").getAttribute("value"));
		Assert.assertEquals("First1 Last1",
				findWidget("$l5").getAttribute("value"));
		Assert.assertEquals("", findWidget("$l8").getAttribute("value"));

		findWidget("$btn4").click();
		Assert.assertEquals("XXX", findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("Last1", findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("XXX Last1", findWidget("$l3")
				.getAttribute("value"));
		Assert.assertEquals("XXX Last1", findWidget("$l4")
				.getAttribute("value"));
		Assert.assertEquals("XXX Last1", findWidget("$l5")
				.getAttribute("value"));

		Assert.assertEquals("XXX", findWidget("$l6").getAttribute("value"));
		Assert.assertEquals("Last1", findWidget("$l7").getAttribute("value"));
		Assert.assertEquals("XXX Last1", findWidget("$l8")
				.getAttribute("value"));

		findWidget("$l1").clear().keys("YYY");
		findWidget("$btn1").focus();

		findWidget("$btn1").click();
		Assert.assertEquals("YYY", findWidget("$l4")
				.getAttribute("value"));
		Assert.assertEquals("XXX", findWidget("$l5").getAttribute("value"));
		Assert.assertEquals("XXX Last1", findWidget("$l8")
				.getAttribute("value"));

		findWidget("$btn4").click();
		Assert.assertEquals("YYY", findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("Last1", findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("YYY Last1", findWidget("$l3")
				.getAttribute("value"));
		Assert.assertEquals("YYY", findWidget("$l4").getAttribute("value"));
		Assert.assertEquals("YYY", findWidget("$l5").getAttribute("value"));

		Assert.assertEquals("YYY", findWidget("$l6").getAttribute("value"));
		Assert.assertEquals("Last1", findWidget("$l7").getAttribute("value"));
		Assert.assertEquals("YYY Last1", findWidget("$l8")
				.getAttribute("value"));
	}

	@Test
	public void testFormDirty() {
		navigate(getTestCaseUrl("/bind/basic/form-dirty.zul"));

		Assert.assertEquals("false", findWidget("$dirty").getValue());
		Assert.assertEquals("Dennis", findWidget("$l1").getValue());
		
		findWidget("$t1").clear().keys("X").tab();
		Assert.assertEquals("true", findWidget("$dirty").getValue());
		Assert.assertEquals("X", findWidget("$l1").getValue());
		
		findWidget("$t1").clear().keys("Dennis").tab();
		Assert.assertEquals("false", findWidget("$dirty").getValue());
		Assert.assertEquals("Dennis", findWidget("$l1").getValue());
		
		findWidget("$t1").clear().keys("Y").tab();
		Assert.assertEquals("true", findWidget("$dirty").getValue());
		Assert.assertEquals("Y", findWidget("$l1").getValue());
		
		findWidget("$btn2").click();
		Assert.assertEquals("old-name Dennis", findWidget("$msg").getValue());
		
		findWidget("$btn1").click();
		Assert.assertEquals("saved Y", findWidget("$msg").getValue());
		
		findWidget("$btn2").click();
		Assert.assertEquals("old-name Y", findWidget("$msg").getValue());
		Assert.assertEquals("false", findWidget("$dirty").getValue());
		Assert.assertEquals("Y", findWidget("$l1").getValue());
	}

}
