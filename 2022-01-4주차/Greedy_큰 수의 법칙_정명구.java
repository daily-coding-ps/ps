package 이코테;

import java.util.*;
import java.io.*;
public class GreedyBasic1 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Integer[] a = new Integer[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a , Collections.reverseOrder());

        int ans = 0;
        int temp = k;
        for(int i=0; i<m; i++){
            if(temp>0){
                ans+=a[0];
                temp--;
            }else{
                ans+=a[1];
                temp = k;
            }
        }

        System.out.println("ans = " + ans);
    }
}
