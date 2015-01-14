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

import edu.sjsu.courseapp.dao.InstanceDAO;
import edu.sjsu.courseapp.domain.Instance;

@Repository("InstanceDaoJdbcImpl")
public class InstanceDaoJdbcImpl implements InstanceDAO {
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedTemplate;
	private SimpleJdbcInsert jdbcInsert;

	private InstanceRowMapper instanceRowMapper;

	@PostConstruct
	public void setup() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		namedTemplate = new NamedParameterJdbcTemplate(dataSource);
		jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("instance")
				.usingColumns("instanceid", "cloudid", "name", "status",
						"type", "os", "cpu", "memory", "storage", "publicip",
						"privateip", "uptime", "userid");
		instanceRowMapper = new InstanceRowMapper();

	}

	@Override
	public int getInstanceCount() {
		String sql = "select count(*) from instance";
		return jdbcTemplate.queryForInt(sql);
	}

	public void insertInstance(List<Instance> listinstance) {
		for (Instance instance : listinstance) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", instance.getName());
			map.put("cloudid", instance.getCloudid());
			map.put("status", instance.getStatus());
			map.put("type", instance.getType());
			map.put("os", instance.getOs());
			map.put("cpu", instance.getCpu());
			map.put("memory", instance.getMemory());
			map.put("storage", instance.getStorage());
			map.put("publicip", instance.getPublicip());
			map.put("privateip", instance.getPrivateip());
			map.put("uptime", instance.getUptime());
			map.put("userid", instance.getUserid());
			int newId = jdbcInsert.execute(map);
			instance.setInstanceid(newId);
		}
	}

	@Override
	public String findInstanceNameById(int id) {
		String sql = "select name from instance where instanceid=?";
		return jdbcTemplate.queryForObject(sql, String.class, id);
	}

	@Override
	public Instance findInstanceByName(String instanceName) {
		int instancesFound;
		String sql = "select * from instance where name=?";
		List<Instance> instanceList = jdbcTemplate.query(sql,
				instanceRowMapper, instanceName);

		instancesFound = instanceList.size();
		if (instancesFound == 1) {

			return instanceList.get(0);

		} else if (instancesFound == 0) {

			return null;

		}
		return (Instance) instanceList;
		// throw new
		// ProductDaoException("Multiple Clouds Found with Same Name");
	}

	@Override
	public void deleteInstance(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Instance> getInstanceallList() {
		String sql = "select * from instance";
		List<Instance> instanceList = jdbcTemplate
				.query(sql, instanceRowMapper);
		return instanceList;
	}

	public int updateInstance(Instance instance, int userid) {
		String sql = "update instance set userid=:userid where instanceid=:id";
		int id;
		MapSqlParameterSource params;
		int rowsAffected;

		id = instance.getInstanceid();

		params = new MapSqlParameterSource("id", id);
		params.addValue("userid", userid);
		rowsAffected = namedTemplate.update(sql, params);
		return rowsAffected;
	}

	// public int updateTotalOrders(Product prod, int change) {
	// String sql =
	// "update product set totalOrders=:newTotalOrders where id=:id";
	// int curTotalOrders, newTotalOrders;
	// String prodName;
	// MapSqlParameterSource params;
	// int rowsAffected;
	// double prodId = prod.getSku();
	//
	// prodName = prod.getName();
	// curTotalOrders = findTotalOrdersByName(prodName);
	// newTotalOrders = curTotalOrders + change;
	//
	// params = new MapSqlParameterSource("id", prodId);
	// params.addValue("newTotalOrders", newTotalOrders);
	// rowsAffected = namedTemplate.update(sql, params);
	// return rowsAffected;
	// }

	// public int findTotalOrdersByName(String prodName) {
	// String sql = "select totalOrders from Product where name=?";
	// return jdbcTemplate.queryForInt(sql, prodName);
	// }
	//
	// public List<String> findProdsWithLessThanTotalOrder(int orderCnt) {
	// String sql = "select name from Product where totalOrders<?";
	// return jdbcTemplate.queryForList(sql, String.class, orderCnt);
	// }

}
