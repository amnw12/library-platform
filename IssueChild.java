/**
* Class containing the methods and attributes specific to each book issued by an child. 
* @author Amn 19067459
**/

package library_app;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class IssueChild extends Issue
{

	public IssueChild(Book b, int i) 
	{
		/**
		* Constructor to initialize the IssueChild object
		* @param b represents the book being issued.
		* @param i an integer corresponding to the book's index in the library catalogue.
		* @author 19067459
		* */
		
		super(b, i);
		this.setDueDate(LocalDate.now());
		this.setDueDate(dueDate.plus(3, ChronoUnit.WEEKS));
	}

}
