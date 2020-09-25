package ecommerce.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.productservice.model.Product;
import ecommerce.productservice.repository.ProductRepository;
import ecommerce.productservice.util.ProductSequenceGenerator;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductSequenceGenerator productSequenceGenerator;

	public Product save(Product product) {
		try {
			product.setId(productSequenceGenerator.getProductId());
			return productRepository.save(product);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Product> get() {
		return productRepository.findAll();
	}

	public Product get(Long id) {
		return productRepository.findById(id).orElse(null);
	}

}
