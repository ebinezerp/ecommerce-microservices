package ecommerce.productreviewservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.productreviewservice.model.ProductReview;
import ecommerce.productreviewservice.repository.ProductReviewRepository;
import ecommerce.productreviewservice.util.ProductReviewSequenceGenerator;

@Service
public class ProductReviewService {

	@Autowired
	private ProductReviewRepository productReviewRepository;

	@Autowired
	private ProductReviewSequenceGenerator productReviewSequenceGenerator;

	public ProductReview save(ProductReview productReview) {
		try {
			productReview.setId(productReviewSequenceGenerator.getId());
			return productReviewRepository.save(productReview);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public List<ProductReview> get(Long productId){
		return productReviewRepository.findByProductId(productId);
	}

}
