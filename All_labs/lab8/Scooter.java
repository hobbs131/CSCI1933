public class Scooter implements Drivable {
  public Scooter(){
  }
  public void movingForward(){
    System.out.println("Scooter class: Vehicle is moving forward");
  }
  public void movingBackward(){
    System.out.println("Scooter class: Vehicle is moving backward");
  }
  public static void main(String[] args){
    Drivable p = new Scooter();
    p.movingForward();
    p.movingBackward();
  }
}
