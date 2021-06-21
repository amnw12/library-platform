/**
* Enumeration holding the possible availability status for each book.
* @author Amn 19067459
**/

package library_app;

public enum Status 
{
	AVAILABLE, BORROWED, OVERDUE;
	
	@Override
	public String toString()
	{
		/**
		* toString method to print the status details as a string
		* @return a string representing the availability status.
		* @author 19067459
		* */
		
		switch(this.name())
		{
		case "AVAILABLE":
			return "AVAILABLE";
		case "BORROWED":
			return "BORROWED";
		case "OVERDUE":
			return "OVERDUE";
		}
		
		return null;
	}
}
