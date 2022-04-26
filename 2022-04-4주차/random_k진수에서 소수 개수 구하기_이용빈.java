public class k진수에서 소수 개수 구하기 {

    public static void main(String[] args) {
        System.out.println(solution(437674, 3));
    }

    public static boolean isPrime(long N) { // 에라토스테네스의 체
        if (N <= 1) {
            return false;
        } else if (N == 2) {
            return true;
        }

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String toKnum(int n, int k) {
        String res = "";
        while (n > 0) {
            res = n % k + res;
            n /= k;
        }
        return res;
    }

    public static int solution(int n, int k) {
        int answer = 0;
        String num = toKnum(n, k); // n을 k진수로 변환
        long P = 0L;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '0') { // 0을 만나면 P가 소수인지 확인
                if (isPrime(P)) {
                    answer++;
                }
                P = 0L;
            } else { // 0이 아니면 P에 값을 더함
                P = P * 10 + num.charAt(i) - '0';
            }
        }

        if (P % 10 != 0L && isPrime(P)) { // for문이 다 끝나도 0P가 존재할수 있으니 확인
            answer++;
        }
        return answer;
    }

}
