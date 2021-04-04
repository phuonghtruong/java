package a01203138.io;

import java.util.Comparator;

import a01203138.book.data.Customer;

public class CompareByJoinDate implements Comparator<Customer> {

	@Override
	public int compare(Customer c1, Customer c2) {
		return c1.getJoinDate().compareTo(c2.getJoinDate());
	}
}
