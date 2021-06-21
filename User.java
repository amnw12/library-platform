/**
* Abstract  lass containing the methods and attributes specific to a generic user. 
* @author Amn 19067459
**/

package library_app;

public abstract class User implements Comparable<User>
{
	protected String firstname;
	protected String lastname;
	protected String username;
	protected String password;
	
	public String getFirstname() 
	{
		/**
		* get method to get the user's first name.
		* @return a string representing the user's first name.
		* @author 19067459
		* */
		
		return firstname;
	}
	public void setFirstname(String firstname) 
	{
		/**
		* set method to set the user's first name.
		* @param firstname a string representing the user's first name.
		* @author 19067459
		* */
		
		this.firstname = firstname;
	}
	public String getUsername() 
	{
		/**
		* get method to get the user's username.
		* @return a string representing the user's username.
		* @author 19067459
		* */
		
		return username;
	}
	public void setUsername(String username) 
	{
		/**
		* set method to set the user's username.
		* @param firstname a string representing the user's username.
		* @author 19067459
		* */
		
		this.username = username;
	}
	public String getLastname() 
	{
		/**
		* get method to get the user's last name.
		* @return a string representing the user's last name.
		* @author 19067459
		* */
		
		return lastname;
	}
	public void setLastname(String lastname) 
	{
		/**
		* set method to set the user's last name.
		* @param firstname a string representing the user's last name.
		* @author 19067459
		* */
		
		this.lastname = lastname;
	}
	public String getPassword() 
	{
		/**
		* get method to get the user's password.
		* @return a string representing the user's password.
		* @author 19067459
		* */
		
		return password;
	}
	public void setPassword(String password) 
	{
		/**
		* set method to set the user's password.
		* @param firstname a string representing the user's password.
		* @author 19067459
		* */
		
		this.password = password;
	}
	
	@Override
	public int compareTo(User o)
	{
		/**
		* method comparing the two users' first names.
		* @param o a user to compare this user to.
		* @return -1 if this user firstname comes before, 1 if it comes after, or 0 if they are the same.
		* @author 19067459
		* */
		
		return this.firstname.compareTo(o.firstname);
	}
	
}
