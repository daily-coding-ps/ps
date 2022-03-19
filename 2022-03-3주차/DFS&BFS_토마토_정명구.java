//백준 토마토

import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static final int dx[] = {0, 0, 1, -1};
    static final int dy[] = {1, -1, 0, 0};
    static int[][] tomato;
    static int[][] day; //0일
    static int n, m;
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        tomato = new int[n][m];
        day = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    q.add(new Node(i, j));
                }
            }
        }

        bfs();

        int ans = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, day[i][j]);
                if (tomato[i][j] == 0 && day[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(ans);
    }

    static void bfs(){

        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (tomato[nx][ny] == 0 && day[nx][ny] == 0) {
                        q.add(new Node(nx, ny));
                        day[nx][ny] = day[x][y] + 1;
                    }

                }
            }

        }
    }
}



