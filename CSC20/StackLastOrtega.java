import java.util.*;

import javax.management.ObjectName;

public class StackLastOrtega // <----- change this name to include your last name.
{
   // no code here
}

interface myStack {
   public void push(String s);

   public String peek();

   public boolean isEmpty();

   public String pop();
}

class rubensStack implements myStack{
   private ArrayList<Object> list;

   public rubensStack(){
      list = new ArrayList<Object>();
   }

   public void push(String s){
      list.add(s);
   }

   public String peek(){
      String x=(String) list.get(list.size()-1);
      return x;
   }

   public boolean isEmpty(){
      if(list.size()==0){
         return true;
      }
      else{
         return false;
      }
   }

   public String pop(){
      String x =(String)list.get(list.size()-1);
      list.remove(x);
      return x;
   }

}
/* must use array to implement the stack class */
class Stack implements myStack// must implement the myStack interface
{
   private String[] s; // Fall 2022
   private int top; // representing the element at the top

   public Stack() {
      s = new String[20];
      top = -1;

   }

   public void push(String token) {
      top++;
      s[top] = token;

   }

   public String pop() {

      String x = s[top];
      top--;
      return x;

   }

   public String peek() {

      return s[top];
   }

   public boolean isEmpty() {
      if (top == -1) {
         return true;
      } else {
         return false;
      }

   }

   public String toString() {
      String x = "";
      for (int i = 0; i < s.length; i++) {
         x += s[i];
      }
      return x;
   }

}

class Expression {
   private String exp; // instance variable

   public Expression(String s) {
      exp = s;
   }

   public String getPostfix() {
      String postFixString = "";
      Stack stackObj = new Stack();

      StringTokenizer st = new StringTokenizer(this.exp, " ");
      while (st.hasMoreTokens()) {
         String token = st.nextToken();

         // check if token is any of the operators
         if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
            // get precedence of the operations
            int precedence = precedence(token);

            // if precedence is 3; if token is * or /
            if (precedence == 3) {
               while (!stackObj.isEmpty() && precedence(stackObj.peek()) == 3) {
                  // pop the element at the top of the stack
                  // concatenate it to the postfix expression
                  postFixString += stackObj.pop() + " ";
                  // cause error needs space at the end
               }
            }
            // if token is + or -
            else if (precedence == 2) {
               while (!stackObj.isEmpty() && precedence(stackObj.peek()) >= 2) {
                  // pop the element at the top of the stack
                  // concatenate it to the postfix expression
                  postFixString += stackObj.pop() + " ";
               }
            }
            // push the token to the top of the stack
            stackObj.push(token);

         }
         // if the token is a number instead
         else {
            postFixString += token + " ";
         }

      }

      while (!stackObj.isEmpty()) {
         postFixString += stackObj.pop() + " ";
      }

      return postFixString;

   }

   private static int precedence(String opr) {
      if (opr.equals("*") || opr.equals("/")) {
         return 3;
      }
      if (opr.equals("+") || opr.equals("-")) {
         return 2;
      }
      return 0;
   }

   // method to calculate a post fix string
   public int evalPostfix() {
      String post = this.getPostfix();
      // create a stack object
      Stack Stackobject = new Stack();

      StringTokenizer st = new StringTokenizer(post, " ");

      while (st.hasMoreTokens()) {
         String token = st.nextToken();
         if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) {
            // push this token to the stack
            Stackobject.push(token);
         } else {

            int num1 = Integer.parseInt(Stackobject.pop());
            // System.out.println(num1);
            int num2 = Integer.parseInt(Stackobject.pop());
            int calcResult = calculate(num1, num2, token);
            Stackobject.push(""+calcResult+"");
            //causes error4
         }
      }

      return Integer.parseInt(Stackobject.pop());
   }

   /* must use if/else. usim=ng switch will not get any credit */
   private int calculate(int num1, int num2, String operation) {
      if (operation.equals("*")) {
         return num1 * num2;
      }
      if (operation.equals("+")) {
         return num1 + num2;
      }
      if (operation.equals("/")) {
         return (num2 / num1);
      }
      if (operation.equals("-")) {

         return num2 - num1;
      }

      return 0;
   }
}

class ExpDrive {
   public static void main(String[] args) {

      String[] exp = new String[11];
      exp[0] = "2 + 3 + 7 * 4 - 2 / 3 + 4";
      exp[1] = "3 - 4 / 2 + 6 * 3 + 5";
      exp[2] = "5 * 6 - 8 + 2 * 10 - 12";
      exp[3] = "4 + 8 * 3 - 2 / 34  * 2";
      exp[4] = "2 + 5 - 3 * 2 / 3 + 16";
      exp[5] = "6 - 3 + 6 / 2 * 4 - 8 / 2";
      exp[6] = "2 + 3 * 6 + 5 - 3";
      exp[7] = "2 * 3 + 4  / 3 * 2 + 6";
      exp[8] = "2 * 3 + 1 - 3 * 4 * 2";
      exp[9] = "1 + 2 * 3 - 6 * 7 + 2 * 3 + 2 * 3";
      exp[10] = "23 + 5 * 6 - 2 / 4 + 8 / 2";
      for (int i = 0; i < exp.length; i++) {

         Expression e1 = new Expression(exp[i]);
         String post = e1.getPostfix();
         int result = e1.evalPostfix();
         System.out.println("Infix: " + exp[i] + ",  postfix: " + post + " = " + result);
      }
   }
}

class MyDriver
{
   public static void main(String[] args)
   {
      ArrayList <String> list = new ArrayList<String>();
      list.add("2 + 3 + 7 * 4 - 2 / 3 + 4");
      list.add("3 - 4 / 2 + 6 * 3 + 5");
      list.add("5 * 6 - 8 + 2 * 10 - 12"); 
      list.add("4 + 8 * 3 - 2 / 34  * 2");
      list.add("2 + 5 - 3 * 2 / 3 + 16");
      list.add("6 - 3 + 6 / 2 * 4 - 8 / 2"); 
      list.add("2 + 3 * 6 + 5 - 3");
      list.add("2 * 3 + 4  / 3 * 2 + 6");
      list.add("2 * 3 + 1 - 3 * 4 * 2");
      list.add("1 + 2 * 3 - 6 * 7 + 2 * 3 + 2 * 3");
      list.add("23 + 5 * 6 - 2 / 4 + 8 / 2");
     for(int i = 0; i < list.size(); i++)
     {

      Expression e1 = new Expression(list.get(i));
      String post = e1.getPostfix();
      int result = e1.evalPostfix();
      System.out.println("Infix: "+ list.get(i) + ",  postfix: " + post + " = " + result);
     }

   }
}