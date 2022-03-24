import java.util.*;

class Solution {

    static class Node{
        int x;
        int y;
        int dir;
        int price;

        public Node(int x, int y, int dir, int price) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.price = price;
        }
    }

    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    static int[][][] visit;

    static int n, ans;

    public int solution(int[][] board) {
        int answer = 0;

        ans = Integer.MAX_VALUE;
        n = board.length;
        visit = new int[n][n][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    visit[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        bfs(board);

        return ans;
    }

    static void bfs(int[][] board){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, -1, 0));
        visit[0][0][0] = visit[0][0][1] = visit[0][0][2] = visit[0][0][3] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;

            if (x == n - 1 && y == n - 1) {
                ans = Math.min(ans, now.price);
            }

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (0 <= nx && nx < n && 0 <= ny && ny < n && board[nx][ny] == 0) {
                    //직진 방향 처리
                    int nextPrice = 0;
                    if (now.dir == -1 || now.dir == k) {
                        nextPrice = now.price + 100;
                    }else{
                        nextPrice = now.price + 600;
                    }
                    if (visit[nx][ny][k] == Integer.MAX_VALUE || visit[nx][ny][k] >= nextPrice) {
                        q.add(new Node(nx, ny, k, nextPrice));
                        visit[nx][ny][k] = nextPrice;
                    }
                }
            }
        }
    }
}