import java.io.*;
import java.util.*;
public class cr{
    static boolean[][] visited;
    static String[][] grid;
    public static void floodfill(int a, int b){
    
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        grid = new String[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = r.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = 
            }
        }
    }   
}