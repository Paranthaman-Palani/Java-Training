package InvoiceMaster;

import java.sql.Connection;
import java.sql.Date;
import java.util.Collection;
import java.util.Scanner;

import JDBCUtility.JDBCUtility;

public class InvoiceDAOMain {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int invid;
			Date date;
			int custid;
			float amount;
			int discount;
			Connection con = JDBCUtility.getConnection();

			InvoiceMasterDAO dao = InoviceMasterDAOImplementation.getPrototype();

			InoviceMasterDAOImplementation.getPrototype();

			System.out.printf(
					"Enter the your choice....\n1.ADD One Record\n2.Delete by Id\n3.Find by Invoice ID\n4.Find By Cust id\n5.Update Invoice Discount\n6.Find All Records");
			int choice = scanner.nextInt();
			switch (choice) {

			case 1:

				System.out.println("****************** ADD RECORD ******************");

				System.out.println("Enter invoice id : ");
				invid = scanner.nextInt();

				System.out.println("Enter the invoice date : ");
				date = Date.valueOf(scanner.next());

				System.out.println("Enter the customer id : ");
				custid = scanner.nextInt();

				System.out.println("Enter the invoice amount : ");
				amount = scanner.nextFloat();

				System.out.println("Enter the discount : ");
				discount = scanner.nextInt();

				InvoiceMasterDTO dto = InvoiceMasterDTO.getInstance();
				dto.setCustid(custid);
				dto.setDiscount(discount);
				dto.setAmount(amount);
				dto.setInvdate(date);
				dto.setInvid(invid);

				dao.save(dto, con);
				System.out.println("1 Record Saved.....");
				break;

			case 2:
				System.out.println("****************** DELETE BY ID ******************");
				System.out.println("Enter Invoice ID to delete Invoice Record");
				invid = scanner.nextInt();
				System.out.println("No of records deleted : " + dao.deleteInvoiceMasterDTO(invid, con));
				break;

			case 3:
				System.out.println("****************** FIND RECORD BY Invoice ID ****************** ");
				System.out.println("Enter Invoice Id");
				invid = scanner.nextInt();
				InvoiceMasterDTO byId = dao.findByPrimaryKey(invid, con);
				System.out.println(byId);
				break;

			case 4:
				System.out.println("****************** FIND RECORD BY Customer ID ****************** ");
				System.out.println("Enter Customer Id");
				custid = scanner.nextInt();
				Collection<InvoiceMasterDTO> dto1 = dao.findByCustomerID(custid, con);
				System.out.println("<------ FIND BY CUSTOMER ID------>");
				System.out.println(dto1);
				break;

			case 5:
				System.out.println("****************** UPDATE ******************");
				System.out.println("Enter Invoice ID to Update discount");
				invid = scanner.nextInt();
				System.out.println("Enter New Discount");
				discount = scanner.nextInt();
				int records = dao.updateInvoiceMasterDTO(invid, discount, con);// invid,discount
				System.out.println(records + " Updated...");
				break;

			case 6:
				Collection<InvoiceMasterDTO> dtoList = dao.findAll(con);
				System.out.println("****************** FIND ALL CUSTOMER RECORDS ******************");
				for (InvoiceMasterDTO cust : dtoList) {
					System.out.println(cust);
				}
				break;
			}

		}

	}
}
