package edu.sjsu.courseapp.dao;

import java.util.List;

import edu.sjsu.courseapp.domain.Rate;

public interface RateDAO {

	public int getRateCount();

	public Rate findRateById(int id);

	public Rate findRateByTypeComponent(String type, String component);

	public void insertRate(List<Rate> rates);
	
	public void deleteRate(int rateid);
	
	public List<Rate> getRateallList() ;

}
