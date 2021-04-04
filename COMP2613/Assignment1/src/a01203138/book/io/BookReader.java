package a01203138.book.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a01203138.book.ApplicationException;
import a01203138.book.data.Book;

public class BookReader {
	public static final String FIELD_DELIMITER = ":";
	private static final Logger LOG = LogManager.getLogger();


	public static Map<Integer, Book> read(String bookData) throws ApplicationException {
		
		Map<Integer, Book>book_list = new HashMap<Integer, Book>();

		File file = new File(bookData);
		FileReader in;
		Iterable<CSVRecord>records;
		try {
			in = new FileReader(file);
			records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
		}catch (IOException e) {
			throw new ApplicationException(e);
		}
		
		LOG.debug("Reading" + file.getAbsolutePath());
		for (CSVRecord record : records) {

			int book_id = Integer.parseInt(record.get("book_id"));
			String isbn = record.get("isbn");
			String author = record.get("authors");
			int original_publication_year = Integer.parseInt(record.get("original_publication_year"));
			String original_title = record.get("original_title");
			double average_rating = Double.parseDouble(record.get("average_rating"));
			int ratings_count = Integer.parseInt(record.get("ratings_count"));
			String image_url = record.get("image_url");

			book_list.put(book_id,
					new Book.Builder(book_id)
							.isbn(isbn)
							.authors(author)
							.original_publication_year(original_publication_year)
							.original_title(original_title)
							.average_rating(average_rating)
							.ratings_count(ratings_count)
							.image_url(image_url)
							.build());
		}

		return book_list;
	}
}
