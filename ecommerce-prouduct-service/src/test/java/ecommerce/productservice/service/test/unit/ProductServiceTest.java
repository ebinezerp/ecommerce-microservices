package ecommerce.productservice.service.test.unit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ecommerce.productservice.model.Product;
import ecommerce.productservice.repository.ProductRepository;
import ecommerce.productservice.service.ProductService;

@SpringBootTest
class ProductServiceTest {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRepository productRepository;

	@BeforeEach
	public void setup() {
		productRepository.deleteAll();
	}

	@Test
	public void test() {
		Map<String, List<String>> specifications = new HashMap<String, List<String>>();
		specifications.put("camera", Arrays.asList("Front Camera - 8MP", "Rare Camera - 16MP"));
		Product product = new Product("Samsung", "J7", 15000D, specifications);
		productService.save(product);
		assertNotNull(productRepository.findById(product.getId()));
	}

}
