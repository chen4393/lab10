import java.util.ArrayList;

/**
 * Created by chen4393 on 4/4/17.
 */
public class Ferry {

	private ArrayList<Passenger> list;

	public boolean addPassenger(Passenger p) {
		if (!isFull()) {
			list.add(p);
			//System.out.println("Add " + p);
			return true;
		} else {
			return false;
		}
	}

	public Passenger[] removePassengersAtIsland(int island) {
		//System.out.println("list.size before removePassengersAtIsland: " + list.size());
		ArrayList<Passenger> tempList = new ArrayList<Passenger>();
		//int initialListSize = list.size();
		for (int i = 0; i < list.size(); i++) {
			Passenger tempPassenger = list.get(i);
			if (tempPassenger.getDropoffIsland() == island) {
				//list.remove(tempPassenger);
				tempList.add(tempPassenger);
			}
		}

		for (int i = 0; i < tempList.size(); i++) {
			Passenger tempPassenger = tempList.get(i);
			list.remove(tempPassenger);
		}

		Passenger[] result = new Passenger[tempList.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = tempList.get(i);
		}
		//System.out.println("list.size after removePassengersAtIsland: " + list.size());
		return result;
	}

	public boolean isFull() {
		return list.size() >= 60;
	}

	public Ferry() {
		list = new ArrayList<Passenger>();
	}

	public int getSize() {
		return list.size();
	}

}
