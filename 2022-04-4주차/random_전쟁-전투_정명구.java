//백준 전쟁-전투
package 스터디.PS4월4주차;

import java.io.*;
import java.util.*;

public class PS0425_1303 {
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};

    static char[][] warMap;
    static boolean[][] check;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        warMap = new char[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            warMap[i] = br.readLine().toCharArray();
        }

        int whiteTeamPower = 0;
        int BlueTeamPower = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!check[i][j]) {
                    if (warMap[i][j] == 'W') {
                        int whiteTeam = 0;
                        whiteTeam += bfs(i, j, warMap[i][j]);
                        whiteTeamPower += (whiteTeam * whiteTeam);
                    }

                    if (warMap[i][j] == 'B') {
                        int blueTeam = 0;
                        blueTeam += bfs(i, j, warMap[i][j]);
                        BlueTeamPower += (blueTeam * blueTeam);
                    }
                }
            }
        }

        System.out.println(whiteTeamPower + " " + BlueTeamPower);

    }

    static int bfs(int x, int y, char army) {
        Queue<Node> q = new LinkedList<>();
        check[x][y] = true;
        q.add(new Node(x, y));
        int count = 1;

        while (!q.isEmpty()) {
            Node now = q.poll();
            x = now.x;
            y = now.y;

            for (int k = 0; k < 4; k++) {
                int nx = dx[k] + x;
                int ny = dy[k] + y;

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (!check[nx][ny] && army == warMap[nx][ny]) {
                        q.add(new Node(nx, ny));
                        check[nx][ny] = true;
                        count++;
                    }
                }
            }
        }

        return count;

    }

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
