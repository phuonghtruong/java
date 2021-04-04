package a01203138.book.data;


public class Purchase {
	private int id;
	private Customer customer;
	private Book book;
	private double price;

	public static class Builder {
		// Required parameters
		private int id;
		private Customer customer;
		private Book book;
		private double price;

		public Builder(int id, Customer customer, Book book, double price) {
			this.id = id;
			this.customer = customer;
			this.book = book;
			this.price = price;
		}

		public Purchase build() {
			return new Purchase(this);
		}
	}

	private Purchase(Builder builder) {
		id = builder.id;
		customer = builder.customer;
		book = builder.book;
		price = builder.price;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the firstName
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @return the lastName
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * @return the streetName
	 */
	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Purchase [id=" + id 
				+ ", customer=" + customer 
				+ ", book=" + book 
				+ ", price=" + price + "]";
	}
}
