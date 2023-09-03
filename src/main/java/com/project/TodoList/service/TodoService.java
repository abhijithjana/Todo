package com.project.TodoList.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.TodoList.Todo;


@Service
public class TodoService {
private static List<Todo> todolist=new ArrayList<Todo>();
public static int sl=0;
static {
	todolist.add(new Todo(++sl,"Abhijith","SpringBoot", LocalDate.now().plusMonths(1), false));
	todolist.add(new Todo(++sl,"Abhijith","FronEnd", LocalDate.now().plusMonths(1), false));
}
public List<Todo> findbyuser(String username){
	return todolist;
}

public void addTodo(Todo t) {
	todolist.add(t);
}
}
