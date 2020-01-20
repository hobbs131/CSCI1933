public class Car extends Vehicle {
  private String model;
  private double horsepower;

  public Car(String inputModel, double inputHorsepower){
    model = inputModel;
    horsepower = inputHorsepower;
    super.numVehicles++;
  }
  public String getModel(){
    return model;
  }
  public double getHorsepower(){
    return horsepower;
  }
  public void movingForward(){
    System.out.println("Car is moving forward");
  }
  public void movingBackward(){
    System.out.println("Car is moving backward");
  }
  public static void main(String[] args){
    Vehicle b = new Car("pontiac", 100);
    b.movingForward();
  }
}
