import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 흩날리는 시험지 속에서 내 평점이 느껴진거야 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 시험지의 개수
        int K = Integer.parseInt(st.nextToken()); // 시험지를 나눌 그룹의 수

        int[] arr = new int[N];
        int low = 0;
        int high = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            high += arr[i];
        }

        while (low <= high) { // low 값이 high보다 커질때 까지 loop
            int mid = (low + high) / 2; // 중단값
            int cnt = 0;
            int sum = 0;

            for (int i = 0; i < N; i++) {
                sum += arr[i]; // 각 시험지의 점수를 더함

                if (sum >= mid) { // 중단값보다 합이 같거나 커지면 그룹을 나눔
                    cnt++; // 그룹 개수 증가
                    sum = 0;
                }
            }

            if (cnt >= K) { // 그룹의 개수가 K보다 크거나 같으면 기준점수를 높여서 그룹을 적게 생성하는 쪽으로
                low = mid + 1;
            } else { // 그룹의 개수가 K보다 작으면 기준 점수를 낮춰서 그룹을 더 많이 만드는 쪽으로
                high = mid - 1;
            }
        }

        System.out.println(high); // 최대 점수 출력
    }

}
