package com.donwoo.product.management.application;

import com.donwoo.product.management.domain.DateInfo;
import com.donwoo.product.management.presentation.ProductDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class SimpleProductServiceTest {

	@Autowired
	SimpleProductService simpleProductService;

	@Test
	@DisplayName("상품을 추가한 후 id로 조회하면 해당 상품이 조회되어야 합니다.")
	void productAddAndFindByIdTest() {
		ProductDto productDto;
		productDto = new ProductDto("1++B", "세종한우거세등심", 73000, "금산한우");

		ProductDto savedProductDto = simpleProductService.add(productDto);
		Long savedProductId = savedProductDto.getProduct_id();

		System.out.println(savedProductId);

		ProductDto foundProductDto = simpleProductService.findById(savedProductId);

		System.out.println(savedProductDto.getProduct_id() == foundProductDto.getProduct_id());
		System.out.println(savedProductDto.getMeat_grade() == foundProductDto.getMeat_grade());
		System.out.println(savedProductDto.getProduct_name() == foundProductDto.getProduct_name());
		System.out.println(savedProductDto.getPrice_per_kg() == foundProductDto.getPrice_per_kg());
		System.out.println(savedProductDto.getBrand_name() == foundProductDto.getBrand_name());
	}
}