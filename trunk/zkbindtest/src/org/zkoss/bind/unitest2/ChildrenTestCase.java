package org.zkoss.bind.unitest2;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.zkoss.zktc.core.junit.TestCaseBase;
import org.zkoss.zktc.core.widget.Widget;

public class ChildrenTestCase extends TestCaseBase{
	@Test
	public void testSimple1(){
		navigate(getTestCaseUrl("/bind/basic/children-simple.zul"));
		
		Widget init = findWidget("$init");
		Widget load = findWidget("$load");
		Widget aftercmd = findWidget("$aftercmd");
		
		Widget cmd1 = findWidget("$cmd1");
		Widget cmd2 = findWidget("$cmd2");
		
		List<Widget> labels = init.findWidgets("@label");
		String[] compare = new String[]{"Item A","Item B","Item C"};
		Assert.assertEquals(compare.length, labels.size());
		for(int i=0;i<compare.length;i++){
			Assert.assertEquals(compare[i], labels.get(i).getValue());
		}
		labels = load.findWidgets("@label");
		Assert.assertEquals(compare.length, labels.size());
		for(int i=0;i<compare.length;i++){
			Assert.assertEquals(compare[i], labels.get(i).getValue());
		}
		labels = aftercmd.findWidgets("@label");
		Assert.assertEquals(0, labels.size());
		
		cmd1.click();
		labels = init.findWidgets("@label");
		compare = new String[]{"Item A","Item B","Item C"};
		Assert.assertEquals(compare.length, labels.size());
		for(int i=0;i<compare.length;i++){
			Assert.assertEquals(compare[i], labels.get(i).getValue());
		}
		labels = load.findWidgets("@label");
		compare = new String[]{"Item A","Item B","Item C","Item D"};
		Assert.assertEquals(compare.length, labels.size());
		for(int i=0;i<compare.length;i++){
			Assert.assertEquals(compare[i], labels.get(i).getValue());
		}
		labels = aftercmd.findWidgets("@label");
		Assert.assertEquals(0, labels.size());
		
		cmd2.click();
		labels = init.findWidgets("@label");
		compare = new String[]{"Item A","Item B","Item C"};
		Assert.assertEquals(compare.length, labels.size());
		for(int i=0;i<compare.length;i++){
			Assert.assertEquals(compare[i], labels.get(i).getValue());
		}
		labels = load.findWidgets("@label");
		compare = new String[]{"Item A","Item B","Item C","Item D"};
		Assert.assertEquals(compare.length, labels.size());
		for(int i=0;i<compare.length;i++){
			Assert.assertEquals(compare[i], labels.get(i).getValue());
		}
		labels = aftercmd.findWidgets("@label");
		compare = new String[]{"Item A","Item B","Item C","Item D","Item E"};
		Assert.assertEquals(compare.length, labels.size());
		for(int i=0;i<compare.length;i++){
			Assert.assertEquals(compare[i], labels.get(i).getValue());
		}
		
		cmd1.click();
		labels = load.findWidgets("@label");
		compare = new String[]{"Item A","Item B","Item C","Item D","Item E","Item D"};
		Assert.assertEquals(compare.length, labels.size());
		for(int i=0;i<compare.length;i++){
			Assert.assertEquals(compare[i], labels.get(i).getValue());
		}
		labels = aftercmd.findWidgets("@label");
		compare = new String[]{"Item A","Item B","Item C","Item D","Item E"};
		Assert.assertEquals(compare.length, labels.size());
		for(int i=0;i<compare.length;i++){
			Assert.assertEquals(compare[i], labels.get(i).getValue());
		}
	}
	
	@Test
	public void testSimple2(){
		navigate(getTestCaseUrl("/bind/basic/children-simple.zul"));
		
		Widget dependency = findWidget("$dependency");
		Widget cmd3 = findWidget("$cmd3");
		
		List<Widget> labels = dependency.findWidgets("@label");
		String[] compare = new String[]{"Item A","Item B","Item C"};
		Assert.assertEquals(compare.length, labels.size());
		for(int i=0;i<compare.length;i++){
			Assert.assertEquals(compare[i], labels.get(i).getValue());
			Assert.assertEquals("Item A".equals(compare[i])?"c1":"c2", labels.get(i).getAttribute("sclass"));
		}
		cmd3.click();
		compare = new String[]{"Item X","Item A","Item C"};
		labels = dependency.findWidgets("@label");
		Assert.assertEquals(compare.length, labels.size());
		for(int i=0;i<compare.length;i++){
			Assert.assertEquals(compare[i], labels.get(i).getValue());
			Assert.assertEquals("Item A".equals(compare[i])?"c1":"c2", labels.get(i).getAttribute("sclass"));
		}
	}
	
	@Test
	public void testComplex(){
		navigate(getTestCaseUrl("/bind/basic/children-complex.zul"));
		
		List<Node> nodes= new ArrayList<Node>();
		nodes.add(createNode("Item A",0,0));
		nodes.add(createNode("Item B",3,1));
		nodes.add(createNode("Item C",2,2));
		
		
		Widget layout = findWidget("$vlayout");
		
		List<Widget> children = layout.getChildren();
		testComplex(nodes,children,true);
	}
	
	void testComplex(List<Node> nodes,List<Widget> children, boolean children1){
		Assert.assertEquals(nodes.size(), children.size());
		for(int i=0;i<nodes.size();i++){
			Node n = nodes.get(i);
			Widget w = children.get(i);
			Assert.assertEquals(children1?"children1":"children2", w.getAttribute("sclass"));
			
			Widget l = w.getFirstChild();
			Assert.assertEquals(n.getName(), l.getValue());
			
			Widget l2 = l.getNextSibling();
			testComplex(n.getChildren(),l2.getChildren(),!children1);
		}
	}
	
	Node createNode(String name,int children,int nested){
		Node n = new Node(name);
		if(nested>0){
			for(int i=0;i<children;i++){
				n.addChild(createNode(name+"_"+i,children,nested-1));
			}
		}
		return n;
	}
	
	
	@Test
	public void testMenu(){
		navigate(getTestCaseUrl("/bind/basic/children-menu.zul"));
		
		List<Node> nodes= new ArrayList<Node>();
		nodes.add(createMenuNode("Item A",0,0));
		nodes.add(createMenuNode("Item B",1,1));
		nodes.add(createMenuNode("Item C",2,2));
		nodes.add(createMenuNode("Item D",3,3));

		Widget mbar = findWidget("$mbar");
		
		List<Widget> children = mbar.getChildren();
		testMenu(nodes,children);
	}

	
	void testMenu(List<Node> nodes,List<Widget> children){
		Assert.assertEquals(nodes.size(), children.size());
		for(int i=0;i<nodes.size();i++){
			Node n = nodes.get(i);
			Widget w = children.get(i);
			
			Assert.assertEquals(n.getName(), w.getLabel());
			if(n.getChildren().size()==0){
				Assert.assertEquals("zul.menu.Menuitem", w.getClassName());
			}else{
				Assert.assertEquals("zul.menu.Menu", w.getClassName());
				if(w.getFirstChild()==null) w.click();//need to click if menu is in menu bar
				//show menu popup
				w.getFirstChild().call("open");
				testMenu(n.getChildren(),w.getFirstChild().getChildren());
			}
		}
	}

	
	Node createMenuNode(String name,int children,int nested){
		Node n = new Node(name);
		if(nested>0){
			for(int i=0;i<children;i++){
				n.addChild(createMenuNode(name+"_"+i,i==children-1?0:children,nested-1));
			}
		}
		return n;
	}

	
	static public class Node{
		List<Node> children;
		String name;
		
		public Node(String name){
			this.name = name;
			children = new ArrayList<Node>();
		}
		
		public void addChild(Node node){
			children.add(node);
		}
		
		public List<Node> getChildren(){
			return children;
		}
		
		public String getName(){
			return name;
		}
		
	}

}
