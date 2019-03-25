import java.util.*;
public class Calculator{
  /*Evaluate a postfix expression stored in s.
   *Assume valid postfix notation, separated by spaces.
   */
  public static double eval(String s){
    String[] tokens = s.split(" "); //split string into list of doubles and operators
    //System.out.println(Arrays.toString(tokens));
    MyDeque<Double> d = new MyDeque<Double>(); //create stack
    for (int i = 0; i < tokens.length; i++){
      try{
        d.addLast(Double.parseDouble(tokens[i])); //adding all non operators
      }catch (NumberFormatException e){ //cannot be converted into double
        if (tokens[i].equals("+")){ //adding
          //System.out.println("+");
          double b = d.removeLast();
          double a = d.removeLast();
          double change = a + b;
          d.addLast(change);
        } else if (tokens[i].equals("-")){ //subtracting
          //System.out.println("-");
          double b = d.removeLast();
          double a = d.removeLast();
          double change = a - b;
          d.addLast(change);
        } else if (tokens[i].equals("*")){ //multiplying
          //System.out.println("*");
          double b = d.removeLast();
          double a = d.removeLast();
          double change = a * b;
          d.addLast(change);
        } else if (tokens[i].equals("/")){ //dividing
          //System.out.println("/");
          double b = d.removeLast();
          double a = d.removeLast();
          double change = a / b;
          d.addLast(change);
        } else if (tokens[i].equals("%")){ //remainder
          //System.out.println("%");
          double b = d.removeLast();
          double a = d.removeLast();
          double change = a % b;
          d.addLast(change);
        }
      }
    }
    //System.out.println(d.toStringDebug());
    return d.removeLast(); //returns last element in stack
  }

  public static void main(String[] args){
    System.out.println(eval("10 2.0 +"));
    System.out.println(eval("11 3 - 4 + 2.5 *"));
    System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    System.out.println(eval("1 2 3 4 5 + * - -"));
  }
}
