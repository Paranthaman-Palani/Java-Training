package ItemMaster;

import java.sql.Connection;
import java.util.Collection;

public abstract class ItemMasterDAO {

	public abstract Collection<ItemMasterDTO> findByItemID(int itemid, Connection con);

	public abstract Collection<ItemMasterDTO> findAll(Connection con);

	public abstract int deleteItemMasterDTO(int itemid, Connection con);

	public abstract int save(ItemMasterDTO inv, Connection con);

	public abstract int updateItemMasterDTO(int itemid, int unit, Connection con);

}