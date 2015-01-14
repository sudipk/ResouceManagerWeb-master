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

import edu.sjsu.courseapp.dao.CloudDAO;
import edu.sjsu.courseapp.domain.Cloud;

@Repository("CloudDaoJdbcImpl")
public class CloudDaoJdbcImpl implements CloudDAO {
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedTemplate;
	private SimpleJdbcInsert jdbcInsert;
	
	private CloudRowMapper cloudRowMapper;


	@PostConstruct
	public void setup() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		namedTemplate = new NamedParameterJdbcTemplate(dataSource);
		jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("cloud")
				    .usingColumns("cloudid", "name","publicip","privateip", "geolocation");
		 cloudRowMapper = new CloudRowMapper();

	}

	@Override
	public int getCloudCount() {
		String sql = "select count(*) from Cloud";
		return jdbcTemplate.queryForInt(sql);
	}

	public void insertCloud(List<Cloud> cloud1) {
		for (Cloud cloud : cloud1) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", cloud.getName());
			map.put("publicip", cloud.getPublicip());
			map.put("cloudid",cloud.getCloudid());
			map.put("privateip",cloud.getPrivateip());
			map.put("geolocation",cloud.getGeolocation());
			int newId = jdbcInsert.execute(map);
			cloud.setCloudid(newId);
		}
	}
	

	@Override
	public String findCloudNameById(int id) {
		String sql = "select name from cloud where cloudid=?";
		return jdbcTemplate.queryForObject(sql, String.class, id);
	}

	@Override
	public Cloud findCloudByName(String cloudName) {
		int cloudsFound;
		String sql = "select * from cloud where name=?";
		List<Cloud> cloudList = jdbcTemplate.query(sql, cloudRowMapper,
				cloudName);

		cloudsFound = cloudList.size();
		if (cloudsFound == 1) {

			return cloudList.get(0);

		} else if (cloudsFound == 0) {

			return null;

		}
		return (Cloud) cloudList;
		// throw new
		// ProductDaoException("Multiple Clouds Found with Same Name");
	}


	@Override
	public void deleteCloud(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Cloud> getCloudallList() {
		String sql = "select * from cloud";
		List<Cloud> cloudList = jdbcTemplate.query(sql, cloudRowMapper);
		return cloudList;
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
