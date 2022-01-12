package com.yuvaraj.pagination_helper;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class PaginationHelperTest {
	PaginationHelper<String> helper;

	/*
	 * this method is run before each test run
	 */
	
	@Before
	public void setUp() throws Exception {
		String[] strList = new String[] { "a", "b", "c", "d", "e", "f" };
		List<String> list = new ArrayList<>(Arrays.asList(strList));
		this.helper = new PaginationHelper<>(list, 4);
	}

	@Test
	public void testItemCount() {
		assertEquals(6, this.helper.itemCount());
	}

	@Test
	public void testPageCount() {
		assertEquals(2, this.helper.pageCount());
	}

	@Test
	public void testPageItemCount() {
		assertEquals(4, this.helper.pageItemCount(0));
		assertEquals(2, this.helper.pageItemCount(1));
		assertEquals(-1, this.helper.pageItemCount(2));
		assertEquals(-1, this.helper.pageItemCount(-2));
	}

	@Test
	public void testPageIndex() {
		assertEquals(1, this.helper.pageIndex(5));
		assertEquals(0, this.helper.pageIndex(2));
		assertEquals(-1, this.helper.pageIndex(20));
		assertEquals(-1, this.helper.pageIndex(-10));
		assertEquals(0, this.helper.pageIndex(0));
		assertEquals(1, this.helper.pageIndex(4));
	}

}
