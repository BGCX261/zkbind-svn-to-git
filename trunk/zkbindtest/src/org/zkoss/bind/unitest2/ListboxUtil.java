package org.zkoss.bind.unitest2;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zktc.core.widget.Widget;

public class ListboxUtil {
	public static long getSelectedIndex(Widget listbox){
		
		long index;
//		long index = (Long)listbox.getAttribute("selectedIndex");////listbox bug in zkmax, don't get form selectedIndex
//		if(index!=-1) return index;
		Widget selected = listbox.getWidgetAttribute("selectedItem");
		if(selected==null) return -1L;
		
		List<Widget> outeritems = listbox.getChildren();//include header
		index = 0;
		for(Widget w:outeritems){
			if("listitem".equals(w.getWidgetName())){
				if(isSelected(w)){
					return index;
				}
				index++;
			}
		}
		return -1L;
	}
	
	public static boolean isSelected(Widget listitem){
		Object selected = listitem.getAttribute("selected");
		return Boolean.TRUE.equals(selected);
	}
	
	public static long[] getSelectedIndexs(Widget listbox){
		//Welcome To Facebook....selected is always false in listitem
		//so this api is useless...
		List<Long> indexs = new ArrayList<Long>();
		List<Widget> outeritems = listbox.getChildren();//include header
		
		long index = 0;
		for(Widget w:outeritems){
			if("listitem".equals(w.getWidgetName())){
				if(isSelected(w)){
					indexs.add(index);
				}
				index++;
			}
		}
		long[] ix = new long[indexs.size()];
		for(int i=0;i<ix.length;i++){
			ix[i] = indexs.get(i);
		}
		return ix;
	}
}
