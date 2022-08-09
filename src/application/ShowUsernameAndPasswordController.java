package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
/**
 * Controller class that deals with showing the saved information
 * @author aniruddha.khan
 */
public class ShowUsernameAndPasswordController
{
	
	CommunicateDataController data = CommunicateDataController.getInstance();
    @FXML
    private Text websiteGoesHere;

    @FXML
    private Text usernameGoesHere;

    @FXML
    private Text passwordGoesHere;             
    
    /**
     * Method that sets the action for "Show" button
     * If the user clicks on the button it will basically reveal the saved information that the user had added 
     * @param event
     */
    
    @FXML
    void showData(ActionEvent event) 
    {
    	setWebsiteLabel(data.getListOfWebsites().get(data.getListIndex()));
    	
    	setUsernameLabel(data.getListOfUsernames().get(data.getListIndex()));
    	
    	setPasswordLabel(data.getListOfPasswords().get(data.getListIndex()));
    }
    
    /**
     * Method that sets the action for "Go Back" button
     * If the user is done viewing his/her saved information he/she can click on it and then it will redirect the user to the scene(window) where he can view the list of his/her saved passwords
     * @param event
     * @throws IOException
     */

    @FXML
    void GoBack(ActionEvent event) throws IOException 
    {	
    	Parent root = FXMLLoader.load(getClass().getResource("AccessUsernameAndPasswordView.fxml"));
    	Scene previousScene = new Scene(root);
    	Main.controller.applicationStage.setScene(previousScene);
    	Main.controller.applicationStage.setTitle("Main page");
    }

    /**
     * A Getter method for getting the website name the user provided.
     * @return It returns the string value as given by the user
     */
    
	public Text getWebsiteLabel() 
	{
		return websiteGoesHere;
	}
	
    /** 
     * A setter method that takes in the parameter websiteGoesHere and assigns it to the label websiteGoesHere variable
     * @param websiteGoesHere
     */
	
	public void setWebsiteLabel(String websiteGoesHere)
	{
		this.websiteGoesHere.setText(websiteGoesHere);;
	}
	
	/**
	 * A getter method for getting the username of the username given by the user
	 * @return It returns the string value of the username as given by the user
	 */
	public Text getUsernameLabel() 
	{
		return usernameGoesHere;
	}
	
	/**
	 * A setter method that takes in the parameter usernameGoesHere and assigns it to the label usernameGoesHere variable
	 * @param usernameGoesHere
	 */
	
	public void setUsernameLabel(String usernameGoesHere) 
	{
		this.usernameGoesHere.setText(usernameGoesHere);
	}
	
	/**
	 * A getter method for getting the password as given by the user
	 * @return
	 */
	
	public Text getPasswordLabel() 
	{
		return passwordGoesHere;
	}
	
	/**
	 * A setter method that takes in the parameter passwordGoesHere and assigns it to the label passwordGoesHere variable
	 * @param passwordGoesHere
	 */
	
	public void setPasswordLabel(String passwordGoesHere)
	{
		this.passwordGoesHere.setText(passwordGoesHere);
	}
	
	

}