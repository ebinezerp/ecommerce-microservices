package ecommerce.productservice.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {

	@Transient
	public static final String SEQUENCE_NAME = "product_sequence";

	@Id
	private Long id;
	private String brand;
	private String model;
	private Double price;
	private Map<String, List<String>> specifications;
	private List<ProductReview> reviews;

	public Product() {
		super();
	}

	public Product(Long id, String brand, String model, Double price, Map<String, List<String>> specifications) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.specifications = specifications;
	}

	public Product(String brand, String model, Double price, Map<String, List<String>> specifications) {
		super();
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.specifications = specifications;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Map<String, List<String>> getSpecifications() {
		return specifications;
	}

	public void setSpecifications(Map<String, List<String>> specifications) {
		this.specifications = specifications;
	}

	public List<ProductReview> getReviews() {
		return reviews;
	}

	public void setReviews(List<ProductReview> reviews) {
		this.reviews = reviews;
	}

}
