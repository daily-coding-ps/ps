package 이코테.DP;

import java.util.*;
import java.io.*;

public class Q31 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());


        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] map = new int[n][m];
            int[][] d = new int[n][m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            d[0][0] = map[0][0];
            d[1][0] = map[1][0];
            d[2][0] = map[2][0];

            for (int j = 1; j < m; j++) {
                for (int i = 0; i < n; i++) {
                    if (i - 1 < 0) {
                        d[i][j] = Math.max(d[i][j - 1], d[i + 1][j - 1]) + map[i][j];
                    } else if (i + 1 > n - 1) {
                        d[i][j] = Math.max(d[i][j - 1], d[i - 1][j - 1]) + map[i][j];
                    } else {
                        d[i][j] = Math.max(d[i][j - 1], Math.max(d[i - 1][j - 1], d[i + 1][j - 1])) + map[i][j];
                    }
                }
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (ans < d[i][m - 1]) {
                    ans = d[i][m - 1];
                }
            }

            sb.append(ans + "\n");
        }

        System.out.println(sb);
    }
}
