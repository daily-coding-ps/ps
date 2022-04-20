package bjo._14719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken()); // 높이
        int W = Integer.parseInt(st.nextToken()); // 너비
        int[] arr = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 1; i < arr.length - 1; i++) { // 맨 왼쪽과 오른쪽은 물이 고이지 않음
            int left = 0;
            int right = 0;

            for (int j = 0; j < i; j++) {
                left = Math.max(left, arr[j]); // 왼쪽에서 제일 높은 블록
            }

            for (int j = i + 1; j < arr.length; j++) {
                right = Math.max(right, arr[j]); // 오른쪽에서 제일 높은 블록
            }

            if (arr[i] < left && arr[i] < right) {
                // 현재 블록이 left, right 보다 작으면 물이 고임
                answer += Math.min(left, right) - arr[i];
            }
        }

        System.out.println(answer);
    }
}
