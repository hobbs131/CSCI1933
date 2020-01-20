
public class Postfix{

  public static double evaluate(String[] expression, Stack<String> newStack){
    try{
      for (int i = 0; i < expression.length; i++){
        if (expression[i]!= "+" && expression[i] != "*" && expression[i] != "-" && expression[i] != "/"){
          newStack.push(expression[i]);
        }
        else{
          String num1 = newStack.pop();
          String num2 = newStack.pop();
          Double double1 = Double.valueOf(num1);
          Double double2 = Double.valueOf(num2);



          if (expression[i].equals("+")){
            newStack.push(String.valueOf(double1 + double2));
          }
          else if (expression[i].equals("/")){
            newStack.push(String.valueOf(double1 / double2));
          }
          else if (expression[i].equals("*")){
            newStack.push(String.valueOf(double1 * double2));
          }
          else if (expression[i].equals("-")){
            newStack.push(String.valueOf(double1 - double2));
          }
        }
      }
    }
    catch (StackException e){
      System.out.println("error! size is:" + e.getSize());
    }
    return Double.parseDouble(newStack.pop());
  }

  public static void main(String[] args){
    String[] input = {"5", "2", "+"};
    Stack<String> stack = new Stack<String>(1);
    Postfix postFix = new Postfix();
    System.out.println(postFix.evaluate(input,stack));

  }
}
