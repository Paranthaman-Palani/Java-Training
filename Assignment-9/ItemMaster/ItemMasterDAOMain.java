package ItemMaster;

import java.sql.Connection;

import java.util.Collection;
import java.util.Scanner;

import JDBCUtility.JDBCUtility;

public class ItemMasterDAOMain {
	public static void main(String[] args) {
		int itemid;
		String itemname;
		float itemprice;
		int unit;

		try (Scanner scanner = new Scanner(System.in)) {
			Connection con = JDBCUtility.getConnection();

			ItemMasterDAO dao = ItemMasterDAOImplementation.getPrototype();

			ItemMasterDAOImplementation.getPrototype();

			System.out.printf(
					"Enter the your choice....\n1.ADD One Record\n2.Delete by Id\n3.Find By Item id\n4.Update Item Unit\n5.Find All Records");
			int choice = scanner.nextInt();
			switch (choice) {

			case 1:

				System.out.println("****************** ADD RECORD ******************");

				System.out.println("Enter Item id : ");
				itemid = scanner.nextInt();

				System.out.println("Enter the Item name : ");
				itemname = scanner.next();

				System.out.println("Enter the Price : ");
				itemprice = scanner.nextFloat();

				System.out.println("Enter the Quantity : ");
				unit = scanner.nextInt();

				ItemMasterDTO dto = ItemMasterDTO.getInstance();
				dto.setItemid(itemid);
				dto.setItemname(itemname);
				dto.setItemprice(itemprice);
				dto.setUnit(unit);

				dao.save(dto, con);
				System.out.println("1 Record Saved.....");
				break;

			case 2:

				System.out.println("****************** DELETE BY ID ******************");
				System.out.println("Enter Item ID to delete Record");
				itemid= scanner.nextInt();
				System.out.println("No of records deleted : " + dao.deleteItemMasterDTO(itemid, con));
				break;

			case 3:
				System.out.println("****************** FIND RECORD BY Item ID ****************** ");
				System.out.println("Enter Item Id");
				itemid = scanner.nextInt();
				Collection<ItemMasterDTO> byId = dao.findByItemID(itemid, con);
				System.out.println(byId);
				break;

			case 4:
				System.out.println("****************** UPDATE ******************");
				System.out.println("Enter Item ID to Update unit");
				itemid = scanner.nextInt();
				System.out.println("Enter New Units");
				unit = scanner.nextInt();
				int records = dao.updateItemMasterDTO(itemid, unit, con);
				System.out.println(records + " Updated...");
				break;

			case 5:
				Collection<ItemMasterDTO> dtoList = dao.findAll(con);
				System.out.println("****************** FIND ALL INVOICE TRANSACTION RECORDS ******************");
				for (ItemMasterDTO invt : dtoList) {
					System.out.println(invt);
				}
				break;
			}
		}

	}

}
