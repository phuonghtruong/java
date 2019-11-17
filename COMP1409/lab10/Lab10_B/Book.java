
/**
 * Write a description of class Book here.
 *
 * @author Brian
 * @version 01
 */
public class Book
{
    // instance variables - replace the example below with your own
    private String title;
    private String author;
    private int yearPublished;
    private double bookPriceInCAD;

    /**
     * Constructor for objects of class Book
     */
    public Book()
    {
        // initialise instance variables
        title = "unknown";
        author = "unknown";
        yearPublished = 0;
        bookPriceInCAD = 0.0;
    }
    /**
     * Constructor for objects of class Book
     * @para title to set title
     * @para author to set author
     * @para yearPublished to set year published
     * @para bookPriceInCAD to set book price in CAD
     */
    public Book(String title, String author, 
                int yearPublished, double bookPriceInCAD){
        setTitle(title);
        setAuthor(author);
        setYearPublished(yearPublished);
        setBookPriceInCAD(bookPriceInCAD);
    }
    /**
     * Mutator method to setTitle
     * @para title to set title of book
     */
    public void setTitle(String title){
        if(title != null){
            this.title = title;
        }
        else{
            throw new IllegalArgumentException("title can not be null");
        }
    }
    /**
     * Accessor method to getTitle
     * @return title
     */
    public String getTitle(){ return title;}
    
    /**
     * Mutator method to setAuthor
     * @para author to set author of book
     */
    public void setAuthor(String author){
        if(author != null){
            this.author = author;
        }
        else{
            throw new IllegalArgumentException("author cannot be null");
        }
    }
    /**
     * Accessor method getAuthor
     * @return author
     */
    public String getAuthor(){ return author;}
    
    /**
     * Mutator method to set year published
     * @para yearPublished to set year published
     */
    public void setYearPublished(int yearPublished){
        if(yearPublished <= 0){
            throw new IllegalArgumentException("year published cannot be negative");
        }
        else{
            this.yearPublished = yearPublished;
        }
    }
    /**
     * Accessor method to get year published
     * @return yearPublished
     */
    public int getYearPublished(){ return yearPublished;}
    /**
     * Mutator method to set book price in CAD
     * @para bookPriceInCAD to set book price in CAD
     */
    public void setBookPriceInCAD(double bookPriceInCAD){
        if(bookPriceInCAD >= 0){
            this.bookPriceInCAD = bookPriceInCAD;
        }
        else{
            throw new IllegalArgumentException("book price cannot be negative");
        }
    }
    /**
     * Accessor method to getBookPriceInCAD
     * @return bookPriceInCAD
     */
    public double getBookPriceInCAD(){ return bookPriceInCAD;}
    
    public void displayDetails(){
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Year Published: " + getYearPublished());
        System.out.println("Book Price: " + getBookPriceInCAD());
    }
}
