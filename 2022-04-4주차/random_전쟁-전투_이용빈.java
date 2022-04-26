import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _4 {


    static boolean[][] visited;
    static Character[][] map;
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int W, B = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Character[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    if (map[i][j] == 'B') {
                        B += Math.pow(bfs(map[i][j], i, j), 2);
                    } else if (map[i][j] == 'W') {
                        W += Math.pow(bfs(map[i][j], i, j), 2);
                    }
                }
            }
        }
        System.out.println(W + " " + B);
    }

    public static int bfs(Character color, int x, int y) {
        int count = 1;
        Queue<Node> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new Node(x, y));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nowX = now.x + dx[i];
                int nowY = now.y + dy[i];

                if (nowX >= 0 && nowX < M && nowY >= 0 && nowY < N) { // 이동 가능한 곳인지
                    if (!visited[nowX][nowY] && color == map[nowX][nowY]) { // 방문하지 않았고 컬러가 같다면
                        queue.offer(new Node(nowX, nowY));
                        visited[nowX][nowY] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    static class Node {

        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
