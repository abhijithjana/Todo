package com.project.TodoList.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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


@Controller
@SessionAttributes("uname")
public class TodoController implements ErrorController {
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
    		model.put("uname",name);
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
	public String addtodo() {
			return "Addtodo";
	}
	
	@RequestMapping(value="add-todo",method = RequestMethod.POST)
	public String savetodo(@RequestParam String discription,ModelMap model) {
		    String uname=(String)model.get("uname");
			todo.addTodo(new Todo(++todo.sl,uname,discription,LocalDate.now().plusYears(1), false));
			return "redirect:/list-todo";
	}

	
	
}
