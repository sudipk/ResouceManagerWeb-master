package edu.sjsu.courseapp.dao;

import java.util.List;

public interface ProductsListDao {

	public List getProductListAll(int sku);
	
	public boolean insertProductList(List all);
}
