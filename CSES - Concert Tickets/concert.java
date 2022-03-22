import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.NavigableMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class concert {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        NavigableMap<Integer, Integer> p = new TreeMap<>();
        Map.Entry<Integer, Integer> temp; // essentially a tuple in java
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken()); int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());

        //storing the occurences of each
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (p.containsKey(num)){
                p.put(num, p.get(num) + 1);
            }
            else{
                p.put(num, 1);
            }
        }
        
        //TreeSet lowerEntry(n) displays the <Key, Value> with the key being the max smaller number then the given key n.
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(st.nextToken());
            temp = (p.lowerEntry(num+1)); // add 1 since lower entry only accounts for strictly less then
            if (temp == null){ // no tickets
                System.out.println(-1);
            }
            else{ 
                System.out.println(temp.getKey());
                if (temp.getValue() == 1){ // only one left, the one we used
                    p.remove(temp.getKey());
                }
                else{
                    p.put(temp.getKey(), temp.getValue() - 1); // take away the ticket we used
                }
            }
        
        }
        r.close();
    }
}
