package emailApp;

import constants.Constants;

import java.util.Scanner;

public class Email {

    // Fields
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity;
    private int defaultPwdLength =10;
    private String alternateEmail;
    private String companySuffix="company.com";


    // Constructor to recieve firstName and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // call getDepartment
        this.department = setDepartment();

        // call method that returns random password
        this.password = randomPassword(defaultPwdLength);

        // combine elements to generate email
        email = generateEmail();

    }

    public String generateEmail () {
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }


    // get department
    public String getDepartment() {
        return department;
    }

    public String setDepartment() {
        System.out.println("Enter the department\n 0 for None \n 1 for Sale \n 2 for Development \n 3 for Accounting  \n Enter Department: ");

        // call Scanner class
        Scanner in = new Scanner(System.in);

        // save userInput
        int departmentChoice = in.nextInt();

        switch (departmentChoice){
            case 1:
                return "sales";
            case 2:
                return "dev";
            case 3:
                return "acct";
            default:
                return "";
        }

    }

    // set/generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOZ123456789!@#$%";
        char [] password = new char[length];

        for(int i=0 ; i <length; i++ ){
            int random = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new String(password);
    }

    // set the mailbox capacity
    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    // set the alternate email
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    // change password
    public void setPassword(String password) {
        // add more logic
        this.password = password;
    }

    // toString


    @Override
    public String toString() {
        return "Email{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                ", mailboxCapacity=" + mailboxCapacity +
                ", defaultPwdLength=" + defaultPwdLength +
                ", alternateEmail='" + alternateEmail + '\'' +
                ", companySuffix='" + companySuffix + '\'' +
                '}';
    }
}
