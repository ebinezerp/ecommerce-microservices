package ecommerce.productreviewservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ProductReview {

	public static final String SEQUENCE_NAME = "product_review_sequence";

	@Id
	private Long id;
	private Long productId;
	private Long customerId;
	private String review;

	public ProductReview() {
		super();
	}

	public ProductReview(Long id, Long productId, Long customerId, String review) {
		super();
		this.id = id;
		this.productId = productId;
		this.customerId = customerId;
		this.review = review;
	}

	public ProductReview(Long productId, Long customerId, String review) {
		super();
		this.productId = productId;
		this.customerId = customerId;
		this.review = review;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

}
