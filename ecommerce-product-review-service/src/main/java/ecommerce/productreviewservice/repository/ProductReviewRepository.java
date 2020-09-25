package ecommerce.productreviewservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ecommerce.productreviewservice.model.ProductReview;

public interface ProductReviewRepository extends MongoRepository<ProductReview, Long> {
	public List<ProductReview> findByProductId(Long id);
}
