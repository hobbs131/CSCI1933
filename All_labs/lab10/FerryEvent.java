public class FerryEvent implements Event{
  private int island;
  private Ferry ship;

  public FerryEvent(int island, Ferry ship){
    this.island = island;
    this.ship = ship;
  }

  public void run(){
    Passenger[] removed = ship.removePassengersAtIsland(island);

    if (removed.length != 0){
      // 2 seconds per passenger.
      FerrySim.agenda.add(new FerryEvent(island,ship),removed.length);
      return;
    }
    // Add passengers if ship is not full and queue is not empty.
    else {
      int passengersAdded = 0;
      if(island == 3) island =0;
      while (!ship.isFull() && FerrySim.islands[island].size() > 0) {
        if (FerrySim.islands[island].peek() != null){
          ship.addPassenger((Passenger)FerrySim.islands[island].poll());
          passengersAdded++;
          //System.out.println("Passenger added to ferry from island: " + island);
        }
      }
      FerrySim.totalPeopleBoarded+= passengersAdded;
      if(passengersAdded > 0){
        // Reschedule agenda 2 seconds per passengerAdded
        FerrySim.agenda.add(new FerryEvent(this.island,this.ship), passengersAdded);
      }
      // Move to next island
      else{
        if(this.island++ == 3){
          this.island = 0;
          FerrySim.agenda.add(new FerryEvent(this.island,this.ship), FerrySim.agenda.getCurrentTime() + 60);
          FerrySim.totalDepartures++;
        }
        else{
          FerrySim.totalDepartures++;
          FerrySim.agenda.add(new FerryEvent(this.island++,this.ship), FerrySim.agenda.getCurrentTime() + 60);
        }
      }
    }
  }
}
