package org.zkoss.bind.unitest2;

import junit.framework.Assert;

import org.junit.Test;
import org.zkoss.zktc.core.junit.TestCaseBase;

public class LoadSaveTestCase extends TestCaseBase{

	
	@Test
	public void testLoadSaveProperty() {
		navigate(getTestCaseUrl("/bind/basic/load-save-property.zul"));
		
		 Assert.assertEquals("A", findWidget("$l11").getValue());
		 Assert.assertEquals("B", findWidget("$l12").getValue());
		 Assert.assertEquals("C", findWidget("$l13").getValue());
		 Assert.assertEquals("A", findWidget("$l14").getValue());
		 Assert.assertEquals("B", findWidget("$l15").getValue());
		 Assert.assertEquals("C", findWidget("$l16").getValue());
		 
		 findWidget("$t21").clear().keys("X").tab();
		 Assert.assertEquals("A", findWidget("$l11").getValue());
		 Assert.assertEquals("X", findWidget("$l12").getValue());
		 Assert.assertEquals("C", findWidget("$l13").getValue());
		 Assert.assertEquals("X", findWidget("$l14").getValue());
		 Assert.assertEquals("X", findWidget("$l15").getValue());
		 Assert.assertEquals("X", findWidget("$l16").getValue());
		
		
		 findWidget("$t22").clear().keys("Y").tab();
		 Assert.assertEquals("A", findWidget("$l11").getValue());
		 Assert.assertEquals("X", findWidget("$l12").getValue());
		 Assert.assertEquals("Y", findWidget("$l13").getValue());
		 Assert.assertEquals("Y", findWidget("$l14").getValue());
		 Assert.assertEquals("X", findWidget("$l15").getValue());
		 Assert.assertEquals("Y", findWidget("$l16").getValue());
		 
		 findWidget("$t23").clear().keys("Z").tab();
		 Assert.assertEquals("A", findWidget("$l11").getValue());
		 Assert.assertEquals("X", findWidget("$l12").getValue());
		 Assert.assertEquals("Y", findWidget("$l13").getValue());
		 Assert.assertEquals("Z", findWidget("$l14").getValue());
		 Assert.assertEquals("X", findWidget("$l15").getValue());
		 Assert.assertEquals("Y", findWidget("$l16").getValue());
		 
		 findWidget("$btn1").click();
		 Assert.assertEquals("A", findWidget("$l11").getValue());
		 Assert.assertEquals("Z", findWidget("$l12").getValue());
		 Assert.assertEquals("Y", findWidget("$l13").getValue());
		 Assert.assertEquals("Z", findWidget("$l14").getValue());
		 Assert.assertEquals("Z", findWidget("$l15").getValue());
		 Assert.assertEquals("Z", findWidget("$l16").getValue());
		 
		 
		 findWidget("$t23").clear().keys("G").tab();
		 Assert.assertEquals("A", findWidget("$l11").getValue());
		 Assert.assertEquals("Z", findWidget("$l12").getValue());
		 Assert.assertEquals("Y", findWidget("$l13").getValue());
		 Assert.assertEquals("G", findWidget("$l14").getValue());
		 Assert.assertEquals("Z", findWidget("$l15").getValue());
		 Assert.assertEquals("Z", findWidget("$l16").getValue());
		 
		 findWidget("$btn2").click();
		 Assert.assertEquals("A", findWidget("$l11").getValue());
		 Assert.assertEquals("Z", findWidget("$l12").getValue());
		 Assert.assertEquals("G", findWidget("$l13").getValue());
		 Assert.assertEquals("G", findWidget("$l14").getValue());
		 Assert.assertEquals("Z", findWidget("$l15").getValue());
		 Assert.assertEquals("G", findWidget("$l16").getValue());
		 
		 
		 findWidget("$t23").clear().keys("H").tab();
		 Assert.assertEquals("A", findWidget("$l11").getValue());
		 Assert.assertEquals("Z", findWidget("$l12").getValue());
		 Assert.assertEquals("G", findWidget("$l13").getValue());
		 Assert.assertEquals("H", findWidget("$l14").getValue());
		 Assert.assertEquals("Z", findWidget("$l15").getValue());
		 Assert.assertEquals("G", findWidget("$l16").getValue());
		 
		 findWidget("$btn3").click();
		 Assert.assertEquals("A", findWidget("$l11").getValue());
		 Assert.assertEquals("Z", findWidget("$l12").getValue());
		 Assert.assertEquals("H", findWidget("$l13").getValue());
		 Assert.assertEquals("H", findWidget("$l14").getValue());
		 Assert.assertEquals("Z", findWidget("$l15").getValue());
		 Assert.assertEquals("H", findWidget("$l16").getValue());

	}
	
	@Test
	public void testLoadSaveForm() {
		navigate(getTestCaseUrl("/bind/basic/load-save-form.zul"));
		
		 findWidget("$t21").clear().keys("X").tab();
		 Assert.assertEquals("A", findWidget("$l11").getValue());
		 Assert.assertEquals("B", findWidget("$l12").getValue());
		 Assert.assertEquals("C", findWidget("$l13").getValue());
		 Assert.assertEquals("A", findWidget("$l14").getValue());
		 Assert.assertEquals("B", findWidget("$l15").getValue());
		 Assert.assertEquals("C", findWidget("$l16").getValue());
		 
		 findWidget("$btn1").click();
		 Assert.assertEquals("A", findWidget("$l11").getValue());
		 Assert.assertEquals("X", findWidget("$l12").getValue());
		 Assert.assertEquals("C", findWidget("$l13").getValue());
		 Assert.assertEquals("A", findWidget("$l14").getValue());
		 Assert.assertEquals("X", findWidget("$l15").getValue());
		 Assert.assertEquals("X", findWidget("$l16").getValue());
		 
		 
		 findWidget("$t21").clear().keys("Y").tab();
		 Assert.assertEquals("A", findWidget("$l11").getValue());
		 Assert.assertEquals("X", findWidget("$l12").getValue());
		 Assert.assertEquals("C", findWidget("$l13").getValue());
		 Assert.assertEquals("A", findWidget("$l14").getValue());
		 Assert.assertEquals("X", findWidget("$l15").getValue());
		 Assert.assertEquals("X", findWidget("$l16").getValue());
		 
		 findWidget("$btn2").click();
		 Assert.assertEquals("A", findWidget("$l11").getValue());
		 Assert.assertEquals("X", findWidget("$l12").getValue());
		 Assert.assertEquals("Y", findWidget("$l13").getValue());
		 Assert.assertEquals("A", findWidget("$l14").getValue());
		 Assert.assertEquals("X", findWidget("$l15").getValue());
		 Assert.assertEquals("Y", findWidget("$l16").getValue());
		 
		 
		 findWidget("$t21").clear().keys("Z").tab();
		 Assert.assertEquals("A", findWidget("$l11").getValue());
		 Assert.assertEquals("X", findWidget("$l12").getValue());
		 Assert.assertEquals("Y", findWidget("$l13").getValue());
		 Assert.assertEquals("A", findWidget("$l14").getValue());
		 Assert.assertEquals("X", findWidget("$l15").getValue());
		 Assert.assertEquals("Y", findWidget("$l16").getValue());
		 
		 findWidget("$btn3").click();
		 Assert.assertEquals("A", findWidget("$l11").getValue());
		 Assert.assertEquals("X", findWidget("$l12").getValue());
		 Assert.assertEquals("Z", findWidget("$l13").getValue());
		 Assert.assertEquals("A", findWidget("$l14").getValue());
		 Assert.assertEquals("X", findWidget("$l15").getValue());
		 Assert.assertEquals("Z", findWidget("$l16").getValue());

	}
	
	@Test
	public void testLoadSavePromptCommandValidation(){
		navigate(getTestCaseUrl("/bind/basic/load-save-prompt-command-validation.zul"));
		 
		Assert.assertEquals("A", findWidget("$l11").getValue());
		Assert.assertEquals("B", findWidget("$l12").getValue());
		Assert.assertEquals("C", findWidget("$l13").getValue());
		
		findWidget("$t12").clear().keys("GG").tab();
		
		findWidget("$t11").clear().keys("PP").tab();
		Assert.assertEquals("A", findWidget("$l11").getValue());
		Assert.assertEquals("B", findWidget("$l12").getValue());
		Assert.assertEquals("C", findWidget("$l13").getValue());
		Assert.assertEquals("value 1 has to be XX or ZZ", findWidget("$msg1").getValue());
		Assert.assertEquals("value 2 has to be YY or ZZ", findWidget("$msg2").getValue());
		
		
		findWidget("$t11").clear().keys("XX").tab();
		Assert.assertEquals("XX", findWidget("$l11").getValue());
		Assert.assertEquals("B", findWidget("$l12").getValue());
		Assert.assertEquals("C", findWidget("$l13").getValue());
		Assert.assertEquals("", findWidget("$msg1").getValue());
		Assert.assertEquals("value 2 has to be YY or ZZ", findWidget("$msg2").getValue());
		
		findWidget("$t11").clear().keys("YY").tab();
		Assert.assertEquals("XX", findWidget("$l11").getValue());
		Assert.assertEquals("YY", findWidget("$l12").getValue());
		Assert.assertEquals("GG", findWidget("$l13").getValue());
		Assert.assertEquals("doCmd1", findWidget("$msg1").getValue());
		Assert.assertEquals("", findWidget("$msg2").getValue());
		
		findWidget("$t11").clear().keys("ZZ").tab();
		Assert.assertEquals("ZZ", findWidget("$l11").getValue());
		Assert.assertEquals("ZZ", findWidget("$l12").getValue());
		Assert.assertEquals("GG", findWidget("$l13").getValue());
		Assert.assertEquals("doCmd1", findWidget("$msg1").getValue());
		Assert.assertEquals("", findWidget("$msg2").getValue());
	}
}
