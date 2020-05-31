	package com.diluna.controller;

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.diluna.entity.Customer;
import com.diluna.service.CustomerService;



	@Controller
	@RequestMapping("/customer")
	public class CustomerController {

		// need to inject our customer service
		@Autowired
		private CustomerService customerService;
		
		@RequestMapping("/list")
		public String listCustomers(Model theModel) {
			
			// get customers from the service
			List<Customer> theCustomers = customerService.getCustomers();
					
			// add the customers to the model
			theModel.addAttribute("customerRef1", theCustomers);
			
			return "list-customer";
		}
		
		@RequestMapping("/add")
		public String showFormForAdd(Model theModel) {
			
			// create model attribute to bind form data
			Customer theCustomers = new Customer();
			
			theModel.addAttribute("customerRef2", theCustomers);
			
			return "form-customer";
		}
		
		@PostMapping("/save")
		public String saveCustomer(@ModelAttribute("customerRef2") Customer thecustomer) {
			
			//save customer using service class
			customerService.saveCustomer(thecustomer);
			
			return "redirect:/customer/list";
		}
		
		@RequestMapping("/update")
		public String customerUpdate(@RequestParam("customerId") int theId, Model theModel) {
			//get the customer from the service
			Customer theCustomer=customerService.getCustomers(theId);
			//set the as model attribute to pre-populate form
			theModel.addAttribute("customerRef2",theCustomer);
			//send over to form
			
			return "form-customer";
		}
		
		@RequestMapping("/delete")
		public String customerDelete(@RequestParam("customerId") int theId) {
			//get the customer from service
			customerService.deleteCustomer(theId);
			
			return "redirect:/customer/list";
			
		}
	
}
