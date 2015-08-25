package org.zkoss.bind.examples.search.mvp;

import java.text.DecimalFormat;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Listitem;
import org.zkoss.bind.examples.search.*;

public class ItemRenderer implements ListitemRenderer<Item>{

	static DecimalFormat priceFormatter = new DecimalFormat("$ ###,###,###,##0.00");

	public void render(Listitem item, Item data, int index){
		
		Listcell nameCell = new Listcell();
		nameCell.setLabel(data.getName());
		Listcell priceCell = new Listcell();
		priceCell.setLabel(priceFormatter.format(data.getPrice()));
		Listcell quantityCell = new Listcell();
		quantityCell.setLabel(Integer.toString(data.getQuantity()));
		if (data.getQuantity()<3){
			quantityCell.setSclass("red");
		}
		
		item.appendChild(nameCell);
		item.appendChild(priceCell);
		item.appendChild(quantityCell);
		
	}
}

