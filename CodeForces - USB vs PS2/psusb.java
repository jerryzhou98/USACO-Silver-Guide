import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class psusb{
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        ArrayList<Long> usb = new ArrayList<>();
        ArrayList<Long> ps2 = new ArrayList<>();
        int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken()); int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(r.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(r.readLine());
            long val = Long.parseLong(st.nextToken());
            String s = st.nextToken();
            if (s.equals("USB")){
                usb.add(val);
            }
            else{
                ps2.add(val);
            }
        }
        Collections.sort(usb);
        Collections.sort(ps2);
        long ans = 0; int nums = 0;
        int p1 = 0; // usb
        while (p1 < a && p1 < usb.size()){
            nums ++;
            ans += usb.get(p1);
            p1++;
        }
        int p2 = 0; // ps2
        while (p2 < b && p2 < ps2.size()){
            nums ++;
            ans += ps2.get(p2);
            p2 ++;
        }
        ArrayList<Long> combine = new ArrayList<>();
        for (int i = p1; i < usb.size(); i++) {
            combine.add(usb.get(i));
        }
        for (int i = p2; i < ps2.size(); i++) {
            combine.add(ps2.get(i));
        }
        Collections.sort(combine);
        int p = 0;
        while (p < c && p < combine.size()){
            nums ++;
            ans += combine.get(p);
            p++;
        }
        System.out.println(nums + " " + ans);
    } 
}