package 이코테.BinarySearch;

import java.io.*;
import java.util.*;

public class Q28 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }


        int start = 0;
        int end = num.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (num[mid] == mid) {
                if (mid == mid) {
                    System.out.println(mid);
                    System.exit(0);
                }
                break;
            } else if (num[mid] > mid) {
                end = mid - 1;
            } else if (num[mid] < mid) {
                start = mid + 1;
            }
        }


        System.out.println(-1);
    }
}
