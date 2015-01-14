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
@XmlRootElement(name = "cloud")
@XmlType(propOrder = { "cloudid", "name", "publicip","privateip" , "geolocation"})
public class Cloud implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3723910394542506470L;
	private int cloudid;
	private String name;
	private String publicip;
	private String privateip;
	private String geolocation;

	public Cloud(){
		//default constructor
	}
	
	public Cloud(int cloudid , String name, String publicip, String privateip, String geolocation) {
		this.cloudid = cloudid;
		this.name = name;
		this.publicip = publicip;
		this.privateip=privateip;
		this.geolocation=geolocation;
	}

	public int getCloudid() {
		return cloudid;
	}

	public String getName() {
		return name;
	}

	
	public String getPublicip() {
		return publicip;
	}

	public String getPrivateip() {
		return privateip;
	}
	
	public String getGeolocation() {
		return geolocation;
	}
	
	@XmlElement(name = "cloudid")
	public void setCloudid(int cloudid) {
		this.cloudid = cloudid;
	}
	
	@XmlElement(name = "name")
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement(name = "publicip")
	public void setPublicip(String publicip) {
		this.publicip = publicip;
	}


	@XmlElement(name = "privateip")
	public void setPrivateip(String privateip) {
		this.privateip = privateip;
	}

	
	@XmlElement(name = "geolocation")
	public void setGeolocation(String geolocation) {
		this.geolocation = geolocation;
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
	
	public void printCloud(){
		System.out.println("Name:"+name);
		System.out.println("cloudid:"+cloudid);
		System.out.println("publicip"+publicip);
		System.out.println("privateip"+privateip);
		System.out.println("geolocation"+geolocation);
		System.out.println(" ===========================================================");
	}
}
