/*
 Name: Ruben Ortega
 Date: 9/28/22
 Description: This is an email application that shows us how to use inheritance. We have 3 classes in this program.
 The email driver class, a document class and an email class which inherits from the document class. 
 Self Grade: 100/100
 Testimony: I have written this program all by myself and have not copied any code 
 from any resourses: Ruben Daniel Ortega
 */
import java.util.Date;
public class DocumnetOrtega //<-------add your last name here
{
   //no code goes here. Must leave empty
}

   //parent class 
class Document
{	
   //private variables
private String content ;
	
   //constructor that will be used by the email class
public Document (String text) {
	content=text;
}
   //getter method returns content
public String getContent() {
	return content;
}
   //setter method initializes content
public void setContent(String newContent){
	content=newContent;
}
   //toString method will be overriden in the email class
 public String toString() {
	 return content;
 }
   //returns how long the content of the email is
 public int getContentLength() {
	 return content.length();
 }
 
   // will return true if the word we are looking for is in content
 public Boolean contains (String keyword) {
	 if(content==keyword) 
    {
		 return true;
	 }
	return false;
 }
   //comapre two objects didnt really use this method
 public Boolean equals (Document other) {
	 if(this.content.equalsIgnoreCase(other.content)) {
		 return true;
		 
	 }
	 return false;
 }
 
}

// subclass of doucument class
class Email extends Document{
   //some varibales defined
	private String sender;
	private String recipient;
	Date date= new Date();;
	private String subject;
	private String cc;
	boolean iSsent ;
	
   //email classes contructor
    public Email (String text, String sender, String recipient, String subject, String cc)   
    {
      // we use the super keyword to call the documents classes constructior
    	super(text);
    	this.sender=sender;
    	this.recipient=recipient;
    	
    	this.subject=subject;
    	this.cc=cc;
}               
    //sends the email and returns true so we cant modify the email after its sent
    public void send() {
    	iSsent=true;
    }
    
    //5 getter methods
    public boolean getSent() {
    	return iSsent;
    	
    }
    
    public String getSender() {
    	return sender;
    }
     
    public String getRecipiant() {
    	return recipient;
    	
    }
    public String getSubject() {
    	return subject;
    }
    public String getCC() {
    	
    	return cc;
    }
     
    //we use the date class to get the actual date
    public Date Date() {
    	
    	return date;
    }
     
    //4 setter methods they all check to see if the email was sent before doing their job
    public void setSender(String a) {
    	if(iSsent == false) {
    		sender = a; }
    	else 
    		System.out.println("This email has been sent cannot be modified");
    	
    }
    public void setRecipiant(String b) {
    	if(iSsent== false) {
    		recipient = b; 
    	}
    	else 
    		System.out.println("This email has been sent cannot be modified");
    	
    }
    
    public void setSubject(String c) {
    	if(iSsent== false) {
    		subject = c; 
    	}
    	else 
    		System.out.println("This email has been sent cannot be modified");
    	
    }
    public void setCC(String d) {
    	
    	if(iSsent== false) {
    		cc = d; 
    	}
    	else 
    		System.out.println("This email has been sent cannot be modified");
    }
    
    //another toString method this one overides the other one
    public String toString() {
    	
    	return "Sender: "+ sender+"\n"+"Recipiant: "+recipient+"\n"
    	+"CC: "+cc+"\n"+"Subject: "+subject+"\n"+
    	"Date: "+date+"\n"+"Content: "+super.toString();
    }
     
    //we can change the content of the email here if the email is not sent
    public void modifyContent (String e) {
    	if(iSsent== false) {
    		super.setContent(e);
    	}
    	else 
    		System.out.println("This email has been sent cannot be modified");
    	
    }
    //here we create a new email object and return it
    public Email forward (String rec, String sender ,String cc) {
    	Email f = new Email (this.getContent(),  sender, rec, this.subject, cc);
    	f.date = new Date();
    	f.iSsent = true;
    	return f; 
    	
    }
} 

class EmailDriver
{
    // public Email(String text, String sender,String recipiant, String subject, String cc)
    public static void main(String[] args)
    {
      //creating two objects of the Email class called e1, and e2
       Email e1 = new Email("Hello everyone I just finshed this weeks assignment", "Ruben Ortega","Kobe","Assignment","");
       Email e2 = new Email("Hello everyone I really like to code in Java,","Daniel", "Jordan", "Coding" , "Java");
       
       //sending the email
       e1.send();
       
       //calling the setter methods on email e1
       e1.setCC("");
       e1.modifyContent("Hey I finshed this assigment");
       e1.setRecipiant("Lebron");
       e1.setSender("This is the sender");
       e1.setSubject("Finished Assigment");
       
       
       
       System.out.println();
       System.out.println("We get all these messages that the email cannot be modified ");
       System.out.println("because the email was sent before this and we cant modify a sent email "+"\n");
       
       //displaying email e1
       System.out.println(e1);
       
       //forwarding email e1
       System.out.println();
       System.out.println("forwarded message\n"+e1.forward("Gita", "Ruben Ortega" ,"rubensMail@mail.com"));
       System.out.println();
       
       
       
       System.out.println("\n");
      
       
      
      
       //calling the setter methods on email e2
       e2.setSender("This is the sender");
       e2.setRecipiant("This is the recipiant");
       e2.setSubject("This is the subject");
       e2.setCC("This is the CC");
       
       //modifying the content on the email e2
       e2.modifyContent("I really like java");
              
       //sending the email
       e2.send();
       
       //displaying email e2
      System.out.println(e2);
   
       //calling the getDocumentLength method on email e2
       System.out.println("The number of the letters in the email is: "+e2.getContentLength());
       
       //calling the contains method in e2 with the word of my choice 
       boolean b = e2.contains("lebron");
       if(b)
         System.out.println("The word lebron was  found in the email");
       else
          System.out.println("The word lebron was found in the email"); 
          
          
       

       
      
       
    }
}