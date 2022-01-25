package 이코테.Greedy;

import java.io.*;
import java.util.*;

public class GreedyQ5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] ball = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            ball[i] = Integer.parseInt(st.nextToken());
        }


        //복잡도 O(N^2) 방식
        int ans =0;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(ball[i] != ball[j]){ //현재 선택한 공과 다음 공의 무게 비교
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
