/* TodoViewModel.java

	Purpose:
		
	Description:
		
	History:
		Sep 15, 2011 4:21:53 PM, Created by henrichen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
*/

package org.zkoss.mvvm.examples.todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.zkoss.bind.BindComposer;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

/**
 * ViewModel for the examples/todo/todo.zul.
 * @author henrichen
 *
 */
public class TodoViewModel extends BindComposer {
	private TaskDAO taskdao = new TaskDAO(); 
	private Task selected;
	private Task newTask;
	private ListModelList allTasks;
	
	public Task getSelected() {
		return selected;
	}
	
	@NotifyChange
	public void setSelected(Task task) {
		this.selected = task;
	}
	
	public ListModel getAllTasks() {
		//fetch all tasks from database 
		List tasks = taskdao.findAll();
		if (tasks == null) {
			tasks = new ArrayList();
		}
		
		if (allTasks == null) {
			allTasks = new ListModelList(tasks, true);
		} else {
			//maintain selected Tasks if any
			final Set<Task> selection = allTasks.getSelection();
			
			allTasks.clear(); //will clear selection
			allTasks.addAll(tasks);
			
			//add selection back
			for (Task obj : selection) {
				allTasks.addSelection(obj);
			}
		}
		
		return allTasks;
	}

	public Task getNewTask() {
		if (newTask == null) {
			newTask = new Task(UUID.randomUUID().toString(), null, 0, null);
		}
		return newTask;
	}
	
	@Command @NotifyChange({"selected", "allTasks"})
	public void add(){	
		//insert into database
		if (newTask != null) {
			validate(); 
			taskdao.insert(newTask);
			
			selected = newTask;
			newTask = null;
		}
	}

	@Command @NotifyChange("selected")
	public void update(){
		//update database
		if (selected != null) {
			validate();
			taskdao.update(selected);
		}
	} 
	
	@Command @NotifyChange({"selected", "allTasks"})
	public void delete(){
		if (selected != null) {
			taskdao.delete(selected);
			selected = null;
		}
	}
	
	void validate(){
	}
}
