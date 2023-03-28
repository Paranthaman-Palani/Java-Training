package ItemMaster;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import JDBCUtility.JDBCUtility;

public class ItemMasterDAOImplementation extends ItemMasterDAO implements Cloneable {

	private static ItemMasterDAOImplementation dao;

	synchronized public static ItemMasterDAO getSingleTon() {
		if (dao == null) {
			dao = new ItemMasterDAOImplementation();
			return dao;
		} else {
			return dao;
		}
	}

	synchronized public static ItemMasterDAO getPrototype() {
		if (dao == null) {
			dao = new ItemMasterDAOImplementation();
			return dao;
		} else {
			return dao.getClone();
		}
	}

	synchronized public ItemMasterDAO getClone() {
		try {
			return (ItemMasterDAO) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ItemMasterDAOImplementation() {
		System.out.println("Item Master DAO......");
	}

	@Override
	public Collection<ItemMasterDTO> findByItemID(int itemid, Connection con) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con.prepareStatement("select * from item where itemid=?");
			ps.setInt(1, itemid);
			ResultSet rs = ps.executeQuery();

			List<ItemMasterDTO> dtoList = new ArrayList<>();
			if (rs.next()) {
				itemid = rs.getInt(1);
				String itemname = rs.getString(2);
				int unit = rs.getInt(3);
				float price = rs.getFloat(4);

				ItemMasterDTO dto = ItemMasterDTO.getInstance();
				dto.setItemid(itemid);
				dto.setItemname(itemname);
				dto.setItemprice(price);
				dto.setUnit(unit);
				dtoList.add(dto);
				JDBCUtility.closeConnection(null, null);
				return dtoList;
			} else {
				JDBCUtility.closeConnection(null, null);
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			JDBCUtility.closeConnection(e, null);
			return null;
		}
	}

	@Override
	public Collection<ItemMasterDTO> findAll(Connection con) {
		// TODO Auto-generated method stub
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from item");

			List<ItemMasterDTO> dtoList = new ArrayList<>();

			while (rs.next()) {
				ItemMasterDTO dto = ItemMasterDTO.getInstance();
				dto.setItemid(rs.getInt(1));
				dto.setItemname(rs.getString(2));
				dto.setItemprice(rs.getFloat(3));
				dto.setUnit(rs.getInt(4));
				dtoList.add(dto);
			}
			return dtoList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteItemMasterDTO(int itemid, Connection con) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con.prepareStatement("delete from item where itemid = ?");
			ps.setInt(1, itemid);
			int record = ps.executeUpdate();
			con.commit();
			return record;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int save(ItemMasterDTO dto, Connection con) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con
					.prepareStatement(" insert into item(itemid,itemname,itemprice,unit) values(?,?,?,?);");
			ps.setInt(1, dto.getItemid());
			ps.setString(2, dto.getItemname());
			ps.setFloat(3, dto.getItemprice());
			ps.setInt(4, dto.getUnit());

			int record = ps.executeUpdate();
			con.commit();

			return record;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int updateItemMasterDTO(int itemid, int unit, Connection con) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con.prepareStatement("update item set unit=? where itemid=?");
			ps.setInt(1, unit);
			ps.setInt(2, itemid);
			int record = ps.executeUpdate();
			con.commit();
			return record;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
