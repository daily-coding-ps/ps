import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 1];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x] = y;
            }

            int result = 1; // 선발되는 인원은 최소 한 명
            int pivot = arr[1]; // 기준
            for (int i = 2; i <= N; i++) {
                if (pivot > arr[i]) { // 기준보다 높은 등수인 경우
                    result++; // 선발 인원 증가
                    pivot = arr[i]; // 기준 변경
                }
            }
            System.out.println(result);
        }
    }
}
