package 스터디.PS4월2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PS0410_2688 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[][] d = new long[65][10]; //자리수 max 64 , 시작하는수

        for (int i = 0; i <= 9; i++) {
            d[1][i] = 1;
        }

        //테케전 미리 dp테이블 완성하여 중복계산 막기
        for (int k = 2; k <= 64; k++) {
            for (int i = 0; i <= 9; i++) {
                for (int j = i; j <= 9; j++) {
                    d[k][i] += d[k - 1][j];
                }
            }
        }

        int t = Integer.parseInt(br.readLine());


        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long ans = 0;

            for (int i = 0; i <= 9; i++) {
                ans += d[n][i];
            }

            sb.append(ans + "\n");
        }

        System.out.println(sb);
    }
}
