import java.util.*;
public class Calculator{
  /*Evaluate a postfix expression stored in s.
   *Assume valid postfix notation, separated by spaces.
   */
  public static double eval(String s){
    String[] tokens = s.split(" ");
    System.out.println(Arrays.toString(tokens));
    return 0.0;
  }

  public static void main(String[] args){
    eval("10 2.0 +");
  }
}
