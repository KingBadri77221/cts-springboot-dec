package com.boot.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.boot.model.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}
