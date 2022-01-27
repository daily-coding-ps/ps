package 이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GreedyQ5_볼링공고르기_이용빈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] array = new int[N + 1];

        int idx = 1;
        while (st.hasMoreTokens()) {
            array[idx++] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] != array[j]) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

}
