import java.util.Random;
import java.util.Queue;
import java.util.ArrayDeque;

public class FerrySim{
  public static double totalDepartures = 0;
  public static double totalPeopleBoarded = 0;
  private int islandOne = 0;
  private int islandTwo = 1;
  private int islandThree = 2;
  public static ArrayDeque<Passenger> islandOneQueue = new ArrayDeque();
  public static ArrayDeque<Passenger> islandTwoQueue = new ArrayDeque();
  public static ArrayDeque<Passenger> islandThreeQueue = new ArrayDeque();
  public static ArrayDeque[] islands = {islandOneQueue,islandTwoQueue,islandThreeQueue};
  public static PQ agenda;

  public static void main(String[] args){
    Ferry ferry = new Ferry();
    FerryEvent ferryEvent = new FerryEvent(0,ferry);


    agenda = new PQ();
    Random random = new Random();
    // places one person in queue on each island.
    PassengerEvent passengerEventOne = new PassengerEvent(0);
    PassengerEvent passengerEventTwo = new PassengerEvent(1);
    PassengerEvent passengerEventThree = new PassengerEvent(2);
    agenda.add(ferryEvent, 5 + random.nextDouble() * 5);
    agenda.add(passengerEventOne, 5 + random.nextDouble() * 5);
    agenda.add(passengerEventTwo, 5 + random.nextDouble() * 5);
    agenda.add(passengerEventThree, 5 + random.nextDouble() * 5);
    while (agenda.getCurrentTime() < 10000){
      agenda.remove().run();
   }
   System.out.println("Average: " + totalPeopleBoarded / totalDepartures);
   System.out.println("total number of people who got in line: " + PassengerEvent.peopleBoarded);
   System.out.println("total number of people who reached destination: " + Ferry.totalPeopleRemoved);
  }
}
