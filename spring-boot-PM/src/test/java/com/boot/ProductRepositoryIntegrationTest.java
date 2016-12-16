package com.boot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.boot.model.Product;
import com.boot.repository.ProductRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { App.class })
@Transactional
public class ProductRepositoryIntegrationTest {

	@Autowired
	private ProductRepository productRepository;

	@Test
	public void findAll() {
		List<Product> products = productRepository.findAll(new PageRequest(0, 10)).getContent();
		assertThat(products.size(), is(greaterThanOrEqualTo(2)));
	}

	@Test
	public void save() {
		Product product = new Product();
		product.setName("test");
		Product savedProduct = productRepository.save(product);
		assertNotNull(savedProduct);
	}

}
