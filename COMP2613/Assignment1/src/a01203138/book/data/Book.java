package a01203138.book.data;

public class Book {
	public static final int ATTRIBUTE_COUNT = 8;
	
	private int book_id;
	private String isbn;
	private String authors;
	private int original_publication_year;
	private String original_title;
	private double average_rating;
	private int ratings_count;
	private String image_url;

	public static class Builder {
		// Required parameters
		private final int book_id;

		// Optional parameters
		private String isbn;
		private String authors;
		private int original_publication_year;
		private String original_title;
		private double average_rating;
		private int ratings_count;
		private String image_url;

		public Builder(int book_id) {
			this.book_id = book_id;
		}

		public Builder isbn(String val) {
			isbn = val;
			return this;
		}

		public Builder authors(String val) {
			authors = val;
			return this;
		}

		public Builder original_publication_year(int val) {
			original_publication_year = val;
			return this;
		}

		public Builder original_title(String val) {
			original_title = val;
			return this;
		}

		public Builder average_rating(double val) {
			average_rating = val;
			return this;
		}

		public Builder ratings_count(int val) {
			ratings_count = val;
			return this;
		}

		public Builder image_url(String val) {
			image_url = val;
			return this;
		}

		public Book build() {
			return new Book(this);
		}
	}

	private Book(Builder builder) {
		book_id = builder.book_id;
		isbn = builder.isbn;
		authors = builder.authors;
		original_publication_year = builder.original_publication_year;
		original_title = builder.original_title;
		average_rating = builder.average_rating;
		ratings_count = builder.ratings_count;
		image_url = builder.image_url;
	}


	/**
	 * @return the book_id
	 */
	public int getBook_id() {
		return book_id;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @return the authors
	 */
	public String getAuthors() {
		return authors;
	}

	/**
	 * @return the original_publication_year
	 */
	public int getOriginal_publication_year() {
		return original_publication_year;
	}

	/**
	 * @return the original_title
	 */
	public String getOriginal_title() {
		return original_title;
	}

	/**
	 * @return the average_rating
	 */
	public double getAverage_rating() {
		return average_rating;
	}

	/**
	 * @return the ratings_count
	 */
	public int getRatings_count() {
		return ratings_count;
	}

	/**
	 * @return the image_url
	 */
	public String getImage_url() {
		return image_url;
	}

	@Override
	public String toString() {
		return "Book [book_id=" + book_id 
				+ ", isbn=" + isbn 
				+ ", authors=" + authors 
				+ ", original_publication_year=" + original_publication_year 
				+ ", original_title=" + original_title 
				+ ", average_rating=" + average_rating 
				+ ", ratings_count=" + ratings_count 
				+ ", image_url=" + image_url + "]";
	}
}
