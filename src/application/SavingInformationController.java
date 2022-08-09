package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller class that deals with saving the informatioon given as input by the user.
 * @author aniruddha.khan
 */

public class SavingInformationController extends AccessUsernameAndPasswordController
{
	
	Stage applicationStage;
	int showPasswordCounter = 0;
	String websiteToSave;
	String usernameToSave; // created an instance variable to get access of the data in scene 3, so that we can append those in the list View
	String passwordToSave; // created an instance variable to get access of the data in scene 4, so that we can append those in the list View
	
	CommunicateDataController data = CommunicateDataController.getInstance();

	@FXML
	private TextField savingUsername;
	
	@FXML
	private PasswordField savingPassword;
	
	@FXML
	private TextArea passwordRevealed;
	
	@FXML
	private Button showButton;
	
	@FXML
	private Button DoneButton;
	
    @FXML
    private TextField savingWebsite;
	
    
    /**
     * Method which sets the action for the "show" button in the scene which allows the user to see his/her saved password and other information associated with it
     * @param event
     * @throws IOException
     */
    
	@FXML  
	void showPassword(ActionEvent event) throws IOException 
	{
		if(showPasswordCounter == 0) 
		{ // making sure it doesn't keep appending the password in the show textfield
			passwordRevealed.appendText(savingPassword.getText());
			showPasswordCounter ++;
		}
		else 
		{
			passwordRevealed.clear();
			passwordRevealed.appendText(savingPassword.getText());	
		}
	}
	
	
	/**
	 * Method which sets the action for the "Done" button in scene 4 ( where the user enters the information )
	 * If the button is clicked it will append the information given into the listview so that the user can view them. 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void valueSaved(ActionEvent event) throws IOException // switching from scene 4 to scene 3
	{	
		passwordToSave = savingPassword.getText(); 
		data.setListOfPasswords(passwordToSave);
		
		websiteToSave = savingWebsite.getText();
		data.setListOfWebsites(websiteToSave);
		
		usernameToSave = savingUsername.getText(); 
		data.setListOfUsernames(usernameToSave);
		
		Parent root = FXMLLoader.load(getClass().getResource("AccessUsernameAndPasswordView.fxml"));
    	Scene accessGranted = new Scene(root);
		Main.controller.applicationStage.setScene(accessGranted);
		
	}
}
