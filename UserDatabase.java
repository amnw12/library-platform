/**
* Class that initializes the user database, and contains relevant methods to access the database. 
* @author Amn 19067459
**/

package library_app;

import java.io.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;

public class UserDatabase 
{
	private ArrayList<AdultUser> adults;
	private ArrayList<ChildUser> children;
	
	public UserDatabase(ArrayList<Book> l)
	{
		/**
		* Constructor to initialize the UserDatabase object
		* @param l represents the library catalouge the user's are accessing.
		* @author 19067459
		* */
		
		this.adults = new ArrayList<AdultUser>();
		this.children = new ArrayList<ChildUser>();
		
		this.adults.add(this.amn(l));	
		this.adults.add(this.blossom(l));
		this.adults.add(this.bubbles(l));
		this.adults.add(this.buttercup(l));
		this.adults.add(this.brick(l));
		this.adults.add(this.boomer(l));
		this.adults.add(this.butch(l));
		this.adults.add(this.khaula(l));
		
		this.children.add(this.dasher(l));
		this.children.add(this.bryce(l));
		this.children.add(this.rosie(l));
		this.children.add(this.lily(l));
		
		this.sortDatabase();
	}
	
	public void addAdult(AdultUser a)
	{
		/**
		* add method to add an AdultUser to the library database.
		* @param a the AdultUser to add to the database.
		* @author 19067459
		* */
		
		this.adults.add(a);
	}
	
	public void addChild(ChildUser c)
	{
		/**
		* add method to add an ChildUser to the library database.
		* @param c the ChildUser to add to the database.
		* @author 19067459
		* */
		
		this.children.add(c);
	}
	
	public AdultUser getAdult(int k)
	{
		/**
		* get method to get the AdultUser stored in the ArrayList at a particular index.
		* @param k the index of the AdultUser to fetch.
		* @return the AdultUser stored at index k.
		* @author 19067459
		* */
		
		return this.adults.get(k);
	}
	
	public ChildUser getChild(int k)
	{
		/**
		* get method to get the ChildUser stored in the ArrayList at a particular index.
		* @param k the index of the ChildUser to fetch.
		* @return the ChildUser stored at index k.
		* @author 19067459
		* */
		
		return this.children.get(k);
	}
	
	
	public AdultUser containsUsernameAdult(String u)
	{
		/**
		* search method to get the AdultUser with a particular username.
		* @param u the username to search database with.
		* @return the AdultUser with the username, or null if no match found.
		* @author 19067459
		* */
		
		AdultUser adultUser;

		
		for (int k = 0; k < this.adults.size();++k)
		{
			adultUser = this.adults.get(k);
			if (adultUser.getUsername().compareToIgnoreCase(u) == 0)
			{
				return adultUser;
			}
		}
		
		return null;
	}
	
	public ChildUser containsUsernameChild(String u)
	{
		/**
		* search method to get the ChildUser with a particular username.
		* @param u the username to search database with.
		* @return the ChildUser with the username, or null if no match found.
		* @author 19067459
		* */
		
		ChildUser childUser;
		
		for (int k = 0; k < this.children.size();++k)
		{
			childUser = this.children.get(k);
			if (childUser.getUsername().compareToIgnoreCase(u) == 0)
			{
				return childUser;
			}
		}
		
		return null;
	}
	
	
	public void issue(AdultUser u, Book b, int i, ArrayList<Book> l, boolean p)
	{
		/**
		* method to issue a book to an adult user in the database.
		* @param u the user to issue the book.
		* @param b the book object to issue;
		* @param i the library catalogue index of the book;
		* @param l the library catalogue where book is stored;
		* @param print boolean value to determine whether or not to print issue successful message;
		* @author 19067459
		* */
		
		int k = this.adults.indexOf(u);
		u.issue(b, i, l, p);
		this.adults.set(k, u);
	}
	
	public void issue(ChildUser u, Book b, int i, ArrayList<Book> l, boolean p)
	{
		/**
		* method to issue a book to a child user in the database.
		* @param u the user to issue the book.
		* @param b the book object to issue;
		* @param i the library catalogue index of the book;
		* @param l the library catalogue where book is stored;
		* @param print boolean value to determine whether or not to print issue successful message;
		* @author 19067459
		* */
		
		int k = this.children.indexOf(u);
		u.issue(b, i, l, p);
		this.children.set(k, u);
	}
	
	public void printIssues(AdultUser u)
	{
		/**
		* method to print an adult user's issue list from the database
		* @param u the user details.
		* @author 19067459
		* */
		
		int k = this.adults.indexOf(u);
		u = this.getAdult(k);
		u.printIssues();
	}
	
	public void printIssues(ChildUser u)
	{
		/**
		* method to print a child user's issue list from the database
		* @param u the user details.
		* @author 19067459
		* */
		
		int k = this.children.indexOf(u);
		u = this.getChild(k);
		u.printIssues();
	}
	
	public void Return(AdultUser u, Issue i, ArrayList<Book> l)
	{
		/**
		* method allowing an adult user in the database to return a book .
		* @param u the user to return the book from;
		* @param i the issue object to return;
		* @param l the library catalogue where book is stored;
		* @author 19067459
		* */
		
		int k = this.adults.indexOf(u);
		u.Return(i, l);
		this.adults.set(k, u);
	}
	
	public void Return(ChildUser u, IssueChild i, ArrayList<Book> l)
	{
		/**
		* method allowing a child user in the database to return a book .
		* @param u the user to return the book from;
		* @param i the issue object to return;
		* @param l the library catalogue where book is stored;
		* @author 19067459
		* */
		
		int k = this.children.indexOf(u);
		u.Return(i, l);
		this.children.set(k, u);
	}
	
	public void checkOverdue(ArrayList<Book> l)
	{
		/**
		* method to check whether any books issues in the database are overdue.
		* @param l the library catalogue where books are stored;
		* @author 19067459
		* */
		
		AdultUser adult;
		ChildUser child;
		
		for(int k = 0; k < this.adults.size(); ++k)
		{
			adult = this.adults.get(k);
			adult.checkOverdue(l);
			this.adults.set(k, adult);
		}
		
		for(int k = 0; k < this.children.size(); ++k)
		{
			child = this.children.get(k);
			child.checkOverdue(l);
			this.children.set(k, child);
		}
	}
	
	public void saveDatabase()
	{
		/**
		* method to save the user database to a file
		* @author 19067459
		* */
		
		try 
		{
			FileWriter out;
			out = new FileWriter("userDatabase.dat");
			this.sortDatabase();
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
	
	public void sortDatabase()
	{
		/**
		* method to sort the user database.
		* @author 19067459
		* */
		
		Collections.sort(this.adults);
		Collections.sort(this.children);
	}
	
	@Override 
	public String toString()
	{
		/**
		* toString method to print the user database as a string
		* @return the user database, containing details of each user, and their database index.
		* @author 19067459
		* */
		
		String toPrint = "";
		
		for (int k = 0; k < this.adults.size(); ++k)
		{
			toPrint += k +"\t" +this.adults.get(k) + "\n\n";
		}
		
		for (int k = 0; k < this.children.size(); ++k)
		{
			toPrint += (k + this.adults.size()) +"\t" +this.children.get(k) + "\n\n";
		}
		
		return toPrint;
	}
	
	private AdultUser amn(ArrayList<Book> l)
	{
		/**
		* method to create and initialize the AdultUser amn.
		* @param l the library catalogue where books are stored;
		* @return the AdultUser amn.
		* @author 19067459
		* */
		
		AdultUser amn = new AdultUser("Amn", "Waqar", "amnw12", "12345", "amn.waqar@gmail.com");
		amn.issue(l.get(5), 5, l, false) ;
		amn.issue(l.get(7), 7, l, false);
		amn.issue(l.get(15), 15, l, false);
		
		return amn;
	}
	
	private AdultUser blossom(ArrayList<Book> l)
	{
		/**
		* method to create and initialize the AdultUser blossom.
		* @param l the library catalogue where books are stored;
		* @return the AdultUser blossom.
		* @author 19067459
		* */
		
		AdultUser blossom = new AdultUser("Blossom", "Utonium", "pinkice", "pinky", "bmu@ppg.com");
		blossom.issue(l.get(18), 18, l, false);
		blossom.issue(l.get(40), 40, l, false);
		blossom.issue(l.get(9), 9, l, false);
		
		return blossom;
	}
	
	private AdultUser bubbles(ArrayList<Book> l)
	{
		/**
		* method to create and initialize the AdultUser bubbles.
		* @param l the library catalogue where books are stored;
		* @return the AdultUser bubbles.
		* @author 19067459
		* */
		
		AdultUser bubbles = new AdultUser("Bubbles", "Utonium", "bluerain", "angel", "bau@ppg.com");
		bubbles.issue(l.get(29), 29, l, false);
		bubbles.issue(l.get(53), 53, l, false);
		
		return bubbles;
	}
	
	private AdultUser buttercup(ArrayList<Book> l)
	{
		/**
		* method to create and initialize the AdultUser buttercup.
		* @param l the library catalogue where books are stored;
		* @return the AdultUser buttercup.
		* @author 19067459
		* */
		
		AdultUser buttercup = new AdultUser("BC", "Utonium", "greenshadow", "butterbabe", "beu@ppg.com");
		buttercup.issue(l.get(21), 21, l, false);
		
		return buttercup;
	}
	
	private AdultUser brick(ArrayList<Book> l)
	{
		/**
		* method to create and initialize the AdultUser brick.
		* @param l the library catalogue where books are stored;
		* @return the AdultUser brick.
		* @author 19067459
		* */
		
		AdultUser brick = new AdultUser("Brick", "Jojo", "crimsonfire", "ruff", "baj@ppg.com");
		brick.issue(l.get(0), 0, l, false);
		brick.issue(l.get(48), 48, l, false);
		brick.issue(l.get(47), 47, l, false);
		brick.issue(l.get(4), 4, l, false);
		
		return brick;
	}
	
	private AdultUser boomer(ArrayList<Book> l)
	{
		/**
		* method to create and initialize the AdultUser boomer.
		* @param l the library catalogue where books are stored;
		* @return the AdultUser boomer.
		* @author 19067459
		* */
		
		AdultUser boomer = new AdultUser("Boomer", "Jojo", "bluelightning", "knight", "bkj@ppg.com");
		boomer.issue(l.get(27), 27, l, false);
		
		return boomer;
	}
	
	private AdultUser butch(ArrayList<Book> l)
	{
		/**
		* method to create and initialize the AdultUser butch.
		* @param l the library catalogue where books are stored;
		* @return the AdultUser butch.
		* @author 19067459
		* */
		
		AdultUser butch = new AdultUser("Butch", "Jojo", "greenshield", "asswipe", "bjj@ppg.com");
		butch.issue(l.get(55), 55, l, false);
		
		Issue issue = butch.getIssueElement(0);
		issue.setDueDate(issue.getDueDate().minus(6, ChronoUnit.WEEKS));
		
		butch.setIssue(0, issue);
		return butch;
	}
	
	private AdultUser khaula(ArrayList<Book> l)
	{
		/**
		* method to create and initialize the AdultUser khaula.
		* @param l the library catalogue where books are stored;
		* @return the AdultUser khaula.
		* @author 19067459
		* */
		
		AdultUser khaula = new AdultUser("Khaula", "Alizai", "khaula", "alixai", "k.alizai@autuni.ac.nz");
		khaula.issue(l.get(1), 1, l, false);
		
		return khaula;
	}
	
	private ChildUser dasher(ArrayList<Book> l)
	{
		/**
		* method to create and initialize the ChildUser dasher.
		* @param l the library catalogue where books are stored;
		* @return the ChildUser dasher.
		* @author 19067459
		* */
		
		ChildUser dasher= new ChildUser("Dasher", "Jojo","djrox", "blue", "blue");
		dasher.issue(l.get(8), 8, l, false);
		dasher.issue(l.get(28), 28, l, false);
		
		return dasher;
	}
	
	private ChildUser bryce(ArrayList<Book> l)
	{
		/**
		* method to create and initialize the ChildUser bryce.
		* @param l the library catalogue where books are stored;
		* @return the ChildUser bryce.
		* @author 19067459
		* */
		
		ChildUser bryce = new ChildUser("Bryce", "Jojo","shyguy", "buj", "green");
		
		return bryce;
	}
	
	private ChildUser rosie(ArrayList<Book> l)
	{
		/**
		* method to create and initialize the ChildUser rosie.
		* @param l the library catalogue where books are stored;
		* @return the ChildUser rosie.
		* @author 19067459
		* */
		
		ChildUser rosie = new ChildUser("Rosie", "Jojo","flowergarden", "rose", "red");
		
		return rosie;
	}
	
	private ChildUser lily(ArrayList<Book> l)
	{
		/**
		* method to create and initialize the ChildUser lily.
		* @param l the library catalogue where books are stored;
		* @return the ChildUser lily.
		* @author 19067459
		* */
		
		ChildUser lily = new ChildUser("Lily", "Jojo","lily", "bunny", "pink");
		
		return lily;
	}

}
