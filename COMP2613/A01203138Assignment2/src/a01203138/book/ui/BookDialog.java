package a01203138.book.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a01203138.book.data.Book;
import a01203138.book.data.BookDao;
import a01203138.book.sorters.BookSorter;

import net.miginfocom.swing.MigLayout;
import java.awt.Point;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class BookDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static final Logger LOG = LogManager.getLogger();


	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("static-access")
	public BookDialog(BookDao bookDao, boolean isSortedByAuthor, boolean isDescending) {
		setBounds(100, 100, 545, 300);
		setTitle("List of Books");
		getContentPane().setLayout(new MigLayout("", "[528.00px]", "[249px]"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, "cell 0 0,alignx right,growy");
		{
			String[] column = {"ID", "ISBN", "AUTHORS", "ORIGINAL_PUBLICATION_YEAR", "ORIGINAL_TITLE", "AVERAGE_RATING", "RATING_COUNT", "IMAGE_URL"};
			Map<Long, Book> books = new HashMap<>();
			Map<Long, Book> sortedBooks = new HashMap<Long, Book>();
			try {
				books = bookDao.getAllBooks();
				Collection<Book> bookCollection = books.values();
				List<Book> list = new ArrayList<>(bookCollection);
				if (isSortedByAuthor)
					Collections.sort(list, new BookSorter.CompareByAuthor());
				if (isDescending)
					Collections.sort(list, new BookSorter.CompareByAuthorDescending());
				
				long index = 0;
				for (Iterator<Book> it = list.iterator(); it.hasNext();) {
					Book book = (Book) it.next();
					sortedBooks.put(index, book);
					index++;
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				LOG.error(e1.getMessage());
			}
			
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(column);
			table = new JTable();
			table.setPreferredScrollableViewportSize(new Dimension(600, 400));
			table.setLocation(new Point(15, 0));
			
			table.setModel(model);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			
			table.setFillsViewportHeight(true);
			JScrollPane scroll = new JScrollPane(table);
			scroll.setLocation(new Point(29, 0));
			scroll.setHorizontalScrollBarPolicy(
	                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        scroll.setVerticalScrollBarPolicy(
	                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			
			for (Map.Entry<Long,Book> book : sortedBooks.entrySet()) {
				Book bk = book.getValue();
				model.addRow(new Object[] {
						String.valueOf(bk.getId()),
						bk.getIsbn(),
						bk.getAuthors(),
						bk.getYear(),
						bk.getTitle(),
						bk.getRating(),
						bk.getRatingsCount(),
						bk.getImageUrl()
				});
			}			
			contentPanel.setLayout(new MigLayout("", "[542.00px]", "[402px]"));
			contentPanel.add(scroll, "cell 0 0,alignx left,aligny top");
			contentPanel.setVisible(true);			
			
		}
	}

}
