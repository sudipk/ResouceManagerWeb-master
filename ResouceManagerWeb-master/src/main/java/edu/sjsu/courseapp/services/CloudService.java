package edu.sjsu.courseapp.services;

import java.util.List;

import edu.sjsu.courseapp.domain.Cloud;


public interface CloudService {
	public List<Cloud> getCloudList();
	public void deleteCloud(Integer id);
	public String getCloudbyId(int id);
	public List<Cloud> getCloudByName(String name);
	void insertCloud(List<Cloud> cloud);
}
