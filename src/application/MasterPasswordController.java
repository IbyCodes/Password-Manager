package application;

import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*; // * indicates import EVERYTHING from that package
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;


public class MasterPasswordController { // created a new class for the master password conditions (to check)
	
	String masterPassword; // created a instance variable to = the password if its good enough 
	
	public Stage applicationStage;
	
	  @FXML
	  private ResourceBundle resources;

	  @FXML
	  private URL location;

	  @FXML
	  void initialize() {

	    }
	  @FXML
	  private Text MasterPassErrorText;
	  
	  @FXML
	 private PasswordField masterPassInit;

	 @FXML
	 private Button submitMasterPass;

	 @FXML
	 private PasswordField ReEnterMasterPass;
	 

	@FXML
	void MasterPasswordCheck (ActionEvent event) {
		
		
		String passwordInput = masterPassInit.toString();
		
		boolean validPassword = true;  // will intially set validPassword as true unless then there's a problem w it
		
		int uppercaseCounter = 0; // to count uppercase letters
		
		int lowercaseCounter = 0; // to count all lowercase letters
		
		int specialChar = 0;  // to count all special characters
	
		
		if (passwordInput.length()<8) {  // make sure the password length is at least 8 
			validPassword = false;
			MasterPassErrorText.setText("Your password is not long enough. Your password "
					+ "should have a length of at least 8 characters. You inputted:"+passwordInput.length() 
					+ " characters.");
		}
		
		
		for (char c: passwordInput.toCharArray()) {
			
			if (Character.isUpperCase(c)) {  // to count all uppercase letters
				uppercaseCounter = uppercaseCounter + 1;
			}
			
			if(Character.isLowerCase(c)) {  // to count all lowercase letters
				lowercaseCounter = lowercaseCounter + 1;
			}
			
			if(Character.isLetterOrDigit(c)) { // to count all special characters (not 100% sure if this works)
				specialChar = specialChar + 1;
			}
			
			
		}

		if (uppercaseCounter < 1) {
			validPassword = false;  // password is not valid 
			MasterPassErrorText.setText("Your master password must contain at least 1 uppercase letter. But you inputted:"
					+ ""+uppercaseCounter + "uppercase values.");}
			
			
		if (lowercaseCounter < 1) {
		validPassword = false;  // password is not valid 
		MasterPassErrorText.setText("Your master password must contain at least 1 lowercase letter. But you inputted:"
		+ ""+lowercaseCounter + "lowercase values.");	
		
			
		}
		
		if (specialChar < 1) {
			validPassword = false;  // password is not valid 
			MasterPassErrorText.setText("Your master password must contain at least 1 special character. But you inputted:"
					+ ""+ specialChar + " special values.");}
		
		if(ReEnterMasterPass.toString() != passwordInput) {
			validPassword = false;
			MasterPassErrorText.setText("Your master password input is not the same as the re-entry. Please try again.");
			
		}
		
		if(validPassword = true) {
			masterPassword = passwordInput;  // if the password is valid, we may use it for the masterpassword 

		}

	}

	
	

	
	
}
