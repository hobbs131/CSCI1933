public class Bike implements Drivable {
  public Bike(){
  }
  public void movingForward(){
    System.out.println("Bike class: Vehicle is moving forward");
  }
  public void movingBackward(){
    System.out.println("Bike class: Vehicle is moving backward");
  }
  public static void main(String[] args){
    Drivable p = new Bike();
    p.movingForward();
    p.movingBackward();
  }
}
