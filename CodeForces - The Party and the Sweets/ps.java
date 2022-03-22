import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ps{
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken()); int k = Integer.parseInt(st.nextToken());
        int[] boys = new int[n]; // min they give to girl
        int[] girls = new int[k]; // max they recieve from boy
        st = new StringTokenizer(r.readLine());
        long total = 0;
        for (int i = 0; i < boys.length; i++) {
            boys[i] = Integer.parseInt(st.nextToken());
            total += boys[i];
        }
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < girls.length; i++) {
            girls[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(boys);
        Arrays.sort(girls);
        total *= k;
        if (girls[0] < boys[n-1]){
            r.close();
            System.out.println(-1);
            System.exit(0);
        }
        for (int i = 1; i < girls.length; i++) {// we are using the biggest to use the least amount of candy
            total += girls[i] - boys[n-1];
        }
        if (boys[n-1] != girls[0]){ // we can't all use the biggest eleent or else the minimum is invalid
            total += girls[0] - boys[n-2];
        }
        System.out.println(total);
        r.close();
    }
}