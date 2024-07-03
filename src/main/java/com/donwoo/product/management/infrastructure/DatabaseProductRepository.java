package com.donwoo.product.management.infrastructure;

import com.donwoo.product.management.domain.Certificate;
import com.donwoo.product.management.domain.Facility;
import com.donwoo.product.management.domain.MeatInformation;
import com.donwoo.product.management.domain.Product;
import com.donwoo.product.management.domain.DateInfo;
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
		// Product Table
		MapSqlParameterSource productParameters = new MapSqlParameterSource();

		productParameters.addValue("meat_grade", product.getMeat_grade());
		productParameters.addValue("product_name", product.getProduct_name());
		productParameters.addValue("price_per_kg", product.getPrice_per_kg());
		productParameters.addValue("brand_name", product.getBrand_name());

		namedParameterJdbcTemplate.update(
				"INSERT INTO Product (meat_grade, product_name, price_per_kg, brand_name)" +
						"VALUES (:meat_grade, :product_name, :price_per_kg, :brand_name)",
				productParameters, keyHolder
		);

		Long generatedId = keyHolder.getKey().longValue();
		product.setProduct_id(generatedId);

		// DateInfo Table
		if (product.getDate_info() != null) {
			DateInfo dateInfo = product.getDate_info();
			MapSqlParameterSource dateInfoParameters = new MapSqlParameterSource();
			dateInfoParameters.addValue("manufacture_date", dateInfo.getManufacture_date());
			dateInfoParameters.addValue("use_by_date", dateInfo.getUse_by_date());
			dateInfoParameters.addValue("product_id", generatedId);

			namedParameterJdbcTemplate.update(
					"INSERT INTO DateInfo (manufacture_date, use_by_date, product_id)" +
							"VALUES (:manufacture_date, :use_by_date, :product_id)",
					dateInfoParameters
			);
		}

		// Certificate Table
		if (product.getCertificate() != null) {
			Certificate certificate = product.getCertificate();
			MapSqlParameterSource certificateParameters = new MapSqlParameterSource();
			certificateParameters.addValue("traceability_number", certificate.getTraceability_number());
			certificateParameters.addValue("certification", certificate.getCertification());
			certificateParameters.addValue("product_id", generatedId);

			namedParameterJdbcTemplate.update(
					"INSERT INTO Certificate (traceability_number, certification, product_id)" +
							"VALUES (:traceability_number, :certification, :product_id)",
					certificateParameters
			);
		}

		// Facility Table
		if (product.getFacility() != null) {
			Facility facility = product.getFacility();
			MapSqlParameterSource facilityParameters = new MapSqlParameterSource();
			facilityParameters.addValue("processing_factory", facility.getProcessing_factory());
			facilityParameters.addValue("slaughterhouse", facility.getSlaughterhouse());
			facilityParameters.addValue("product_id", generatedId);

			namedParameterJdbcTemplate.update(
					"INSERT INTO Facility (processing_factory, slaughterhouse, product_id)" +
							"VALUES (:processing_factory, :slaughterhouse, :product_id)",
					facilityParameters
			);
		}

		// MeatInformation Table
		if (product.getMeat_information() != null) {
			MeatInformation meatInformation = product.getMeat_information();
			MapSqlParameterSource meatInfoParameters = new MapSqlParameterSource();
			meatInfoParameters.addValue("back_fat", meatInformation.getBack_fat());
			meatInfoParameters.addValue("meat_color", meatInformation.getMeat_color());
			meatInfoParameters.addValue("maturity", meatInformation.getMaturity());
			meatInfoParameters.addValue("loin_area", meatInformation.getLoin_area());
			meatInfoParameters.addValue("fat_color", meatInformation.getFat_color());
			meatInfoParameters.addValue("age_in_months", meatInformation.getAge_in_months());
			meatInfoParameters.addValue("marbling", meatInformation.getMarbling());
			meatInfoParameters.addValue("texture", meatInformation.getTexture());
			meatInfoParameters.addValue("birth", meatInformation.getBirth());
			meatInfoParameters.addValue("product_id", generatedId);

			namedParameterJdbcTemplate.update(
					"INSERT INTO MeatInformation (back_fat, meat_color, maturity, loin_area, fat_color, age_in_months, marbling, texture, birth, product_id)" +
							"VALUES (:back_fat, :meat_color, :maturity, :loin_area, :fat_color, :age_in_months, :marbling, :texture, :birth, :product_id)",
					meatInfoParameters
			);
		}

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
