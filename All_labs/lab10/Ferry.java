import java.util.ArrayList;

public class Ferry{
  private ArrayList<Passenger> passengers = new ArrayList(60);
  private int passengerCount = 0;
  public static int totalPeopleRemoved = 0;

  public boolean addPassenger(Passenger p){

    if (passengerCount < 60){
      passengers.add(p);
      passengerCount++;
      return true;
    }
    else {
      return false;
    }
  }

  public Passenger[] removePassengersAtIsland(int island){
    int passengersRemovedCount = 0;

    for (int i = 0; i < passengers.size(); i++){
      if (passengers.get(i).getDropOffIsland() == island){
        passengers.remove(passengers.get(i));
        this.passengerCount--;
        passengersRemovedCount++;
      }
    }
    this.totalPeopleRemoved += passengersRemovedCount;
    Passenger[] passengersRemoved = new Passenger[passengersRemovedCount];
    return passengersRemoved;
  }
  public boolean isFull(){
    if (passengerCount == 60){
      return true;
    }
    else{
      return false;
    }
  }
  public int getPassengerCount(){
    return passengerCount;
  }
}
