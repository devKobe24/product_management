package com.donwoo.product.management.infrastructure;

import com.donwoo.product.management.domain.EntityNotFoundException;
import com.donwoo.product.management.domain.Product;
import com.donwoo.product.management.presentation.ProductDto;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
public class ListProductRepository {

	private List<Product> products = new CopyOnWriteArrayList<>();
	private AtomicLong sequence = new AtomicLong(1L);

	public Product add(Product product) {
		product.setId(sequence.getAndAdd(1L));

		products.add(product);
		return product;
	}

	// 상품 번호를 기준으로 조회 기능
	public Product findById(Long id) {
		return products.stream()
				.filter(product -> product.sameId(id))
				.findFirst()
				.orElseThrow(() -> new EntityNotFoundException("Product를 찾지 못했습니다."));
	}

	// 이름으로 찾기 기능
	public List<Product> findByNameContaining(String productName) {
		return products.stream()
				.filter(product -> product.containsProductName(productName))
				.toList();
	}

	// 전체 상품 목록 조회 기능
	public List<Product> findAll() {
		return products;
	}

	// 상품 수정
	public Product update(Product product) {
		Integer indexToModify = products.indexOf(product);
		products.set(indexToModify, product);
		return product;
	}

	// 상품 삭제
	public void delete(Long id) {
		Product product = this.findById(id);
		products.remove(product);
	}
}
