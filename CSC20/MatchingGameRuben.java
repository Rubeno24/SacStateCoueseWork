/*
Ruben Ortega
9/15/22
This program ask the user for a range of numbers and then generates 3 random numbers
if 2 numbers match we add 200 to the total winnings and if 3 numbers match we add
500 to the winnings. The user can quit the game by press q twice
100/100
*/
import java.util.*;
public class MatchingGameRuben
{
   public static void main(String[] args)
  {
     //creates a scanner object for user input
     Scanner scnr = new Scanner(System.in);
     //blank string variable
     String answer = "";  
     //creates a random object that will be used to get random numbers
      Random rand = new Random();
     while (!answer.equalsIgnoreCase("q"))
     //this while loop will not stop until the users q
     {	
    	 description();
     //description method will welcome the user to the program
    	 System.out.print("What is your name: ");
    	 String name = scnr.nextLine();
       System.out.println("Hello "+name+" lets start playing");
      // the play method is where the majority of the game happens
      //we will pass our random object in the play method for use later
       play(rand);
      //once the play method is done the user can let another peson play or exit the program
       System.out.println("Hit enter to let another person play or enter Q to quit the program");
       answer = scnr.nextLine();
     }
     	System.out.println("Good Bye! Come Back soon to play again");
      
  }
 
	
   //All this method does is return a random number when called
   public static int getRand(Random rand, int max)
  {
  	int x=  rand.nextInt(max) + 1;
  	return x;
  }
 
  		
  		
  		
  public static void play(Random rand)
  {//we declare the variables we need here for later use. Total store the money the user wins
  	//anser store user input and stops the loop or keeps it going
  	//n1 n2 n3 store the randomly generated numbers
  	Scanner scnr = new Scanner(System.in);
  	int total = 0;
  	String answer = "";
  	int n1= 0, n2 = 0, n3 = 0;
  	//max variable store the range the user wants to generate there numbers
  	System.out.print("Enter the max value to generate a random number: ");
	int max=scnr.nextInt();
 	//this nextLine(); somehow fixes the program so it doesn't generate two outputs on one enter press
  	//another student and I asked our instructor and he helped us
  	scnr.nextLine();
  			
  	//while loop keeps going as long as user does not enter q
  		while(!answer.equalsIgnoreCase("q"))
     {//if input is not q we call the getRand method and store those numbers in n1 n2 n3
  		n1 =getRand(rand, max);
  		n2 =getRand(rand, max);
  		n3 =getRand(rand, max);
  		// then we print them
  		System.out.println("You got: "+ n1+" "+n2+" "+n3);   
       
  		//we call the match method to see if those numbers match.
  		//match method returns 2 if 2 numbers match or 3 if all match
  		int match = match(n1,n2,n3);
  		//if statements print out appropriate output and add 200 or 500 to total
  		if (match == 2)
       {
       
  	      System.out.println("You got two matches, you won 200 dollars");
  	      total+=200;
       }   
  	else if( match == 3)
       {
  	      System.out.println("You got three matches, you won 500 dollars");
  	      total+=500;
            
       }    
  	// no matches noting is added to total
  	else
  		{
  			System.out.println("Sorry no match");
  		}
        
     
  	System.out.print("\nHit enter to continue or press q/Q to quit  ");
  	System.out.println();
  	answer = scnr.nextLine(); 
  	//will prompt the user for input to quit or continue
  	//store into the answer variable, while loop ends if user enters q
       
       
             
     }//prints out the total store in the total variable 
  	System.out.println("\nTotal amount you won: " + total);
  	System.out.println("\n");
     
  }
  
  //this method accepts 3 numbers as arguments and compares them
  public static int match(int n1, int n2, int n3) 
  {
  	//if all 3 numbers match method returns 3
  	if (n1 == n2 && n2 == n3)  
   {
  		return 3;
  				
   }
  	//if 2 numbers match method returns 2
  	else if(n1 == n2 || n1 == n3 || n2==n3) 
   {
  	  	return 2;
  	}
  	//no matches returns 0
		return 0;
  }

  //just prints the welcome message
  public static void description()
  {
  	System.out.println("*************************************************************************");
  	System.out.println("*******************");
  	System.out.println("*	Welcome to number matching game. I will generate three random numbers");
  	System.out.println("	for you base on your input. If two      *");
  	System.out.println("* 	of the numbers match you win 200, if you get three matching numbers you");
  	System.out.println("	win 500 dollars   *");
  	System.out.println("*************************************************************************");
  	System.out.println("*******************");
  }
}