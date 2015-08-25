package org.zkoss.bind.unitest2;

import org.junit.Assert;
import org.junit.Test;
import org.zkoss.zktc.core.junit.TestCaseBase;
/**
 * 
 * @author dennis
 *
 */
public class ParamTestCase extends TestCaseBase{

	@Test
	public void testHttpParam(){
		navigate(getTestCaseUrl("/bind/basic/httpparam.zul?param1=foo"));//param is not available in ztltest
		
		
		findWidget("$cmd1").click();
		
		Assert.assertNotNull(findWidget("$l11").getValue());
		Assert.assertNotNull(findWidget("$l12").getValue());
		Assert.assertNotNull(findWidget("$l13").getValue());
		
		Assert.assertFalse("".equals(findWidget("$l11").getValue().toString().trim()));
		Assert.assertFalse("".equals(findWidget("$l12").getValue().toString().trim()));
		Assert.assertFalse("".equals(findWidget("$l13").getValue().toString().trim()));
		
	}
	
	@Test
	public void testExecutionParam(){
		navigate(getTestCaseUrl("/bind/basic/executionparam.zul"));
		findWidget("$btn1").click();
		
		Assert.assertEquals("foo",findWidget("$w1 $l11").getValue());
		Assert.assertEquals("bar",findWidget("$w1 $l12").getValue());
		
		findWidget("$w1 $cmd1").click();
		Assert.assertEquals("",findWidget("$w1 $l11").getValue());
		Assert.assertEquals("",findWidget("$w1 $l12").getValue());
		
		findWidget("$btn2").click();
		
		Assert.assertEquals("abc",findWidget("$w2 $l11").getValue());
		Assert.assertEquals("goo",findWidget("$w2 $l12").getValue());
		
		findWidget("$w2 $cmd1").click();
		Assert.assertEquals("",findWidget("$w2 $l11").getValue());
		Assert.assertEquals("",findWidget("$w2 $l12").getValue());
	}
	
	@Test
	public void testScopeParam(){
		navigate(getTestCaseUrl("/bind/basic/scopeparam.zul"));
		
		Assert.assertEquals("applicationScope-A",findWidget("$l11").getValue());
		Assert.assertEquals("sessionScope-A",findWidget("$l12").getValue());
		Assert.assertEquals("desktopScope-A",findWidget("$l13").getValue());
		Assert.assertEquals("spaceScopeScope-A",findWidget("$l14").getValue());
		Assert.assertEquals("requestScope-A",findWidget("$l15").getValue());
		
		Assert.assertEquals("B",findWidget("$l16").getValue());
		Assert.assertEquals("C",findWidget("$l17").getValue());
		Assert.assertEquals("E",findWidget("$l18").getValue());
		Assert.assertEquals("",findWidget("$l19").getValue());
		
		
		findWidget("$cmd1").click();
		Assert.assertEquals("applicationScope-A",findWidget("$l11").getValue());
		Assert.assertEquals("sessionScope-A",findWidget("$l12").getValue());
		Assert.assertEquals("desktopScope-A",findWidget("$l13").getValue());
		Assert.assertEquals("spaceScopeScope-A",findWidget("$l14").getValue());
		Assert.assertEquals("",findWidget("$l15").getValue());
		
		Assert.assertEquals("F",findWidget("$l16").getValue());
		Assert.assertEquals("C",findWidget("$l17").getValue());
		Assert.assertEquals("E",findWidget("$l18").getValue());
		Assert.assertEquals("G",findWidget("$l19").getValue());
		
		
		findWidget("$cmd2").click();
		Assert.assertEquals("var2 by Desktop",findWidget("$l11").getValue());
		Assert.assertEquals("var1 by Desktop",findWidget("$l12").getValue());
		Assert.assertEquals("desktopScope-A",findWidget("$l13").getValue());
		Assert.assertEquals("spaceScopeScope-A",findWidget("$l14").getValue());
		Assert.assertEquals("",findWidget("$l15").getValue());
		
		Assert.assertEquals("F",findWidget("$l16").getValue());
		Assert.assertEquals("C",findWidget("$l17").getValue());
		Assert.assertEquals("E",findWidget("$l18").getValue());
		Assert.assertEquals("G",findWidget("$l19").getValue());
		
		
		findWidget("$cmd3").click();
		Assert.assertEquals("applicationScope-A",findWidget("$l11").getValue());
		Assert.assertEquals("sessionScope-A",findWidget("$l12").getValue());
		Assert.assertEquals("desktopScope-A",findWidget("$l13").getValue());
		Assert.assertEquals("spaceScopeScope-A",findWidget("$l14").getValue());
		Assert.assertEquals("",findWidget("$l15").getValue());
		
		Assert.assertEquals("F",findWidget("$l16").getValue());
		Assert.assertEquals("C",findWidget("$l17").getValue());
		Assert.assertEquals("E",findWidget("$l18").getValue());
		Assert.assertEquals("G",findWidget("$l19").getValue());
		
		findWidget("$cmd2").click();
		Assert.assertEquals("var2 by Desktop",findWidget("$l11").getValue());
		Assert.assertEquals("var1 by Desktop",findWidget("$l12").getValue());
		Assert.assertEquals("desktopScope-A",findWidget("$l13").getValue());
		Assert.assertEquals("spaceScopeScope-A",findWidget("$l14").getValue());
		Assert.assertEquals("",findWidget("$l15").getValue());
		
		Assert.assertEquals("F",findWidget("$l16").getValue());
		Assert.assertEquals("C",findWidget("$l17").getValue());
		Assert.assertEquals("E",findWidget("$l18").getValue());
		Assert.assertEquals("G",findWidget("$l19").getValue());
	}
	
	@Test
	public void testSelectorParam(){
		navigate(getTestCaseUrl("/bind/basic/selectorparam.zul"));
		
		Assert.assertEquals("Init 0",findWidget("$l11").getValue());
		Assert.assertEquals("Init 1",findWidget("$l12").getValue());
		Assert.assertEquals("Init 2",findWidget("$l13").getValue());
		Assert.assertEquals("Init 3:4",findWidget("$l14").getValue());
		
		findWidget("$cmd1").click();
		Assert.assertEquals("Command 0",findWidget("$l11").getValue());
		Assert.assertEquals("Command 1",findWidget("$l12").getValue());
		Assert.assertEquals("Command 2:3",findWidget("$l13").getValue());
		Assert.assertEquals("Command 3",findWidget("$l14").getValue());
		
		findWidget("$cmd2").click();
		Assert.assertEquals("size 0",findWidget("$cmd2").getLabel());
	}
	
	
	@Test
	public void testContextParam(){
		navigate(getTestCaseUrl("/bind/basic/contextparam.zul"));
		
		Assert.assertEquals("applicationScope-A",findWidget("$l11").getValue());
		Assert.assertEquals("sessionScope-A",findWidget("$l12").getValue());
		Assert.assertEquals("desktopScope-A",findWidget("$l13").getValue());
		Assert.assertEquals("spaceScope-A",findWidget("$l14").getValue());
		Assert.assertEquals("requestScope-A",findWidget("$l15").getValue());
		Assert.assertEquals("componentScope-B",findWidget("$l16").getValue());
		Assert.assertEquals("vbox1",findWidget("$l17").getValue());
		Assert.assertEquals("vbox1",findWidget("$l18").getValue());
		Assert.assertEquals("true",findWidget("$l19").getValue());
		Assert.assertEquals("true",findWidget("$l1a").getValue());

		
		findWidget("$cmd1").click();
		Assert.assertEquals("applicationScope-A",findWidget("$l11").getValue());
		Assert.assertEquals("sessionScope-A",findWidget("$l12").getValue());
		Assert.assertEquals("desktopScope-A",findWidget("$l13").getValue());
		Assert.assertEquals("spaceScope-A",findWidget("$l14").getValue());
		Assert.assertEquals("",findWidget("$l15").getValue());
		Assert.assertEquals("componentScope-C",findWidget("$l16").getValue());
		Assert.assertEquals("cmd1",findWidget("$l17").getValue());
		Assert.assertEquals("vbox1",findWidget("$l18").getValue());
		Assert.assertEquals("false",findWidget("$l19").getValue());
		Assert.assertEquals("false",findWidget("$l1a").getValue());

		
		
		findWidget("$cmd2").click();
		Assert.assertEquals("var2 by Desktop",findWidget("$l11").getValue());
		Assert.assertEquals("var1 by Desktop",findWidget("$l12").getValue());
		Assert.assertEquals("desktopScope-A",findWidget("$l13").getValue());
		Assert.assertEquals("spaceScope-Y",findWidget("$l14").getValue());
		Assert.assertEquals("",findWidget("$l15").getValue());
		Assert.assertEquals("componentScope-C",findWidget("$l16").getValue());
		Assert.assertEquals("cmd2",findWidget("$l17").getValue());
		Assert.assertEquals("vbox1",findWidget("$l18").getValue());
		Assert.assertEquals("false",findWidget("$l19").getValue());
		Assert.assertEquals("false",findWidget("$l1a").getValue());

		
		
		findWidget("$cmd3").click();
		Assert.assertEquals("applicationScope-A",findWidget("$l11").getValue());
		Assert.assertEquals("sessionScope-A",findWidget("$l12").getValue());
		Assert.assertEquals("desktopScope-A",findWidget("$l13").getValue());
		Assert.assertEquals("spaceScope-Y",findWidget("$l14").getValue());
		Assert.assertEquals("",findWidget("$l15").getValue());
		Assert.assertEquals("componentScope-C",findWidget("$l16").getValue());
		Assert.assertEquals("cmd3",findWidget("$l17").getValue());
		Assert.assertEquals("vbox1",findWidget("$l18").getValue());
		Assert.assertEquals("false",findWidget("$l19").getValue());
		Assert.assertEquals("false",findWidget("$l1a").getValue());
	}
}
