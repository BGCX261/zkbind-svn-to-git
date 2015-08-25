package org.zkoss.mvvm.examples.confirm_delete;

import org.zkoss.bind.Binder;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Messagebox.ClickEvent;

public class ConfirmDelete2 extends ConfirmDeleteBase{

	
	@Command
	public void showConfirm(@ContextParam(ContextType.BINDER) final Binder binder){
		Messagebox.show("Do you really want to delete "+selected,"Confirm",
				new Messagebox.Button[] { Messagebox.Button.YES,Messagebox.Button.NO },
				Messagebox.QUESTION,new EventListener<ClickEvent>() {
			public void onEvent(ClickEvent event) throws Exception {
				switch (event.getButton()) {
					case YES:
						//if you call super.delete here, since original zk event is not control by binder
						//the change of viewmodel will not update to the ui.
						//so, I post a delete to trigger to process it in binder controll.
						binder.postCommand("delete", null);
				}
			}
		});
	}
	
	@Override
	protected boolean daoDelete(String data){
		try{
			super.daoDelete(data);
			return true;
		}catch(Exception x){
			Messagebox.show(x.getMessage());
		}
		return false;
	}
	
	public boolean isNeedToConfirm(){
		//simulate C doesn't need to be confirm
		if("C".equals(selected)){
			return false;
		}
		return true;
	}	
}
