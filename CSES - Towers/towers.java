import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class towers{
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        int[] temp = new int[n];
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> t = new ArrayList<Integer>(); // sorts in non decreasing order 
        for (int i = 0; i < n; i++) {

            //binary search to find the smalles bigger block, since optimal
            int lo = 0; int hi = t.size();
            while (lo < hi){
                int mid = (lo + hi)/2;
                if (temp[i] >= t.get(mid)){
                    lo = mid +1;
                }
                else{
                    hi = mid;
                }
            }

            if (lo == t.size()){ // if not here
                t.add(temp[i]);
            }
            else{ // if here
                t.set(lo, temp[i]);
            }
        }
        System.out.println(t.size()); // number of towers
        r.close();
    }
}