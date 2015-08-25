package org.zkoss.bind.unitest2;

import org.junit.Assert;
import org.junit.Test;
import org.zkoss.zktc.core.junit.TestCaseBase;
import org.zkoss.zktc.core.widget.Widget;
/**
 * test case for features from number 500-999
 * @author dennis
 *
 */
public class FeaturesTestCase1000 extends TestCaseBase{

	
	
	
	@Test
	public void f01032BindContextEvent(){
		navigate(getTestCaseUrl("/bind/issue/F01032BindContextEvent.zul"));
		
		Widget msg = findWidget("$msg");
		Widget tb = findWidget("$tb");
		Widget btn = findWidget("$btn");
		
		tb.replace("a").tab();
		Assert.assertEquals("evt1:onChange,evt2:onChange, cmd:cmd",msg.getValue());
		
		btn.click();
		Assert.assertEquals("evt1:onClick,evt2:onClick, cmd:cmd",msg.getValue());
	}
	
	@Test
	public void f01033InitClass(){
		navigate(getTestCaseUrl("/bind/issue/F01033InitClass.zul"));
		
		Widget l11 = findWidget("$l11");
		Widget l12 = findWidget("$l12");
		Widget l21 = findWidget("$l21");
		Widget l22 = findWidget("$l22");

		Assert.assertEquals("",l11.getValue());
		Assert.assertEquals("Chen",l12.getValue());
		Assert.assertEquals("Ian",l21.getValue());
		Assert.assertEquals("Tasi",l22.getValue());
	}
	
	@Test
	public void f01046PublicEvent(){
		navigate(getTestCaseUrl("/bind/issue/F01046PublicEvent.zul"));
		
		Widget msg1 = findWidget("$msg1");
		Widget btn1 = findWidget("$btn1");
		Widget msg2 = findWidget("$msg2");
		Widget btn2 = findWidget("$btn2");
		
		btn1.click();
		Assert.assertEquals("Hello i am a vm",msg2.getValue());
		
		btn2.click();
		Assert.assertEquals("Hello i am a composer",msg1.getValue());
	}
	
	@Test
	public void F01231AfterComposeVM(){
		navigate(getTestCaseUrl("/bind/issue/F01231AfterComposeVM.zul"));
		
		Widget myWin = findWidget("$myWin");
		Widget headerLb = findWidget("$headerLb");
		Widget nameLb = findWidget("$nameLb");
		Widget descTxb = findWidget("$descTxb");
		
		Assert.assertEquals("AAAA", myWin.getAttribute("title"));
		Assert.assertEquals("This is a label", headerLb.getValue());
		Assert.assertEquals("admin", nameLb.getValue());
		Assert.assertEquals("this is desc", descTxb.getValue());
	}
	
	
	@Test
	public void f01416DefaultCommand(){
		navigate(getTestCaseUrl("/bind/issue/F01416DefaultCommand.zul"));
		
		Widget btn1 = findWidget("$btn1");
		Widget btn2 = findWidget("$btn2");
		Widget btng1 = findWidget("$btng1");
		Widget btng2 = findWidget("$btng2");
		Widget lb1 = findWidget("$lb1");
		
		Widget btn3 = findWidget("$btn3");
		Widget btn4 = findWidget("$btn4");
		Widget btng3 = findWidget("$btng3");
		Widget btng4 = findWidget("$btng4");
		Widget lb2 = findWidget("$lb2");
		
		
		Assert.assertEquals("Dennis",lb1.getValue());
		Assert.assertEquals("Dennis",lb2.getValue());
		
		btn1.click();
		Assert.assertEquals("do command1",lb1.getValue());
		Assert.assertEquals("Dennis",lb2.getValue());
		
		btn2.click();
		Assert.assertEquals("do command cmd2",lb1.getValue());
		Assert.assertEquals("Dennis",lb2.getValue());
		
		btng1.click();
		Assert.assertEquals("do globa-command1",lb1.getValue());
		Assert.assertEquals("do globa-command1",lb2.getValue());
		
		btng2.click();
		Assert.assertEquals("do globa-command gcmd2",lb1.getValue());
		Assert.assertEquals("do globa-command gcmd2",lb2.getValue());
		
		btn3.click();
		Assert.assertEquals("do globa-command gcmd2",lb1.getValue());
		Assert.assertEquals("do command3",lb2.getValue());
		
		btn4.click();
		Assert.assertEquals("do globa-command gcmd2",lb1.getValue());
		Assert.assertEquals("do command cmd4",lb2.getValue());
		
		btng3.click();
		Assert.assertEquals("do globa-command3",lb1.getValue());
		Assert.assertEquals("do globa-command3",lb2.getValue());
		
		btng4.click();
		Assert.assertEquals("do globa-command gcmd4",lb1.getValue());
		Assert.assertEquals("do globa-command gcmd4",lb2.getValue());
	}
	
	@Test
	public void F01048FormBindingMessage(){
		navigate(getTestCaseUrl("/bind/issue/F01048FormBindingMessage.zul"));
		
		Widget tb1 = findWidget("$tb1");
		Widget tb2 = findWidget("$tb2");
		Widget tb3 = findWidget("$tb3");
		
		Widget lb1 = findWidget("$lb1");
		Widget lb2 = findWidget("$lb2");
		Widget lb3 = findWidget("$lb3");
		
		Widget save = findWidget("$save");
		
		save.click();
		Assert.assertEquals("First name is missing.", lb1.getValue());
		Assert.assertEquals("Last name is missing.", lb2.getValue());
		Assert.assertEquals("Age is missing.", lb3.getValue());
		
		tb1.replace("Dennis").tab();
		Assert.assertEquals("", lb1.getValue());
		
		tb2.replace("Chen").tab();
		Assert.assertEquals("", lb2.getValue());
		
		tb3.replace("35").tab();
		Assert.assertEquals("", lb3.getValue());
		
		tb1.replace("").tab();
		tb3.replace("").tab();
		
		
		Assert.assertEquals("", lb1.getValue());
		Assert.assertEquals("", lb2.getValue());
		Assert.assertEquals("", lb3.getValue());
		
		save.click();
		
		Assert.assertEquals("First name is missing.", lb1.getValue());
		Assert.assertEquals("", lb2.getValue());
		Assert.assertEquals("Age is missing.", lb3.getValue());
		
		
		tb1.replace("DennisA").tab();
		Assert.assertEquals("", lb1.getValue());
		
		tb2.replace("ChenB").tab();
		Assert.assertEquals("", lb2.getValue());
		
		tb3.replace("37").tab();
		Assert.assertEquals("", lb3.getValue());
		
		save.click();
		Assert.assertEquals("", lb1.getValue());
		Assert.assertEquals("", lb2.getValue());
		Assert.assertEquals("", lb3.getValue());
		Assert.assertEquals("Update DennisA,ChenB,37", findWidget("$msg").getValue());
	}
}

