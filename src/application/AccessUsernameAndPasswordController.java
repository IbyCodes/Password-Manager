package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AccessUsernameAndPasswordController extends ShowUsernameAndPasswordController {

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


    
    @FXML
    void AddNewPassword(ActionEvent event) throws IOException {
    	
    	
    	Parent root = FXMLLoader.load(getClass().getResource("SavingInformationView.fxml"));
    	Scene addInformation = new Scene(root);
    	Main.controller.applicationStage.setScene(addInformation);
    	Main.controller.applicationStage.setTitle("Saving Username and Password");
    	
    }
    
    
    @FXML
    void refreshPage(ActionEvent event) {
    	
    	counter ++ ;
    	
    	if (counter>1) {
    		refreshedPagesText.setText("You already refreshed the page to its most updated values.");
    	}
    	
    	else {
    	ListOfPasswords.getItems().addAll(data.getListOfWebsites());
    	

    }
    	
    	
    	
   
    	
    }
    
    @FXML
    public void clickedOnAPassword() throws IOException { // source: https://imgur.com/a/L99ij8N
    	
    	countClicks ++;
    	
    	if (countClicks>1) {
    	
    	int countingIndex = 0;
    	
    	while (!(countingIndex<0)) { // i want the listIndex to keep reseting every time something on the list is clicked

    	
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
    void DeleteAPassword(ActionEvent event) {
    	
    	if (ListOfPasswords.getItems().isEmpty()||data.getListIndex()<0) {
    		refreshedPagesText.setText("There is no password to delete! Please add a password first.");
    		
    		
    	}
    	else {
    	data.setListIndex(ListOfPasswords.getSelectionModel().getSelectedIndex());
    	ListOfPasswords.getItems().remove(data.getListIndex());
    	data.getListOfPasswords().remove(data.getListIndex());
    	data.getListOfUsernames().remove(data.getListIndex());
    	data.getListOfWebsites().remove(data.getListIndex());
    	
    	

    }
    	
    }

	
   

}