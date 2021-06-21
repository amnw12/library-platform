/**
* Class containing the methods and attributes specific the user menu. Makes up the user interface. 
* @author Amn 19067459
**/

package library_app;

import java.io.*;
import java.util.Scanner;

public class UserMenu 
{
	private Library library;
	private UserDatabase users;
	private AdultUser adult;
	private ChildUser child;
	private boolean isAdult;
	private Scanner scan;
	
	public UserMenu(Library library, UserDatabase users)
	{
		/**
		* Constructor to initialize the UserMenu object
		* @param library represents the library being accessed.
		* @param users contains details of all users accessing the app.
		* @author 19067459
		* */
		
		this.setLibrary(library);
		this.setUsers(users);
		this.users.checkOverdue(library.getLibrary());
		this.scan = new Scanner(System.in);
	}

	public Library getLibrary() 
	{
		/**
		* get method to get the library.
		* @return a Library object representing the library.
		* @author 19067459
		* */
		
		return library;
	}
	
	public UserDatabase getUsers() 
	{
		/**
		* get method to get the user database.
		* @return an UserDatabase object representing the user database.
		* @author 19067459
		* */
		
		return users;
	}

	public void setUsers(UserDatabase users) 
	{
		/**
		* set method to set the user database.
		* @param users an UserDatabase object representing the user database.
		* @author 19067459
		* */
		
		this.users = users;
	}

	public void setLibrary(Library library) 
	{
		/**
		* set method to set the library.
		* @param library a Library object representing the library.
		* @author 19067459
		* */
		
		this.library = library;
	}

	public boolean isAdult() 
	{
		/**
		* get method to fetch whether the logged in user is an adult.
		* @return a boolean object representing whether the logged in user is an adult.
		* @author 19067459
		* */
		
		return isAdult;
	}

	public void setAdult(boolean isAdult) 
	{
		/**
		* set method to flag whether the logged in user is an adult.
		* @param isAdult a boolean object representing whether the logged in user is an adult.
		* @author 19067459
		* */
		
		this.isAdult = isAdult;
	}
	
	public void welcomeMessage()
	{
		/**
		* method to display the welcome message to the user.
		* @author 19067459
		* */
		
		try 
		{ // layer Scanner over FileReader instead of System.in 
			Scanner scanner = new Scanner(new FileReader("welcome.txt")); 
			while (scanner.hasNextLine()) 
			{
				String s = scanner.nextLine();
				System.out.println(s); }
				scanner.close();
		} 
		catch (IOException e) 
		{
			System.err.println("Problem with Scanner and FileReader " + e); 
		}
	}
	
	public void login()
	{
		/**
		* method to display login menu to the user.
		* @author 19067459
		* */
		
		boolean login = false;
		int choice = 0;
		String firstname;
		String lastname;
		String username;
		String password;
		String email;
		String favColour;
		
		while (!login)
		{
			try 
			{ // layer Scanner over FileReader instead of System.in 
				Scanner scanner = new Scanner(new FileReader("login.txt")); 
				while (scanner.hasNextLine()) 
				{
					String s = scanner.nextLine();
					System.out.println(s); }
					scanner.close();
				} 
			catch (IOException e) 
			{
				System.err.println("Problem with Scanner and FileReader " + e); 
			}
	
			choice = this.scan.nextInt();
		
		
			while (choice < 1 || choice > 2)
			{
				System.out.println("Error!!   Please   make   a   selection   from   the   menu   (input   1   or   2)");
				choice = this.scan.nextInt();
			}
			
			if (choice == 1)
			{
				System.out.println("\nS E L E C T    A N    A C C O U N T   T Y P E");
				System.out.println("\n\t1. ADULT");
				System.out.println("\n\t2. CHILD");
				
				choice = this.scan.nextInt();
				
				while (choice < 1 || choice > 2)
				{
					System.out.println("Error!!   Please   make   a   selection   from   the   menu   (input   1   or   2)");
					choice = this.scan.nextInt();
				}
				
				System.out.println("\n\n* * * * username * * * *:");
				username = this.scan.next();
				
				if (choice == 1)
				{
					this.setAdult(true);
					this.adult = this.users.containsUsernameAdult(username);
					
					if (this.adult == null)
					{
						System.out.println("\nError!! Username not found! \n");
					}
					else
					{
						System.out.println("\n\n* * * * password * * * *:");
						password = this.scan.next();
					
						if (this.adult.getPassword().compareToIgnoreCase(password) == 0)
						{
							System.out.println("\n\nL O G I N   S U C C E S S F U L ! \n\n\n\n\t\t\t\tLogged   in   as:\t\t" +this.adult);
							login = true;
						}
						else
						{
							System.out.println("\nPassword   failed.   Enter   your   email   to   recover   password: ");
							email = this.scan.next();
						
							System.out.println(this.adult.recoverPassword(email));
							this.adult = null;
						}
					}
				}
				else
				{
					this.setAdult(false);
					this.child = this.users.containsUsernameChild(username);
					
					if (this.child == null)
					{
						System.out.println("\n\nError!!   Username   not   found!\n");
					}
					else
					{
						System.out.println("\n\n* * * * password * * * *:");
						password = this.scan.next();
					
						if (this.child.getPassword().compareToIgnoreCase(password) == 0)
						{
							System.out.println("\n\nL O G I N   S U C C E S S F U L ! \n\n\n\n\t\t\t\tLogged   in   as:\t\t" +this.child);
							login = true;
						}
						else
						{
							System.out.println("\n\nPassword   failed.   Enter   your   favourite   colour   to   recover   password: ");
							favColour = this.scan.next();
						
							System.out.println(this.child.recoverPassword(favColour));
							this.child = null;
						}
					}
				}
			}
			else
			{
				System.out.println("\nS E L E C T    A N    A C C O U N T   T Y P E");
				System.out.println("\n\t1. ADULT");
				System.out.println("\n\t2. CHILD");
				
				choice = this.scan.nextInt();
				
				while (choice < 1 || choice > 2)
				{
					System.out.println("Error!!   Please   make   a   selection   from   the   menu   (input   1   or   2)");
					choice = this.scan.nextInt();
				}
				
				if (choice == 1)
				{
					this.setAdult(true);
					System.out.println("\nPlease   enter   your   details   below: ");
					System.out.println("\n\nFirst Name: ");
					firstname = this.scan.next();
					System.out.println("\nLast Name: ");
					lastname = this.scan.next();
					System.out.println("\nUsername: ");
					username = this.scan.next();
					System.out.println("\nPassword: ");
					password = this.scan.next();
					System.out.println("\nEmail: ");
					email = this.scan.next();
					
					this.adult = new AdultUser(firstname, lastname, username, password, email);
					this.users.addAdult(this.adult);
					System.out.println("\n\nL O G I N   S U C C E S S F U L ! \n\n\n\n\t\t\t\tLogged   in   as:\t\t" +this.adult);
					login = true;
				}
				else
				{
					this.setAdult(false);
					System.out.println("\nPlease   enter   your   details   below: ");
					System.out.println("\nFirst Name: ");
					firstname = this.scan.next();
					System.out.println("\nLast Name: ");
					lastname = this.scan.next();
					System.out.println("\nUsername: ");
					username = this.scan.next();
					System.out.println("\nPassword: ");
					password = this.scan.next();
					System.out.println("\nFavourite Colour: ");
					favColour = this.scan.next();
					
					this.child = new ChildUser(firstname, lastname, username, password, favColour);
					this.users.addChild(this.child);
					System.out.println("\n\nL O G I N   S U C C E S S F U L ! \n\n\n\n\t\t\t\tLogged   in   as:\t\t" +this.child);
					login = true;
				}
				this.users.saveDatabase();
			}
		}
		
	}
	
	
	public void userOptions()
	{
		/**
		* method to display user menu to the user once they have logged in.
		* @author 19067459
		* */
		
		boolean exit = false;
		int choice = 0;
		
		while (!exit)
		{
			try 
			{ // layer Scanner over FileReader instead of System.in 
				Scanner scanner = new Scanner(new FileReader("account.txt")); 
				while (scanner.hasNextLine()) 
				{
					String s = scanner.nextLine();
					System.out.println(s); }
					scanner.close();
				} 
			catch (IOException e) 
			{
				System.err.println("Problem with Scanner and FileReader " + e); 
			}
			
			choice = this.scan.nextInt();
			
			while (choice < 1 || choice > 5)
			{
				System.out.println("Error!!   Please   make   a   selection   from   the   menu   (input   1,   2,  3,   4   or   5)");
				choice = this.scan.nextInt();
			}
			
			if (choice == 1)
			{
				System.out.println("\nL I B R A R Y   C A T A L O G U E :\n\n" +this.library);
			}
			else if (choice == 2)
			{
				System.out.println("\nI S S U E S   L I S T :\n\n" );
				if (this.isAdult)
				{
					this.adult.printIssues();
				}
				else
				{
					this.child.printIssues();
				}
			}
			else if (choice == 3)
			{
				System.out.println("\nChoose   a   book   to   issue   from   the   library   catalouge:\n\n" );
				System.out.println("\nL I B R A R Y   C A T A L O G U E :\n\n" +this.library);
				System.out.println("\n\n\nEnter   Choice:");
				
				choice = this.scan.nextInt();
				
				while (choice < 0 || choice > 54)
				{
					System.out.println("Error!!   Please   make   a   selection   from   the   catalogue.");
					choice = this.scan.nextInt();
				}

				
				if (this.isAdult)
				{
					this.users.issue(this.adult, this.library.getElement(choice), choice, this.library.getLibrary(), true);
				}
				else
				{
					this.users.issue(this.child, this.library.getElement(choice), choice, this.library.getLibrary(), true);
				}
				
				
				this.library.saveLibrary();
				
			}
			else if (choice == 4)
			{
				System.out.println("\nChoose   a   book   to   return   from   your   issues   list:\n\n" );
				System.out.println("\nI S S U E S   L I S T :\n\n" );
				
				if (this.isAdult)
				{
					this.adult.printIssues();
				}
				else
				{
					this.child.printIssues();
				}
				
				System.out.println("\n\n\nEnter   Choice:");
				
				choice = this.scan.nextInt();
				
				if (this.isAdult)
				{
					while (choice < 0 || choice > this.adult.getIssueSize())
					{
						System.out.println("Error!!   Please   make   a   selection   from   the   catalogue.");
						choice = this.scan.nextInt();
					}
					
					this.users.Return(this.adult, this.adult.getIssueElement(choice), this.library.getLibrary());
				}
				else
				{
					while (choice < 0 || choice > this.child.getIssueSize())
					{
						System.out.println("Error!!   Please   make   a   selection   from   the   catalogue.");
						choice = this.scan.nextInt();
					}
					
					this.users.Return(this.child, this.child.getIssueElement(choice), this.library.getLibrary());
				}
				
				this.library.saveLibrary();
			}
			else 
			{	
				this.adult = null;
				this.child = null;
				exit = true;
				
				try 
				{ // layer Scanner over FileReader instead of System.in 
					Scanner scanner = new Scanner(new FileReader("exit.txt")); 
					while (scanner.hasNextLine()) 
					{
						String s = scanner.nextLine();
						System.out.println(s); }
						scanner.close();
					} 
				catch (IOException e) 
				{
					System.err.println("Problem with Scanner and FileReader " + e); 
				}
			}
		}
	}
	
	
	public void closeScanner()
	{
		/**
		* method to close the Scanner.
		* @author 19067459
		* */
		
		this.scan.close();
	}
}
