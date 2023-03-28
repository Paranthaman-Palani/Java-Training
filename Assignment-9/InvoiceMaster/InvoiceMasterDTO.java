package InvoiceMaster;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class InvoiceMasterDTO implements Serializable, Cloneable, Comparable<InvoiceMasterDTO> {

	private static final long serialVersionUID = 1L;
	private int invid;
	private int custid;
	private Date invdate;
	private float amount;
	private int discount;

	@Override
	public int compareTo(InvoiceMasterDTO o) {
		return this.invid - o.invid;
	}

	private static InvoiceMasterDTO invm_dto;

	synchronized public static InvoiceMasterDTO getInstance() {
		if (invm_dto == null) {
			invm_dto = new InvoiceMasterDTO();
			return invm_dto;
		} else {
			return invm_dto.createClone();
		}
	}

	synchronized public InvoiceMasterDTO createClone() {
		try {
			return (InvoiceMasterDTO) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getInvid() {
		return invid;
	}

	public void setInvid(int invid) {
		this.invid = invid;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public Date getInvdate() {
		return invdate;
	}

	public void setInvdate(Date invdate) {
		this.invdate = invdate;
	}

	public float getAmount() {
		return amount;
	}

	public int getDiscount() {
		return discount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, custid, discount, invdate, invid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceMasterDTO other = (InvoiceMasterDTO) obj;
		
		boolean isAmountEqual = amount == other.amount;
		boolean isCustomerIdEqual = custid  == other.custid;
		boolean isDiscountEqual = discount == other.discount;
		boolean isInvoiceDateEqual = Objects.equals(invdate, other.invdate);
		boolean isInvoiceIDEqual = invid == other.invid;

		boolean isTrue = isAmountEqual && isCustomerIdEqual && isDiscountEqual && isInvoiceDateEqual && isInvoiceIDEqual;
		
		return isTrue;


	}

	@Override
	public String toString() {
		return "InvoiceMasterDTO [invid=" + invid + ", custid=" + custid + ", invdate=" + invdate + ", amount=" + amount
				+ ", discount=" + discount + "]";
	}

}