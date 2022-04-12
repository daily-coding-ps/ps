class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int mod = 1000000007;

        int[][] d = new int[n + 1][m + 1];

        for (int[] puddle : puddles) {
            d[puddle[1]][puddle[0]] = -1;
        }

        d[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (d[i][j] == -1) {
                    continue;
                }

                if (d[i - 1][j] != -1) {
                    d[i][j] += (d[i - 1][j] % mod);
                }
                if (d[i][j - 1] != -1) {
                    d[i][j] += (d[i][j - 1] % mod);
                }
            }
        }

        return d[n][m] % mod;
    }
}