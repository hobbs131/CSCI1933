import java.util.Random;

public class PassengerEvent implements Event{
  private int island;
  public static int peopleBoarded = 0;

  public PassengerEvent(int island){
    this.island = island;
  }
  public void run(){

    Passenger passengerToAdd = new Passenger(island);

    if(island == 0){
      FerrySim.islandOneQueue.add(passengerToAdd);
      peopleBoarded++;
    }
    else if(island == 1){
      FerrySim.islandTwoQueue.add(passengerToAdd);
      peopleBoarded++;
    }
    else if(island == 2){
      FerrySim.islandThreeQueue.add(passengerToAdd);
      peopleBoarded++;
    }
    Random random = new Random();
    double timeToWait = 5 + random.nextDouble() * 5;
    PassengerEvent eventToAdd = new PassengerEvent(island);
    FerrySim.agenda.add(eventToAdd, timeToWait);
    //System.out.println("Passenger Event Island: " + island + ", Time is: " + FerrySim.agenda.getCurrentTime() + ", Next Passenger in: " + timeToWait);



  }
}
