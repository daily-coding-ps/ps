package 이코테.DFS_BFS;

import java.io.*;
import java.util.StringTokenizer;

public class Q19 {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static int n;
    static int[] a;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int mul = Integer.parseInt(st.nextToken());
        int div = Integer.parseInt(st.nextToken());

        dfs(1, a[0], plus, minus, mul, div);

        System.out.println(max);
        System.out.println(min);

    }

    private static void dfs(int index, int sum, int plus, int minus, int mul, int div) {
        if (index == n) {

            if (max < sum) {
                max = sum;
            }

            if (min > sum) {
                min = sum;
            }

            return;
        }

        if (plus > 0) {
            dfs(index + 1, sum + a[index], plus - 1, minus, mul, div);
        }

        if (minus > 0) {
            dfs(index + 1, sum - a[index], plus, minus - 1, mul, div);
        }

        if (mul > 0) {
            dfs(index + 1, sum * a[index], plus, minus, mul - 1, div);
        }

        if (div > 0) {
            dfs(index + 1, sum / a[index], plus, minus, mul, div - 1);
        }


    }

}
