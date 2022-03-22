import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {

    static int N;
    static int M;
    static int[][] box;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        box = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
    }

    static void bfs() {
        Queue<Dot> q = new LinkedList<>();
        int day = 0;

        // 토마토가 있는 좌표를 찾아서 큐에 넣음
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (box[i][j] == 1) {
                    q.offer(new Dot(i, j, 0));
                }
            }
        }

        while (!q.isEmpty()) {

            // 큐에 있는 x, y 좌표와 day를 꺼냄
            Dot dot = q.poll();
            day = dot.day;

            // 상하좌우 4방향 이동
            for (int i = 0; i < 4; i++) {
                int nx = dot.x + dx[i];
                int ny = dot.y + dy[i];

                if (0 <= nx && nx < M && 0 <= ny && ny < N) { // 이동 가능한 곳인지
                    if (box[nx][ny] == 0) { // 안익은 토마토라면
                        box[nx][ny] = 1; // 토마토를 익히고
                        q.add(new Dot(nx, ny, day + 1)); // 큐에 좌표와 day+1을 추가
                    }
                }
            }
        }

        // 이동가능한 경우의 모든 경우를 돈 뒤 안익은 토마토가 있는지 체크
        if (checkTomato()) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }

    static boolean checkTomato() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (box[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    static class Dot {

        int x;
        int y;
        int day;

        public Dot(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
}

