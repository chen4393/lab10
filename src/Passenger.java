/**
 * Created by chen4393 on 4/4/17.
 */
import java.util.Random;

public class Passenger {

	/* get the island that the person got on the ferry at */
	public int getPickupIsland() {
		return pickupIsland;
	}

	/* get the island that the person will get off the ferry at */
	public int getDropoffIsland() {
		return dropoffIsland;
	}

	/* a constructor that takes in the island the passenger is starting at */
	public Passenger(int pickupIsland) {

		/* save pickupIsland */
		this.pickupIsland = pickupIsland;

		/* select a random drop off island that isn’t pickupIsland */
		Random randomGenerator = new Random();
		while (this.dropoffIsland != this.pickupIsland) {
			/* generate a random integer in the range 0..2 */
			this.dropoffIsland = randomGenerator.nextInt(3);
		}
	}

	private int pickupIsland;
	private int dropoffIsland;
}
