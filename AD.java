//have to find the highest or else it will never by destroyed, since x is always decreasing

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class AD{
    public static class format{
        int a; int b;
        public format(int x, int y){
            a = x;
            b = y;
        }
    }
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(r.readLine());
            int[] nums = new int[2 * n];
            st = new StringTokenizer(r.readLine());
            int large = 0;
            TreeMap<Integer, Integer> ms = new TreeMap<>();
            for (int j = 0; j < nums.length; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (ms.containsKey(temp)){
                    ms.put(temp, ms.get(temp) + 1);
                }
                else{
                    ms.put(temp, 1);
                }
                nums[j] = temp;
                large = Math.max(large, temp);
            }
            //System.out.println(Arrays.toString(nums));
            if(ms.get(large) == 1){
                ms.remove(large);
            }
            else{
                ms.put(large, ms.get(large) - 1);
            }
            boolean found = false;
            for (int j = 0; j < nums.length; j++) { // finding the second first element forming x;
                TreeMap<Integer, Integer> temp = new TreeMap<Integer, Integer>(ms);
                format[] ans = new format[n];
                int cur = 0;
                //System.out.println(large + " " + nums[j] + " " + j);
                if (temp.containsKey(nums[j])){
                    if(temp.get(nums[j]) == 1){
                        temp.remove(nums[j]);
                    }
                    else{
                        temp.put(nums[j], temp.get(nums[j]) - 1);
                    }
                    ans[cur] = new format(nums[j], large);
                    int x = large;
                    while (temp.size() > 0){
                        //System.out.print(temp);
                        cur ++;
                        int l = temp.lastKey();
                        if(temp.get(l) == 1){
                            temp.remove(l);
                        }
                        else{
                            temp.put(l, temp.get(l) - 1);
                        }
                        if (!temp.containsKey(x - l)){
                            break;
                        }
                        else{
                            if(temp.get(x- l) == 1){
                                temp.remove(x-l);
                            }
                            else{
                                temp.put(x-l, temp.get(x-l) - 1);
                            }
                        }
                        ans[cur] = new format(x - l, l);
                        x = l;
                    }
                    if (temp.size() == 0){
                        found = true;
                        System.out.println("YES");
                        System.out.println(large + nums[j]);
                        for (int k = 0; k < ans.length; k++) {
                            System.out.println(ans[k].a + " "+ ans[k].b);
                        }
                        break;
                    }
                }
            }
            if (!found){
                System.out.println("NO");
            }
        }
    }
}