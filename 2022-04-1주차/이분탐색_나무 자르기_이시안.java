package bjo._2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] list = new int[N];
        st = new StringTokenizer(br.readLine());
        int min = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            if (list[i] > max) {
                max = list[i];
            }
        }

        while (min < max) {
            int mid = (min + max) / 2; // 자르는 위치
            long sum = 0;
            for (int height : list) {
                if (height - mid > 0) { // 자르는 위치보다 작은 나무는 잘리지 않음
                    sum += height - mid;
                }
            }
            /*
             * 자른 값이 M보다 낮으면 max를 낮춤
             * 자른 값이 M보다 크면 min을 올림*/
            if (sum < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1); // min이 max 값과 같아졌으므로 -1
    }
}
