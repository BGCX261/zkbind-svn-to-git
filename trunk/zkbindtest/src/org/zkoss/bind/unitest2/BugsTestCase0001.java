package org.zkoss.bind.unitest2;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.zkoss.zktc.core.junit.TestCaseBase;
import org.zkoss.zktc.core.widget.Widget;
/**
 * test case for bugs from number 1-499
 * @author dennis
 *
 */
public class BugsTestCase0001 extends TestCaseBase{

	@Test
	public void b0004(){
		navigate(getTestCaseUrl("/bind/issue/B0004.zul"));
		
		Assert.assertEquals("0",findWidget("$l11").getValue());
		Assert.assertEquals("",findWidget("$l12").getValue());
		Assert.assertEquals("",findWidget("$msg1").getValue());
		Assert.assertEquals("",findWidget("$msg2").getValue());
		Assert.assertEquals("",findWidget("$msg3").getValue());
		
		findWidget("$btn1").click();
		Assert.assertEquals("0",findWidget("$l11").getValue());
		Assert.assertEquals("",findWidget("$l12").getValue());
		Assert.assertEquals("value 1 have to large than 10",findWidget("$msg1").getValue());
		Assert.assertEquals("",findWidget("$msg2").getValue());
		Assert.assertEquals("",findWidget("$msg3").getValue());
		
		
		findWidget("$t21").clear().keys("32").tab();
		Assert.assertEquals("0",findWidget("$l11").getValue());
		Assert.assertEquals("",findWidget("$l12").getValue());
		Assert.assertEquals("",findWidget("$msg1").getValue());
		Assert.assertEquals("",findWidget("$msg2").getValue());
		Assert.assertEquals("",findWidget("$msg3").getValue());
		
		findWidget("$btn1").click();
		Assert.assertEquals("0",findWidget("$l11").getValue());
		Assert.assertEquals("",findWidget("$l12").getValue());
		Assert.assertEquals("",findWidget("$msg1").getValue());
		Assert.assertEquals("value 2 is not valid For input string: \"\"",findWidget("$msg2").getValue());
		Assert.assertEquals("",findWidget("$msg3").getValue());
		
		
		findWidget("$t22").clear().keys("13").tab();
		Assert.assertEquals("0",findWidget("$l11").getValue());
		Assert.assertEquals("",findWidget("$l12").getValue());
		Assert.assertEquals("",findWidget("$msg1").getValue());
		Assert.assertEquals("value 2 have to large than 20",findWidget("$msg2").getValue());
		Assert.assertEquals("",findWidget("$msg3").getValue());
		
		findWidget("$t22").clear().keys("22").tab();
		Assert.assertEquals("0",findWidget("$l11").getValue());
		Assert.assertEquals("",findWidget("$l12").getValue());
		Assert.assertEquals("",findWidget("$msg1").getValue());
		Assert.assertEquals("",findWidget("$msg2").getValue());
		Assert.assertEquals("",findWidget("$msg3").getValue());
		
		findWidget("$btn1").click();
		Assert.assertEquals("0",findWidget("$l11").getValue());
		Assert.assertEquals("",findWidget("$l12").getValue());
		Assert.assertEquals("",findWidget("$msg1").getValue());
		Assert.assertEquals("value 2 have to large than value 1",findWidget("$msg2").getValue());
		Assert.assertEquals("",findWidget("$msg3").getValue());
		
		findWidget("$t22").clear().keys("42").tab();
		Assert.assertEquals("0",findWidget("$l11").getValue());
		Assert.assertEquals("",findWidget("$l12").getValue());
		Assert.assertEquals("",findWidget("$msg1").getValue());
		Assert.assertEquals("",findWidget("$msg2").getValue());
		Assert.assertEquals("",findWidget("$msg3").getValue());
		
		
		findWidget("$btn1").click();
		Assert.assertEquals("32",findWidget("$l11").getValue());
		Assert.assertEquals("42",findWidget("$l12").getValue());
		Assert.assertEquals("",findWidget("$msg1").getValue());
		Assert.assertEquals("",findWidget("$msg2").getValue());
		Assert.assertEquals("execute command 1",findWidget("$msg3").getValue());
	}
	
	@Test
	public void b0020(){
		navigate(getTestCaseUrl("/bind/issue/B0020.zul"));
		//test property init
		Assert.assertEquals(5,findWidgets("@button").size());
		Widget b = findWidget("@button");
		b.click();
		
		Assert.assertEquals(4,findWidgets("@button").size());
		b = findWidget("@button");
		b.click();
		
		Assert.assertEquals(3,findWidgets("@button").size());
		b = findWidget("@button");
		b.click();
		
		Assert.assertEquals(2,findWidgets("@button").size());
		b = findWidget("@button");
		b.click();
		
		Assert.assertEquals(1,findWidgets("@button").size());
		b = findWidget("@button");
		b.click();
		
		Assert.assertEquals(0,findWidgets("@button").size());
		b = findWidget("@button");
		Assert.assertNull(b);
		
	}
}
