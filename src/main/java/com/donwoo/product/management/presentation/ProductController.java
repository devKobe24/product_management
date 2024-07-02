package com.donwoo.product.management.presentation;

import com.donwoo.product.management.application.SimpleProductService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

	private SimpleProductService simpleProductService;

	@Autowired
	ProductController(SimpleProductService simpleProductService) {
		this.simpleProductService = simpleProductService;
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ProductDto createProduct(@Valid @RequestBody ProductDto productDto) {
		System.out.println(productDto.getBrandName());
		return simpleProductService.add(productDto);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public ProductDto findProductById(@PathVariable Long id) {
		return simpleProductService.findById(id);
	}

	// 상품 이름으로 찾기 기능
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<ProductDto> findProducts(
			@RequestParam(required = false) String productName
	) {
		if (null == productName) {
			return simpleProductService.findAll();
		}
		return simpleProductService.findByProductNameContaining(productName);
	}

	// 상품 수정 기능
	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	public ProductDto updateProduct(
			@PathVariable Long id,
			@RequestBody ProductDto productDto
	) {
		productDto.setProductId(id);
		return simpleProductService.update(productDto);
	}

	// 상품 삭제 기능
	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable Long id) {
		simpleProductService.delete(id);
	}
}
