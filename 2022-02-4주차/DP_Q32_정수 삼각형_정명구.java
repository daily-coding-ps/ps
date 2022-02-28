//정수 삼각형
package 이코테.DP;

import java.io.*;
import java.util.*;


public class Q32 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];
        int[][] d = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                d[i][j] = Math.max(d[i - 1][j - 1], d[i - 1][j]) + arr[i][j];
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (ans < d[n][i]) {
                ans = d[n][i];
            }
        }

        System.out.println(ans);
    }
}

