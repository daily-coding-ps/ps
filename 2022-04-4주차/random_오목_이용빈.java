import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 오목 {

    static char[][] map = new char[19][19];
    static int[] dx = {1, 1, 0, -1}; // 오른쪽, 오른쪽 대각선 아래, 아래, 오른쪽 대각선 위
    static int[] dy = {0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 19; i++) {
            String str = br.readLine().replaceAll(" ", "");
            for (int j = 0; j < 19; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (map[i][j] != '0') { // 빈칸이 아니라면
                    for (int d = 0; d < 4; d++) {
                        int cnt = bfs(i, j, d);
                        if (cnt == 5) { // 오목이라면
                            System.out.println(map[i][j]); // 승리자 출력
                            System.out.println((i + 1) + " " + (j + 1)); // 좌표 출력
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0); // 승리자 없음

    }

    private static int bfs(int x, int y, int dir) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 1));
        int max = 0;
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            max = Math.max(tmp.cnt, max);
            int nx = tmp.x + dx[dir];
            int ny = tmp.y + dy[dir];

            // 이동 못하는 곳이거나 이동한곳의 바둑알 색이 다르면 패스
            if (nx < 0 || nx >= 19 || ny < 0 || ny >= 19 || map[nx][ny] != map[tmp.x][tmp.y]) {
                continue;
            }
            queue.add(new Node(nx, ny, tmp.cnt + 1)); // 이동 및 개수 1 추가
        }
        if (max == 5) { // 오른쪽 방향으로 탐색한 결과가 오목이라면 -> 왼쪽 방향 탐색을 해서 육목 검사
            int nx = x - dx[dir];
            int ny = y - dy[dir];
            // 이동 가능한 곳이고 바둑알 색이 같다면 max++; => 육목 체크
            if (nx >= 0 && nx < 19 && ny >= 0 && ny < 19 && map[nx][ny] == map[x][y]) {
                max++;
            }
        }
        return max;
    }

    static class Node {

        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

}
