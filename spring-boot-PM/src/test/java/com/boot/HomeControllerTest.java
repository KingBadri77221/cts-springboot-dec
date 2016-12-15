package com.boot;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import com.boot.controller.HomeController;

/*
 * 
 *  UnitTesting ==> AAA
 *  
 *  A -> Arrange
 *  A -> Act
 *  A -> Assert
 * 
 */

public class HomeControllerTest {

	@Test
	public void testRootPath() {

		HomeController homeController = new HomeController();
		String result = homeController.home();

		// assertEquals("Nag! on training", result);
		assertThat(result, is("Nag! on training"));

	}

}
