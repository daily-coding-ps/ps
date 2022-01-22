package 이코테;

import java.util.*;
import java.io.*;

public class GreedyQ1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] a = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        int index = 0; //그룹의 위치
        int ans = 0; //결성할 수 있는 그룹의 수
        while (index < a.length) {
            index += a[index]; // 모험가의 공포도 만큼 위치를 누적하여 이동하여
            if(index <= a.length){ //해당 위치가 배열의 길이와 같거나 작아야
                ans++; // 그룹을 형성할 수 있다.
            }
        }

        System.out.println(ans);
    }
}
