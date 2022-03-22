import java.util.*;
import java.io.*;


public class broads{

    public static ArrayList<Integer> adj[];//adjancy list, shows which one is next to which
    public static ArrayList<Integer> rep = new ArrayList<>();//keeps track of the ones not visited
    public static boolean visited[]; //see if we visited or not

    public static void dfs(int node){ //rescursive function, too see the travel
        visited[node] = true; // noting where we traveled to 
        for(int u: adj[node]){
            if(!visited[u]){
                dfs(u);
            }
        }
    }
    public static int count_c(){
        int c = 0;
        for (int i = 1; i < adj.length; i++) {
            if (!visited[i]){
                c ++;
                rep.add(i);// adding the ones that are not connected, means that they are 2 seperate graphs essentially, since no connections between them, otherwise they would be marked by the dfs
                dfs(i);
            }
        }
        return c;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n+1]; // n+a to avoid using zero, since too complicated
        visited = new boolean[n+1];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {// marking what is adjacent to what
            st = new StringTokenizer(r.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v); adj[v].add(u);
        }

        int ans = count_c();

        //answer
        System.out.println(ans - 1); // we don't need to connect all the graphs together

        for (int i = 1; i < ans; i++) { // connectinos between the graphs
            System.out.println(rep.get(i-1) + " " + rep.get(i));
        }

        r.close();
    }
}