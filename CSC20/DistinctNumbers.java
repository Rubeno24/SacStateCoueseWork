/*
 Name: Ruben Ortega
 Date: 9/8/22
 Description: This program ask the user to enter numbers and removes the repeated numbers but does keep track of how many numbers were entered.
 The program keeps going until our array has 10 different numbers and when that is the case we print our array and print how many numbers
 were entered total
 Self Grade: 100/100
 Testimony: I have written this program all by myself and have not copied any code 
from any resourses: Ruben Daniel Ortega
 */
import java.util.*; 
public class DistinctNumbers 																//This method checks to see if our userInput is in the array.
{ 
	
		public static boolean isDistinct(int[] num, int n) 
		{
			for (int i =0; i<num.length;i++)												// For loop to iterate through array
			{																				
			    if (num[i]==n) 														// if statement to check if our number is in the array 
			    {																
			        return true;														// if number is found method will return true
			    }		
			}
			 return false;															// Not found method will return false
		}
		
		
		public static int getInput(int[] numbers) 												// Gets user input and stores into array if number not in array
		{									
			Scanner scnr = new Scanner(System.in);
			int userInput;
			int count=0;
			for(int i=0;i<numbers.length;i++) 
			{																// for loop to through array and ask the user for user input
				System.out.print("Enter a number: ");
				userInput = scnr.nextInt();												// user input using scanner
				count ++;														// each time the loop makes a loop our count variable will be in incremented
				boolean isFound=isDistinct(numbers,userInput);										// our boolean variable will be true or false depending on the is Distinct method
				if(isFound==true) 													// if true the number is in the array already and we need to decrement the loop
				{														
					i--;
					
				}
				
				else 
				{
					numbers[i]=userInput;												// this means it was false and we have to add the number into the array
				}
			}
			
			return count;															// count variable store the amount of numbers the user inputed
		}																	// we need that number so we return it for later use
   
		
		public static void display(int[] num, int counter) 											// this method prints our results and formats them
		{																								
			System.out.println("You entered "+counter +" numbers total, I filtered out all the repeated numbers.");
			System.out.println("Here is the list of distinct numbers you entered. ");
			System.out.print("{");
			for(int i =0; i<num.length-1;i++) 
			{																// for loop to iterate through the array. I made it so it goes to the second
				System.out.print(+num[i]+", ");												// to last element so a comma wont print on the last element
				
				
			}
			System.out.print(num[num.length-1]+"}");											// prints the last element without a comma to match output 

		}
		
		
		public static void main(String[] args) 													// call and pass in arguments into our methods here
		{																								
			 System.out.println("Welcome to the distinct numbers. ");
			 System.out.println("I will remove the repeated numbers and display the numbers you just enetered. As long as you have ");
			  System.out.println("not entered 10 distinct numbers I will keep prompting you to enter a number");
	
			 
			int[] arr = new int [10];													// creates an array with 10 elements
			int counter = getInput(arr);													// counter is assigned what getInput returns
			display(arr,counter);														// display method prints and formats our array and counter variable
		}
  
}