import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        Arrays.sort(rocks);
        int left =1;
        int right = distance;

        while (left <= right) {
            int prev = 0;
            int cnt  = 0;
            int mid = (left + right) / 2;

            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prev < mid) {
                    cnt++;
                }else{
                    prev = rocks[i];
                }
            }

            if (distance - prev < mid) {
                cnt++;
            }

            if (cnt <= n) {
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }

        return answer;
    }
}