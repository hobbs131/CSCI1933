public class VehicleSorter {
	public static void main(String[] args) {
		Vehicle[] vehicles = new Vehicle[5];
		vehicles[0] = new Car("Pontiac",100);
		vehicles[1] = new Car("Honda", 200);
		vehicles[2] = new Helicopter("Apache", 500);
		vehicles[3] = new Helicopter("Blackhawk", 600);
		vehicles[4] = new Boat("Coaster", 300);
	
		/*	TODO:
			Add vehicle objects of different types to your array. e.g.

			vehicles[0] = new Car("Ford Mustang GT", 425.5);
			... etc ...

			Make sure your list is not in sorted order when you create it!
		*/

		sortVehicles(vehicles);

		for (Vehicle v : vehicles) {
			System.out.println(v);
		}
	}

	public static void sortVehicles(Vehicle[] list) {

		for(int i = 0; i < list.length; i++){
			for (int j = 1; j < list.length - i; j++){
				if (list[j - 1].compareTo(list[j]) == -1){
					Vehicle temp = list[j - 1];
					list[j - 1] = list[j];
					list[j] = temp;
				}

			}
		}
	}
}
