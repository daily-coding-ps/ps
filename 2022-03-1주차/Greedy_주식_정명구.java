//주식
package 이코테.Greedy;

import java.io.*;
import java.util.*;

public class PS0304_11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            int[] money = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                money[i] = Integer.parseInt(st.nextToken());
            }

            int max = -1;
            long sum = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (max < money[i]) {
                    max = money[i];
                }else{
                    sum += max - money[i];
                }
            }
            sb.append(sum + "\n");
        }

        System.out.println(sb);
    }
}
