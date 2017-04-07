/**
 * Created by chaoranchen on 4/6/17.
 */
public class Stat {

    /* accumulative number of people on the ferry in each departure */
    private static int accumNumOnFerry;

    /* times of departure */
    private static int numDeparture;

    /* total number of people who got in line for the Ferry */
    private static int totalNumWaitFerry;

    /* total number of people who arrived at their destination */
    private static int totalNumArrived;

    public static void updateAccumNumOnFerry(int numOnFerry) {
        accumNumOnFerry += numOnFerry;
    }

    public static void updateNumDeparture() {
        numDeparture++;
    }

    public static void updateTotalNumWaitFerry(int numWaitFerry) {
        totalNumWaitFerry += numWaitFerry;
    }

    public static void updateTotalNumArrived(int numArrived) {
        totalNumArrived += numArrived;
    }

    public static void displayStats() {
        System.out.println("\n** Simulation Results **\n");
        System.out.println("Mean number of people in the Ferry: " + (double)accumNumOnFerry / numDeparture);
        System.out.println("The total number of people who got in line for the Ferry: " + totalNumWaitFerry);
        System.out.println("The total number of people who arrived at their destination: " + totalNumArrived);
    }
}
