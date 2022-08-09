package application;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*; // * indicates import EVERYTHING from that package
import javafx.scene.text.Text;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * A controller class that handles the checking and setting of the master password for the password manager  
 */
public class MasterPasswordController 
{ // created a new class for the master password conditions (to check)
	
	 private String masterPassword; // created a instance variable to = the password if its good enough 
	
	 public Stage applicationStage;
	
	 boolean validPassword = true; // will initially set validPassword as true unless then there's a problem w it
	
	 @FXML
	 private ResourceBundle resources;

	 @FXML
	 private URL location;

	 @FXML
	 void initialize()
	 {

	 }
	 @FXML
	 private Text MasterPassErrorText;
	  
	 @FXML
	 private PasswordField masterPassInit;

	 @FXML
	 private Button submitMasterPass;

	 @FXML
	 private PasswordField ReEnterMasterPass;
	 
	 CommunicateDataController data = CommunicateDataController.getInstance();
	 
	 /**
	  * The method sets the action for the "Next-->" button 
	  * checks if the master password that has been set or not 
	  * If the password has been set correctly it switches the scene from scene 1 to scene 2 and redirects the user to the login page.
	  * Source - YouTube video link - " https://www.youtube.com/watch?v=hcM-R-YOKkQ&t=362s&ab_channel=BroCode" helped us understand the concept of switching and connecting the scenes 
	  * @throws IOException
	  */
	 
	 @FXML
	 void PasswordCheck() throws IOException   // action method created for "Next" button                                                  
	 {
		 if(validPassword == false || data.getMasterPassword() == null) 					// checks if the boolean variable is False that is if there are errors in setting the master password  
		 {
			 MasterPassErrorText.setText("Your master password has not been set yet!");
			 
		 }
		 
		 else if(data.forgotPasswordCounter > 0) 
		 {
			 applicationStage = data.getApplicationStage();
			 Parent root = FXMLLoader.load(getClass().getResource("VerifyMasterPasswordView.fxml"));  // changed the VBox root to Parent root to load the FXML document for the next scene
			 Scene password = new Scene(root);    // creates a new scene
			 applicationStage.setScene(password);
			 applicationStage.setTitle("VerifyMasterPassword");
			 applicationStage.show();			// makes the new scene visible on the screen
			 
		 }
		 
		 else										// if the password has been set and there are no errors we move to switching the scenes.
		 {
			 Parent root = FXMLLoader.load(getClass().getResource("VerifyMasterPasswordView.fxml"));  // changed the VBox root to Parent root to load the FXML document for the next scene
			 Scene password = new Scene(root);    // creates a new scene
			 applicationStage.setScene(password);
			 applicationStage.setTitle("VerifyMasterPassword");
			 applicationStage.show();			// makes the new scene visible on the screen
			 data.setApplicationStage(applicationStage);
			 

		 }
	 }
	 
	 /**
	  * Sets the action of the "Submit" button
	  * The method verifies if the conditions for setting up the master password are correct or not
	  * If there exists any errors in setting up the master password then prints an error text in the window and asks the user to set it again
	  * If the conditions are met the master passowrd gets set and the user can move on using the password and can eventually login into the app 
	  * @param event
	  */
	 
	 @FXML
	 void MasterPasswordCheck (ActionEvent event)
	 {

		String passwordInput = masterPassInit.getText();
		
		int uppercaseCounter = 0; // to count uppercase letters
		
		int lowercaseCounter = 0; // to count all lowercase letters
		
		int specialChar = 0;  // to count all special characters
		
	
		for (char c: passwordInput.toCharArray())
		{
			
			if (Character.isUpperCase(c)) // to count all uppercase letters
			{  
				uppercaseCounter = uppercaseCounter + 1;
			}
			
			if(Character.isLowerCase(c)) // to count all lowercase letters
			{  
				lowercaseCounter = lowercaseCounter + 1;
			}
			
			if(!Character.isLetterOrDigit(c)) // to count all special characters (not 100% sure if this works)
			{ 
				specialChar = specialChar + 1;
			}
			
		}
		
		if (passwordInput.length()<8) 
		{  // make sure the password length is at least 8 
			validPassword = false;
			MasterPassErrorText.setText("Your password is not long enough. Your password "
					+ "should have a length of at least 8 characters. You inputted: "+passwordInput.length() 
					+ " characters.");
		}
		
		else if(passwordInput.length()==0)
		{
			validPassword = false;
			MasterPassErrorText.setText("You didn't input anything for the master password! Please set a master password first.");
		}
		

		else if (uppercaseCounter < 1) 
		{
			validPassword = false;  // password is not valid 
			MasterPassErrorText.setText("Your master password must contain at least 1 uppercase letter. But you inputted: "
					+ ""+uppercaseCounter + " uppercase values.");
		}
			
		else if (lowercaseCounter < 1)
		{
		validPassword = false;  // password is not valid 
		MasterPassErrorText.setText("Your master password must contain at least 1 lowercase letter. But you inputted: "
		+ ""+lowercaseCounter + " lowercase values.");	
		}
		
		else if (specialChar < 1)
		{
			validPassword = false;  // password is not valid 
			MasterPassErrorText.setText("Your master password must contain at least 1 special character. But you inputted: "
					+ ""+ specialChar + " special values.");}
		
		else if(!ReEnterMasterPass.getText().equals(masterPassInit.getText()))
		{
			validPassword = false;
			MasterPassErrorText.setText("Your master password input is not the same as the re-entry. Please try again.");
			
		}

		else
		{
			data.setMasterPassword(masterPassInit.getText());  // if the password is valid, we may use it for the masterpassword 
			validPassword = true;
			MasterPassErrorText.setText("Your master password has been set!");
		}
		
	}
	 
	 
	 /**
	  * 
	  * @return It basically returns the Master password that has been set by the user so that we can use it in other classes.
	  */
	
	public String getMasterPassword() // to get the master password in any other class (in case of errors from communicatedatacointroller)
	{  
		return data.getMasterPassword();

	}
	

	
		
}
