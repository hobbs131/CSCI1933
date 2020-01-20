public class Helicopter extends Vehicle{
  private String model;
  private double horsepower;

  public Helicopter(String inputModel, double inputHorsepower){
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
    System.out.println("Helicopter is moving forward");
  }
  public void movingBackward(){
    System.out.println("Helicopter is moving backward");
  }
  public void moveUp(){
    System.out.println("Helicopter is moving upwards");
  }
  public void moveDown(){
    System.out.println("Helicopter is moving downwards");
  }
  public static void main(String[] args){
    Vehicle b = new Helicopter("apache", 100);
    b.movingForward();
    Helicopter c = (Helicopter)b;
    c.moveUp();
    c.moveDown();
  }
}
