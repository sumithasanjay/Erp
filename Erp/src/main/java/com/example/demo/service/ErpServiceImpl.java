package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.ErpRepository;

import net.bytebuddy.asm.Advice.Return;

@Service
public class ErpServiceImpl implements ErpService{

	
	@Autowired
	private ErpRepository repo;
	
	@Override
	public void save( Employee Contact) {
		repo.save(Contact);

	}
	@Override
	public List<Employee> search(String s) {
		return repo.findByNameContaining(s);
	}
	
	
	
	@Override
	public Iterable<Employee>findAll(){
	return repo.findAll();
}
	
	@Override
	public void delete(int id) {
    repo.deleteById((int) id);
	}
	
	
	@Override
	public void edit(int id) {
    repo.existsById((int) id);
	}
}
