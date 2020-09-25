package ecommerce.customerservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.customerservice.model.Customer;
import ecommerce.customerservice.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer save(Customer customer) {
		return Optional.ofNullable(customerRepository.save(customer)).orElse(null);
	}

	public Customer get(Integer id) {
		return customerRepository.findById(id).orElse(null);
	}
	
	public List<Customer> get(){
		return customerRepository.findAll();
	}

}
