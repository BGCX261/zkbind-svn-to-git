package org.zkoss.mvvm.examples.todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class TaskDAO {
	private String url = "jdbc:hsqldb:file:hsqldb/todo/task";//"jdbc:hsqldb:hsql://localhost/task"; //

	private String user = "SA";

	private String pwd = "";

	public TaskDAO() {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List findAll(){
		Statement stmt = null;
		Connection conn = null;
		List allTasks = new ArrayList();
		try {
			// get connection
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from TASK");

			// fetch all events from database
			Task task;
			while (rs.next()) {
				task = new Task();
				task.setId(rs.getString(1));
		        task.setName(rs.getString(2));
				task.setPriority(rs.getInt(3));
				task.setDate(rs.getDate(4));

				allTasks.add(task);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return allTasks;
	}
	
	public boolean delete(Task task){
		Connection conn = null;
		Statement stmt = null;
		boolean result = false;
		try {
			// get connection
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();
			if (stmt.executeUpdate("delete from TASK where id = '" + task.getId() + "'") > 0){
				result = true;	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public boolean insert(Task task){
		Connection conn = null;
		Statement stmt = null;
		boolean result = false;
		try {
			// get connection
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();
			if (stmt.executeUpdate("insert into TASK(id,name,priority,date) " +
					"values ('" + task.getId() + "','" + task.getName() +
					"'," + task.getPriority() + ",'" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(task.getDate()) + "')") > 0);
			result = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public boolean update(Task task){
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean result = false;
		try {
			// get connection
			conn = DriverManager.getConnection(url, user, pwd);
			String updateString = "update TASK set name = ?, priority = ?, date = ? where id = ?";
			stmt = conn.prepareStatement(updateString);
			stmt.setString(1, task.getName());
			stmt.setInt(2, task.getPriority());
			stmt.setDate(3, new java.sql.Date(task.getDate().getTime()));
			stmt.setString(4, task.getId());
			if (stmt.executeUpdate() > 0)
				result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
