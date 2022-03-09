import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        while (T-- != 0) {
            long result = 0; // 결과값
            int max = 0; // 최고가
            int N = Integer.parseInt(br.readLine()); // 날의 수
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = N - 1; i >= 0; i--) {
                if (arr[i] > max) {
                    max = arr[i]; // 최고가보다 현재가가 높으면 변경
                } else {
                    result += max - arr[i]; // 최고가에서 현재가를 뺀 가격
                }
            }
            System.out.println(result);
        }
    }
}
