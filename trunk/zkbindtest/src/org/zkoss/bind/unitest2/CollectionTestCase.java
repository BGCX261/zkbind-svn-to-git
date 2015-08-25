package org.zkoss.bind.unitest2;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.zkoss.zktc.core.junit.TestCaseBase;
import org.zkoss.zktc.core.widget.Widget;
import org.zkoss.zktc.core.widget.Widgets;

public class CollectionTestCase  extends TestCaseBase{
	@Test
	public void indexListbox1(){
		navigate(getTestCaseUrl("/bind/basic/collection-index-listbox.zul"));
		
		Widget outerbox = findWidget("$outerbox");
		List<Widget> outeritems = outerbox.getChildren();//include header
		outeritems.remove(0);//don't care header
		
		String[] itemLabel = new String[]{"A","B","C", "D"};
		Assert.assertEquals(itemLabel.length, outeritems.size());
		
		for(int i=0;i<itemLabel.length;i++){
			Widget outeritem = outeritems.get(i);
			String outerl = itemLabel[i];
			
			Widget cell = outeritem.getFirstChild();
			Assert.assertEquals(""+i, cell.getLabel());// verify the index
			cell = cell.getNextSibling();
			Assert.assertEquals(outerl, cell.getLabel());//verify the label
			
			Widget innerbox = outeritem.findWidget("@listbox");
			Assert.assertNotNull(innerbox);
			List<Widget> inneritems = innerbox.findWidgets("@listitem");
			Assert.assertEquals(2, inneritems.size());
			for(int j=0;j<2;j++){
				Widget inneritem = inneritems.get(j);
				cell = inneritem.getFirstChild();
				Assert.assertEquals(""+j, cell.getLabel());
				cell = cell.getNextSibling();
				Assert.assertEquals(""+i, cell.getLabel());
				
				String innerl = itemLabel[i]+" "+j;
				cell = cell.getNextSibling();
				Assert.assertEquals(innerl, cell.getLabel());
			}
			
			cell = outeritem.getLastChild();
			Widget btn = cell.findWidget("@button");//index button
			Widget msg = findWidget("$msg");
			btn.click();
			
			Assert.assertEquals("item index "+i, msg.getValue());
		}
	}
	
	@Test
	public void indexListbox2(){
		navigate(getTestCaseUrl("/bind/basic/collection-index-listbox.zul"));
		
		Widget outerbox = findWidget("$outerbox");
		List<Widget> outeritems = outerbox.getChildren();//include header
		outeritems.remove(0);//don't care header
		
		//=================================delete 2rd row
		Widget outeritem = outeritems.get(1);
		outeritem.findWidgets("@button").get(1).click();//click the delete button on 2nd row
		
		outerbox = findWidget("$outerbox");
		outeritems = outerbox.getChildren();//include header
		outeritems.remove(0);//don't care header
		String[] itemLabel = new String[]{"A","C", "D"};
		Assert.assertEquals(itemLabel.length, outeritems.size());
		
		for(int i=0;i<itemLabel.length;i++){
			outeritem = outeritems.get(i);
			String outerl = itemLabel[i];
			
			Widget cell = outeritem.getFirstChild();
			Assert.assertEquals(""+i, cell.getLabel());// verify the index
			cell = cell.getNextSibling();
			Assert.assertEquals(outerl, cell.getLabel());//verify the label
			
			Widget innerbox = outeritem.findWidget("@listbox");
			Assert.assertNotNull(innerbox);
			List<Widget> inneritems = innerbox.findWidgets("@listitem");
			Assert.assertEquals(2, inneritems.size());
			for(int j=0;j<2;j++){
				Widget inneritem = inneritems.get(j);
				cell = inneritem.getFirstChild();
				Assert.assertEquals(""+j, cell.getLabel());
				cell = cell.getNextSibling();
				Assert.assertEquals(""+i, cell.getLabel());
				
				String innerl = itemLabel[i]+" "+j;
				cell = cell.getNextSibling();
				Assert.assertEquals(innerl, cell.getLabel());
			}
			
			cell = outeritem.getLastChild();
			Widget btn = cell.findWidget("@button");//index button
			Widget msg = findWidget("$msg");
			btn.click();
			
			Assert.assertEquals("item index "+i, msg.getValue());
		}
		
		//===============================add after row
		outeritem = outeritems.get(1);
		outeritem.findWidgets("@button").get(2).click();//click the add after button on 2nd row
		
		outerbox = findWidget("$outerbox");
		outeritems = outerbox.getChildren();//include header
		outeritems.remove(0);//don't care header
		itemLabel = new String[]{"A","C","C1","D"};
		Assert.assertEquals(itemLabel.length, outeritems.size());
		
		for(int i=0;i<itemLabel.length;i++){
			outeritem = outeritems.get(i);
			String outerl = itemLabel[i];
			
			Widget cell = outeritem.getFirstChild();
			Assert.assertEquals(""+i, cell.getLabel());// verify the index
			cell = cell.getNextSibling();
			Assert.assertEquals(outerl, cell.getLabel());//verify the label
			
			Widget innerbox = outeritem.findWidget("@listbox");
			Assert.assertNotNull(innerbox);
			List<Widget> inneritems = innerbox.findWidgets("@listitem");
			Assert.assertEquals(2, inneritems.size());
			for(int j=0;j<2;j++){
				Widget inneritem = inneritems.get(j);
				cell = inneritem.getFirstChild();
				Assert.assertEquals(""+j, cell.getLabel());
				cell = cell.getNextSibling();
				Assert.assertEquals(""+i, cell.getLabel());
				
				String innerl = itemLabel[i]+" "+j;
				cell = cell.getNextSibling();
				Assert.assertEquals(innerl, cell.getLabel());
			}
			
			cell = outeritem.getLastChild();
			Widget btn = cell.findWidget("@button");//index button
			Widget msg = findWidget("$msg");
			btn.click();
			
			Assert.assertEquals("item index "+i, msg.getValue());
		}
		
		//===============================add add before row
		outeritem = outeritems.get(2);
		outeritem.findWidgets("@button").get(3).click();//click the add before button on 2nd row
		
		outerbox = findWidget("$outerbox");
		outeritems = outerbox.getChildren();//include header
		outeritems.remove(0);//don't care header
		itemLabel = new String[]{"A","C","C12","C1","D"};
		Assert.assertEquals(itemLabel.length, outeritems.size());
		
		for(int i=0;i<itemLabel.length;i++){
			outeritem = outeritems.get(i);
			String outerl = itemLabel[i];
			
			Widget cell = outeritem.getFirstChild();
			Assert.assertEquals(""+i, cell.getLabel());// verify the index
			cell = cell.getNextSibling();
			Assert.assertEquals(outerl, cell.getLabel());//verify the label
			
			Widget innerbox = outeritem.findWidget("@listbox");
			Assert.assertNotNull(innerbox);
			List<Widget> inneritems = innerbox.findWidgets("@listitem");
			Assert.assertEquals(2, inneritems.size());
			for(int j=0;j<2;j++){
				Widget inneritem = inneritems.get(j);
				cell = inneritem.getFirstChild();
				Assert.assertEquals(""+j, cell.getLabel());
				cell = cell.getNextSibling();
				Assert.assertEquals(""+i, cell.getLabel());
				
				String innerl = itemLabel[i]+" "+j;
				cell = cell.getNextSibling();
				Assert.assertEquals(innerl, cell.getLabel());
			}
			
			cell = outeritem.getLastChild();
			Widget btn = cell.findWidget("@button");//index button
			Widget msg = findWidget("$msg");
			btn.click();
			
			Assert.assertEquals("item index "+i, msg.getValue());
		}
	}
	
	
	@Test
	public void indexGrid1(){
		navigate(getTestCaseUrl("/bind/basic/collection-index-grid.zul"));
		
		Widget outerbox = findWidget("$outergrid");
		List<Widget> outerrows = outerbox.findWidget("@rows").getChildren();
		
		String[] itemLabel = new String[]{"A","B","C", "D"};
		Assert.assertEquals(itemLabel.length, outerrows.size());
		
		for(int i=0;i<itemLabel.length;i++){
			Widget outerrow = outerrows.get(i);
			String outerl = itemLabel[i];
			
			Widget rowkid = outerrow.getFirstChild();
			Assert.assertEquals(""+i, rowkid.getValue());// verify the index  on label
			rowkid = rowkid.getNextSibling();
			Assert.assertEquals(outerl, rowkid.getValue());//verify the label on label
			
			Widget innergrid = rowkid.getNextSibling();
			Assert.assertNotNull(innergrid);
			List<Widget> innerrows = innergrid.findWidgets("@row");
			Assert.assertEquals(2, innerrows.size());
			for(int j=0;j<2;j++){
				Widget innerrow = innerrows.get(j);
				rowkid = innerrow.getFirstChild();
				Assert.assertEquals(""+j, rowkid.getValue());
				rowkid = rowkid.getNextSibling();
				Assert.assertEquals(""+i, rowkid.getValue());
				
				String innerl = itemLabel[i]+" "+j;
				rowkid = rowkid.getNextSibling();
				Assert.assertEquals(innerl, rowkid.getValue());
			}
			
			rowkid = outerrow.getLastChild();
			Widget btn = rowkid.findWidget("@button");//index button
			Widget msg = findWidget("$msg");
			btn.click();
			
			Assert.assertEquals("item index "+i, msg.getValue());
		}
	}
	
	@Test
	public void indexGrid2(){
		navigate(getTestCaseUrl("/bind/basic/collection-index-grid.zul"));
		
		Widget outerbox = findWidget("$outergrid");
		List<Widget> outerrows = outerbox.findWidget("@rows").getChildren();
		
		//=================================delete 2rd row
		Widget outeritem = outerrows.get(1);
		outeritem.findWidgets("@button").get(1).click();//click the delete button on 2nd row
		
		outerbox = findWidget("$outergrid");
		outerrows = outerbox.findWidget("@rows").getChildren();
		String[] itemLabel = new String[]{"A" ,"C", "D"};
		Assert.assertEquals(itemLabel.length, outerrows.size());
		
		for(int i=0;i<itemLabel.length;i++){
			Widget outerrow = outerrows.get(i);
			String outerl = itemLabel[i];
			
			Widget rowkid = outerrow.getFirstChild();
			Assert.assertEquals(""+i, rowkid.getValue());// verify the index  on label
			rowkid = rowkid.getNextSibling();
			Assert.assertEquals(outerl, rowkid.getValue());//verify the label on label
			
			Widget innergrid = rowkid.getNextSibling();
			Assert.assertNotNull(innergrid);
			List<Widget> innerrows = innergrid.findWidgets("@row");
			Assert.assertEquals(2, innerrows.size());
			for(int j=0;j<2;j++){
				Widget innerrow = innerrows.get(j);
				rowkid = innerrow.getFirstChild();
				Assert.assertEquals(""+j, rowkid.getValue());
				rowkid = rowkid.getNextSibling();
				Assert.assertEquals(""+i, rowkid.getValue());
				
				String innerl = itemLabel[i]+" "+j;
				rowkid = rowkid.getNextSibling();
				Assert.assertEquals(innerl, rowkid.getValue());
			}
			
			rowkid = outerrow.getLastChild();
			Widget btn = rowkid.findWidget("@button");//index button
			Widget msg = findWidget("$msg");
			btn.click();
			
			Assert.assertEquals("item index "+i, msg.getValue());
		}
		
		//=================================add after row
		outeritem = outerrows.get(1);
		outeritem.findWidgets("@button").get(2).click();//add after 2nd row
		
		outerbox = findWidget("$outergrid");
		outerrows = outerbox.findWidget("@rows").getChildren();
		itemLabel = new String[]{"A" ,"C","C1", "D"};
		Assert.assertEquals(itemLabel.length, outerrows.size());
		
		for(int i=0;i<itemLabel.length;i++){
			Widget outerrow = outerrows.get(i);
			String outerl = itemLabel[i];
			
			Widget rowkid = outerrow.getFirstChild();
			Assert.assertEquals(""+i, rowkid.getValue());// verify the index  on label
			rowkid = rowkid.getNextSibling();
			Assert.assertEquals(outerl, rowkid.getValue());//verify the label on label
			
			Widget innergrid = rowkid.getNextSibling();
			Assert.assertNotNull(innergrid);
			List<Widget> innerrows = innergrid.findWidgets("@row");
			Assert.assertEquals(2, innerrows.size());
			for(int j=0;j<2;j++){
				Widget innerrow = innerrows.get(j);
				rowkid = innerrow.getFirstChild();
				Assert.assertEquals(""+j, rowkid.getValue());
				rowkid = rowkid.getNextSibling();
				Assert.assertEquals(""+i, rowkid.getValue());
				
				String innerl = itemLabel[i]+" "+j;
				rowkid = rowkid.getNextSibling();
				Assert.assertEquals(innerl, rowkid.getValue());
			}
			
			rowkid = outerrow.getLastChild();
			Widget btn = rowkid.findWidget("@button");//index button
			Widget msg = findWidget("$msg");
			btn.click();
			
			Assert.assertEquals("item index "+i, msg.getValue());
		}
		
		//=================================add after row
		outeritem = outerrows.get(2);
		outeritem.findWidgets("@button").get(3).click();//add after 2nd row
		
		outerbox = findWidget("$outergrid");
		outerrows = outerbox.findWidget("@rows").getChildren();
		itemLabel = new String[]{"A" ,"C","C12","C1", "D"};
		Assert.assertEquals(itemLabel.length, outerrows.size());
		
		for(int i=0;i<itemLabel.length;i++){
			Widget outerrow = outerrows.get(i);
			String outerl = itemLabel[i];
			
			Widget rowkid = outerrow.getFirstChild();
			Assert.assertEquals(""+i, rowkid.getValue());// verify the index  on label
			rowkid = rowkid.getNextSibling();
			Assert.assertEquals(outerl, rowkid.getValue());//verify the label on label
			
			Widget innergrid = rowkid.getNextSibling();
			Assert.assertNotNull(innergrid);
			List<Widget> innerrows = innergrid.findWidgets("@row");
			Assert.assertEquals(2, innerrows.size());
			for(int j=0;j<2;j++){
				Widget innerrow = innerrows.get(j);
				rowkid = innerrow.getFirstChild();
				Assert.assertEquals(""+j, rowkid.getValue());
				rowkid = rowkid.getNextSibling();
				Assert.assertEquals(""+i, rowkid.getValue());
				
				String innerl = itemLabel[i]+" "+j;
				rowkid = rowkid.getNextSibling();
				Assert.assertEquals(innerl, rowkid.getValue());
			}
			
			rowkid = outerrow.getLastChild();
			Widget btn = rowkid.findWidget("@button");//index button
			Widget msg = findWidget("$msg");
			btn.click();
			
			Assert.assertEquals("item index "+i, msg.getValue());
		}
	}
	
	
	@Test
	public void indexCombobox1(){
		navigate(getTestCaseUrl("/bind/basic/collection-index-combobox.zul"));
		
		Widget outerbox = findWidget("$outergrid");
		List<Widget> outerrows = outerbox.findWidget("@rows").getChildren();
		String[] itemLabel = new String[]{"A","B","C", "D"};
		Assert.assertEquals(itemLabel.length, outerrows.size());
		for(int i=0;i<itemLabel.length;i++){
			Widget outerrow = outerrows.get(i);
			Widget combobox = outerrow.findWidget("@combobox");
			combobox.call("open");//to show popu first so we can find comboitem in zkmax
			
			List<Widget> comboitems = combobox.findWidgets("@comboitem");
			Assert.assertEquals(2, comboitems.size());
			for(int j=0;j<2;j++){
				Widget comboitem = comboitems.get(j);
				Assert.assertEquals(itemLabel[i]+" "+j+"-"+j+"-"+i, comboitem.getLabel());
				Assert.assertEquals(itemLabel[i]+" "+j, comboitem.getAttribute("description"));
			}
			Widget btn = outerrow.findWidget("@button");//index button
			Widget msg = findWidget("$msg");
			btn.click();
			
			Assert.assertEquals("item index "+i, msg.getValue());
		}
	}
	
	@Test
	public void indexCombobox2(){
		navigate(getTestCaseUrl("/bind/basic/collection-index-combobox.zul"));
		
		Widget outerbox = findWidget("$outergrid");
		List<Widget> outerrows = outerbox.findWidget("@rows").getChildren();
		
		//=================================delete 2rd row
		Widget outeritem = outerrows.get(1);
		outeritem.findWidgets("@button").get(1).click();//click the delete button on 2nd row
		
		outerbox = findWidget("$outergrid");
		outerrows = outerbox.findWidget("@rows").getChildren();
		String[] itemLabel = new String[]{"A","C", "D"};
		Assert.assertEquals(itemLabel.length, outerrows.size());
		
		for(int i=0;i<itemLabel.length;i++){
			Widget outerrow = outerrows.get(i);
			Widget combobox = outerrow.findWidget("@combobox");
			combobox.call("open");//has to wait for open
			
			List<Widget> comboitems = combobox.findWidgets("@comboitem");
			Assert.assertEquals(2, comboitems.size());
			for(int j=0;j<2;j++){
				Widget comboitem = comboitems.get(j);
				Assert.assertEquals(itemLabel[i]+" "+j+"-"+j+"-"+i, comboitem.getLabel());
				Assert.assertEquals(itemLabel[i]+" "+j, comboitem.getAttribute("description"));
			}
			Widget btn = outerrow.findWidget("@button");//index button
			Widget msg = findWidget("$msg");
			btn.click();
			
			Assert.assertEquals("item index "+i, msg.getValue());
		}
		
		//=================================add after 2rd row
		outeritem = outerrows.get(1);
		outeritem.findWidgets("@button").get(2).click();//click the add after button on 2nd row
		
		outerbox = findWidget("$outergrid");
		outerrows = outerbox.findWidget("@rows").getChildren();
		itemLabel = new String[]{"A","C", "C1", "D"};
		Assert.assertEquals(itemLabel.length, outerrows.size());
		
		for(int i=0;i<itemLabel.length;i++){
			Widget outerrow = outerrows.get(i);
			Widget combobox = outerrow.findWidget("@combobox");
			combobox.call("open");//to show popu first so we can find comboitem in zkmax
			
			List<Widget> comboitems = combobox.findWidgets("@comboitem");
			Assert.assertEquals(2, comboitems.size());
			for(int j=0;j<2;j++){
				Widget comboitem = comboitems.get(j);
				Assert.assertEquals(itemLabel[i]+" "+j+"-"+j+"-"+i, comboitem.getLabel());
				Assert.assertEquals(itemLabel[i]+" "+j, comboitem.getAttribute("description"));
			}
			Widget btn = outerrow.findWidget("@button");//index button
			Widget msg = findWidget("$msg");
			btn.click();
			
			Assert.assertEquals("item index "+i, msg.getValue());
		}
		
		//=================================add before 2rd row
		outeritem = outerrows.get(2);
		outeritem.findWidgets("@button").get(3).click();//click the add after button on 2nd row
		
		outerbox = findWidget("$outergrid");
		outerrows = outerbox.findWidget("@rows").getChildren();
		itemLabel = new String[]{"A","C", "C12", "C1", "D"};
		Assert.assertEquals(itemLabel.length, outerrows.size());
		
		for(int i=0;i<itemLabel.length;i++){
			Widget outerrow = outerrows.get(i);
			Widget combobox = outerrow.findWidget("@combobox");
			combobox.call("open");//to show popu first so we can find comboitem in zkmax
			
			List<Widget> comboitems = combobox.findWidgets("@comboitem");
			Assert.assertEquals(2, comboitems.size());
			for(int j=0;j<2;j++){
				Widget comboitem = comboitems.get(j);
				Assert.assertEquals(itemLabel[i]+" "+j+"-"+j+"-"+i, comboitem.getLabel());
				Assert.assertEquals(itemLabel[i]+" "+j, comboitem.getAttribute("description"));
			}
			Widget btn = outerrow.findWidget("@button");//index button
			Widget msg = findWidget("$msg");
			btn.click();
			
			Assert.assertEquals("item index "+i, msg.getValue());
		}
		
	}
	
	@Test
	public void indexTree1(){
		navigate(getTestCaseUrl("/bind/basic/collection-index-tree.zul"));
		
		
		MyTreeNode root = new MyTreeNode("Root");
		String[] labs = new String[]{"A","B","C"};
		for (int i = 0; i < 3; i++) {
			MyTreeNode ni = new MyTreeNode(labs[i] + i);
			for (int j = 0; j < 3; j++) {
				MyTreeNode nj = new MyTreeNode(ni.data
						+ "-" + j);
				for (int k = 0; k < 2; k++) {
					MyTreeNode nk = new MyTreeNode(
							nj.data + "-" + k);
					nj.add(nk);
				}
				ni.add(nj);
			}
			root.add(ni);
		}
		
		
		Widget tree = findWidget("$tree");
		Widget treeChildren = tree.getFirstChild().getNextSibling();
		testTree1(root,treeChildren);
	}
	
	void testTree1(MyTreeNode node,Widget parent){
		List<Widget> children = parent.getChildren();
		List<MyTreeNode> nodes =  node.getChildren();
		Assert.assertEquals(nodes.size(), children.size());
		Widget addBeforeBtn = null;
		Widget addAfterBtn = null;
		Widget deleteBtn = null;
		MyTreeNode n1 = nodes.get(1);
		for(int i=0;i<nodes.size();i++){
			MyTreeNode n = nodes.get(i);
			Widget item = children.get(i);
			Widget row = item.getFirstChild();
			Widget cell = row.getFirstChild();
			Widget treechildren = row.getNextSibling();
			Assert.assertEquals(""+i, cell.getLabel());
			cell = cell.getNextSibling();
			Assert.assertEquals(n.data, cell.getLabel());
			cell = cell.getNextSibling();
			
			List<Widget> buttons = cell.findWidgets("@button");
			buttons.get(0).click();
			Assert.assertEquals("item index "+i, findWidget("$msg").getValue());
			
			if(i==1){
				deleteBtn = buttons.get(1);
				addAfterBtn =  buttons.get(2);
				addBeforeBtn =  buttons.get(3);
			}
			
			if(n.getChildren().size()==0){
				Assert.assertEquals(0, treechildren==null?0:treechildren.getChildrenSize());
			}else{
				item.call("setOpen", true); 
				waitForTrip(1, 1000);
				testTree1(n,treechildren);
			}
		}
		
//		if(action){//check after before
//			nodes.add(2, new MyTreeNode(n1.data+"-after"));
//			addAfterBtn.click();
//			nodes.add(1, new MyTreeNode(n1.data+"-before"));
//			addBeforeBtn.click();
//			nodes.remove(2);
//			deleteBtn.click();
//		}
	}
	
	
	static public class MyTreeNode {

		String data;
		List<MyTreeNode> children;
		public MyTreeNode(String data) {
			this.data = data;
			children = new ArrayList<MyTreeNode>();
		}
		public void add(MyTreeNode node){
			children.add(node);
		}
		public List<MyTreeNode> getChildren(){
			return children;
		}
	}
	
	@Test
	public void templateTree(){
		navigate(getTestCaseUrl("/bind/basic/collection-template-tree.zul"));
		
		
		MyTreeNode root = new MyTreeNode("Root");
		String[] labs = new String[]{"A","B","C"};
		for (int i = 0; i < 3; i++) {
			MyTreeNode ni = new MyTreeNode(labs[i] + i);
			for (int j = 0; j < 3; j++) {
				MyTreeNode nj = new MyTreeNode(ni.data
						+ "-" + j);
				for (int k = 0; k < 2; k++) {
					MyTreeNode nk = new MyTreeNode(
							nj.data + "-" + k);
					nj.add(nk);
				}
				ni.add(nj);
			}
			root.add(ni);
		}
		
		
		Widget tree = findWidget("$tree");
		Widget treeChildren = tree.getFirstChild().getNextSibling();
		templateTree(root,treeChildren);
	}
	
	void templateTree(MyTreeNode node,Widget parent){
		List<Widget> children = parent.getChildren();
		List<MyTreeNode> nodes =  node.getChildren();
		Assert.assertEquals(nodes.size(), children.size());
		for(int i=0;i<nodes.size();i++){
			MyTreeNode n = nodes.get(i);
			Widget item = children.get(i);
			Widget row = item.getFirstChild();
			Widget cell = row.getLastChild();
			Widget treechildren = row.getNextSibling();
			
			if(i==1 || n.data.startsWith("A")){
				Assert.assertEquals("Model1", cell.getLabel());
			}else{
				Assert.assertEquals("Model2", cell.getLabel());
			}
			

			if(n.getChildren().size()==0){
				Assert.assertEquals(0, treechildren==null?0:treechildren.getChildrenSize());
			}else{
				item.call("setOpen", true); 
				waitForTrip(1, 1000);
				templateTree(n,treechildren);
			}
		}
	}
	
	
	@Test
	public void listboxModel(){
		navigate(getTestCaseUrl("/bind/basic/listboxmodel.zul"));
		
		Widget outerbox = findWidget("$outerbox");
		List<Widget> outeritems = outerbox.getChildren();//include header
		outeritems.remove(0);//don't care header
		
		//=================================delete 2rd row
		Widget outeritem = outeritems.get(1);
		outeritem.findWidgets("@button").get(1).click();//click the delete button on 2nd row
		
		outerbox = findWidget("$outerbox");
		outeritems = outerbox.getChildren();//include header
		outeritems.remove(0);//don't care header
		String[] itemLabel = new String[]{"A","C", "D"};
		Assert.assertEquals(itemLabel.length, outeritems.size());
		
		for(int i=0;i<itemLabel.length;i++){
			outeritem = outeritems.get(i);
			String outerl = itemLabel[i];
			
			Widget cell = outeritem.getFirstChild();
			Assert.assertEquals(""+i, cell.getLabel());// verify the index
			cell = cell.getNextSibling();
			Assert.assertEquals(outerl, cell.getLabel());//verify the label
			
			Widget innerbox = outeritem.findWidget("@listbox");
			Assert.assertNotNull(innerbox);
			List<Widget> inneritems = innerbox.findWidgets("@listitem");
			Assert.assertEquals(2, inneritems.size());
			for(int j=0;j<2;j++){
				Widget inneritem = inneritems.get(j);
				cell = inneritem.getFirstChild();
				Assert.assertEquals(""+j, cell.getLabel());
				cell = cell.getNextSibling();
				Assert.assertEquals(""+i, cell.getLabel());
				
				String innerl = itemLabel[i]+" "+j;
				cell = cell.getNextSibling();
				Assert.assertEquals(innerl, cell.getLabel());
			}
			
			cell = outeritem.getLastChild();
			Widget btn = cell.findWidget("@button");//index button
			Widget msg = findWidget("$msg");
			btn.click();
			
			Assert.assertEquals("item index "+i, msg.getValue());
		}
		
		//===============================add after row
		outeritem = outeritems.get(1);
		outeritem.findWidgets("@button").get(2).click();//click the add after button on 2nd row
		
		outerbox = findWidget("$outerbox");
		outeritems = outerbox.getChildren();//include header
		outeritems.remove(0);//don't care header
		itemLabel = new String[]{"A","C","C1","D"};
		Assert.assertEquals(itemLabel.length, outeritems.size());
		
		for(int i=0;i<itemLabel.length;i++){
			outeritem = outeritems.get(i);
			String outerl = itemLabel[i];
			
			Widget cell = outeritem.getFirstChild();
			Assert.assertEquals(""+i, cell.getLabel());// verify the index
			cell = cell.getNextSibling();
			Assert.assertEquals(outerl, cell.getLabel());//verify the label
			
			Widget innerbox = outeritem.findWidget("@listbox");
			Assert.assertNotNull(innerbox);
			List<Widget> inneritems = innerbox.findWidgets("@listitem");
			Assert.assertEquals(2, inneritems.size());
			for(int j=0;j<2;j++){
				Widget inneritem = inneritems.get(j);
				cell = inneritem.getFirstChild();
				Assert.assertEquals(""+j, cell.getLabel());
				cell = cell.getNextSibling();
				Assert.assertEquals(""+i, cell.getLabel());
				
				String innerl = itemLabel[i]+" "+j;
				cell = cell.getNextSibling();
				Assert.assertEquals(innerl, cell.getLabel());
			}
			
			cell = outeritem.getLastChild();
			Widget btn = cell.findWidget("@button");//index button
			Widget msg = findWidget("$msg");
			btn.click();
			
			Assert.assertEquals("item index "+i, msg.getValue());
		}
		
		//===============================add add before row
		outeritem = outeritems.get(2);
		outeritem.findWidgets("@button").get(3).click();//click the add before button on 2nd row
		
		outerbox = findWidget("$outerbox");
		outeritems = outerbox.getChildren();//include header
		outeritems.remove(0);//don't care header
		itemLabel = new String[]{"A","C","C12","C1","D"};
		Assert.assertEquals(itemLabel.length, outeritems.size());
		
		for(int i=0;i<itemLabel.length;i++){
			outeritem = outeritems.get(i);
			String outerl = itemLabel[i];
			
			Widget cell = outeritem.getFirstChild();
			Assert.assertEquals(""+i, cell.getLabel());// verify the index
			cell = cell.getNextSibling();
			Assert.assertEquals(outerl, cell.getLabel());//verify the label
			
			Widget innerbox = outeritem.findWidget("@listbox");
			Assert.assertNotNull(innerbox);
			List<Widget> inneritems = innerbox.findWidgets("@listitem");
			Assert.assertEquals(2, inneritems.size());
			for(int j=0;j<2;j++){
				Widget inneritem = inneritems.get(j);
				cell = inneritem.getFirstChild();
				Assert.assertEquals(""+j, cell.getLabel());
				cell = cell.getNextSibling();
				Assert.assertEquals(""+i, cell.getLabel());
				
				String innerl = itemLabel[i]+" "+j;
				cell = cell.getNextSibling();
				Assert.assertEquals(innerl, cell.getLabel());
			}
			
			cell = outeritem.getLastChild();
			Widget btn = cell.findWidget("@button");//index button
			Widget msg = findWidget("$msg");
			btn.click();
			
			Assert.assertEquals("item index "+i, msg.getValue());
		}
		
		
	}
	
	@Test
	public void listboxModelSelection(){
		navigate(getTestCaseUrl("/bind/basic/listboxmodel.zul"));
		Widget msg = findWidget("$msg");
		Widget outerbox = findWidget("$outerbox");
		List<Widget> outeritems = outerbox.getChildren();//include header
		outeritems.remove(0);//don't care header
		
		Widget outeritem = outeritems.get(1);//select 2nd
		outeritem.getFirstChild().click();//click on listitem is not work if it has listbox inside, (it will click on the inside listbox)
		Assert.assertEquals(1L, ListboxUtil.getSelectedIndex(outerbox));
		Assert.assertEquals("", msg.getValue());
		
		findWidget("$btn1").click();
		
		
		Assert.assertEquals(1L, ListboxUtil.getSelectedIndex(outerbox));
		Assert.assertEquals("reloaded", msg.getValue());
		
	}
	
	
	@Test
	public void gridModel(){
		navigate(getTestCaseUrl("/bind/basic/gridmodel.zul"));
		
		Widget outerbox = findWidget("$outergrid");
		List<Widget> outerrows = outerbox.findWidget("@rows").getChildren();
		
		//=================================delete 2rd row
		Widget outeritem = outerrows.get(1);
		outeritem.findWidgets("@button").get(1).click();//click the delete button on 2nd row
		
		outerbox = findWidget("$outergrid");
		outerrows = outerbox.findWidget("@rows").getChildren();
		String[] itemLabel = new String[]{"A" ,"C", "D"};
		Assert.assertEquals(itemLabel.length, outerrows.size());
		
		for(int i=0;i<itemLabel.length;i++){
			Widget outerrow = outerrows.get(i);
			String outerl = itemLabel[i];
			
			Widget rowkid = outerrow.getFirstChild();
			Assert.assertEquals(""+i, rowkid.getValue());// verify the index  on label
			rowkid = rowkid.getNextSibling();
			Assert.assertEquals(outerl, rowkid.getValue());//verify the label on label
			
			Widget innergrid = rowkid.getNextSibling();
			Assert.assertNotNull(innergrid);
			List<Widget> innerrows = innergrid.findWidgets("@row");
			Assert.assertEquals(2, innerrows.size());
			for(int j=0;j<2;j++){
				Widget innerrow = innerrows.get(j);
				rowkid = innerrow.getFirstChild();
				Assert.assertEquals(""+j, rowkid.getValue());
				rowkid = rowkid.getNextSibling();
				Assert.assertEquals(""+i, rowkid.getValue());
				
				String innerl = itemLabel[i]+" "+j;
				rowkid = rowkid.getNextSibling();
				Assert.assertEquals(innerl, rowkid.getValue());
			}
			
			rowkid = outerrow.getLastChild();
			Widget btn = rowkid.findWidget("@button");//index button
			Widget msg = findWidget("$msg");
			btn.click();
			
			Assert.assertEquals("item index "+i, msg.getValue());
		}
		
		//=================================add after row
		outeritem = outerrows.get(1);
		outeritem.findWidgets("@button").get(2).click();//add after 2nd row
		
		outerbox = findWidget("$outergrid");
		outerrows = outerbox.findWidget("@rows").getChildren();
		itemLabel = new String[]{"A" ,"C","C1", "D"};
		Assert.assertEquals(itemLabel.length, outerrows.size());
		
		for(int i=0;i<itemLabel.length;i++){
			Widget outerrow = outerrows.get(i);
			String outerl = itemLabel[i];
			
			Widget rowkid = outerrow.getFirstChild();
			Assert.assertEquals(""+i, rowkid.getValue());// verify the index  on label
			rowkid = rowkid.getNextSibling();
			Assert.assertEquals(outerl, rowkid.getValue());//verify the label on label
			
			Widget innergrid = rowkid.getNextSibling();
			Assert.assertNotNull(innergrid);
			List<Widget> innerrows = innergrid.findWidgets("@row");
			Assert.assertEquals(2, innerrows.size());
			for(int j=0;j<2;j++){
				Widget innerrow = innerrows.get(j);
				rowkid = innerrow.getFirstChild();
				Assert.assertEquals(""+j, rowkid.getValue());
				rowkid = rowkid.getNextSibling();
				Assert.assertEquals(""+i, rowkid.getValue());
				
				String innerl = itemLabel[i]+" "+j;
				rowkid = rowkid.getNextSibling();
				Assert.assertEquals(innerl, rowkid.getValue());
			}
			
			rowkid = outerrow.getLastChild();
			Widget btn = rowkid.findWidget("@button");//index button
			Widget msg = findWidget("$msg");
			btn.click();
			
			Assert.assertEquals("item index "+i, msg.getValue());
		}
		
		//=================================add after row
		outeritem = outerrows.get(2);
		outeritem.findWidgets("@button").get(3).click();//add after 2nd row
		
		outerbox = findWidget("$outergrid");
		outerrows = outerbox.findWidget("@rows").getChildren();
		itemLabel = new String[]{"A" ,"C","C12","C1", "D"};
		Assert.assertEquals(itemLabel.length, outerrows.size());
		
		for(int i=0;i<itemLabel.length;i++){
			Widget outerrow = outerrows.get(i);
			String outerl = itemLabel[i];
			
			Widget rowkid = outerrow.getFirstChild();
			Assert.assertEquals(""+i, rowkid.getValue());// verify the index  on label
			rowkid = rowkid.getNextSibling();
			Assert.assertEquals(outerl, rowkid.getValue());//verify the label on label
			
			Widget innergrid = rowkid.getNextSibling();
			Assert.assertNotNull(innergrid);
			List<Widget> innerrows = innergrid.findWidgets("@row");
			Assert.assertEquals(2, innerrows.size());
			for(int j=0;j<2;j++){
				Widget innerrow = innerrows.get(j);
				rowkid = innerrow.getFirstChild();
				Assert.assertEquals(""+j, rowkid.getValue());
				rowkid = rowkid.getNextSibling();
				Assert.assertEquals(""+i, rowkid.getValue());
				
				String innerl = itemLabel[i]+" "+j;
				rowkid = rowkid.getNextSibling();
				Assert.assertEquals(innerl, rowkid.getValue());
			}
			
			rowkid = outerrow.getLastChild();
			Widget btn = rowkid.findWidget("@button");//index button
			Widget msg = findWidget("$msg");
			btn.click();
			
			Assert.assertEquals("item index "+i, msg.getValue());
		}
	}
	
	@Test
	public void comboboxModel(){
		navigate(getTestCaseUrl("/bind/basic/comboboxmodel.zul"));
		
		Widget outerbox = findWidget("$outergrid");
		List<Widget> outerrows = outerbox.findWidget("@rows").getChildren();
		
		//=================================delete 2rd row
		Widget outeritem = outerrows.get(1);
		outeritem.findWidgets("@button").get(1).click();//click the delete button on 2nd row
		
		outerbox = findWidget("$outergrid");
		outerrows = outerbox.findWidget("@rows").getChildren();
		String[] itemLabel = new String[]{"A","C", "D"};
		Assert.assertEquals(itemLabel.length, outerrows.size());
		
		for(int i=0;i<itemLabel.length;i++){
			Widget outerrow = outerrows.get(i);
			Widget combobox = outerrow.findWidget("@combobox");
			combobox.call("open");//to show popu first so we can find comboitem in zkmax
			List<Widget> comboitems = combobox.findWidgets("@comboitem");
			Assert.assertEquals(2, comboitems.size());
			for(int j=0;j<2;j++){
				Widget comboitem = comboitems.get(j);
				Assert.assertEquals(itemLabel[i]+" "+j+"-"+j+"-"+i, comboitem.getLabel());
				Assert.assertEquals(itemLabel[i]+" "+j, comboitem.getAttribute("description"));
			}
			Widget btn = outerrow.findWidget("@button");//index button
			Widget msg = findWidget("$msg");
			btn.click();
			
			Assert.assertEquals("item index "+i, msg.getValue());
		}
		
		//=================================add after 2rd row
		outeritem = outerrows.get(1);
		outeritem.findWidgets("@button").get(2).click();//click the add after button on 2nd row
		
		outerbox = findWidget("$outergrid");
		outerrows = outerbox.findWidget("@rows").getChildren();
		itemLabel = new String[]{"A","C", "C1", "D"};
		Assert.assertEquals(itemLabel.length, outerrows.size());
		
		for(int i=0;i<itemLabel.length;i++){
			Widget outerrow = outerrows.get(i);
			Widget combobox = outerrow.findWidget("@combobox");
			combobox.call("open");//to show popu first so we can find comboitem in zkmax
			List<Widget> comboitems = combobox.findWidgets("@comboitem");
			Assert.assertEquals(2, comboitems.size());
			for(int j=0;j<2;j++){
				Widget comboitem = comboitems.get(j);
				Assert.assertEquals(itemLabel[i]+" "+j+"-"+j+"-"+i, comboitem.getLabel());
				Assert.assertEquals(itemLabel[i]+" "+j, comboitem.getAttribute("description"));
			}
			Widget btn = outerrow.findWidget("@button");//index button
			Widget msg = findWidget("$msg");
			btn.click();
			
			Assert.assertEquals("item index "+i, msg.getValue());
		}
		
		//=================================add before 2rd row
		outeritem = outerrows.get(2);
		outeritem.findWidgets("@button").get(3).click();//click the add after button on 2nd row
		
		outerbox = findWidget("$outergrid");
		outerrows = outerbox.findWidget("@rows").getChildren();
		itemLabel = new String[]{"A","C", "C12", "C1", "D"};
		Assert.assertEquals(itemLabel.length, outerrows.size());
		
		for(int i=0;i<itemLabel.length;i++){
			Widget outerrow = outerrows.get(i);
			Widget combobox = outerrow.findWidget("@combobox");
			combobox.findElement(".z-combobox-btn").click();//to show popu first so we can find comboitem in zkmax
			List<Widget> comboitems = combobox.findWidgets("@comboitem");
			Assert.assertEquals(2, comboitems.size());
			for(int j=0;j<2;j++){
				Widget comboitem = comboitems.get(j);
				Assert.assertEquals(itemLabel[i]+" "+j+"-"+j+"-"+i, comboitem.getLabel());
				Assert.assertEquals(itemLabel[i]+" "+j, comboitem.getAttribute("description"));
			}
			Widget btn = outerrow.findWidget("@button");//index button
			Widget msg = findWidget("$msg");
			btn.click();
			
			Assert.assertEquals("item index "+i, msg.getValue());
		}
		
	}
	
	@Test
	public void comboboxModelSelection(){
		navigate(getTestCaseUrl("/bind/basic/comboboxmodelselection.zul"));
		
		Widget combobox1 = findWidget("$cb1");
		Widget combobox2 = findWidget("$cb2");
		
		Assert.assertEquals("",findWidget("$msg").getValue());
		combobox1.call("open");//has to wait for open
		List<Widget> items = combobox1.findWidgets("@comboitem");
		combobox1.call("open");//has to wait for open
		waitForTrip(1, 1500);
		
		items.get(1).click();
		Assert.assertEquals("B",combobox1.getValue());
		Assert.assertEquals("A",combobox2.getValue());
		
		combobox1.call("open");//has to wait for open
		waitForTrip(1, 1500);
		
		items.get(2).click();
		Assert.assertEquals("C",combobox1.getValue());
		Assert.assertEquals("A",combobox2.getValue());
		
		findWidget("$btn1").click();
		Assert.assertEquals("reloaded",findWidget("$msg").getValue());
		Assert.assertEquals("C",combobox1.getValue());
		Assert.assertEquals("A",combobox2.getValue());
		
		findWidget("$btn2").click();
		Assert.assertEquals("selected",findWidget("$msg").getValue());
		Assert.assertEquals("C",combobox1.getValue());
		Assert.assertEquals("D",combobox2.getValue());
	}
	
	@Test
	public void selectboxModelSelection(){
		navigate(getTestCaseUrl("/bind/basic/selectboxmodelselection.zul"));
		
		Widget sb1 = findWidget("$sb1");
		Widget sb2 = findWidget("$sb2");
		Widget sb3 = findWidget("$sb3");
		Widget msg = findWidget("$msg");
		Widget btn1 = findWidget("$btn1");
		Widget btn2 = findWidget("$btn2");
		
		
		Assert.assertEquals("",msg.getValue());
		
		Assert.assertEquals(-1L, sb1.getAttribute("selectedIndex"));
		Assert.assertEquals(-1L, sb2.getAttribute("selectedIndex"));
		Assert.assertEquals(1L, sb3.getAttribute("selectedIndex"));
		
		Widgets.toSelectWidget(sb1).select(0);
		Widgets.toSelectWidget(sb2).select(1);
		Widgets.toSelectWidget(sb3).select(2);
		
		Assert.assertEquals(0L, sb1.getAttribute("selectedIndex"));
		Assert.assertEquals(1L, sb2.getAttribute("selectedIndex"));
		Assert.assertEquals(2L, sb3.getAttribute("selectedIndex"));
		
		btn1.click();
		Assert.assertEquals(0L, sb1.getAttribute("selectedIndex"));
		Assert.assertEquals(1L, sb2.getAttribute("selectedIndex"));
		Assert.assertEquals(2L, sb3.getAttribute("selectedIndex"));
		
		btn2.click();
		Assert.assertEquals(0L, sb1.getAttribute("selectedIndex"));
		Assert.assertEquals(1L, sb2.getAttribute("selectedIndex"));
		Assert.assertEquals(3L, sb3.getAttribute("selectedIndex"));
		
	}
	
	
	@Test
	public void templateGrid1(){
		navigate(getTestCaseUrl("/bind/basic/collection-template-grid.zul"));
		
		Widget outerbox = findWidget("$outergrid");
		List<Widget> outerrows = outerbox.findWidget("@rows").getChildren();
		
		String[] itemLabel = new String[]{"A","B","C", "D"};
		Assert.assertEquals(itemLabel.length, outerrows.size());
		
		for(int i=0;i<itemLabel.length;i++){
			Widget outerrow = outerrows.get(i);
			String outerl = itemLabel[i];
			
			Widget rowkid = outerrow.getFirstChild();
			Assert.assertEquals(""+i, rowkid.getValue());// verify the index  on label
			rowkid = rowkid.getNextSibling();
			Assert.assertEquals(outerl, rowkid.getValue());//verify the label on label
			
			//verify inner index
			Widget innergrid = rowkid.getNextSibling();
			Assert.assertNotNull(innergrid);
			List<Widget> innerrows = innergrid.findWidgets("@row");
			Assert.assertEquals(2, innerrows.size());
			for(int j=0;j<2;j++){
				Widget innerrow = innerrows.get(j);
				rowkid = innerrow.getFirstChild();
				Assert.assertEquals(""+j, rowkid.getValue());
				rowkid = rowkid.getNextSibling();
				Assert.assertEquals(""+i, rowkid.getValue());
				
				String innerl = itemLabel[i]+" "+j;
				rowkid = rowkid.getNextSibling();
				Assert.assertEquals(innerl, rowkid.getValue());
			}
			
			rowkid = outerrow.getLastChild().getPreviousSibling();
			Widget btn = rowkid.findWidget("@button");//index button
			Widget msg = findWidget("$msg");
			btn.click();
			
			Assert.assertEquals("item index "+i, msg.getValue());
			
			//verify template
			rowkid = outerrow.getLastChild();
			Widget label = rowkid.findWidget("@label");//index button
			if(outerl.equals("A") || i==2){
				Assert.assertEquals("Model1", label.getValue());
			}else{
				Assert.assertEquals("Model2", label.getValue());
			}
		}
	}
	
	@Test
	public void templateGrid2(){
		navigate(getTestCaseUrl("/bind/basic/collection-template-grid.zul"));
		
		Widget outerbox = findWidget("$outergrid");
		List<Widget> outerrows = outerbox.findWidget("@rows").getChildren();
		
		//=================================delete 2rd row
		Widget outeritem = outerrows.get(1);
		outeritem.findWidgets("@button").get(1).click();//click the delete button on 2nd row
		
		outerbox = findWidget("$outergrid");
		outerrows = outerbox.findWidget("@rows").getChildren();
		String[] itemLabel = new String[]{"A" ,"C", "D"};
		Assert.assertEquals(itemLabel.length, outerrows.size());
		
		for(int i=0;i<itemLabel.length;i++){
			Widget outerrow = outerrows.get(i);
			String outerl = itemLabel[i];
			
			Widget rowkid = outerrow.getFirstChild();
			Assert.assertEquals(""+i, rowkid.getValue());// verify the index  on label
			rowkid = rowkid.getNextSibling();
			Assert.assertEquals(outerl, rowkid.getValue());//verify the label on label
			
			//verify inner index
			Widget innergrid = rowkid.getNextSibling();
			Assert.assertNotNull(innergrid);
			List<Widget> innerrows = innergrid.findWidgets("@row");
			Assert.assertEquals(2, innerrows.size());
			for(int j=0;j<2;j++){
				Widget innerrow = innerrows.get(j);
				rowkid = innerrow.getFirstChild();
				Assert.assertEquals(""+j, rowkid.getValue());
				rowkid = rowkid.getNextSibling();
				Assert.assertEquals(""+i, rowkid.getValue());
				
				String innerl = itemLabel[i]+" "+j;
				rowkid = rowkid.getNextSibling();
				Assert.assertEquals(innerl, rowkid.getValue());
			}
			
			rowkid = outerrow.getLastChild().getPreviousSibling();
			Widget btn = rowkid.findWidget("@button");//index button
			Widget msg = findWidget("$msg");
			btn.click();
			
			Assert.assertEquals("item index "+i, msg.getValue());
			
			//verify template
			
			rowkid = outerrow.getLastChild();
			Widget label = rowkid.findWidget("@label");//index button
			if(outerl.equals("A") || i==2){
				Assert.assertEquals("Model1", label.getValue());
			}else{
				Assert.assertEquals("Model2", label.getValue());
			}
		}
		
		//=================================add after row
		outeritem = outerrows.get(1);
		outeritem.findWidgets("@button").get(2).click();//add after 2nd row
		
		outerbox = findWidget("$outergrid");
		outerrows = outerbox.findWidget("@rows").getChildren();
		itemLabel = new String[]{"A" ,"C","C1", "D"};
		Assert.assertEquals(itemLabel.length, outerrows.size());
		
		for(int i=0;i<itemLabel.length;i++){
			Widget outerrow = outerrows.get(i);
			String outerl = itemLabel[i];
			
			Widget rowkid = outerrow.getFirstChild();
			Assert.assertEquals(""+i, rowkid.getValue());// verify the index  on label
			rowkid = rowkid.getNextSibling();
			Assert.assertEquals(outerl, rowkid.getValue());//verify the label on label
			
			rowkid = outerrow.getLastChild();
			Widget label = rowkid.findWidget("@label");//index button
			if(outerl.equals("A") || i==2){
				Assert.assertEquals("Model1", label.getValue());
			}else{
				Assert.assertEquals("Model2", label.getValue());
			}
		}
		
		//=================================add after row
		outeritem = outerrows.get(2);
		outeritem.findWidgets("@button").get(3).click();//add after 2nd row
		
		outerbox = findWidget("$outergrid");
		outerrows = outerbox.findWidget("@rows").getChildren();
		itemLabel = new String[]{"A" ,"C","C12","C1", "D"};
		Assert.assertEquals(itemLabel.length, outerrows.size());
		
		for(int i=0;i<itemLabel.length;i++){
			Widget outerrow = outerrows.get(i);
			String outerl = itemLabel[i];
			
			Widget rowkid = outerrow.getFirstChild();
			Assert.assertEquals(""+i, rowkid.getValue());// verify the index  on label
			rowkid = rowkid.getNextSibling();
			Assert.assertEquals(outerl, rowkid.getValue());//verify the label on label
			
			rowkid = outerrow.getLastChild();
			Widget label = rowkid.findWidget("@label");//index button
			if(outerl.equals("A") || i==2){
				Assert.assertEquals("Model1", label.getValue());
			}else{
				Assert.assertEquals("Model2", label.getValue());
			}
		}
	}
	
	
	@Test
	public void templateGrid3(){
		navigate(getTestCaseUrl("/bind/basic/collection-template-grid.zul"));
		
		Widget outerbox = findWidget("$outergrid");
		List<Widget> outerrows = outerbox.findWidget("@rows").getChildren();
		
		String[] itemLabel = new String[]{"A","B","C", "D"};
		Assert.assertEquals(itemLabel.length, outerrows.size());
		
		for(int i=0;i<itemLabel.length;i++){
			Widget outerrow = outerrows.get(i);
			String outerl = itemLabel[i];
			
			Widget rowkid = outerrow.getFirstChild();
			Assert.assertEquals(""+i, rowkid.getValue());// verify the index  on label
			rowkid = rowkid.getNextSibling();
			Assert.assertEquals(outerl, rowkid.getValue());//verify the label on label
			
			//verify template
			rowkid = outerrow.getLastChild();
			Widget label = rowkid.findWidget("@label");//index button
			if(outerl.equals("A") || i==2){
				Assert.assertEquals("Model1", label.getValue());
			}else{
				Assert.assertEquals("Model2", label.getValue());
			}
		}
		
		
		findWidget("@button[label='change1']").click();
		outerbox = findWidget("$outergrid");
		outerrows = outerbox.findWidget("@rows").getChildren();
		
		itemLabel = new String[]{"X","A","C", "D"};
		Assert.assertEquals(itemLabel.length, outerrows.size());
		
		for(int i=0;i<itemLabel.length;i++){
			Widget outerrow = outerrows.get(i);
			String outerl = itemLabel[i];
			
			Widget rowkid = outerrow.getFirstChild();
			Assert.assertEquals(""+i, rowkid.getValue());// verify the index  on label
			rowkid = rowkid.getNextSibling();
			Assert.assertEquals(outerl, rowkid.getValue());//verify the label on label
			
			//verify template
			rowkid = outerrow.getLastChild();
			Widget label = rowkid.findWidget("@label");//index button
			if(outerl.equals("A") || i==2){
				Assert.assertEquals("Model1", label.getValue());
			}else{
				Assert.assertEquals("Model2", label.getValue());
			}
		}
		
		findWidget("@button[label='change2']").click();
		outerbox = findWidget("$outergrid");
		outerrows = outerbox.findWidget("@rows").getChildren();
		
		itemLabel = new String[]{"A","B","C", "D"};
		Assert.assertEquals(itemLabel.length, outerrows.size());
		
		for(int i=0;i<itemLabel.length;i++){
			Widget outerrow = outerrows.get(i);
			String outerl = itemLabel[i];
			
			Widget rowkid = outerrow.getFirstChild();
			Assert.assertEquals(""+i, rowkid.getValue());// verify the index  on label
			rowkid = rowkid.getNextSibling();
			Assert.assertEquals(outerl, rowkid.getValue());//verify the label on label
			
			//verify template
			rowkid = outerrow.getLastChild();
			Widget label = rowkid.findWidget("@label");//index button
			if(outerl.equals("A") || i==2){
				Assert.assertEquals("Model1", label.getValue());
			}else{
				Assert.assertEquals("Model2", label.getValue());
			}
		}
	}
	
	
	@Test
	public void templateListbox1(){
		navigate(getTestCaseUrl("/bind/basic/collection-template-listbox.zul"));
		
		Widget outerbox = findWidget("$outerbox");
		List<Widget> outeritems = outerbox.getChildren();//include header
		outeritems.remove(0);//don't care header
		
		String[] itemLabel = new String[]{"A","B","C", "D"};
		Assert.assertEquals(itemLabel.length, outeritems.size());
		
		for(int i=0;i<itemLabel.length;i++){
			Widget outeritem = outeritems.get(i);
			String outerl = itemLabel[i];
			
			Widget cell = outeritem.getFirstChild();
			Assert.assertEquals(""+i, cell.getLabel());// verify the index
			cell = cell.getNextSibling();
			Assert.assertEquals(outerl, cell.getLabel());//verify the label
			
			Widget innerbox = outeritem.findWidget("@listbox");
			Assert.assertNotNull(innerbox);
			List<Widget> inneritems = innerbox.findWidgets("@listitem");
			Assert.assertEquals(2, inneritems.size());
			for(int j=0;j<2;j++){
				Widget inneritem = inneritems.get(j);
				cell = inneritem.getFirstChild();
				Assert.assertEquals(""+j, cell.getLabel());
				cell = cell.getNextSibling();
				Assert.assertEquals(""+i, cell.getLabel());
				
				String innerl = itemLabel[i]+" "+j;
				cell = cell.getNextSibling();
				Assert.assertEquals(innerl, cell.getLabel());
			}
			
			cell = outeritem.getLastChild().getPreviousSibling();
			Widget btn = cell.findWidget("@button");//index button
			Widget msg = findWidget("$msg");
			btn.click();
			
			Assert.assertEquals("item index "+i, msg.getValue());
			
			//verify template
			cell = outeritem.getLastChild();
			if(outerl.equals("A") || i==2){
				Assert.assertEquals("Model1", cell.getLabel());
			}else{
				Assert.assertEquals("Model2", cell.getLabel());
			}
		}
	}
	
	@Test
	public void templateListbox2(){
		navigate(getTestCaseUrl("/bind/basic/collection-template-listbox.zul"));
		
		Widget outerbox = findWidget("$outerbox");
		List<Widget> outeritems = outerbox.getChildren();//include header
		outeritems.remove(0);//don't care header
		
		//=================================delete 2rd row
		Widget outeritem = outeritems.get(1);
		outeritem.findWidgets("@button").get(1).click();//click the delete button on 2nd row
		
		outerbox = findWidget("$outerbox");
		outeritems = outerbox.getChildren();//include header
		outeritems.remove(0);//don't care header
		String[] itemLabel = new String[]{"A","C", "D"};
		Assert.assertEquals(itemLabel.length, outeritems.size());
		
		for(int i=0;i<itemLabel.length;i++){
			outeritem = outeritems.get(i);
			String outerl = itemLabel[i];
			
			Widget cell = outeritem.getFirstChild();
			Assert.assertEquals(""+i, cell.getLabel());// verify the index
			cell = cell.getNextSibling();
			Assert.assertEquals(outerl, cell.getLabel());//verify the label
			
			Widget innerbox = outeritem.findWidget("@listbox");
			Assert.assertNotNull(innerbox);
			List<Widget> inneritems = innerbox.findWidgets("@listitem");
			Assert.assertEquals(2, inneritems.size());
			for(int j=0;j<2;j++){
				Widget inneritem = inneritems.get(j);
				cell = inneritem.getFirstChild();
				Assert.assertEquals(""+j, cell.getLabel());
				cell = cell.getNextSibling();
				Assert.assertEquals(""+i, cell.getLabel());
				
				String innerl = itemLabel[i]+" "+j;
				cell = cell.getNextSibling();
				Assert.assertEquals(innerl, cell.getLabel());
			}
			
			cell = outeritem.getLastChild().getPreviousSibling();
			Widget btn = cell.findWidget("@button");//index button
			Widget msg = findWidget("$msg");
			btn.click();
			
			Assert.assertEquals("item index "+i, msg.getValue());
			
			//verify template
			cell = outeritem.getLastChild();
			if(outerl.equals("A") || i==2){
				Assert.assertEquals("Model1", cell.getLabel());
			}else{
				Assert.assertEquals("Model2", cell.getLabel());
			}
		}
		
		//===============================add after row
		outeritem = outeritems.get(1);
		outeritem.findWidgets("@button").get(2).click();//click the add after button on 2nd row
		
		outerbox = findWidget("$outerbox");
		outeritems = outerbox.getChildren();//include header
		outeritems.remove(0);//don't care header
		itemLabel = new String[]{"A","C","C1","D"};
		Assert.assertEquals(itemLabel.length, outeritems.size());
		
		for(int i=0;i<itemLabel.length;i++){
			outeritem = outeritems.get(i);
			String outerl = itemLabel[i];
			
			Widget cell = outeritem.getFirstChild();
			Assert.assertEquals(""+i, cell.getLabel());// verify the index
			cell = cell.getNextSibling();
			Assert.assertEquals(outerl, cell.getLabel());//verify the label
			
			//verify template
			cell = outeritem.getLastChild();
			if(outerl.equals("A") || i==2){
				Assert.assertEquals("Model1", cell.getLabel());
			}else{
				Assert.assertEquals("Model2", cell.getLabel());
			}
		}
		
		//===============================add add before row
		outeritem = outeritems.get(2);
		outeritem.findWidgets("@button").get(3).click();//click the add before button on 2nd row
		
		outerbox = findWidget("$outerbox");
		outeritems = outerbox.getChildren();//include header
		outeritems.remove(0);//don't care header
		itemLabel = new String[]{"A","C","C12","C1","D"};
		Assert.assertEquals(itemLabel.length, outeritems.size());
		
		for(int i=0;i<itemLabel.length;i++){
			outeritem = outeritems.get(i);
			String outerl = itemLabel[i];
			
			Widget cell = outeritem.getFirstChild();
			Assert.assertEquals(""+i, cell.getLabel());// verify the index
			cell = cell.getNextSibling();
			Assert.assertEquals(outerl, cell.getLabel());//verify the label
			
			//verify template
			cell = outeritem.getLastChild();
			if(outerl.equals("A") || i==2){
				Assert.assertEquals("Model1", cell.getLabel());
			}else{
				Assert.assertEquals("Model2", cell.getLabel());
			}
		}
	}
	
	@Test
	public void templateListbox3(){
		navigate(getTestCaseUrl("/bind/basic/collection-template-listbox.zul"));
		
		Widget outerbox = findWidget("$outerbox");
		List<Widget> outeritems = outerbox.getChildren();//include header
		outeritems.remove(0);//don't care header
		
		String[] itemLabel = new String[]{"A","B","C", "D"};
		Assert.assertEquals(itemLabel.length, outeritems.size());
		
		for(int i=0;i<itemLabel.length;i++){
			Widget outeritem = outeritems.get(i);
			String outerl = itemLabel[i];
			
			Widget cell = outeritem.getFirstChild();
			Assert.assertEquals(""+i, cell.getLabel());// verify the index
			cell = cell.getNextSibling();
			Assert.assertEquals(outerl, cell.getLabel());//verify the label
			
			//verify template
			cell = outeritem.getLastChild();
			if(outerl.equals("A") || i==2){
				Assert.assertEquals("Model1", cell.getLabel());
			}else{
				Assert.assertEquals("Model2", cell.getLabel());
			}
		}
		
		
		findWidget("@button[label='change1']").click();
		outerbox = findWidget("$outerbox");
		outeritems = outerbox.getChildren();//include header
		outeritems.remove(0);//don't care header
		
		itemLabel = new String[]{"X","A","C", "D"};
		Assert.assertEquals(itemLabel.length, outeritems.size());
		
		for(int i=0;i<itemLabel.length;i++){
			Widget outeritem = outeritems.get(i);
			String outerl = itemLabel[i];
			
			Widget cell = outeritem.getFirstChild();
			Assert.assertEquals(""+i, cell.getLabel());// verify the index
			cell = cell.getNextSibling();
			Assert.assertEquals(outerl, cell.getLabel());//verify the label
			
			//verify template
			cell = outeritem.getLastChild();
			if(outerl.equals("A") || i==2){
				Assert.assertEquals("Model1", cell.getLabel());
			}else{
				Assert.assertEquals("Model2", cell.getLabel());
			}
		}
		
		findWidget("@button[label='change2']").click();
		outerbox = findWidget("$outerbox");
		outeritems = outerbox.getChildren();//include header
		outeritems.remove(0);//don't care header
		
		itemLabel = new String[]{"A","B","C", "D"};
		Assert.assertEquals(itemLabel.length, outeritems.size());
		
		for(int i=0;i<itemLabel.length;i++){
			Widget outeritem = outeritems.get(i);
			String outerl = itemLabel[i];
			
			Widget cell = outeritem.getFirstChild();
			Assert.assertEquals(""+i, cell.getLabel());// verify the index
			cell = cell.getNextSibling();
			Assert.assertEquals(outerl, cell.getLabel());//verify the label
			
			//verify template
			cell = outeritem.getLastChild();
			if(outerl.equals("A") || i==2){
				Assert.assertEquals("Model1", cell.getLabel());
			}else{
				Assert.assertEquals("Model2", cell.getLabel());
			}
		}
	}
	
	
	@Test
	public void templateCombobox(){
		navigate(getTestCaseUrl("/bind/basic/collection-template-combobox.zul"));
		
		Widget outerbox = findWidget("$outergrid");
		List<Widget> outerrows = outerbox.findWidget("@rows").getChildren();
		String[] itemLabel = new String[]{"A","B","C", "D"};
		Assert.assertEquals(itemLabel.length, outerrows.size());
		for(int i=0;i<itemLabel.length;i++){
			Widget outerrow = outerrows.get(i);
			Widget combobox = outerrow.findWidget("@combobox");
			combobox.call("open");//to show popu first so we can find comboitem in zkmax
			
			List<Widget> comboitems = combobox.findWidgets("@comboitem");
			Assert.assertEquals(4, comboitems.size());
			for(int j=0;j<2;j++){
				Widget comboitem = comboitems.get(j);
				if(j==0 || j==2){
					Assert.assertEquals("Model1-"+itemLabel[i]+" "+j+"-"+j+"-"+i, comboitem.getLabel());
				}else{
					Assert.assertEquals("Model2-"+itemLabel[i]+" "+j+"-"+j+"-"+i, comboitem.getLabel());
				}
				Assert.assertEquals(itemLabel[i]+" "+j, comboitem.getAttribute("description"));
			}
			Widget btn = outerrow.findWidget("@button");//index button
			Widget msg = findWidget("$msg");
			btn.click();
			
			Assert.assertEquals("item index "+i, msg.getValue());
		}
	}

	
	@Test
	public void testTreeselection(){
		navigate(getTestCaseUrl("/bind/basic/tree-selection.zul"));
		
		Widget tree = findWidget("$tree");
		
		Widget msg = findWidget("$msg");
		Widget selected = findWidget("$selected");
		Widget clean = findWidget("$clean");
		Widget select = findWidget("$select");
		Widget reload = findWidget("$reload");
		Widget select0 = findWidget("$select0");
		Widget select1 = findWidget("$select1");
		Widget showselect = findWidget("$showselect");
		
		findWidget("$A-0-1").getFirstChild().click();//treeitem->treerow
		Assert.assertEquals("A-0-1", selected.getValue());
		showselect.click();
		Assert.assertEquals("[0, 1]", msg.getValue());
		
		findWidget("$A-1-0-1").getFirstChild().click();//treeitem->treerow
		Assert.assertEquals("A-1-0-1", selected.getValue());
		showselect.click();
		Assert.assertEquals("[1, 0, 1]", msg.getValue());
		
		clean.click();
		Assert.assertEquals("", selected.getValue());
		showselect.click();
		Assert.assertEquals("no selection", msg.getValue());
		
		select.click();
		Assert.assertEquals("A-1-1-1", selected.getValue());
		showselect.click();
		Assert.assertEquals("[1, 1, 1]", msg.getValue());
		
		select0.click();
		showselect.click();
		Assert.assertEquals("[0, 1]", msg.getValue());
		
		reload.click();
		Assert.assertEquals("A-1-1-1", selected.getValue());
		Assert.assertEquals("reloaded A-1-1-1", msg.getValue());
		showselect.click();
		Assert.assertEquals("[1, 1, 1]", msg.getValue());
		
		select1.click();
		showselect.click();
		Assert.assertEquals("[0, 1, 1]", msg.getValue());
		
		reload.click();
		Assert.assertEquals("A-1-1-1", selected.getValue());
		Assert.assertEquals("reloaded A-1-1-1", msg.getValue());
		showselect.click();
		Assert.assertEquals("[1, 1, 1]", msg.getValue());
		
		
	}
	
	
	@Test
	public void indexDefault(){
		navigate(getTestCaseUrl("/bind/basic/collection-index-default.zul"));
		
		Widget listbox = findWidget("$listbox");
		List<Widget> outeritems = listbox.getChildren();//include header
		outeritems.remove(0);//don't care header
		
		String[] itemLabel = new String[]{"A","B","C", "D"};
		Assert.assertEquals(itemLabel.length, outeritems.size());
		
		for(int i=0;i<itemLabel.length;i++){
			Widget outeritem = outeritems.get(i);
			String outerl = itemLabel[i];
			
			Widget cell = outeritem.getFirstChild();
			Assert.assertEquals(""+i, cell.getLabel());// verify the index
			cell = cell.getNextSibling();
			Assert.assertEquals(outerl, cell.getLabel());//verify the label
		}
		
		Widget grid = findWidget("$grid");
		List<Widget> outerrows = grid.findWidget("@rows").getChildren();
		
		Assert.assertEquals(itemLabel.length, outerrows.size());
		
		for(int i=0;i<itemLabel.length;i++){
			Widget outerrow = outerrows.get(i);
			String outerl = itemLabel[i];
			
			Widget rowkid = outerrow.getFirstChild();
			Assert.assertEquals(""+i, rowkid.getValue());// verify the index  on label
			rowkid = rowkid.getNextSibling();
			Assert.assertEquals(outerl, rowkid.getValue());//verify the label on label
		}
		
		
		Widget combobox = findWidget("$combobox");
		combobox.call("open");//to show popu first so we can find comboitem in zkmax
		List<Widget> comboitems = combobox.findWidgets("@comboitem");
		Assert.assertEquals(itemLabel.length, comboitems.size());
		for(int i=0;i<itemLabel.length;i++){
			Widget comboitem = comboitems.get(i);
			Assert.assertEquals(itemLabel[i], comboitem.getLabel());
			Assert.assertEquals(""+i, comboitem.getAttribute("description"));
		}
		
	}
}
