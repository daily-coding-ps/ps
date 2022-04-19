import java.util.*;

public class 거리두기 확인하기 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
            new String[][]{
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
            })));
    }

    public static int[] solution(String[][] places) {
        int[] result = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            result[i] = check(places[i]);
        }
        return result;
    }

    public static int check(String[] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'P') {
                    if (!bfs(board, i, j)) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }

    public static boolean bfs(String[] board, int x, int y) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board.length];
        q.offer(new Node(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                // 맨해튼 거리 공식 = |r1 - r2| + |c1 - c2|
                int manhattan = Math.abs(x - nx) + Math.abs(y - ny);

                // 이동할수 없는곳이거나 이미 방문했거나 맨해튼 거리가 2를 넘은 경우는 무시
                if (nx < 0 || ny < 0 || nx >= board.length || ny >= board.length
                    || visited[nx][ny] || manhattan > 2) {
                    continue;
                }

                visited[nx][ny] = true;
                if (board[nx].charAt(ny) == 'X') {
                    continue;
                } else if (board[nx].charAt(ny) == 'P') {
                    return false;
                } else {
                    q.offer(new Node(nx, ny));
                }
            }
        }
        return true;
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
