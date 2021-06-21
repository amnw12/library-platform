/**
* Class declaring the library catalogue and containing relevant methods to access the catalogue. 
* @author Amn 19067459
**/

package library_app;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Library 
{
	private ArrayList<Book> library;
	
	
	public Library()
	{
		/**
		* Constructor to initialize the Library object
		* @author 19067459
		* */
		
		this.library = new ArrayList<Book>();
		
		this.library.add(new Book("Geek Girl\t", new Author("Holly", "Smale"), Genre.ROMANCE, Status.AVAILABLE, 2013));
		this.library.add(new Book("Model Misft\t", new Author("Holly", "Smale"), Genre.ROMANCE, Status.AVAILABLE, 2013));
		this.library.add(new Book("Geek Drama\t", new Author("Holly", "Smale"), Genre.ROMANCE, Status.AVAILABLE, 2015));
		this.library.add(new Book("Picture Perfect\t", new Author("Holly", "Smale"), Genre.ROMANCE, Status.AVAILABLE, 2014));
		this.library.add(new Book("All That Glitters", new Author("Holly", "Smale"), Genre.ROMANCE, Status.AVAILABLE, 2015));
		this.library.add(new Book("Head Over Heels\t", new Author("Holly", "Smale"), Genre.ROMANCE, Status.AVAILABLE, 2016));
		this.library.add(new Book("Forever Geek\t", new Author("Holly", "Smale"), Genre.ROMANCE, Status.AVAILABLE, 2017));
		this.library.add(new Book("The Hobbit\t", new Author("J.R.R", "Tolkien"), Genre.FANTASY, Status.AVAILABLE, 1937));
		this.library.add(new Book("Diary of a Wimpy Kid", new Author("Jeff", "Kinney"), Genre.TEEN, Status.AVAILABLE, 2007));
		this.library.add(new Book("Rodrick Rules\t", new Author("Jeff", "Kinney"), Genre.TEEN, Status.AVAILABLE, 2008));
		this.library.add(new Book("The Last Straw\t", new Author("Jeff", "Kinney"), Genre.TEEN, Status.AVAILABLE, 2009));
		this.library.add(new Book("The Ugly Truth\t", new Author("Jeff", "Kinney"), Genre.TEEN, Status.AVAILABLE, 2010));
		this.library.add(new Book("Hard luck\t", new Author("Jeff", "Kinney"), Genre.TEEN, Status.AVAILABLE, 2013));
		this.library.add(new Book("The Long Haul\t", new Author("Jeff", "Kinney"), Genre.TEEN, Status.AVAILABLE, 2014));
		this.library.add(new Book("Old School\t", new Author("Jeff", "Kinney"), Genre.TEEN, Status.AVAILABLE, 2015));
		this.library.add(new Book("Double Down\t", new Author("Jeff", "Kinney"), Genre.TEEN, Status.AVAILABLE, 2016));
		this.library.add(new Book("The Getaway\t", new Author("Jeff", "Kinney"), Genre.TEEN, Status.AVAILABLE, 2017));
		this.library.add(new Book("The Meltdown\t", new Author("Jeff", "Kinney"), Genre.TEEN, Status.AVAILABLE, 2018));
		this.library.add(new Book("Wrecking Ball\t", new Author("Jeff", "Kinney"), Genre.TEEN, Status.AVAILABLE, 2019));
		this.library.add(new Book("The Martian\t", new Author("Andy", "Weir"), Genre.SCIFI, Status.AVAILABLE, 2011));
		this.library.add(new Book("Philosopher's Stone", new Author("J.K", "Rowling"), Genre.FANTASY, Status.AVAILABLE, 1997));
		this.library.add(new Book("Chamber of Secrets", new Author("J.K", "Rowling"), Genre.FANTASY, Status.AVAILABLE, 1998));
		this.library.add(new Book("Prince of Azkaban", new Author("J.K", "Rowling"), Genre.FANTASY, Status.AVAILABLE, 1999));
		this.library.add(new Book("Goblet of Fire\t", new Author("J.K", "Rowling"), Genre.FANTASY, Status.AVAILABLE, 2000));
		this.library.add(new Book("Order of the Phoenix", new Author("J.K", "Rowling"), Genre.FANTASY, Status.AVAILABLE, 2003));
		this.library.add(new Book("Half-Blood Prince", new Author("J.K", "Rowling"), Genre.FANTASY, Status.AVAILABLE, 2005));
		this.library.add(new Book("Deathly Hallows\t", new Author("J.K", "Rowling"), Genre.FANTASY, Status.AVAILABLE, 2007));
		this.library.add(new Book("As Time Goes By\t", new Author("Carrie", "Dreamer"), Genre.ADVENTURE, Status.AVAILABLE, 2015));
		this.library.add(new Book("Matilda\t\t", new Author("Roald", "Dahl"), Genre.CHILDREN, Status.AVAILABLE, 1988));
		this.library.add(new Book("Charlotte's Web\t", new Author("E.B", "White"), Genre.CHILDREN, Status.AVAILABLE, 1952));
		this.library.add(new Book("Ender's Game\t", new Author("Orson S", "Card"), Genre.SCIFI, Status.AVAILABLE, 1985));
		this.library.add(new Book("1984\t\t", new Author("George", "Orwell"), Genre.SCIFI, Status.AVAILABLE, 1949));
		this.library.add(new Book("Angels and Demons", new Author("Dan", "Brown"), Genre.ADVENTURE, Status.AVAILABLE, 2003));
		this.library.add(new Book("The Da Vinci Code", new Author("Dan", "Brown"), Genre.ADVENTURE, Status.AVAILABLE, 2000));
		this.library.add(new Book("The Lost Symbol\t", new Author("Dan", "Brown"), Genre.ADVENTURE, Status.AVAILABLE, 2009));
		this.library.add(new Book("Inferno\t\t", new Author("Dan", "Brown"), Genre.ADVENTURE, Status.AVAILABLE, 2013));
		this.library.add(new Book("The Notebook\t", new Author("Nicholas", "Sparks"), Genre.ROMANCE, Status.AVAILABLE, 1996));
		this.library.add(new Book("Me Before You\t", new Author("Jojo", "Moyes"), Genre.ROMANCE, Status.AVAILABLE, 2012));
		this.library.add(new Book("To All The Boys\t", new Author("Jenny", "Han"), Genre.ROMANCE, Status.AVAILABLE, 2014));
		this.library.add(new Book("Alif\t\t", new Author("Umaira", "Ahmed"), Genre.ROMANCE, Status.AVAILABLE, 2019));
		this.library.add(new Book("The Witches\t", new Author("Roald", "Dahl"), Genre.CHILDREN, Status.AVAILABLE, 1983));
		this.library.add(new Book("The Giving Tree\t", new Author("Shel", "Silver"), Genre.CHILDREN, Status.AVAILABLE, 1964));
		this.library.add(new Book("The Cat in the Hat", new Author("Dr", "Seuss"), Genre.CHILDREN, Status.AVAILABLE, 1957));
		this.library.add(new Book("Peter and Wendy\t", new Author("J.M", "Barrie"), Genre.CHILDREN, Status.AVAILABLE, 1904));
		this.library.add(new Book("Holes\t\t", new Author("Louis", "Sachar"), Genre.CHILDREN, Status.AVAILABLE, 1998));
		this.library.add(new Book("The Hunger Games", new Author("Suzanne", "Collins"), Genre.ADVENTURE, Status.AVAILABLE, 2008));
		this.library.add(new Book("Catching Fire\t", new Author("Suzanne", "Collins"), Genre.ADVENTURE, Status.AVAILABLE, 2009));
		this.library.add(new Book("Mockingjay\t", new Author("Suzanne", "Collins"), Genre.ADVENTURE, Status.AVAILABLE, 2010));
		this.library.add(new Book("Divergent\t", new Author("Veronica", "Roth"), Genre.TEEN, Status.AVAILABLE, 2011));
		this.library.add(new Book("Insurgent\t", new Author("Veronica", "Roth"), Genre.TEEN, Status.AVAILABLE, 2012));
		this.library.add(new Book("Allegiant\t", new Author("Veronica", "Roth"), Genre.TEEN, Status.AVAILABLE, 2013));
		this.library.add(new Book("Four\t\t", new Author("Veronica", "Roth"), Genre.TEEN, Status.AVAILABLE, 2014));
		this.library.add(new Book("Fault In Our Stars", new Author("John", "Green"), Genre.TEEN, Status.AVAILABLE, 2012));
		this.library.add(new Book("Handmaid's Tale\t", new Author("Margaret", "Atwood"), Genre.SCIFI, Status.AVAILABLE, 1984));
		this.library.add(new Book("Lord of The Rings", new Author("J.R.R", "Tolkien"), Genre.FANTASY, Status.AVAILABLE, 1954));
		this.library.add(new Book("When Breath Becomes Air", new Author("Paul", "Kalanithi"), Genre.NONFICTION, Status.AVAILABLE, 2016));
		
		this.sortLibrary();
	}

	public ArrayList<Book> getLibrary() 
	{
		/**
		* get method to get the library catalogue.
		* @return an ArrayList<Book> representing the library catalogue.
		* @author 19067459
		* */
		
		
		return library;
	}

	public void setLibrary(ArrayList<Book> library) 
	{
		/**
		* set method to set the library catalogue.
		* @param library an ArrayList<Book> representing the library catalogue.
		* @author 19067459
		* */
		
		this.library = library;
	}
	
	public void sortLibrary()
	{
		/**
		* method to sort the library catalogue
		* @author 19067459
		* */
		
		Collections.sort(this.library);
	}
	
	public void saveLibrary()
	{
		/**
		* method to save the library catalogue to a file
		* @author 19067459
		* */
		
		try 
		{
			FileWriter out;
			out = new FileWriter("library.dat");
			out.write(this.toString());
			out.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Error: Cannot open file for writing");
		} 
		catch (IOException e) {
			System.out.println("Error: Cannot write to file");
		}
	}
	
	public void editElement(int k, Book b)
	{
		/**
		* set method to set the book stored in the ArrayList at a particular index.
		* @param k the index of the ArrayList.
		* @param b the book to store at index k.
		* @author 19067459
		* */
		
		this.library.set(k, b);
	}
	
	public Book getElement(int k)
	{
		/**
		* get method to get the book stored in the ArrayList at a particular index.
		* @param k the index of the book to fetch.
		* @return the book stored at index k.
		* @author 19067459
		* */
		
		return this.library.get(k);
	}
	
	@Override
	public String toString()
	{
		/**
		* toString method to print the library's details as a string
		* @return the whole library catalogue, containing details of each book, and it's library index.
		* @author 19067459
		* */
		
		String toPrint = "";
		
		for (int k = 0; k < this.library.size(); ++k)
		{
			toPrint += "\t" +k +"\t" +this.library.get(k) + "\n\n";
		}
		
		return toPrint;
	}
}
