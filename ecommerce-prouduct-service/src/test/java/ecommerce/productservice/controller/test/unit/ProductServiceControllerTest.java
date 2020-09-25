package ecommerce.productservice.controller.test.unit;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import ecommerce.productservice.ProductReviewServiceProxy;
import ecommerce.productservice.controller.ProductServiceController;
import ecommerce.productservice.model.Product;
import ecommerce.productservice.service.ProductService;

@WebMvcTest(controllers = ProductServiceController.class)
public class ProductServiceControllerTest {

	@InjectMocks
	private ProductServiceController productServiceController;

	@MockBean
	private ProductService productService;

	@MockBean
	private ProductReviewServiceProxy proxy;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void test() throws Exception {

		Map<String, List<String>> specifications = new HashMap<String, List<String>>();
		specifications.put("camera", Arrays.asList("Front Camera - 8MP", "Rare Camera - 16MP"));
		Product product1 = new Product("Samsung", "J7", 15000D, specifications);
		Product product2 = new Product("Nokia", "S5", 20000D, specifications);
		List<Product> products = Arrays.asList(product1, product2);

		when(productService.get()).thenReturn(products);

		mockMvc.perform(get("/product-service").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

		System.out.println(new JSONArray(products).toString());
		ResultMatcher matcher = content().json(new JSONArray(products).toString());

	}

}
