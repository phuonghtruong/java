
/**
 * Write a description of class BookStore here.
 *
 * @author Brian
 * @version 01
 */
import java.util.*;

public class BookStore
{
    // instance variables - replace the example below with your own
    private String businessName;
    private ArrayList<Book> bookList;
    private final static double discountPercentage = 0.15;
    /**
     * Constructor for objects of class BookStore
     */
    public BookStore()
    {
        // initialise instance variables
        businessName = "Book Store";
        bookList = new ArrayList <Book> ();
    }
    /**
     * constructor for objects of class BookStore
     * @para businessName
     */
    public BookStore(String businessName){
        setName(businessName);
        bookList = new ArrayList <Book> ();
    }
    /**
     * Mutator method setName
     * @para businessName to set business name of store
     */
    public void setName(String businessName){
        if(businessName != null){
            this.businessName = businessName;
        }
        else{
            throw new IllegalArgumentException("business name cannot be null"); 
        }
    }
    /** 
     * Accessor method getName
     * @return businessName
     */
    public String getName(){ return businessName;}
    /**
     * Method addBook to add book to bookList
     * @para book 
     */
    public void addBook(Book book){
        if(book != null){
            bookList.add(book);
        }
    }
    /**
     * Method getBook to display details of a book based on position index
     * @para index to set position of book in the bookList
     */
    public void getBook(int index){
        if(index >=0 && index < bookList.size()){
            Book b = bookList.get(index);
            b.displayDetails();
        }
        else{
            System.out.println("Invalid index");
        }
    }
    /**
     * Method displayBook to display details book based on title
     * @para title to set title of the book
     */
    public void displayBook(String title){
        boolean isFound = false;
        for(Book b : bookList){
            if(b.getTitle().equalsIgnoreCase(title)){
                b.displayDetails();
                isFound = true;
            }
        }
        if(!isFound){
            System.out.println("Book title is not found in the list");
        }
    }
    /**
     * Method to display all books in store
     */
    public void displayAllBooks(){
        for(Book b : bookList){
            b.displayDetails();
        }
    }
    /**
     * Method donateBook
     * @para yearPublished
     * @return numberOfDonateBook
     */
    public int donateBook(int yearPublished){
        int numberOfDonateBook = 0;
        Iterator<Book> iter = bookList.iterator();
        while(iter.hasNext()){
            Book b = iter.next();
            if(b.getYearPublished()== yearPublished){
                iter.remove();
                numberOfDonateBook++;
            }
        }
        return numberOfDonateBook;
    }
    /**
     * Method applyDiscountToBooks
     * @para beginYear
     * @para endYear
     */
    public void applyDiscountToBooks(int beginYear, int endYear){
        Iterator<Book> iter = bookList.iterator();
        while(iter.hasNext()){
            Book b = iter.next();
            if(b.getYearPublished() >= beginYear && b.getYearPublished() <= endYear){
                double newPriceInCAD = b.getBookPriceInCAD() * (1 - discountPercentage);
                b.setBookPriceInCAD(newPriceInCAD);
            }
        }
    }
    
    public static void main(String[] args){
        BookStore bookstore = new BookStore();
        Book b1 = new Book("Harry Potter", "Rowling", 1998, 39.99);
        Book b2 = new Book("Gone Girl", "Jean Kane", 2001, 36.5);
        Book b3 = new Book("The Lord of The Ring", "Steve Maiden", 1991, 65.5);
        
        bookstore.addBook(b1);
        bookstore.addBook(b2);
        bookstore.addBook(b3);
        
        bookstore.getBook(4);
        bookstore.getBook(2);
        System.out.println();
        bookstore.displayBook("Avenger");
        bookstore.displayBook("Gone Girl");
        System.out.println();
        bookstore.displayAllBooks();
        
        int yearPublished = 1995;
        System.out.println("Number of donated book published in " + yearPublished + " : " + bookstore.donateBook(yearPublished));
        yearPublished = 1991;
        System.out.println("Number of donated book published in " + yearPublished + " : " + bookstore.donateBook(yearPublished));
        
        System.out.println();
        System.out.println("******Before Discount******");
        bookstore.displayAllBooks();
        System.out.println();
        System.out.println("******After Discount******");
        bookstore.applyDiscountToBooks(1997,2005);
        bookstore.displayAllBooks();
        
    }
}
