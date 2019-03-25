import java.util.*;
public class Calculator{
  /*Evaluate a postfix expression stored in s.
   *Assume valid postfix notation, separated by spaces.
   */
  public static double eval(String s){
    String[] tokens = s.split(" ");
    System.out.println(Arrays.toString(tokens));
    MyDeque<Double> d = new MyDeque<Double>();
    for (int i = 0; i < tokens.length; i++){
      try{
        d.addLast(Double.parseDouble(tokens[i]));
      }catch (NumberFormatException e){
        if (tokens[i].equals("+")){
          System.out.println("+");
          double b = d.removeLast();
          double a = d.removeLast();
          double change = a + b;
          d.addLast(change);
        } else if (tokens[i].equals("-")){
          System.out.println("-");
          double b = d.removeLast();
          double a = d.removeLast();
          double change = a - b;
          d.addLast(change);
        } else if (tokens[i].equals("*")){
          System.out.println("*");
          double b = d.removeLast();
          double a = d.removeLast();
          double change = a * b;
          d.addLast(change);
        } else if (tokens[i].equals("/")){
          System.out.println("/");
          double b = d.removeLast();
          double a = d.removeLast();
          double change = a / b;
          d.addLast(change);
        } else if (tokens[i].equals("%")){
          System.out.println("%");
          double b = d.removeLast();
          double a = d.removeLast();
          double change = a % b;
          d.addLast(change);
        }
      }
    }
    System.out.println(d.toStringDebug());
    return d.removeLast();
  }

  public static void main(String[] args){
    System.out.println(eval("10 2.0 +"));
  }
}
