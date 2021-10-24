package homework_8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 * Homework 8 - StoreCatalog
 * <p>
 * StoreCatalog represents the catalog of books held by a bookstore. 
 * Operations such as purchases and book searches are handled here. 
 * Furthermore, information is read from a file in the beginning of
 * the program, and saved back to the file at the end of the program.
 * @author Arnav Patel L12
 * @version October 17, 2021
 */
public class StoreCatalog {
	private ArrayList<Book> books;
	private String fileName;
	
	public StoreCatalog(String fileName) throws java.io.FileNotFoundException, BookParseException { 
		this.fileName = fileName;
		books = new ArrayList<Book>();
		FileReader fr = new FileReader(fileName);
        BufferedReader bfr = new BufferedReader(fr);
        try {
        	String line = bfr.readLine();
            while (line != null) { 
            	Book b = parseBook(line);
            	books.add(b);
            	line = bfr.readLine();
            }
            bfr.close();	
        } catch (java.io.FileNotFoundException e) { 
        	e.printStackTrace();
        } catch (IOException e) {
        	throw new BookParseException(e.getMessage());
        } finally { 
        	if (bfr != null) { 
        		try { 
        			bfr.close();
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
        	}
        }
	}
	
	public ArrayList<Book> getBookList() { 
		return books;
	}
	
	private static Book parseBook(String line) throws BookParseException { 
		//handles the parsing of the individual lines read by the StoreCatelog constructor
		try {
			String bookName = "";
	        String authorName = "";
	        float price = 0;
	        int quantity = 0;
	        int year = 0;
	        int underScore = 0;
	        int endSub = 0;
	        
			endSub = line.indexOf(" ");
	    	bookName = line.substring(0, endSub);
	    	line = line.substring(endSub + 1);
	    	while (bookName.contains("_")) {
	    		underScore = bookName.indexOf("_");
		    	if (underScore != -1) { 
		    		bookName = bookName.substring(0, underScore) + " " + bookName.substring(underScore + 1);
		    	}
	    	}
	    	
	    	
	    	endSub = line.indexOf(" ");
	    	authorName = line.substring(0, endSub);
	    	line = line.substring(endSub + 1);
	    	while (authorName.contains("_")) {
	    		underScore = authorName.indexOf("_");
		    	if (underScore != -1) { 
		    		authorName = authorName.substring(0, underScore) + " " + authorName.substring(underScore + 1);
		    	}
	    	}
	    	
	    	endSub = line.indexOf(" ");
	    	price = Float.valueOf(line.substring(0, endSub));
	    	line = line.substring(endSub + 1);
	    	
	    	endSub = line.indexOf(" ");
	    	quantity = Integer.valueOf(line.substring(0, endSub));
	    	line = line.substring(endSub + 1);
	    	
	    	year = Integer.valueOf(line);
	    	
	    	Book b = new Book (bookName, authorName, price, quantity, year);
	    	return b;
	    	//return new Book(bookName, authorName, price, quantity, year); 
		} catch (java.lang.NumberFormatException e) {
			throw new BookParseException("Error parsing book! Failed to parse numbers from file");
		} catch (IndexOutOfBoundsException e) {
			throw new BookParseException("Error parsing book! Data provided in a single line is invalid!");
		} catch (NullPointerException e) {
			throw new BookParseException("Error parsing book! Failed to parse numbers from file");
		}
	}
	
	public void purchaseBook(String bookName) throws BookNotFoundException { 
		//Purchases a book with the exact same name as the given b ookName.
		int found = 0;
		for (Book i : books) {
			if (i.getBookName().equals(bookName) ) { 
				i.setQuantity(i.getQuantity() - 1);
				found++;
				if (i.getQuantity() == 0) { 
					books.remove(i);
				}
			}
			if (found == 1) {
				break;
			}
		}
		if (found == 0) { 
			throw new BookNotFoundException("The given book was not found.");
		}
	}
	
	public ArrayList<Book> searchByAuthor(String authorName) throws BookNotFoundException { 
		//Creates an ArrayList of all the books in ArrayList books which contain the given author name (ignoring case).
		ArrayList<Book> list = new ArrayList<Book>();
		for (Book i : books) { 
			if (i.getAuthorName().toLowerCase().contains(authorName.toLowerCase())) {
				list.add(i);
			}
		}
		if (list.size() == 0) { 
			throw new BookNotFoundException("No books found with the given author name!");
		}
		
		return list;
	}
	
	public ArrayList<Book> searchByName(String bookName) throws BookNotFoundException {
		//Creates an ArrayList of all the books in ArrayList books which contain the given book name (ignoring case).
		ArrayList<Book> list = new ArrayList<Book>();
		for (Book i : books) { 
			if (i.getBookName().toLowerCase().contains(bookName.toLowerCase())) { 
				list.add(i);
			}
		}
		if (list.size() == 0) {
			throw new BookNotFoundException("No books found with the given book name!");
		}
		
		return list;
	}
	public void writeChangesToFile() throws java.io.FileNotFoundException {
		//Called to save all the changes made, by rewriting the current file with the new book details.
		// re write the entire file
		// go through each part of book (e.g. name)
		// and append it (to the same line)
		// and make sure to sub spaces with underscores
		
		// after all 5 items have been added u append to a new line.
		// can accomplish this by adding everything to a string called line
		// and then doing .append(line) or something of that sort
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
	    	PrintWriter pw = new PrintWriter(fos);
			String element = "";
			float price = 0;
			int elementNum = -1;
			String line = "";
			int index = -1;
			for (Book i : books) {
				element = i.getBookName();
				while (element.contains(" ")) {
					index = element.indexOf(" ");
					element = element.substring(0, index) + "_" + element.substring(index + 1);
				}
				line = element;
				element = i.getAuthorName();
				while (element.contains(" ")) { 
					index = element.indexOf(" ");
					element = element.substring(0, index) + "_" + element.substring(index + 1);
				}
				line += " " + element;
				price = i.getPrice();
				line += " " + price;
				elementNum = i.getQuantity();
				line += " " + elementNum;
				elementNum = i.getYear();
				line += " " + elementNum;
				
				//add to the file
				pw.println(line);
			}
			pw.close();

		} catch (java.io.FileNotFoundException e) {
			throw new java.io.FileNotFoundException();
		}
	}
}
