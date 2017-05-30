package application;

/**
 * Created by nicholas on 5/24/17.
 */
public class Person {
    private String firstName,lastName,SSN,dob,gender;

    public Person(String firstName,String lastName,String SSN,String dob,String gender){
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
        this.dob = dob;
        this.gender = gender;
    }

    public String toString(){
        return firstName + " " + lastName + "\n" + dob + "\n" + gender + "\n" + SSN;
    }
}
