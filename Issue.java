/**
* Class containing the methods and attributes specific to each book issued by an adult. 
* @author Amn 19067459
**/

package library_app;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Issue extends Book
{
	protected LocalDate dueDate;
	protected int libraryIndex;
	
	
	public Issue(Book b, int i) 
	{
		/**
		* Constructor to initialize the Issue object
		* @param b represents the book being issued.
		* @param i an integer corresponding to the book's index in the library catalogue.
		* @author 19067459
		* */
		
		super(b.getTitle(), b.getAuthor(), b.getGenre(), b.getStatus(), b.getPublicationYear());
		this.setDueDate(LocalDate.now());
		this.setDueDate(dueDate.plus(5, ChronoUnit.WEEKS));
		this.setStatus(Status.BORROWED);;
		this.setLibraryIndex(i);
	}

	public LocalDate getDueDate() 
	{
		/**
		* get method to get the book's due date.
		* @return a LocalDate representing the book's due date.
		* @author 19067459
		* */
		
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) 
	{
		/**
		* set method to set the book's due date.
		* @param dueDate a LocalDate representing the book's due date.
		* @author 19067459
		* */
		
		this.dueDate = dueDate;
	}


	public int getLibraryIndex() 
	{
		/**
		* get method to get the index of the library catalogue where the book is stored.
		* @return an integer representing the book's library index.
		* @author 19067459
		* */
		
		return libraryIndex;
	}

	public void setLibraryIndex(int libraryIndex) 
	{
		/**
		* set method to set the index of the library catalogue where the book is stored.
		* @param libraryIndex an integer representing the book's library index.
		* @author 19067459
		* */
		
		this.libraryIndex = libraryIndex;
	}
	
	public Book getBookDetails()
	{
		/**
		* get method to get the book details of an issued item.
		* @return a Book object representing the issue's book details.
		* @author 19067459
		* */
		
		return new Book(this.title, this.author, this.genre, this.status, this.publicationYear);
	}
	
	@Override
	public String toString()
	{
		/**
		* toString method to print the issue details as a string
		* @return a string representing the book's title, author, due date and borrowing status.
		* @author 19067459
		* */
		
		return this.title + "\t\t\t" + this.author + "\t\t" +this.dueDate + "\t" +this.status;
	}
	
}
