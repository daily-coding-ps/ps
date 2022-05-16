package 백준.PS5월;

import java.io.*;
import java.util.*;

public class PS0516_17485 {
    static int n, m;
    static int[][] map;
    static int[][][] d;
    static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        d = new int[n][m][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (i == 0) {
                    d[i][j][0] = map[i][j];
                    d[i][j][1] = map[i][j];
                    d[i][j][2] = map[i][j];
                }
                else if (j == m - 1) {
                    d[i][j][0] = Integer.MAX_VALUE;
                }
                else if (j == 0) {
                    d[i][j][2] = Integer.MAX_VALUE;
                }
            }
        }

        solution();
        System.out.println(minCost);
    }

    static void solution() {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isValid(i - 1, j + 1)) {
                    d[i][j][0] = Math.min(d[i - 1][j + 1][1], d[i - 1][j + 1][2]) + map[i][j];
                }
                if (isValid(i - 1, j)){
                    d[i][j][1] = Math.min(d[i-1][j][0], d[i-1][j][2]) + map[i][j];
                }

                if (isValid(i - 1, j - 1)) {
                    d[i][j][2] = Math.min(d[i - 1][j - 1][0], d[i - 1][j - 1][1]) + map[i][j];
                }
            }
        }

        for (int j = 0; j < m; j++) {
            for (int k = 0; k < 3; k++) {
                if (minCost > d[n-1][j][k])
                    minCost = d[n-1][j][k];
            }
        }
    }

    static boolean isValid(int x, int y) {
        return (0 <= x && x < n) && (0 <= y && y < m);
    }
}