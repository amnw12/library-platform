/**
* Class containing the main method which executes the app interface; 
* @author Amn 19067459
**/

package library_app;


public class LibraryApp 
{
	public static void main(String[] args)
	{
		/**
		* Main method to run the app and present the user interface.
		* @author 19067459
		* */
		
		Library library = new Library();
		library.saveLibrary();
		UserDatabase users = new UserDatabase(library.getLibrary());
		users.saveDatabase();
		library.saveLibrary();
		UserMenu menu = new UserMenu(library, users);
		
		
		menu.welcomeMessage();
		menu.login();
		menu.userOptions();
		menu.closeScanner();
	}
}
