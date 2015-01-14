package edu.sjsu.courseapp.domain;



import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author Sudip
 * 
 */
@XmlRootElement(name = "user")
@XmlType(propOrder = { "userid", "name", "creditcard","emailid" , "phone" , "totalbill" , "paidbill"})
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3723910394542506470L;
	private int userid;
	private String name;
	private String creditcard;
	private String emailid;
	private String phone;
	private double totalbill;
	private double paidbill;

	public User(){
		//default constructor
	}
	
	public User(int userid , String name, String creditcard, String emailid, String phone , double totalbill, double paidbill) {
		this.userid = userid;
		this.name = name;
		this.creditcard = creditcard;
		this.emailid=emailid;
		this.phone=phone;
		this.totalbill=totalbill;
		this.paidbill=paidbill;
	}

	public int getUserid() {
		return userid;
	}

	public String getName() {
		return name;
	}

	
	public String getCreditcard() {
		return creditcard;
	}

	public String getEmailid() {
		return emailid;
	}

	public String getPhone() {
		return phone;
	}

	public double getTotalbill() {
		return totalbill;
	}

	public double getPaidbill() {
		return paidbill;
	}

	@XmlElement(name = "userid")
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	@XmlElement(name = "name")
	public void setName(String name) {
		this.name = name;
	}
	

/*	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (sku ^ (sku >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (sku != other.sku)
			return false;
		return true;
	}*/
	
	@XmlElement(name = "creditcard")
	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}

	@XmlElement(name = "emailid")
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	@XmlElement(name = "phone")
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@XmlElement(name = "totalbill")
	public void setTotalbill(double totalbill) {
		this.totalbill = totalbill;
	}

	@XmlElement(name = "paidbill")
	public void setPaidbill(double paidbill) {
		this.paidbill = paidbill;
	}

	public void printCloud(){
		System.out.println("Name:"+name);
		System.out.println("userid:"+userid);
		System.out.println("creditcard"+creditcard);
		System.out.println("emailid"+emailid);
		System.out.println("phone"+phone);
		System.out.println("totalbill"+totalbill);
		System.out.println("paidbill"+paidbill);
		System.out.println(" ===========================================================");
	}
}
