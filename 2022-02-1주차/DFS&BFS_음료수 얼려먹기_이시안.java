package thisiscote.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IceJuice {

    static int N;
    static int M;
    static int[][] square;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 2차원 배열 생성
        square = new int[N][M];

        // 2차원 배열 초기화
        for (int x = 0; x < N; x++) {
            String str = br.readLine();
            for (int y = 0; y < M; y++) {
                square[x][y] = str.charAt(y) - '0';
                // System.out.print(square[x][y]);
            }
            // System.out.println();
        }

        int result = 0;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (dfs(x, y)) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    public static boolean dfs(int x, int y) {

        // 범위를 벗어나면 즉시 종료
        if (x < 0 || y < 0 || x >= N || y >= M) {
            return false;
        }

        // 방문 여부 확인
        if (square[x][y] == 0) {
            square[x][y] = 1;

            // 상하좌우 좌표도 모두 재귀 호출
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);

            return true;
        }

        return false;
    }
}
