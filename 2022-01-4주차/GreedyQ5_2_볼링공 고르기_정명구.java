package 이코테.Greedy;

import java.io.*;
import java.util.*;

public class GreedyQ5_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] ballWeight = new int[m+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int weight = Integer.parseInt(st.nextToken());
            ballWeight[weight]++;
        }

        //복잡도 O(m)
        int ans =0;
        for(int i=1; i<=m; i++){ //무게가 1인거부터 m까지 순차적으로 고른다.
            n -= ballWeight[i]; //해당 무게의 개수를 전체개수에서 뺀다.
            ans += ballWeight[i] * n; // 현재 고른 무게의 개수와 남은 고를수 있는 무게를 곱한다.
        }

        System.out.println(ans);
    }
}
