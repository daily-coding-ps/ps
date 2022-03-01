//퇴사
package 이코테.DP;

import java.io.*;
import java.util.*;

public class Q33 {
    static int[] t, p, d;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        t = new int[n];
        p = new int[n];
        d = new int[n+1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i + t[i] <= n) {
                d[i + t[i]] = Math.max(d[i + t[i]], d[i] + p[i]);
            }
            d[i + 1] = Math.max(d[i + 1], d[i]);
        }

        System.out.println(d[n]);
    }
}
