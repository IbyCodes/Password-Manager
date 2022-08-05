package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;

public class VerifyMasterPasswordController extends MasterPasswordController {

    @FXML
    private PasswordField VerifyMasterPasswordField;

    @FXML
    private Button VerifyMasterPasswordButton;
    
    @FXML
    private Text UnlockManagerPassError;
    
    
    
    @FXML
    void VerifyMasterPass(ActionEvent event) {
    	
    	String inputToCheck = VerifyMasterPasswordField.getText();
    	if(inputToCheck != getMasterPassword()) {	
    		
    		UnlockManagerPassError.setText("The master password input is incorrect. Try again.");
    		
    	}
    	
    	else {
    		; // here we can switch the scene to scene AccessUsernameAndPasswordView
    		
    	}
    	
    	
    	

    }
    

}