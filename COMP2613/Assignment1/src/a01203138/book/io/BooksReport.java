package a01203138.book.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a01203138.book.data.Book;


public class BooksReport {
	public static final String HEADER_FORMAT   = "%8s %-12s %-40s %-80s %4s %10s %13s %-60s";
	public static final String BOOK_FORMAT = "%8d %-12s %-40s %-80s %4d %26.3f %15d %-60s";
	
	private static final Logger Log = LogManager.getLogger();
	
	public static void write(Map<Integer, Book> books) {
		File filename = new File("book_report.txt");
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(filename);
			PrintStream out = new PrintStream(fileOut);
		
			String dash = "-";
			// Print the list customer in tabular format.
			out.println("Books Report");
			Log.info("Books Report");
			out.println(dash.repeat(200));
			Log.info(dash.repeat(200));
			out.printf(HEADER_FORMAT, "book_id", "isbn", "authors",
					"original_title", "original_publication_year", "average_rating", "ratings_count", "image_url");
			Log.info(String.format(HEADER_FORMAT, "book_id", "isbn", "authors",
					"original_title", "original_publication_year", "average_rating", "ratings_count", "image_url"));
			out.println();
			out.println(dash.repeat(200));
			Log.info(dash.repeat(200));
			for (Map.Entry<Integer, Book> book : books.entrySet()) {	
				out.printf(BOOK_FORMAT,
						book.getValue().getBook_id(), 
						book.getValue().getIsbn(),
						book.getValue().getAuthors(), 						 
						book.getValue().getOriginal_title(),
						book.getValue().getOriginal_publication_year(),
						book.getValue().getAverage_rating(), 
						book.getValue().getRatings_count(), 
						book.getValue().getImage_url()
						);
				out.println();
				Log.info(String.format(BOOK_FORMAT,
						book.getValue().getBook_id(), 
						book.getValue().getIsbn(),
						book.getValue().getAuthors(), 						 
						book.getValue().getOriginal_title(),
						book.getValue().getOriginal_publication_year(),
						book.getValue().getAverage_rating(), 
						book.getValue().getRatings_count(), 
						book.getValue().getImage_url()
						));
			}
			out.println(dash.repeat(200));
			Log.info(dash.repeat(200));
			out.close();
		} catch (FileNotFoundException e) {
			Log.error(e.getMessage());
			e.getMessage();
		}
	}
}
