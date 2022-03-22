//if you return to your orignial node a cycle has been completed

import java.util.*;
import java.io.*;

public class rank{
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] visit;
    static boolean[] cyclic;

    public static void dfs(int a, int start){
        visit[a] = true;
        for(int next: adj.get(a)){
            if (next == start){ // check to see if cycled
                cyclic[start] = true;
            }
            if (!visit[next]){
                dfs(next, start);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());

        int n = Integer.parseInt(st.nextToken()); int k = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList<>();
        cyclic = new boolean[n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(r.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int ascore = Integer.parseInt(st.nextToken());
            int bscore = Integer.parseInt(st.nextToken());
            if (ascore > bscore){
                adj.get(a).add(b);
            }
            else{
                adj.get(b).add(a);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) { // starting vertex
            Arrays.fill(visit, false);
            dfs(i, i);
            if (cyclic[i]){
                ans ++;
            }
        }
        System.out.println(ans);
    }
}