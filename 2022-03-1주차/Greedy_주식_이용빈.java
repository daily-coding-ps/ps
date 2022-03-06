import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] stock = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                stock[j] = Integer.parseInt(st.nextToken());
            }

            long max = 0;
            long answer = 0;

            // 뒤에서 부터 for문을 돌림
            for (int j = N - 1; j >= 0; j--) {

                // 현재 주식 가격이 max보다 크면 max로 설정
                if (stock[j] > max) {
                    max = stock[j];
                } else {
                    answer += max - stock[j]; // 만약 max보다 작으면 max에서 팔았다고 가정하고 차익계산 후 answer에 더함
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

}
