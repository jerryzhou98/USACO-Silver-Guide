//a moo network is like a connected graph, so 2 seperate moo networks would be2 seperate connected graphs that don't intersect each otehr

import java.util.*;
import java.io.*;

public class fenceplan{
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] visited;
    static Cow[] info;
    static int ans;
    static int left; static int right; static int top; static int bottom;

    public static class Cow{
        int x; int y;
        public Cow(int a, int b){
            x = a;
            y = b;
        }
    }
    public static void dfs(int a){ // a is cow number
        visited[a] = true;
        left = Math.min(left, info[a].x);
        right = Math.max(info[a].x, right);
        top = Math.max(info[a].y, top);
        bottom = Math.min(info[a].y, bottom);
        for(int e : adj.get(a)){
            if(!visited[e]){
                dfs(e);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("fenceplan.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        info = new Cow[n];
        ans = Integer.MAX_VALUE;
        adj = new ArrayList<>();
        visited = new boolean[n];

        for (int i = 0; i < info.length; i++) {
            st = new StringTokenizer(r.readLine());
            info[i] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(r.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {//we don't have Arrays.fill since nothing is connected to one another
            if(!visited[i]){
                left = Integer.MAX_VALUE;
                right = Integer.MIN_VALUE;
                top = Integer.MIN_VALUE;
                bottom = Integer.MAX_VALUE;
                dfs(i);
                ans = Math.min(ans, (2 * (right - left)) + (2 * (top - bottom)));
            }
        }
        pw.println(ans);
        pw.close();
        r.close();
    }
}