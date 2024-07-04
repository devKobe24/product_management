package com.donwoo.product.management.application;

import static org.junit.jupiter.api.Assertions.*;

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
		ProductDto productDto = new ProductDto()
	}
}