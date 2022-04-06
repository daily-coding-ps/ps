class Solution {

    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200000000;

        while (left <= right) {
            int mid = (left + right) / 2;

            int count = 0;
            boolean flag = true;
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] < mid) {
                    count++;
                }else{
                    count = 0;
                }

                if (count == k) {
                    flag = false;
                    break;
                }
            }

            if(flag){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return right;
    }
}