import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무 자르기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        int l = 0;
        int r = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (r < arr[i]) {
                r = arr[i]; // 최대값
            }
        }

        int result = 0;
        while (l <= r) {

            int mid = (l + r) / 2;
            long sum = 0;
            for (int num : arr) {
                if (num - mid > 0) {
                    sum += num - mid;
                }
            }

            if (sum < M) { // 합이 M보다 작으면 자르는 높이를 낮춰서 더 많이 가져가도록
                r = mid - 1;
            } else { // 합이 M보다 크거나 같으면 자르는 높이를 높혀서 더 조금 가져가도록
                l = mid + 1;
                result = mid; // 현재 자른 위치
            }
        }

        System.out.println(result);

    }
}

