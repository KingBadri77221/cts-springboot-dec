package com.boot.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.boot.model.Product;

public class ProductStub {
	private static Map<Long, Product> products = new HashMap<Long, Product>();
	private static Long idIndex = 3L;

	// populate initial products
	static {
		Product a = new Product(1L, "Laptop", 200.00, new Date(), "New Model");
		products.put(1L, a);
		Product b = new Product(1L, "Mobile", 300.00, new Date(), "New Model");
		products.put(2L, b);
		Product c = new Product(1L, "Other", 400.00, new Date(), "New Model");
		products.put(3L, c);
	}

	public static List<Product> list() {
		return new ArrayList<Product>(products.values());
	}

	public static Product create(Product wreck) {
		idIndex += idIndex;
		wreck.setId(idIndex);
		products.put(idIndex, wreck);
		return wreck;
	}

	public static Product get(Long id) {
		return products.get(id);
	}

	public static Product update(Long id, Product wreck) {
		products.put(id, wreck);
		return wreck;
	}

	public static Product delete(Long id) {
		return products.remove(id);
	}
}
