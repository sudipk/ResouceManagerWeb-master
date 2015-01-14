package edu.sjsu.courseapp.dao;

import java.util.List;

import edu.sjsu.courseapp.domain.Cloud;
import edu.sjsu.courseapp.domain.Product;
import edu.sjsu.courseapp.domain.ProductEbay;

public interface CloudDAO {

	public int getCloudCount();
	//public List getProductList(int suk);

	//int findTotalOrdersByName(String prodName);

	public String findCloudNameById(int id);

	public Cloud findCloudByName(String cloudName);

	public void insertCloud(List<Cloud> cloud);
	
	public void deleteCloud(int cloudid);
	
	public List<Cloud> getCloudallList() ;

}
