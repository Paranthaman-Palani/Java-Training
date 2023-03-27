package ItemMaster;

import java.io.Serializable;
import java.util.Objects;

public class ItemMasterDTO implements Serializable, Cloneable, Comparable<ItemMasterDTO> {

	private static final long serialVersionUID = 1L;

	private int itemid;
	private String itemname;
	private float itemprice;
	private int unit;

	@Override
	public int compareTo(ItemMasterDTO o) {
		return this.itemid - o.itemid;
	}

	private static ItemMasterDTO itm_dto;

	synchronized public static ItemMasterDTO getInstance() {
		if (itm_dto == null) {
			itm_dto = new ItemMasterDTO();
			return itm_dto;
		} else {
			return itm_dto.createClone();
		}
	}

	synchronized public ItemMasterDTO createClone() {
		try {
			return (ItemMasterDTO) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public float getItemprice() {
		return itemprice;
	}

	public void setItemprice(float itemprice) {
		this.itemprice = itemprice;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "ItemMasterDTO [itemid=" + itemid + ", itemname=" + itemname + ", itemprice=" + itemprice + ", unit="
				+ unit + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemid, itemname, itemprice, unit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemMasterDTO other = (ItemMasterDTO) obj;
		boolean isTrue = (itemid == other.itemid && itemname == other.itemname
				&& Float.floatToIntBits(itemprice) == Float.floatToIntBits(other.itemprice) && unit == other.unit);
        
		return isTrue;
	}

}
