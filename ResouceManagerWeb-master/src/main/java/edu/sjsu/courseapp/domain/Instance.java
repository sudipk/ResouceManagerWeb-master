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
@XmlRootElement(name = "instance")
@XmlType(propOrder = { "instanceid", "cloudid", "name", "status", "type" , "os", "cpu" , "memory" , "storage" , "publicip", "privateip" , "uptime" , "userid" })

public class Instance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3723910394542506470L;
	private int instanceid;
	private int cloudid;
	private String name;
	private String status;
	private String type;
	private String os;
	private String cpu;
	private String memory;
	private String storage;
	private String publicip;
	private String privateip;
	private long uptime;
	private int userid;

	public Instance(){
		//default constructor
	}
	
	public Instance(int cloudid , int instanceid, String name, String status, String type, String os, 
			String cpu, String memory, String storage, String publicip, String privateip, long uptime , int userid) {
		this.instanceid = instanceid;
		this.cloudid = cloudid;
		this.name = name;
		this.status = status;
		this.type = type;
		this.os = os;
		this.cpu = cpu;
		this.memory = memory;
		this.storage = storage;
		this.publicip = publicip;
		this.privateip=privateip;
		this.uptime=uptime;
		this.userid=userid;
	}

	public int getInstanceid() {
		return instanceid;
	}
	
	public String getName() {
		return name;
	}

	public int getCloudid() {
		return cloudid;
	}

	public String getStatus() {
		return status;
	}

	public String getType() {
		return type;
	}

	public String getOs() {
		return os;
	}

	public String getCpu() {
		return cpu;
	}

	public String getMemory() {
		return memory;
	}

	public String getStorage() {
		return storage;
	}

	public long getUptime() {
		return uptime;
	}

	public int getUserid() {
		return userid;
	}
	
	public String getPublicip() {
		return publicip;
	}

	public String getPrivateip() {
		return privateip;
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
	
	@XmlElement(name = "instanceid")
	public void setInstanceid(int instanceid) {
		this.instanceid = instanceid;
	}

	@XmlElement(name = "status")
	public void setStatus(String status) {
		this.status = status;
	}

	@XmlElement(name = "type")
	public void setType(String type) {
		this.type = type;
	}

	@XmlElement(name = "os")
	public void setOs(String os) {
		this.os = os;
	}

	@XmlElement(name = "cpu")
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	@XmlElement(name = "memory")
	public void setMemory(String memory) {
		this.memory = memory;
	}

	@XmlElement(name = "storage")
	public void setStorage(String storage) {
		this.storage = storage;
	}

	@XmlElement(name = "uptime")
	public void setUptime(long uptime) {
		this.uptime = uptime;
	}

	@XmlElement(name = "userid")
	public void setUserid(int userid) {
		this.userid = userid;
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
	

	public void printInstance(){
		System.out.println("Instanceid:"+instanceid);
		System.out.println("Name:"+name);
		System.out.println("cloudid:"+cloudid);
		System.out.println("Status:"+status);
		System.out.println("Type:"+type);
		System.out.println("os:"+os);
		System.out.println("cpu:"+cpu);
		System.out.println("memory:"+memory);
		System.out.println("storage:"+storage);
		System.out.println("publicip"+publicip);
		System.out.println("privateip"+privateip);
		System.out.println("uptime"+uptime);
		System.out.println("userid"+userid);
		System.out.println(" ===========================================================");
	}
}
