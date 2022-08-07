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
	
	

public class VerifyMasterPasswordController extends MasterPasswordController {
	
	
    @FXML
    private PasswordField VerifyMasterPasswordField;

    @FXML
    private Button VerifyMasterPasswordButton;
    
    @FXML
    void verifyPassword()
    {
    	
    }

    
    @FXML
    private Text UnlockManagerPassError;
    
    
    
    @FXML
    void VerifyMasterPass(ActionEvent event) throws IOException {
    	
    	applicationStage.getScene();
    	
    	
    	String inputToCheck = VerifyMasterPasswordField.getText();
    	
    	
		if(inputToCheck.equals(Main.controller.getMasterPassword())) { // comparing created masterPassword to the verifyMasterPassword	
    		
    	UnlockManagerPassError.setText("The master password input is incorrect. Try again."); 
    	System.out.println(inputToCheck);
    	System.out.println(getMasterPassword());


    	}
    	
    	else {
    		
    		Parent root = FXMLLoader.load(getClass().getResource("AccessUsernameAndPasswordView.fxml"));
    		Scene accessGranted = new Scene(root);
    		Stage settingUpStage = new Stage();
    		settingUpStage.setScene(accessGranted);
    		settingUpStage.show();
    		
    	}
    	
    	
    }

    
}