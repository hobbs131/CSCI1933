import java.util.Random;

public class Passenger{
  private int pickUpIsland;
  private int dropOffIsland;

  public Passenger(int pickUpIsland){
    Random random = new Random();
    this.dropOffIsland = random.nextInt(3);
    this.pickUpIsland = pickUpIsland;
  }
  public int getPickupIsland(){
    return pickUpIsland;
  }
  public int getDropOffIsland(){
    return dropOffIsland;
  }
}
