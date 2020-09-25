package ecommerce.productreviewservice.util;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import ecommerce.productreviewservice.model.ProductReview;
import ecommerce.productreviewservice.model.ProductReviewSequence;

@Component
public class ProductReviewSequenceGenerator {

	@Autowired
	private MongoOperations mongoOperations;

	public Long getId() {
		ProductReviewSequence counter = mongoOperations.findAndModify(
				query(where("_id").is(ProductReview.SEQUENCE_NAME)), new Update().inc("seq", 1),
				options().returnNew(true).upsert(true), ProductReviewSequence.class);
		return !Objects.isNull(counter) ? counter.getSeq() : 1;

	}

}
