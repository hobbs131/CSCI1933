Project 4: Bus Simulation // Author: Tanner Hobbs

Instructions: run Main.java, # of buses/starting positions/ of buses can be varied in Main. Run-time of simulation is also varied in Main.
Inter-arrival rate can be varied in RiderEvent.java

Overview: The project was organized very similarly to the Ferry Simulator. Events simulated bus/rider actions, and
were rescheduled and ran through the agenda until the simulated time was up.

Data structures used: queue and stack // complicated algorithms are explained through comments in each class.
  queue: A queue was a good idea to use because it simulates any kind of line. (FIFO)
  Stack: I used a stack in RiderEvent because it is automatically resized with convenient push/pop methods.
  It's also easy to add to and remove from therefore it was a good idea to use this for temporary storage.

Bugs/known issues: None known
