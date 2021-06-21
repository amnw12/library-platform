/**
* Class containing details of each book author.
* @author Amn 19067459
**/

package library_app;

public class Author 
{
	private String firstname;
	private String lastname;
	
	public Author(String f, String l)
	{
		/**
		* Constructor to initialize the Authoer object
		* @param f represents the author's first name.
		* @param l represents the author's last name.
		* @author 19067459
		* */
		
		this.setFirstname(f);
		this.setLastname(l);
	}

	public String getFirstname() 
	{
		/**
		* get method to get the author's first name.
		* @return a string representing the author's first name.
		* @author 19067459
		* */
		
		return firstname;
	}

	public void setFirstname(String firstname) 
	{
		/**
		* set method to set the author's first name.
		* @param firstname a string representing the author's first name.
		* @author 19067459
		* */
		
		this.firstname = firstname;
	}

	public String getLastname() 
	{
		/**
		* get method to get the author's last name.
		* @return a string representing the author's last name.
		* @author 19067459
		* */
		
		return lastname;
	}

	public void setLastname(String lastname) 
	{
		/**
		* set method to set the author's last name.
		* @param lastname a string representing the author's last name.
		* @author 19067459
		* */
		
		this.lastname = lastname;
	}	
	
	@Override
	
	public String toString()
	{
		/**
		* toString method to print the author's details as a string
		* @return a string representing the author's full name.
		* @author 19067459
		* */
		
		return this.firstname +" " +this.lastname;
	}
}
