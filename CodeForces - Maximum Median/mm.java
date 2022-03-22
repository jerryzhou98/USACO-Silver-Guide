import java.util.*;
import java.io.*;

public class mm{
    static int n; static int k; static int[] nums;
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
        nums = new int[n];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        System.out.println(solve());
        r.close();
    }
    public static boolean checkMid(int x){
        long op = 0;
        for (int i = (n-1)/2; i < nums.length; i++) {
            op += Math.max(0, x - nums[i]);
        }
        if (op <= k){
            return true;
        }
        else{
            return false;
        }
    }
    public static int solve(){
        int lo = 0; int hi = (int)2e9;
        while (lo < hi){
            int mid = lo + (hi - lo + 1)/2;
            if(checkMid(mid)){
                lo = mid;
            }
            else{
                hi = mid - 1;
            }
        }
        return lo;
    }
}