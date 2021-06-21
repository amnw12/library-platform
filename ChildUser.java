/**
* Class containing the methods and attributes specific to child users of the application. 
* @author Amn 19067459
**/

package library_app;

import java.time.LocalDate;
import java.util.ArrayList;

public class ChildUser extends User
{
	private String favouriteColour;
	private ArrayList<IssueChild> issues;
	
	public ChildUser(String f, String l, String u, String p, String c)
	{
		/**
		* Constructor to initialize the ChildUser object
		* @param f represents the user's first name.
		* @param l represents the user's last name.
		* @param u represents the user's username.
		* @param p represents the user's password.
		* @param c represents the user's favourite colour.
		* @author 19067459
		* */
		
		this.setFavouriteColour(c);
		this.setFirstname(f);
		this.setLastname(l);
		this.setPassword(p);
		this.setUsername(u);
		issues = new ArrayList<IssueChild>();
	}
	
	public String getFavouriteColour() 
	{
		/**
		* get method to get the user's favourite colour.
		* @return a string representing the user's favourite colour.
		* @author 19067459
		* */
		
		return favouriteColour;
	}

	public void setFavouriteColour(String favouriteColour) 
	{
		/**
		* set method to set the user's favourite colour.
		* @param favouriteColour a string representing the user's favourite colour
		* @author 19067459
		* */
		
		this.favouriteColour = favouriteColour;
	}

	public ArrayList<IssueChild> getIssues() 
	{
		/**
		* get method to get the user's issue list.
		* @return an ArrayList<Issue> representing the user's issue list.
		* @author 19067459
		* */
		
		return issues;
	}

	public void setIssues(ArrayList<IssueChild> issues) 
	{
		/**
		* set method to set the user's issue list.
		* @param issues an ArrayList<Issue> representing the user's issue list.
		* @author 19067459
		* */
		
		this.issues = issues;
	}

	public void setIssue(int k, IssueChild i) 
	{
		/**
		* set method to set the issue stored in the ArrayList at a particular index.
		* @param k the index of the ArrayList.
		* @param i the issue to store at index k.
		* @author 19067459
		* */
		
		this.issues.set(k, i);
	}
	
	public IssueChild getIssueElement(int k)
	{
		/**
		* get method to get the issue stored in the ArrayList at a particular index.
		* @param k the index of the issue to fetch.
		* @return the issue stored at index k.
		* @author 19067459
		* */
		
		return this.issues.get(k);
	}
	
	public int getIssueSize()
	{
		/**
		* get method to get the user's total number of issues.
		* @return an integer representing the user's total number of issues.
		* @author 19067459
		* */
		
		return this.issues.size();
	}
	
	public void issue(Book b, int i, ArrayList<Book> l, boolean print)
	{
		/**
		* method to issue a book to the user.
		* @param b the book object to issue;
		* @param i the library catalogue index of the book;
		* @param l the library catalogue where book is stored;
		* @param print boolean value to determine whether or not to print issue successful message;
		* @author 19067459
		* */
		
		if (this.issues.size() < 5)
		{
			if(b.getStatus() == Status.AVAILABLE)
			{
				this.issues.add(new IssueChild(b,i));
				b.setStatus(Status.BORROWED);
				
				if (print)
				{
					System.out.println("\n\nI S S U E   S U C C E S S F U L ! \n\n\n\n" +this.issues.get(getIssueSize()-1));
				}
			}
			else
			{
				System.out.println("ERROR! You cannot issue a book that is already borrowed by someone.");
			}
			
		}
		else
		{
			System.out.println("ERROR! You cannot issue more than 5 books at a time. Please return a book to continue.");
		}
		
		l.set(i, b);
	}
	
	
	public void Return(IssueChild i, ArrayList<Book> l)
	{
		/**
		* method allowing the user to return a book .
		* @param i the issue object to return;
		* @param l the library catalogue where book is stored;
		* @author 19067459
		* */
		
		this.issues.remove(i);
		i.setStatus(Status.AVAILABLE);
		l.set(i.getLibraryIndex(), i.getBookDetails());
		System.out.println("\n\nR E T U R N   S U C C E S S F U L !");
	}
	
	public void checkOverdue(ArrayList<Book> l)
	{
		/**
		* method to check whether an book on the account is overdue.
		* @param l the library catalogue where book is stored;
		* @author 19067459
		* */
		
		LocalDate date = LocalDate.now();

		for(int k = 0; k < this.issues.size(); ++k)
		{
			IssueChild issueDetails = this.issues.get(k);
						
			if (date.compareTo(issueDetails.getDueDate()) >= 0)
			{
				issueDetails.setStatus(Status.OVERDUE);
				this.issues.set(k, issueDetails);
				l.set(issueDetails.getLibraryIndex(), issueDetails.getBookDetails());
			}
		}
	}
	
	public String recoverPassword(String c)
	{
		/**
		* method that takes in the user's favourite, and return the password to the corresponding account.
		* @param c the colour entered by the user;
		* @return either the user's password, or an error message if the colour is incorrect.
		* @author 19067459
		* */
		
		if (this.favouriteColour.compareToIgnoreCase(c)== 0)
		{
			return "Password: " +this.getPassword();
		}
		
		return "ERROR! Colour entered does not match the database.";
	}

	@Override
	public String toString()
	{
		/**
		* toString method to print the user's details as a string
		* @return a string representing the user's full name and account type.
		* @author 19067459
		* */
		
		return this.firstname + " " +this.lastname + "\t\t\t\tCHILD";
	}
	
	public void printIssues()
	{
		/**
		* method to print the user's issue list
		* @author 19067459
		* */
		
		String toPrint = "";
		
		for (int k = 0; k < this.issues.size(); ++k)
		{
			toPrint += "\t" +k +"\t" +this.issues.get(k) + "\n\n";
		}
		
		System.out.println(toPrint);
	}

}
