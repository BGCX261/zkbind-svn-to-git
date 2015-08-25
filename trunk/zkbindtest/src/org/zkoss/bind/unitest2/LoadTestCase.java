package org.zkoss.bind.unitest2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.zkoss.zktc.core.junit.TestCaseBase;
import org.zkoss.zktc.core.widget.Widgets;

public class LoadTestCase extends TestCaseBase{

	
	@Test
	public void testLoad(){
		navigate(getTestCaseUrl("/bind/basic/load.zul"));
		
		Assert.assertEquals("First1",findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("First1 Last1",findWidget("$l3").getAttribute("value"));
		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l4").getAttribute("value"));
		
		Assert.assertEquals("First1",findWidget("$l5").getAttribute("value"));
		Assert.assertEquals("Last1",findWidget("$l6").getAttribute("value"));
		Assert.assertEquals("First1 Last1",findWidget("$l7").getAttribute("value"));
		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l8").getAttribute("value"));
		
		findWidget("$btn1").click();
		
		Assert.assertEquals("Dennis",findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("Dennis Last1",findWidget("$l3").getAttribute("value"));
		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l4").getAttribute("value"));
		
		Assert.assertEquals("Dennis",findWidget("$l5").getAttribute("value"));
		Assert.assertEquals("Last1",findWidget("$l6").getAttribute("value"));
		Assert.assertEquals("Dennis Last1",findWidget("$l7").getAttribute("value"));
		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l8").getAttribute("value"));
		
		findWidget("$btn2").click();
		
		Assert.assertEquals("Dennis",findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("Chen",findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("Dennis Chen",findWidget("$l3").getAttribute("value"));
		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l4").getAttribute("value"));
		
		Assert.assertEquals("Dennis",findWidget("$l5").getAttribute("value"));
		Assert.assertEquals("Chen",findWidget("$l6").getAttribute("value"));
		Assert.assertEquals("Dennis Chen",findWidget("$l7").getAttribute("value"));
		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l8").getAttribute("value"));
		
		findWidget("$btn3").click();
		
		Assert.assertEquals("Alex",findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("Chen",findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("Alex Chen",findWidget("$l3").getAttribute("value"));
		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l4").getAttribute("value"));
		
		Assert.assertEquals("Alex",findWidget("$l5").getAttribute("value"));
		Assert.assertEquals("Chen",findWidget("$l6").getAttribute("value"));
		Assert.assertEquals("Alex Chen",findWidget("$l7").getAttribute("value"));
		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l8").getAttribute("value"));
		
		findWidget("$btn4").click();
		
		Assert.assertEquals("Alex",findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("Wang",findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("Alex Wang",findWidget("$l3").getAttribute("value"));
		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l4").getAttribute("value"));
		
		Assert.assertEquals("Alex",findWidget("$l5").getAttribute("value"));
		Assert.assertEquals("Wang",findWidget("$l6").getAttribute("value"));
		Assert.assertEquals("Alex Wang",findWidget("$l7").getAttribute("value"));
		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l8").getAttribute("value"));
		
		
		findWidget("$btn5").click();
		
		Assert.assertEquals("Alex",findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("Chen",findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("Alex Chen",findWidget("$l3").getAttribute("value"));
		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l4").getAttribute("value"));
		
		Assert.assertEquals("Alex",findWidget("$l5").getAttribute("value"));
		Assert.assertEquals("Chen",findWidget("$l6").getAttribute("value"));
		Assert.assertEquals("Alex Chen",findWidget("$l7").getAttribute("value"));
		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l8").getAttribute("value"));
		

		findWidget("$btn6").click();
		
		Assert.assertEquals("Alex",findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("Wang",findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("Alex Wang",findWidget("$l3").getAttribute("value"));
		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l4").getAttribute("value"));
		
		Assert.assertEquals("Alex",findWidget("$l5").getAttribute("value"));
		Assert.assertEquals("Wang",findWidget("$l6").getAttribute("value"));
		Assert.assertEquals("Alex Wang",findWidget("$l7").getAttribute("value"));
		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l8").getAttribute("value"));
		

		//we have spec change here since 10/29, revision 18, notify p1 will also cause selected reload(they are same instance)
		findWidget("$btn7").click();
		
		Assert.assertEquals("Ian",findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("Tasi",findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("Ian Tasi",findWidget("$l3").getAttribute("value"));
		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l4").getAttribute("value"));
		
//		Assert.assertEquals("Alex",findWidget("$l5").getAttribute("value"));
//		Assert.assertEquals("Wang",findWidget("$l6").getAttribute("value"));
//		Assert.assertEquals("Alex Wang",findWidget("$l7").getAttribute("value"));
//		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l8").getAttribute("value"));
		Assert.assertEquals("Ian",findWidget("$l5").getAttribute("value"));
		Assert.assertEquals("Tasi",findWidget("$l6").getAttribute("value"));
		Assert.assertEquals("Ian Tasi",findWidget("$l7").getAttribute("value"));
		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l8").getAttribute("value"));
		
		//we have spec change here since 10/29, revision 18, notify selected will also cause p1 reload(they are same instance)
		findWidget("$btn8").click();

		Assert.assertEquals("Jumper",findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("Chen",findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("Jumper Chen",findWidget("$l3").getAttribute("value"));
		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l4").getAttribute("value"));
		
//		Assert.assertEquals("Ian",findWidget("$l1").getAttribute("value"));
//		Assert.assertEquals("Tasi",findWidget("$l2").getAttribute("value"));
//		Assert.assertEquals("Ian Tasi",findWidget("$l3").getAttribute("value"));
//		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l4").getAttribute("value"));
		
		Assert.assertEquals("Jumper",findWidget("$l5").getAttribute("value"));
		Assert.assertEquals("Chen",findWidget("$l6").getAttribute("value"));
		Assert.assertEquals("Jumper Chen",findWidget("$l7").getAttribute("value"));
		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei",findWidget("$l8").getAttribute("value"));
	}
	
	
	@Test
	public void testIndirect1(){
		navigate(getTestCaseUrl("/bind/basic/load-indirect.zul"));
		
		Assert.assertEquals("First1",findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("First1 Last1",findWidget("$l3").getAttribute("value"));
		Assert.assertEquals("First1",findWidget("$l4").getAttribute("value"));
		Assert.assertEquals(0L,findWidget("$select").getAttribute("selectedIndex"));
		
		
		findWidget("$l1").clear().keys("AAA");
		findWidget("$btn1").focus();
		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("AAA Last1",findWidget("$l3").getAttribute("value"));
		Assert.assertEquals("AAA",findWidget("$l4").getAttribute("value"));
		
		
		
		findWidget("$btn2").click();
		
		Assert.assertEquals("AAA",findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("AAA Last1",findWidget("$l3").getAttribute("value"));
		Assert.assertEquals("Last1",findWidget("$l4").getAttribute("value"));
		Assert.assertEquals(1L,findWidget("$select").getAttribute("selectedIndex"));
		
		findWidget("$l1").clear().keys("BBB");
		findWidget("$btn1").focus();
		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("BBB Last1",findWidget("$l3").getAttribute("value"));
		Assert.assertEquals("Last1",findWidget("$l4").getAttribute("value"));
		
		
		findWidget("$btn3").click();
		
		Assert.assertEquals("BBB",findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("BBB Last1",findWidget("$l3").getAttribute("value"));
		Assert.assertEquals("BBB Last1",findWidget("$l4").getAttribute("value"));
		Assert.assertEquals(2L,findWidget("$select").getAttribute("selectedIndex"));
		
		findWidget("$btn1").click();
		
		Assert.assertEquals("BBB",findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("BBB Last1",findWidget("$l3").getAttribute("value"));
		Assert.assertEquals("BBB",findWidget("$l4").getAttribute("value"));
		Assert.assertEquals(0L,findWidget("$select").getAttribute("selectedIndex"));
		
		
	}
	
	@Test
	public void testIndirect2(){
		navigate(getTestCaseUrl("/bind/basic/load-indirect.zul"));
		
		Assert.assertEquals("First1",findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("First1 Last1",findWidget("$l3").getAttribute("value"));
		Assert.assertEquals("First1",findWidget("$l4").getAttribute("value"));
		Assert.assertEquals(0L,findWidget("$select").getAttribute("selectedIndex"));
		
		
		findWidget("$l1").clear().keys("AAA");
		findWidget("$btn1").focus();
		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("AAA Last1",findWidget("$l3").getAttribute("value"));
		Assert.assertEquals("AAA",findWidget("$l4").getAttribute("value"));
		
		
		
		Widgets.toSelectWidget(findWidget("$select")).select(1);
		
		Assert.assertEquals("AAA",findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("AAA Last1",findWidget("$l3").getAttribute("value"));
		Assert.assertEquals("Last1",findWidget("$l4").getAttribute("value"));
		Assert.assertEquals(1L,findWidget("$select").getAttribute("selectedIndex"));
		
		findWidget("$l1").clear().keys("BBB");
		findWidget("$btn1").focus();
		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("BBB Last1",findWidget("$l3").getAttribute("value"));
		Assert.assertEquals("Last1",findWidget("$l4").getAttribute("value"));
		
		
		Widgets.toSelectWidget(findWidget("$select")).select(2);
		
		Assert.assertEquals("BBB",findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("BBB Last1",findWidget("$l3").getAttribute("value"));
		Assert.assertEquals("BBB Last1",findWidget("$l4").getAttribute("value"));
		Assert.assertEquals(2L,findWidget("$select").getAttribute("selectedIndex"));
		
		Widgets.toSelectWidget(findWidget("$select")).select(0);
		
		Assert.assertEquals("BBB",findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("BBB Last1",findWidget("$l3").getAttribute("value"));
		Assert.assertEquals("BBB",findWidget("$l4").getAttribute("value"));
		Assert.assertEquals(0L,findWidget("$select").getAttribute("selectedIndex"));
		
		
	}
	
	@Test
	public void testProperty(){
		navigate(getTestCaseUrl("/bind/basic/property.zul"));
		
		Assert.assertEquals("A",findWidget("$t1").getAttribute("value"));
		Assert.assertEquals("A",findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("",findWidget("$l1x").getAttribute("value"));
		
		findWidget("$t1").keys("XX");
		findWidget("$cmd1").focus();
		Assert.assertEquals("AXX",findWidget("$t1").getAttribute("value"));
		Assert.assertEquals("AXX",findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("",findWidget("$l1x").getAttribute("value"));
	
		findWidget("$cmd1").click();
		Assert.assertEquals("AXX",findWidget("$t1").getAttribute("value"));
		Assert.assertEquals("AXX",findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("AXX",findWidget("$l1x").getAttribute("value"));
		
		//test 2
		Assert.assertEquals("",findWidget("$t2").getAttribute("value"));
		Assert.assertEquals("B",findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("",findWidget("$l2x").getAttribute("value"));
		
		findWidget("$t2").keys("YY");
		findWidget("$cmd2").focus();
		Assert.assertEquals("YY",findWidget("$t2").getAttribute("value"));
		Assert.assertEquals("YY",findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("",findWidget("$l2x").getAttribute("value"));
		
		findWidget("$cmd2").click();
		Assert.assertEquals("YY-by-cmd2",findWidget("$t2").getAttribute("value"));
		Assert.assertEquals("YY",findWidget("$l2").getAttribute("value"));
		Assert.assertEquals("YY-by-cmd2",findWidget("$l2x").getAttribute("value"));
		
		//test 3
		Assert.assertEquals("C",findWidget("$t3").getAttribute("value"));
		Assert.assertEquals("",findWidget("$l3").getAttribute("value"));
		Assert.assertEquals("",findWidget("$l3x").getAttribute("value"));
		
		findWidget("$t3").keys("ZZ");
		findWidget("$cmd3").focus();
		Assert.assertEquals("CZZ",findWidget("$t3").getAttribute("value"));
		Assert.assertEquals("",findWidget("$l3").getAttribute("value"));
		Assert.assertEquals("",findWidget("$l3x").getAttribute("value"));
		
		findWidget("$cmd3").click();
		Assert.assertEquals("CZZ-by-cmd3",findWidget("$t3").getAttribute("value"));
		Assert.assertEquals("CZZ",findWidget("$l3").getAttribute("value"));
		Assert.assertEquals("CZZ-by-cmd3",findWidget("$l3x").getAttribute("value"));
		
		findWidget("$t3").clear().keys("GG");
		findWidget("$cmd3").focus();
		Assert.assertEquals("GG",findWidget("$t3").getAttribute("value"));
		Assert.assertEquals("CZZ",findWidget("$l3").getAttribute("value"));
		Assert.assertEquals("CZZ-by-cmd3",findWidget("$l3x").getAttribute("value"));
		
		findWidget("$change3").click();
		Assert.assertEquals("CZZ-by-cmd3-by-change3",findWidget("$t3").getAttribute("value"));
		Assert.assertEquals("CZZ",findWidget("$l3").getAttribute("value"));
		Assert.assertEquals("CZZ-by-cmd3",findWidget("$l3x").getAttribute("value"));
	}
	
	@Test
	public void testConverter(){
		navigate(getTestCaseUrl("/bind/basic/converter.zul"));
		
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse("1975/02/13"));
		} catch (ParseException e) {}
		String age1 = "" + (Calendar.getInstance().get(Calendar.YEAR) - c.get(Calendar.YEAR));
		try {
			c.setTime(sdf.parse("1980/02/13"));
		} catch (ParseException e) {}
		String age2 = "" + (Calendar.getInstance().get(Calendar.YEAR) - c.get(Calendar.YEAR));
		try {
			c.setTime(sdf.parse("1985/02/13"));
		} catch (ParseException e) {}
		String age3 = "" + (Calendar.getInstance().get(Calendar.YEAR) - c.get(Calendar.YEAR));
		
		
		Assert.assertEquals("1975/02/13",findWidget("$t1").getAttribute("value"));
		Assert.assertEquals(age1,findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("1975/02/13",findWidget("$t2").getAttribute("value"));
		Assert.assertEquals(age1,findWidget("$l2").getAttribute("value"));
		
		findWidget("$t1").clear().keys("1980/02/AA");
		findWidget("$saveForm").focus();
		
		Assert.assertEquals("",findWidget("$t1").getAttribute("value"));
		Assert.assertEquals("0",findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("1975/02/13",findWidget("$t2").getAttribute("value"));
		Assert.assertEquals(age1,findWidget("$l2").getAttribute("value"));
		
		
		findWidget("$t1").clear().keys("1980/02/13");
		findWidget("$saveForm").focus();
		
		Assert.assertEquals("1980/02/13",findWidget("$t1").getAttribute("value"));
		Assert.assertEquals(age2,findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("1975/02/13",findWidget("$t2").getAttribute("value"));
		Assert.assertEquals(age1,findWidget("$l2").getAttribute("value"));
		
		
		findWidget("$t2").clear().keys("1985/02/13");
		findWidget("$saveForm").focus();
		
		Assert.assertEquals("1980/02/13",findWidget("$t1").getAttribute("value"));
		Assert.assertEquals(age2,findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("1985/02/13",findWidget("$t2").getAttribute("value"));
		Assert.assertEquals(age1,findWidget("$l2").getAttribute("value"));
		
		findWidget("$saveForm").click();
		
		Assert.assertEquals("1985/02/13",findWidget("$t1").getAttribute("value"));
		Assert.assertEquals(age3,findWidget("$l1").getAttribute("value"));
		Assert.assertEquals("1985/02/13",findWidget("$t2").getAttribute("value"));
		Assert.assertEquals(age3,findWidget("$l2").getAttribute("value"));
		
		
	}
	
	@Test
	public void testValidation1(){
		navigate(getTestCaseUrl("/bind/basic/validation.zul"));
		
		Assert.assertEquals("0",findWidget("$l11").getValue());
		Assert.assertEquals("",findWidget("$l12").getValue());
		Assert.assertEquals("0",findWidget("$t21").getValue());
		Assert.assertEquals("",findWidget("$t22").getValue());
		Assert.assertEquals("0",findWidget("$t31").getValue());
		Assert.assertEquals("",findWidget("$t32").getValue());
		Assert.assertEquals("",findWidget("$msg1").getValue());
		Assert.assertEquals("",findWidget("$msg2").getValue());
		
		findWidget("$t21").clear().keys("1").tab();
		Assert.assertEquals("0",findWidget("$l11").getValue());
		Assert.assertEquals("",findWidget("$l12").getValue());
		Assert.assertEquals("1",findWidget("$t21").getValue());
		Assert.assertEquals("",findWidget("$t22").getValue());
		Assert.assertEquals("0",findWidget("$t31").getValue());
		Assert.assertEquals("",findWidget("$t32").getValue());
		Assert.assertEquals("value 1 have to large than 10",findWidget("$msg1").getValue());
		Assert.assertEquals("",findWidget("$msg2").getValue());
		
		findWidget("$t21").clear().keys("12").tab();
		Assert.assertEquals("12",findWidget("$l11").getValue());
		Assert.assertEquals("",findWidget("$l12").getValue());
		Assert.assertEquals("12",findWidget("$t21").getValue());
		Assert.assertEquals("",findWidget("$t22").getValue());
		Assert.assertEquals("12",findWidget("$t31").getValue());
		Assert.assertEquals("",findWidget("$t32").getValue());
		Assert.assertEquals("",findWidget("$msg1").getValue());
		Assert.assertEquals("",findWidget("$msg2").getValue());
		
		
		findWidget("$t22").clear().keys("3").tab();
		Assert.assertEquals("12",findWidget("$l11").getValue());
		Assert.assertEquals("",findWidget("$l12").getValue());
		Assert.assertEquals("12",findWidget("$t21").getValue());
		Assert.assertEquals("3",findWidget("$t22").getValue());
		Assert.assertEquals("12",findWidget("$t31").getValue());
		Assert.assertEquals("",findWidget("$t32").getValue());
		Assert.assertEquals("",findWidget("$msg1").getValue());
		Assert.assertEquals("value 2 have to large than 20",findWidget("$msg2").getValue());
		
		findWidget("$t22").clear().keys("33").tab();
		Assert.assertEquals("12",findWidget("$l11").getValue());
		Assert.assertEquals("33",findWidget("$l12").getValue());
		Assert.assertEquals("12",findWidget("$t21").getValue());
		Assert.assertEquals("33",findWidget("$t22").getValue());
		Assert.assertEquals("12",findWidget("$t31").getValue());
		Assert.assertEquals("33",findWidget("$t32").getValue());
		Assert.assertEquals("",findWidget("$msg1").getValue());
		Assert.assertEquals("",findWidget("$msg2").getValue());
	}
	
	@Test
	public void testValidation2() {
		navigate(getTestCaseUrl("/bind/basic/validation.zul"));

		Assert.assertEquals("0", findWidget("$l11").getValue());
		Assert.assertEquals("", findWidget("$l12").getValue());
		Assert.assertEquals("0", findWidget("$t21").getValue());
		Assert.assertEquals("", findWidget("$t22").getValue());
		Assert.assertEquals("0", findWidget("$t31").getValue());
		Assert.assertEquals("", findWidget("$t32").getValue());
		Assert.assertEquals("", findWidget("$msg1").getValue());
		Assert.assertEquals("", findWidget("$msg2").getValue());

		findWidget("$t31").clear().keys("1").tab();
		Assert.assertEquals("0", findWidget("$l11").getValue());
		Assert.assertEquals("", findWidget("$l12").getValue());
		Assert.assertEquals("0", findWidget("$t21").getValue());
		Assert.assertEquals("", findWidget("$t22").getValue());
		Assert.assertEquals("1", findWidget("$t31").getValue());
		Assert.assertEquals("", findWidget("$t32").getValue());
		Assert.assertEquals("", findWidget("$msg1").getValue());
		Assert.assertEquals("", findWidget("$msg2").getValue());

		findWidget("$t32").clear().keys("3").tab();
		Assert.assertEquals("0", findWidget("$l11").getValue());
		Assert.assertEquals("", findWidget("$l12").getValue());
		Assert.assertEquals("0", findWidget("$t21").getValue());
		Assert.assertEquals("", findWidget("$t22").getValue());
		Assert.assertEquals("1", findWidget("$t31").getValue());
		Assert.assertEquals("3", findWidget("$t32").getValue());
		Assert.assertEquals("", findWidget("$msg1").getValue());
		Assert.assertEquals("", findWidget("$msg2").getValue());

		findWidget("$btn1").click();
		Assert.assertEquals("0", findWidget("$l11").getValue());
		Assert.assertEquals("", findWidget("$l12").getValue());
		Assert.assertEquals("0", findWidget("$t21").getValue());
		Assert.assertEquals("", findWidget("$t22").getValue());
		Assert.assertEquals("1", findWidget("$t31").getValue());
		Assert.assertEquals("3", findWidget("$t32").getValue());
		Assert.assertEquals("value 1 have to large than 10",
				findWidget("$msg1").getValue());
		Assert.assertEquals("", findWidget("$msg2").getValue());

		findWidget("$t31").clear().keys("15").tab();
		Assert.assertEquals("0", findWidget("$l11").getValue());
		Assert.assertEquals("", findWidget("$l12").getValue());
		Assert.assertEquals("0", findWidget("$t21").getValue());
		Assert.assertEquals("", findWidget("$t22").getValue());
		Assert.assertEquals("15", findWidget("$t31").getValue());
		Assert.assertEquals("3", findWidget("$t32").getValue());
		Assert.assertEquals("value 1 have to large than 10",
				findWidget("$msg1").getValue());
		Assert.assertEquals("", findWidget("$msg2").getValue());

		findWidget("$btn1").click();
		Assert.assertEquals("0", findWidget("$l11").getValue());
		Assert.assertEquals("", findWidget("$l12").getValue());
		Assert.assertEquals("0", findWidget("$t21").getValue());
		Assert.assertEquals("", findWidget("$t22").getValue());
		Assert.assertEquals("15", findWidget("$t31").getValue());
		Assert.assertEquals("3", findWidget("$t32").getValue());
		Assert.assertEquals("", findWidget("$msg1").getValue());
		Assert.assertEquals("value 2 have to large than 20",
				findWidget("$msg2").getValue());

		findWidget("$t32").clear().keys("35").tab();
		Assert.assertEquals("0", findWidget("$l11").getValue());
		Assert.assertEquals("", findWidget("$l12").getValue());
		Assert.assertEquals("0", findWidget("$t21").getValue());
		Assert.assertEquals("", findWidget("$t22").getValue());
		Assert.assertEquals("15", findWidget("$t31").getValue());
		Assert.assertEquals("35", findWidget("$t32").getValue());
		Assert.assertEquals("", findWidget("$msg1").getValue());
		Assert.assertEquals("value 2 have to large than 20",
				findWidget("$msg2").getValue());

		findWidget("$btn1").click();
		Assert.assertEquals("15", findWidget("$l11").getValue());
		Assert.assertEquals("35", findWidget("$l12").getValue());
		Assert.assertEquals("15", findWidget("$t21").getValue());
		Assert.assertEquals("35", findWidget("$t22").getValue());
		Assert.assertEquals("15", findWidget("$t31").getValue());
		Assert.assertEquals("35", findWidget("$t32").getValue());
		Assert.assertEquals("", findWidget("$msg1").getValue());
		Assert.assertEquals("", findWidget("$msg2").getValue());
	}
	
}
