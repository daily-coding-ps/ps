package 이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GreedyQ4_만들수없는금액_이용빈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] coin = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(st.nextToken());
        }

        // 만들 수 있는 낮은 금액부터 확인 할 것이기 때문에 오름차순 정렬
        Arrays.sort(coin);

        int target = 1;
        for (int i = 0; i < N; i++) {
            if (target < coin[i]) {
                System.out.println(target);
                return;
            }
            target += coin[i];
        }

    }

}
