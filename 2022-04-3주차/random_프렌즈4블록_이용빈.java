import java.util.*;

public class 프렌즈4블록 {

    static char[][] map;
    static int answer = 0;

    public static void main(String[] args) {
        System.out.println(solution(4, 5, new String[]{
            "CCBDE",
            "AAADE",
            "AAABF",
            "CCBBF"}));
    }

    public static int solution(int m, int n, String[] board) {

        map = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        // 지워질 블럭이 있는 경우 반복
        while (true) {
            if (!updateBlocks(m, n)) {
                break;
            }
        }

        return answer;
    }

    public static boolean updateBlocks(int m, int n) {
        boolean[][] check = new boolean[m][n];
        int cnt = 0; // 사라진 블럭 수

        // 체크
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (map[i][j] == '0') {
                    continue;
                }
                if (checkSameBlock(i, j)) { // 만약 2x2가 같다면 true로 바꿈 // true = 제거대상
                    check[i][j] = true;
                    check[i][j + 1] = true;
                    check[i + 1][j] = true;
                    check[i + 1][j + 1] = true;
                }
            }
        }

        // 갱신 check가 true인 것들을 지우고 기존것들은 내림
        for (int i = 0; i < n; i++) {
            List<Character> temp = new ArrayList<>();
            for (int j = m - 1; j >= 0; j--) {
                if (check[j][i]) {
                    cnt++;
                    continue;
                }
                temp.add(map[j][i]);
            }

            for (int j = m - 1, k = 0; j >= 0; j--, k++) {
                if (k < temp.size()) {
                    map[j][i] = temp.get(k);
                } else {
                    map[j][i] = '0';
                }
            }
        }

        answer += cnt; // 사라진 블럭 수 더하기

        return cnt > 0; // 바뀐게 있다면 true
    }

    public static boolean checkSameBlock(int i, int j) {
        char std = map[i][j];

        return map[i][j + 1] == std && map[i + 1][j] == std && map[i + 1][j + 1] == std; // 오른쪽, 아래, 대각선 오른쪽 아래가 같으면
    }
}
