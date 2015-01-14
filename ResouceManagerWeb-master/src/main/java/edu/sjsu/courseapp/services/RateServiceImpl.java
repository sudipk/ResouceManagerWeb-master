package edu.sjsu.courseapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.sjsu.courseapp.dao.RateDAO;
import edu.sjsu.courseapp.dao.jdbc.RateDaoJdbcImpl;
import edu.sjsu.courseapp.domain.Rate;


@Transactional(rollbackFor={java.io.IOException.class},noRollbackFor = ArithmeticException.class)
@Service
public class RateServiceImpl implements RateService {
	@Qualifier("RateDaoJdbcImpl")
	@Autowired
	private RateDAO  rateDao=new RateDaoJdbcImpl();

	@Override
	public void deleteRate(Integer id) {
		// TODO Auto-generated method stub
		rateDao.deleteRate(id);
	}


	@Override
	public List<Rate> getRateList() {
		List<Rate> rates = rateDao.getRateallList();
		return rates;
	}

	@Override
	public void insertRate(List<Rate> rate) {
		 rateDao.insertRate(rate);
	}


	@Override
	public Rate getRatebyId(int id) {
		return rateDao.findRateById(id);
	}


	@Override
	public Rate getRateByTypeComponent(String type, String component) {
		return rateDao.findRateByTypeComponent(type, component);
	}

}
