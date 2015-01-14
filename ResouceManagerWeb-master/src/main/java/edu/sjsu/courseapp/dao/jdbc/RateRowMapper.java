package edu.sjsu.courseapp.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.sjsu.courseapp.domain.Rate;

public class RateRowMapper implements RowMapper<Rate>{{

}

@Override
public Rate mapRow(ResultSet rs, int rowNum) throws SQLException {

	int rateid;
	String type;
	String component;
	double costpermin;
	
	type = rs.getString("type");
	component = rs.getString("component");
	costpermin = rs.getDouble("costpermin");
	rateid = rs.getInt("rateid");
	
	Rate rate = new Rate();
	
	rate.setType(type);
	rate.setComponent(component);
	rate.setCostpermin(costpermin);
	rate.setRateid(rateid);
	return rate;

}
}
