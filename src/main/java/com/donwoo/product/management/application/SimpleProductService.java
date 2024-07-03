package com.donwoo.product.management.application;

import com.donwoo.product.management.domain.Product;
import com.donwoo.product.management.domain.ProductRepository;
import com.donwoo.product.management.infrastructure.DatabaseProductRepository;
import com.donwoo.product.management.presentation.ProductDto;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleProductService {

	private ProductRepository productRepository;
//	private DatabaseProductRepository databaseProductRepository;
	private ModelMapper modelMapper;
	private ValidationService validationService;

	@Autowired
	SimpleProductService(ProductRepository productRepository, ModelMapper modelMapper, ValidationService validationService) {
		this.productRepository = productRepository;
		this.modelMapper = modelMapper;
		this.validationService = validationService;
	}

	public ProductDto addToProduct(ProductDto productDto) {
		// ProductDto를 Product로 변환
		Product product = modelMapper.map(productDto, Product.class);
		validationService.checkValid(product);
		// Repository Call
		Product savedProduct = productRepository.add(product);
		// Product를 ProductDTO로 변환
		ProductDto savedProductDto = modelMapper.map(savedProduct, ProductDto.class);
		// return DTO
		return savedProductDto;
	}

	public ProductDto findById(Long productId) {
		Product product = productRepository.findById(productId);
		ProductDto productDto = modelMapper.map(product, ProductDto.class);
		return productDto;
	}

	public List<ProductDto> findAll() {
		List<Product> products = productRepository.findAll();
		List<ProductDto> productDtos = products.stream()
				.map(product -> modelMapper.map(product, ProductDto.class))
				.toList();
		return productDtos;
	}

	// 상품 이름으로 찾기 기능
	public List<ProductDto> findByProductNameContaining(String productName) {
		List<Product> products = productRepository.findByNameContaining(productName);
		List<ProductDto> productDtos = products.stream()
				.map(product -> modelMapper.map(product, ProductDto.class))
				.toList();
		return productDtos;
	}

	public ProductDto update(ProductDto productDto) {
		Product product = modelMapper.map(productDto, Product.class);
		Product updateProduct = productRepository.update(product);
		ProductDto updatedProductDto = modelMapper.map(updateProduct, ProductDto.class);
		return updatedProductDto;
	}

	// 상품 삭제
	public void delete(Long productId) {
		productRepository.delete(productId);
	}
}
