package com.project.TodoList.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class TodoController {
    @Autowired
	private TodoService todo;
    
    @RequestMapping("login")
    public String login() {
    	return "Login";
    }
    
    @RequestMapping(value = "auth",method = RequestMethod.POST)
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
}
