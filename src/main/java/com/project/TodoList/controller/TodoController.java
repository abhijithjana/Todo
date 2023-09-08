package com.project.TodoList.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project.TodoList.Todo;
import com.project.TodoList.TodoRepositary;
import com.project.TodoList.service.TodoService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;


@Controller
@SessionAttributes("uname")
public class TodoController{
    @Autowired
   private TodoService todo;
	@Autowired
	private TodoRepositary todos;
    
    @RequestMapping("")
    public String welcome() {
    	return "home";
    }
    public String getUsername() {
    	return SecurityContextHolder.getContext().getAuthentication().getName();
    }
    
   @RequestMapping("list-todo")
	public String getTodoList(ModelMap model) {
		List<Todo> todolist=todos.findByusername(getUsername());
		model.addAttribute("todos",todolist);
		model.put("uname",getUsername());
		return "listtodo";
	}
	
	@RequestMapping(value="add-todo",method = RequestMethod.GET)
	public String addtodo(ModelMap model) {
		 String uname=getUsername();
		 model.put("action","add-todo");
		 model.put("todo",new Todo(0,uname,"", null, false));
			return "Addtodo";
	}
	
	@RequestMapping(value="add-todo",method = RequestMethod.POST)
	public String savetodo(ModelMap model,@Valid Todo t,BindingResult result) {
		if(result.hasErrors()) {
			return "Addtodo";
		}
		    String uname=(String)model.get("uname");
			t.setUsername(uname);
		    todos.save(t);
			return "redirect:/list-todo";
	}
	
	@RequestMapping(value="update-todo",method = RequestMethod.GET)
	public String updatetodo(@RequestParam int id,ModelMap model) {
		 
		  Todo t=todos.findById(id).get();
		 model.put("todo",t);
		 model.put("action","update-todo");
			return "Addtodo";
	}
	
	@RequestMapping(value="update-todo",method = RequestMethod.POST)
	public String updatetodos(ModelMap model,@Valid Todo t,BindingResult result) {
		if(result.hasErrors()) {
			return "Addtodo";
		}
		   
			todos.saveAndFlush(t);
			return "redirect:/list-todo";
	}
	
	
	@RequestMapping(value="remove-id",method = RequestMethod.GET)
	public String removebyid(@RequestParam int id) {
		   todos.deleteById(id);
			return "redirect:/list-todo";
	}

	
	
}
