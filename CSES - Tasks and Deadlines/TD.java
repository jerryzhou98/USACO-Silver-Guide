import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TD {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(r.readLine());
        Task[] tasks = new Task[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            tasks[i] = new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(tasks);

        long answer = 0;
        long time = 0;
        for (Task t:
             tasks) {
            time += t.a;
            answer += t.b - time;
        }

        System.out.println(answer);

        r.close();
    }

    static class Task implements Comparable<Task>{
        int a; int b;

        public Task(int x, int y) {
            this.a = x; this.b = y;
        }

        public int compareTo(Task other) {
            return Integer.compare(this.a, other.a);
        }
    }
}
