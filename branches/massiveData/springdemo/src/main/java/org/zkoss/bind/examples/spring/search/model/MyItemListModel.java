package org.zkoss.bind.examples.spring.search.model;

import java.util.Comparator;
import java.util.List;

import org.zkoss.bind.examples.spring.search.domain.Item;
import org.zkoss.bind.examples.spring.search.domain.ItemDao;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.AbstractListModel;
import org.zkoss.zul.FieldComparator;
import org.zkoss.zul.event.ListDataEvent;
import org.zkoss.zul.ext.Sortable;

public class MyItemListModel extends AbstractListModel<Item> implements Sortable<Item>{

	private ItemDao itemDao;
	
	private List<Item> cache;
	private Integer size;
	private int pageSize = 10;
	private int beginOffset;
	
	private Boolean ascending;
	private String orderBy;
	private String filter;
	
	public MyItemListModel() {
		itemDao = (ItemDao)SpringUtil.getBean("itemDao");
	}
	
	public Item getElementAt(int index){
		
		if (cache == null || index < beginOffset || index >= beginOffset + pageSize) {
			beginOffset = index;
			if (ascending!=null &&orderBy!=null){
				cache = itemDao.findByRangeOrder(index, pageSize, ascending, orderBy, filter);
			}else{
				cache = itemDao.findByRange(index,pageSize, filter);
			}
		}
		return cache.get(index-beginOffset);
	}
	
	public int getSize(){
		if (size == null){
			if (filter == null){
				size = itemDao.findAll().size();
			}
			else{
				size = itemDao.findByFilter(filter).size();
			}
		}
		return size;
	}
	//FIXME selection of listbox doesn't update after sorting  
	public void sort(Comparator comparator, boolean flag) {
	   if (comparator instanceof FieldComparator) {
		   //Find all selected item
		   
	       ascending = flag;
	       orderBy = ((FieldComparator)comparator).getRawOrderBy();
	       cache = null;
	       size = null;
	       fireEvent(ListDataEvent.CONTENTS_CHANGED, -1, -1);
	       
	       //TODO update selection to new index for selected item
	    }
	}
	
	public String getSortDirection(Comparator<Item> cmpr){
		if(ascending==null) return "natural";
		return ascending?"ascending":"descending";
	}
	
	public void setFilter(String filter){
		this.filter = filter;
		cache = null;
		size = null;
		
		//clear selection 
		clearSelection();
		fireEvent(ListDataEvent.CONTENTS_CHANGED, -1, -1);
		
	}
}
