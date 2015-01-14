package edu.sjsu.courseapp.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.sjsu.courseapp.domain.User;

public class UserRowMapper implements RowMapper<User>{{

}

@Override
public User mapRow(ResultSet rs, int rowNum) throws SQLException {

	int userid;
	String name;
	String creditcard;
	String emailid;
	String phone;
	double totalbill;
	double paidbill;
	
	name = rs.getString("name");
	creditcard = rs.getString("creditcard");
	emailid = rs.getString("emailid");
	phone = rs.getString("phone");
	totalbill = rs.getDouble("totalbill");
	paidbill = rs.getDouble("paidbill");
	userid = rs.getInt("userid");
	
	User user = new User();
	
	user.setUserid(userid);
	user.setName(name);
	user.setCreditcard(creditcard);
	user.setEmailid(emailid);
	user.setPhone(phone);
	user.setTotalbill(totalbill);
	user.setPaidbill(paidbill);
	
	return user;

}
}
