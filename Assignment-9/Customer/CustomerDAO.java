package Customer;

import java.sql.Connection;
import java.util.Collection;

public abstract class CustomerDAO {

	public abstract CustomerDTO findByCustomerID(int custid, Connection con);

	public abstract Collection<CustomerDTO> findAll(Connection con);

	public abstract int deleteCustomerDTO(int id, Connection con);

	public abstract int save(CustomerDTO inv, Connection con);

	public abstract int updateCustomerDTO(int custid, String location, Connection con);

}
