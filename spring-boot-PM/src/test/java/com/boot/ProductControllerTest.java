package com.boot;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.ExpectedExceptions;

import com.boot.controller.ProductController;
import com.boot.controller.ProductNotFoundException;
import com.boot.model.Product;
import com.boot.repository.ProductRepository;

public class ProductControllerTest {

	@InjectMocks
	private ProductController productController;

	@Mock
	private ProductRepository productRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getPositive() {

		Product product = new Product();
		product.setId(1L);
		when(productRepository.findOne(1l)).thenReturn(product);
		product = productController.get(1L);
		assertThat(1L, is(product.getId()));
		verify(productRepository).findOne(1l);

	}

	@Test(expected=ProductNotFoundException.class)
	public void getNegative() {

		Product product = new Product();
		product.setId(1L);
		when(productRepository.findOne(1l)).thenReturn(product);
		product = productController.get(10L);
		// assertThat(1L, is(product.getId()));
		verify(productRepository).findOne(1l);

	}

}
