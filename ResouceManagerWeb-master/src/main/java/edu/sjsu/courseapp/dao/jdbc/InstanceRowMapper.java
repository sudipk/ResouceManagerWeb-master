package edu.sjsu.courseapp.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.sjsu.courseapp.domain.Instance;

public class InstanceRowMapper implements RowMapper<Instance>{{

}

@Override
public Instance mapRow(ResultSet rs, int rowNum) throws SQLException {

	int instanceid;
	int cloudid;
	String name;
	String status;
	String type;
	String os;
	String cpu;
	String memory;
	String storage;
	String publicip;
	String privateip;
	long uptime;
	int userid;

	cloudid = rs.getInt("cloudid");
	instanceid = rs.getInt("instanceid");
	name = rs.getString("name");
	status = rs.getString("status");
	type = rs.getString("type");
	os = rs.getString("os");
	cpu = rs.getString("cpu");
	memory = rs.getString("memory");
	storage = rs.getString("storage");
	publicip = rs.getString("publicip");
	privateip = rs.getString("privateip");
	uptime = rs.getLong("uptime");
	userid = rs.getInt("userid");
	
	Instance instance = new Instance();
	
	instance.setInstanceid(instanceid);
	instance.setName(name);
	instance.setCloudid(cloudid);
	instance.setStatus(status);
	instance.setType(type);
	instance.setOs(os);
	instance.setCpu(cpu);
	instance.setMemory(memory);
	instance.setStorage(storage);
	instance.setPublicip(publicip);
	instance.setPrivateip(privateip);
	instance.setUptime(uptime);
	instance.setUserid(userid);

	return instance;

	}
}
