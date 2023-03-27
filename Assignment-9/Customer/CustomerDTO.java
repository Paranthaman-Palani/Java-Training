package Customer;

import java.io.Serializable;
import java.util.Objects;

public class CustomerDTO implements Serializable, Cloneable, Comparable<CustomerDTO> {

	private int customerid;
	private String customername;
	private String location;
	private String mobilenumber;

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

	@Override
	public String toString() {
		return "CustomerDTO [customerid=" + customerid + ", customername=" + customername + ", location=" + location
				+ ", mobilenumber=" + mobilenumber + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerid, customername, location, mobilenumber);
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
		
		boolean isCustomerIdEqual = customerid == other.customerid;
		boolean isCustomerNameEqual = Objects.equals(customername, other.customername);
		boolean isLocationEqual = Objects.equals(location, other.location);
		boolean isMobileNumberEqual = Objects.equals(mobilenumber, other.mobilenumber);

		boolean isTrue = isCustomerIdEqual && isCustomerNameEqual && isLocationEqual && isMobileNumberEqual;
		
		return isTrue;

	}

	public static CustomerDTO getCus_dto() {
		return cus_dto;
	}

	public static void setCus_dto(CustomerDTO cus_dto) {
		CustomerDTO.cus_dto = cus_dto;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
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
		return this.customerid - o.customerid;
	}

}