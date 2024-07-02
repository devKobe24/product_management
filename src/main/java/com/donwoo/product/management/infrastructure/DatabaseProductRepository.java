package com.donwoo.product.management.infrastructure;

import com.donwoo.product.management.domain.Product;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class DatabaseProductRepository {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public DatabaseProductRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public Product add(Product product) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource namedParameter = new BeanPropertySqlParameterSource(product);

				namedParameterJdbcTemplate.update("INSERT INTO Product (meatGrade, productName, pricePerKg, brandName) VALUES (:meatGrade, :productName, :pricePerKg, :brandName)",
				namedParameter, keyHolder
		);
				Long generatedId = keyHolder.getKey().longValue();
				product.setProductId(generatedId);

				return product;
	}

	public Product findById(Long prodcutId) {
		SqlParameterSource namedParameter = new MapSqlParameterSource("product_id", prodcutId);

		Product product = namedParameterJdbcTemplate.queryForObject(
				"SELECT product_id, meatGrade, productName, pricePerKg, brandName FROM Product WHERE product_id=:product_id",
				namedParameter,
				new BeanPropertyRowMapper<>(Product.class)
		);
		return product;
	}

	public List<Product> findAll() {
		return Collections.EMPTY_LIST;
	}

	public List<Product> findByNameContaining(String productName) {
		return Collections.EMPTY_LIST;
	}

	public Product update(Product product) {
		return null;
	}

	public void delete(Long id) {
		// do nothing
	}
}
