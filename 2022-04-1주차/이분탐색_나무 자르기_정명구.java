//나무자르기
package 스터디.PS4월1주차;

import java.io.*;
import java.util.*;

public class PS0404_2805 {

    static int[] tree;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tree = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree);

        int left = 0;
        int right = 1000000000;

        while (left <= right) {
            int mid = (left + right) / 2;

            if(cutTree(mid) >= m){
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }

        System.out.println(right);
    }

    static long cutTree(int height) {
        long sum = 0;

        for (int i = 0; i < n; i++) {
            if (tree[i] - height > 0) {
                sum += (tree[i] - height);
            }
        }

        return sum;
    }
}
