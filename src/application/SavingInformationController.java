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

public class SavingInformationController extends AccessUsernameAndPasswordController{
	
	Stage applicationStage;
	
	int showPasswordCounter = 0;
	
	String websiteToSave;
	String usernameToSave; // created instance variable to get access of the data in scene 3, so that we can append those in the list View
	String passwordToSave; // created instance variable to get access of the data in scene 4, so that we can append those in the list View
	
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
	
	@FXML  
	void showPassword(ActionEvent event) throws IOException {
		
		if(showPasswordCounter == 0) { // making sure it doesn't keep appending the password in the show textfield
		passwordRevealed.appendText(savingPassword.getText());
		showPasswordCounter ++;
		}
		
		else {
			passwordRevealed.clear();
			passwordRevealed.appendText(savingPassword.getText());
			
		}
		
		
	}
	
	
	
	@FXML
	void valueSaved(ActionEvent event) throws IOException {
		// switching from scene 4 to scene 3 
		
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
