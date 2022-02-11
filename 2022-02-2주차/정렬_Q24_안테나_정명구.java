//안테나
package 이코테.Sort;

import java.util.*;
import java.io.*;

public class Q24 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] house = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(house);

        System.out.println(house[(n-1)/2]);

    }
}
