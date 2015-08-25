package org.zkoss.bind.examples.search;

import org.junit.Assert;
import org.junit.Test;

public class SearchVMTestCase {
	@Test
	public void test01(){
		SearchVM vm = new SearchVM();
		
		Assert.assertNull(vm.getItems());
		vm.doSearch();
		Assert.assertNotNull(vm.getItems());
		Assert.assertEquals(20, vm.getItems().getSize());
		
		vm.setFilter("A");
		vm.doSearch();
		Assert.assertNotNull(vm.getItems());
		Assert.assertEquals(4, vm.getItems().getSize());
		
		vm.setFilter("B");
		vm.doSearch();
		Assert.assertNotNull(vm.getItems());
		Assert.assertEquals(4, vm.getItems().getSize());
		
		vm.setFilter("X");
		vm.doSearch();
		Assert.assertNotNull(vm.getItems());
		Assert.assertEquals(0, vm.getItems().getSize());
	}
}
