package com.list.springboot.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.list.springboot.model.Item;
import com.list.springboot.services.TodoService;

@RestController
public class TodoRestController {
	@Autowired
	private TodoService service;
	 
	//@RequestMapping(path = "/getitemlist", method=RequestMethod.GET)
	@GetMapping("/getitemlist")
	public List<Item> fetchItemList(){
		List<Item> itens = new ArrayList<Item>();
		//logic to fetch list from database
		itens = service.fetchItemList();
		return itens;
	}
	
	@PostMapping("/additem")
	public Item saveItem(@RequestBody Item item){
		return service.saveItemToDB(item);
		
	}
	/* remover*/
	@GetMapping("/getitembyid/{id}")
	public Item fetchItemById(@PathVariable int id){
		return service.fetchItemById(id).get();
		
	}
	@DeleteMapping("/deleteitembyid/{id}")
	public String DeleteItemById(@PathVariable int id){
		return service.deleteItemById(id);
		
		
	}
	
}
