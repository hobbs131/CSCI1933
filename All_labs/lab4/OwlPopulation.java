import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OwlPopulation {
    private String fileName;
    private Owl[] data;

    public void populateData() throws FileNotFoundException{
        File f = new File(fileName);
        Scanner scanner = new Scanner(f);

        int numLines = 0;
        while(scanner.hasNextLine()){
            numLines++;
            String s = scanner.nextLine();
        }
        scanner.close();

        data = new Owl[numLines];
        scanner = new Scanner(f);

        for (int i = 0; i < numLines; i++){
          String[] stringArray = scanner.nextLine().split(",");
          data[i] = new Owl(stringArray[0], Integer.parseInt(stringArray[1]), Double.parseDouble(stringArray[2]));
        }
      }

    public OwlPopulation(String fileName) throws FileNotFoundException{
        this.fileName = fileName;
        populateData();
    }

    public double averageAge(){
      double sumOfAges = 0;
      for (int i = 0; i < data.length; i++){
        sumOfAges += data[i].getAge();
      }
        return sumOfAges/data.length;
    }

    public Owl getYoungest(){
      int indexOfYoungest = 0;

      for (int i = 0; i < data.length; i++){
        if (data[i].getAge() < data[indexOfYoungest].getAge()){

          indexOfYoungest = i;
        }
      }
        return data[indexOfYoungest];
    }

    public Owl getHeaviest(){
        double heaviest = 0;
        int indexOfHeaviest = 0;

        for (int i = 0; i < data.length; i++){
          if (data[i].getWeight() > data[indexOfHeaviest].getWeight()){

            indexOfHeaviest = i;
          }
        }
          return data[indexOfHeaviest];
    }

    public String toString(){

      String output = "";
      Owl young=this.getYoungest();
      Owl heaviest = this.getHeaviest();


        output += "Avg. age: " + averageAge() + "\n";
        output += "Name and weight of heaviest: " +  heaviest.getName() +"  "+ heaviest.getWeight() + "\n";
        output += "Name and age of youngest: " + young.getName() + "age: " + young.getAge() + "\n";
        return output;
    }

    public boolean containsOwl(Owl other){
      int containsCheck = 0;
      if (other instanceof Owl){
        Owl otherOwl = (Owl) other;
        for(int i = 0; i < data.length; i++){
          if (data[i].getWeight() == otherOwl.getWeight() && data[i].getName().equals(otherOwl.getName()) && data[i].getAge() == otherOwl.getAge()){
            containsCheck++;
          }
        }
        if (containsCheck != 0){
          return true;
        }
      }
      return false;
    }

    public void merge(OwlPopulation other){
      Owl[] tempDistinctOwls = new Owl[data.length + other.popSize()];
      int distinctOwlCount = 0;
      int duplicateCount = 0;

      for(int i = 0; i < data.length; i++){
        tempDistinctOwls[distinctOwlCount] = data[i];
        distinctOwlCount++;
      }

      for(int a = 0; a < other.popSize(); a++){
        for (int i = 0; i < data.length; i++){
          if (data[i].getWeight() == other.data[a].getWeight() && data[i].getName().equals(other.data[a].getName()) && data[i].getAge() == other.data[a].getAge()) {
            duplicateCount++;
          }
        }
        if(duplicateCount == 0){
          tempDistinctOwls[distinctOwlCount] = data[a];
          distinctOwlCount++;
        }
        duplicateCount = 0;
      }

      Owl[] distinctOwls = new Owl[distinctOwlCount];

      for (int k = 0; k < distinctOwlCount; k++){
        distinctOwls[k] =  tempDistinctOwls[k];
      }
      this.data = distinctOwls;


        //TODO: a brief overview of what you can do to implement this method is given below:

        //1) determine (and store) the distinct owls in the other population.

        //2) make a new data array to hold the correct number of owls for the merged population

        //3) copy over the distinct owls from each population to the data array

        //4) set the new data array to "this" data (where is the merged population? what happens to the original populations?)
    }

    public int popSize(){
        return data.length;
    }
    public static void main(String[] args) {
        try {
            //The following should run when you are complete. Feel free to comment out as you see fit while you work.
            OwlPopulation pop1 = new OwlPopulation("owlPopulation1.csv");
            System.out.println();
            System.out.println("Population one size: " + pop1.popSize());
            System.out.println(pop1.toString());

            OwlPopulation pop2 = new OwlPopulation("owlPopulation2.csv");
            System.out.println("Population two size: " + pop2.popSize());
            System.out.println(pop2.toString());

            pop1.merge(pop2);
            System.out.println("Merged population size: " + pop1.popSize());
            System.out.println(pop1.toString());

        }
        catch (FileNotFoundException f){
            System.out.println("File not found.");
        }
    }
}
