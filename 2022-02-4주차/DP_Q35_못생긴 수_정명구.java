package 이코테.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q35 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n];
        d[0] = 1;

        //2배, 3배, 5배를 위한 인덱스
        int i2 = 0, i3 = 0, i5 = 0;
        int next2 = 2, next3 = 3, next5 = 5;

        for (int i = 1; i < n; i++) {

            //가능한 곱셈 결과 중에서 가장 작은 수를 선택
            d[i] = Math.min(next2, Math.min(next3, next5));

            //인덱스에 따라 곱셈 결과 증가
            if (d[i] == next2) {
                i2 += 1;
                next2 = d[i2] * 2;
            }
            if (d[i] == next3) {
                i3 += 1;
                next3 = d[i3] * 3;
            }
            if (d[i] == next5) {
                i5 += 1;
                next5 = d[i5] * 5;
            }
        }

        System.out.println(d[n-1]);
    }
}
