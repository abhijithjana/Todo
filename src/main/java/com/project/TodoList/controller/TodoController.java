package com.project.TodoList.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project.TodoList.Todo;
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
    
    @RequestMapping("login")
    public String login() {
    	return "Login";
    }
    
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String auth(HttpServletRequest req,ModelMap model,HttpServletResponse res) throws ServletException, IOException {
    	String name=req.getParameter("uname");
    	String pass=req.getParameter("upass");
    	if(name.equalsIgnoreCase(pass))
//    		return "redirect:/list-todo";
    	{
    		
    		RequestDispatcher rd=req.getRequestDispatcher("/list-todo");
    		rd.forward(req,res);
    	}
    	model.put("error","Invalid credential");
    	return "Login";
    }
	
	@RequestMapping("list-todo")
	
	public String getTodoList(ModelMap model) {
		List<Todo> todolist=todo.findbyuser("Abhijith");
		model.addAttribute("todos",todolist);
		return "listtodo";
	}
	
	@RequestMapping(value="add-todo",method = RequestMethod.GET)
	public String addtodo(ModelMap model) {
		 String uname=(String)model.get("uname");
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
			todo.addTodo(new Todo(++todo.sl,uname,t.getDisc(),t.getTarget(), false));
			return "redirect:/list-todo";
	}
	
	@RequestMapping(value="update-todo",method = RequestMethod.GET)
	public String updatetodo(@RequestParam int id,ModelMap model) {
		 
		  Todo t=todo.findbyid(id);
		 model.put("todo",t);
		 model.put("action","update-todo");
			return "Addtodo";
	}
	
	@RequestMapping(value="update-todo",method = RequestMethod.POST)
	public String updatetodos(ModelMap model,@Valid Todo t,BindingResult result) {
		if(result.hasErrors()) {
			return "Addtodo";
		}
		    String uname=(String)model.get("uname");
			todo.updatebyid(t);
			return "redirect:/list-todo";
	}
	
	
	@RequestMapping(value="remove-id",method = RequestMethod.GET)
	public String removebyid(@RequestParam int id) {
		   todo.removebyid(id);
			return "redirect:/list-todo";
	}

	
	
}
