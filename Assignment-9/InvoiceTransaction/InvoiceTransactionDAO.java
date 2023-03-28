package InvoiceTransaction;

import java.sql.Connection;
import java.util.Collection;

public abstract class InvoiceTransactionDAO {
	public abstract InvoiceTransactionDTO findByPrimaryKey(int id, Connection con);

	public abstract Collection<InvoiceTransactionDTO> findByItemID(int custid, Connection con);

	public abstract Collection<InvoiceTransactionDTO> findAll(Connection con);

	public abstract int deleteInvoiceTransactionDTO(int itmid, Connection con);

	public abstract int save(InvoiceTransactionDTO inv, Connection con);

	public abstract int updateInvoiceTransactionDTO(int itmid, int price, Connection con);

}
