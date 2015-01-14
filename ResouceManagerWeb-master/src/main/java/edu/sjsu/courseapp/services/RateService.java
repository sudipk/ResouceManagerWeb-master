package edu.sjsu.courseapp.services;

import java.util.List;

import edu.sjsu.courseapp.domain.Rate;


public interface RateService {
	public List<Rate> getRateList();
	public void deleteRate(Integer id);
	public Rate getRatebyId(int id);
	public Rate getRateByTypeComponent(String type, String component);
	void insertRate(List<Rate> rate);
}
