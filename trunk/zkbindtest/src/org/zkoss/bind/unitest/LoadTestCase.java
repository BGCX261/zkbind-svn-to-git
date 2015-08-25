package org.zkoss.bind.unitest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.zkoss.zktc.core.junit.TestCaseBase;
import org.zkoss.zktc.core.widget.Widget;
import org.zkoss.zktc.core.widget.WidgetDriver;

public class LoadTestCase extends TestCaseBase{

	
	@Test
	public void testLoad(){
		WidgetDriver driver = getDriver();
		driver.navigate(getTestCaseUrl("/test/zkbind-load.zul"));
		
		Widget l1 = driver.findWidget("$l1");
		Widget l2 = driver.findWidget("$l2");
		Widget l3 = driver.findWidget("$l3");
		
		Assert.assertNotNull(l1);
		Assert.assertNotNull(l2);
		Assert.assertNotNull(l3);
		
		Assert.assertEquals("First1", l1.getAttribute("value"));
		Assert.assertEquals("Last1", l2.getAttribute("value"));
		Assert.assertEquals("First1 Last1", l3.getAttribute("value"));
		
		Widget btn = driver.findWidget("@button:first");
		btn.click();
		
		Assert.assertEquals("", l1.getAttribute("value"));
		Assert.assertEquals("", l2.getAttribute("value"));
		Assert.assertEquals("", l3.getAttribute("value"));
		
		
		
	}
	
	@Test
	public void testLoadForm(){
		WidgetDriver driver = getDriver();
		driver.navigate(getTestCaseUrl("/test/zkbind-load-form.zul"));
		
		Widget row = driver.findWidget("$row1");
		List<Widget> cs = row.getChildren();
		Assert.assertEquals(4, cs.size());
		
		Widget l1 = cs.get(0);
		Widget l2 = cs.get(1);
		Widget l3 = cs.get(2);
		Widget l4 = cs.get(3);
		
		Assert.assertEquals("First1", l1.getAttribute("value"));
		Assert.assertEquals("Last1", l2.getAttribute("value"));
		Assert.assertEquals("First1 Last1", l3.getAttribute("value"));
		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei", l4.getAttribute("value"));
		
	}
	
	@Test
	public void testLoadFormArray(){
		WidgetDriver driver = getDriver();
		driver.navigate(getTestCaseUrl("/test/zkbind-load-form-array.zul"));
		
		Widget row = driver.findWidget("$row1");
		List<Widget> cs = row.getChildren();
		Assert.assertEquals(4, cs.size());
		
		Widget l1 = cs.get(0);
		Widget l2 = cs.get(1);
		Widget l3 = cs.get(2);
		Widget l4 = cs.get(3);
		
		Assert.assertEquals("First1", l1.getAttribute("value"));
		Assert.assertEquals("Last1", l2.getAttribute("value"));
		Assert.assertEquals("First1 Last1", l3.getAttribute("value"));
		Assert.assertEquals("87 Zhengzhou Road #11F-2 Taipei", l4.getAttribute("value"));
		
	}
	
	@Test
	public void testLoadGrid(){
		WidgetDriver driver = getDriver();
		driver.navigate(getTestCaseUrl("/test/zkbind-load-grid.zul"));
		
		Widget grid = driver.findWidget("@grid");
		
		List<Widget> rows = grid.findWidgets("@row");
		Assert.assertEquals(4, rows.size());
		
		for(int i = 0;i<4;i++){
			Widget row = rows.get(i);
			List<Widget> labels = row.getChildren();
			Assert.assertEquals(3, labels.size());
			Assert.assertEquals("First"+i, labels.get(0).getAttribute("value"));
			Assert.assertEquals("Last"+i, labels.get(1).getAttribute("value"));
			Assert.assertEquals("First"+i+" Last"+i, labels.get(2).getAttribute("value"));
		}
		
		Widget btn = driver.findWidget("@button:first");
		//delete one row
		btn.click();
		
		//current version, the grid is invaliate, so i need to get it again.
		grid = driver.findWidget("@grid");
		
		rows = grid.findWidgets("@row");
		Assert.assertEquals(3, rows.size());
		
		for(int i = 0;i<3;i++){
			Widget row = rows.get(i);
			
			int j = i<=0?i:i+1;//2nd row was removed.
			
			List<Widget> labels = row.getChildren();
			Assert.assertEquals(3, labels.size());
			Assert.assertEquals("First"+j, labels.get(0).getAttribute("value"));
			Assert.assertEquals("Last"+j, labels.get(1).getAttribute("value"));
			Assert.assertEquals("First"+j+" Last"+j, labels.get(2).getAttribute("value"));
		}
		
		//delete one row
		btn.click();
		
		//current version, the grid is invaliate, so i need to get it again.
		grid = driver.findWidget("@grid");
		
		rows = grid.findWidgets("@row");
		Assert.assertEquals(2, rows.size());
		
		for(int i = 0;i<2;i++){
			Widget row = rows.get(i);
			
			int j = i<=0?i:i+2;//2,3nd row was removed.
			
			List<Widget> labels = row.getChildren();
			Assert.assertEquals(3, labels.size());
			Assert.assertEquals("First"+j, labels.get(0).getAttribute("value"));
			Assert.assertEquals("Last"+j, labels.get(1).getAttribute("value"));
			Assert.assertEquals("First"+j+" Last"+j, labels.get(2).getAttribute("value"));
		}
		
	}
	
	@Test
	public void testLoadArray(){
		WidgetDriver driver = getDriver();
		driver.navigate(getTestCaseUrl("/test/zkbind-load-array.zul"));
		
		Widget wd = driver.findWidget("@label");
		Assert.assertNotNull(wd);
		
		Assert.assertEquals("First1 Last1", wd.getAttribute("value"));
	}
}
