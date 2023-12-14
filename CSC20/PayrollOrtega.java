/*
 Name: Ruben Ortega
 Date: 9/24/22
 Description: This program uses object oriented programming to create another class and make objects to simulate 
 the payroll for employees
 Self Grade: 100/100
 Testimony: I have written this program all by myself and have not copied any code 
from any resourses: Ruben Daniel Ortega
 */
class Payroll
{	//private variables so only this class can access them
	private String Name;
	private String id;
	private double hourlyRate;
	private double HoursWorked;
	   
	//constructor to initialize variables
	public Payroll(String Name, String id,double hourlyRate,double HoursWorked)
	{
	this.Name=Name;
	this.id=id;
	this.HoursWorked=HoursWorked;
	this.hourlyRate=hourlyRate;
	}
	
	//setter methods can initialize the variable or change the name
	
	public void setName(String Name) 
	{
		this.Name=Name;
	}
	
	public void setId(String id) 
	{
		this.id=id;
	}
   
   
	public void setHourlyRate(double hourlyRate) 
	{
		this.hourlyRate=hourlyRate;
	}
	
	
	public void setHoursWorked(double HoursWorked) 
	{
		this.HoursWorked=HoursWorked;
	}
   
	//getter methods return the whats in the variable without giving other classes direct access
	
   public String getName() 
   {
	   return Name;
   }
   
   
   public String getId() 
   {
	   return id;
   }
   
   
   public double getHourlyRate() 
   {
	   return hourlyRate;
   }
   
   public double getHoursWorked() 
   {
	   return HoursWorked;
   }
   
   //Used the getPay method to get the normal pay and the overtime pay using an if statement
   // if hours is 40 or less return normal pay else return overtime pay
   public double getPay() 
   {
	   if(HoursWorked<=40) 
	   {
		   return HoursWorked* hourlyRate;
	   }
		   
	   return 40*hourlyRate+(HoursWorked-40)*(hourlyRate+hourlyRate *.20);
	   
   }
   
   
   public double getOvertimePay() 
   {
	   if(HoursWorked>=40) 
	   {
		   return (HoursWorked - 40 )* (hourlyRate + hourlyRate * .20);
	   }
	   return 0;
   }

   //get raise methods changes the hourly rate or returns a message when raiseAmount is negative
   public void getRaise(double raiseAmount)
   {
	   if (raiseAmount>0) 
	   {
	   hourlyRate= hourlyRate+raiseAmount;
	   }
	   else 
	   {
		   System.out.println("Raise must be a postitve number");
	   }
		   
   }

   //toSting method just returns the object as a string which is formated to print the info of the user
   public String toString()
   {
	   return "Name: " + Name +"\n"+
			   "ID: "+ id+"\n"+"Hours Worked: "
			   + HoursWorked+"\n"+"Hourly Rate: "+hourlyRate;
   }
   
}
   
public class PayrollOrtega
{
	public static void main(String[] args)
  {
   
	      System.out.println("Cretaing payroll objects");
	      Payroll p2 = new Payroll("Ali Santos", "986747", 125, 45);
	      System.out.println("testing the toString method");
	   
	     
	      System.out.println("\n*******************");
	      System.out.println(p2);
	      System.out.println("Salary is : " + p2.getPay());
	      System.out.println("Overtimepay is : " + p2.getOvertimePay()); //calling the 
	     // getPay method
	      p2.getRaise(2); // calling the raise method
	      System.out.println("Your salary after getting 2$ raise per hour");
	      System.out.println("Salary is : " + p2.getPay()); //calling the getPay method
	      System.out.println("Overtimepay is : " + p2.getOvertimePay()); //calling the 
	      //getPay method
	      
	              
	      System.out.println("\n*******************");
	      System.out.println("\nTesting the setter methods");
	      System.out.println("The hourly pay of " + p2.getName() + " is being chnaged");
	      p2.setHoursWorked(80); // changing the hours worked for the object p1
	      System.out.println(p2);
	      
	      
	      //1. creates one object of the payroll class 
	      Payroll myPerson = new Payroll("Ruben", "2092423",50,45);
	      
	      
	      //2. display the objects on the screen by calling the toString method
	      System.out.println("\n*******************");
	      System.out.println(myPerson);
	     
	   
	      //3. display the salary of the person by calling the getPay method
	      System.out.println("Salary is : " + myPerson.getPay());
	      
	      
	      
	      //4. display the overtime salary
	      System.out.println("Overtimepay is : " + myPerson.getOvertimePay());
	      System.out.println("\n*******************");	
	      
	      
	      //5. give a raise of 5 dollars to the person
	      myPerson.getRaise(5); // calling the raise method
	      System.out.println("Your salary after getting 5$ raise per hour");
	     
	      
	      //6. display the new salary
	      System.out.println("Salary is : " + myPerson.getPay());
	      
	      
	      //7. display the overtime salary
	      System.out.println("Overtimepay is : " + myPerson.getOvertimePay());
	       
	   
	      //8. change the hourlyRate of the objects you created to 34
	      System.out.println("\n*******************");
	      System.out.println("The hourly pay of " + myPerson.getName() + " is being changed");
	      myPerson.setHourlyRate(34); 
	      
	      
	      
	      //9. display the objects again to see the changes you made by calling the 
	      System.out.println(myPerson);
	      System.out.println("Salary is : " + myPerson.getPay());
	      System.out.println("Overtimepay is : " + myPerson.getOvertimePay());
	      System.out.println("\n*******************");
	      
	      //10. change the hours worked for the objects you created by calling the setter
	      System.out.println("The hours for "+ myPerson.getName()+" is being changed");
	      myPerson.setHoursWorked(30);
	      
	      
	      //11. display your object again to see the changes you made
	      System.out.println(myPerson);
	      System.out.println("Salary is : " + myPerson.getPay());
	      System.out.println("Overtimepay is : " + myPerson.getOvertimePay());
	       
	   
	   
	   }
	  }


