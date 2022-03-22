import java.util.*;
import java.io.*;

public class ad{
    static int[] arr;
    static int k;
    public static boolean check(long cap){
        long cur = 0;
        int ans = 1; // since we have to count the beginning array
        for(int i = 0; i < arr.length; i++){
            if (arr[i] > cap) { //if you have an element greater then the biggest possible sum, you're screwed
				return false;
			}
            if(cur + arr[i] > cap){
                cur = 0;
                ans ++; // this counds the next subarray just created
            }
            cur += arr[i];
        }
        if(ans <= k){
            return true;
        }
        else{
            return false;
        }
    }
    public static long bs(){
        long lo = 1;
        long hi = (long) 1e18;
        while (lo < hi){
            long mid = (lo + hi)/2;
            if(check(mid)){
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
        int n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(bs());
    }
}