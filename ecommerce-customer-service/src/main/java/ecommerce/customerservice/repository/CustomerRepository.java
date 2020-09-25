package ecommerce.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.customerservice.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
