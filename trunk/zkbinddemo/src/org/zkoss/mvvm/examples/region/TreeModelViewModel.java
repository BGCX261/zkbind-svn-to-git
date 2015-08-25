/* TreeModelViewModel.java

	Purpose:
		
	Description:
		
	History:
		Sep 26, 2011 3:46:39 PM, Created by henrichen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
*/

package org.zkoss.mvvm.examples.region;

import org.zkoss.bind.BindComposer;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.TreeModel;
import org.zkoss.zul.TreeNode;

/**
 * View model for examples/region/treeview.zul
 * @author henrichen
 *
 */
public class TreeModelViewModel extends BindComposer {
	private static Country country = new Country();
	private TreeNode _selected;
	
	public TreeModel getTreeModel() { //Tree view model
		return country.getTreeModel(); 
	}
	
	@NotifyChange
	public void setSelected(TreeNode node) { //selected TreeNode
		_selected = node;
	}
	
	public TreeNode getSelected() {
		return _selected;
	}
}
