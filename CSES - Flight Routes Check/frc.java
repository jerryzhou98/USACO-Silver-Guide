//uses greedy DFS
// We see that this problem is satisifed as long as every vertice can be reached by every other vertice and every vertice can reach this vertice
//Proof: We'will prove by contradidiction:
// Say, there is a vertice, say a, such that every vertice connects to it, and every it goes to every vertice, and there is a pair of vertices, call them u, and v
// that cannot travel to each other however they could from u --> a --> v, since they are connected based on the assumption
// You could also prove directly, by saying if one statement is false

// Since if we prove at least one vertice satisfies we solved it.
// Therefore we can just focus on the first vertice, since if it satisfies this assumption we found the answer, since all the other vertices
// are connected

import java.util.*;
import java.io.*;


public class frc{
    static int n, m;
    static boolean[] vis;

    public static void dfs(int a, ArrayList<ArrayList<Integer>> adj){ // our dfs function
        vis[a] = true;
        for (int e : adj.get(a)) {
            if (!vis[e]){
                dfs(e, adj);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>(); // stores to values of a traveling to b, the order of the info given, we will 
		ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>(); // stores the values of b traveling to a, or the inverse of the info given

        for (int i = 0; i < n; i++) {
            adj1.add(new ArrayList<>());
			adj2.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(r.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            adj1.get(a).add(b);
            adj2.get(b).add(a);
        }

        vis = new boolean[n];
        dfs(0, adj1);
        for (int i = 0; i < n; i++) {
            if (!vis[i]){
                System.out.println("NO");
                System.out.println(1 + " " + (i+1)); // since we know that traveling form 1 to that vertice won't work, and add one since zero based
                System.exit(0);
            }
        }
        vis = new boolean[n];
        dfs(0, adj2);
        for (int i = 0; i < n; i++) {
            if (!vis[i]){
                System.out.println("NO");
                System.out.println((i+1) + " " +1); // same logic but reversed from above
                System.exit(0);
            }
        }
        System.out.println("YES");
        r.close();
    }
    //slower method times out. your doing dfs on every vertice which is just unnecessary work. 
    /*
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] v;
    static int c;
    public static void dfs(int a){
        v[a] = true;
        c++;
        for (int e : adj.get(a)) {
            if (!v[e]){
                dfs(e);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(r.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            adj.get(a).add(b);
        }
        boolean z = false;
        int a = -1;
        for (int i = 0; i < n; i++) {
            c= 0;
            v = new boolean[n];
            dfs(i);
            if(c != n){
                a = i;
                z = true;
                break;
            }
        }
        if(z){
            System.out.println("NO");
                for (int j = 0; j < v.length; j++) {
                    if(!v[j]){
                        System.out.println(a + 1 + " " + (j+1));
                        System.exit(0);
                    }
                }
        }
        else{System.out.println("YES");}
        r.close();
    }
    */
}