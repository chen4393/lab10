/**
 * Created by chen4393 on 4/4/17.
 */

public class PassengerEvent implements Event {

	/* the island that this PassengerEvent will make Passenger Objects for */
	private int island;
	private int interval;

	public PassengerEvent(int island) {
		this.island = island;
	}


	public void run() {

		/* add a new PassengerEvent to our agenda for the same island at a time
		that is a random number between 5 and 10 (inclusive) */
		interval = intRandomInterval(5, 10);
		FerrySim.agenda.add(new PassengerEvent(island), interval);

		/* create a new Passenger at the correct pickupIsland and add it to the correct queue */
		Passenger passenger = new Passenger(island);
		FerrySim.islands[island].add(passenger);

		System.out.println("Passenger Event Island: " + island +
				", Time is:" + FerrySim.agenda.getCurrentTime() + ", Next Passenger in: " + interval);
	}

	public static int intRandomInterval(int low, int high) {
		return (int) Math.floor((high - low) * Math.random() + low + 0.5);
	}

}