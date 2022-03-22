import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class fasterroomal {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] times = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
            times[i][2] = i;
        }
        Arrays.sort(times, (a, b) -> a[0] - b[0]); // sort by beginning time, since we want min
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // sorting by departure time, since that is the closest room that opens up      
        int[] ans = new int[n];
        int roomnum = 1;
        pq.add(times[0]); // arrival, departure, index
        ans[times[0][2]] = roomnum;
        for (int i = 1; i < n; i++) {
            int[] min = pq.peek(); // finding the first place --> smallest index
            if(min[1]< times[i][0]){
                pq.remove();
                pq.add(times[i]);
                ans[times[i][2]] = ans[min[2]]; // marking the place with the room number
            }
            else{
                roomnum ++; // increase the room number
                pq.add(times[i]);
                ans[times[i][2]] = roomnum;
            }
        }
        System.out.println(roomnum);
        StringBuilder str = new StringBuilder(); // printing out the array
		for (int allocation : ans) {
			str.append(allocation).append(" ");
		}
        System.out.println(str);
        br.close();
    }
}