import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    private static int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};
    private static String[][] map = new String[19][19];
    private static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 19; i++) {
            map[i] = br.readLine().split(" ");
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (map[i][j].equals("1") || map[i][j].equals("2")) {
                    for (int k = 0; k < 4; k++) {
                        cnt = 1;
                        // 6목 확인
                        if (check(k, map[i][j], i, j) == 5 && !checkPrev(k + 4, map[i][j], i, j)) {
                            System.out.printf("%s\n%d %d", map[i][j], i + 1, j + 1);
                            System.exit(0);
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }

    private static boolean checkPrev(int k, String color, int r, int c) {
        // 6목 확인
        return 0 <= r + dx[k] && r + dx[k] < 19 && 0 <= c + dy[k] && c + dy[k] < 19 && map[r + dx[k]][c + dy[k]].equals(color);
    }

    private static int check(int dir, String color, int r, int c) {

        if (dir == 0) {
            // 바둑판 밖을 탐색하는 경우가 아니고, 해당 방향에 같은 색의 바둑돌이 존재한다면
            if (search(dir, color, r, c))
                return cnt;
        } else if (dir == 1) {
            if (search(dir, color, r, c))
                return cnt;
        } else if (dir == 2) {
            if (search(dir, color, r, c))
                return cnt;
        } else if (dir == 3) {
            if (search(dir, color, r, c))
                return cnt;
        }
        return cnt;
    }

    private static boolean search(int dir, String color, int r, int c) {
        if (0 <= r + dx[dir] && r + dx[dir] < 19 && 0 <= c + dy[dir] && c + dy[dir] < 19 && map[r + dx[dir]][c + dy[dir]].equals(color)) {
            cnt++; // 연속된 바둑알 수
            check(dir, color, r + dx[dir], c + dy[dir]); // 해당 방향 계속 탐색
        } else {
            return true;
        }
        return false;
    }
}
