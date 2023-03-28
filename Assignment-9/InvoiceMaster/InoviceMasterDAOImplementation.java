package InvoiceMaster;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import JDBCUtility.JDBCUtility;

public class InoviceMasterDAOImplementation extends InvoiceMasterDAO implements Cloneable {

	private static InoviceMasterDAOImplementation dao;

	synchronized public static InvoiceMasterDAO getSingleTon() {
		if (dao == null) {
			dao = new InoviceMasterDAOImplementation();
			return dao;
		} else {
			return dao;
		}
	}

	synchronized public static InvoiceMasterDAO getPrototype() {
		if (dao == null) {
			dao = new InoviceMasterDAOImplementation();
			return dao;
		} else {
			return dao.getClone();
		}
	}

	synchronized public InvoiceMasterDAO getClone() {
		try {
			return (InvoiceMasterDAO) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public InoviceMasterDAOImplementation() {
		System.out.println("Invoice Master DAO....");
	}

	@Override
	public InvoiceMasterDTO findByPrimaryKey(int id, Connection con) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con.prepareStatement("select * from invoice where invid=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int invid = rs.getInt(1);
				Date date = rs.getDate(3);
				int custid = rs.getInt(2);
				int invamt = rs.getInt(4);
				int discount = rs.getInt(5);

				InvoiceMasterDTO dto = InvoiceMasterDTO.getInstance();
				dto.setInvid(invid);
				dto.setInvdate(date);
				dto.setAmount(invamt);
				dto.setDiscount(discount);
				dto.setCustid(custid);
				JDBCUtility.closeConnection(null, null);
				return dto;
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
	public Collection<InvoiceMasterDTO> findByCustomerID(int custid, Connection con) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con.prepareStatement("select * from invoice where custid=?");
			ps.setInt(1, custid);
			ResultSet rs = ps.executeQuery();

			List<InvoiceMasterDTO> dtoList1 = new ArrayList<>();
			if (rs.next()) {
				int invid = rs.getInt(1);
				Date date = rs.getDate(3);
				custid = rs.getInt(2);
				int invamt = rs.getInt(4);
				int discount = rs.getInt(5);

				InvoiceMasterDTO dto = InvoiceMasterDTO.getInstance();
				dto.setInvid(invid);
				dto.setInvdate(date);
				dto.setAmount(invamt);
				dto.setDiscount(discount);
				dto.setCustid(custid);
				dtoList1.add(dto);
				JDBCUtility.closeConnection(null, null);
				return dtoList1;
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
	public Collection<InvoiceMasterDTO> findAll(Connection con) {
		// TODO Auto-generated method stub
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from invoice");

			List<InvoiceMasterDTO> dtoList = new ArrayList<>();

			while (rs.next()) {
				InvoiceMasterDTO dto = InvoiceMasterDTO.getInstance();
				dto.setInvid(rs.getInt(1));
				dto.setCustid(rs.getInt(2));
				dto.setInvdate((java.sql.Date) rs.getDate(3));
				dto.setAmount(rs.getFloat(4));
				dto.setDiscount(rs.getInt(5));
				dtoList.add(dto);
			}
			return dtoList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteInvoiceMasterDTO(int id, Connection con) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con.prepareStatement("delete from invoice where invid = ?");
			ps.setInt(1, id);
			int record = ps.executeUpdate();
			con.commit();
			return record;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int save(InvoiceMasterDTO dto, Connection con) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con
					.prepareStatement(" insert into invoice(invid,custid,date,amount,discount) values(?,?,?,?,?);");
			ps.setInt(1, dto.getInvid());
			ps.setInt(2, dto.getCustid());
			ps.setDate(3, (Date) dto.getInvdate());
			ps.setFloat(4, dto.getAmount());
			ps.setInt(5, dto.getDiscount());

			int record = ps.executeUpdate();
			con.commit();

			return record;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int updateInvoiceMasterDTO(int invid, int discount, Connection con) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con.prepareStatement("update invoice set discount=? where invid=?");
			ps.setInt(1, discount);
			ps.setInt(2, invid);
			int noOfRowsAffected = ps.executeUpdate();
			con.commit();
			return noOfRowsAffected;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
