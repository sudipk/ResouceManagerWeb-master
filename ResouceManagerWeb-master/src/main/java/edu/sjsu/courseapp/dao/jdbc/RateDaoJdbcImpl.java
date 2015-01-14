package edu.sjsu.courseapp.dao.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import edu.sjsu.courseapp.dao.RateDAO;
import edu.sjsu.courseapp.domain.Rate;

@Repository("RateDaoJdbcImpl")
public class RateDaoJdbcImpl implements RateDAO {
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedTemplate;
	private SimpleJdbcInsert jdbcInsert;
	
	private RateRowMapper rateRowMapper;


	@PostConstruct
	public void setup() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		namedTemplate = new NamedParameterJdbcTemplate(dataSource);
		jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("rate")
				    .usingColumns("rateid", "type","component","costpermin");
		 rateRowMapper = new RateRowMapper();

	}

	@Override
	public int getRateCount() {
		String sql = "select count(*) from rate";
		return jdbcTemplate.queryForInt(sql);
	}

	public void insertRate(List<Rate> listrate) {
		for (Rate rate : listrate) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("type", rate.getType());
			map.put("component", rate.getComponent());
			map.put("costpermin",rate.getCostpermin());
			int newId = jdbcInsert.execute(map);
			rate.setRateid(newId);
		}
	}
	

	@Override
	public Rate findRateById(int id) {
		String sql = "select * from rate where rateid=?";
		return jdbcTemplate.queryForObject(sql, rateRowMapper, id);
	}

	
	@Override
	public Rate findRateByTypeComponent(String type, String component) {
		int ratesFound;
		String sql = "select * from rate where type=:type and component=:component";
		MapSqlParameterSource params;
		params = new MapSqlParameterSource("type", type);
		params.addValue("component", component);
		List<Rate> rateList = namedTemplate.query(sql, params, rateRowMapper);

		ratesFound = rateList.size();
		if (ratesFound == 1) {

			return rateList.get(0);

		} else if (ratesFound == 0) {

			return null;

		}
		return (Rate) rateList;
		// throw new
		// ProductDaoException("Multiple Rates Found with Same Name");
	}


	@Override
	public void deleteRate(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Rate> getRateallList() {
		String sql = "select * from rate";
		List<Rate> rateList = jdbcTemplate.query(sql, rateRowMapper);
		return rateList;
	}

	
	
	
//	public int updateTotalOrders(Product prod, int change) {
//		String sql = "update product set totalOrders=:newTotalOrders where id=:id";
//		int curTotalOrders, newTotalOrders;
//		String prodName;
//		MapSqlParameterSource params;
//		int rowsAffected;
//		double prodId = prod.getSku();
//
//		prodName = prod.getName();
//		curTotalOrders = findTotalOrdersByName(prodName);
//		newTotalOrders = curTotalOrders + change;
//
//		params = new MapSqlParameterSource("id", prodId);
//		params.addValue("newTotalOrders", newTotalOrders);
//		rowsAffected = namedTemplate.update(sql, params);
//		return rowsAffected;
//	}
	
//	public int findTotalOrdersByName(String prodName) {
//		String sql = "select totalOrders from Product where name=?";
//		return jdbcTemplate.queryForInt(sql, prodName);
//	}
//
//	public List<String> findProdsWithLessThanTotalOrder(int orderCnt) {
//		String sql = "select name from Product where totalOrders<?";
//		return jdbcTemplate.queryForList(sql, String.class, orderCnt);
//	}


	
}
