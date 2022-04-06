public class 징검다리 건너기 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
    }

    public static int solution(int[] stones, int k) {
        int low = 1; // 각 원소는 1 이상
        int high = 200000000; // 2억 이하
        int mid = 0;
        int answer = 0;

        while(low <= high){
            mid = (low + high) / 2;

            if(!cross(stones, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
                answer = max;
            }
        }

        return answer;
    }

    public static boolean cross(int[] stones, int k, int mid) {
        int cnt = 0;

        for (int stone : stones) {
            if (stone - mid < 0) {
                cnt++;
            } else {
                cnt = 0;
            }

            if (cnt == k)
                return false;
        }

        return true;
    }

}
