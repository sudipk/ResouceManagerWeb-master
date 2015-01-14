package edu.sjsu.courseapp.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.sjsu.courseapp.domain.Cloud;

public class CloudRowMapper implements RowMapper<Cloud>{{

}

@Override
public Cloud mapRow(ResultSet rs, int rowNum) throws SQLException {

	String name;
	String publicip;
	String privateip;
	int cloudid;
	String geolocation;
	
	name = rs.getString("name");
	publicip = rs.getString("publicip");
	privateip = rs.getString("privateip");
	cloudid = rs.getInt("cloudid");
	geolocation = rs.getString("geolocation");
	
	Cloud cloud = new Cloud();
	
	cloud.setPublicip(publicip);
	cloud.setPrivateip(privateip);
	cloud.setName(name);
	cloud.setCloudid(cloudid);
	cloud.setGeolocation(geolocation);
	return cloud;

}
}
