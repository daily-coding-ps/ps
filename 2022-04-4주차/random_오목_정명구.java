package 스터디.PS4월4주차;

import java.io.*;
import java.util.*;

public class PS0426_2615 {
    static int n = 19;
    static int[][] map;
    static boolean[][] check;
    static boolean[][] winCheck;
    static final int[] dx = {-1, 0, -1, -1, 1, 0, 1, 1};
    static final int[] dy = {0, -1, -1, 1, 0, 1, 1, -1};
    static ArrayList<Node> list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[n][n];
        check = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!check[i][j] && map[i][j] != 0) {
                    if (bfs(i, j, map[i][j])) {
                        System.out.println(sb);
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }

    static boolean bfs(int x, int y, int color) {
        Queue<Node> q = new LinkedList<>();
        check[x][y] = true;
        q.add(new Node(x, y));

        winCheck = new boolean[n][n];
        winCheck[x][y] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();
            x = now.x;
            y = now.y;

            for (int k = 0; k < 4; k++) {

                int count = 1;
                list = new ArrayList<>();
                list.add(new Node(x, y));

                if (k == 0) {
                    count += search(k, winCheck, now, color);
                    count += search(k + 4, winCheck, now, color);
                }

                if (k == 1) {
                    count += search(k, winCheck, now, color);
                    count += search(k + 4, winCheck, now, color);
                }

                if (k == 2) {
                    count += search(k, winCheck, now, color);
                    count += search(k + 4, winCheck, now, color);
                }

                if (k == 3) {
                    count += search(k, winCheck, now, color);
                    count += search(k + 4, winCheck, now, color);
                }

                if (count == 5) {
                    sb.append(color + "\n");
                    findPoint(list);
                    return true;
                }
            }
        }
        return false;
    }

    static int search(int k, boolean[][] winCheck, Node now, int color) {
        int count = 0;
        int nx = now.x + dx[k];
        int ny = now.y + dy[k];

        while(0 <= nx && nx < n && 0 <= ny && ny < n) {
            if (color == map[nx][ny] && !winCheck[nx][ny]) {
                winCheck[nx][ny] = true;
                list.add(new Node(nx, ny));
                nx += dx[k];
                ny += dy[k];
                count++;
            }else{
                break;
            }
        }
        return count;
    }

    static void findPoint(ArrayList<Node> list) {

        Collections.sort(list, (o1, o2) -> o1.y - o2.y);

        if (list.get(0).y == list.get(list.size() - 1).y) {
            Collections.sort(list, (o1, o2) -> o1.x - o2.x);
        }

        sb.append((list.get(0).x + 1) + " " +(list.get(0).y + 1));
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
