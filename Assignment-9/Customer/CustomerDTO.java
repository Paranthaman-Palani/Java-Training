package Customer;

import java.io.Serializable;
import java.util.Objects;

public class CustomerDTO implements Serializable, Cloneable, Comparable<CustomerDTO> {

	private static final long serialVersionUID = 1L;

	private static CustomerDTO cus_dto;

	synchronized public static CustomerDTO getInstance() {
		if (cus_dto == null) {
			cus_dto = new CustomerDTO();
			return cus_dto;
		} else {
			return cus_dto.createClone();
		}
	}

	synchronized public CustomerDTO createClone() {
		try {
			return (CustomerDTO) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private int custid;
	private String cusname;
	private String location;
	private String mobilenumber;

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getCusname() {
		return cusname;
	}

	public void setCusname(String cusname) {
		this.cusname = cusname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int compareTo(CustomerDTO o) {
		// TODO Auto-generated method stub
		return this.custid - o.custid;
	}

	@Override
	public String toString() {
		return "CustomerDTO [custid=" + custid + ", cusname=" + cusname + ", location=" + location + ", mobilenumber="
				+ mobilenumber + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cusname, custid, location, mobilenumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDTO other = (CustomerDTO) obj;
		return Objects.equals(cusname, other.cusname) && custid == other.custid
				&& Objects.equals(location, other.location) && Objects.equals(mobilenumber, other.mobilenumber);
	}

}
