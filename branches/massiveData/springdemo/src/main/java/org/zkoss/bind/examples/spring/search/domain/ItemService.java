/* SearchService.java

	Purpose:
		
	Description:
		
	History:
		2011/10/25 Created by Dennis Chen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
 */
package org.zkoss.bind.examples.spring.search.domain;

import java.util.List;

/**
 *
 */
public interface ItemService {
	public List<Item> search(String fitler);
	
	public List<Item> findAll();
}
