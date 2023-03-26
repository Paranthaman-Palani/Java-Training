package InvoiceTransaction;

import java.io.Serializable;
import java.util.Objects;

public class InvoiceTransactionDTO implements Serializable, Cloneable, Comparable<InvoiceTransactionDTO> {

	private static final long serialVersionUID = 1L;

	private int invid;
	private int itmid;
	private int qty;
	private float price;

	@Override
	public int compareTo(InvoiceTransactionDTO o) {
		return this.invid - o.invid;
	}

	private static InvoiceTransactionDTO invt_dto;

	synchronized public static InvoiceTransactionDTO getInstance() {
		if (invt_dto == null) {
			invt_dto = new InvoiceTransactionDTO();
			return invt_dto;
		} else {
			return invt_dto.createClone();
		}
	}

	synchronized public InvoiceTransactionDTO createClone() {
		try {
			return (InvoiceTransactionDTO) super.clone();
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

	public int getItmid() {
		return itmid;
	}

	public void setItmid(int itmid) {
		this.itmid = itmid;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "InvoiceTransactionDTO [invid=" + invid + ", itmid=" + itmid + ", qty=" + qty + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(invid, itmid, price, qty);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceTransactionDTO other = (InvoiceTransactionDTO) obj;
		return invid == other.invid && itmid == other.itmid
				&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price) && qty == other.qty;
	}

}
