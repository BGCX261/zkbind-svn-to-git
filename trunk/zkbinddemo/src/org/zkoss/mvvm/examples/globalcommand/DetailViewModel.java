package org.zkoss.mvvm.examples.globalcommand;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;

public class DetailViewModel {

	private boolean visible = true;
	

	
	private String msg;
	
	public boolean isVisible() {
		return visible;
	}
	

	@GlobalCommand @NotifyChange("msg")
	public void detail(@BindingParam("name")String name){
		msg = name+"'s detail data: ....";
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
}
