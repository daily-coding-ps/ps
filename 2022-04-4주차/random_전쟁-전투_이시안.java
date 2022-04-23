package bjo._1303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] map; // W, B가 들어갈 2차원 배열
    static boolean[][] checked; // 방문 처리용
    static int W = 0;
    static int H = 0;
    static int sumW = 0;
    static int sumB = 0;
    static int cnt = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        checked = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            String str = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (!checked[i][j]) {
                    bfs(i, j, map[i][j]);
                    if (map[i][j] == 'W') {
                        sumW += cnt * cnt;
                    } else {
                        sumB += cnt * cnt;
                    }
                    cnt = 0;
                }
            }
        }
        System.out.println(sumW + " " + sumB);
    }

    public static void bfs(int x, int y, char team) {
        Queue<Node> queue = new LinkedList();
        checked[x][y] = true;
        queue.offer(new Node(x, y));

        // 큐가 빌 때까지 cnt를 증가시키며 반복
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                // map 범위를 벗어나는 지 확인
                if (nx >= 0 && ny >= 0 && nx < H && ny < W) {
                    // 방문한 적이 없으며 같은 팀인 경우에만 처리
                    if (!checked[nx][ny] && map[nx][ny] == team) {
                        checked[nx][ny] = true;
                        queue.offer(new Node(nx, ny));
                    }
                }
            }
        }
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
