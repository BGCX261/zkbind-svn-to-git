/* AlbumDataSet.java

	Purpose:
		
	Description:
		
	History:
		Sep 28, 2011 2:59:47 PM, Created by henrichen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
*/

package org.zkoss.mvvm.examples.album;

import java.util.ArrayList;
import java.util.List;

/**
 * Album Data Set.
 * @author henrichen
 *
 */
public class AlbumDataSet {
    public static List<Album> getAlbums() {
        List<Album> result = new ArrayList<Album>();
        result.add(new Album(1, "HQ", "Roy Harper", false, null));
        result.add(new Album(2, "The Rough Dancer and Cyclical Night", "Astor Piazzola", false, null));
        result.add(new Album(3, "The Black Light", "Calexico", false, null));
        result.add(new Album(4, "Symphony No.5", "CBSO", true, "Sibelius" ));
        return result;
    }
}
