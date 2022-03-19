import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 좌표값
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int M = 0;
    static int N = 0;
    static Queue<Node> queue = new LinkedList<>();
    static int[][] tomato = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomato = new int[N][M];
        int cnt = 0; // 익지 않은 토마토의 개수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    queue.offer(new Node(i, j)); // 익은 토마토를 큐에 추가
                }
                if (tomato[i][j] == 0) {
                    cnt++;
                }
            }
        }

        // 익지 않은 토마토가 없는 경우 = 모든 토마토가 저장할 때 익은 토마토
        if (cnt == 0) {
            System.out.println(0);
            return;
        }

        bfs();

        int day = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 토마토가 전부 익을 수 없는 상황
                if (tomato[i][j] == 0) {
                    System.out.println(-1);
                    return;
                } else {
                    day = Math.max(day, tomato[i][j]); // 가장 마지막에 익은 토마토의 day 구하기
                }
            }
        }
        System.out.println(day - 1); // 0일부터 시작이기 때문에 -1
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];

                // 이동이 가능한 지 확인
                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                    // 익지 않은 토마토 = 방문을 아직 안함
                    if (tomato[nextX][nextY] == 0) {
                        tomato[nextX][nextY] = tomato[node.x][node.y] + 1; // 방문 처리, 익은 날 저장
                        queue.offer(new Node(nextX, nextY)); // 익은 토마토를 큐에 추가
                    }
                }
            }
        }
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
