import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class pqueue{
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("pqueue.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pqueue.out")));
        int n = Integer.parseInt(r.readLine());
        PriorityQueue<Long> order = new PriorityQueue<Long>();
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i++) {
            order.add(Long.parseLong(st.nextToken()));
        }
        order.
    }
}