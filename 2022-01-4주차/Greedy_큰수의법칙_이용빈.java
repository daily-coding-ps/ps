package 이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GreedyBQ2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(data);

        int first = data[N - 1]; // 첫번째로 큰 수
        int second = data[N - 2]; // 두번째로 큰 수

        int result = 0;
        /*
            N(전체)         : 5
            M(총 더하는 횟수) : 8
            K(연속 n회까지)   : 3

            8 / (3 + 1) * 3 = 6
            first + first + first + second + first + first + first + second >> first가 총 6번
            8 % (3 + 1) == 0 // 만약 나머지가 있을경우 second 다음이니까 first만 더하면 됨

            result += count(first의 개수) * first
            result += (8 - count) * second // second의 개수만큼 곱한 값을 넣어줌

         */
        int count = M / (K + 1) * K;
        count += M % (K + 1);

        result += count * first;
        result += (M - count) * second;

        System.out.println(result);
    }

}
