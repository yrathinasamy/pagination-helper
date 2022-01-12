package com.yuvaraj.pagination_helper;

import java.util.List;

public class PaginationHelper<I> {
	private int itemCount;
	private int itemsPerPage;
	private int pageCount;

	/**
	 * This constructor takes in a collections of items and an integer denoting the
	 * number of items limited per page
	 */

	public PaginationHelper(List<I> list, int itemsperPage) {
		this.itemCount = list.size();
		this.itemsPerPage = itemsperPage;
		this.pageCount = (this.itemCount % this.itemsPerPage) == 0 ? this.itemCount / this.itemsPerPage
				: (this.itemCount / this.itemsPerPage) + 1;
	}

	/*
	 * this method returns the total number of items in the collection
	 */

	public int itemCount() {
		return this.itemCount;
	}

	/*
	 * this method returns the total number of pages
	 */

	public int pageCount() {
		return this.pageCount;
	}

	/*
	 * this method returns the number of items on the current page. this takes
	 * pageIndex as input. pageIndex is zero based. this method should return -1 for
	 * pageIndex values that are out of range
	 */

	public int pageItemCount(int pageIndex) {
		if (pageIndex < 0 || pageIndex >= this.pageCount)
			return -1;
		else if (pageIndex == this.pageCount - 1)
			return this.itemCount % this.itemsPerPage;
		else
			return this.itemsPerPage;
	}

	/**
	 * this method determines what page an item is situated on. this takes itemIndex
	 * as input. itemIndex is zero based. this method should return -1 for itemIndex
	 * values that are out of range
	 */

	public int pageIndex(int itemIndex) {
		if (itemIndex < 0 || itemIndex >= this.itemCount)
			return -1;
		else
			return itemIndex / this.itemsPerPage;
	}

}
