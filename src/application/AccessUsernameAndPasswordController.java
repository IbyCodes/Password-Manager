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
import javafx.stage.Stage;

public class AccessUsernameAndPasswordController extends ShowUsernameAndPasswordController {

	Stage applicationStage;
	
	int counter = 0;
	
	CommunicateDataController data = CommunicateDataController.getInstance();

    @FXML
    private Button AddPasswordButton;

    @FXML
    public ListView<String> ListOfPasswords;
    

    
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
    		System.out.println("You already refreshed the page to its most updated values.");
    	}
    	
    	else {
    	ListOfPasswords.getItems().addAll(data.getListOfWebsites());
    	

    }
    	
    	
    	
   
    	
    }
    
    @FXML
    public void clickedOnAPassword() throws IOException { // source: https://imgur.com/a/L99ij8N
    	
    	
    	
    	int countingIndex = 0;
    	
    	while (!(countingIndex<0)) { // i want the listIndex to keep reseting every time something on the list is clicked

    	
    	data.setListIndex(ListOfPasswords.getSelectionModel().getSelectedIndex());
    	
    	Parent root = FXMLLoader.load(getClass().getResource("ShowUsernameAndPassword.fxml"));
    	Scene showInformation = new Scene(root);
    	Main.controller.applicationStage.setScene(showInformation);
    	Main.controller.applicationStage.setTitle("Show Information");
    	
    	countingIndex = -1;
    	
    	
 
    	
    	
    	
  

    }

    }

	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*

    @FXML
    void AddNewPassword(ActionEvent event) {
		Scene mainScene = applicationStage.getScene();
		VBox allRows = new VBox();
		ArrayList<TextField> newPasswordTextFields = new ArrayList<TextField>();
		
		int rowCounter = 0;
		
		while(rowCounter < 3) {
			
			HBox newPasswordScene = new HBox();
			if (rowCounter == 0) {
			Label websiteLabel = new Label("Enter the website of the password: ");
			TextField websiteTextfield = new TextField();
			newPasswordTextFields.add(websiteTextfield);
			newPasswordScene.getChildren().addAll(websiteLabel, websiteTextfield);
			allRows.getChildren().add(newPasswordScene);
			rowCounter ++;
				
			
			}
			else if(rowCounter == 1) {
				Label usernameLabel = new Label("Enter the username of the site: ");
				TextField usernameTextfield = new TextField();
				newPasswordTextFields.add(usernameTextfield);
				newPasswordScene.getChildren().addAll(usernameLabel, usernameTextfield);
				allRows.getChildren().add(newPasswordScene);
				rowCounter ++;
			}
			
			else if(rowCounter == 2) {
				Label passwordLabel = new Label("Enter the password of the site to save: ");
				TextField passwordTextfield = new TextField();
				newPasswordTextFields.add(passwordTextfield);
				newPasswordScene.getChildren().addAll(passwordLabel, passwordTextfield);
				allRows.getChildren().add(newPasswordScene);
				rowCounter ++;
		}
		}
    	
		Button doneButton = new Button("Done entering information for password");
    	 //doneButton.setOnAction(doneEvent -> calculateQuizGrade(mainScene, quizTextFields)); // return to main scene( need to figure out how)
    	allRows.getChildren().add(doneButton);
    	
    	Label passwordInputErrorLabel = new Label();
    	allRows.getChildren().add(passwordInputErrorLabel);
    	
    	
    	
    	//Scene quizScene = new Scene(allRows); // still need to figure out how to return to previous scene
    	// applicationStage.setScene(quizScene);  // still need to figure out how to return to previous scene
    	
    	

    }
	*/

}