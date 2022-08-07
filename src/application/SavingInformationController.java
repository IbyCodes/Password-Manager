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

public class SavingInformationController {
	
	Stage applicationStage;
	
	String Username; // created instance variable to get access of the data in scene 3, so that we can append those in the list View
	String Password; // created instance variable to get access of the data in scene 4, so that we can append those in the list View

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
		
		passwordRevealed.appendText(savingPassword.getText());
		
		
	}
	
	@FXML
	void valueSaved(ActionEvent event) throws IOException {
		// switching from scene 4 to scene 3 
		Parent root = FXMLLoader.load(getClass().getResource("AccessUsernameAndPasswordView.fxml"));
    	Scene accessGranted = new Scene(root);
    	
		Main.controller.applicationStage.setScene(accessGranted);
	}
	
	public String sendUsername() {
		
		Username = savingUsername.getText();
		
		System.out.println(Username); // for debugging
		
		return Username;
	}
	
	public String sendPassword() {
		
		Password = savingPassword.getText(); 
		
		System.out.println(Password); // for debugging

		
		return Password;
	}
	
}
