/**
 * Created by chen4393 on 4/4/17.
 */
public class FerrySim {

	public static PQ agenda;

	public static Q2[] islands;

	public static void main(String[] args) {
		agenda = new PQ();
		islands = new Q2[3];
		islands[0] = new Q2();
		islands[1] = new Q2();
		islands[2] = new Q2();
		agenda.add(new PassengerEvent(0), 0);
		agenda.add(new PassengerEvent(1), 1);
		agenda.add(new PassengerEvent(2), 2);

		while (agenda.getCurrentTime() <= 10000) {
			agenda.remove().run();
		}
	}
}
