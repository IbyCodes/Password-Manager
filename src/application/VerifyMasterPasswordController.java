package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;

/**
 * Controller class to operate the login page of the password manager and verifies the master password that the user just created to access the password manager. 
 */
public class VerifyMasterPasswordController 
{
    @FXML
    private PasswordField VerifyMasterPasswordField;

    @FXML
    private Text UnlockManagerPassError;

    /**
     * Method that sets the action for the "Submit" button 
     * If the password matches with the password that has been set it will redirect the user to the next scene where the user can start saving passwords
     * If the password doesn't match then the corresponding error message gets displayed on the window
     * @param event
     * @throws IOException
     */
    
    @FXML
    void VerifyMasterPass(ActionEvent event) throws IOException
    {	
    	String inputToCheck = VerifyMasterPasswordField.getText();	
		if(inputToCheck.equals(Main.controller.getMasterPassword())) // comparing created masterPassword to the verifyMasterPassword
		{ 
    		Parent root = FXMLLoader.load(getClass().getResource("AccessUsernameAndPasswordView.fxml"));
    		Scene accessGranted = new Scene(root);
    		Main.controller.applicationStage.setScene(accessGranted);
    		Main.controller.applicationStage.setTitle("AccessUsernameAndPassword");
    	}
    	
    	else 
    	{	
    		UnlockManagerPassError.setText("The master password input is incorrect. Try again.");
    	}
    }
    
    CommunicateDataController data = CommunicateDataController.getInstance();
    
    /**
     * Method that sets the action for "Forgot Your Password" button 
     * In case if the user forgets the master password for the Password manager then he can get back to main scene ( window ) to reset the password. 
     * @param event
     * @throws IOException
     */
    
    
    @FXML
    void forgotYourPassword(ActionEvent event) throws IOException
    {	
    	data.forgotPasswordCounter ++;
    	data.setApplicationStage(Main.controller.applicationStage);
    	Parent root = FXMLLoader.load(getClass().getResource("MasterPasswordView.fxml"));
		Scene createPassword = new Scene(root);
		Main.controller.applicationStage.setScene(createPassword);
		Main.controller.applicationStage.setTitle("Create Master password");

    }
    
    
    

    
}