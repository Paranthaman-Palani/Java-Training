package Customer;

import java.sql.Connection;
import java.util.Collection;
import java.util.Scanner;
import JDBCUtility.JDBCUtility;

public class CustomerDAOMain {
	public static void main(String[] args) {

		int customerid;
		String customername;
		String location;
		String mobilenumber;

		try (Scanner scanner = new Scanner(System.in)) {
			Connection con = JDBCUtility.getConnection();

			CustomerDAO dao = CustomerDAOImplementation.getPrototype();

			CustomerDAOImplementation.getPrototype();

			System.out.printf(
					"Enter the your choice....\n1.ADD One Record\n2.Delete by Id\n3.Find by Customer ID\n4.Update Customer Location \n5.Find All Records");
			int choice = scanner.nextInt();
			switch (choice) {

			case 1:

				System.out.println("****************** ADD RECORD ******************");

				System.out.println("Enter Customer Id : ");
				customerid = scanner.nextInt();

				System.out.println("Enter Customer Name : ");
				customername = scanner.next();

				System.out.println("Enter Customer Location : ");
				location = scanner.next();

				System.out.println("Enter Customer Mobile number : ");
				mobilenumber = scanner.next();

				CustomerDTO dto = CustomerDTO.getInstance();
				dto.setCustomerid(customerid);
				dto.setCustomername(customername);
				dto.setLocation(location);
				dto.setMobilenumber(mobilenumber);

				dao.save(dto, con);
				System.out.println("1 Record Saved.....");
				break;

			case 2:

				System.out.println("****************** DELETE BY ID ******************");
				System.out.println("Enter Customer ID to delete Customer Record");
				customerid = scanner.nextInt();
				System.out.println("No of records deleted : " + dao.deleteCustomerDTO(customerid , con));
				break;

			case 3:

				System.out.println("****************** FIND RECORD BY CUSTOMER ID ****************** ");
				System.out.println("Enter Customer ID");
				customerid = scanner.nextInt();
				CustomerDTO dto1 = dao.findByCustomerID(customerid, con);
				System.out.println(dto1);
				break;

			case 4:

				System.out.println("****************** UPDATE ******************");
				System.out.println("Enter Customer ID to Update Customer location");
				customerid = scanner.nextInt();
				System.out.println("Enter Customer New location");
				location = scanner.next();
				int records = dao.updateCustomerDTO(customerid, location , con);// invid,discount
				System.out.println(records + " Updated...");
				break;

			case 5:
				Collection<CustomerDTO> dtoList = dao.findAll(con);
				System.out.println("****************** FIND ALL CUSTOMER RECORDS ******************");
				for (CustomerDTO customer : dtoList) {
					System.out.println(customer);
				}
				break;
			}

		}

	}
}
