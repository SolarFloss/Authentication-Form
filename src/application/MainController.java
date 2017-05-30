package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController{

    @FXML
    TextField fldUsername;
    @FXML
    TextField fldPassword;
    @FXML
    Button btnSignIn;
    @FXML
    Label lblMessage;

    public ComboBox<String> genderBox;


    private static Stage signupStage;
    private static Scene signupScene;
    private static Parent root;
    private static boolean open = false;


    public static Stage getSignupStage(){return signupStage;}
    public static Scene getSignupScene(){return signupScene;}
    public static void setOpen(boolean val){open = val;}




    //Validation
    public void signInClicked(MouseEvent mouseEvent) {
        //System.out.println(Main.getUsers().get(fldUsername.getText()));
        String username = fldUsername.getText();
        if(Main.getUsers().get(fldUsername.getText()) != null) {
            if (Main.getUsers().get(fldUsername.getText()).equals(fldPassword.getText())) {

                try {
                    Stage newStage = new Stage();
                    Parent layout = FXMLLoader.load(getClass().getResource("/fxml/welcome.fxml"));
                    Scene newScene = new Scene(layout, 211,162);
                    newStage.setScene(newScene);
                    newStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                lblMessage.setText("Incorrect Password or Username");
            }
        }else{
            lblMessage.setText("Incorrect Password or Username");
        }
    }

    //Open SignUp Form
    public void linkClicked(MouseEvent mouseEvent) {
        //Prevent opening multiple signup forms at once
        if(!open) {
            try {
                signupStage = new Stage();
                root = FXMLLoader.load(getClass().getResource("/fxml/signup.fxml"));
                signupScene = new Scene(root, 386, 501);
                signupStage.setScene(signupScene);
                signupStage.initModality(Modality.APPLICATION_MODAL);
                signupStage.setResizable(false);

                //Weird lambda stuff here
                signupStage.setOnCloseRequest(e -> open = false);
                signupStage.show();
                open = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
