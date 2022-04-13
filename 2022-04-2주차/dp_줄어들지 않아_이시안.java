import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] dp = new long[65][11]; // dp[i][j] : i는 자리 수, j는 시작하는 수

        Arrays.fill(dp[1], 1);

        // i-1의 자리의 j로 시작하는 수부터 i-1 자리의 9까지 줄어들지 않는 수를 더하기
        for (int i = 2; i <= 64; i++) {
            for (int j = 1; j <= 10; j++) {
                dp[i][j] += dp[i - 1][j] + dp[i][j - 1];
            }
        }

        int t = Integer.parseInt(br.readLine());


        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long result = 0;

            for (int i = 1; i <= 10; i++) {
                result += dp[n][i];
            }

            System.out.println(result);
        }
    }
}