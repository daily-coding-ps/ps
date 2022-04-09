class Solution {
    public long solution(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1]; // dp 테이블

        // 뛸 수 있는 거리
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567; // 피보나치 수열 구하기
        }

        return dp[n];
    }
}