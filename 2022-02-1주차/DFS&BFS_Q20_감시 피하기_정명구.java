package 이코테.DFS_BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q20 {
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static ArrayList<Node> student = new ArrayList<>();
    static int n;
    static char[][] map;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if(map[i][j] == 'S'){
                    student.add(new Node(i, j));
                }
            }
        }
        dfs(0);

        System.out.println("NO");

    }

    static void dfs(int wall) {
        if (wall == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'X') {
                    map[i][j] = 'O';
                    dfs(wall + 1);
                    map[i][j] = 'X';
                }
            }
        }
    }

    private static void bfs() {

        Queue<Node> q = new LinkedList<>();
        char[][] copyMap = new char[n][n];
        boolean[][] check = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (copyMap[i][j] == 'T') {
                    q.add(new Node(i, j));
                    check[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                while(0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (copyMap[nx][ny] != 'O') {
                        check[nx][ny] = true;
                        nx += dx[k];
                        ny += dy[k];
                    }else{
                        break;
                    }
                }
            }
        }
        if(catchStudent(check)){
            System.out.println("YES");
            System.exit(0);
        }
    }

    private static boolean catchStudent(boolean[][] check) {

        for (Node node : student) {
            if (check[node.x][node.y] == true) {
                return false;
            }
        }
        return true;
    }
}
