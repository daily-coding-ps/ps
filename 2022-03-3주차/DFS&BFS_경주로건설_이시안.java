import java.util.LinkedList;
import java.util.Queue;

public class BuildRaceway {
    static int min = Integer.MAX_VALUE;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;
    static boolean[][][] visited; // 방문 처리용 3차원 배열

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
    }

    public static int solution(int[][] board) {
        N = board.length;
        visited = new boolean[N][N][4]; // 4는 상하좌우
        bfs(board);
        return min;
    }

    public static void bfs(int[][] board) {
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(0, 0, 0, -1));

        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.x == N - 1 && node.y == N - 1) { // 도착점 도달 시
                min = Math.min(min, node.cost); // 최소값 갱신
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && board[nx][ny] != 1) { // 이동 가능한 지역인 경우
                    int newCost;
                    if (node.dir == -1 || node.dir == i) { // 같은 방향으로 이동하는 지 판단
                        newCost = node.cost + 100; // 직진
                    } else {
                        newCost = node.cost + 600; // 코너
                    }

                    // 처음 방문하거나 이전에 방문했을 때의 비용보다 작거나 같으면
                    if (!visited[nx][ny][i] || board[nx][ny] + 600 >= newCost) {
                        visited[nx][ny][i] = true;
                        board[nx][ny] = newCost; // 최저 비용 갱신
                        q.add(new Node(nx, ny, newCost, i)); // 해당 지점으로 이동한다
                    }
                }
            }
        }
    }

    static class Node {
        int x;
        int y;
        int cost;
        int dir;

        public Node(int x, int y, int cost, int dir) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }
    }
}