package 스터디.PS4월2주차;

import java.io.*;
import java.util.*;

public class PS0411_2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] line = new int[n + 1][2];
        int[] d = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line, (o1, o2) -> o1[0] - o2[0]);

        for (int i = 1; i <= n; i++) {
            d[i] = 1;
            for (int j = 1; j < i; j++) {
                if (line[i][1] > line[j][1]) {
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, d[i]);
        }

        System.out.println(n - max);
    }
}
