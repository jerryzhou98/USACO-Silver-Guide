import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class lights {
    public static void main(String[] args) throws IOException{
        BufferedReader r= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        //Method 1 using "Multiset"
        /*
        TreeSet<Integer> pos = new TreeSet<>();
        TreeMap<Integer, Integer> d = new TreeMap<>();
        int x = Integer.parseInt(st.nextToken()); int k = Integer.parseInt(st.nextToken());
        pos.add(0);
        pos.add(x);
        d.put(x, 1);
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(st.nextToken());
            int hi = pos.higher(num);
            int lo = pos.lower(num);
            pos.add(num);
            if (d.get(hi - lo) == 1){
                d.remove(hi - lo);
            }
            else{
                d.put(hi - lo, d.get(hi - lo) - 1);
            }
            if (d.containsKey(hi - num)){
                d.put(hi - num, d.get(hi - num) + 1);
            }
            else{
                d.put(hi - num, 1);
            }
            if (d.containsKey(num - lo)){
                d.put(num - lo, d.get(num - lo) + 1);
            }
            else{
                d.put(num - lo, 1);
            }
            System.out.print(d.lastKey() + " ");
        }
        */
        //Method 2, backtracking, faster
        //you store every position, then you search in reverse the order the lights were put, so you can keep track of the maximal dist
        TreeSet <Integer> pos = new TreeSet<>();
        int x = Integer.parseInt(st.nextToken()); int k = Integer.parseInt(st.nextToken());
        int[] order = new int[k];
        int maxdist = 0;
        int prev = 0;
        st = new StringTokenizer(r.readLine());

        pos.add(0);
        pos.add(x);
        for (int i = 0; i < k; i++) {
            int temp = Integer.parseInt(st.nextToken());
            pos.add(temp);
            order[i] = temp;
        }
        for(int i: pos){
            maxdist = Math.max(maxdist, i - prev); // max distance after everything is added
            prev = i;
        }

        int[] gaps = new int[k]; // keeping track of the distances
        gaps[k-1] = maxdist;

        for (int i = k - 1; i > 0; i--) {
            pos.remove(order[i]); // remove the light
            int hi = pos.higher(order[i]); int lo = pos.lower(order[i]);
            maxdist = Math.max(maxdist, hi - lo); // seeing if any gaps that are larger, gaps that are already open
            gaps[i-1] = maxdist; // marking it
        }

        StringBuilder sb = new StringBuilder(); //faster way
		for (int i : gaps) {
			sb.append(i).append(" ");
		}
        System.out.println(sb);
        r.close();
    }
}
