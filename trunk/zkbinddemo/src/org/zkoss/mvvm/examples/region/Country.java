/* Country.java

	Purpose:
		
	Description:
		
	History:
		Sep 26, 2011 10:59:22 AM, Created by henrichen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
*/

package org.zkoss.mvvm.examples.region;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.TreeModel;
import org.zkoss.zul.TreeNode;

/**
 * Example borrowed from http://www.codeproject.com/KB/WPF/TreeViewWithViewModel.aspx by Josh Smith.
 * User choose region, state, then city in US.
 * @author henrichen
 *
 */
public class Country {
	private Region[] regions;
	private Map<Region, State[]> states;
	private Map<State, City[]> cities;
	
	public Country() {
		regions = new Region[2];
		
		states = new HashMap<Region, State[]>();
		cities = new HashMap<State, City[]>(); 
		
		
		//Connecticut
		int j= 0;
		final State state1 = new State("Connecticut");
		{
		final City[] tcities = new City[3];
		tcities[j++] = new City("Bridgeport");
		tcities[j++] = new City("Hartford");
		tcities[j++] = new City("New Haven");
		cities.put(state1, tcities);
		}
		//New York
		j = 0;
		final State state2 = new State("New York");
		{
			final City[] tcities = new City[3];
			tcities[j++] = new City("Buffalo");
			tcities[j++] = new City("New York");
			tcities[j++] = new City("Syracuse");
			cities.put(state2, tcities);
		}
		//Indiana
		j = 0;
		final State state3 = new State("Indiana"); 
		{
			final City[] tcities = new City[4];
			tcities[j++] = new City("Evansville");
			tcities[j++] = new City("Fort Wayne");
			tcities[j++] = new City("Indianapolis");
			tcities[j++] = new City("South Bend");
			cities.put(state3, tcities);
		}
		
		//Northeast
		j = 0;
		final Region region1 = new Region("Northeast");
		{
			final State[] tstates = new State[2];
			tstates[j++] = state1;
			tstates[j++] = state2;
			states.put(region1, tstates);
		}
		
		//Midwest
		j = 0;
		final Region region2 = new Region("Midwest");
		{
			final State[] tstates = new State[1];
			tstates[j++] = state3;
			states.put(region2, tstates);
		}
		
		j= 0;
		regions[j++] = region1;
		regions[j++] = region2;
	}
	
	public Region[] getRegions() {
		return regions;
	}
	
	public State[] getStates(Region region) {
		return states.get(region);
	}
	
	public City[] getCities(State state) {
		return cities.get(state);
	}
	
	public TreeModel getTreeModel() {
		List<TreeNode> rnodes = new ArrayList<TreeNode>(regions.length);
		for (Region region : regions) {
			State[] states = getStates(region);
			List<TreeNode> snodes = new ArrayList<TreeNode>(states.length);
			for (State state : states) {
				City[] scities = getCities(state); 
				List<TreeNode> cnodes = new ArrayList<TreeNode>(scities.length);
				for (City city : scities) {
					cnodes.add(new DefaultTreeNode(city));
				}
				snodes.add(new DefaultTreeNode(state, cnodes));
			}
			rnodes.add(new DefaultTreeNode(region, snodes));
		}
		return new DefaultTreeModel(new DefaultTreeNode("Region", rnodes)); 
	}
}
