package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AccessUsernameAndPasswordController {
	
	Stage applicationStage;

    @FXML
    private Button EditPasswordButton;

    @FXML
    private Button AddPasswordButton;

    @FXML
    private ListView<?> ListOfPasswords;
    
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
			
			}
			else if(rowCounter == 1) {
				Label usernameLabel = new Label("Enter the username of the site: ");
				TextField usernameTextfield = new TextField();
				newPasswordTextFields.add(usernameTextfield);
				newPasswordScene.getChildren().addAll(usernameLabel, usernameTextfield);
				allRows.getChildren().add(newPasswordScene);
			}
			
			else if(rowCounter == 2) {
				Label passwordLabel = new Label("Enter the password of the site to save: ");
				TextField passwordTextfield = new TextField();
				newPasswordTextFields.add(passwordTextfield);
				newPasswordScene.getChildren().addAll(passwordLabel, passwordTextfield);
				allRows.getChildren().add(newPasswordScene);
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


}