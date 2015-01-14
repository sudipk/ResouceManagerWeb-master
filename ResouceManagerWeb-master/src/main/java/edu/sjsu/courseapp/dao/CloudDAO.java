package edu.sjsu.courseapp.dao;

import java.util.List;

import edu.sjsu.courseapp.domain.Cloud;

public interface CloudDAO {

	public int getCloudCount();

	public String findCloudNameById(int id);

	public Cloud findCloudByName(String cloudName);

	public void insertCloud(List<Cloud> cloud);
	
	public void deleteCloud(int cloudid);
	
	public List<Cloud> getCloudallList() ;

}
