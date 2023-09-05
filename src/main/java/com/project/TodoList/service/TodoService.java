package com.project.TodoList.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

public void updatebyid(Todo t) {
	  int index = todolist.indexOf(t);

	    if (index != -1) {
	    	if(todolist.removeIf(element->element.getId()==t.getId()));
	    		 // Remove the old object with the same ID
	        todolist.add(index, t);
	    }
	
}
public void removebyid(int id) {
	
	todolist.removeIf(element->element.getId()==id);
		
	
}

public Todo findbyid(int id) {
 Todo to=todolist.stream().filter(e->e.getId()==id).findFirst().orElse(null);
return to;
}
}
