package 이코테.BinarySearch;

import java.util.*;
import java.io.*;

public class Q29 {

    static int[] house;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        house = new int[n];

        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int low = 1;
        int high = house[n - 1] - house[0] + 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (wifi(mid) < c) {
                high = mid;
            }else{
                low = mid + 1;
            }
        }

        System.out.println(high - 1);

    }

    private static int wifi(int dist) {
        int count = 1;
        int prevLocate = house[0]; //직전 위치

        for (int i = 1; i < house.length; i++) {
            int nowLocate = house[i];

            if (nowLocate - prevLocate >= dist) {
                count++;
                prevLocate = nowLocate;
            }
        }

        return count;
    }
}
