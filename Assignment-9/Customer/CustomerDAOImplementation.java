package Customer;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import JDBCUtility.JDBCUtility;

public class CustomerDAOImplementation extends CustomerDAO implements Cloneable {

	private static CustomerDAO dao;

	synchronized public static CustomerDAO getSingleTon() {
		if (dao == null) {
			dao = new CustomerDAOImplementation();
			return dao;
		} else {
			return dao;
		}
	}

	synchronized public static CustomerDAO getPrototype() {
		if (dao == null) {
			dao = new CustomerDAOImplementation();
			return dao;
		} else {
			return ((CustomerDAOImplementation) dao).getClone();
		}
	}

	synchronized public CustomerDAO getClone() {
		try {
			return (CustomerDAO) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public CustomerDAOImplementation() {
		System.out.println("Customer DAO...");
	}

	@Override
	public CustomerDTO findByCustomerID(int customerid, Connection con) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con.prepareStatement("select * from customer where custid=?");
			ps.setInt(1, customerid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customerid = rs.getInt(1);
				String customername = rs.getString(2);
				String location = rs.getString(3);
				String mobilenumber = rs.getString(4);

				CustomerDTO dto = CustomerDTO.getInstance();
				dto.setCustomerid(customerid);
				dto.setCustomername(customername);
				dto.setLocation(location);
				dto.setMobilenumber(mobilenumber);

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
	public Collection<CustomerDTO> findAll(Connection con) {
		// TODO Auto-generated method stub
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customer");

			Collection<CustomerDTO> dtoList = new ArrayList<>();

			while (rs.next()) {
				CustomerDTO dto = CustomerDTO.getInstance();
				dto.setCustomerid(rs.getInt(1));
				dto.setCustomername(rs.getString(2));
				dto.setLocation(rs.getString(3));
				dto.setMobilenumber(rs.getString(4));
				dtoList.add(dto);
			}
			return dtoList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteCustomerDTO(int id, Connection con) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con.prepareStatement("delete from customer where custid = ?");
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
	public int save(CustomerDTO dto, Connection con) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con
					.prepareStatement(" insert into customer(custid,cusname,loaction,mobilenumber) values(?,?,?,?);");
			ps.setInt(1, dto.getCustomerid());
			ps.setString(2, dto.getCustomername());
			ps.setString(3, dto.getLocation());
			ps.setString(4, dto.getMobilenumber());

			int record = ps.executeUpdate();
			con.commit();

			return record;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int updateCustomerDTO(int customerid, String location, Connection con) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con.prepareStatement("update customer set loaction=? where custid=?");
			ps.setString(1, location);
			ps.setInt(2, customerid);
			int noOfRowsAffected = ps.executeUpdate();
			con.commit();
			return noOfRowsAffected;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
