package ecommerce.productservice.util;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import ecommerce.productservice.model.Product;
import ecommerce.productservice.model.ProductSequence;

@Service
public class ProductSequenceGenerator {

	@Autowired
	private MongoOperations mongoOperations;

	public Long getProductId() {
		ProductSequence counter = mongoOperations.findAndModify(query(where("_id").is(Product.SEQUENCE_NAME)),
				new Update().inc("nextSeq", 1), options().returnNew(true).upsert(true), ProductSequence.class);
		return !Objects.isNull(counter) ? counter.getNextSeq() : 1;
	}

}
