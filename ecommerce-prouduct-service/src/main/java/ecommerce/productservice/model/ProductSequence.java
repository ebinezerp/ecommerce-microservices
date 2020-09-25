package ecommerce.productservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product_sequence")
public class ProductSequence {

	@Id
	private String id;
	private Long nextSeq;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getNextSeq() {
		return nextSeq;
	}

	public void setNextSeq(Long nextSeq) {
		this.nextSeq = nextSeq;
	}

}
