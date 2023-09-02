package com.project.TodoList.service;

import java.time.LocalDate;
import java.util.List;

import com.project.TodoList.Todo;

public class TodoService {
private static List<Todo> todolist;

static {
	todolist.add(new Todo(1,"Abhijith","SpringBoot", LocalDate.now().plusMonths(1), false));
	todolist.add(new Todo(2,"Abhijith","FronEnd", LocalDate.now().plusMonths(1), false));
}
public List<Todo> findbyuser(String username){
	return todolist;
}
}
