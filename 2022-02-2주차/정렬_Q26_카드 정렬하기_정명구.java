package 이코테.Sort;

import java.io.*;
import java.util.*;

public class Q26 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> q = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            q.add(Long.parseLong(br.readLine()));
        }

        long sum = 0;
        while (q.size() > 1) {
            long a = q.poll();
            long b = q.poll();

            sum += (a + b);
            q.add(a + b);
        }

        System.out.println(sum);

    }
}
