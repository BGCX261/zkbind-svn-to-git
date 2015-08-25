package org.zkoss.bind.unitest2;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.zkoss.zktc.core.junit.TestCaseBase;
import org.zkoss.zktc.core.widget.WidgetDriver;
/**
 * test case for features from number 1-499
 * @author dennis
 *
 */
public class FeaturesTestCase0001 extends TestCaseBase{

	@Test
	public void f0002(){
		navigate(getTestCaseUrl("/bind/issue/F0002.zul"));
		//test property init
		Assert.assertEquals("A",findWidget("$tb1").getValue());
		Assert.assertEquals("A",findWidget("$l1").getValue());
		Assert.assertEquals("A",findWidget("$tb2").getValue());
		Assert.assertEquals("A",findWidget("$l2").getValue());
		
		findWidget("$tb1").clear().keys("XX").tab();
		Assert.assertEquals("XX",findWidget("$tb1").getValue());
		Assert.assertEquals("XX",findWidget("$l1").getValue());
		Assert.assertEquals("A",findWidget("$tb2").getValue());
		Assert.assertEquals("A",findWidget("$l2").getValue());
		
		findWidget("$tb2").clear().keys("YY").tab();
		Assert.assertEquals("XX",findWidget("$tb1").getValue());
		Assert.assertEquals("XX",findWidget("$l1").getValue());
		Assert.assertEquals("YY",findWidget("$tb2").getValue());
		Assert.assertEquals("A",findWidget("$l2").getValue());
		
		findWidget("$btn1").click();
		Assert.assertEquals("YY",findWidget("$tb1").getValue());
		Assert.assertEquals("YY",findWidget("$l1").getValue());
		Assert.assertEquals("YY",findWidget("$tb2").getValue());
		Assert.assertEquals("YY",findWidget("$l2").getValue());
		
		//test form init
		
		Assert.assertEquals("B",findWidget("$tb3").getValue());
		Assert.assertEquals("B",findWidget("$l31").getValue());
		Assert.assertEquals("B",findWidget("$l32").getValue());
		
		findWidget("$tb3").clear().keys("ZZ").tab();
		Assert.assertEquals("ZZ",findWidget("$tb3").getValue());
		Assert.assertEquals("B",findWidget("$l31").getValue());
		Assert.assertEquals("B",findWidget("$l32").getValue());
		
		findWidget("$btn2").click();
		Assert.assertEquals("ZZ",findWidget("$tb3").getValue());
		Assert.assertEquals("ZZ",findWidget("$l31").getValue());
		Assert.assertEquals("ZZ",findWidget("$l32").getValue());
	}

	@Test
	public void f0010(){
		navigate(getTestCaseUrl("/bind/issue/F0010.zul"));
		
		Assert.assertEquals("A-toUI-c0",findWidget("$l0").getValue());
		Assert.assertEquals("B-toUI-c1",findWidget("$l1").getValue());
		Assert.assertEquals("C-toUI-c2",findWidget("$l2").getValue());
		
		Assert.assertEquals("A-toUI-c0",findWidget("$t0").getValue());
		Assert.assertEquals("B-toUI-c1",findWidget("$t1").getValue());
		Assert.assertEquals("C-toUI-c2",findWidget("$t2").getValue());
		
		findWidget("$t0").clear().keys("I").tab();
		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$l0").getValue());
		Assert.assertEquals("B-toUI-c1",findWidget("$l1").getValue());
		Assert.assertEquals("C-toUI-c2",findWidget("$l2").getValue());
		
		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$t0").getValue());
		Assert.assertEquals("B-toUI-c1",findWidget("$t1").getValue());
		Assert.assertEquals("C-toUI-c2",findWidget("$t2").getValue());
		
		findWidget("$t1").clear().keys("J").tab();
		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$l0").getValue());
		Assert.assertEquals("J-toBean-c1-toUI-c1",findWidget("$l1").getValue());
		Assert.assertEquals("C-toUI-c2",findWidget("$l2").getValue());
		
		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$t0").getValue());
		Assert.assertEquals("J-toBean-c1-toUI-c1",findWidget("$t1").getValue());
		Assert.assertEquals("C-toUI-c2",findWidget("$t2").getValue());
		
		findWidget("$t2").clear().keys("K").tab();
		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$l0").getValue());
		Assert.assertEquals("J-toBean-c1-toUI-c1",findWidget("$l1").getValue());
		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$l2").getValue());
		
		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$t0").getValue());
		Assert.assertEquals("J-toBean-c1-toUI-c1",findWidget("$t1").getValue());
		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$t2").getValue());
		
		
		//test converter dependency
		findWidget("$t1").clear().keys("X").tab();
		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$l0").getValue());
		Assert.assertEquals("X-toBean-c1-toUI-c1",findWidget("$l1").getValue());//
		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$l2").getValue());
		
		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$t0").getValue());
		Assert.assertEquals("X-toBean-c1-toUI-c1",findWidget("$t1").getValue());//
		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$t2").getValue());
		
		findWidget("$btn1").click();
		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$l0").getValue());
		Assert.assertEquals("X-toBean-c1-toUI-c3",findWidget("$l1").getValue());//
		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$l2").getValue());
		
		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$t0").getValue());
		Assert.assertEquals("X-toBean-c1-toUI-c3",findWidget("$t1").getValue());//
		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$t2").getValue());
		
		findWidget("$t1").clear().keys("X").tab();
		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$l0").getValue());
		Assert.assertEquals("X-toBean-c3-toUI-c3",findWidget("$l1").getValue());//
		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$l2").getValue());
		
		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$t0").getValue());
		Assert.assertEquals("X-toBean-c3-toUI-c3",findWidget("$t1").getValue());//
		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$t2").getValue());
		
		findWidget("$btn2").click();
		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$l0").getValue());
		Assert.assertEquals("X-toBean-c3-toUI-c4",findWidget("$l1").getValue());//
		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$l2").getValue());
		
		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$t0").getValue());
		Assert.assertEquals("X-toBean-c3-toUI-c4",findWidget("$t1").getValue());//
		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$t2").getValue());
		
	}
	
	@Test
	public void f0011(){
		navigate(getTestCaseUrl("/bind/issue/F0011.zul"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date now = new Date();
		String today = sdf.format(now);
		String yesterday = sdf.format(new Date(now.getTime()-1000*60*60*24));
		String tomorrow = sdf.format(new Date(now.getTime()+1000*60*60*24));
		
		//validate date1
		
		Assert.assertEquals(today,findWidget("$db1").getText());
		Assert.assertEquals(today,findWidget("$lb11").getValue());
		Assert.assertEquals("",findWidget("$lb12").getValue());
		
		findWidget("$db1").clear().keys(tomorrow).tab();
		Assert.assertEquals(tomorrow,findWidget("$db1").getText());
		Assert.assertEquals(today,findWidget("$lb11").getValue());
		Assert.assertEquals("date bday1 must small than today",findWidget("$lb12").getValue());
		
		findWidget("$db1").clear().keys(yesterday).tab();
		Assert.assertEquals(yesterday,findWidget("$db1").getText());
		Assert.assertEquals(yesterday,findWidget("$lb11").getValue());
		Assert.assertEquals("",findWidget("$lb12").getValue());
		
		//validate date2
		
		Assert.assertEquals("",findWidget("$db2").getText());
		Assert.assertEquals("",findWidget("$lb21").getValue());
		Assert.assertEquals("",findWidget("$lb22").getValue());
		
		findWidget("$db2").clear().keys(yesterday).tab();
		Assert.assertEquals(yesterday,findWidget("$db2").getText());
		Assert.assertEquals("",findWidget("$lb21").getValue());
		Assert.assertEquals("date bday2 must large than today",findWidget("$lb22").getValue());
		
		findWidget("$db2").clear().keys(tomorrow).tab();
		Assert.assertEquals(tomorrow,findWidget("$db2").getText());
		Assert.assertEquals(tomorrow,findWidget("$lb21").getValue());
		Assert.assertEquals("",findWidget("$lb22").getValue());
	}
	
	@Test
	public void f0011_1(){
		navigate(getTestCaseUrl("/bind/issue/F0011.zul"));
		
		
		//validate property before command
		
		Assert.assertEquals("",findWidget("$tb31").getValue());
		Assert.assertEquals("",findWidget("$tb32").getValue());
		Assert.assertEquals("",findWidget("$lb31").getValue());
		Assert.assertEquals("",findWidget("$lb32").getValue());
		
		findWidget("$btn1").click();
		Assert.assertEquals("value1 is empty",findWidget("$lb32").getValue());
		
		findWidget("$tb31").keys("abc").tab();
		Assert.assertEquals("",findWidget("$lb31").getValue());
		Assert.assertEquals("value1 is empty",findWidget("$lb32").getValue());
		
		findWidget("$btn1").click();
		Assert.assertEquals("value2 must euqlas to value 1",findWidget("$lb32").getValue());
		
		findWidget("$tb32").keys("abc").tab();
		Assert.assertEquals("",findWidget("$lb31").getValue());
		Assert.assertEquals("value2 must euqlas to value 1",findWidget("$lb32").getValue());
		
		findWidget("$btn1").click();
		Assert.assertEquals("abc",findWidget("$lb31").getValue());
		Assert.assertEquals("do Command1",findWidget("$lb32").getValue());
	}
	
	@Test
	public void f0011_3(){
		navigate(getTestCaseUrl("/bind/issue/F0011.zul"));
		
		
		//validate property before command
		
		Assert.assertEquals("",findWidget("$tb51").getValue());
		Assert.assertEquals("",findWidget("$tb52").getValue());
		Assert.assertEquals("",findWidget("$lb51").getValue());
		Assert.assertEquals("",findWidget("$lb52").getValue());
		
		findWidget("$btn3").click();
		Assert.assertEquals("do Command3",findWidget("$lb52").getValue());
		
		findWidget("$tb51").keys("abc").tab();
		Assert.assertEquals("",findWidget("$lb51").getValue());
		Assert.assertEquals("do Command3",findWidget("$lb52").getValue());
		
		findWidget("$btn3").click();
		Assert.assertEquals("value2 must euqlas to value 1",findWidget("$lb52").getValue());
		
		findWidget("$tb52").clear().keys("def");
		findWidget("$btn3").click();
		Assert.assertEquals("",findWidget("$lb51").getValue());
		Assert.assertEquals("value2 must euqlas to value 1",findWidget("$lb52").getValue());
		
		
		findWidget("$tb52").clear().keys("abc").tab();
		findWidget("$btn3").click();
		Assert.assertEquals("abc",findWidget("$lb51").getValue());
		Assert.assertEquals("do Command3",findWidget("$lb52").getValue());
	}
	
	@Test
	public void f0011_2(){
		navigate(getTestCaseUrl("/bind/issue/F0011.zul"));
		
		
		//validate property before command
		
		Assert.assertEquals("",findWidget("$tb41").getValue());
		Assert.assertEquals("",findWidget("$tb42").getValue());
		Assert.assertEquals("",findWidget("$lb41").getValue());
		Assert.assertEquals("",findWidget("$lb42").getValue());
		
		findWidget("$btn2").click();
		Assert.assertEquals("",findWidget("$lb41").getValue());
		Assert.assertEquals("value3 is empty",findWidget("$lb42").getValue());
		
		findWidget("$tb41").keys("abc").tab();
		Assert.assertEquals("",findWidget("$lb41").getValue());
		Assert.assertEquals("",findWidget("$lb42").getValue());
		findWidget("$tb41").clear().tab();
		Assert.assertEquals("",findWidget("$lb41").getValue());
		Assert.assertEquals("value3 is empty",findWidget("$lb42").getValue());
		
		findWidget("$tb41").keys("abc").tab();
		findWidget("$btn2").click();
		Assert.assertEquals("",findWidget("$lb41").getValue());
		Assert.assertEquals("value4 is empty",findWidget("$lb42").getValue());
		
		findWidget("$tb42").keys("def").tab();
		Assert.assertEquals("",findWidget("$lb41").getValue());
		Assert.assertEquals("",findWidget("$lb42").getValue());
		
		findWidget("$btn2").click();
		Assert.assertEquals("",findWidget("$lb41").getValue());
		Assert.assertEquals("value4 must euqlas to value 3",findWidget("$lb42").getValue());
		
		findWidget("$tb42").clear().keys("abc").tab();
		Assert.assertEquals("",findWidget("$lb41").getValue());
		Assert.assertEquals("",findWidget("$lb42").getValue());
		
		findWidget("$btn2").click();
		Assert.assertEquals("abc",findWidget("$lb41").getValue());
		Assert.assertEquals("do Command2",findWidget("$lb42").getValue());
	}
	
	
	@Test
	public void f0013(){
		navigate(getTestCaseUrl("/bind/issue/F0013.zul"));
		
		Assert.assertEquals("A",findWidget("$l1").getValue());
		Assert.assertEquals("B",findWidget("$l2").getValue());
		
		Assert.assertEquals("A",findWidget("$t1").getValue());
		Assert.assertEquals("B",findWidget("$t2").getValue());
		
		findWidget("$t1").clear().keys("Dennis");
		findWidget("$t2").clear().keys("Chen");
		
		findWidget("$btn1").click();
		
		Assert.assertEquals("Dennis-cmd1",findWidget("$l1").getValue());
		Assert.assertEquals("Chen-cmd1",findWidget("$l2").getValue());
		
		Assert.assertEquals("Dennis",findWidget("$t1").getValue());
		Assert.assertEquals("Chen",findWidget("$t2").getValue());
		
		
		findWidget("$t1").clear().keys("Alice");
		findWidget("$t2").clear().keys("Wu");
		
		findWidget("$btn2").click();
		
		Assert.assertEquals("Alice-cmd2",findWidget("$l1").getValue());
		Assert.assertEquals("Wu-cmd2",findWidget("$l2").getValue());
		
		Assert.assertEquals("Alice-cmd2",findWidget("$t1").getValue());
		Assert.assertEquals("Wu-cmd2",findWidget("$t2").getValue());
		
		findWidget("$t1").clear().keys("Jumper");
		findWidget("$t2").clear().keys("Tj");
		
		findWidget("$btn3").click();
		
		Assert.assertEquals("Jumper-cmd3",findWidget("$l1").getValue());
		Assert.assertEquals("Tj-cmd3",findWidget("$l2").getValue());
		
		Assert.assertEquals("Jumper-cmd3",findWidget("$t1").getValue());
		Assert.assertEquals("Tj-cmd3",findWidget("$t2").getValue());
	}
	
	
	@Test
	public void f0012(){
		navigate(getTestCaseUrl("/bind/issue/F0015.zul"));
		
		Assert.assertEquals("A",findWidget("$l11").getValue());
		Assert.assertEquals("B",findWidget("$l12").getValue());
		Assert.assertEquals("C",findWidget("$l13").getValue());
		Assert.assertEquals("",findWidget("$l21").getValue());
		Assert.assertEquals("",findWidget("$l22").getValue());
		Assert.assertEquals("",findWidget("$l23").getValue());
		
		findWidget("$btn1").click();
		Assert.assertEquals("doCommand1",findWidget("$l11").getValue());
		Assert.assertEquals("B",findWidget("$l12").getValue());
		Assert.assertEquals("C",findWidget("$l13").getValue());
		Assert.assertEquals("doCommand1",findWidget("$l21").getValue());
		Assert.assertEquals("",findWidget("$l22").getValue());
		Assert.assertEquals("",findWidget("$l23").getValue());
		
		findWidget("$btn2").click();
		Assert.assertEquals("doCommand1",findWidget("$l11").getValue());
		Assert.assertEquals("doCommand2",findWidget("$l12").getValue());
		Assert.assertEquals("doCommand3",findWidget("$l13").getValue());
		Assert.assertEquals("doCommand1",findWidget("$l21").getValue());
		Assert.assertEquals("doCommand2",findWidget("$l22").getValue());
		Assert.assertEquals("doCommand3",findWidget("$l23").getValue());
	}
	
}
