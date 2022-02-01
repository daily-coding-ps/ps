import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UpDownLeftRight {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ArrayList<String> plan = new ArrayList<>();

        while (st.hasMoreTokens()) {
            plan.add(st.nextToken());
        }

        // 처음 시작 좌표
        int x = 1;
        int y = 1;

        // L, R, U, D에 따른 이동값
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        String[] moves = {"L", "R", "U", "D"};

        // L, R, U, D와 일치 여부 확인
        for (String move : plan) {
            for (int j = 0; j < moves.length; j++) {
                if (move.equals(moves[j])) {
                    // x나 y가 지도를 벗어나는 범위가 아닌 경우에만 이동
                    if ((x + dx[j]) > 0 && (x + dx[j]) <= N && (y + dy[j]) > 0 && (y + dy[j]) <= N) {
                        x += dx[j];
                        y += dy[j];
                    }
                }
            }
        }

        System.out.println(x + " " + y);
    }
}
