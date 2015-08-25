/* FakeSearchService.java

	Purpose:
		
	Description:
		
	History:
		2011/10/25 Created by Dennis Chen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
 */
package org.zkoss.bind.examples.spring.search.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 */
@Service("itemService")
public class SearchServiceImpl implements ItemService {

	@Autowired
	ItemDao itemDao;
	
	List<Item> allItems = new ArrayList<Item>();

	Random r = new Random(System.currentTimeMillis());
	

	double nextPrice() {
		return r.nextDouble()*300;
	}
	
	int nextQuantity() {
		return r.nextInt(10);
	}

	public List<Item> search(String fitler) {
		List<Item> items = new ArrayList<Item>();
		for (Item item : allItems) {
			if ((fitler == null || "*".equals(fitler))
					|| item.getName().indexOf(fitler) >= 0) {
				items.add(item);
			}
		}
		return items;
	}
	
	public List<Item> findAll(){
		return itemDao.findAll();
	}

}
