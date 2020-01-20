import java.util.Scanner;

public class Fib1{

  public static int fibonacciRecursive(int n){
    if (n == 1 || n == 2){
      return 1;
    }
    else{
      return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
  }

  public static void main(String[] args){
    Scanner c = new Scanner(System.in);
    System.out.println("Please enter the term you want in the fibonacci sequence:");
    int inputNumber = c.nextInt();
    System.out.println(fibonacciRecursive(inputNumber) + " is the value of the requested term");
  }
}
