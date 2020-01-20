class Max{

  public static int recursiveMaxDigit(int num){

    if(num == 0){
      return 0;
    }
    else{
      return Math.max(num%10,recursiveMaxDigit(num/10));
    }
  }

  public static int iterativeMaxDigit(int num){
    int maxNum = num%10;

    while(num > 0){
      if(num % 10 > maxNum){
        maxNum = num % 10;
      }
      num /=10;
    }
    return maxNum;
  }

  public static void main(String[] args){
    System.out.println(iterativeMaxDigit(7395));
    System.out.println(recursiveMaxDigit(7395));
  }
}
