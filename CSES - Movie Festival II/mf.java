import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class mf{
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken()); int k = Integer.parseInt(st.nextToken());
        int[][] movies = new int[n][2];
        for (int i = 0; i < movies.length; i++) {
            st = new StringTokenizer(r.readLine());
            movies[i][0] = Integer.parseInt(st.nextToken());
            movies[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(movies, (a, b) -> a[1] - b[1]);
        int ans = 0;
        TreeMap<Integer, Integer> used = new TreeMap<>();
        used.put(0, k);
        for (int[] e : movies) {
            Integer lower = used.floorKey(e[0]);
            if (lower != null){
                ans ++;
                int z = used.get(lower);
                if (z == 1){
                    used.remove(lower);
                }
                else{
                    used.put(lower, z - 1);
                }
                if (!used.containsKey(e[1])){
                    used.put(e[1], 1);
                }
                else{
                    used.put(e[1], used.get(e[1]) + 1);
                }
            }
        }
        System.out.println(ans);
        r.close();
    }
}