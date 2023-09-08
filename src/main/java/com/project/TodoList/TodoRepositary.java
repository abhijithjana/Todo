package com.project.TodoList;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepositary extends JpaRepository<Todo,Integer>{

	
	public List<Todo> findByusername(String name);
}
