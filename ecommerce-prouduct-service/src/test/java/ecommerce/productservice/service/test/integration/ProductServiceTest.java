package ecommerce.productservice.service.test.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import ecommerce.productservice.EcommerceProuductServiceApplication;
import ecommerce.productservice.model.Product;
import ecommerce.productservice.repository.ProductRepository;
import ecommerce.productservice.service.ProductService;

@SpringJUnitConfig(classes = EcommerceProuductServiceApplication.class)
class ProductServiceTest {

	@InjectMocks
	private ProductService productService;

	@Mock
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
		Mockito.when(productRepository.findById(101L)).thenReturn(Optional.of(product));
		Product fetchProduct = productService.get(101L);
		System.out.println(fetchProduct);
		assertNotNull(fetchProduct);
		assertEquals(fetchProduct.getModel(), product.getModel());
	}

	@Test
	public void testSave() {
		Mockito.when(productRepository.save(null)).thenReturn(Optional.ofNullable(null));
		assertNull(productService.save(null));
	}

}
