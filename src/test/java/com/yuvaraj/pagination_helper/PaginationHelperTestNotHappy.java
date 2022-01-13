package com.yuvaraj.pagination_helper;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.DisplayName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PaginationHelperTestNotHappy {
	PaginationHelper<String> helper;

	/*
	* Incorrect parameterization of PaginationHelper constructor
	*/

	@Test(expected = Error.class)
	@DisplayName("PaginationHelper class instantiation Negative case#1")
	public void setUp1() {
		String[] strList = new String[10];
		List<String> list = new ArrayList<>(Arrays.asList(strList));
		helper = new PaginationHelper<>(list);
	}

	@Test(expected = Error.class)
	@DisplayName("PaginationHelper class instantiation Negative case#2")
	public void setUp2() {
		helper = new PaginationHelper<>(4);
	}

	@Test(expected = Error.class)
	@DisplayName("PaginationHelper class instantiation Negative case#3")
	public void setUp3() {
		helper = new PaginationHelper<>();
	}

	/*
	* Test to ensure what happens when size zero list is as sent as input
	*/

	@Test
	@DisplayName("PaginationHelper class instantiation size zero list input")
	public void setUp4() {
		String[] strList = new String[] {};
		List<String> list = new ArrayList<>(Arrays.asList(strList));
		this.helper = new PaginationHelper<>(list, 4);
		assertEquals(0, helper.itemCount());
		assertEquals(0, helper.pageCount());
	}
	
	/*
	* Test to see the exception when class instance is not instantiated
	*/

	@Test(expected = NullPointerException.class)
	@DisplayName("PaginationHelper class instance Not instantiated")
	public void setUp5() {
		helper.itemCount();
		helper.pageCount();
	}

	/*
	* Incorrect parameterization of pageItemCount method - type and number
	*/
	
	@Test(expected = Error.class)
	@DisplayName("PageItemCount Method Negative case")
	public void testPageItemCountNegative() {
		String[] strList = new String[] { "a", "b", "c", "d", "e", "f" };
		List<String> list = new ArrayList<>(Arrays.asList(strList));
		this.helper = new PaginationHelper<>(list, 4);
		helper.pageItemCount("a");
		helper.pageItemCount();
	}
	
	/*
	* Incorrect parameterization of pageIndex method - type and number
	*/

	@Test(expected = Error.class)
	@DisplayName("PageIndex Method Negative case")
	public void testPageIndexNegative() {
		String[] strList = new String[] { "a", "b", "c", "d", "e", "f" };
		List<String> list = new ArrayList<>(Arrays.asList(strList));
		this.helper = new PaginationHelper<>(list, 4);
		helper.pageIndex("a");
		helper.pageIndex();
	}
}
