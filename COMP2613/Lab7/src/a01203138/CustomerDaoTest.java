package a01203138;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a01203138.data.Customer;
import a01203138.data.CustomerDao;;


public class CustomerDaoTest {
	private static Logger Log = LogManager.getLogger();
	private CustomerDao customerDao;

	public CustomerDaoTest(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void test() {
		try {
			Log.info("Getting the customer IDs");
			List<String> ids = customerDao.getCustomerIds();
			Log.info("Customer IDs: " + Arrays.toString(ids.toArray()));
			for (String id : ids) {
				Log.info(id);
				Customer customer = customerDao.getCustomer(id);
				Log.info(customer);
			}
			long count = customerDao.countAllCustomers();
			Log.info(count);
		} catch (Exception e) {
			Log.error(e.getMessage());
		}

	}
	
}
