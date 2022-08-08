package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;

public class ShowUsernameAndPasswordController {
	
	DataSingleton data = DataSingleton.getInstance();

    @FXML
    private Text websiteGoesHere;

    @FXML
    private Text usernameGoesHere;

    @FXML
    private Text passwordGoesHere;             

    @FXML
    void showData(ActionEvent event) {
    	
    	
    	setWebsiteLabel(data.getListOfWebsites().get(data.getListIndex()));
    	
    	setUsernameLabel(data.getListOfUsernames().get(data.getListIndex()));
    	
    	setPasswordLabel(data.getListOfPasswords().get(data.getListIndex()));
    	

    }
    

    @FXML
    void GoBack(ActionEvent event) throws IOException {
    	
    	
    	Parent root = FXMLLoader.load(getClass().getResource("AccessUsernameAndPasswordView.fxml"));
    	Scene previousScene = new Scene(root);
    	Main.controller.applicationStage.setScene(previousScene);
    	Main.controller.applicationStage.setTitle("Main page");

    }


	public Text getWebsiteLabel() {
		return websiteGoesHere;
	}


	public void setWebsiteLabel(String websiteGoesHere) {
		this.websiteGoesHere.setText(websiteGoesHere);;
	}


	public Text getUsernameLabel() {
		return usernameGoesHere;
	}


	public void setUsernameLabel(String usernameGoesHere) {
		this.usernameGoesHere.setText(usernameGoesHere);
	}


	public Text getPasswordLabel() {
		return passwordGoesHere;
	}


	public void setPasswordLabel(String passwordGoesHere) {
		this.passwordGoesHere.setText(passwordGoesHere);
	}
	
	

}