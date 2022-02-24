//병사 배치하기 18353
package 이코테.DP;

import java.io.*;
import java.util.*;

public class Q34 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int d[]= new int[n];
        int a[]= new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            d[i] = 1;
        }

        //LIS (최장 길이 부분수열) 이용
        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(a[j] > a[i]){
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }
        }

        int ans=0;
        for(int i=0; i<n; i++) {
            if(ans < d[i]) ans = d[i];
        }

        System.out.println(n - ans); //전체에서 구성된 병사들 빼면 답이 나옴

    }
}
