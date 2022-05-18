import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class 진우의 달 여행 {

    static int N, M;
    static int[][] arr;

    static int[][][] dp; // 방향 0 : 오른쪽 아래, 방향 1 : 아래, 방향 2 : 왼쪽 아래

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dp = new int[3][N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 값 세팅
        IntStream.range(0, M).forEach(i -> {
            dp[0][0][i] = arr[0][i];
            dp[1][0][i] = arr[0][i];
            dp[2][0][i] = arr[0][i];
        });

        // 존재하지 않을 경우 처리
        for (int i = 0; i < N; i++) {
            // 맨 왼쪽 끝인데 왼쪽 대각선에서 오는 경우
            dp[0][i][0] = Integer.MAX_VALUE;
            // 맨 오른쪽 끝인데 오른쪽 대각선 방향에서 오는 경우
            dp[2][i][M-1] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 왼쪽, 오른쪽 방향에서 모두 올수있는 경우
                if (isValidPosition(j - 1) && isValidPosition(j + 1)) {
                    dp[0][i][j] = Math.min(dp[1][i - 1][j - 1], dp[2][i - 1][j - 1]) + arr[i][j];
                    dp[1][i][j] = Math.min(dp[0][i - 1][j], dp[2][i - 1][j]) + arr[i][j];
                    dp[2][i][j] = Math.min(dp[0][i - 1][j + 1], dp[1][i - 1][j + 1]) + arr[i][j];
                } else if (!isValidPosition(j - 1) && isValidPosition(j + 1)) { // 왼쪽 끝에 있는 경우
                    dp[1][i][j] = Math.min(dp[0][i - 1][j], dp[2][i - 1][j]) + arr[i][j];
                    dp[2][i][j] = Math.min(dp[0][i - 1][j + 1], dp[1][i - 1][j + 1]) + arr[i][j];
                } else if (isValidPosition(j - 1) && !isValidPosition(j + 1)) { // 오른쪽 끝에 있는 경우
                    dp[0][i][j] = Math.min(dp[1][i - 1][j - 1], dp[2][i - 1][j - 1]) + arr[i][j];
                    dp[1][i][j] = Math.min(dp[0][i - 1][j], dp[2][i - 1][j]) + arr[i][j];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        // 최소값 찾기
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                min = Math.min(min, dp[j][N - 1][i]);
            }
        }
        System.out.println(min);
    }

    private static boolean isValidPosition(int p) {
        return p >= 0 && p < M;
    }


}
