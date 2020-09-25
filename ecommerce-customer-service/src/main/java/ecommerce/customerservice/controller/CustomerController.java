package ecommerce.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.customerservice.model.Customer;
import ecommerce.customerservice.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		if (customerService.save(customer) != null) {
			return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{userid}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") Integer id) {
		Customer customer = customerService.get(id);
		if (customer != null) {
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		} else {
			return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return new ResponseEntity<List<Customer>>(customerService.get(), HttpStatus.OK);
	}

}
