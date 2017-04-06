import java.util.ArrayList;

/**
 * Created by chen4393 on 4/4/17.
 */
public class Ferry {

	private ArrayList<Passenger> list;

	public boolean addPassenger(Passenger p) {
		if (!isFull()) {
			list.add(p);
			return true;
		} else {
			return false;
		}
	}

	public Passenger[] removePassengersAtIsland(int island) {
		ArrayList<Passenger> tempList = new ArrayList<Passenger>();
		for (int i = 0; i < list.size(); i++) {
			Passenger tempPassenger = list.get(i);
			if (tempPassenger.getDropoffIsland() == island) {
				list.remove(tempPassenger);
				tempList.add(tempPassenger);
			}
		}
		Passenger[] result = new Passenger[tempList.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = tempList.get(i);
		}
		return result;
	}

	public boolean isFull() {
		return list.size() >= 60;
	}

	public Ferry() {
		list = new ArrayList<Passenger>(60);
	}

	public int getSize() {
		return list.size();
	}
}
