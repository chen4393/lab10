import java.util.Random;

/**
 * Created by chen4393 on 4/4/17.
 */
public class FerryEvent implements Event {

	/* what island the Ferry that this Event is for is at */
	private int island;

	/* the Ferry object that we will remove and board passengers on */
	private Ferry ship;

	public FerryEvent(int island, Ferry ship) {
	    this.island = island;
	    this.ship = ship;
    }

	public void run() {

        Stat.updateTotalNumWaitFerry(FerrySim.islands[island].length());

		/* remove all Passengers that want to get off at our current island */
		Passenger[] arrived = getShip().removePassengersAtIsland(getIsland());

		Stat.updateTotalNumArrived(arrived.length);

		/* board new Passengers */
        //System.out.println("num of passengers waiting at island: " + FerrySim.islands[island].length());
        int initialIslandQSize = FerrySim.islands[island].length();
        for (int i = 0; i < initialIslandQSize; i++) {
			Passenger p = (Passenger) FerrySim.islands[island].remove();
            boolean isAddSuccess = getShip().addPassenger(p);
            //System.out.println(isAddSuccess);
            if (!isAddSuccess) {
				break;
			}
		}

        //System.out.println("list size after board new Passengers: " + getShip().getSize());

        Stat.updateAccumNumOnFerry(getShip().getSize());

		Stat.updateNumDeparture();

		/* move our ferry to the next island */
		int interval = 60;
        System.out.println("Ferry Event Island: " + island +
                ", Time is: " + FerrySim.agenda.getCurrentTime() + ", Next Ferry in: " + interval);
		Random randomGenerator = new Random();
		int nextIsland = randomGenerator.nextInt(3);

		while (island == nextIsland) {
			nextIsland = randomGenerator.nextInt(3);
		}

		setIsland(nextIsland);

		/* add a new PassengerEvent to our agenda */
		FerrySim.agenda.add(new FerryEvent(island, ship), interval);

        System.out.println("Ferry Event Island: " + island +
                ", Time is: " + FerrySim.agenda.getCurrentTime() + ", Next Ferry in: " + interval);
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
