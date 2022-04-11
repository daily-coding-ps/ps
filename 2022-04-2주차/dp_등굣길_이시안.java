class Solution {
   public int solution(int m, int n, int[][] puddles) {
      int[][] map = new int[n + 1][m + 1];

        // 웅덩이는 -1
        for (int[] puddle : puddles) {
            map[puddle[1]][puddle[0]] = -1;
        }

        map[1][1] = 1;

        for (int i = 1; i < n + 1; i++) { // 시작점은 1로 저장
            for (int j = 1; j < m + 1; j++) {

                if (map[i][j] == -1) { // 웅덩이면 continue
                    continue;
                }

                // 테두리 확인
                if (map[i - 1][j] > 0) {
                    map[i][j] += map[i - 1][j] % 1000000007;
                }
                if (map[i][j - 1] > 0) {
                    map[i][j] += map[i][j - 1] % 1000000007;
                }
            }
        }

        return map[n][m] % 1000000007;
  }
}