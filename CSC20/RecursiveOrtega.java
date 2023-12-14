import java.util.*;
import java.lang.*;
public class RecursiveOrtega  //<-------------change this class name to include your last name
{
   // no code here
}
 
/*This class implements some methods recursively.
All the methods in this class are static, to call the methods you need to use the 
class name
such as Recursive.equals
Refer to the driver class*/
class Recursive 
{
   
   /*This method accepts an arraylist of string objects, returns true if the list 
   is palindrome and returns false othrewise
   must be implemented recursively. no loop can be used. 
   Using array instead of arraylist will not get any points
   you can not add variable to the list of the parameters for the method
   This method compares the first element with the last element,
   removes the first and last element. */
   public static boolean palindrome(ArrayList<String> list)   
   {
      if(list.size()==0 || list.size()==1){
         return true;
      }
      
      boolean x =  list.get(0).equals(list.get(list.size()-1));
       list.remove(0);
       list.remove(list.size()-1);
      return (x && palindrome(list));
      
   }
   /*This method gets a string and finds the sequence of the asccii codes in the given string
   for example if the string is "abcdef" then the return must be " 97 98 99 100 101102" each number
   represents the ascci code for each letter in the given String
   this method recursively gets the asccii code of the first letter in the string, removes the first letter
   calls the asccii method with the shorter string.
   to remove the first letter from a string we can use the substring method
   if  s ="abcd" then s =s.substring(1) will store bcd in the vaiable s
   The string s will become shorer with each recursive call until the length becomes zero 
   the asccii code of a letter can be found : (int)(s.charAt(0)) */
   public static String ascii(String s)  
   {
      if(s.length()==0){
         return "";
      }
     //1. if the length of the string is return ""  (base case)
     
     return" "+ (int)(s.charAt(0))+ascii(s.substring(1)) ;
             
      
   }
   /*This method gets an array list and a string, return the longets string in the list
   This method must be implemented recursively, no loop can be used
   as you go through the list you need to make the list shorter by removing the first element in the list
   until the size of the list becomes zero*/
   public static String longest(ArrayList<String> list, String longest)  
   {
      if(list.size()==0){
         return longest;
      }
      
      if(longest.length()<list.get(0).length())
      //2.if the length of the vaiable longest is less than the length of the string at index 0
      {
            longest=list.get(0);
            list.remove(0);
           
      }
      else 
         list.remove(0);  
              
               
      return longest(list, longest);
       
   }
   /*This method compares two arraylists to see if they conatin the same values in the same order
    this method compares the element at index 0, if they are not the same it returns false
    if the elements at the index 0 are the same, remove the elemnet at index 0 
    then call the method equals. 
     
   */
   public static Boolean equals(ArrayList<String> list1, ArrayList<String> list2)  
   {
      if(list1.size()!=list2.size()){
         return false;

      }
      if(list1.size()==0 || list2.size()==0){
         return true;
      }
       
      if(list1.get(0)!=list2.get(0)){
         return false;

      }
        
       list1.remove(0);
       list2.remove(0);
        
      
              
      return true && equals(list1,list2); 
   }
   
   /*This method gets a link list of string values. 
   finds the sum of the length of all the strings stored in the list
   at every recursive call the size of the list must get smaller.
   */
   public static int wordsSumLength(LinkedList<String> list)      
   {
      if(list.size()==0){
         return 0;
      }
      int size = list.get(0).length();
      list.remove(0);   
       
      //remove the element at the index 0
      
       return size + wordsSumLength(list);
     
   } 
} //end of class
class Driver
{
   public static void main(String [] args)
   {
      System.out.println("testing the palindrom method");
      String[] words = {"Hello","Bye","Car","Watches","Cat","Dog","Houses","Chair","Computers"};
      System.out.println(Arrays.toString(words));
      ArrayList<String> list = new ArrayList<String>();
      //filling in the arraylist
      for(int i = 0; i <words.length; i++)
         list.add(words[i]);
      //testing the palindrom method    
      System.out.print(Arrays.toString(words) + " is palindrome?  ");
      System.out.println(Recursive.palindrome(list));
      //creating another arraylist
      ArrayList<String> list2 = new ArrayList<String>();
      list2.add("1");
      list2.add("23445");
      list2.add("3455");
      list2.add("2rtrtryty");
      list2.add("1rttrt");
      //testing the palindrome method
      System.out.print(list2 + " is palindrome?  ");
      System.out.println(Recursive.palindrome(list2));
      ArrayList<String> list4 = new ArrayList<String>();
      list4.add("a");
      list4.add("b");
      list4.add("c");
      list4.add("b");
      list4.add("a");
      System.out.print(list4 + " is palindrome?  ");
      System.out.println(Recursive.palindrome(list4));
      
      //*******************testing the ascii method      
      System.out.println("\ntesting ascci metod");
      String s ="abcdef"; 
      System.out.println("The list of the asccii code in the string " + s  + " is "+ Recursive.ascii(s));
      
      //**************************testing the longest method
      //filling in the array list
      for(int i = 0; i <words.length; i++)
         list.add(words[i]);
      System.out.println("\ntesting longest string in the list of string" + list.toString());
       
      System.out.println("The longest string is the list " + list.toString() + 
         " is " + Recursive.longest(list,""));
      //*********************************************************   
        //testing the equlas method 
         
      for(int i = 0; i <words.length; i++) // rebuilding the list
         list.add(words[i]); 
      System.out.println("\ntesing the equals method on two arraylist");
      
      System.out.println("first list: " + list);
      System.out.println("second list: " + list2);
      System.out.println("Are the two list equal: " + Recursive.equals(list,list2)); 
      ArrayList<String> list5 = new ArrayList<String>();
      for(int i = 0; i <words.length; i++)
         list5.add(words[i]); 
      System.out.println("first list: " + list);
      System.out.println("second list: " + list5);
      System.out.println("Are the two list equal: " + Recursive.equals(list,list5));      
      
      //testing the length method     
             
      System.out.println("\ntesting the sum of the integers in a link list");
      LinkedList<String> list3 = new LinkedList<String>();
      list3.add("aaaa");
      list3.add("abababab");
      list3.add("abcabcabcabc");
      list3.add("bbbcccdddeee");
      System.out.println("The average length of the string in the list " + list3);
      System.out.println(" is " + Recursive.wordsSumLength(list3)); 
   
   }
} 