import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {

        Arrays.sort(times);
        long left = 1;
        long right = n * (long) times[times.length - 1];

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int i = 0; i < times.length; i++) {
                sum += (mid / times[i]);
            }

            if(sum < n){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return left;
    }
}
