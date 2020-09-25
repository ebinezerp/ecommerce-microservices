package ecommerce.productreviewservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.productreviewservice.model.ProductReview;
import ecommerce.productreviewservice.service.ProductReviewService;

@RestController
@RequestMapping("/product-review")
public class ProductReviewServiceController {
	
	@Autowired
	private ProductReviewService productReviewService;
	
	@GetMapping("/{productId}")
	public ResponseEntity<List<ProductReview>> getProductReview(@PathVariable("productId")Long productId){
		return new ResponseEntity<List<ProductReview>>(productReviewService.get(productId),HttpStatus.OK);
	}

}
