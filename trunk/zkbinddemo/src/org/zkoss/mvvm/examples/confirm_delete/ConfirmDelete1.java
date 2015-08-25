package org.zkoss.mvvm.examples.confirm_delete;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

public class ConfirmDelete1 extends ConfirmDeleteBase{

	
	String confirmMessage;
	
	public String getConfirmMessage(){
		return confirmMessage;
	}
	
	@Command @NotifyChange("confirmMessage")
	public void cancelConfirm(){
		confirmMessage = null;
	}
	
	@Command @NotifyChange("confirmMessage")
	public void showConfirm(){
		confirmMessage = "Do you really want to delete "+selected;
	}
	
	@Override
	@Command @NotifyChange({"message","items","selected","confirmMessage"})
	public void delete(){
		super.delete();
		confirmMessage = null;
		//clean confirmMessage and notify
	}
	
	public boolean isNeedToConfirm(){
		//simulate C doesn't need to be confirm
		if("C".equals(selected)){
			return false;
		}
		return true;
	}	
}
