package a01203138.book.sorters;

import java.util.Comparator;

import a01203138.book.data.Customer;

public class CustomerSorter {
	public static class CompareByJoinedDate implements Comparator<Customer>{
		@Override
		public int compare(Customer customer1, Customer customer2) {
			return customer1.getJoinDate().compareTo(customer2.getJoinDate());
		}
	}
	
	public static class CompareByJoinedDateDescending implements Comparator<Customer>{
		@Override
		public int compare(Customer customer1, Customer customer2) {
			return customer2.getJoinDate().compareTo(customer1.getJoinDate());
		}
	}
}
