package org.zkoss.bind.unitest2;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.zkoss.zktc.core.junit.TestCaseBase;
import org.zkoss.zktc.core.widget.Widget;
/**
 * test case for bugs from number 500-999
 * @author dennis
 *
 */
public class BugsTestCase0500 extends TestCaseBase{

	
	@Test
	public void b00603(){
		navigate(getTestCaseUrl("/bind/issue/B00603.zul"));
		Widget outerbox = findWidget("$outsidebox");
		List<Widget> outeritems = outerbox.getChildren();//include header
		outeritems.remove(0);//don't care header
		
		Assert.assertEquals(3, outeritems.size());
		String[] itemLabel = new String[]{"A","B","C"};
		String[] optionLabel = new String[]{"A","B"};
		for(int i=0;i<3;i++){
			Widget outeritem = outeritems.get(i);
			String outerl = itemLabel[i];
			Widget cell = outeritem.getFirstChild();
			Assert.assertEquals(outerl, cell.getLabel());
			Widget innerbox = outeritem.findWidget("@listbox");
			Assert.assertNotNull(innerbox);
			List<Widget> inneritems = innerbox.findWidgets("@listitem");
			Assert.assertEquals(2, inneritems.size());
			for(int j=0;j<2;j++){
				Widget inneritem = inneritems.get(j);
				String innerl = optionLabel[j];
				cell = inneritem.getFirstChild();
				Assert.assertEquals(outerl+" "+innerl, cell.getLabel());
				cell = cell.getNextSibling();
				Assert.assertEquals(outerl+" "+innerl+innerl, cell.getLabel());
			}
		}
	}
	
	@Test
	public void b00604(){
		navigate(getTestCaseUrl("/bind/issue/B00604.zul"));
		Widget inc1 = findWidget("$inc1");
		Widget inc2 = findWidget("$inc2");
		Widget listbox1 = inc1.findWidget("@listbox");
		Widget listbox2 = inc2.findWidget("@listbox");
		
		String[] itemLabel1 = new String[]{"A","B","C"};
		String[] itemLabel2 = new String[]{"X","Y","Z"};
		
		Assert.assertNotNull(listbox1);
		Assert.assertNull(listbox2);
		Widget listbox = listbox1;
		for(int i=0;i<2;i++){
			
			List<Widget> items = listbox.findWidgets("@listitem");
			Assert.assertEquals(3, items.size());
			
			for(int j=0;j<items.size();j++){
				Widget item = items.get(j);
				Widget cell1 = item.getFirstChild();
				Widget cell2 = cell1.getNextSibling();
				Assert.assertEquals(itemLabel1[j], cell1.getLabel());
				Assert.assertEquals(itemLabel2[j], cell2.getLabel());
			}
			
			findWidget("$btn1").click();
			listbox = findWidget("$inc2").findWidget("@listbox");
		}
	}
	
	@Test
	public void b00605(){
		navigate(getTestCaseUrl("/bind/issue/B00605.zul"));
		
		Assert.assertEquals("A", findWidget("$tb1").getValue());
		Assert.assertEquals("A", findWidget("$lb1").getValue());
		Assert.assertEquals("A", findWidget("$tb2").getValue());
		Assert.assertEquals("A", findWidget("$lb2").getValue());
		Assert.assertNull(findWidget("$tb3",0));//no need to wait it is not exist in init
		Assert.assertNull(findWidget("$lb3",0));//no need to wait it is not exist in init
		
		findWidget("$tb1").clear().keys("JJ").tab();
		Assert.assertEquals("JJ", findWidget("$tb1").getValue());
		Assert.assertEquals("JJ", findWidget("$lb1").getValue());
		Assert.assertEquals("A", findWidget("$tb2").getValue());
		Assert.assertEquals("A", findWidget("$lb2").getValue());

		findWidget("$tb2").clear().keys("KK").tab();
		Assert.assertEquals("JJ", findWidget("$tb1").getValue());
		Assert.assertEquals("JJ", findWidget("$lb1").getValue());
		Assert.assertEquals("KK", findWidget("$tb2").getValue());
		Assert.assertEquals("KK", findWidget("$lb2").getValue());
		
		findWidget("$btn1").click();
		
		Assert.assertEquals("A", findWidget("$tb3").getValue());
		Assert.assertEquals("A", findWidget("$lb3").getValue());
		
		findWidget("$tb3").clear().keys("LL").tab();
		Assert.assertEquals("JJ", findWidget("$tb1").getValue());
		Assert.assertEquals("JJ", findWidget("$lb1").getValue());
		Assert.assertEquals("KK", findWidget("$tb2").getValue());
		Assert.assertEquals("KK", findWidget("$lb2").getValue());
		Assert.assertEquals("LL", findWidget("$tb3").getValue());
		Assert.assertEquals("LL", findWidget("$lb3").getValue());
		
		//test again since inc2 is here
		findWidget("$tb1").clear().keys("X").tab();
		Assert.assertEquals("X", findWidget("$tb1").getValue());
		Assert.assertEquals("X", findWidget("$lb1").getValue());
		Assert.assertEquals("KK", findWidget("$tb2").getValue());
		Assert.assertEquals("KK", findWidget("$lb2").getValue());
		Assert.assertEquals("LL", findWidget("$tb3").getValue());
		Assert.assertEquals("LL", findWidget("$lb3").getValue());

		findWidget("$tb2").clear().keys("Y").tab();
		Assert.assertEquals("X", findWidget("$tb1").getValue());
		Assert.assertEquals("X", findWidget("$lb1").getValue());
		Assert.assertEquals("Y", findWidget("$tb2").getValue());
		Assert.assertEquals("Y", findWidget("$lb2").getValue());
		Assert.assertEquals("LL", findWidget("$tb3").getValue());
		Assert.assertEquals("LL", findWidget("$lb3").getValue());
		
		findWidget("$tb3").clear().keys("Z").tab();
		Assert.assertEquals("X", findWidget("$tb1").getValue());
		Assert.assertEquals("X", findWidget("$lb1").getValue());
		Assert.assertEquals("Y", findWidget("$tb2").getValue());
		Assert.assertEquals("Y", findWidget("$lb2").getValue());
		Assert.assertEquals("Z", findWidget("$tb3").getValue());
		Assert.assertEquals("Z", findWidget("$lb3").getValue());
	}
	
	@Test
	public void b00619(){
		navigate(getTestCaseUrl("/bind/issue/B00619.zul"));
		Assert.assertEquals(1L,findWidget("$listbox").getAttribute("selectedIndex"));
		Assert.assertEquals(1L,findWidget("$tabbox").getAttribute("selectedIndex"));
		assertFalseOrNull((Boolean)findWidget("$taba").getAttribute("selected"));
		Assert.assertTrue((Boolean)findWidget("$tabb").getAttribute("selected"));
		assertFalseOrNull((Boolean)findWidget("$tabc").getAttribute("selected"));
		
		
		findWidget("$itema").click();
		Assert.assertEquals(0L,findWidget("$listbox").getAttribute("selectedIndex"));
		Assert.assertEquals(0L,findWidget("$tabbox").getAttribute("selectedIndex"));
		Assert.assertTrue((Boolean)findWidget("$taba").getAttribute("selected"));
		assertFalseOrNull((Boolean)findWidget("$tabb").getAttribute("selected"));
		assertFalseOrNull((Boolean)findWidget("$tabc").getAttribute("selected"));
		
		
		findWidget("$tabc").click();
		Assert.assertEquals(2L,findWidget("$listbox").getAttribute("selectedIndex"));
		Assert.assertEquals(2L,findWidget("$tabbox").getAttribute("selectedIndex"));
		assertFalseOrNull((Boolean)findWidget("$taba").getAttribute("selected"));
		assertFalseOrNull((Boolean)findWidget("$tabb").getAttribute("selected"));
		Assert.assertTrue((Boolean)findWidget("$tabc").getAttribute("selected"));

	}
	
	@Test
	public void b00632(){
		navigate(getTestCaseUrl("/bind/issue/B00632.zul"));
		
		Assert.assertEquals("XYZ", findWidget("$lb1").getValue());
		Assert.assertEquals("XYZ", findWidget("$lb2").getValue());
		Assert.assertEquals("XYZ", findWidget("$lb3").getValue());
		Assert.assertEquals("XYZ", findWidget("$lb4").getValue());
		
		Assert.assertEquals("A", findWidget("$l11").getValue());
		Assert.assertEquals("B", findWidget("$l12").getValue());
		
		findWidget("$t11").clear().keys("YY").tab();
		Assert.assertEquals("YY", findWidget("$l11").getValue());
		Assert.assertEquals("by-YY", findWidget("$l12").getValue());
	}
	
	@Test
	public void b00634(){
		navigate(getTestCaseUrl("/bind/issue/B00634.zul"));
		 
		Assert.assertEquals("A", findWidget("$l11").getValue());
		Assert.assertEquals("B", findWidget("$l12").getValue());
		
		findWidget("$t11").clear().keys("PP").tab();
		Assert.assertEquals("A", findWidget("$l11").getValue());
		Assert.assertEquals("B", findWidget("$l12").getValue());
		Assert.assertEquals("value 1 has to be XX or ZZ", findWidget("$msg1").getValue());
		Assert.assertEquals("value 2 has to be YY or ZZ", findWidget("$msg2").getValue());
		
		
		findWidget("$t11").clear().keys("XX").tab();
		Assert.assertEquals("A", findWidget("$l11").getValue());
		Assert.assertEquals("B", findWidget("$l12").getValue());
		Assert.assertEquals("", findWidget("$msg1").getValue());
		Assert.assertEquals("value 2 has to be YY or ZZ", findWidget("$msg2").getValue());
		
		findWidget("$t11").clear().keys("YY").tab();
		Assert.assertEquals("A", findWidget("$l11").getValue());
		Assert.assertEquals("B", findWidget("$l12").getValue());
		Assert.assertEquals("value 1 has to be XX or ZZ", findWidget("$msg1").getValue());
		Assert.assertEquals("", findWidget("$msg2").getValue());
		
		findWidget("$t11").clear().keys("ZZ").tab();
		Assert.assertEquals("ZZ", findWidget("$l11").getValue());
		Assert.assertEquals("ZZ", findWidget("$l12").getValue());
		Assert.assertEquals("", findWidget("$msg1").getValue());
		Assert.assertEquals("", findWidget("$msg2").getValue());
	}
	
	@Test
	public void b00657(){
		navigate(getTestCaseUrl("/bind/issue/B00657.zul"));
		 
		Assert.assertEquals(0L, findWidget("$listbox").getAttribute("selectedIndex"));
		Assert.assertEquals(0L, findWidget("$intbox").getValue());
		
		findWidget("$intbox").replace("1").tab();
		Assert.assertEquals(1L, findWidget("$listbox").getAttribute("selectedIndex"));
		Assert.assertEquals(1L, findWidget("$intbox").getValue());
		
		findWidget("$intbox").replace("2").tab();
		Assert.assertEquals(2L, findWidget("$listbox").getAttribute("selectedIndex"));
		Assert.assertEquals(2L, findWidget("$intbox").getValue());
	}
	
	@Test
	public void b00678(){
		navigate(getTestCaseUrl("/bind/issue/B00678.zul"));
		 
		Assert.assertEquals("Value A", findWidget("$l1").getValue());
		Assert.assertEquals("msg A", findWidget("$l2").getValue());
		
		findWidget("$btn1").click();
		Assert.assertEquals("Value B", findWidget("$l1").getValue());
		Assert.assertEquals("msg B", findWidget("$l2").getValue());
		
		findWidget("$btn2").click();
		Assert.assertEquals("Value C", findWidget("$l1").getValue());
		Assert.assertEquals("msg C", findWidget("$l2").getValue());
	}
	
	
	@Test
	public void b00682(){
		navigate(getTestCaseUrl("/bind/issue/B00682.zul"));
		
		Widget l1 = findWidget("$l1");
		Widget l2 = findWidget("$l2");
		Widget l3 = findWidget("$l3");
		Widget l4 = findWidget("$l4");
		Widget l5 = findWidget("$l5");
		Widget l6 = findWidget("$l6");
		
		Assert.assertNotNull(l1);
		Assert.assertNotNull(l2);
		Assert.assertNotNull(l3);
		Assert.assertNotNull(l4);
		Assert.assertNotNull(l5);
		Assert.assertNotNull(l6);
		
		Assert.assertEquals("", l1.getValue());
		Assert.assertEquals("", l2.getValue());
		Assert.assertEquals("-1.0", l3.getValue());
		Assert.assertEquals("-2.0", l4.getValue());
		Assert.assertEquals("-3", l5.getValue());
		Assert.assertEquals("-4", l6.getValue());
		
		Widget i11 = findWidget("$inp11");
		Widget i12 = findWidget("$inp12");
		Widget i13 = findWidget("$inp13");
		Widget i14 = findWidget("$inp14");
		Widget i15 = findWidget("$inp15");
		Widget i16 = findWidget("$inp16");
		Widget i17 = findWidget("$inp17");
		Widget i18 = findWidget("$inp18");
		Widget i19 = findWidget("$inp19");
		Widget i1a = findWidget("$inp1a");
		Widget i1b = findWidget("$inp1b");
		
		Widget i21 = findWidget("$inp21");
		Widget i22 = findWidget("$inp22");
		Widget i23 = findWidget("$inp23");
		Widget i24 = findWidget("$inp24");
		Widget i25 = findWidget("$inp25");
		Widget i26 = findWidget("$inp26");
		Widget i27 = findWidget("$inp27");
		Widget i28 = findWidget("$inp28");
		Widget i29 = findWidget("$inp29");
		Widget i2a = findWidget("$inp2a");
		Widget i2b = findWidget("$inp2b");
		
		Assert.assertNotNull(i11);
		Assert.assertNotNull(i12);
		Assert.assertNotNull(i13);
		Assert.assertNotNull(i14);
		Assert.assertNotNull(i15);
		Assert.assertNotNull(i16);
		Assert.assertNotNull(i17);
		Assert.assertNotNull(i18);
		Assert.assertNotNull(i19);
		Assert.assertNotNull(i1a);
		Assert.assertNotNull(i1b);
		
		
		Assert.assertNotNull(i21);
		Assert.assertNotNull(i22);
		Assert.assertNotNull(i23);
		Assert.assertNotNull(i24);
		Assert.assertNotNull(i25);
		Assert.assertNotNull(i26);
		Assert.assertNotNull(i27);
		Assert.assertNotNull(i28);
		Assert.assertNotNull(i29);
		Assert.assertNotNull(i2a);
		Assert.assertNotNull(i2b);
		
		
		Assert.assertEquals("", i11.getValue());
		Assert.assertEquals(null, i12.getValue());
		Assert.assertEquals(null, i13.getValue());
		Assert.assertEquals(null, i14.getValue());
		Assert.assertEquals(null, i15.getValue());
//		Assert.assertEquals(-1L, i16.getValue()); //widget bug
		Assert.assertEquals(-2L, i17.getValue());
		Assert.assertEquals(-2L, i18.getValue());
		Assert.assertEquals(-3L, i19.getValue());
		Assert.assertEquals(-3L, i1a.getValue());
//		Assert.assertEquals(-4L, i1b.getValue()); //widget bug
		
		
		i11.focus(0,1000);
		i11.tab(0,1000);
		i12.tab(0,1000);
		i13.tab(0,1000);
		i14.tab(0,1000);
		i15.tab(0,1000);
		i16.tab(0,1000);
		i17.tab(0,1000);
		i18.tab(0,1000);
		i19.tab(0,1000);
		i1a.tab(0,1000);
		i1b.tab(0,1000);
		
		i21.tab(0,1000);
		i22.tab(0,1000);
		i23.tab(0,1000);
		i24.tab(0,1000);
		i25.tab(0,1000);
		i26.tab(0,1000);
		i27.tab(0,1000);
		i28.tab(0,1000);
		i29.tab(0,1000);
		i2a.tab(0,1000);
		i2b.tab(0,1000);
		
		
		Assert.assertEquals("", l1.getValue());
		Assert.assertEquals("", l2.getValue());
		Assert.assertEquals("-1.0", l3.getValue());
		Assert.assertEquals("-2.0", l4.getValue());
		Assert.assertEquals("-3", l5.getValue());
		Assert.assertEquals("-4", l6.getValue());
		
	}
	
	
	@Test
	public void b00722(){
		navigate(getTestCaseUrl("/bind/issue/B00722.zul"));
		
		Widget l11 = findWidget("$l11");
		Widget t21 = findWidget("$t21");
		Widget m21 = findWidget("$m21");
		Widget cmd1 = findWidget("$cmd1");
		Widget cmd2 = findWidget("$cmd2");
		
		
		Assert.assertEquals("abc", l11.getValue());
		Assert.assertEquals("abc", t21.getValue());
		Assert.assertEquals("", m21.getValue());
		
		t21.replace("efg").tab();
		Assert.assertEquals("abc", l11.getValue());
		Assert.assertEquals("efg", t21.getValue());
		Assert.assertEquals("the value has to be 'abc' or 'ABC'", m21.getValue());
		
		cmd1.click();
		Assert.assertEquals("abc", l11.getValue());
		Assert.assertEquals("efg", t21.getValue());
		Assert.assertEquals("the value has to be 'abc' or 'ABC'", m21.getValue());
		
		t21.replace("ABC").tab();
		Assert.assertEquals("abc", l11.getValue());
		Assert.assertEquals("ABC", t21.getValue());
		Assert.assertEquals("", m21.getValue());
		
		cmd1.click();
		Assert.assertEquals("ABC:saved", l11.getValue());
		Assert.assertEquals("ABC", t21.getValue());
		Assert.assertEquals("", m21.getValue());
		
		t21.replace("kkk").tab();
		Assert.assertEquals("ABC:saved", l11.getValue());
		Assert.assertEquals("kkk", t21.getValue());
		Assert.assertEquals("the value has to be 'abc' or 'ABC'", m21.getValue());
		
		cmd2.click();
		Assert.assertEquals("ABC:saved", l11.getValue());
		Assert.assertEquals("ABC:saved", t21.getValue());
		Assert.assertEquals("", m21.getValue());
	}
	


	@Test
	public void b00762Listbox1(){
		navigate(getTestCaseUrl("/bind/issue/B00762Listbox1.zul"));
		Widget outerbox = findWidget("$outerbox");
		Widget selected = findWidget("$selected");
		Widget min = findWidget("$min");
//		Widget max = findWidget("$max");

		Widget clean = findWidget("$clean");
		Widget select = findWidget("$select");
		Widget showselect = findWidget("$showselect");
		
		
		outerbox.findWidgets("@listitem").get(0).click();
		Assert.assertEquals("A", selected.getValue());
		showselect.click();
		Assert.assertEquals("0", min.getValue());
//		Assert.assertEquals("0", max.getValue());
		
		outerbox.findWidgets("@listitem").get(2).click();
		Assert.assertEquals("C", selected.getValue());
		showselect.click();
		Assert.assertEquals("2", min.getValue());
//		Assert.assertEquals("2", max.getValue());
		
		clean.click();
		Assert.assertEquals(-1L, ListboxUtil.getSelectedIndex(outerbox));
		Assert.assertEquals("", selected.getValue());
		showselect.click();
		Assert.assertEquals("-1", min.getValue());
//		Assert.assertEquals("-1", max.getValue());
		
		select.click();
		Assert.assertEquals(1L, ListboxUtil.getSelectedIndex(outerbox));
		Assert.assertEquals("B", selected.getValue());
		showselect.click();
		Assert.assertEquals("1", min.getValue());
//		Assert.assertEquals("1", max.getValue());
		
		
	}
	
	
	@Test
	public void b00762Listbox2(){
		navigate(getTestCaseUrl("/bind/issue/B00762Listbox2.zul"));
		Widget outerbox = findWidget("$outerbox");
		Widget min = findWidget("$min");
//		Widget max = findWidget("$max");

		Widget clean = findWidget("$clean");
		Widget select = findWidget("$select");
		Widget showselect = findWidget("$showselect");
		
		
		outerbox.findWidgets("@listitem").get(0).click();
		showselect.click();
		Assert.assertEquals("0", min.getValue());
//		Assert.assertEquals("0", max.getValue());
		
		outerbox.findWidgets("@listitem").get(2).click();
		showselect.click();
		Assert.assertEquals("2", min.getValue());
//		Assert.assertEquals("2", max.getValue());
		
		clean.click();
		Assert.assertEquals(-1L, ListboxUtil.getSelectedIndex(outerbox));
		showselect.click();
		Assert.assertEquals("-1", min.getValue());
//		Assert.assertEquals("-1", max.getValue());
		
		select.click();
		Assert.assertEquals(1L, ListboxUtil.getSelectedIndex(outerbox));
		showselect.click();
		Assert.assertEquals("1", min.getValue());
//		Assert.assertEquals("1", max.getValue());
		
	}
	
	
	@Test
	public void b00762Combobox1(){
		navigate(getTestCaseUrl("/bind/issue/B00762Combobox1.zul"));
		Widget outerbox = findWidget("$outerbox");
		Widget selected = findWidget("$selected");
		Widget min = findWidget("$min");
//		Widget max = findWidget("$max");

		Widget clean = findWidget("$clean");
		Widget select = findWidget("$select");
		Widget reload = findWidget("$reload");
		Widget showselect = findWidget("$showselect");
		
		outerbox.call("open");
		waitForTrip(1, 500);
		outerbox.findWidgets("@comboitem").get(0).click();
		Assert.assertEquals("A", selected.getValue());
		showselect.click();
		Assert.assertEquals("0", min.getValue());
//		Assert.assertEquals("0", max.getValue());
		
		outerbox.call("open");
		waitForTrip(1, 500);
		outerbox.findWidgets("@comboitem").get(2).click();
		Assert.assertEquals("C", selected.getValue());
		showselect.click();
		Assert.assertEquals("2", min.getValue());
//		Assert.assertEquals("2", max.getValue());
		
		clean.click();
		Assert.assertEquals("", outerbox.getValue());
		Assert.assertEquals("", selected.getValue());
		showselect.click();
		Assert.assertEquals("-1", min.getValue());
//		Assert.assertEquals("-1", max.getValue());
		
		select.click();
		Assert.assertEquals("B", outerbox.getValue());
		Assert.assertEquals("B", selected.getValue());
		showselect.click();
		Assert.assertEquals("1", min.getValue());
//		Assert.assertEquals("1", max.getValue());
		
	}
	
	@Test
	public void b00762Combobox2(){
		navigate(getTestCaseUrl("/bind/issue/B00762Combobox2.zul"));
		Widget outerbox = findWidget("$outerbox");
		Widget min = findWidget("$min");
//		Widget max = findWidget("$max");

		Widget clean = findWidget("$clean");
		Widget select = findWidget("$select");
		Widget reload = findWidget("$reload");
		Widget showselect = findWidget("$showselect");
		
		outerbox.call("open");
		waitForTrip(1, 500);
		outerbox.findWidgets("@comboitem").get(0).click();
		showselect.click();
		Assert.assertEquals("0", min.getValue());
//		Assert.assertEquals("0", max.getValue());
		
		outerbox.call("open");
		waitForTrip(1, 500);
		outerbox.findWidgets("@comboitem").get(2).click();
		showselect.click();
		Assert.assertEquals("2", min.getValue());
//		Assert.assertEquals("2", max.getValue());
		
		clean.click();
		Assert.assertEquals("", outerbox.getValue());
		showselect.click();
		Assert.assertEquals("-1", min.getValue());
//		Assert.assertEquals("-1", max.getValue());
		
		select.click();
		Assert.assertEquals("B", outerbox.getValue());
		showselect.click();
		Assert.assertEquals("1", min.getValue());
//		Assert.assertEquals("1", max.getValue());
		
	}
	
	@Test
	public void b00775ListmodelSelection(){
		navigate(getTestCaseUrl("/bind/issue/B00775ListmodelSelection.zul"));
		Widget listbox = findWidget("$listbox");
		Widget header = findWidget("$header");
		Widget shrink = findWidget("$shrink");
		
		header.click();
		header.click();//twice
		
		listbox.findWidgets("@listitem").get(8).click();
		Assert.assertEquals(8L,ListboxUtil.getSelectedIndex(listbox));
		
		shrink.click();
		Assert.assertEquals(0L,ListboxUtil.getSelectedIndex(listbox));
	}
	
	@Test
	public void b00757OnChange(){
		navigate(getTestCaseUrl("/bind/issue/B00757OnChange.zul"));
		Widget t1 = findWidget("$t1");
		Widget l1 = findWidget("$l1");
		
		Widget t2 = findWidget("$t2");
		Widget l2 = findWidget("$l2");
		
		Widget t3 = findWidget("$t3");
		Widget l31 = findWidget("$l31");
		Widget l32 = findWidget("$l32");
		
		Widget t4 = findWidget("$t4");
		Widget l4 = findWidget("$l4");
		
		
		t1.replace("A").tab();
		Assert.assertEquals("A-X", l1.getValue());
		
		t2.replace("A").tab();
		Assert.assertEquals("null-Y", l2.getValue());
		t2.replace("B").tab();
		Assert.assertEquals("B-Y", l2.getValue());
		t2.replace("C").tab();
		Assert.assertEquals("B-Y", l2.getValue());
		
		t3.replace("A").tab();
		Assert.assertEquals("A", l31.getValue());
		Assert.assertEquals("", l32.getValue());
		Assert.assertEquals("", l4.getValue());
		
		t4.replace("C").tab();
		Assert.assertEquals("A", l31.getValue());
		Assert.assertEquals("", l32.getValue());
		Assert.assertEquals("", l4.getValue());
		
		t3.replace("B").tab();
		Assert.assertEquals("B", l31.getValue());
		Assert.assertEquals("B-I", l32.getValue());
		Assert.assertEquals("C-J", l4.getValue());
	}
	
	@Test
	public void b00810ListboxMultiple(){
		navigate(getTestCaseUrl("/bind/issue/B00810ListboxMultiple.zul"));
		Widget listbox1 = findWidget("$listbox1");
		Widget listbox2 = findWidget("$listbox2");
		Widget listbox3 = findWidget("$listbox3");
		Widget l1 = findWidget("$l1");
		Widget toggle = findWidget("$toggle");
		Widget update = findWidget("$update");
		
		listbox1.findWidgets("@listitem").get(1).click();
		Assert.assertArrayEquals(new long[]{1}, ListboxUtil.getSelectedIndexs(listbox1));
		Assert.assertArrayEquals(new long[]{1}, ListboxUtil.getSelectedIndexs(listbox2));
		Assert.assertArrayEquals(new long[]{1}, ListboxUtil.getSelectedIndexs(listbox3));
		Assert.assertEquals("[1]", l1.getValue());
		
		
		listbox2.findWidgets("@listitem").get(3).click();
		Assert.assertArrayEquals(new long[]{1,3}, ListboxUtil.getSelectedIndexs(listbox1));
		Assert.assertArrayEquals(new long[]{1,3}, ListboxUtil.getSelectedIndexs(listbox2));
		Assert.assertArrayEquals(new long[]{1,3}, ListboxUtil.getSelectedIndexs(listbox3));
		Assert.assertEquals("[1, 3]", l1.getValue());
		
		listbox3.findWidgets("@listitem").get(6).click();
		Assert.assertArrayEquals(new long[]{1,3,6}, ListboxUtil.getSelectedIndexs(listbox1));
		Assert.assertArrayEquals(new long[]{1,3,6}, ListboxUtil.getSelectedIndexs(listbox2));
		Assert.assertArrayEquals(new long[]{1,3,6}, ListboxUtil.getSelectedIndexs(listbox3));
		Assert.assertEquals("[1, 3, 6]", l1.getValue());
		
		toggle.click();
		listbox3.findWidgets("@listitem").get(7).click();
		Assert.assertArrayEquals(new long[]{7}, ListboxUtil.getSelectedIndexs(listbox1));
		Assert.assertArrayEquals(new long[]{7}, ListboxUtil.getSelectedIndexs(listbox2));
		Assert.assertArrayEquals(new long[]{7}, ListboxUtil.getSelectedIndexs(listbox3));
		Assert.assertEquals("[7]", l1.getValue());
		
		listbox3.findWidgets("@listitem").get(1).click();
		Assert.assertArrayEquals(new long[]{1}, ListboxUtil.getSelectedIndexs(listbox1));
		Assert.assertArrayEquals(new long[]{1}, ListboxUtil.getSelectedIndexs(listbox2));
		Assert.assertArrayEquals(new long[]{1}, ListboxUtil.getSelectedIndexs(listbox3));
		Assert.assertEquals("[1]", l1.getValue());
		
	}
	
	@Test
	public void b00821SelectedIndex(){
		navigate(getTestCaseUrl("/bind/issue/B00821SelectedIndex.zul"));
		Widget selectbox = findWidget("$selectbox");
		Widget listbox = findWidget("$listbox");
		Widget combobox = findWidget("$combobox");
		Widget i1 = findWidget("$i1");
		
		i1.replace("1").tab();
		
		Assert.assertEquals(1L, ListboxUtil.getSelectedIndex(listbox));
		Assert.assertEquals(1L, selectbox.getAttribute("selectedIndex"));
		Assert.assertEquals("B", combobox.getValue());
		
		i1.replace("2").tab();
		Assert.assertEquals(2L, ListboxUtil.getSelectedIndex(listbox));
		Assert.assertEquals(2L, selectbox.getAttribute("selectedIndex"));
		Assert.assertEquals("C", combobox.getValue());
	}
	
	@Test
	public void b00828GlobalCommand(){
		navigate(getTestCaseUrl("/bind/issue/B00828GlobalCommand.zul"));
		Widget post = findWidget("$post");
		for(int i=0;i<5;i++){
			post.click();
			Widget w = findWidget(".z-window-modal");
			Assert.assertNull(w);
		}		
	}
	
	@Test
	public void b00807GroupModel_1(){
		navigate(getTestCaseUrl("/bind/issue/B00807GroupModel.zul"));
		
		Widget grid = findWidget("$grid");
		List<Widget> groups = grid.findWidgets("@group");
		List<Widget> groupfoots = grid.findWidgets("@groupfoot");
		List<Widget> rows = grid.findWidgets("@row");
		
		Assert.assertEquals(3, groups.size());
		Assert.assertEquals(3, groupfoots.size());
		Assert.assertEquals(5, rows.size());
		
		Assert.assertEquals("Fruits", groups.get(0).getAttribute("label"));
		Assert.assertEquals("Seafood", groups.get(1).getAttribute("label"));
		Assert.assertEquals("Vegetables", groups.get(2).getAttribute("label"));
		
		Assert.assertEquals("1", groupfoots.get(0).findWidget("@label").getAttribute("value"));
		Assert.assertEquals("2", groupfoots.get(1).findWidget("@label").getAttribute("value"));
		Assert.assertEquals("2", groupfoots.get(2).findWidget("@label").getAttribute("value"));
		
		Assert.assertEquals("Apples", rows.get(0).findWidgets("@label").get(1).getAttribute("value"));
		Assert.assertEquals("Salmon", rows.get(1).findWidgets("@label").get(1).getAttribute("value"));
		Assert.assertEquals("Shrimp", rows.get(2).findWidgets("@label").get(1).getAttribute("value"));
		Assert.assertEquals("Asparagus", rows.get(3).findWidgets("@label").get(1).getAttribute("value"));
		Assert.assertEquals("Beets", rows.get(4).findWidgets("@label").get(1).getAttribute("value"));
		
	}
	@Test
	public void b00807GroupModel_2(){
		navigate(getTestCaseUrl("/bind/issue/B00807GroupModelListbox.zul"));
		
		Widget listbox = findWidget("$listbox");
		List<Widget> groups = listbox.findWidgets("@listgroup");
		List<Widget> groupfoots = listbox.findWidgets("@listgroupfoot");
		List<Widget> items = listbox.findWidgets("@listitem");
		Widget l1 = findWidget("$l1");
		Widget sel1 = findWidget("$sel1");
		Widget sel2 = findWidget("$sel2");
		
		Assert.assertEquals(3, groups.size());
		Assert.assertEquals(3, groupfoots.size());
		Assert.assertEquals(5, items.size());
		
		Assert.assertEquals("Fruits", groups.get(0).findWidget("@listcell").getAttribute("label"));
		Assert.assertEquals("Seafood", groups.get(1).findWidget("@listcell").getAttribute("label"));
		Assert.assertEquals("Vegetables", groups.get(2).findWidget("@listcell").getAttribute("label"));
		
		Assert.assertEquals("1", groupfoots.get(0).findWidget("@listcell").getAttribute("label"));
		Assert.assertEquals("2", groupfoots.get(1).findWidget("@listcell").getAttribute("label"));
		Assert.assertEquals("2", groupfoots.get(2).findWidget("@listcell").getAttribute("label"));
		
		Assert.assertEquals("Apples", items.get(0).findWidgets("@label").get(1).getAttribute("value"));
		Assert.assertEquals("Salmon", items.get(1).findWidgets("@label").get(1).getAttribute("value"));
		Assert.assertEquals("Shrimp", items.get(2).findWidgets("@label").get(1).getAttribute("value"));
		Assert.assertEquals("Asparagus", items.get(3).findWidgets("@label").get(1).getAttribute("value"));
		Assert.assertEquals("Beets", items.get(4).findWidgets("@label").get(1).getAttribute("value"));
		
		
		
		items.get(4).click();
		Assert.assertEquals("Beets",l1.getValue());

		sel1.click();
		Assert.assertEquals("Apples",l1.getValue());
		
		sel2.click();
		Assert.assertEquals("Salmon",l1.getValue());
		
	}
	
	@Test
	public void b00807GroupModel_3(){
		navigate(getTestCaseUrl("/bind/issue/B00807GroupModelListboxMultiple.zul"));
		
		Widget listbox = findWidget("$listbox");
		List<Widget> groups = listbox.findWidgets("@listgroup");
		List<Widget> groupfoots = listbox.findWidgets("@listgroupfoot");
		List<Widget> items = listbox.findWidgets("@listitem");
		Widget l1 = findWidget("$l1");
		Widget sel1 = findWidget("$sel1");
		
		Assert.assertEquals(3, groups.size());
		Assert.assertEquals(3, groupfoots.size());
		Assert.assertEquals(5, items.size());
		
		Assert.assertEquals("Fruits", groups.get(0).findWidget("@listcell").getAttribute("label"));
		Assert.assertEquals("Seafood", groups.get(1).findWidget("@listcell").getAttribute("label"));
		Assert.assertEquals("Vegetables", groups.get(2).findWidget("@listcell").getAttribute("label"));
		
		Assert.assertEquals("1", groupfoots.get(0).findWidget("@listcell").getAttribute("label"));
		Assert.assertEquals("2", groupfoots.get(1).findWidget("@listcell").getAttribute("label"));
		Assert.assertEquals("2", groupfoots.get(2).findWidget("@listcell").getAttribute("label"));
		
		Assert.assertEquals("Apples", items.get(0).findWidgets("@label").get(1).getAttribute("value"));
		Assert.assertEquals("Salmon", items.get(1).findWidgets("@label").get(1).getAttribute("value"));
		Assert.assertEquals("Shrimp", items.get(2).findWidgets("@label").get(1).getAttribute("value"));
		Assert.assertEquals("Asparagus", items.get(3).findWidgets("@label").get(1).getAttribute("value"));
		Assert.assertEquals("Beets", items.get(4).findWidgets("@label").get(1).getAttribute("value"));
		
		
		
		items.get(3).click();
		Assert.assertEquals("[Asparagus]",l1.getValue());
		items.get(4).click();
		Assert.assertEquals("[Asparagus, Beets]",l1.getValue());

		sel1.click();
		Assert.assertEquals("[Apples, Shrimp]",l1.getValue());
		Assert.assertArrayEquals(new long[]{0,2}, ListboxUtil.getSelectedIndexs(listbox));
	}
	
	@Test
	public void b00847FormInit(){
		navigate(getTestCaseUrl("/bind/issue/B00847FormInit.zul"));
		
		Widget l1 = findWidget("$l1");
		Widget l2 = findWidget("$l2");
		
		Widget cmd1 = findWidget("$cmd1");
		Widget cmd2 = findWidget("$cmd2");
		
		Assert.assertEquals("blue",l1.getValue());
		Assert.assertEquals("blue",l2.getValue());
		
		cmd1.click();
		Assert.assertEquals("red",l1.getValue());
		Assert.assertEquals("blue",l2.getValue());
		
		cmd2.click();
		Assert.assertEquals("yellow",l1.getValue());
		Assert.assertEquals("yellow",l2.getValue());
	}
	
	@Test
	public void b00849ConverterParameters(){
		navigate(getTestCaseUrl("/bind/issue/B00849ConverterParameters.zul"));
		
		Widget l11 = findWidget("$l11");
		Widget l12 = findWidget("$l12");
		Widget tb1 = findWidget("$tb1");
		
		Widget l21 = findWidget("$l21");
		Widget l22 = findWidget("$l22");
		Widget tb2 = findWidget("$tb2");
		
		Widget l31 = findWidget("$l31");
		Widget l32 = findWidget("$l32");
		Widget tb3 = findWidget("$tb3");
		
		Widget cmd1 = findWidget("$btn1");
		Widget cmd2 = findWidget("$btn2");
		Widget cmd3 = findWidget("$btn3");
		
		
		tb1.replace("A");
		cmd1.click();
		Assert.assertEquals("",l11.getValue());
		Assert.assertEquals("",l12.getValue());
		Assert.assertEquals("A:value1",tb1.getValue());
		
		
		tb2.replace("B");
		cmd2.click();
		Assert.assertEquals("",l21.getValue());
		Assert.assertEquals("",l22.getValue());
		Assert.assertEquals("B:value2",tb2.getValue());
		
		tb3.replace("C");
		cmd3.click();
		Assert.assertEquals("",l31.getValue());
		Assert.assertEquals("",l32.getValue());
		Assert.assertEquals("C:value3",tb3.getValue());
		
	}
	
	@Test
	public void b00878WrongValueException1(){
		navigate(getTestCaseUrl("/bind/issue/B00878WrongValueException.zul"));
		
		Widget msgName = findWidget("$msgName");
		Widget msgAge = findWidget("$msgAge");
		Widget msgScore = findWidget("$msgScore");
		
		Widget inpName = findWidget("$inpName");
		Widget inpAge = findWidget("$inpAge");
		Widget inpScore = findWidget("$inpScore");
		Widget save = findWidget("$save");
		
		Assert.assertEquals("",msgName.getValue());
		Assert.assertEquals("0",msgAge.getValue());
		Assert.assertEquals("0",msgScore.getValue());
		
		
		inpName.replace("Chen").tab();
		inpAge.replace("3").tab();
		inpScore.replace("-1").tab();
		save.click();
		Assert.assertEquals("",msgName.getValue());
		Assert.assertEquals("0",msgAge.getValue());
		Assert.assertEquals("0",msgScore.getValue());
		List<Widget> errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(3,errorPopup.size());
		
		
		inpName.replace("Lin").tab();
		inpAge.replace("5").tab();
		inpScore.replace("-2").tab();
		save.click();
		Assert.assertEquals("",msgName.getValue());
		Assert.assertEquals("0",msgAge.getValue());
		Assert.assertEquals("0",msgScore.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(2,errorPopup.size());
		
		inpAge.replace("24").tab();
		inpScore.replace("-3").tab();
		save.click();
		Assert.assertEquals("",msgName.getValue());
		Assert.assertEquals("0",msgAge.getValue());
		Assert.assertEquals("0",msgScore.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(1,errorPopup.size());
		
		inpScore.replace("34").tab();
		save.click();
		Assert.assertEquals("Lin",msgName.getValue());
		Assert.assertEquals("24",msgAge.getValue());
		Assert.assertEquals("34",msgScore.getValue());
		errorPopup = findWidgets(".z-errorbox.z-popup");
		Assert.assertEquals(0,errorPopup.size());
	}
	
	@Test
	public void b00878WrongValueException2(){
		navigate(getTestCaseUrl("/bind/issue/B00878WrongValueException2.zul"));
		
		Widget focus = findWidget("@button");
		Widget l = findWidget("$l1");
		Widget inp = findWidget("$inp1");
		List<Widget> errorPopup = null;
		//bandbox
		Assert.assertEquals("",l.getValue());
		
		inp.replace("A");
		focus.focus();
		Assert.assertEquals("A",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(0,errorPopup.size());
		
		inp.replace("");
		focus.focus();
		Assert.assertEquals("A",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(1,errorPopup.size());
		
		inp.replace("B");
		focus.focus();
		Assert.assertEquals("B",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(0,errorPopup.size());
		
		//combobox
		l = findWidget("$l2");
		inp = findWidget("$inp2");
		Assert.assertEquals("",l.getValue());
		
		inp.replace("C");
		focus.focus();
		Assert.assertEquals("C",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(0,errorPopup.size());
		
		inp.replace("");
		focus.focus();
		Assert.assertEquals("C",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(1,errorPopup.size());
		
		inp.replace("D");
		focus.focus();
		Assert.assertEquals("D",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(0,errorPopup.size());
		
		//textbox
		l = findWidget("$l10");
		inp = findWidget("$inp10");
		Assert.assertEquals("",l.getValue());
		
		inp.replace("E");
		focus.focus();
		Assert.assertEquals("E",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(0,errorPopup.size());
		
		inp.replace("");
		focus.focus();
		Assert.assertEquals("E",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(1,errorPopup.size());
		
		inp.replace("F");
		focus.focus();
		Assert.assertEquals("F",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(0,errorPopup.size());
		
		
		//decimalbox
		l = findWidget("$l4");
		inp = findWidget("$inp4");
		Assert.assertEquals("",l.getValue());
		
		inp.replace("1");
		focus.focus();
		Assert.assertEquals("1.0",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(0,errorPopup.size());
		
		inp.replace("-1");
		focus.focus();
		Assert.assertEquals("1.0",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(1,errorPopup.size());
		
		inp.replace("2");
		focus.focus();
		Assert.assertEquals("2.0",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(0,errorPopup.size());
		
		//doublebox
		l = findWidget("$l5");
		inp = findWidget("$inp5");
		Assert.assertEquals("",l.getValue());
		
		inp.replace("3");
		focus.focus();
		Assert.assertEquals("3.0",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(0,errorPopup.size());
		
		inp.replace("-3");
		focus.focus();
		Assert.assertEquals("3.0",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(1,errorPopup.size());
		
		inp.replace("4");
		focus.focus();
		Assert.assertEquals("4.0",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(0,errorPopup.size());
		
		//doublespinner
		l = findWidget("$l6");
		inp = findWidget("$inp6");
		Assert.assertEquals("",l.getValue());
		
		inp.replace("5");
		focus.focus();
		Assert.assertEquals("5.0",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(0,errorPopup.size());
		
		inp.replace("-5");
		focus.focus();
		Assert.assertEquals("5.0",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(1,errorPopup.size());
		
		inp.replace("6");
		focus.focus();
		Assert.assertEquals("6.0",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(0,errorPopup.size());
		
		//intbox
		l = findWidget("$l7");
		inp = findWidget("$inp7");
		Assert.assertEquals("",l.getValue());
		
		inp.replace("7");
		focus.focus();
		Assert.assertEquals("7",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(0,errorPopup.size());
		
		inp.replace("-7");
		focus.focus();
		Assert.assertEquals("7",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(1,errorPopup.size());
		
		inp.replace("8");
		focus.focus();
		Assert.assertEquals("8",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(0,errorPopup.size());
		
		
		//longbox
		l = findWidget("$l8");
		inp = findWidget("$inp8");
		Assert.assertEquals("",l.getValue());
		
		inp.replace("9");
		focus.focus();
		Assert.assertEquals("9",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(0,errorPopup.size());
		
		inp.replace("-9");
		focus.focus();
		Assert.assertEquals("9",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(1,errorPopup.size());
		
		inp.replace("10");
		focus.focus();
		Assert.assertEquals("10",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(0,errorPopup.size());
		
		//spinner
		l = findWidget("$l9");
		inp = findWidget("$inp9");
		Assert.assertEquals("",l.getValue());
		
		inp.replace("11");
		focus.focus();
		Assert.assertEquals("11",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(0,errorPopup.size());
		
		inp.replace("-11");
		focus.focus();
		Assert.assertEquals("11",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(1,errorPopup.size());
		
		inp.replace("12");
		focus.focus();
		Assert.assertEquals("12",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(0,errorPopup.size());
		
		
		//datebox
		l = findWidget("$l3");
		inp = findWidget("$inp3");
		Assert.assertEquals("",l.getValue());
		
		inp.replace("20120223");
		focus.focus();
		Assert.assertEquals("20120223",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(0,errorPopup.size());
		
		inp.replace("20110101");
		focus.focus();
		Assert.assertEquals("20120223",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(1,errorPopup.size());
		
		inp.replace("20120320");
		focus.focus();
		Assert.assertEquals("20120320",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(0,errorPopup.size());
		
		//timebox
		l = findWidget("$l11");
		inp = findWidget("$inp11");
		Assert.assertEquals("",l.getValue());
		
		inp.replace("13:00");
		focus.focus();
		Assert.assertEquals("13:00",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(0,errorPopup.size());
		
		inp.replace("10:00");
		focus.focus();
		Assert.assertEquals("13:00",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(1,errorPopup.size());
		
		inp.replace("14:02");
		focus.focus();
		Assert.assertEquals("14:02",l.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(0,errorPopup.size());
	}
	
	@Test
	public void b00877NPEInSaveOnlyBinding(){
		navigate(getTestCaseUrl("/bind/issue/B00877NPEInSaveOnlyBinding.zul"));
		
		Widget msg = findWidget("$msg");
		Widget tb = findWidget("$tb");
		List<Widget> errorPopup = null;
		
		tb.replace("abc").tab();
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals("", msg.getValue());
		Assert.assertEquals(1,errorPopup.size());
		
		tb.replace("Lin").tab();
		Assert.assertEquals("Lin", msg.getValue());
		errorPopup = findWidgets(".z-errbox.z-popup");
		Assert.assertEquals(0,errorPopup.size());
		
	}
	
	@Test
	public void b00869Serialization(){
		navigate(getTestCaseUrl("/bind/issue/B00869Serialization.zul"));
		
		Widget msg = findWidget("$msg");
		Widget selected = findWidget("$selected");
		Widget listbox = findWidget("$listbox");
		Widget tb1 = findWidget("$tb1");
		Widget save = findWidget("$save");
		Widget serialize = findWidget("$serialize");
		Widget children = findWidget("$children");
		
		Assert.assertEquals("A", selected.getValue());
		Assert.assertEquals("A", tb1.getValue());
		Assert.assertEquals("B", children.findWidgets("@label").get(1).getValue());
		
		listbox.findWidgets("@listitem").get(1).click();
		Assert.assertEquals("B", selected.getValue());
		Assert.assertEquals("B", tb1.getValue());
		
		tb1.replace("BX");
		save.click();
		Assert.assertEquals("BX", selected.getValue());
		Assert.assertEquals("BX", children.findWidgets("@label").get(1).getValue());
		Assert.assertEquals("BX", listbox.findWidgets("@listitem").get(1).findWidgets("@listcell").get(1).getLabel());
		
		serialize.click();
		
		//refine
		msg = findWidget("$msg");
		selected = findWidget("$selected");
		listbox = findWidget("$listbox");
		tb1 = findWidget("$tb1");
		save = findWidget("$save");
		serialize = findWidget("$serialize");
		children = findWidget("$children");
		
		
		Assert.assertTrue(msg.getValue().toString().startsWith("done deserialize:"));
		
		listbox.findWidgets("@listitem").get(2).click();
		Assert.assertEquals("C", selected.getValue());
		Assert.assertEquals("C", tb1.getValue());
		
		tb1.replace("CY");
		save.click();
		Assert.assertEquals("CY", selected.getValue());
		Assert.assertEquals("CY", children.findWidgets("@label").get(2).getValue());
		Assert.assertEquals("CY", listbox.findWidgets("@listitem").get(2).findWidgets("@listcell").get(1).getLabel());
		
	}
	
	@Test
	public void b00892ChildBindingUnderListbox(){
		navigate(getTestCaseUrl("/bind/issue/B00892ChildBindingUnderListbox.zul"));
		
		Widget outerbox = findWidget("$outerbox");
		
		List<Widget> items = outerbox.findWidgets("@listitem");
		
		Assert.assertEquals(4, items.size());
		
		List<Widget> cell = items.get(0).findWidgets("@listcell");
		Assert.assertEquals(2, cell.size());
		Assert.assertEquals("0", cell.get(0).getLabel());
		Assert.assertEquals("A", cell.get(1).getLabel());
		
		cell = items.get(1).findWidgets("@listcell");
		Assert.assertEquals(2, cell.size());
		Assert.assertEquals("1", cell.get(0).getLabel());
		Assert.assertEquals("B", cell.get(1).getLabel());
		
		cell = items.get(2).findWidgets("@listcell");
		Assert.assertEquals(2, cell.size());
		Assert.assertEquals("2", cell.get(0).getLabel());
		Assert.assertEquals("C", cell.get(1).getLabel());
		
		cell = items.get(3).findWidgets("@listcell");
		Assert.assertEquals(2, cell.size());
		Assert.assertEquals("3", cell.get(0).getLabel());
		Assert.assertEquals("D", cell.get(1).getLabel());
	}
	
	@Test
	public void b00913ValueReload(){
		navigate(getTestCaseUrl("/bind/issue/B00913ValueReload.zul"));
		
		Widget tb1 = findWidget("$tb1");
		Widget l1 = findWidget("$l1");
		Widget msg1 = findWidget("$msg1");
		
		Assert.assertEquals("",msg1.getValue());
		
		tb1.replace("abc").tab();
		
		Assert.assertEquals("value has to be def",msg1.getValue());
		Assert.assertEquals("abc",tb1.getValue());
		Assert.assertEquals("KGB",l1.getValue());
		
		tb1.replace("def").tab();
		Assert.assertEquals("",msg1.getValue());
		Assert.assertEquals("def",tb1.getValue());
		Assert.assertEquals("def",l1.getValue());
		
	}
	
	@Test
	public void b00905FormNotifyChange(){
		navigate(getTestCaseUrl("/bind/issue/B00905FormNotifyChange.zul"));
		
		Widget tb = findWidget("$tb");
		Widget l1 = findWidget("$l1");
		Widget l2 = findWidget("$l2");
		Widget l3 = findWidget("$l3");
		Widget btn = findWidget("$btn");
		Widget msg = findWidget("$msg");
		
		
		Assert.assertEquals("Dennis", tb.getValue());
		Assert.assertEquals("Dennis", l1.getValue());
		Assert.assertEquals("Dennis", l2.getValue());
		Assert.assertEquals("Dennis", l3.getValue());
		Assert.assertEquals("Dennis", msg.getValue());
		
		tb.replace("Alex").tab();
		Assert.assertEquals("Alex", tb.getValue());
		Assert.assertEquals("Alex", l1.getValue());
		Assert.assertEquals("Alex", l2.getValue());
		Assert.assertEquals("Alex", l3.getValue());
		Assert.assertEquals("Dennis", msg.getValue());
		
		btn.click();
		Assert.assertEquals("Alex", tb.getValue());
		Assert.assertEquals("Alex", l1.getValue());
		Assert.assertEquals("Alex", l2.getValue());
		Assert.assertEquals("Alex", l3.getValue());
		Assert.assertEquals("Alex", msg.getValue());
		
	}
	
	@Test
	public void b00911FormNotifyChange(){
		navigate(getTestCaseUrl("/bind/issue/B00911FormNotifyChange.zul"));
		
		Widget l1 = findWidget("$l1");
		Widget l2 = findWidget("$l2");
		Widget l3 = findWidget("$l3");
		Widget l4 = findWidget("$l4");
		Widget l5 = findWidget("$l5");
		Widget l6 = findWidget("$l6");
		Widget btn = findWidget("$btn");
		
		Assert.assertEquals("Dennis", l1.getValue());
		Assert.assertEquals("Dennis", l2.getValue());
		Assert.assertEquals("Dennis", l3.getValue());
		Assert.assertEquals("A", l4.getValue());
		Assert.assertEquals("A", l5.getValue());
		Assert.assertEquals("A", l6.getValue());
		
		btn.click();
		Assert.assertEquals("Alex", l1.getValue());
		Assert.assertEquals("Alex", l2.getValue());
		Assert.assertEquals("Alex", l3.getValue());
		Assert.assertEquals("A", l4.getValue());
		Assert.assertEquals("A", l5.getValue());
		Assert.assertEquals("A", l6.getValue());
		
	}
	
	@Test
	public void b00950ReferenceChange(){
		navigate(getTestCaseUrl("/bind/issue/B00950ReferenceChange.zul"));
		
		Widget listbox = findWidget("$listbox");
		Widget l11 = findWidget("$l11");
		Widget l12 = findWidget("$l12");
		Widget l13 = findWidget("$l13");
		Widget l21 = findWidget("$l21");
		Widget l22 = findWidget("$l22");
		Widget l23 = findWidget("$l23");
		Widget clear = findWidget("$clear");
		
		Assert.assertEquals("", l11.getValue());
		Assert.assertEquals("", l12.getValue());
		Assert.assertEquals("", l13.getValue());
		Assert.assertEquals("", l21.getValue());
		Assert.assertEquals("", l22.getValue());
		Assert.assertEquals("", l23.getValue());
		
		listbox.findWidgets("@listitem").get(0).click();
		Assert.assertEquals("Dennis", l11.getValue());
		Assert.assertEquals("Chen", l12.getValue());
		Assert.assertEquals("Dennis Chen", l13.getValue());
		Assert.assertEquals("Dennis", l21.getValue());
		Assert.assertEquals("Chen", l22.getValue());
		Assert.assertEquals("Dennis Chen", l23.getValue());
		
		listbox.findWidgets("@listitem").get(1).click();
		Assert.assertEquals("Alice", l11.getValue());
		Assert.assertEquals("Lin", l12.getValue());
		Assert.assertEquals("Alice Lin", l13.getValue());
		Assert.assertEquals("Alice", l21.getValue());
		Assert.assertEquals("Lin", l22.getValue());
		Assert.assertEquals("Alice Lin", l23.getValue());
		
		listbox.findWidgets("@listitem").get(2).click();
		Assert.assertEquals("", l11.getValue());
		Assert.assertEquals("", l12.getValue());
		Assert.assertEquals("", l13.getValue());
		Assert.assertEquals("", l21.getValue());
		Assert.assertEquals("", l22.getValue());
		Assert.assertEquals("", l23.getValue());
		
		listbox.findWidgets("@listitem").get(1).click();
		listbox.findWidgets("@listitem").get(1).findWidget("@textbox").replace("Grace").tab();
		Assert.assertEquals("Grace", l11.getValue());
		Assert.assertEquals("Lin", l12.getValue());
		Assert.assertEquals("Grace Lin", l13.getValue());
		Assert.assertEquals("Grace", l21.getValue());
		Assert.assertEquals("Lin", l22.getValue());
		Assert.assertEquals("Grace Lin", l23.getValue());
		
		clear.click();
		Assert.assertEquals("", l11.getValue());
		Assert.assertEquals("", l12.getValue());
		Assert.assertEquals("", l13.getValue());
		Assert.assertEquals("", l21.getValue());
		Assert.assertEquals("", l22.getValue());
		Assert.assertEquals("", l23.getValue());
	}
	
	
	
	@Test
	public void b00967GroupModel_1(){
		navigate(getTestCaseUrl("/bind/issue/B00967GroupModel.zul"));
		
		Widget grid = findWidget("$grid");
		List<Widget> groups = grid.findWidgets("@group");
		List<Widget> groupfoots = grid.findWidgets("@groupfoot");
		List<Widget> rows = grid.findWidgets("@row");
		
		Assert.assertEquals(3, groups.size());
		Assert.assertEquals(3, groupfoots.size());
		Assert.assertEquals(5, rows.size());
		
		Assert.assertEquals("Fruits", groups.get(0).getAttribute("label"));
		Assert.assertEquals("Seafood", groups.get(1).getAttribute("label"));
		Assert.assertEquals("Vegetables", groups.get(2).getAttribute("label"));
		
		Assert.assertEquals("1", groupfoots.get(0).findWidget("@label").getAttribute("value"));
		Assert.assertEquals("2", groupfoots.get(1).findWidget("@label").getAttribute("value"));
		Assert.assertEquals("2", groupfoots.get(2).findWidget("@label").getAttribute("value"));
		
		Assert.assertEquals("Apples", rows.get(0).findWidgets("@label").get(1).getAttribute("value"));
		Assert.assertEquals("Salmon", rows.get(1).findWidgets("@label").get(1).getAttribute("value"));
		Assert.assertEquals("Shrimp", rows.get(2).findWidgets("@label").get(1).getAttribute("value"));
		Assert.assertEquals("Asparagus", rows.get(3).findWidgets("@label").get(1).getAttribute("value"));
		Assert.assertEquals("Beets", rows.get(4).findWidgets("@label").get(1).getAttribute("value"));
		
	}
	@Test
	public void b00967GroupModel_2(){
		navigate(getTestCaseUrl("/bind/issue/B00967GroupModelListbox.zul"));
		
		Widget listbox = findWidget("$listbox");
		List<Widget> groups = listbox.findWidgets("@listgroup");
		List<Widget> groupfoots = listbox.findWidgets("@listgroupfoot");
		List<Widget> items = listbox.findWidgets("@listitem");
		Widget l1 = findWidget("$l1");
		Widget sel1 = findWidget("$sel1");
		Widget sel2 = findWidget("$sel2");
		
		Assert.assertEquals(3, groups.size());
		Assert.assertEquals(3, groupfoots.size());
		Assert.assertEquals(5, items.size());
		
		Assert.assertEquals("Fruits", groups.get(0).findWidget("@listcell").getAttribute("label"));
		Assert.assertEquals("Seafood", groups.get(1).findWidget("@listcell").getAttribute("label"));
		Assert.assertEquals("Vegetables", groups.get(2).findWidget("@listcell").getAttribute("label"));
		
		Assert.assertEquals("1", groupfoots.get(0).findWidget("@listcell").getAttribute("label"));
		Assert.assertEquals("2", groupfoots.get(1).findWidget("@listcell").getAttribute("label"));
		Assert.assertEquals("2", groupfoots.get(2).findWidget("@listcell").getAttribute("label"));
		
		Assert.assertEquals("Apples", items.get(0).findWidgets("@label").get(1).getAttribute("value"));
		Assert.assertEquals("Salmon", items.get(1).findWidgets("@label").get(1).getAttribute("value"));
		Assert.assertEquals("Shrimp", items.get(2).findWidgets("@label").get(1).getAttribute("value"));
		Assert.assertEquals("Asparagus", items.get(3).findWidgets("@label").get(1).getAttribute("value"));
		Assert.assertEquals("Beets", items.get(4).findWidgets("@label").get(1).getAttribute("value"));
		
		
		
		items.get(4).click();
		Assert.assertEquals("Beets",l1.getValue());

		sel1.click();
		Assert.assertEquals("Apples",l1.getValue());
		
		sel2.click();
		Assert.assertEquals("Salmon",l1.getValue());
		
	}
	
	@Test
	public void b00967GroupModel_3(){
		navigate(getTestCaseUrl("/bind/issue/B00967GroupModelListboxMultiple.zul"));
		
		Widget listbox = findWidget("$listbox");
		List<Widget> groups = listbox.findWidgets("@listgroup");
		List<Widget> groupfoots = listbox.findWidgets("@listgroupfoot");
		List<Widget> items = listbox.findWidgets("@listitem");
		Widget l1 = findWidget("$l1");
		Widget sel1 = findWidget("$sel1");
		
		Assert.assertEquals(3, groups.size());
		Assert.assertEquals(3, groupfoots.size());
		Assert.assertEquals(5, items.size());
		
		Assert.assertEquals("Fruits", groups.get(0).findWidget("@listcell").getAttribute("label"));
		Assert.assertEquals("Seafood", groups.get(1).findWidget("@listcell").getAttribute("label"));
		Assert.assertEquals("Vegetables", groups.get(2).findWidget("@listcell").getAttribute("label"));
		
		Assert.assertEquals("1", groupfoots.get(0).findWidget("@listcell").getAttribute("label"));
		Assert.assertEquals("2", groupfoots.get(1).findWidget("@listcell").getAttribute("label"));
		Assert.assertEquals("2", groupfoots.get(2).findWidget("@listcell").getAttribute("label"));
		
		Assert.assertEquals("Apples", items.get(0).findWidgets("@label").get(1).getAttribute("value"));
		Assert.assertEquals("Salmon", items.get(1).findWidgets("@label").get(1).getAttribute("value"));
		Assert.assertEquals("Shrimp", items.get(2).findWidgets("@label").get(1).getAttribute("value"));
		Assert.assertEquals("Asparagus", items.get(3).findWidgets("@label").get(1).getAttribute("value"));
		Assert.assertEquals("Beets", items.get(4).findWidgets("@label").get(1).getAttribute("value"));
		
		
		
		items.get(3).click();
		Assert.assertEquals("[Asparagus]",l1.getValue());
		items.get(4).click();
		Assert.assertEquals("[Asparagus, Beets]",l1.getValue());

		sel1.click();
		Assert.assertEquals("[Apples, Shrimp]",l1.getValue());
		Assert.assertArrayEquals(new long[]{0,2}, ListboxUtil.getSelectedIndexs(listbox));
	}
	
	@Test
	public void b00848ValidationMessagesEmpty(){
		navigate(getTestCaseUrl("/bind/issue/B00848ValidationMessagesEmpty.zul"));
		Widget l11 = findWidget("$l11");
		Widget l12 = findWidget("$l12");
		
		Widget t21 = findWidget("$t21");
		Widget t22 = findWidget("$t22");
		
		Widget t31 = findWidget("$t31");
		Widget t32 = findWidget("$t32");
		Widget m31 = findWidget("$m31");
		Widget m32 = findWidget("$m32");
		
		Widget btn1 = findWidget("$btn1");
		
		Widget t41 = findWidget("$t41");
		Widget t42 = findWidget("$t42");
		Widget m41 = findWidget("$m41");
		Widget m42 = findWidget("$m42");
		Widget m43 = findWidget("$m43");
		Widget m44 = findWidget("$m44");
		Widget m45 = findWidget("$m45");
		Widget m46 = findWidget("$m46");
		
		Widget btn2 = findWidget("$btn2");
		Widget btn3 = findWidget("$btn3");
		
		Widget vmsize = findWidget("$vmsize");
		Widget vmempty = findWidget("$vmempty");
		
		Assert.assertEquals("ABC", l11.getValue());
		Assert.assertEquals("10", l12.getValue());
		
		Assert.assertEquals("ABC", t21.getValue());
		Assert.assertEquals(10L, t22.getValue());
		
		Assert.assertEquals("ABC", t31.getValue());
		Assert.assertEquals(10L, t32.getValue());
		Assert.assertEquals("", m31.getValue());
		Assert.assertEquals("", m32.getValue());
		
		Assert.assertEquals("ABC", t41.getValue());
		Assert.assertEquals(10L, t42.getValue());
		Assert.assertEquals("", m41.getValue());
		Assert.assertEquals("", m42.getValue());
		Assert.assertEquals("", m43.getValue());
		Assert.assertEquals("", m44.getValue());
		Assert.assertEquals("0", vmsize.getValue());
		Assert.assertEquals("true", vmempty.getValue());
		
		t21.replace("ABCD").tab().focus(1,1000);
		t22.replace("6").tab().focus(1,1000);
		Assert.assertEquals("ABC", l11.getValue());
		
		Assert.assertEquals("10", l12.getValue());
		
		Assert.assertEquals("ABCD", t21.getValue());
		Assert.assertEquals(6L, t22.getValue());
		Assert.assertEquals("ABC", t31.getValue());
		Assert.assertEquals(10L, t32.getValue());
		Assert.assertEquals("", m31.getValue());
		Assert.assertEquals("", m32.getValue());
		Assert.assertEquals("ABC", t41.getValue());
		Assert.assertEquals(10L, t42.getValue());
		Assert.assertEquals("", m41.getValue());
		Assert.assertEquals("", m42.getValue());
		Assert.assertEquals("", m43.getValue());
		Assert.assertEquals("", m44.getValue());
		
		Assert.assertEquals("2", vmsize.getValue());
		Assert.assertEquals("false", vmempty.getValue());
		
		
		t21.replace("Abc").tab().focus(1,1000);
		t22.replace("33").tab().focus(1,1000);//intbox has reset issue...too bad
		Assert.assertEquals("Abc", l11.getValue());
		
		Assert.assertEquals("33", l12.getValue());
		
		Assert.assertEquals("Abc", t21.getValue());
		Assert.assertEquals(33L, t22.getValue());
		Assert.assertEquals("Abc", t31.getValue());
		Assert.assertEquals(33L, t32.getValue());
		Assert.assertEquals("", m31.getValue());
		Assert.assertEquals("", m32.getValue());
		Assert.assertEquals("ABC", t41.getValue());
		Assert.assertEquals(10L, t42.getValue());
		Assert.assertEquals("", m41.getValue());
		Assert.assertEquals("", m42.getValue());
		Assert.assertEquals("", m43.getValue());
		Assert.assertEquals("", m44.getValue());
		
		Assert.assertEquals("0", vmsize.getValue());
		Assert.assertEquals("true", vmempty.getValue());
		
		
		t31.replace("XXX").tab().focus(0,0);
		t32.replace("1").tab().focus(0,0);//intbox has reset issue...too bad
		Assert.assertEquals("Abc", l11.getValue());
		Assert.assertEquals("33", l12.getValue());
		Assert.assertEquals("Abc", t21.getValue());
		Assert.assertEquals(33L, t22.getValue());
		Assert.assertEquals("XXX", t31.getValue());
		Assert.assertEquals(1L, t32.getValue());
		Assert.assertEquals("", m31.getValue());
		Assert.assertEquals("", m32.getValue());
		Assert.assertEquals("ABC", t41.getValue());
		Assert.assertEquals(10L, t42.getValue());
		Assert.assertEquals("", m41.getValue());
		Assert.assertEquals("", m42.getValue());
		Assert.assertEquals("", m43.getValue());
		Assert.assertEquals("", m44.getValue());
		
		Assert.assertEquals("0", vmsize.getValue());
		Assert.assertEquals("true", vmempty.getValue());
		
		btn1.click();
		Assert.assertEquals("Abc", l11.getValue());
		Assert.assertEquals("33", l12.getValue());
		Assert.assertEquals("Abc", t21.getValue());
		Assert.assertEquals(33L, t22.getValue());
		Assert.assertEquals("XXX", t31.getValue());
		Assert.assertEquals(1L, t32.getValue());
		Assert.assertEquals("value must equals ignore case 'abc', but is XXX", m31.getValue());
		Assert.assertEquals("value must not < 10 or > 100, but is 1", m32.getValue());
		Assert.assertEquals("ABC", t41.getValue());
		Assert.assertEquals(10L, t42.getValue());
		Assert.assertEquals("", m41.getValue());
		Assert.assertEquals("", m42.getValue());
		Assert.assertEquals("", m43.getValue());
		Assert.assertEquals("", m44.getValue());
		
		Assert.assertEquals("2", vmsize.getValue());
		Assert.assertEquals("false", vmempty.getValue());
		
		t32.replace("55").tab().focus(0,0);//intbox has reset issue...too bad
		Assert.assertEquals("Abc", l11.getValue());
		Assert.assertEquals("33", l12.getValue());
		Assert.assertEquals("Abc", t21.getValue());
		Assert.assertEquals(33L, t22.getValue());
		Assert.assertEquals("XXX", t31.getValue());
		Assert.assertEquals(55L, t32.getValue());
		Assert.assertEquals("value must equals ignore case 'abc', but is XXX", m31.getValue());
		Assert.assertEquals("value must not < 10 or > 100, but is 1", m32.getValue());
		Assert.assertEquals("ABC", t41.getValue());
		Assert.assertEquals(10L, t42.getValue());
		Assert.assertEquals("", m41.getValue());
		Assert.assertEquals("", m42.getValue());
		Assert.assertEquals("", m43.getValue());
		Assert.assertEquals("", m44.getValue());
		
		btn1.click();
		Assert.assertEquals("Abc", l11.getValue());
		Assert.assertEquals("33", l12.getValue());
		Assert.assertEquals("Abc", t21.getValue());
		Assert.assertEquals(33L, t22.getValue());
		Assert.assertEquals("XXX", t31.getValue());
		Assert.assertEquals(55L, t32.getValue());
		Assert.assertEquals("value must equals ignore case 'abc', but is XXX", m31.getValue());
		Assert.assertEquals("", m32.getValue());
		Assert.assertEquals("ABC", t41.getValue());
		Assert.assertEquals(10L, t42.getValue());
		Assert.assertEquals("", m41.getValue());
		Assert.assertEquals("", m42.getValue());
		Assert.assertEquals("", m43.getValue());
		Assert.assertEquals("", m44.getValue());
		
		Assert.assertEquals("1", vmsize.getValue());
		Assert.assertEquals("false", vmempty.getValue());
		
		t31.replace("aBC").tab().focus(0,0);//intbox has reset issue...too bad
		Assert.assertEquals("Abc", l11.getValue());
		Assert.assertEquals("33", l12.getValue());
		Assert.assertEquals("Abc", t21.getValue());
		Assert.assertEquals(33L, t22.getValue());
		Assert.assertEquals("aBC", t31.getValue());
		Assert.assertEquals(55L, t32.getValue());
		Assert.assertEquals("value must equals ignore case 'abc', but is XXX", m31.getValue());
		Assert.assertEquals("", m32.getValue());
		Assert.assertEquals("ABC", t41.getValue());
		Assert.assertEquals(10L, t42.getValue());
		Assert.assertEquals("", m41.getValue());
		Assert.assertEquals("", m42.getValue());
		Assert.assertEquals("", m43.getValue());
		Assert.assertEquals("", m44.getValue());
		
		btn1.click();
		Assert.assertEquals("aBC", l11.getValue());
		Assert.assertEquals("55", l12.getValue());
		Assert.assertEquals("aBC", t21.getValue());
		Assert.assertEquals(55L, t22.getValue());
		Assert.assertEquals("aBC", t31.getValue());
		Assert.assertEquals(55L, t32.getValue());
		Assert.assertEquals("", m31.getValue());
		Assert.assertEquals("", m32.getValue());
		Assert.assertEquals("ABC", t41.getValue());
		Assert.assertEquals(10L, t42.getValue());
		Assert.assertEquals("", m41.getValue());
		Assert.assertEquals("", m42.getValue());
		Assert.assertEquals("", m43.getValue());
		Assert.assertEquals("", m44.getValue());
		
		Assert.assertEquals("0", vmsize.getValue());
		Assert.assertEquals("true", vmempty.getValue());
		
		/////////
		
		t41.replace("YYY").tab().focus(0,0);
		t42.replace("1999").tab().focus(0,0);//intbox has reset issue...too bad
		Assert.assertEquals("aBC", l11.getValue());
		Assert.assertEquals("55", l12.getValue());
		Assert.assertEquals("aBC", t21.getValue());
		Assert.assertEquals(55L, t22.getValue());
		Assert.assertEquals("aBC", t31.getValue());
		Assert.assertEquals(55L, t32.getValue());
		Assert.assertEquals("", m31.getValue());
		Assert.assertEquals("", m32.getValue());
		Assert.assertEquals("YYY", t41.getValue());
		Assert.assertEquals(1999L, t42.getValue());
		Assert.assertEquals("value must equals ignore case 'abc', but is YYY", m41.getValue());
		Assert.assertEquals("value must not < 10 or > 100, but is 1999", m42.getValue());
		Assert.assertEquals("", m43.getValue());
		Assert.assertEquals("", m44.getValue());
		
		Assert.assertEquals("2", vmsize.getValue());
		Assert.assertEquals("false", vmempty.getValue());
		
		btn2.click();
		Assert.assertEquals("aBC", l11.getValue());
		Assert.assertEquals("55", l12.getValue());
		Assert.assertEquals("aBC", t21.getValue());
		Assert.assertEquals(55L, t22.getValue());
		Assert.assertEquals("aBC", t31.getValue());
		Assert.assertEquals(55L, t32.getValue());
		Assert.assertEquals("", m31.getValue());
		Assert.assertEquals("", m32.getValue());
		Assert.assertEquals("YYY", t41.getValue());
		Assert.assertEquals(1999L, t42.getValue());
		Assert.assertEquals("value must equals ignore case 'abc', but is YYY", m41.getValue());
		Assert.assertEquals("value must not < 10 or > 100, but is 1999", m42.getValue());
		Assert.assertEquals("value must equals 'AbC', but is ABC", m43.getValue());
		Assert.assertEquals("value must equals 'AbC', but is ABC", m44.getValue());
		Assert.assertEquals("value must equals 'AbC', but is ABC", m45.getValue());
		Assert.assertEquals("extra validation info ABC", m46.getValue());
		
		Assert.assertEquals("4", vmsize.getValue());
		Assert.assertEquals("false", vmempty.getValue());
		
		
		t41.replace("abc").tab().focus(0,0);
		t42.replace("77").tab().focus(0,0);//intbox has reset issue...too bad
		Assert.assertEquals("aBC", l11.getValue());
		Assert.assertEquals("55", l12.getValue());
		Assert.assertEquals("aBC", t21.getValue());
		Assert.assertEquals(55L, t22.getValue());
		Assert.assertEquals("aBC", t31.getValue());
		Assert.assertEquals(55L, t32.getValue());
		Assert.assertEquals("", m31.getValue());
		Assert.assertEquals("", m32.getValue());
		Assert.assertEquals("abc", t41.getValue());
		Assert.assertEquals(77L, t42.getValue());
		Assert.assertEquals("", m41.getValue());
		Assert.assertEquals("", m42.getValue());
		Assert.assertEquals("value must equals 'AbC', but is ABC", m43.getValue());
		Assert.assertEquals("value must equals 'AbC', but is ABC", m44.getValue());
		Assert.assertEquals("value must equals 'AbC', but is ABC", m45.getValue());
		Assert.assertEquals("extra validation info ABC", m46.getValue());
		
		Assert.assertEquals("2", vmsize.getValue());
		Assert.assertEquals("false", vmempty.getValue());
		
		btn2.click();
		Assert.assertEquals("aBC", l11.getValue());
		Assert.assertEquals("55", l12.getValue());
		Assert.assertEquals("aBC", t21.getValue());
		Assert.assertEquals(55L, t22.getValue());
		Assert.assertEquals("aBC", t31.getValue());
		Assert.assertEquals(55L, t32.getValue());
		Assert.assertEquals("", m31.getValue());
		Assert.assertEquals("", m32.getValue());
		Assert.assertEquals("abc", t41.getValue());
		Assert.assertEquals(77L, t42.getValue());
		Assert.assertEquals("", m41.getValue());
		Assert.assertEquals("", m42.getValue());
		Assert.assertEquals("value must equals 'AbC', but is abc", m43.getValue());
		Assert.assertEquals("value must equals 'AbC', but is abc", m44.getValue());
		Assert.assertEquals("value must equals 'AbC', but is abc", m45.getValue());
		Assert.assertEquals("extra validation info abc", m46.getValue());
		
		Assert.assertEquals("2", vmsize.getValue());
		Assert.assertEquals("false", vmempty.getValue());
		
		t41.replace("AbC").tab().focus(0,0);
		btn2.click();
		Assert.assertEquals("AbC", l11.getValue());
		Assert.assertEquals("77", l12.getValue());
		Assert.assertEquals("AbC", t21.getValue());
		Assert.assertEquals(77L, t22.getValue());
		Assert.assertEquals("AbC", t31.getValue());
		Assert.assertEquals(77L, t32.getValue());
		Assert.assertEquals("", m31.getValue());
		Assert.assertEquals("", m32.getValue());
		Assert.assertEquals("AbC", t41.getValue());
		Assert.assertEquals(77L, t42.getValue());
		Assert.assertEquals("", m41.getValue());
		Assert.assertEquals("", m42.getValue());
		Assert.assertEquals("", m43.getValue());
		Assert.assertEquals("", m44.getValue());
		
		
		t31.replace("YYY").tab().focus(0,0);
		t32.replace("2").tab().focus(0,0);//intbox has reset issue...too bad
		btn1.click();
		Assert.assertEquals("YYY", t31.getValue());
		Assert.assertEquals(2L, t32.getValue());
		Assert.assertEquals("value must equals ignore case 'abc', but is YYY", m31.getValue());
		Assert.assertEquals("value must not < 10 or > 100, but is 2", m32.getValue());
		
		Assert.assertEquals("2", vmsize.getValue());
		Assert.assertEquals("false", vmempty.getValue());
		
		btn3.click();
		Assert.assertEquals("AbC", t31.getValue());
		Assert.assertEquals(2L, t32.getValue());
		Assert.assertEquals("", m31.getValue());
		Assert.assertEquals("value must not < 10 or > 100, but is 2", m32.getValue());
		
		Assert.assertEquals("1", vmsize.getValue());
		Assert.assertEquals("false", vmempty.getValue());
	}
	
	@Test
	public void b00758Indirect(){
		navigate(getTestCaseUrl("/bind/issue/B00758Indirect.zul"));
		Widget grid = findWidget("$grid");
		Widget btn1 = findWidget("$btn1");
		Widget btn2 = findWidget("$btn2");
		List<Widget> rows = grid.findWidgets("@row");
		Assert.assertEquals("First0",rows.get(0).findWidgets("@textbox").get(0).getValue());
		Assert.assertEquals("Last0",rows.get(0).findWidgets("@textbox").get(1).getValue());
		Assert.assertEquals("First0 Last0",rows.get(0).findWidget("@label").getValue());
		
		btn1.click();
		rows = grid.findWidgets("@row");
		Assert.assertEquals("Tom",rows.get(0).findWidgets("@textbox").get(0).getValue());
		Assert.assertEquals("Last0",rows.get(0).findWidgets("@textbox").get(1).getValue());
		Assert.assertEquals("Tom Last0",rows.get(0).findWidget("@label").getValue());
		
		btn2.click();
		rows = grid.findWidgets("@row");
		Assert.assertEquals("Henri",rows.get(0).findWidgets("@textbox").get(0).getValue());
		Assert.assertEquals("Chen",rows.get(0).findWidgets("@textbox").get(1).getValue());
		Assert.assertEquals("Henri Chen",rows.get(0).findWidget("@label").getValue());
	}
	
	@Test
	public void b00B00994InitParam(){
		navigate(getTestCaseUrl("/bind/issue/B00994InitParam.zul"));
		Widget l1 = findWidget("$l1");
		Widget l2 = findWidget("$l2");
		
		Assert.assertEquals("foo", l1.getValue());
		Assert.assertEquals("bar", l2.getValue());
	}
	
	@Test
	public void b00993IncludeReload(){
		navigate(getTestCaseUrl("/bind/issue/B00993IncludeReload.zul"));
		Widget l1 = findWidget("$l1");
		Widget l2 = findWidget("$l2");
		Widget reload = findWidget("$reload");
		
		String val1 = (String)l1.getValue();
		String val2 = (String)l2.getValue();
		reload.click();
		l1 = findWidget("$l1");
		l2 = findWidget("$l2");
		Assert.assertFalse(val1.equals(l1.getValue()));
		Assert.assertFalse(val2.equals(l2.getValue()));
		
		val1 = (String)l1.getValue();
		val2 = (String)l2.getValue();
		reload.click();
		l1 = findWidget("$l1");
		l2 = findWidget("$l2");
		Assert.assertFalse(val1.equals(l1.getValue()));
		Assert.assertFalse(val2.equals(l2.getValue()));
		
		val1 = (String)l1.getValue();
		val2 = (String)l2.getValue();
		reload.click();
		l1 = findWidget("$l1");
		l2 = findWidget("$l2");
		Assert.assertFalse(val1.equals(l1.getValue()));
		Assert.assertFalse(val2.equals(l2.getValue()));
		
		val1 = (String)l1.getValue();
		val2 = (String)l2.getValue();
		reload.click();
		l1 = findWidget("$l1");
		l2 = findWidget("$l2");
		Assert.assertFalse(val1.equals(l1.getValue()));
		Assert.assertFalse(val2.equals(l2.getValue()));
	}
	
	@Test
	public void b00992SubModel(){
		navigate(getTestCaseUrl("/bind/issue/B00992SubModel.zul"));
		Widget combobox = findWidget("$combobox");
		Widget lab = findWidget("$lab");
		
		combobox.replace("9").tab();
		Assert.assertEquals("9", lab.getValue());
		
		combobox.call("open");
		
		waitForTrip(1, 1000);
		
		Widget w = combobox.findWidgets("@comboitem").get(10);
		
		Assert.assertEquals("99", w.getLabel());
		w.click();
		
		Assert.assertEquals("99", lab.getValue());
	}
}
