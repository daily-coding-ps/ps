package 스터디.PS4월1주차;

import java.io.*;
import java.util.*;

public class PS0404_17951 {

    static int[] score;
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        score = new int[n];

        int left = 0;
        int right = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            right += score[i];
        }

        while (left <= right) {
            int mid = (left + right) / 2;

            if (group(mid) > k) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(right);
    }

    static int group(int mid){
        int count = 1;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += score[i];

            if (sum >= mid) {
                count++;
                sum = 0;
            }
        }

        return count;
    }
}
