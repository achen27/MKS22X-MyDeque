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
        } else if (tokens[i].equals("-")){
          System.out.println("-");
        } else if (tokens[i].equals("*")){
          System.out.println("*");
        } else if (tokens[i].equals("/")){
          System.out.println("/");
        } else if (tokens[i].equals("%")){
          System.out.println("%");
        }
      }
    }
    System.out.println(d.toStringDebug());
    return 0.0;
  }

  public static void main(String[] args){
    eval("10 2.0 +");
  }
}
