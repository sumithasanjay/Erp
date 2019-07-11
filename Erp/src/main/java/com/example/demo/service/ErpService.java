package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface ErpService {

	void save(Employee Contact);
	
	Iterable<Employee> findAll();
	
	List<Employee> search(String s);
	
	void delete(int id);
	
	void edit(int id);

}
