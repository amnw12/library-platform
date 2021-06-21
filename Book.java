/**
* Class containing details of each book in the library.
* @author Amn 19067459
**/

package library_app;

public class Book implements Comparable<Book>
{
	protected String title;
	protected Author author;
	protected Genre genre;
	protected Status status;
	protected int publicationYear;
	
	public Book(String t, Author a, Genre g, Status s, int y)
	{
		/**
		* Constructor to initialize the Book object
		* @param t represents the book's title.
		* @param a represents the book's author.
		* @param g represents the book's genre.
		* @param s represents the book's availability status.
		* @param y represents the book's publication year.
		* @author 19067459
		* */
		
		this.setAuthor(a);
		this.setGenre(g);
		this.setPublicationYear(y);
		this.setStatus(s);
		this.setTitle(t);
	}

	public String getTitle() 
	{
		/**
		* get method to get the book's title.
		* @return a string representing the book's title.
		* @author 19067459
		* */
		
		return title;
	}

	public void setTitle(String title) 
	{
		/**
		* set method to set the book's title.
		* @param title a string representing the book's title.
		* @author 19067459
		* */
		
		this.title = title;
	}

	public Genre getGenre() 
	{
		/**
		* get method to get the book's genre.
		* @return a Genre representing the book's genre.
		* @author 19067459
		* */
		
		return genre;
	}

	public void setGenre(Genre genre) 
	{
		/**
		* set method to set the book's genre.
		* @param genre a Genre representing the book's title.
		* @author 19067459
		* */
		
		this.genre = genre;
	}

	public Author getAuthor() 
	{
		/**
		* get method to get the book's author.
		* @return an Author object representing the book's author.
		* @author 19067459
		* */
		
		return author;
	}

	public void setAuthor(Author author) 
	{
		/**
		* set method to set the book's author.
		* @param author an Author object representing the book's title.
		* @author 19067459
		* */
		
		this.author = author;
	}

	public Status getStatus() 
	{
		/**
		* get method to get the book's availability status.
		* @return a Status representing the book's availability status.
		* @author 19067459
		* */
		
		return status;
	}

	public void setStatus(Status status) 
	{
		/**
		* set method to set the book's availability status.
		* @param status a Status representing the book's availability status.
		* @author 19067459
		* */
		
		this.status = status;
	}

	public int getPublicationYear() 
	{
		/**
		* get method to get the book's publication year.
		* @return an integer representing the book's publication year.
		* @author 19067459
		* */
		
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) 
	{
		/**
		* set method to set the book's publication year.
		* @param publicationYear an integer representing the book's publication year.
		* @author 19067459
		* */
		
		this.publicationYear = publicationYear;
	}
	
	@Override
	public String toString()
	{
		/**
		* toString method to print the book's details as a string
		* @return a string representing the book's title, author, publication year, genre and availability status.
		* @author 19067459
		* */
		
		return this.title + "\t\t\t" + this.author + "\t\t" +this.publicationYear + "\t\t" +this.genre + "\t" +this.status;
	}

	@Override
	public int compareTo(Book o) 
	{
		/**
		* method comparing the two books' titles.
		* @param o a book to compare this book to.
		* @return -1 if this book title comes before, 1 if it comes after, or 0 if they are the same.
		* @author 19067459
		* */
		
		return this.title.compareTo(o.title);
	}
}
