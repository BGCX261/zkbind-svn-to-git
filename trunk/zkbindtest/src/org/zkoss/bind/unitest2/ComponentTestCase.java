package org.zkoss.bind.unitest2;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.zkoss.zktc.core.junit.TestCaseBase;
import org.zkoss.zktc.core.widget.Widget;

public class ComponentTestCase  extends TestCaseBase{
	
	@Test
	public void tabboxSelected1(){
		navigate(getTestCaseUrl("/bind/comp/tabbox-selected.zul"));
		
		Assert.assertEquals(2L,findWidget("$listbox1").getAttribute("selectedIndex"));
		Assert.assertEquals(2L,findWidget("$tabbox1").getAttribute("selectedIndex"));
		assertFalseOrNull((Boolean)findWidget("$tab1a").getAttribute("selected"));
		assertFalseOrNull((Boolean)findWidget("$tab1b").getAttribute("selected"));
		Assert.assertEquals(true,(Boolean)findWidget("$tab1c").getAttribute("selected"));
		
		
		findWidget("$item1a").click();
		Assert.assertEquals(0L,findWidget("$listbox1").getAttribute("selectedIndex"));
		Assert.assertEquals(0L,findWidget("$tabbox1").getAttribute("selectedIndex"));
		Assert.assertEquals(true,(Boolean)findWidget("$tab1a").getAttribute("selected"));
		assertFalseOrNull((Boolean)findWidget("$tab1b").getAttribute("selected"));
		assertFalseOrNull((Boolean)findWidget("$tab1c").getAttribute("selected"));
		
		
		findWidget("$item1b").click();
		Assert.assertEquals(1L,findWidget("$listbox1").getAttribute("selectedIndex"));
		Assert.assertEquals(1L,findWidget("$tabbox1").getAttribute("selectedIndex"));
		assertFalseOrNull((Boolean)findWidget("$tab1a").getAttribute("selected"));
		Assert.assertEquals(true,(Boolean)findWidget("$tab1b").getAttribute("selected"));
		assertFalseOrNull((Boolean)findWidget("$tab1c").getAttribute("selected"));
		
	}
	
	@Test
	public void tabboxSelected2(){
		navigate(getTestCaseUrl("/bind/comp/tabbox-selected.zul"));
		
		Assert.assertEquals(1L,findWidget("$listbox2").getAttribute("selectedIndex"));
		Assert.assertEquals(1L,findWidget("$tabbox2").getAttribute("selectedIndex"));
		assertFalseOrNull((Boolean)findWidget("$tab2a").getAttribute("selected"));
		Assert.assertEquals(true,(Boolean)findWidget("$tab2b").getAttribute("selected"));
		assertFalseOrNull((Boolean)findWidget("$tab2c").getAttribute("selected"));
		
		
		findWidget("$item2a").click();
		Assert.assertEquals(0L,findWidget("$listbox2").getAttribute("selectedIndex"));
		Assert.assertEquals(0L,findWidget("$tabbox2").getAttribute("selectedIndex"));
		Assert.assertEquals(true,(Boolean)findWidget("$tab2a").getAttribute("selected"));
		assertFalseOrNull((Boolean)findWidget("$tab2b").getAttribute("selected"));
		assertFalseOrNull((Boolean)findWidget("$tab2c").getAttribute("selected"));
		
		
		findWidget("$tab2c").click();
		Assert.assertEquals(2L,findWidget("$listbox2").getAttribute("selectedIndex"));
		Assert.assertEquals(2L,findWidget("$tabbox2").getAttribute("selectedIndex"));
		assertFalseOrNull((Boolean)findWidget("$tab2a").getAttribute("selected"));
		assertFalseOrNull((Boolean)findWidget("$tab2b").getAttribute("selected"));
		Assert.assertEquals(true,(Boolean)findWidget("$tab2c").getAttribute("selected"));
		
	}
	
	@Test
	public void radiogroupSelected(){
		navigate(getTestCaseUrl("/bind/comp/radiogroup-selected.zul"));
		Widget rgroup = null;
		Assert.assertEquals(1L,findWidget("$listbox").getAttribute("selectedIndex"));
		rgroup = findWidget("$radiogroup");
		Assert.assertEquals(1L,rgroup.getAttribute("selectedIndex"));

		assertFalseOrNull((Boolean)findWidget("$radioa").getAttribute("checked"));//dont use selected, not work
		Assert.assertEquals(true,(Boolean)findWidget("$radiob").getAttribute("checked"));
		assertFalseOrNull((Boolean)findWidget("$radioc").getAttribute("checked"));
		
		
		findWidget("$itema").click();
		Assert.assertEquals(0L,findWidget("$listbox").getAttribute("selectedIndex"));
		Assert.assertEquals(0L,findWidget("$radiogroup").getAttribute("selectedIndex"));
		Assert.assertTrue((Boolean)findWidget("$radioa").getAttribute("checked"));
		assertFalseOrNull((Boolean)findWidget("$radiob").getAttribute("checked"));
		assertFalseOrNull((Boolean)findWidget("$radioc").getAttribute("checked"));
		
		
		findWidget("$radiob").click();
		Assert.assertEquals(1L,findWidget("$listbox").getAttribute("selectedIndex"));
		Assert.assertEquals(1L,findWidget("$radiogroup").getAttribute("selectedIndex"));
		assertFalseOrNull((Boolean)findWidget("$radioa").getAttribute("checked"));
		Assert.assertTrue((Boolean)findWidget("$radiob").getAttribute("checked"));
		assertFalseOrNull((Boolean)findWidget("$radioc").getAttribute("checked"));
		
		findWidget("$radioc").click();
		Assert.assertEquals(2L,findWidget("$listbox").getAttribute("selectedIndex"));
		Assert.assertEquals(2L,findWidget("$radiogroup").getAttribute("selectedIndex"));
		assertFalseOrNull((Boolean)findWidget("$radioa").getAttribute("checked"));
		assertFalseOrNull((Boolean)findWidget("$radiob").getAttribute("checked"));
		Assert.assertTrue((Boolean)findWidget("$radioc").getAttribute("checked"));
		
	}
	
	
}
