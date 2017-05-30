package application;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nicholas on 5/24/17.
 */
public class User extends Person {
    private String username,email,phoneNumber,password;


    //File path for photo
    private File photo;

    public User(String username,String email,String phoneNumber,String password,File photo,String firstName,String lastName,String dob, String gender,String SSN){
        super(firstName,lastName,SSN,dob,gender);
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.photo = photo;
    }

    //Override the toString method
    public String toString(){
        return username + "\n" + email + "\n" + phoneNumber + "\n" + photo.getAbsolutePath();
    }
}
