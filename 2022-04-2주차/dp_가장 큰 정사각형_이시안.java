import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 1][m + 1];

        int result = 0;
        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = input.charAt(j - 1) - '0';

                // 정사각형이 되려면 현재 위치에서 좌, 좌상, 상의 값이 다 1이어야 한다
                // Math.min으로 현재 위치에 좌, 좌상, 상의 값 중 가장 작은 값을 넣어 가능한 큰 정사각형이 되는 지 체크
                if (map[i][j] == 1) {
                    map[i][j] = Math.min(map[i - 1][j - 1], Math.min(map[i - 1][j], map[i][j - 1])) + 1;
                    result = Math.max(result, map[i][j]); // 가장 큰 정사각형을 만드는 값
                }
            }
        }
        System.out.println(result * result);
    }
}