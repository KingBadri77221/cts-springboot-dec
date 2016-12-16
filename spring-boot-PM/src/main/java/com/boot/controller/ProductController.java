
package com.boot.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Product;
import com.boot.repository.ProductRepository;

@RestController
@RequestMapping("api/v1/")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@RequestMapping(value = "products", method = RequestMethod.GET)
	public List<Product> list(@RequestParam(required=false,defaultValue="0") int page,@RequestParam(required=false,defaultValue="10") int size) {
		Page<Product> pageResult=productRepository.findAll(new PageRequest(page, size));
		return pageResult.getContent();
	}

	@RequestMapping(value = "products", method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Product create(@RequestBody Product product) {
		return productRepository.save(product);
	}

	@RequestMapping(value = "products/{id}", method = RequestMethod.GET)
	public Product get(@PathVariable Long id) {
		Product product = productRepository.findOne(id);
		if (product != null) {
			return product;
		} else {
			throw new ProductNotFoundException();
		}
	}

	@RequestMapping(value = "products/{id}", method = RequestMethod.PUT)
	public Product update(@PathVariable Long id, @RequestBody Product product) {
		Product existingProduct = productRepository.findOne(id);
		BeanUtils.copyProperties(product, existingProduct);
		return productRepository.save(existingProduct);
	}

	@RequestMapping(value = "products/{id}", method = RequestMethod.DELETE)
	public Product delete(@PathVariable Long id) {
		Product existingProduct = productRepository.findOne(id);
		productRepository.delete(existingProduct);
		return existingProduct;
	}

	@ExceptionHandler(ProductNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	private void handler1(ProductNotFoundException e) {
		// ...
	}

}
