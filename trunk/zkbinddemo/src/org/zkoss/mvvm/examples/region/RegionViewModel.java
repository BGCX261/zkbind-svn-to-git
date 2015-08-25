/* RegionViewModel.java

	Purpose:
		
	Description:
		
	History:
		Sep 26, 2011 10:58:58 AM, Created by henrichen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
*/

package org.zkoss.mvvm.examples.region;

import org.zkoss.bind.BindComposer;
import org.zkoss.bind.annotation.DependsOn;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.lang.Objects;
import org.zkoss.zul.ListModelList;

/**
 * View model for examples/region/region.zul
 * @author henrichen
 *
 */
public class RegionViewModel extends BindComposer {
	private static Country country = new Country();
	private Region region;
	private State state;
	private City city;
	
	public RegionViewModel() {
		
	}
	
	public Region getRegion() {
		return region;
	}

	@NotifyChange
	public void setRegion(Region region) { //selected region
		if (!Objects.equals(this.region, region)) {
			this.region = region;
			setState(null);
		}
	}

	@DependsOn("region")
	public State getState() {
		return state;
	}

	@NotifyChange
	public void setState(State state) { //selected state
		if (!Objects.equals(this.state, state)) {
			this.state = state;
			setCity(null);
		}
	}

	@DependsOn("state")
	public City getCity() {
		return city;
	}

	@NotifyChange
	public void setCity(City city) { //selected city
		this.city = city;
	}

	public ListModelList<Region> getRegions() { //region ListModel
		return new ListModelList<Region>(country.getRegions());
	}
	
	@DependsOn("region")
	public ListModelList<State> getStates() { //state ListModel
		if (region != null) {
			return new ListModelList<State>(country.getStates(region));
		}
		return null;
	}
	
	@DependsOn("state")
	public ListModelList<City> getCities() { //city ListModel
		if (state != null) {
			return new ListModelList<City>(country.getCities(state));
		}
		return null;
	}
	
	public static Country getCountry() {
		return country;
	}
	
	public static void setCountry(Country country) {
		RegionViewModel.country = country;
	}

}
