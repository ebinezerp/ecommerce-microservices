package ecommerce.productservice.controller;

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

import ecommerce.productservice.ProductReviewServiceProxy;
import ecommerce.productservice.model.Product;
import ecommerce.productservice.model.ProductReview;
import ecommerce.productservice.service.ProductService;

@RestController
@RequestMapping("/product-service")
public class ProductServiceController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductReviewServiceProxy proxy;

	@GetMapping
	public ResponseEntity<List<Product>> getProducts() {
		return new ResponseEntity<List<Product>>(productService.get(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id")Long id){
		Product product = productService.get(id);
		List<ProductReview> productReviews = proxy.getProductReviews(id);
		product.setReviews(productReviews);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		return new ResponseEntity<Product>(productService.save(product),HttpStatus.CREATED);
	}

}
