import java.util.Random;

/**
 * Created by chen4393 on 4/4/17.
 */
public class FerryEvent implements Event {

	/* what island the Ferry that this Event is for is at */
	private int island;

	/* the Ferry object that we will remove and board passengers on */
	private Ferry ship;

	public FerryEvent(int island) {
	    this.island = island;
	    ship = new Ferry();
    }

	public void run() {

		/* remove all Passengers that want to get off at
		our current island */
		getShip().removePassengersAtIsland(getIsland());

		/* board new Passengers */
		for (int i = 0; i < FerrySim.islands[island].length(); i++) {
			Passenger p = (Passenger) FerrySim.islands[island].remove();
			if (!getShip().addPassenger(p)) {
				break;
			}
		}

		/* move our ferry to the next island */
		int interval = 60;
		Random randomGenerator = new Random();
		int nextIsland = randomGenerator.nextInt(3);

		while (island == nextIsland) {
			nextIsland = randomGenerator.nextInt(3);
		}

		setIsland(nextIsland);

		/* add a new PassengerEvent to our agenda */
		FerrySim.agenda.add(new FerryEvent(island), interval);

        System.out.println("Ferry Event Island: " + island +
                ", Time is:" + FerrySim.agenda.getCurrentTime() + ", Next Ferry in: " + interval);
	}

	public void setIsland(int island) {
		this.island = island;
	}

	public int getIsland() {
		return island;
	}

	public Ferry getShip() {
		return ship;
	}
}
