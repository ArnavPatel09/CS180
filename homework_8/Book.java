package homework_8;
/**
 * Homework 8 - Book
 * <p>
 * The Book class is meant to resemble the details about a particular book, 
 * as well as its current stock and price in the current store.
 * 
 * @author Arnav Patel L12
 * @version October 17, 2021
 */
public class Book {
    private String bookName;
    private String authorName;
    private float price;
    private int quantity;
    private int year;

    public Book(String bookName, String authorName, float price, int quantity, int year) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.price = price;
        this.quantity = quantity;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDisplayString() {
        return String.format("%s: %s (%d)", authorName, bookName, year);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getInformationString() {
        return String.format("Book Name: %s\n" + "Book Author: %s\n" + "Year: %d\n" + "Price: $%.2f", bookName,
                authorName, year, price);
    }
}
