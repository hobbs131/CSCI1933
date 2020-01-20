public class Fib{
  public int fibonacciRecursive(int n){
    if (n==0 || n==1){
      return 1;
    }
    else{
      return fibonacciRecursive(n-1)+fibonacciRecursive(n-2);
    }
  }
}
