package InvoiceTransaction;

import java.sql.Connection;

import java.util.Collection;
import java.util.Scanner;

import JDBCUtility.JDBCUtility;

public class InvoiceTransactionDAOMain {
	public static void main(String[] args) {
		int invid;
		int itmid;
		int qty;
		float price;
		
		try (Scanner scanner = new Scanner(System.in)) {
			Connection con = JDBCUtility.getConnection();

			InvoiceTransactionDAO dao = InvoiceTransactionDAOImplementation.getPrototype();

			InvoiceTransactionDAOImplementation.getPrototype();	
			System.out.printf("Enter the your choice....\n1.ADD One Record\n2.Delete by Id\n3.Find by Invoice ID\n4.Find By Item ID id\n5.Update price\n6.Find All Records");
			int choice = scanner.nextInt();
			switch (choice) {
			
			case 1:

				System.out.println("****************** ADD RECORD ******************");

				System.out.println("Enter Invoice id : ");
				invid = scanner.nextInt();


				System.out.println("Enter Item id : ");
				itmid = scanner.nextInt();

				System.out.println("Enter Quantity : ");
				qty = scanner.nextInt();

				System.out.println("Enter Price : ");
				price = scanner.nextFloat();

				InvoiceTransactionDTO dto = InvoiceTransactionDTO.getInstance();
				dto.setInvid(invid);
				dto.setItmid(itmid);
				dto.setQty(qty);
				dto.setPrice(price);

				dao.save(dto, con);
				System.out.println("1 Record Saved.....");
				break;
			
			case 2:
				
				System.out.println("****************** DELETE BY ID ******************");
				System.out.println("Enter Invoice ID to delete Record");
				invid = scanner.nextInt();
				System.out.println("No of records deleted : "+dao.deleteInvoiceTransactionDTO(invid, con));
				break;
				
				
			case 3:
				System.out.println("****************** FIND RECORD BY Invoice ID ****************** ");
				System.out.println("Enter Invoice Id");
				invid = scanner.nextInt();
				InvoiceTransactionDTO byId =  dao.findByPrimaryKey(invid, con);
				System.out.println(byId);
				break;
			
			
			case 4:
				System.out.println("****************** FIND RECORD BY Item ID ****************** ");
				System.out.println("Enter Item Id");
				itmid = scanner.nextInt();
				Collection<InvoiceTransactionDTO> dto1 =  dao.findByItemID(itmid, con);
				System.out.println(dto1);
				break;


			case 5:		
				System.out.println("****************** UPDATE ******************");
				System.out.println("Enter Item ID to Update price");
				itmid = scanner.nextInt();
				System.out.println("Enter New Price");
				price = scanner.nextFloat();
				int records = dao.updateInvoiceTransactionDTO(itmid,(int) price,con);//invid,discount
				System.out.println(records+" Updated...");
				break;
			
			
			case 6:
				Collection<InvoiceTransactionDTO> dtoList = dao.findAll(con);
				System.out.println("****************** FIND ALL INVOICE TRANSACTION RECORDS ******************");
				for(InvoiceTransactionDTO invt:dtoList) {
					System.out.println(invt);
				}
				break;
			}
		}
			
	
	}

}

