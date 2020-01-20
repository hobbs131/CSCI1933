import java.util.Scanner;

public class Histogram{
  int lowerBound;
  int upperBound;
  int[] histogram;
  public Histogram(int lowerbound, int upperbound){
    lowerBound = lowerbound;
    upperBound = upperbound;
    histogram = new int[upperBound-lowerBound+1];
  }

  public boolean add(int i){

    if (i >= lowerBound && i <= upperBound){
      histogram[i-lowerBound]++;
      return true;
    }
    else{
      return false;
    }
  }

  public String toString(){
    System.out.println(histogram);
    int histogramNum = lowerBound;
    for(int histogramIndex = 0; histogramIndex < upperBound-lowerBound + 1; histogramIndex++){
      int starCounter = 0;
      System.out.print(histogramNum + ":");
      while(starCounter < histogram[histogramIndex]){
        System.out.print("*");
        starCounter++;
      }
      System.out.println("");
      histogramNum++;
    }
    return "";
  }
  public static void main(String[] args){
    System.out.println("");
    System.out.println("---Histogram Console---");
    System.out.println("add - used to add numbers to the histogram");
    System.out.println("print - prints the histogram to the screen");
    System.out.println("quit - leaves the program");
    System.out.println("");
    System.out.println("Enter range to get started: ");
    Scanner bounds = new Scanner(System.in);
    Scanner input = new Scanner(System.in);
    int lowerBoundInput = bounds.nextInt();
    int upperBoundInput = bounds.nextInt();
    Histogram newHistogram = new Histogram(lowerBoundInput,upperBoundInput);
    System.out.println("Good! now choose an option.");
    while (input.hasNextLine()){
      System.out.print(">");
      String input1 = input.nextLine();

      if(input1.equals("add")){
        System.out.println("Enter number(s)");
        String[] stringArray = input.nextLine().split(" ");
        int[] intArray = new int[stringArray.length];
        for (int i =0; i < stringArray.length; i++){
          String numberAsString = stringArray[i];
          intArray[i] = Integer.parseInt(numberAsString);
        }
        for (int i = 0; i < intArray.length; i++){
          if (!newHistogram.add(intArray[i])){
              System.out.println(intArray[i] + " is out of range");
          }
        }

      } else if (input1.equals("quit")){
        System.out.println("bye!");
        return;

      } else if (input1.equals("print")){
        newHistogram.toString();
      }

      else {
        System.out.println("Command not recognized " + input1);
      }
    }
  }
}
