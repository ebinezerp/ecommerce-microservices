package ecommerce.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ecommerce.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, Long>{

}
