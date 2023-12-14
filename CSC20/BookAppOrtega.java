/*
 Name: Ruben Ortega
 Date: 10/31/22
 Description: In this program we learned about about 3 sorting algorhythms and we impelmemented them in 
 a book app. We use the sorting algorhythms to sort the books based on title,author,and author and price.
 We then combine this with what we have learned in the past to create a fucntioning book app.
 Self Grade: 100/100
 Testimony: I have written this program all by myself and have not copied any code 
from any resourses: Ruben Daniel Ortega
 */
import java.util.*;
public class BookAppOrtega 
{
   // no code here
}

// Class named Author implements the compareable interface
class Author implements Comparable
{
   //class private variables
   private String first;
   private String last;
   
   //constructor
   public Author(String first, String last)
   {
      this.first = first;
      this.last = last;
   }
   
   //setter method
   public void setFirst(String first)
   {
      this.first = first;
   }
   
   //setter method
   public void setLast()
   {
      this.last = last;
   }
   
   //getter method
   public String getFirst()
   {
      return first;
   }
   
   //getter method
   public String getLast()
   {
      return last;
   }
   
   /*This method compares the two objects of Author for equality based on the last name*/
   public boolean equals(Object o) 
   {
   //if o is type Author we type cast o into the u
   if(o instanceof Author) 
      {
	   	Author u = (Author) o;
    //comparison true if they are the same
    return this.last.equalsIgnoreCase(u.last);
		
      }
  
	return false;
   	}
   	
   //prints a string representation of our object
   public String toString()
   {
      return "Author: " + first + " " + last;
   }
   
   /*This method compares the two objects of type Author based on their last name
   compareTo method from the String class should be called.
   This method accepts an Object as its parameter therfore must use instanceof and 
type casting in this method*/
   public int compareTo(Object other)
   {
    //if o is type Author we type cast o into the u
		  Author u = (Author) other;
	    return this.last.compareTo(u.last);
   }
}

//Class called Book implements the comparable interface to use the compareTo method
class Book implements Comparable
{
   //private variables
   private String title;
   private Author author;
   private String ISBN;
   private double price;
   private int pages;
   
   
   //*this constructor accepts the values for all the instance varibales and intializes them all.
   public Book(String title, String first, String last, String ISBN,double price, int pages)
   {	   author = new Author(first, last);
	   	this.title=title;
	   	this.ISBN=ISBN;
	   	this.price=price;
	   	this.pages=pages;
   }
   
   //getter method
   public String getTitle()
   {
      return title;
   }
   /*this method returns the first and last name of the author
   Since the Book has an Author object as its instance variables,
    then the methods getFirt() and getLast must be called from the Author class*/
   //getter method
   public String getAuthor()
   {
      return author.getFirst()+" " +author.getLast();
   }
   
   //getter method
   public String getISBN()
   {
      return ISBN;
   }
   
   //getter method
   public double getPrice()
   {
      return price;
   }
   
   //setter method
   public void setTitle(String t)
   {
      title = t;
   }
   
   //setter method
   public void setPrice(double p)
   {
      price = p;
   }
   
   //setter method
   public void setIsbn(String sb)
   {
      ISBN = sb;
   }
   /*this method creates a string representing all the attributes of the Book 
   object
   Make sure to call the toString method from the Author class to include the first
   and last. 
      */
   public String toString()
   {  
      return author.toString()+"\nTITLE: "+title
    		  +"\nPRICE: "+ price+ "\nPAGES: "+ pages
    		  +"\nISBN: "+ISBN;
   }
   /*compare two books for equlaity based on the isbn number*/
   public boolean equals(Book other)
   {
	   if(other instanceof Book) 
      {
		   Book u = (Book) other;
	    //returns true if they are the same 
	    return this.ISBN.equalsIgnoreCase(u.getISBN());
			
	   }
		return false;
      
   }
   
   //this method incrases the number of the pages by adding p to the instance variable pages
   public int append(int p)
   {
	  return pages +=p;
       
   }
   
   /* compares the book objects based on the title of the book
   This compareTo method is called in the selection sort*/
   // #1
   public int compareTo(Object o)
   {
		  Book u = (Book) o;
		  //returns an integer based on the comparison
		  return this.title.compareTo(u.getTitle());  
   }
    /*compares objects of type book based on their author
   This comapreTo method is called in the insertion sort
   the paramter for this method is of type Book and the author of the book b 
   needed to be compared with the author of the Book object called this*/
   // #2
   public int compares(Book b)
   {      //compare the last name of the authors and returns an integer based on the comparison
		    return this.author.getLast().compareTo(b.author.getLast());
		
   }
   /*compares the Book object based on the author, if the author is the same then 
	compares the 
   Book  objects based on the price
   this compareTo method is used in the bubbleSort method
   conditional statemnet needs to be used in this method
   if the authors of the book b is the same as the author of the Book object this
        return this.price - b.price
   else
      return   return author.compareTo(b.author)
    */
   // #3
   public double compare(Book b)
   {
      //last names are equal
      if(this.author.getLast()==b.author.getLast()) 
      { //compare prices and return an integer bases on the comparison
    	  return this.price-b.getPrice();
      }
      else 
      {
        //not the same name compare them and return an integer based on the comparison
    	  return this.author.getLast().compareTo(b.author.getLast());
      }
   }
}

//class named BookStore
class BookStore
{  //arraylist of type books
   private ArrayList<Book> books;
   private static int bookNum;
   //this is the constructor that instantiates the ArrayList books
   public BookStore()
   {
	   books = new ArrayList<Book>();
      
   }
   /*
   This method adds a book object to the list
   you need to create a book object first, once you have it then you can add it to the list.
   if the created book object is called z then we need tosay: books.add(z);
   */
   public void add(String title, String first, String last, double price, String isbn, int pages)
   {
	   Book b = new Book(title,first,last,isbn,price,pages);
	   books.add(b);
      bookNum++;
       
   }
   /*This method creates a toString from all the objects in the arraylist,
   make sure to call the tostring method from the book class on each item stored in the list:
   to call the tostring method from the book class:books.get(i).toString()
   */
    
   public String toString()
   {	String s ="";
      
	   for(int i=0; i<books.size();i++) 
      {  		   
         s+= "\n"+books.get(i).toString();
		   s+="\n*************************\n";
		   
	   }
	   //returns string s with all the info we added in it
	   return s;
   }
   /*This method searches the arraylist to find the book with the given isbn. 
   this method does a sequential serach, therfore a for loop is needed. */
   public boolean delete(String isbn)
   {
	   for(int i=0; i<books.size();i++) 
      {  //if the isbns match we remove the book
		   if(books.get(i).getISBN().equals(isbn)) 
         {
			   books.remove(i); // delete the song from the list
            bookNum--;
	         return true;
            
		   }
	   }
	   //method must is of type boolean so it must return true or false
      return false;
   }
   /*sorts the books based on the title of the book
   call the compareTo #1 in this method
   remember the name of the ArrayList is books and it is not list*/
   public void selectionSort()
   {   
	   
		      for(int i = 0; i<books.size() -1; i++)
		      {
		         int index = 0;
		         Book min = books.get(i);
		         boolean found = false;
		         for(int j = i+1; j < books.size(); j++)
		         { 
		            //find the smallest value in the list
		          
		            if(books.get(j).compareTo(min)<0)
		            {
		               index = j; //index of the next smallest element in the list
		               min = books.get(j);
		               found = true;  //to check if there is any min value found
		            }   
		           
		         }
		         
		        //swapping the vlues
		         if(found == true)
		         {
		            Book temp = books.get(i);
		            books.set(i, books.get(index));
		            books.set(index,temp);
		         }   
		      }
   }
   /*sorts the book objects based on the author of the book
   remember the name of the ArrayList is books and it is not list
   call compareTo #2 in this method*/
   public  void insertionSort( )
   {
	      for(int i = 0; i < books.size() -1; i++)
	      {
	          
	         int j = i+1;

	         Book n  = books.get(j);  //get the song at the index j

	         // compare the element at the index j with the elements at the indexes  j-1 to 0 until we find a proper location for the object n
	         while(j > 0 && n.compares(books.get(j-1)) < 0) 
	         {
	        	 books.set(j,books.get(j-1)); //shifting the element to the right
	            j--;
	         }
	         books.set(j,n); 
	         
	       }
   } 
        
   /*sorts the book objcts based on the author, 
   if the author is the same then sorts it based on the price
   call comapre #3 method in this method
   */
   public void bubbleSort()
   {
	   for(int i = 0; i <books.size() ; i++)
	      {
	         for(int j = 0 ; j <books.size() -1 - i; j++)
	         {
	            //swap
	            if(books.get(j+1).compare(books.get(j)) < 0)// < list[j])
	            {
	               Book temp = books.get(j) ;
	               books.set(j,  books.get(j+1));
	               books.set(j+1, temp);
	            }
	         }
	      }
   }
   /*the following search method searches the book based on the title of the book
   therfore the first line of code should be a call to the selection sort to sort 
the books
   based on the title of the books*/
   public Book binarySearch(String title) {
       // sort the arraylist based on title
       selectionSort();

       int first = 0;
       int last = books.size() - 1;
       int mid = (first + last) / 2;

       while( first <= last) {
           if (books.get(mid).getTitle().equalsIgnoreCase(title)){
               // found the element
               return books.get(mid);
           }

           if (title.compareTo(books.get(mid).getTitle()) > 0) {
               // element is somewhere on right side
               first = mid + 1;
           } else {
               // element is somewhere on left side
               last = mid - 1;
           }

           // reset mid every loop 
           
           mid = (first + last) / 2;
       }
       
       // else if not found return -1 or null
       return null;
   }



   /* This method will search the list of the books sequentially to find  the book 
with the given isbn.
   once the book is found, need a for loop to go through the arraylist to find the 
book with the gien isbn.
   once the book is found then call the append method on the object: 
   for example if the book at the index i has the isbn of the book that we are 
looking for then
   books.get(i).append(pages). this method should return the Book object that has 
been modified.
   if the Book with the give isbn is not found return null 
    .*/
   public Book append(String isbn, int pages)
   {	for(int i =0;i<books.size();i++) 
   {
	   	if(books.get(i).getISBN().equals(isbn)) 
         {
         //store the pages we want to append into x to create a new object
		   int x =books.get(i).append(pages);
         //new object with the updated information
		   Book b = new Book(books.get(i).getTitle(),books.get(i).getAuthor()," ",isbn,books.get(i).getPrice(),x);
         //method returns object of type book
		   return b;
	   }
   }
      return null;
   }
   //static method to keep count of how many books we have
   public static int getCount()
   {
      return bookNum;
   }
  }
/*
Do not delete this driver. 
*/
 class Driver
{
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      BookStore myStore = new BookStore();
      myStore.add("Java","Zoie","Zanjani", 23.56,"12345678",1234);
      myStore.add("Python","Elina","Busta",23.56,"2", 900);
    
      myStore.add("Advance Java","Stewart","Watts",98,"767676576",800);
      myStore.add("Build Java","Liang", "Lu",45,"56786565y76",700);
      myStore.add("Zip lining", "Stewart","Watts", 12,"1234566576",1200);
      myStore.add("C++","Elina", "Jackson",23.56,"2645556",1234);
      myStore.add("Programming Java","Stewart","Watts", 124,"75465666",3456);
      myStore.add("Humanity","Smith","Brown", 100.56,"234545657",1234);
      boolean b = true;
      while(b)
      {
         System.out.println("Enter 1 to sort based on the title");
         System.out.println("Enter 2 to sort based on the author");
         System.out.println("Enter 3 to sort based on the author, and the price");
         System.out.print("Enter your choice: ");
         int option = kb.nextInt();
         System.out.println("\n*************");
         if(option == 1)
         {
            System.out.println("Sorted based on the title\n");
            myStore.selectionSort();
         }
         else if (option == 2)
         {
            System.out.println("Sorted based on the author\n");
            myStore.insertionSort();
         } 
         
         else  
         {
            System.out.println("Sorted based on the author and price\n");
            myStore.bubbleSort();
         }
            
         System.out.println(myStore);
         System.out.println("\n     **************     ");
         System.out.println("Enter the title of the book to search for it: ");
         kb.nextLine();
         String t = kb.nextLine();
         
         Book book = myStore.binarySearch(t);
         if(book != null)
            System.out.println(book);
         else
            System.out.println("Book not found");   
         System.out.println("\n");
         System.out.print("Enter the isbn of the book to append pages to it: ");
         String isbn = kb.next();
         System.out.print("Enter the number of the pages to append: ");
         int pages = kb.nextInt();
         Book z  = myStore.append(isbn, pages);
         System.out.println("The " + pages + " has been added to the following book");
         System.out.println(z);
         System.out.println("Enter the information of the book you want to add to the list:");
         
         kb.nextLine();
         System.out.print("Title --> ");
         String tit = kb.nextLine();
         System.out.print("first name --> ");
         String f = kb.next();
         System.out.print("last name --> ");
         String l = kb.next();
         System.out.print("price --> ");
         double price = kb.nextDouble();
         System.out.print("ISBN --> ");
         isbn = kb.next();
         System.out.print("pages --> ");
         pages = kb.nextInt();
         myStore.add(tit,f,l,price,isbn,pages);
         myStore.selectionSort();
         System.out.println("Here is the updated list:");
         System.out.println(myStore);
         
         
         
         
            
      }  
   
   }
   
}

class YourDriver
{
 /* in this driver create your own code:
create a BookStore object
create 5 book objects and add them to the book store
create a while loop and implement the similar code to the given driver.
Do not copy paste the provided driver here, make your own code
add some creative codes to call the methods in the BookStore class.
make sure to call the method that you created yourself*/
   public static void main(String[] args)
   {
   Scanner kb = new Scanner(System.in);
      BookStore Store = new BookStore();
      Store.add("War and Peace","Ruben","Ortega", 23.56,"789642",5154851);
      Store.add("The Great Gatsby","Kobe","Bryany",274.56,"251", 250);
      Store.add("Lolita","Lebron","James",23,"767676576",54);
      Store.add("Middlemarch","Muchael", "Jordan",45,"56786565y76",700);
      Store.add("The Adventures of Huckleberry Finn", "Shaq","Oneal", 12,"1234566576",1200);
      
      
      boolean b = true;
      while(b)
      {
         System.out.println("Enter 1 to sort based on the title");
         System.out.println("Enter 2 to sort based on the author");
         System.out.println("Enter 3 to sort based on the author, and the price");
         System.out.print("Enter your choice: ");
         int option = kb.nextInt();
         System.out.println("\n*************");
         if(option == 1)
         {
            System.out.println("Sorted based on the title\n");
            Store.selectionSort();
            
         }
         else if (option == 2)
         {
            System.out.println("Sorted based on the author\n");
            Store.insertionSort();
         } 
         
         else  
         {
            System.out.println("Sorted based on the author and price\n");
            Store.bubbleSort();
         } 
         System.out.println("Number of books: " +BookStore.getCount());  //custom feature
         System.out.println(Store);
         System.out.println("\n     **************     ");
         System.out.println("Enter the title of the book to search for it: ");
         kb.nextLine();
         String t = kb.nextLine();
         
         Book book = Store.binarySearch(t);
         if(book != null)
            System.out.println(book);
         else
            System.out.println("Book not found");   
         System.out.println("\n");
         System.out.print("Enter the isbn of the book to append pages to it: ");
         String isbn = kb.next();
         System.out.print("Enter the number of the pages to append: ");
         int pages = kb.nextInt();
         Book z  = Store.append(isbn, pages);
         System.out.println("The " + pages + " has been added to the following book");
         System.out.println(z);
         System.out.println("Enter the information of the book you want to add to the list:");
         
         kb.nextLine();
         System.out.print("Title --> ");
         String tit = kb.nextLine();
         System.out.print("first name --> ");
         String f = kb.next();
         System.out.print("last name --> ");
         String l = kb.next();
         System.out.print("price --> ");
         double price = kb.nextDouble();
         System.out.print("ISBN --> ");
         isbn = kb.next();
         System.out.print("pages --> ");
         pages = kb.nextInt();
         Store.add(tit,f,l,price,isbn,pages);
         Store.selectionSort();
         System.out.println("Here is the updated list:");
         System.out.println("Number of books: " +BookStore.getCount());  //custom feature
         System.out.println(Store);
         }

   }
}
   

 

