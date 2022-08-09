package application;

import java.util.ArrayList;
import java.util.List;

import javafx.stage.Stage;


// source: https://www.youtube.com/watch?v=MsgiJdf5njc&ab_channel=Randomcode

/**
 * this controller will take care of communicating most data between other controllers and saving important data
 * @author aniruddha.khan
 *
 */

public class CommunicateDataController 
{
	private static final CommunicateDataController instance = new CommunicateDataController();
	
	private List<String> listOfPasswords = new ArrayList<>();
	
	private List<String> listOfUsernames =  new ArrayList<>();
	
	private List<String> listOfWebsites =  new ArrayList<>();
	
	private int listIndex;
	
	private Stage applicationStage;
	
	private String masterPassword;
	
	public int forgotPasswordCounter = 0;

	private CommunicateDataController()
	{
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * A getter method that obtains the instance of the class 
	 * @return It basically returns the instance of the class created above 
	 */
	
	public static CommunicateDataController getInstance() 
	{
		return instance;
	}
	
	
	/**
	 * Getter method that obtains the arraylist of the passwords saved by the user
	 * @return It returns the array list containing all the passwords saved by the user
	 */
	
	public List<String> getListOfPasswords()
	{
		return listOfPasswords;
	}


	/**
	 * Setter method that sets the parameter with the list of passwords as given by the user
	 * @param password
	 */
	
	public void setListOfPasswords(String password)
	{
		this.listOfPasswords.add(password);	
	}

	/**
	 * Setter method that sets the parameter websiteToSave with the list of all the websites as given by the user
	 * @param websiteToSave
	 */
	
	public void setListOfWebsites(String websiteToSave)
	{
		this.listOfWebsites.add(websiteToSave);	
	}
	
	/**
	 * Getter method that obtains the list of website names that the user enters 
	 * @return It returns the list of names of all the wbesites as given by the user
	 */
	
	public List<String> getListOfWebsites()
	{
		return listOfWebsites;
	}
	
	/**
	 * Setter method that sets list of usernames the user wants to save
	 * @param usernameToSave
	 */
	
	public void setListOfUsernames(String usernameToSave)
	{
		this.listOfUsernames.add(usernameToSave);
	}
	
	/**
	 * Getter method that obtains the list of all the usernames given by the user
	 * @return It returns the list of all the usernames given by the user
	 */
	public List<String> getListOfUsernames() 
	{
		return listOfUsernames;
	}
	
	/**
	 * Getter method that obtains the index number of the list in which the passwords get saved 
	 * @return It returns the integer value of the list index
	 */

	public int getListIndex()
	{
		return listIndex;
	}
	
	/**
	 * setter method that sets the value of the index to the parameter "list index"
	 * @param listIndex
	 */
	
	public void setListIndex(int listIndex)
	{
		this.listIndex = listIndex;
	}
	
	/**
	 * Getter method that obtains the obtains the application stage 
	 * @return It returns the application stage 
	 */
	
	public Stage getApplicationStage()
	{
		return applicationStage;
	}

	/**
	 * Setter method that sets the value application stage to the parameter 
	 * @param applicationStage
	 */
	
	public void setApplicationStage(Stage applicationStage) 
	{
		this.applicationStage = applicationStage;
	}


	/**
	 * getter method that obtains the master password 
	 * @return It returns the master password
	 */
	
	public String getMasterPassword()
	{
		return masterPassword;
	}

	/**
	 * setter method that sets the master password to the parameter passed into the function.
	 * @param masterPassword
	 */
	
	public void setMasterPassword(String masterPassword) 
	{
		this.masterPassword = masterPassword;
	}
	
}
