import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class roomal {
    static StringTokenizer st;
    static class Customer{
        int arrival, departure, index;

		Customer(int arrival, int departure, int index) {
			this.arrival = arrival;
			this.departure = departure;
			this.index = index;
		}
    }
    static class Room {
		// departure: the time that the customer occupying the room leaves
		// number: the number of the room
		int departure, number;

		Room(int departure, int number) {
			this.departure = departure;
			this.number = number;
		}
	}
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
		Customer[] customers = new Customer[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(r.readLine());
			int arrival = Integer.parseInt(st.nextToken());
			int departure = Integer.parseInt(st.nextToken());
			customers[i] = new Customer(arrival, departure, i);
		}
        Arrays.sort(customers, Comparator.comparingInt(c -> c.arrival));
		PriorityQueue<Room> pq = new PriorityQueue<>(
			// order rooms by departure
			Comparator.comparingInt(x -> x.departure)
		);

		int k = 0;
		// the room numbers allocated to each customer
		int[] roomAllocations = new int[n];
		// the number of the last new room we've allocated
		int lastRoom = 1;

		// add the first customer to the priority queue
		pq.add(new Room(customers[0].departure, lastRoom));
		roomAllocations[customers[0].index] = lastRoom;

		for (int i = 1; i < n; i++) {
			// find the minimum departure time
			Room min = pq.peek();

			if (min.departure < customers[i].arrival) {
				pq.remove();
				pq.add(new Room(customers[i].departure, min.number));
				roomAllocations[customers[i].index] = min.number;
			} else {
				lastRoom++;
				pq.add(new Room(customers[i].departure, lastRoom));
				roomAllocations[customers[i].index] = lastRoom;
			}
			k = Math.max(k, pq.size());
		}
        System.out.println(k);
        StringBuilder str = new StringBuilder();
		for (int allocation : roomAllocations) {
			str.append(allocation).append(" ");
		}
        System.out.println(str);
    }
}
