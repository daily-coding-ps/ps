package programmers;

public class Friends4Block {
    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        String[] board = new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"};
        Friends4Block main = new Friends4Block();
        System.out.println(main.solution(m, n, board));
    }

    public int solution(int m, int n, String[] board) {
        char[][] map = new char[n][m];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                map[j][i] = board[i].charAt(j);
            }
        }

        int answer = 0;

        boolean flag = true;

        while (flag) {

            flag = false; // 지워줄 블록이 있는지 체크하기 위함

            int[][] visited = new int[n][m]; // 지워줄 블록을 표시해줄 배열

            // 현재 위치에서 상하좌우 검증
            for (int i = 0; i < map.length - 1; i++) {
                for (int j = 0; j < map[i].length - 1; j++) {
                    if (map[i][j] == '0') {
                        continue; // 비어있는 블록
                    }

                    // 상하좌우가 일치하면 아래에서 제거하도록 체크
                    if (map[i][j] == map[i + 1][j] && map[i + 1][j] == map[i + 1][j + 1]
                            && map[i][j + 1] == map[i + 1][j + 1] && map[i][j + 1] == map[i][j]) {

                        visited[i][j] = 1;
                        visited[i + 1][j] = 1;
                        visited[i + 1][j + 1] = 1;
                        visited[i][j + 1] = 1;

                        flag = true;
                    }
                }
            }

            // 블록을 지우고 빈칸 채우기
            for (int i = 0; i < visited.length; i++) {
                for (int j = 0; j < visited[i].length; j++) {

                    // 지울 블록
                    if (visited[i][j] == 1) {
                        answer++;
                        for (int k = j - 1; k >= 0; k--) { // 현재 블록의 열에 해당하는 부분을 다시 셋팅
                            map[i][k + 1] = map[i][k];
                            map[i][k] = '0'; // 빈칸 처리
                        }
                    }
                }
            }
        }
        return answer;
    }
}
