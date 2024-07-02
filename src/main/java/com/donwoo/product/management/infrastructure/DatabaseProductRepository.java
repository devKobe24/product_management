package com.donwoo.product.management.infrastructure;

import com.donwoo.product.management.domain.Product;
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

	// 상품 추가 기능
	public Product add(Product product) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource namedParameter = new BeanPropertySqlParameterSource(product);

				namedParameterJdbcTemplate.update("INSERT INTO Product (meatGrade, productName, pricePerKg, brandName) VALUES (:meatGrade, :productName, :pricePerKg, :brandName)",
				namedParameter, keyHolder
		);
				Long generatedId = keyHolder.getKey().longValue();
				product.setProduct_id(generatedId);

				return product;
	}

	// 상품 조회 기능(product_id로)
	public Product findById(Long prodcut_id) {
		SqlParameterSource namedParameter = new MapSqlParameterSource("product_id", prodcut_id);

		Product product = namedParameterJdbcTemplate.queryForObject(
				"SELECT product_id, meatGrade, productName, pricePerKg, brandName FROM Product WHERE product_id=:product_id",
				namedParameter,
				new BeanPropertyRowMapper<>(Product.class)
		);
		return product;
	}

	// 상품 전체 조회 기능
	public List<Product> findAll() {
		List<Product> products = namedParameterJdbcTemplate.query(
				"SELECT * FROM Product",
				new BeanPropertyRowMapper<>(Product.class)
		);
		return products;
	}

	// 상품 이름으로 조회 기능
	public List<Product> findByNameContaining(String productName) {
		SqlParameterSource namedParameter = new MapSqlParameterSource("productName", "%" + "productName" + "%");

		List<Product> products = namedParameterJdbcTemplate.query(
				"SELECT * FROM Product WHERE productName LIKE :productName",
				namedParameter,
				new BeanPropertyRowMapper<>(Product.class)
		);
		return products;
	}

	// 상품 수정 기능
	public Product update(Product product) {
		SqlParameterSource namedParameter = new BeanPropertySqlParameterSource(product);

		namedParameterJdbcTemplate.update("UPDATE Product SET meatGrade=:meatGrade, productName=:productName, pricePerKg=:pricePerKg, brandName=:brandName WHERE product_id=:product_id", namedParameter);

		return product;
	}

	// 상품 삭제 기능
	public void delete(Long product_id) {
		SqlParameterSource namedParameter = new MapSqlParameterSource("product_id", product_id);

		namedParameterJdbcTemplate.update(
				"DELETE FROM Product WHERE product_id=:product_id",
				namedParameter
		);
	}
}
