
/*
Name: Ruben Ortega
date: 11/28/22
Description: In this assignment we were given a remade queue class and we had to implement
methods so the driver could run and it could match the output
self grade 100/100 I matched the output and even altered the program so it works with different.
My own driver is made with an array and it to matches the output.
inputs
*/

import java.util.*;

public class QueueLastOrtega // <------ change the name of the class to include yourlast name
{
   // no code goes here
}

class arrays 
{
   private String q[];
   // Used a front and back to simulate adding and removing to an array since
   // we really cant remove from an array since its dynamic
   private int front = 0;
   private int back = 0;

   // constructor and initializes our array
   public arrays() 
   {
      q = new String[20];
   }

   public void enqueue(String num) 
   {
      // adds an element to the back of our array
      q[back] = num;
      // increments back to simulate the back moving
      back++;
   }

   public String dequeue() 
   {
      int i;
      // goes to the simulated front of array and assigns the first element to q[i]
      for (i = 0; i < back - 1; i++) 
      {
         q[i] = q[i + 1];
      }
      // decrements back to simulate an element leaving the queue
      back--;
      //returns the first element
      return q[i];

   }

   // visual representation of our queue
   public String toString() 
   {
      String s = "";
      for (int i = front; i < back; i++) 
      {
         s += q[i] ;
      }
      return s;
   }

   public String getLongestName() 
   {
      boolean b = false;
      int front1 = front;
      String longest = q[front];
      try {

         while (!b) 
         {

            String name = q[front1];// get the first element
            front1++;
            // compares to find the longest name
            if (name.length() > longest.length())
               longest = name;
         }

      }
       catch (Exception e) 
      {

         b = true;
      }
      // returns the longest name
      return longest;

   }

   // Same as hte longest name but gets shortest name
   public String getShortestName() {
      boolean b = false;
      int front1 = front;
      String shortest = q[front];
      try {

         while (!b) 
         {
            String name = q[front1];// get the first element
            front1++;
            if (name.length() < shortest.length())
               shortest = name;
         }

      } 
      catch (Exception e) 
      {
         b = true;
      }
      return shortest;

   }

   public void listReversed() 
   {
      // i starts at the last element of our array and stops when it greater or equal
      // to zero
      for (int i = q.length - 1; i >= 0; i--)
       {
         // only prints an element if its not null
         if (q[i] != null) {

            System.out.print(q[i] + " ");
         }

      }
   }

   public double getAverageLength() 
   {
      double sum = 0, average = 0, count = 0;
      boolean b = false;
      int front1 = front;
      try {

         while (!b) 
         {
            String name = q[front1];// get the first element
            front1++;
            sum += name.length() - 1.00;
            count++;
         }

      } 
      catch (Exception e) 
      {

         b = true;
      }

      average = sum / count;
      return average;

   }

   public boolean ordered() 
   {
      boolean b = false;
      int front1 = front;
      boolean s = true;
      try {

         while (!b) 
         {
            // gets the first and second elements and stores them in variables to compare
            String firstElement = q[front1];
            front1++;
            String secondElement = q[front1];
            front1++;
            //compares them using compare to method returns false if greater than 0
            if (firstElement.compareTo(secondElement) > 0) 
            {
               s = false;
            }
         }

      } 
      catch (Exception e) 
      {
         b = true;
      }
      return s;
   }

   // I created copy array called q1
   public boolean isPalindrome() 
   {
      String q1[] = new String[20];
      boolean b = false;
      int count = 0;
      while (!b) 
      {
         try {
            // used a for loop to copy the elements from the orginal q in reverse
            for (int i = q.length - 1; i >= 0; i--) 
            {
               //check to see if elements are null so we can add to the copy
               if (q[i] != null) 
               {
                  q1[count] = q[i];
                  count++;

               } 
               else 
               {
                  b = true;
               }
            }

         } 
         catch (Exception e) 
         {

            b = true;
         }

      }
      // I then compared both arrays and if they were equal it would return false
      // other wise it would return false
      boolean boolval = Arrays.equals(q, q1);

      return boolval;

   }
}

class Queue {
   private ArrayList<String> q;

   // class constructor
   public Queue() 
   {
      q = new ArrayList<String>();

   }

   // how we add elements to our Queue
   public void enqueue(String num) 
   {
      q.add(num);
   }

   // how we delete elements from our Queue.
   // can only delete the first element in the Queue
   public String dequeue() 
   {
      return q.remove(0);
   }

   /*
    * This method goes through the Queue and finds the longest name in the q
    * The queue must be restored in its original state after finding the longest
    * name
    */
   public String getLongestName() 
   {
      Stack s = new Stack();
      String longest = q.get(0);
      // q.remove(0);
      boolean b = false;
      while (!b) 
      {
         try 
         {
            String front = this.dequeue();// get the first element
            s.push(front);// push it to the stack
            if (front.length() > longest.length())
               longest = front;

         } 
         catch (Exception e) 
         {
            b = true;
         }

      }
      restore(s); // restoring the queue
      return longest;

   }

   /*
    * Traverse through the queue and creates a string containing all the names.
    * must restore the quque to its original state
    */
   public String toString() 
   {
      Stack c = new Stack();
      String s = "";
      boolean b = false;
      while (!b) {
         try 
         {
            s = s + q.get(0) + " ";
            c.push(q.remove(0));
         } 
         catch (Exception e) 
         {
            b = true;
         }
      }
      restore(c);
      return s;
   }

   /*
    * This method is called to restore the queue to its original state
    */
   public void restore(Stack s) 
   {
      boolean b = false;
      while (!b) 
      {
         try 
         {
            if (s.isEmpty())
               throw new Exception();
            String a = (String) s.pop();
            q.add(0, a);
         } 
         catch (Exception c) 
         {
            b = true;
         }
      }
   }

   /*
    * this method goes through the queue finding the shortest name
    * The queue must be restored to its original state
    * this method is similar to the longest name
    */
   public String getShortestName() 
   {
      Stack s = new Stack();
      String shortest = q.get(0);
      // q.remove(0);
      boolean b = false;
      while (!b) 
      {
         try 
         {
            String front = this.dequeue();// get the first element
            s.push(front);// push it to the stack
            if (front.length() < shortest.length())
               shortest = front;

         } 
         catch (Exception e) 
         {
            b = true;
         }

      }
      restore(s); // restoring the queue
      return shortest;
   }

   /* This method reverses the order of the names in the queue */
   public void listReversed() 
   {
      Stack s = new Stack();
      boolean b = false;
      while (!b) 
      {
         try {
            // gett the first element from the Queue and stores it in a stack
            String front = this.dequeue();
            s.push(front);

         } 
         catch (Exception e) 
         {
            b = true;
         }
      }
      b = false;
      while (!b) 
      {
         try {
            // gets the first element in the stack and stores it in the Queue
            // it will be reversed since the stack is a last in first out data struture
            String poppedEllement = (String) s.pop();
            this.enqueue(poppedEllement);
         } 
         catch (Exception e) 
         {
            b = true;
         }
      }

   }

   /*
    * This method finds the average length of the length of all the names in the q
    * queue must be restored to its original state
    */
   public double getAverageLength() 
   {
      double sum = 0, average = 0, count = 0;
      Queue copy = new Queue();
      Boolean b = false;
      while (!b) 
      {
         try {
            // we get an element from our original Queue and store in our copy Queue
            String name = this.dequeue();
            copy.enqueue(name);
            // we then call the length method to see how long each element is and store into
            // a variable
            sum += name.length();
            count++;
         } 
         catch (Exception e) 
         {
            b = true;
         }
      }
      // we call the preserve method and send in our copy Queue to restore our orginal
      // Queue
      preserve(copy);
      // we find the average by dividing sum by the count of elements in our Queue
      average = sum / count;
      return average;

   }

   /*
    * This method returns true if the q is sorted alphabetically
    * Queue must be restored to its original state
    * This method gave me alot of trouble but I did get it work for even
    * and odd number of elements.
    */
   public boolean ordered() 
   {
      Queue copy1 = new Queue();
      Queue copy = new Queue();
      boolean b = false;
      boolean s = true;

      /*
       * so I made 2 copies of the orginal Queue. I got the first element
       * and stored inside the content varibale. Then I added that varibale to
       * my copy and copy1 Queue. copy1 is going to act as our orginal Queue
       * since I destroyed the orginal making the 2 copies. We are going to
       * leave copy untouched to use the preserve method on it.
       */
      while (!b) 
      {
         try 
         {
            String content = this.dequeue();
            copy1.enqueue(content);
            copy.enqueue(content);
         } 
         catch (Exception e) 
         {
            b = true;
         }
      }

      // So this part of the method is troublesome.
      b = false;
      while (!b) 
      {
         try 
         {
            /*
             * Copy1 has all the elements as our first q we defined so i dequeued 2
             * elmements and
             * stored them into first1 and second2 to be compared.
             */
            String first1 = copy1.dequeue();
            String second1 = copy1.dequeue();

            /*
             * There is no point to enqueue the elements back to q since if the number is
             * elements
             * is odd it will skip the last element and that will effect further methods in
             * the future
             * I made this program work with odd and even number inputs
             */
            // q.enqueue (first);
            // q.enqueue (second);

            // compares to see if they are in order and assigns false if they are not
            if (first1.compareTo(second1) > 0) 
            {
               s = false;
            }
         }

         catch (Exception e) 
         {
            b = true;
         }

      }
      // we call preserve on a fresh Queue so our Queue can go back to its
      // orginal state
      preserve(copy);

      return s;
   }

   /*
    * this method returns true if the queue is palindrom and returns false
    * otherwise
    * call the method copy in the palindrome method
    */
   public boolean isPalindrome() 
   {
      Stack s = new Stack();
      boolean b = false;
      // I created a copy of the q and named it copylist and added every element from
      // the q into the copy
      ArrayList<String> copyList = new ArrayList<String>();
      copyList.addAll(q);

      while (!b) 
      {
         try 
         {
            // got the first element of the copy and stored into a stack so we can reverse
            // it
            String element = copyList.get(0);
            copyList.remove(0);
            s.push(element);// push it to the stack
         } 
         catch (Exception e) 
         {
            b = true;
         }
      }

      b = false;
      while (!b) 
      {
         try 
         {
            // added all the elements from the back into the arraylist named copyList
            // but now copyList has the elements in reverse order
            String element = (String) s.pop();
            copyList.add(element);

         } 
         catch (Exception e) 
         {
            b = true;
         }
      }
      // created a boolean and compared the orginal q to our copyList
      // If they are equals its a isPalindrome since q has the orginal elements
      // and copyList has them in reverse boolval will return true. if they are not
      // equal boolval will return false
      boolean boolval = q.equals(copyList);
      return boolval;
   }

   public void preserve(Queue q) 
   {
      boolean b = false;
      while (!b)
       {
         try 
         {
            this.enqueue(q.dequeue());
         } 
         catch (Exception e) 
         {
            b = true;
         }
      }
   }

}

class Driver {
   public static void main(String[] args) {
      // String[] names = { "Alexis", "Zoeehra", "Maryam", "Jose", "Bill", "Niksan",
      // "BB" };
       String[] names = {"a", "b", "c", "b","a"};
      //String[] names = { "h", "a", "n", "n", "a", "h" };
      // String[] names = { "a", "a", "a", "a","a"};
      // String[] names = { "a", "b", "c", "d", "e", "f" };
      Queue people = new Queue();
      // enqueue the queue using the array called names
      for (int i = 0; i < names.length; i++) {
         people.enqueue(names[i]);
      }

      System.out.println("The q of the people at Bestbuy on black Friday : " + people);
      people.listReversed();
      System.out.println("The q of the people in the reverse order is: " + people);
      people.listReversed();
      System.out.println("List is back to its original state: " + people);
      System.out.printf("Average length of all the Strings in the q is = %.2f\n", people.getAverageLength());

      System.out.println("The longest name in the q is = " + people.getLongestName());
      System.out.println("The shortest name in the q is = " + people.getShortestName());
      System.out.print("is the list of the people sorted? ");
      if (people.ordered())
         System.out.println("Yes");
      else
         System.out.println("No");
      if (people.isPalindrome())
         System.out.println("The list is a palindrome");
      else
         System.out.println("The list is not apalindrome");
      System.out.print(people.isPalindrome() + "\n");
      System.out.println("List is back to its original state: " + people);
   }
}

/*
 * create your own driver(15 points)
 * In this driver must use an array q otherwise you will not get any points
 */
class YourDriver {
   public static void main(String[] args) {
      // String[] names = { "Alexis", "Zoeehra", "Maryam", "Jose", "Bill", "Niksan",
      // "BB" };
      //String[] names = { "a", "b", "c", "b", "a" };
      //String[] names = {"h", "a", "n", "n","a","h"};
       String[] names = { "a", "b", "c", "d", "e", "f" };
      // String[] names = { "a", "a", "a", "a","a"};
      arrays people = new arrays();
      for (int i = 0; i < names.length; i++) {
         people.enqueue(names[i] + " ");
      }
      System.out.println("The q of the people at Bestbuy on black Friday : " + people);

      System.out.print("The q of the people in the reverse order is: ");
      people.listReversed();

      System.out.println("\nThe longest name in the q is = " + people.getLongestName());
      System.out.println("******************");
      System.out.println("The shortest name in the q is = " + people.getShortestName());
      System.out.printf("Average length of all the Strings in the q is = %.2f\n", people.getAverageLength());
      System.out.print("is of the list of the people is sorted? ");
      if (people.ordered())
         System.out.println("Yes");
      else
         System.out.println("No");
      if (people.isPalindrome())
         System.out.println("The list is palindrome");
      else
         System.out.println("The list is not palindrome");
      System.out.println(people.isPalindrome());
      System.out.println("List is back to its original state: " + people);
      // 4. call all the methods similar to the given driver.

   }
}
