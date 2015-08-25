/* Album.java

	Purpose:
		
	Description:
		
	History:
		Sep 28, 2011 2:42:28 PM, Created by henrichen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
*/

package org.zkoss.mvvm.examples.album;

/**
 * @author henrichen
 *
 */
public class Album {
	private int id;
	private String title;
	private String artist;
	private boolean classical;
	private String composer;
	
	public Album(int id, String title, String artist, boolean classical, String composer) {
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.classical = classical;
		this.composer = composer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;  
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public boolean isClassical() {
		return classical;
	}
	public void setClassical(boolean classical) {
		this.classical = classical;
	}
	public String getComposer() {
		return composer;
	}
	public void setComposer(String composer) {
		this.composer = composer;
	}
	public int hashCode() {
		return id;
	}
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (!(other instanceof Album)) {
			return false;
		}
		final Album o = (Album) other;
		return this.id == o.id;
	}
}
