/* WizardViewModel.java

	Purpose:
		
	Description:
		
	History:
		Sep 27, 2011 11:55:24 AM, Created by henrichen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
*/

package org.zkoss.mvvm.examples.wizard;

import org.zkoss.bind.BindComposer;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.DependsOn;
import org.zkoss.bind.annotation.NotifyChange;

/**
 * View model for examples/wizard.zul
 * @author henrichen
 *
 */
public class WizardViewModel extends BindComposer {
	private int step = 0; //assume step0 ~ step3, total 4 steps
	private int lastStep = 3;
	private String finishMessage;
	
	public String getStep() {
		return "step"+step;
	}
	
	public boolean isFirstStep() {
		return 0 == step;
	}
	
	@DependsOn("step")
	public boolean isLastStep() {
		return lastStep == step;
	}
	
	@Command @NotifyChange("step")
	public void next() {
		if (step < lastStep) {
			++step;
		}
	}
	
	@Command @NotifyChange("step")
	public void prev() {
		if (step > 0) {
			--step;
		}
	}
	
	@Command @NotifyChange("finishMessage")
	public void finish() {
		finishMessage = "Finished!";
	}
	
	public String getFinishMessage() {
		return finishMessage; 
	}
}
