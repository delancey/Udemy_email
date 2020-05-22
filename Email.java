import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "anyone.com";
    

//Constructor to receive first and last name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        // System.out.println("Email created " + this.firstName + " " + this.lastName);
        
        //Call a method asking for department - return department
        this.department = setDepartment();
        // System.out.println("Department: " + this.department);

        //Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is " + this.password);

        //Combine elements to generate email
        email = firstName.toLowerCase() +"." + lastName.toLowerCase()+"@"+ department+  "." + companySuffix;
        // System.out.println("Your email is: " + email);

        
    }

    private String setDepartment(){
        System.out.print("New worker: " +firstName +  ". Department Codes: \n1 for sales\n2 for development\n3 for accounting\n0 for none");

        Scanner in = new Scanner(System.in);
        int deptChoice = in.nextInt();
        in.close();
        if(deptChoice == 1){
            return "sales";
        }else if (deptChoice ==2){
            return "dev";
        } else if (deptChoice == 3){
            return "accounting";
        } else {
            return "";
        }
        
    }
    

//Generate random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKMNOPQRSTUVWXYZ0123456789!@#$%";
        char[]password = new char[length];
        for(int i = 0; i < length; i++){
            int random = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new String (password);
    }

//Set mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

//set alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

//Change password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity(){
        return mailboxCapacity;        
    }

    public String getAlternateEmail(){
        return alternateEmail;
    }

    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName + 
               "\nCOMPANY EMAIL: " + email + 
               "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
    
}