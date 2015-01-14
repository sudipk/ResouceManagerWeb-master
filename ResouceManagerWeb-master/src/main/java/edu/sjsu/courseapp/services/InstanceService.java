package edu.sjsu.courseapp.services;

import java.util.List;

import edu.sjsu.courseapp.domain.Instance;


public interface InstanceService {
	public List<Instance> getInstanceList();
	public void deleteInstance(Integer id);
	public String getInstancebyId(int id);
	public List<Instance> getInstanceByName(String name);
	void insertInstance(List<Instance> instance);
}
