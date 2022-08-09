package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class VerifyMasterPasswordController {
	
    @FXML
    private PasswordField VerifyMasterPasswordField;

    @FXML
    private Text UnlockManagerPassError;

    
    @FXML
    void VerifyMasterPass(ActionEvent event) throws IOException {
    	
    	
    	
    	String inputToCheck = VerifyMasterPasswordField.getText();
    	
    	
		if(inputToCheck.equals(Main.controller.getMasterPassword())) { // comparing created masterPassword to the verifyMasterPassword	

    		
    		Parent root = FXMLLoader.load(getClass().getResource("AccessUsernameAndPasswordView.fxml"));
    		Scene accessGranted = new Scene(root);
    		
    		Main.controller.applicationStage.setScene(accessGranted);
    		Main.controller.applicationStage.setTitle("AccessUsernameAndPassword");
    	}
    	
    	else {
    		
    		UnlockManagerPassError.setText("The master password input is incorrect. Try again."); 

    

    	}
    	
    	
    }
    
    CommunicateDataController data = CommunicateDataController.getInstance();
    
    @FXML
    void forgotYourPassword(ActionEvent event) throws IOException {
    	
    	data.forgotPasswordCounter ++;
    	data.setApplicationStage(Main.controller.applicationStage);
    	
    	Parent root = FXMLLoader.load(getClass().getResource("MasterPasswordView.fxml"));
		Scene createPassword = new Scene(root);
		
		Main.controller.applicationStage.setScene(createPassword);
		Main.controller.applicationStage.setTitle("Create Master password");
		

    }
    
    
    

    
}