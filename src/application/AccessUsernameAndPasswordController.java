package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * The contoller class for displaying the saved passwords
 */
public class AccessUsernameAndPasswordController extends ShowUsernameAndPasswordController
{
	Stage applicationStage;
	int counter = 0;
	int countClicks = 0; // i want to make it so theres a double click before u can get to the password page

	CommunicateDataController data = CommunicateDataController.getInstance();

    @FXML
    private Button AddPasswordButton;

    @FXML
    public ListView<String> ListOfPasswords;
    

    @FXML
    private Text refreshedPagesText;


    /**
     * Method that sets the action for "Add" button and redirects the user to a new different scene where the user can input the information that he/she wants to save
     * @param event
     * @throws IOException
     */
    
    @FXML
    void AddNewPassword(ActionEvent event) throws IOException 
    {	
    	Parent root = FXMLLoader.load(getClass().getResource("SavingInformationView.fxml"));
    	Scene addInformation = new Scene(root);
    	Main.controller.applicationStage.setScene(addInformation);
    	Main.controller.applicationStage.setTitle("Saving Username and Password");	
    }
    
    /**
     * Method which sets the action for the "Refresh" button which will refresh the list of saved passwords and information which the user inputs.
     * @param event
     */
    
    @FXML
    void refreshPage(ActionEvent event)
    {
    	counter ++;
    	if (counter>1) 
    	{
    		refreshedPagesText.setText("You already refreshed the page to its most updated values.");
    	}	
    	else 
    	{
    		ListOfPasswords.getItems().addAll(data.getListOfWebsites());
    	}
    }
    
    /**
     * Method which sets the action to show the saved password and other information associated with it. 
     * Switches the scene to the new scene where all the saved information is shown to the user
     * @throws IOException
     */
    
    @FXML
    public void clickedOnAPassword() throws IOException
    {
    	// source: https://imgur.com/a/L99ij8N
    	countClicks ++;
    	if (countClicks>1) 
    	{
    		int countingIndex = 0;
    	
    		while (!(countingIndex<0)) 
    		{ 
    			// i want the listIndex to keep reseting every time something on the list is clicked
		    	data.setListIndex(ListOfPasswords.getSelectionModel().getSelectedIndex());
		    	Parent root = FXMLLoader.load(getClass().getResource("ShowUsernameAndPassword.fxml"));
		    	Scene showInformation = new Scene(root);
		    	Main.controller.applicationStage.setScene(showInformation);
		    	Main.controller.applicationStage.setTitle("Show Information");
		    	
		    	countingIndex = -1;
		    	countClicks = 0;
		    	
    		}

    	}

    }
    
    
    @FXML
    
    /**
     * Method which sets the action to the delete any of the saved passwords 
     * Also it checks if there aren't any saved passwords it warns the user about it and asks to save a password first and then delete it.
     * @param event
     */
    
    void DeleteAPassword(ActionEvent event)
    {
    	
    	if (ListOfPasswords.getItems().isEmpty()||data.getListIndex()<0)
    	{
    		refreshedPagesText.setText("There is no password to delete! Please add a password first.");
    	}
    	
    	else
    	{
	    	data.setListIndex(ListOfPasswords.getSelectionModel().getSelectedIndex());
	    	ListOfPasswords.getItems().remove(data.getListIndex());
	    	data.getListOfPasswords().remove(data.getListIndex());
	    	data.getListOfUsernames().remove(data.getListIndex());
	    	data.getListOfWebsites().remove(data.getListIndex());
    	
    	}	
    }
    
    /**
     * Method which sets the action for the "Log Out" button. It will redirect the user to the main login window
     * If the user wants he can access the password manager by using the proper login credential
     * @param event
     * @throws IOException
     */
    
    @FXML
    void logOut(ActionEvent event) throws IOException
    {
    	 applicationStage = data.getApplicationStage();
    	 Parent root = FXMLLoader.load(getClass().getResource("VerifyMasterPasswordView.fxml"));  // changed the VBox root to Parent root to load the FXML document for the next scene
		 Scene password = new Scene(root);    // creates a new scene
		 applicationStage.setScene(password);
		 applicationStage.setTitle("VerifyMasterPassword");
		 applicationStage.show();			// makes the new scene visible on the screen
    }
}