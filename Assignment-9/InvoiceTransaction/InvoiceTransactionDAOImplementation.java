package InvoiceTransaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import JDBCUtility.JDBCUtility;

public class InvoiceTransactionDAOImplementation extends InvoiceTransactionDAO implements Cloneable {

	private static InvoiceTransactionDAOImplementation dao;

	synchronized public static InvoiceTransactionDAO getSingleTon() {
		if (dao == null) {
			dao = new InvoiceTransactionDAOImplementation();
			return dao;
		} else {
			return dao;
		}
	}

	synchronized public static InvoiceTransactionDAO getPrototype() {
		if (dao == null) {
			dao = new InvoiceTransactionDAOImplementation();
			return dao;
		} else {
			return dao.getClone();
		}
	}

	synchronized public InvoiceTransactionDAO getClone() {
		try {
			return (InvoiceTransactionDAO) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public InvoiceTransactionDAOImplementation() {
		System.out.println("Invoice Transaction DAO....");
	}

	@Override
	public InvoiceTransactionDTO findByPrimaryKey(int id, Connection con) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con.prepareStatement("select * from invoicetransaction where invid=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int invid = rs.getInt(1);
				int itmid = rs.getInt(2);
				int qty = rs.getInt(3);
				float price = rs.getFloat(4);

				InvoiceTransactionDTO dto = InvoiceTransactionDTO.getInstance();
				dto.setInvid(invid);
				dto.setItmid(itmid);
				dto.setQty(qty);
				dto.setPrice(price);
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
	public Collection<InvoiceTransactionDTO> findByItemID(int custid, Connection con) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con.prepareStatement("select * from invoicetransaction where custid=?");
			ps.setInt(1, custid);
			ResultSet rs = ps.executeQuery();

			List<InvoiceTransactionDTO> dtoList = new ArrayList<>();
			if (rs.next()) {
				int invid = rs.getInt(1);
				int itmid = rs.getInt(2);
				int qty = rs.getInt(3);
				float price = rs.getFloat(4);

				InvoiceTransactionDTO dto = InvoiceTransactionDTO.getInstance();
				dto.setInvid(invid);
				dto.setItmid(itmid);
				dto.setQty(qty);
				dto.setPrice(price);
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
	public Collection<InvoiceTransactionDTO> findAll(Connection con) {
		// TODO Auto-generated method stub
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from invoicetransaction");

			List<InvoiceTransactionDTO> dtoList = new ArrayList<>();

			while (rs.next()) {
				InvoiceTransactionDTO dto = InvoiceTransactionDTO.getInstance();
				dto.setInvid(rs.getInt(1));
				dto.setItmid(rs.getInt(2));
				dto.setQty(rs.getInt(3));
				dto.setPrice(rs.getFloat(4));
				dtoList.add(dto);
			}
			return dtoList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteInvoiceTransactionDTO(int itmid, Connection con) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con.prepareStatement("delete from invoicetransaction where invid = ?");
			ps.setInt(1, itmid);
			int record = ps.executeUpdate();
			con.commit();
			return record;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int save(InvoiceTransactionDTO dto, Connection con) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con
					.prepareStatement(" insert into invoicetransaction(invid,itmid,qty,price) values(?,?,?,?);");
			ps.setInt(1, dto.getInvid());
			ps.setInt(2, dto.getItmid());
			ps.setInt(3, dto.getQty());
			ps.setFloat(4, dto.getPrice());

			int record = ps.executeUpdate();
			con.commit();

			return record;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int updateInvoiceTransactionDTO(int itmid, int price, Connection con) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con.prepareStatement("update invoicetransaction set price=? where itmid=?");
			ps.setFloat(1, price);
			ps.setInt(2, itmid);
			int record = ps.executeUpdate();
			con.commit();
			return record;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
