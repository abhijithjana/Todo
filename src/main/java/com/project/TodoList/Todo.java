package com.project.TodoList;

import java.time.LocalDate;

public class Todo {

	
	private int id;
	private String username;
	private String disc;
	private LocalDate target;
	private boolean done;
	public Todo(int id, String username, String disc, LocalDate target, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.disc = disc;
		this.target = target;
		this.done = done;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDisc() {
		return disc;
	}
	public void setDisc(String disc) {
		this.disc = disc;
	}
	public LocalDate getTarget() {
		return target;
	}
	public void setTarget(LocalDate target) {
		this.target = target;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", disc=" + disc + ", target=" + target + ", done=" + done
				+ "]";
	}
	
}
