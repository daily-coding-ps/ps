import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _카드_정렬하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(Long.valueOf(br.readLine()));
        }

        long num = 0;
        while (pq.size() > 1) {
            long a = pq.poll();
            long b = pq.poll();

            num += a + b;
            pq.add(a + b);
        }

        System.out.println(num);
    }
}
