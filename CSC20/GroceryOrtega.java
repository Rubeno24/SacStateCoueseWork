/*
 Name: Ruben Ortega
 Date: 10/24/22
 Description: In this program we learned about linked lists. We added all the methods that an arraylist would 
 have to a linke list. We then created a grocery application, where we can print,add and remove grocery
 items using linked list.
 Self Grade: 100/100
 Testimony: I have written this program all by myself and have not copied any code 
from any resourses: Ruben Daniel Ortega
 */
import java.util.Scanner;
public class GroceryOrtega 
{
   //no code goes here
}
  //class item will be used to create objects and add to our linked list
  //implents the Comarable interface so we can compare objects
  class Item implements Comparable<Object>
  {
   //private variables
   private String name;
   private double price;
   private String expDate;
   private String barcode;
   
   
   
   // constructor
	  Item(String name, double price, String expDate, String barcode)
   {
		  this.name=name;
		  this.price=price;
		  this.expDate=expDate;
		  this.barcode=barcode;
       
   }
   //getter method
   public String getName() 
   {
      return name;
   }
   
   //getter method
   public double getPrice() 
   {
      return price;
   }
   
   //getter method
   public String getExpDate() 
   {
      return expDate;
   }
   
   //getter method
   public String getBarcode()
   {
      return barcode;
   }
   
   //setter method
   public void setName(String name) 
   {
       this.name=name;
   }
   
   //setter method
   public void setPrice(double price) 
   {
      this.price=price;
   }
   
   //setter method
   public void setExpDate(String expDate) 
   {
       this.expDate=expDate;
   }
   
   //setter method
   public void setBarcode(String barcode)
   {
       this.barcode=barcode;
   }
   
   //compares two objects for equality based on the barcode of the object
   public boolean equals(Object o) 
   {
	   Item s =(Item)o;
      return this.barcode.equals(s.barcode);
   }
   
   //compares two objects baned on the name of the objects, 
   //if the names are the same then compare based onthe barcode
   public int compareTo(Object o) 
   {
	   Item s =(Item)o;
	 
      if(this.name.equals(s.name)) 
      {
    	  return this.barcode.compareTo(s.barcode);
      }
      return -1;
   }
   
   /* create a string representing the item object and returns it*/
   public String toString() 
   {
      return   "\n Barcode: "+ barcode + "\n Name: " + name+
    		  "\n Price: "+price + "\n Expiration Date: " + expDate;
   }
}

class ListNode{
   //hold the data of the node
   private Item item;
   //refrence to the next node
   private ListNode next;
   
   //empty constructor
   public ListNode()
   {
	   
   }
   
   //one parameter constructor
   public ListNode(Item item) 
   {
      this.item = item;
   }
   
   //two parameter constructor
   public ListNode(Item item, ListNode next) 
   {
      this.item = item;
      this.next = next;
   }
     
   //getter method
   public Item getItem() 
   {
	   return item;  
   }
   
   //getter method
   public ListNode getNext() 
   {
	   return next;
	   
   }
   
   //setter method
   public void setNext(ListNode next) 
   {
	   this.next=next;
   }
  
}

//interface with methods that GroceryList class has to implement
interface List
{
   public void add(String food, double price, String expDate, String barcode);
   public void add(int index, String name, double price, String expDate, String barcode);
   public int indexOf(String barcode);
   public Item remove(String barcode);
   public int getSize();
   public String toString();
   public Item get(int index);
   public Item mostExpensive();
   public Item leastExpensive();
}

class GroceryList implements List{
  //instance variables
   private ListNode head;
   public static int size = 0;
 
   //constructor
   public GroceryList() {
      head = null;
   }
   //constructor
   public GroceryList(Item i) {
      head = new ListNode(i);
      size++;
   }
   //This method creates an Item object, finds the end of the list and adds it to the end
   public void add(String name, double price, String expDate, String barcode)
   {
      //creates an object named s that will be added at the end of the list
	   Item s = new Item(name,price,expDate,barcode);
	   ListNode current =head;
	   
      //if list is empty s will be added to the list and size is increased
	   if(head==null) 
      {
		   head=new ListNode(s);
		   size++;
		   return;  
	   }
      //creates a new list node named n to be added to the end of the list
	   ListNode n = new ListNode(s);
	   
      //once null is found that is the end of the list and we will add our object there
	   while(current.getNext()!=null) 
      {
		   current=current.getNext();
	   }
	   current.setNext(n);
	   size++;
	   
   }
   /* creates an item object, finds the given index, adds the item at the given 
index*/
   public void add(int index, String name, double price, String expDate, String barcode) {
	   Item s = new Item(name,price,expDate,barcode);
	   
      //index greater than size so we dont do anything
	   if(index>size) 
      {
		   return;
	   }
	   
      //index is 0 so we add the object there and make it the head of the list
	   if(index==0)
       {
		   ListNode n = new ListNode(s);
		   n.setNext(head);
		   head = n;
		   size++;
		   return;
		   
	   }
      
	   //adds the object in the list based on the index
	   ListNode current =head;
	   int i=0;
	   while(current.getNext()!=null&&i<index-1) {
		   current = current.getNext();
		   i++;
	   }
	   ListNode n = new ListNode(s);
	   n.setNext(current.getNext());
	   current.setNext(n);
	   size++;
	   
	   
   }
   
         
   /*searches the list for the given barcode and returns the index of the item with
the given barcode*/   
   public int indexOf(String barcode) 
   {  //empty list return -1
	   if(head ==null) 
      {
		   return -1;
	   }
      
      //barcode is the head we return 0
	   if(barcode.equals(head.getItem().getBarcode())) 
      {
         return 0;
      }
	   
	   ListNode current =head;
	   int index = 0;
      
      //returns where the barcode is found as the index
	   while(current!=null && index<=size) 
      {
		   if(current.getItem().getBarcode().equals(barcode))
			   return index;
		   current =current.getNext();
		   index++;
	   }
      //none of the cases triggred return -1 by default
	   return -1;
   }
   
   /* searches the list for the given barcode, removes the item from the list and 
returns the removed item*/
   public Item remove(String barcode) 
   {  //created an item variable since the method returns something of type item
	   Item deleted = null;
      
      //empty list
	   if(head ==null) 
      {
		   return null;
	   }
      
      //head is the target we go to the next node and make it the head
	   if(head.getItem().getBarcode().equals(barcode)) 
      {
		   head=head.getNext();
	
	   }
	   
	   ListNode pre=head;
	   ListNode current=head;
	   
	   while(current!=null &&!(current.getItem().getBarcode().equals(barcode))) {
		   pre =current;
		   current=current.getNext();
	   }
      //deletes the node gets the node before it and that node points to the node after it
	   if(current!=null && current.getNext()==null && (current.getItem().getBarcode().equals(barcode))) {
		   pre.setNext(null);
		   deleted=current.getItem();
		   size--;
		  // System.out.println("This item has been void:");
	   }
	   else if(current==null) {
		   System.out.println("The barcode was not found");
	   }
	   else {
		   pre.setNext(current.getNext());
		   deleted=current.getItem();
		   size--;
		   // System.out.println("This item has been void:");
	   }
      
   
	return deleted;
	   
         
   }
   /*returns the size of the list*/
   public int getSize() 
   {
      return size;
   }
   
  /*goes through the list, calls the toString method on each item in the list, 
returns a String representing all
  the objects in the list*/
   public String toString() {
	   
	   if(head==null) 
      {
		   return " ";
	   }	   
      
	   ListNode current = head;
	   String s ="";
	   int count=0;
	   while(current != null)
	     {	
		   	count ++;
		   	s+=count+".";
	        s = s + current.getItem().toString() + " ";
	        s += "\n************************\n";
	        current = current.getNext();
	     }   
	     return s + "";
   }
   /* returns the item at the given index, goes through the list, finde the given 
index, returns the item at the index*/
   public Item get(int pos)
    {
	   if(head==null) {
		   return null;
	   }
	   if(pos>size) {
		   return null;
	   }
	   
	   ListNode current =head;
	   int index=0;
	   while(current!=null &&pos != index) {
		   index++;
		   current=current.getNext();
	   }
	   if(current==null) {
		   return null;
	   }
	   
      return current.getItem();
   }
   
   /*Returns the most expensive item in the list. goes through the list and finds 
the expensive one
   This is very similar to the least expensive method*/
   public Item mostExpensive(){
	      if(head == null) 
	      {
	         return null;
	      }
	      else
	      {
	         //make a copy of the head node
	         ListNode curr = head;
	         
	         //declare a variable of type Item set it to null
	         Item MostExpensive = null;
	         
	         //declare a variable for the price set it to  a min value
	         double price = Integer.MIN_VALUE;
	         
	       //while curr is not null
	         while(curr!=null)
	         { 
	        	 if(curr.getItem().getPrice()>price)
	             //if the price of the item at the curr node is less than the price 
	            {
	        		 MostExpensive=curr.getItem();
	               //set the leastexpensive to the ittem at the current node
	                price=curr.getItem().getPrice();
	               //set the price to the price of the item at the curr node
	                
	            }//end if
	            curr=curr.getNext();
	            // curr should be assigned to curr.getNext() 
	            
	             
	         }//end while
	       
	       return MostExpensive;
	      }  
	   }
       
   
   /* returns the least expensive item in the list
   Some code along with commnets  is provided
   follow the commnets to complete the code*/
   public Item leastExpensive()
   {
      if(head == null) 
      {
         return null;
      }
      else
      {
         //make a copy of the head node
         ListNode curr = head;
         
         //declare a variable of type Item set it to null
         Item leastExpensive = null;
         
         //declare a variable for the price set it to  a max value
         double price = Integer.MAX_VALUE;
         
       //while curr is not null
         while(curr!=null)
         { 
        	 if(curr.getItem().getPrice()<price)
             //if the price of the item at the curr node is less than the price 
            {
        		 leastExpensive=curr.getItem();
               //set the leastexpensive to the ittem at the current node
                price=curr.getItem().getPrice();
               //set the price to the price of the item at the curr node
                
            }//end if
            curr=curr.getNext();
            // curr should be assigned to curr.getNext() 
            
             
         }//end while
       
       return leastExpensive;
      }  
   }
   }

   class yourDriver
   {
    public static void main(String []args) {
         Scanner kb = new Scanner(System.in);
         GroceryList list = new GroceryList();
      
         list.add("Pizza", 7.99, "10/20/2023", "20923245285");
         list.add("Cookies", 3.99, "2/1/2002", "12396378945");
         list.add("Beef Jerky", 1.99, "12/30/2025", "78963214753");
         list.add("Yogurt", 1.29, "8/15/2023", "78941236547");
      
         boolean repeat = true;
         while (true)
         {
         
            System.out.println("Here is the list of food items");
            System.out.println(list);
            System.out.println("**************************************");
            System.out.println("Here is the most expensive item on the list");
            System.out.println(list.mostExpensive());
            System.out.println("**************************************");
            System.out.print("Enter the barcode of the item to remove from the list: ");
            String barcode = kb.next();
         // System.out.println("Removing Milk from the list and adding a new expensive item on the list in the 2nd node");
            Item i = list.remove(barcode);
            if (i != null)
               System.out.println("This item has been void: \n" + i);
            else
               System.out.println("This item is not in the list");  
            System.out.println("**************************************");
            System.out.println("enter the info for the item to add it to the list ");
            System.out.println("index must be in the range 0 - " + (list.getSize()-1));
            System.out.print("Index -> ");
            int index = kb.nextInt(); 
            System.out.print("name --> ");
            String name = kb.next();
            System.out.print("Price --> " );
            double price = kb.nextDouble();
            System.out.print("Expiration date --> " );
            String date = kb.next();
            System.out.print("barcode--> " );
            barcode = kb.next();   
            list.add(index, name, price, date, barcode);
            System.out.println("**************************************");
            System.out.println("Here is the items in your list: ");
            System.out.println(list);
            System.out.println("**************************************");
         
            System.out.println("Testing the mostExpensive method to see what is the most expensive item now");
            System.out.println(list.mostExpensive());
            System.out.println("**************************************");
            System.out.println("Testing the leastExpensive method to see what is the least expensive item now");
            System.out.println(list.leastExpensive());
            System.out.println("**************************************");
         
            System.out.println("Enter the index of the item in the list(list is zero based) to display the item");
            System.out.println("index must be in the range 0 - " + (list.getSize()-1));
            System.out.print("Index --> " );
         
            index = kb.nextInt();
            System.out.println("Here is the item at the index " + index);
            System.out.println(list.get(index));
            System.out.println("**************************************");
            kb.nextLine();
            System.out.println("Press any key to continue");
            kb.nextLine();
         } 
      } 

   }
      class Driver {
      public static void main(String []args) {
         Scanner kb = new Scanner(System.in);
         GroceryList list = new GroceryList();
      
         list.add("Chicken", 5.99, "3/20/2022", "1234567890");
         list.add("Chocolate", 3.99, "2/1/2002", "22334455667788");
         list.add("Icecream", 2.99, "12/30/2025", "125467890");
         list.add("Steak", 35.50, "8/15/2030", "78956223445");
      
         boolean repeat = true;
         while (true)
         {
         
            System.out.println("Here is the list of food items");
            System.out.println(list);
            System.out.println("**************************************");
            System.out.println("Here is the most expensive item on the list");
            System.out.println(list.mostExpensive());
            System.out.println("**************************************");
            System.out.print("Enter the barcode of the item to remove from the list: ");
            String barcode = kb.next();
         // System.out.println("Removing Milk from the list and adding a new expensive item on the list in the 2nd node");
            Item i = list.remove(barcode);
            if (i != null)
               System.out.println("This item has been void: \n" + i);
            else
               System.out.println("This item is not in the list");  
            System.out.println("**************************************");
            System.out.println("enter the info for the item to add it to the list ");
            System.out.println("index must be in the range 0 - " + (list.getSize()-1));
            System.out.print("Index -> ");
            int index = kb.nextInt(); 
            System.out.print("name --> ");
            String name = kb.next();
            System.out.print("Price --> " );
            double price = kb.nextDouble();
            System.out.print("Expiration date --> " );
            String date = kb.next();
            System.out.print("barcode--> " );
            barcode = kb.next();   
            list.add(index, name, price, date, barcode);
            System.out.println("**************************************");
            System.out.println("Here is the items in your list: ");
            System.out.println(list);
            System.out.println("**************************************");
         
            System.out.println("Testing the mostExpensive method to see what is the most expensive item now");
            System.out.println(list.mostExpensive());
            System.out.println("**************************************");
            System.out.println("Testing the leastExpensive method to see what is the least expensive item now");
            System.out.println(list.leastExpensive());
            System.out.println("**************************************");
         
            System.out.println("Enter the index of the item in the list(list is zero based) to display the item");
            System.out.println("index must be in the range 0 - " + (list.getSize()-1));
            System.out.print("Index --> " );
         
            index = kb.nextInt();
            System.out.println("Here is the item at the index " + index);
            System.out.println(list.get(index));
            System.out.println("**************************************");
            kb.nextLine();
            System.out.println("Press any key to continue");
            kb.nextLine();
         } 
      } 
   }
   