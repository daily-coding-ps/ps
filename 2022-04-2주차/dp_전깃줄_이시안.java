import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][2];
        int[] dp = new int[n]; // dp 테이블

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken()); // A 전봇대
            map[i][1] = Integer.parseInt(st.nextToken()); // B 전봇대
        }

        // A 전봇대 정렬
        Arrays.sort(map, (Comparator.comparingInt(o -> o[0])));

        for (int i = 0; i < n; i++) {
            dp[i] = 1; // 최소 전선 값

            for (int j = 0; j < i; j++) {
                // i번째의 B 전봇대 값보다 이전의 B 전봇대 값이 크면 dp 테이블에 저장
                if (map[i][1] > map[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dp[i]);
        }

        // 전체 개수 - 설치 가능한 전선
        System.out.println(n - result);
    }
}
