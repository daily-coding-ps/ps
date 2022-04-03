import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int low = 0;
        int high = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            high += arr[i]; // 모든 점수를 합친 값
        }

        while (low <= high) {
            int mid = (low + high) / 2; // 그룹별 최대 점수
            int cnt = 0;
            int sum = 0;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                sum += arr[i];

                // 최대 점수를 넘긴 경우
                if (sum >= mid) {
                    cnt++;
                    min = Math.min(min, sum); // 최소값 중 최대값 구하기
                    sum = 0;
                }
            }

            if (cnt >= K) {
                low = mid + 1; // K 이상으로 나뉘었다면 최소점 증가
            } else {
                high = mid - 1; // K 미만으로 나뉘었다면 최고점 감소
            }
        }

        System.out.println(low - 1);
    }
}
