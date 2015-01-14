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
@XmlRootElement(name = "rate")
@XmlType(propOrder = { "rateid", "type", "component","costpermin"})
public class Rate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3723910394542506470L;
	private int rateid;
	private String type;
	private String component;
	private double costpermin;

	public Rate(){
		//default constructor
	}
	
	public Rate(int rateid , String type, String component, double costpermin) {
		this.rateid = rateid;
		this.type = type;
		this.component = component;
		this.costpermin=costpermin;
	}

	public int getRateid() {
		return rateid;
	}

	public String getType() {
		return type;
	}

	public String getComponent() {
		return component;
	}

	public double getCostpermin() {
		return costpermin;
	}

	@XmlElement(name = "rateid")
	public void setRateid(int rateid) {
		this.rateid = rateid;
	}

	@XmlElement(name = "type")
	public void setType(String type) {
		this.type = type;
	}

	@XmlElement(name = "component")
	public void setComponent(String component) {
		this.component = component;
	}

	@XmlElement(name = "costpermin")
	public void setCostpermin(double costpermin) {
		this.costpermin = costpermin;
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
		System.out.println("rateid:"+rateid);
		System.out.println("type:"+type);
		System.out.println("component"+component);
		System.out.println("costpermin"+costpermin);
		System.out.println(" ===========================================================");
	}
}
