package emailapp;
import java.util.Scanner;

public class Email {
 
   
    
    private String firstname;                  //Define all the necessities
    private String lastname;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;              //Since we don't want all these things to be directly accessed 
    private String alternateEmail;            //by the user so everything will be private
    private String changePass;
    

//Constructor to recieve firstname and lastname
public Email(String firstname, String lastname){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter firstname");
    firstname = sc.next();
    System.out.println("Enter lastname");
    lastname = sc.next();

    this.firstname = firstname;
    this.lastname = lastname;
    System.out.println("Email Created: " + this.firstname + " " + this.lastname);

    this.department = setDepartment();
    //System.out.println("Department is " + this.department);

    this.password = randomPassword(8);
    System.out.println("Your password is "+this.password);

    //Combine the elements to generate email
    email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department + "." + "github.com";
    System.out.println("Your email is: " + email);
} 


// Call a method asking for the department and return the department

private String setDepartment() {
    System.out.println("Enter the department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for nothing ");
    Scanner in = new Scanner(System.in);
    int a = in.nextInt(); // a contains the number according to dept.
    if(a == 1){
        return "Sales";
    }
    else if(a==2){
        return "Developement";
    }
    else if(a==3){
        return "Accounting";
    }
    else{
        return " ";
    }
    }

// Call a method that returns a random password
private String randomPassword(int length){  //length =for the length of pwd
    String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&*";
    char[] password = new char[length];
    for(int i=0;i<length;i++)
    {
       int random =(int)(Math.random() * passwordSet.length()); //multiply one random char with the length
       password[i]=passwordSet.charAt(random);     // array pwd = character at random from passwordSet
    }
    return new String(password);             //returning a string

}

//Set the mailbox capacity
public void setMailboxCapacity(int capacity) {
    this.mailboxCapacity = capacity;
}

// Set the alternate email
public void setAlternateEmail(String altEmail){
    this.alternateEmail = altEmail;
}

//Change the password
public void changePassword(String changePass){
    this.changePass = changePass;
}
public String getchangePassword(){  
    System.out.println("Reset your password");
    Scanner in = new Scanner(System.in);
    changePass = in.next();                               //here encapsulation is taking place
    return changePass;

}
public String getAlternateEmail() {
    return alternateEmail;
}
public int getMailboxcapacity() {
    return mailboxCapacity;
}

}
