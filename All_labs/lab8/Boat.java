public class Boat extends Vehicle{
  private String model;
  private double horsepower;

  public Boat(String inputModel, double inputHorsepower){
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
    System.out.println("Boat is moving forward");
  }
  public void movingBackward(){
    System.out.println("Boat is moving backward");
  }
  public void dropAnchor(){
    System.out.println("Anchor has been dropped");
  }
  public void hoistAnchor(){
    System.out.println("Anchor has been hoisted");
  }
  public static void main(String[] args){
    Vehicle b = new Boat("awesomeBoat", 100);
    b.movingBackward();
    Boat j = (Boat)b;
    j.hoistAnchor();

  }
}
