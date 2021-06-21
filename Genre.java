/**
* Enumeration containing the different genre options for a book. 
* @author Amn 19067459
**/

package library_app;

public enum Genre 
{
	TEEN, CHILDREN, ROMANCE, SCIFI, FANTASY, ADVENTURE, NONFICTION;
	
	@Override
	public String toString()
	{
		/**
		* toString method to print the genre details as a string
		* @return a string representing the book's genre.
		* @author 19067459
		* */
		
		switch(this.name())
		{
		case "TEEN":
			return "TEEN    ";
		case "CHILDREN":
			return "CHILDREN";
		case "ROMANCE":
			return "ROMANCE ";
		case "SCIFI":
			return "SCI-FI  ";
		case "FANTASY":
			return "FANTASY ";
		case "ADVENTURE":
			return "ADVENTURE";
		case "NONFICTION":
			return "NON FICTION";
		}
		
		return null;
	}
}
