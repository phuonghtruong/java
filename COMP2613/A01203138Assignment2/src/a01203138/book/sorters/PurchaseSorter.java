package a01203138.book.sorters;

import java.util.Comparator;


import a01203138.book.data.AllData;
import a01203138.book.data.Book;
import a01203138.book.data.Customer;
import a01203138.book.data.Purchase;

public class PurchaseSorter {
	public static class CompareByBookTitle implements Comparator<Purchase>{

		@Override
		public int compare(Purchase purchase1, Purchase purchase2) {
			long bookId1 = purchase1.getBookId();
			Book book1 = AllData.getBooks().get(bookId1);
			long bookId2 = purchase2.getBookId();
			Book book2 = AllData.getBooks().get(bookId2);
			return book1.getTitle().compareTo(book2.getTitle());
		}
	}
	
	public static class CompareByBookTitleDescending implements Comparator<Purchase>{
		@Override
		public int compare(Purchase purchase1, Purchase purchase2) {
			long bookId1 = purchase1.getBookId();
			Book book1 = AllData.getBooks().get(bookId1);
			long bookId2 = purchase2.getBookId();
			Book book2 = AllData.getBooks().get(bookId2);
			return book2.getTitle().compareTo(book1.getTitle());
		}
	}
	
	public static class CompareByLastName implements Comparator<Purchase>{
		@Override
		public int compare(Purchase purchase1, Purchase purchase2) {
			long customerId1 = purchase1.getCustomerId();
			Customer customer1 = AllData.getCustomers().get(customerId1);
			long customerId2 = purchase2.getCustomerId();
			Customer customer2 = AllData.getCustomers().get(customerId2);
			return customer1.getLastName().compareTo(customer2.getLastName());
		}
	}
	
	public static class CompareByLastNameDescending implements Comparator<Purchase>{
		@Override
		public int compare(Purchase purchase1, Purchase purchase2) {
			long customerId1 = purchase1.getCustomerId();
			Customer customer1 = AllData.getCustomers().get(customerId1);
			long customerId2 = purchase2.getCustomerId();
			Customer customer2 = AllData.getCustomers().get(customerId2);
			return customer2.getLastName().compareTo(customer1.getLastName());
		}
	}
}
