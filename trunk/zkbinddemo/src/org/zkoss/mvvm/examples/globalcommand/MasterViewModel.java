package org.zkoss.mvvm.examples.globalcommand;

import java.util.Arrays;
import java.util.List;

import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.validator.AbstractValidator;

public class MasterViewModel {

	private boolean visible = true;
	
	private String[] staffs ={"Peter", "John","Matthew", "Simon", "Lucas"};

	private String selected;
	private int number;
	
	private String msg;
	
	
	public List<String> getStaffs() {
		return Arrays.asList(staffs);
	}

	public boolean isVisible() {
		return visible;
	}
	

	@Command @NotifyChange("msg")
	public void select(){
		msg = "You select "+selected;
	}
	
	@Command @NotifyChange("msg")
	public void submit(){
		selected = staffs[number];
		msg = "You select "+selected;
	}	

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public Validator getStaffNumberValidator(){
		return new AbstractValidator() {
			
			public void validate(ValidationContext ctx) {
				if (ctx.getProperty().getValue() instanceof Integer){
					Integer staffIndex =(Integer)ctx.getProperty().getValue()-1;
					if (staffIndex> staffs.length || staffIndex <0){
						addInvalidMessage(ctx, "Number out of range.");
					}
				}
				
			}
		};
	}
}
