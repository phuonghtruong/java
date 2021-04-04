package a01203138.book.sorters;

import java.util.Comparator;

import a01203138.book.data.Purchase;

public class PurchaseSorter {
	public static class CompareByBookTitle implements Comparator<Purchase>{
		@Override
		public int compare(Purchase purchase1, Purchase purchase2) {
			return purchase1.getBook().getOriginal_title().compareTo(purchase2.getBook().getOriginal_title());
		}
	}
}
