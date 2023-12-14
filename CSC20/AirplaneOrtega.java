/*
 Name: Ruben Ortega
 Date: 10/6/22
 Description: This program uses everything we learned about inheritance to create an airplane app
 we can add people to the airplane,delete people and print their information 
 Self Grade: 100/100
 Testimony: I have written this program all by myself and have not copied any code 
from any resourses: Ruben Daniel Ortega
 */
import java.util.*;
public class AirplaneOrtega//<------- chnage this name to include your last name
{
  //no code goes here
}
//The person class is the super class that other will extend
class Person{
   //class variables
	private String firstName;
	private String lastName;
	private String phone;
	
	//class constructor 
	public Person(String firstName, String lastName, String phone) 
   {
		this.firstName=firstName;
		this.lastName=lastName;
		this.phone=phone;
		
	}
	//getter and setter methods
	public void setFirst(String name) 
   {
		firstName=name;
	}
   
	public void setLast(String last) 
   {
		lastName=last;
	}
   
	public void setPhone(String phoneNumber) 
   {
		phone=phoneNumber;
	}

	public String getFirst() 
   {
		return firstName;
	}
   
	public String getLast() 
   {
		return lastName;
	}
		public String getPhone() 
   {
		return phone;
	}
   
	//To string method that another class will over ride
	public String toString() 
   {
		return "Name: "+ firstName+ "\n Name: "+lastName+
				"\n Phone: "+ phone;
	}
	//equals method checks to see if first and last name are equal
	public boolean equals(Object o) 
   {
		if(o instanceof Person) 
      {
			Person p = (Person)o;
			return (this.firstName.equalsIgnoreCase(p.firstName) && this.lastName.equalsIgnoreCase(p.lastName)) ;
		}
		
		return false;
	}
	
}
class Passenger extends Person{
   //Class variables
	private int seatNumber;
	private String classType;
	private String ticketID;
   //Class constructor 
	public Passenger(String first, String last, String ticketID, int seatNumber, String classType,String phone)
   {
      //We use the super keyword to use the person classes constuctor, and pass in these values
		super(first,last,phone);
		this.seatNumber=seatNumber;
		this.classType=classType;
		this.ticketID=ticketID;
	}
   //Getter and setter methods
	public void setTicketId(String ticketID) 
   {
		this.ticketID=ticketID;
	}
   
	public String getTicketId() 
   {
		return ticketID;
	}
   
	public void changeSeatNumber(int num) 
   {
		seatNumber=num;
	}
   
	public void setClass(String classs) 
   {
		classType=classs;
	}
	
	public String getClassType() 
   {
		return classType;
	}
	
	public int getSeat() 
   {
		return seatNumber;
	}
   
	//toString method we overide the person classes toString method
	public String toString() 
   {
		return super.toString()+"\n Seat Number: "+seatNumber+"\n Class: "+classType
				+ "\n TicketID: "+ticketID+"\n";
	}
	
	
}
//Interface whatever class extends the list interface has to use these methods
interface list {   
   public boolean add(Object o);
   public Object search(Object o);
   public boolean delete(Object o);
   public void printLast();
   public void takeOff();
}

//Airplane needs to use those methods above in the list interface
class Airplane implements list{
   //variabels and an array
   public static int count=0;
   private Passenger plane [];
   private boolean takenOff;
   private int planeNum;
   
   //class construtor   
   public Airplane(int planeNum) 
   {
	  this.planeNum=planeNum;
	  plane = new Passenger[10];
	  this.takenOff=false;
   }
   //setter and getter methods
   public void setPlaneNumber(int num)
   {
   		planeNum=num;
   }
   
  	public int getPlaneNumber() {
  		return planeNum;
  	}
   
  	public static int getCount() {
  		return count;
  	}
   //toString method
  	public String toString()
   {  
  		String s ="";
  		for(int i=0; i<plane.length;i++) 
      {  //if plane i doesnt equlal null 
  			if(plane[i]!=null) 
         //we set s = to what ever number the for loop is at 
         //so if the for loop is at 1 that means plane[1].toString
  			 s+=plane[i].toString()+"\n";
  		}
      //then we return S that has all the toString methods in it
		return s;
  	}
  	
   public boolean add(Object o) 
   {
	   if(o instanceof Passenger) 
      {  //typecasting o
		   Passenger p = (Passenger)o;
         //if the plane is not taken off we can still add people
		   if(takenOff!=true) 
         {  //adds p to whatever element count is at
			   plane[count]=p;
            //increment count
			   count++;
			   return true;
		   }
	   }
      return false;
   }
   
   public Object search(Object o) {
	   boolean b = o instanceof String; 
	   if(!b) 
	   return null;
	   String name = (String)o; 
	   for(int i = 0; i < plane.length; i++)
	   {
	    if(plane[i]!= null && plane[i].getLast().equalsIgnoreCase(name))
	    {
	    	return plane[i];   //returning the found object } 
	   }
	   }
	   return null;//returning null if the object is not found
   }
   
   public boolean delete(Object o) 
   {
	   boolean b = o instanceof String; 
	   if(!b) 
      {
	   return false;
	   }  
      
      // typecasting o again   
		 String l= (String)o;
       //for loop keeps going until i is greater than the length of plane
		 for (int i=0;i<plane.length;i++) 
       {
          //if plane at i is not null and the last name matches
			 if(plane[i]!=null && plane[i].getLast().equalsIgnoreCase(l)) 
          {  //plane[i] will be removed
				 plane[i]=null;
             //then we decrement count
				 count--;
				 return true;
			 }
		 }
		   
      return false;
   }
   
   //methods prints only the last name of the person
   public void printLast() 
   {
    for(int i=0;i<plane.length;i++) 
    {
      //if plane isnt null at i then we call the gesLast method to print the last name
    	if(plane[i]!= null)
    		System.out.println(plane[i].getLast());	
    }
   }
   
   //we call this method to say the plane has taken off
   public void takeOff() 
   {
	   takenOff=true;
   }
}

class Driver  {
   public static void main(String[]args) {
      Scanner in = new Scanner(System.in);
   
      Scanner kb = new Scanner(System.in);
      Airplane plane = new Airplane(817345);
      Passenger p1 = new Passenger("Bobbys", "Smith", "123456789", 1, "First  class", "916-222-3333");
      Passenger p2 = new Passenger("Johnny", "Apples", "987654321", 8, "Business class", "818-000-1234");
      Passenger p3 = new Passenger("Tommy", "Jerrys", "567123489", 32, "Economy class","202-222-3333");
      Passenger p4 = new Passenger("Candy", "Cruze", "982134567", 15, "Premium Economy class","707-444-5555");
      
      //this passenger will be added after take off
      Passenger p5 = new Passenger("Kalotiii", "Aaronn", "762134589", 5, "Economy plus","817-222-6666");
      
      plane.add(p1);
      plane.add(p2);
      plane.add(p3);
      plane.add(p4);
      System.out.println("The palne is about to take off");
      plane.takeOff();
      System.out.println("adding a passenger after take off");
      plane.add(p5);
      String repeat = "";
      while(Airplane.getCount() > 0) 
      {
      
         System.out.println("Here is the list of the passengers in this plane");
         System.out.println("There are " + Airplane.getCount() + " Passengers on this plane"); 
         System.out.println(plane + "\n");
      
         System.out.println("Testing the printLast method to display the last names");
         plane.printLast();  
         System.out.println();
         
         System.out.println("Testing the static method getCount");
         System.out.println("This train has " + Airplane.getCount() + " Passengers\n");
         
         System.out.print("Enter the last name of the passenger to search for: ");
         String lastName = in.nextLine();
         System.out.println(plane.search(lastName));
         System.out.println();
         
         System.out.println("Testing the delete method");
         System.out.print("Enter the last name of the passenger to be deleted: ");
         String last = in.nextLine();
         plane.delete(last);
         System.out.println("Passenger " + last + " has been removed from the list\n");
         
         System.out.println("Here is the updated list");
         System.out.println(plane);
         System.out.println("*********************");
         System.out.print("Press any key to continue : ");
         repeat = kb.nextLine();
      }
      System.out.println("No passenger left on this airplane");
   
   }
}

class rubensDriver
{  public static void main(String[]args) {
   Scanner in = new Scanner(System.in);
   
   Scanner kb = new Scanner(System.in);
   Airplane United = new Airplane(209);
   Passenger p1 = new Passenger("Ruben", "Ortega", "123456789", 1, "First  class", "916-222-3333");
   Passenger p2 = new Passenger("Kobe", "Bryant", "987654321", 8, "Business class", "818-000-1234");
   Passenger p3 = new Passenger("Lebron", "James", "567123489", 23, "Economy class","202-222-3333");
   Passenger p4 = new Passenger("Michael", "Jordan", "982134567", 23, "Premium Economy class","707-444-5555");
   Passenger p5 = new Passenger("Shaq", "Oneal", "762134589", 34, "Economy plus","817-222-6666");

   
      
      United.add(p1);
      United.add(p2);
      United.add(p3);
      United.add(p4);

      System.out.println("The plane is about to take off");
      United.takeOff();
      System.out.println("adding a passenger after take off");
      United.add(p5);
      String repeat = "";
      while(Airplane.getCount() > 0) 
      {
      
         System.out.println("Here is the list of the passengers in this plane");
         System.out.println("There are " + Airplane.getCount() + " Passengers on this plane"); 
         System.out.println(United + "\n");
      
         System.out.println("Testing the printLast method to display the last names");
         United.printLast();  
         System.out.println();
         
         System.out.println("Testing the static method getCount");
         System.out.println("This train has " + Airplane.getCount() + " Passengers\n");
         
         System.out.print("Enter the last name of the passenger to search for: ");
         String lastName = in.nextLine();
         System.out.println(United.search(lastName));
         System.out.println();
         
         System.out.println("Testing the delete method");
         System.out.print("Enter the last name of the passenger to be deleted: ");
         String last = in.nextLine();
         United.delete(last);
         System.out.println("Passenger " + last + " has been removed from the list\n");
         
         System.out.println("Here is the updated list");
         System.out.println(United);
         System.out.println("*********************");
         System.out.print("Press any key to continue : ");
         repeat = kb.nextLine();
      }
      System.out.println("No passenger left on this airplane");
   
   }

   
}