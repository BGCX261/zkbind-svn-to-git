package org.zkoss.mvvm.examples.globalcommand;

import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.validator.AbstractValidator;

public class MainViewModel {

	private boolean visible = true;
	private String item;
	private String msg;
	
	public boolean isVisible() {
		return visible;
	}

	@Command @NotifyChange("msg")
	public void add(){
		ItemList.add(item);
		msg = "Added "+item;
	}
	
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@GlobalCommand @NotifyChange("visible")
	public void show(){
		visible = true;
	}
	@GlobalCommand @NotifyChange("visible")
	public void hide(){
		visible =false;
	}

	
	public Validator getItemValidator(){
		return new AbstractValidator() {
			
			public void validate(ValidationContext ctx) {
				if (ctx.getProperty().getValue() instanceof String){
					String item = (String)ctx.getProperty().getValue();
					if (null == item || item.length()<=2){
						addInvalidMessage(ctx, "Too short item name");
					}
				}
				
			}
		};
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}
}
