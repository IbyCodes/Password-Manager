package application;
	
import javafx.application.Application;
import java.io.FileInputStream;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(); //needed to use the fxmlloader file we made 
			VBox root = loader.load(new FileInputStream("src/application/MasterPasswordView.fxml")); 
			controller.applicationStage = primaryStage;  // GETTING A PROBLEM
			
			Scene scene = new Scene(root,400,400);
			
			primaryStage.setScene(scene);
			
			primaryStage.setTitle("Password Manager");  // Our idea is to create a password manager that stores different 
			// passwords with a name for what account the password is for, which can then be accessed via one MASTER password
			// and if the person gets the master password wrong he's not allowed to access any of the passwords. 
			
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}