package application;

import java.util.ArrayList;
import java.util.List;


// source: https://www.youtube.com/watch?v=MsgiJdf5njc&ab_channel=Randomcode


// this controller will take care of communicating most data between other controllers and saving important data

public class CommunicateDataController {

	private static final CommunicateDataController instance = new CommunicateDataController();
	
	private List<String> listOfPasswords = new ArrayList<>();
	
	private List<String> listOfUsernames =  new ArrayList<>();
	
	private List<String> listOfWebsites =  new ArrayList<>();
	
	private int listIndex;
	

	private CommunicateDataController() {
		// TODO Auto-generated constructor stub
	}

	public static CommunicateDataController getInstance() {
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

	public int getListIndex() {
		return listIndex;
	}

	public void setListIndex(int listIndex) {
		this.listIndex = listIndex;
	}
	
}