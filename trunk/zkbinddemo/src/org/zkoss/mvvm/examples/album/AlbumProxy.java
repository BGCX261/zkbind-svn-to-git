package org.zkoss.mvvm.examples.album;

import org.zkoss.lang.Objects;

public class AlbumProxy extends Album {
	private Album _inner;
	public AlbumProxy(Album inner) {
		super(inner.getId(), inner.getTitle(), inner.getArtist(), inner.isClassical(), inner.getComposer());
		_inner = inner;
	}
	
	public void acceptChanges() {
		_inner.setId(getId());
		_inner.setTitle(getTitle());
		_inner.setArtist(getArtist());
		_inner.setClassical(isClassical());
		_inner.setComposer(getComposer());
	}
	
	public void rejectChanges() {
		setId(_inner.getId());
		setTitle(_inner.getTitle());
		setArtist(_inner.getArtist());
		setClassical(_inner.isClassical());
		setComposer(_inner.getComposer());
	}
	
	public boolean isDirty() {
		return !Objects.equals(_inner.getTitle(), this.getTitle())
			|| !Objects.equals(_inner.getArtist(), this.getArtist())
			|| !Objects.equals(_inner.isClassical(), this.isClassical())
			|| !Objects.equals(_inner.getComposer(), this.getComposer());
	}
}
