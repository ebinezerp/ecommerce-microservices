package ecommerce.productservice;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ecommerce.productservice.model.ProductReview;

@FeignClient(name = "ecommerce-product-review-service")
@RibbonClient(name = "ecommerce-product-review-service")
public interface ProductReviewServiceProxy {
	
	@GetMapping("/product-review/{id}")
	public List<ProductReview> getProductReviews(@PathVariable("id")Long productId);
}
