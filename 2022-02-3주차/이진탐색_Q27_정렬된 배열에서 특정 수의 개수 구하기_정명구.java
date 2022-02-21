//정렬된 배열에서 특정 수의 개수 구하기
package 이코테.BinarySearch;

import java.util.*;
import java.io.*;

public class Q27 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] num = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num); //정렬

        int ans = searchHigh(num, x) - searchLow(num, x);

        System.out.println( ans == 0 ? -1 : ans);

    }

    private static int searchHigh(int[] num, int target) {
        int low = 0;
        int high = num.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if(target < num[mid]){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return high;
    }

    private static int searchLow(int[] num, int target) {
        int low = 0;
        int high = num.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if(target <= num[mid]){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return high;
    }
}
