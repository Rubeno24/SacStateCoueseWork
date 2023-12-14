/*
 Name: Ruben Ortega
 Date: 10/13/22
 Description: This program simulates a social media app where we use an array list to add and delete our followers 
 Self Grade: 100/100
 Testimony: I have written this program all by myself and have not copied any code 
from any resourses: Ruben Daniel Ortega
 */
import java.util.*;
public class InstaOrtega
{
   //no code here
}
//user class implements Comparable interface so we can use the compareTo metho
class User implements Comparable<User> 
{
   private String first;
   private String last;
   private String username;
   private boolean followBack; 
     
   //constructor    
   public User(String first, String last, String username, boolean followBack)
   {
	   this.first = first;
      this.last = last;
      this.username = username;
      this.followBack = followBack;
   }
   //getter and setter metods
   public boolean getFollow()
   {
      return followBack;
   }
   //unfollow and follow are methods that are called to set followBack to true of false
   public void unfollow()
   {
	   followBack=false;
   }
   
   public void follow()
   {
	   followBack=true;
   }
   
   public String getFirst() 
   {
      return first;// change this line
   }
   
   public String getLast() 
   {
      return last;//chnage this line
   }
             
   public void setFirst(String first)
   {
      this.first=first;
   }
   
   public void setLast(String last) 
   {
	   this.last=last;
   }
   
   public String getUsername()
   {
      return username; //your code
   }
   
   public boolean equals(User other) 
   {
   
	   return this.first.equalsIgnoreCase(other.first) && this.last.equalsIgnoreCase(other.last);
       
   }
   
   //toString methods returns the variables and formats them to match text
   public String toString() 
   {
     
      return "User Name: "+username+"\nName: "+first+
    		  "\nLast name: "+last; // must change
           
   }
   //this method is from the comparable interface  
@Override
public int compareTo(User o) 
   {
	User u = (User)o;
	 return (this.username).compareTo(u.getUsername());
	}
   
   //this method is used to know if you are following a person and display it in the other toString method.
public String isFollowing() 
      {
	  
	   if(followBack==true) 
      {
		   return"You follow back this person";
	   }
	   else 
      {
		   return "You are not following this person";
	   }
}
}

class SocialMedia{
   //creates an arraylist of type User class named app
   private ArrayList<User> app;
     
   //constructor
   SocialMedia()
   {
      app = new ArrayList<User>();
         
   }
   //this method takes the username of a person and follows them back which adds them to the app arraylist
   public void followBack(String username)
   {
       String s = username;
       for(int i = 0; i < app.size(); i++) 
       {
    	   String x = app.get(i).getUsername();
    	   if(x.equalsIgnoreCase(s)) 
         {
    		   app.get(i).follow();
    	   }
       }
   }
   
   //this method is how we add anyone to the app arraylist
   public boolean follow(String first, String last, String username, boolean followBack) {
	   boolean b = search(first,last);
	   boolean added = false;
	   if(b) {
		   return false;
	   }    
           //create an object of type user named userObject
           User userObject = new User(first,last,username,followBack);
           
           //adds userObject if list is empty
           if(app.size()==0) 
           {
        	   app.add(userObject);
        	   added = true;
           }
           
           //if list is not empty this for loop adds userObject where it belongs
           for (int j=0; j<app.size(); j++) 
           {
               if (userObject.compareTo(app.get(j)) < 0) 
               {
                   app.add(j, userObject);
                   added = true;
                   break;
               }
               
           }
               //if userObject is not added yet this if statements add them at the end of the arraylist
               if (!added) 
               {
                   app.add(userObject);
                   added = true;
               }
           
               return added; 
           
                          
   }
     
    /*This method removes the person from the list meaning that they are not 
    following you
    and you are not following them*/
   public boolean remove(String first, String last ) {
       boolean b = search(first,last);
       if(!b) 
       {
    	   return false;
       }
       
       String s = first + " "+last;
       
       for (int i=0; i < app.size(); i++) 
       {
           String x=app.get(i).getFirst() + " " + app.get(i).getLast();
           if (s.equalsIgnoreCase(x)) 
           {
               app.remove(i); // remove the person from the list
               return true;
           }            
       }
      return false; 
   }
           
    
   //search methods comapres the parameters passes in to the first and last of the arraylist index we are 
   //looking at
   public boolean search(String first, String last) 
   {
	   for (int i=0; i<app.size(); i++) 
      {
		   String s = first + " " + last;
		   String x =app.get(i).getFirst() + " " + app.get(i).getLast();
	   if (s.equalsIgnoreCase(x)) 
      {
           return true;
           //if they match return true
	   }
      }
      
	   return false;
      //no match 
   }
     
   
   //getter method
   public ArrayList<User>getList()
   {
      return app;
   }
   
   //returns how long the list is thats how many followers you have
   public int followerCounts()
   {
      return app.size();
   }
   
   //returns how many people you follow based on the getFollow method
   //if its true we increment count by 1
   public int followingCounts()
   {
      int count=0;
      for (int i=0; i < app.size(); i++) 
      {
    	  if (app.get(i).getFollow()) 
        {
    		  count++;
    	  }
      }
      return count;      
   } 
   
   //toString Method
   public String toString() { 
     String s = "";
     for (int i=0; i < app.size(); i++) 
     {
         s += app.get(i).toString() + "\n";
         //isFollowing method is called and appends to string if you are or are not following the person
         s+= app.get(i).isFollowing();
         s += "\n************************\n";
        
         
         
     }
      return s; 
   
   }
   

}
 
class MyDriverOrtega
{
    public static void main(String[]args) {
      SocialMedia TikTok = new SocialMedia();
      
     /*Adding followers to your list*/
      /*the boolean field indicates whether you want to follow them back*/
      TikTok.follow("Ruben", "Ortega", "rubeno_24", true);
      TikTok.follow("Lebron", "James",  "KingJames23", false); 
      TikTok.follow("Kobe", "Bryant",  "KobeBryant24", true); 
      TikTok.follow("Kevin", "Durant", "EasyMoneySniper",true);
      TikTok.follow("Michael", "Jordan", "BabyGoat", false);
      
     /*Displaying your followers*/
      System.out.println("Your followers informations\n");
      System.out.println(TikTok);
    
      /*Unfollowing a user*/
      System.out.println("Removing Robert Kenny from your followers list");
      TikTok.remove("Michael", "Jordan");
   
      /*Displaying the list*/
      System.out.println("List of followers after removing Robert Kenny");
      System.out.println(TikTok);
   
      /*adding a new follower*/
      System.out.println("Adding Elon Musk to your list of followers");
      TikTok.follow("Elon", "Musk", "ElonM", true);
      
      /*Dipslying the followers*/
      System.out.println("List of your followers:");
      System.out.println(TikTok);
   
      /*Searching for a follower*/
      System.out.println("Searching for Dwayne Wade(DWade) in your followers list");
      if(TikTok.search("Dwayne", "Wade") == false) {
         System.out.println("Dwayne Wade is not in your list of followers");
         System.out.println("\n***************************");   
         System.out.println("You are following " + TikTok.followerCounts() + " people");
      
         System.out.println("You have " + TikTok.followingCounts() + " followers");  
         System.out.println(TikTok);
         Scanner kb = new Scanner(System.in);
         System.out.println("Enter the username of the person that you want to follow back: ");
      
         String username =kb.next();
          
         TikTok.followBack(username);
      
         System.out.println(TikTok);
      
      }
   }

}
/*below is a sample driver. Do not remove this driver from your code when 
sub,itting it*/


 class Driver{
   public static void main(String[]args) {
      SocialMedia myInsta = new SocialMedia();
      
     /*Adding followers to your list*/
      /*the boolean field indicates whether you want to follow them back*/
      myInsta.follow("Matthew", "Philips", "MatPhil", true);
      myInsta.follow("Gary", "Kane",  "GKane", false); 
      myInsta.follow("Robert", "Kenny",  "RKenny", true); 
      myInsta.follow("Bill", "Fitch", "BillF",true);
      myInsta.follow("Trevor", "Schlulz", "TrevorS", false);
      
     /*Displaying your followers*/
      System.out.println("Your followers informations\n");
      System.out.println(myInsta);
    
      /*Unfollowing a user*/
      System.out.println("Removing Robert Kenny from your followers list");
      myInsta.remove("Robert", "Kenny");
   
      /*Displaying the list*/
      System.out.println("List of followers after removing Robert Kenny");
      System.out.println(myInsta);
   
      /*adding a new follower*/
      System.out.println("Adding Elon Musk to your list of followers");
      myInsta.follow("Elon", "Musk", "ElonM", true);
      
      /*Dipslying the followers*/
      System.out.println("List of your followers:");
      System.out.println(myInsta);
   
      /*Searching for a follower*/
      System.out.println("Searching for Stonewall Jackson(StonW) in your followers list");
      if(myInsta.search("Jackson", "Stonewall") == false) {
         System.out.println("Stonewall Jackson is not in your list of followers");
         System.out.println("\n***************************");   
         System.out.println("You are following " + myInsta.followerCounts() + " people");
      
         System.out.println("You have " + myInsta.followingCounts() + " followers");  
         System.out.println(myInsta);
         Scanner kb = new Scanner(System.in);
         System.out.println("Enter the username of the person that you want to follow back: ");
      
         String username =kb.next();
          
         myInsta.followBack(username);
      
         System.out.println(myInsta);
      
      }
   }
   }