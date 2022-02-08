package 이코테.DFS_BFS;

import java.io.*;
import java.util.*;

public class Q21 {
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    static int n, l , r;
    static int[][] map;
    static boolean[][] check;
    static ArrayList<Node> union;
    static boolean isMove;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;

        while (true) {
            isMove = false;
            check = new boolean[n][n]; //날이 지나면 초기화

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(!check[i][j]){
                        bfs(i, j);
                    }
                }
            }

            if(!isMove) break;
            day++;
        }

        System.out.println(day);
    }

    static void bfs(int i, int j) {
        Queue<Node> q = new LinkedList<>();
        union = new ArrayList<>(); //국경의 좌표를 담는 리스트 (연합의 인구수)/(연합을 이루고 있는 칸의 개수)를 구하기 위함
        
        q.add(new Node(i, j));
        union.add(new Node(i, j));
        check[i][j] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (0 <= nx && nx < n && 0 <= ny && ny < n && !check[nx][ny]) {
                    int peopleDiff = Math.abs(map[x][y] - map[nx][ny]);

                    if (l <= peopleDiff && peopleDiff <= r) {
                        q.add(new Node(nx, ny));
                        union.add(new Node(nx, ny));
                        check[nx][ny] = true;
                    }
                }
            }
        }

        peopleMove();
    }

    static void peopleMove() {
        int totalPeople = 0;

        if (union.size() > 1) { //연합이 한개보다 커야지 인구 이동이 이루어짐
            isMove = true;
        }else{
            return;
        }

        for (Node node : union) {
            totalPeople += map[node.x][node.y];
        }

        for (Node node : union) {
            map[node.x][node.y] = totalPeople / union.size();
        }

    }
}
