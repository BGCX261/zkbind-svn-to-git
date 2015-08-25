package org.zkoss.bind.unitest2;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.zkoss.zktc.core.junit.TestCaseBase;
import org.zkoss.zktc.core.widget.Widget;

public class MemoryTest  extends TestCaseBase{

	int loop = 10;
	
	@Test
	public void testList(){
		navigate(getTestCaseUrl("/bind/cases/order/order.zul"));
		Widget main = findWidget("$main");
		Assert.assertNotNull(main);
		for(int i=0;i<loop;i++){
			testList0(i);
			testEdit0(i);
			testNew0(i);
			testDelete0(i);
		}
		
		findWidget("$detachAll").click();
		main = findWidget("$main");
		Assert.assertNull(main);
	}
	private void testList0(int count){
		Widget editor = findWidget("$editor");
		Widget listbox = findWidget("$orderList");
		
		List<Widget> items = listbox.findWidgets("@listitem");
		Assert.assertEquals(5, items.size());
		
		for(int i=0;i<items.size();i++){
			Widget item = items.get(i);
			item.click();
			Assert.assertEquals(true,editor.isVisible());
			
			Widget id = editor.findWidget("$id");
			if(count==0){
				Assert.assertEquals("0000"+(i+1), id.getValue());
			}
		}
	}
	
	private void testEdit0(int count){
		Widget editor = findWidget("$editor");
		Widget listbox = findWidget("$orderList");
		
		List<Widget> items = listbox.findWidgets("@listitem");
		Assert.assertEquals(5, items.size());
		
		for(int i=0;i<items.size();i++){
			Widget item = items.get(i);
			item.click();
			Assert.assertEquals(true,editor.isVisible());
			
			Widget id = editor.findWidget("$id");
			String idstr = (String)id.getValue();
			
			if(count==0){
				Assert.assertEquals("0000"+(i+1), idstr);
			}
			
			Widget desc = editor.findWidget("$desc");
//			if(count>0){
//				Assert.assertEquals("0000"+(i+1)+",count:"+count, desc.getValue());
//			}
			desc.clear().keys("0000"+(i+1)+",count:"+(count+1));
			findWidget("$saveBtn").click();
		}
	}
	
	private void testNew0(int count){
		Widget editor = findWidget("$editor");
		Widget listbox = findWidget("$orderList");
		List<Widget> items = listbox.findWidgets("@listitem");
		int oldsize = items.size();
		
		findWidget("$newBtn").click();
		
		
		Widget desc = editor.findWidget("$desc");
		Widget quantity = editor.findWidget("$quantity");
		Widget price = editor.findWidget("$price");
		Widget creationDate = editor.findWidget("$creationDate");
		Widget shippingDate = editor.findWidget("$shippingDate");
		String descstr = "new order in loop "+count; 
		String pricestr = ""+(count+1);
		desc.keys(descstr);
		quantity.clear().keys(pricestr);
		price.clear().keys(""+(count+1)*100);
		creationDate.clear().keys("2011/11/11");
		shippingDate.clear().keys("2011/11/11");
		
		findWidget("$saveBtn").click();
		
		
		
		items = listbox.findWidgets("@listitem");
		int newsize = items.size();
		Assert.assertEquals(oldsize+1, newsize);
		
		Widget neworder = items.get(items.size()-1);
		Widget newdesc = neworder.findWidgets("@listcell").get(1);
		Assert.assertEquals("0", newdesc.getLabel());
		
		
		shippingDate.clear().keys("2011/11/15");
		
		findWidget("$saveBtn").click();
		items = listbox.findWidgets("@listitem");
		newsize = items.size();
		Assert.assertEquals(oldsize+1, newsize);
		
		neworder = items.get(items.size()-1);
		newdesc = neworder.findWidgets("@listcell").get(1);
		Assert.assertNotSame(pricestr, newdesc.getLabel());
		
	}
	
	private void testDelete0(int count){
		
		Widget listbox = findWidget("$orderList");
		List<Widget> items = listbox.findWidgets("@listitem");
		int oldsize = items.size();
		
		Widget item = items.get(0);
		item.click();

		findWidget("$deleteBtn1").click();
		
		Widget dialog = findWidget("$dialog");
		Assert.assertTrue(dialog.isVisible());
		dialog.findWidget("$cancelBtn").click();
		Assert.assertFalse(dialog.isVisible());
		
		items = listbox.findWidgets("@listitem");
		int newsize = items.size();
		
		Assert.assertEquals(oldsize, newsize);
		
		findWidget("$deleteBtn1").click();
		dialog = findWidget("$dialog");
		Assert.assertTrue(dialog.isVisible());
		dialog.findWidget("$deleteBtn2").click();
		Assert.assertFalse(dialog.isVisible());
		
		items = listbox.findWidgets("@listitem");
		newsize = items.size();
		Assert.assertEquals(oldsize-1, newsize);
	}
}
