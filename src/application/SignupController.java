package application;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.xml.validation.Validator;
import java.io.File;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nicholas on 5/29/17.
 */




public class SignupController {
    @FXML
    ComboBox<String> genderBox;
    @FXML
    TextField fldUsername;
    @FXML
    PasswordField fldPassword;
    @FXML
    PasswordField fldVerify;
    @FXML
    TextField fldEmail;
    @FXML
    TextField fldFirstName;
    @FXML
    TextField fldLastName;
    @FXML
    DatePicker dob;
    @FXML
    Button btnBrowse;
    @FXML
    TextField fldPhoto;
    @FXML
    TextField fldPhoneNumber1,fldPhoneNumber2,fldPhoneNumber3;
    @FXML
    Button btnSignup, btnCancel;
    @FXML
    TextField fldSSN;
    @FXML
    Label lblMessage;


    //Terribly inefficient, but it adds teh elements needed for the combo box
    public void genderClicked(MouseEvent mouseEvent) {
        genderBox.getItems().removeAll("Male","Female","Other");
        genderBox.getItems().addAll("Male","Female","Other");
    }

    //Open FileChooser when the button is clicked
    public void browseClicked(MouseEvent mouseEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Browse for photo");
        File file = fileChooser.showOpenDialog(MainController.getSignupStage());
        if(file != null)
            fldPhoto.setText(file.getAbsolutePath());
    }

    //This was supposed to do something but it doesn't
    public void phoneNumberKeyPressed(KeyEvent keyEvent){
        int index = keyEvent.getSource().toString().indexOf("lblPhoneNumber");
        char number = keyEvent.getSource().toString().charAt(index + 14);
    }

    public void signupClicked(MouseEvent mouseEvent) {
        boolean pass = true;
        String errors = "";
        String phoneNumber = fldPhoneNumber1.getText() + fldPhoneNumber2.getText() + fldPhoneNumber3.getText();
        String check = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(check);
        Matcher matcher = pattern.matcher((CharSequence)fldEmail.getText());



        //Uppercase password check
        if(!(!fldPassword.getText().toUpperCase().equals(fldPassword.getText()) && !fldPassword.getText().toLowerCase().equals(fldPassword.getText())))
            errors += "\nPassword must contain at least one uppercase and lowercase";
        //Special character check
        if(!fldPassword.getText().matches(".*[!@#$%^&*].*"))
            errors += "\nPassword must contain at least one special character";
        //Password verification
        if(!fldPassword.getText().equals(fldVerify.getText()))
            errors += "\nPassword and verification must be the same";
        //Email format check
        if(!matcher.matches())
            errors += "\nEmail must be 'xxxx@email.com'";
        //Duplicate username check
        if(Main.getUsers().containsKey(fldUsername.getText()))
            errors += "\nThat username is already taken";




        lblMessage.setText(errors);
        //If there are no errors, then make the new user 
        if(errors.equals("")){
            //Polymorphism
            Person user = new User(fldUsername.getText(),fldEmail.getText(),phoneNumber,fldPassword.getText(),
                    new File(fldPhoto.getText()),fldFirstName.getText(),fldLastName.getText(),dob.getChronology().toString(),genderBox.getValue(),"");
            Main.getUsers().put(fldUsername.getText(),fldPassword.getText());
            //System.out.println(user.toString());
            MainController.getSignupStage().close();
            MainController.setOpen(false);
        }


    }

    public void cancelClicked(MouseEvent mouseEvent) {
        MainController.getSignupStage().close();
        MainController.setOpen(false);
    }
}
