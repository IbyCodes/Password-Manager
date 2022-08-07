package application;

import java.util.ArrayList;
import java.util.List;


// source: https://www.youtube.com/watch?v=MsgiJdf5njc&ab_channel=Randomcode

public class DataSingleton {

	private static final DataSingleton instance = new DataSingleton();
	
	private List<String> listOfPasswords = new ArrayList<>();
	
	private List<String> listOfUsernames =  new ArrayList<>();
	
	private List<String> listOfWebsites =  new ArrayList<>();
	

	private DataSingleton() {
		// TODO Auto-generated constructor stub
	}

	public static DataSingleton getInstance() {
		return instance;
	}
	
	
	public List<String> getListOfPasswords() {
		return listOfPasswords;
	}

	public void setListOfPasswords(String password) {
		
		this.listOfPasswords.add(password);
		
	}

	public void setListOfWebsites(String websiteToSave) {
		this.listOfWebsites.add(websiteToSave);
		
	}
	
	public List<String> getListOfWebsites() {
		return listOfWebsites;
	}
	
	public void setListOfUsernames(String usernameToSave) {
		this.listOfUsernames.add(usernameToSave);
		
	}
	
	public List<String> getListOfUsernames() {
		return listOfUsernames;
	}
	
}
