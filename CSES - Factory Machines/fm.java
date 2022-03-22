import java.util.*;
import java.io.*;

public class fm{
    static long[] p;
    static int max;
    static long k;
    public static boolean check(long a){
        long total = 0;
        for (long e : p) {
            total += a/e;
            if (total >= k){
                return true;
        }
        }        
        return false;
    }
    public static long bs(){
        long lo = 0;
        long hi = (long) Math.pow(10, 18);
        while (lo < hi){
            long mid = (lo + hi)/2;
            if (check(mid)){
                hi = mid;
            }
            else{
                lo = mid + 1;
            }
        }
        return lo;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken()); k = Long.parseLong(st.nextToken());
        p = new long[n];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < p.length; i++) {
            p[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(p);
        System.out.println(bs());
    }
}