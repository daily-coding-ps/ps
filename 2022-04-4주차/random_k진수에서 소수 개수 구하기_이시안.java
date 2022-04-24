public class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String kDigit = convertDigit(n, k);
        long P = 0;

        for (int i = 0; i < kDigit.length(); i++) {
            // 0을 만나면 P가 소수인지 확인
            if (kDigit.charAt(i) == '0') {
                // 소수면 0으로 초기화하고 answer++
                if (P != 0 && isPrime(P)) {
                    answer++;
                }
                P = 0;

                // 소수가 아닌 경우 P에 현재 값을 추가
            } else {
                P = P * 10 + kDigit.charAt(i) - '0';
            }
        }

        // 0P가 존재할 수 있으므로 확인
        if (P % 10 != 0 && isPrime(P)) {
            answer++;
        }

        return answer;
    }

    // 소수 검증 메서드
    public static boolean isPrime(long num) {
        // 1이거나 2로 나누어 떨어지면 소수가 아님
        if (num == 1 || num % 2 == 0) {
            return false;
        }

        // 제곱으로 소수 검증하기
        long sqrt = (long) Math.sqrt(num);
        for (long i = 3; i < sqrt; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // k진수로 변환하는 메서드
    public static String convertDigit(int num, int digit) {
        StringBuilder sb = new StringBuilder();

        // num을 digit로 나눈 나머지를 문자열 가장 뒷자리에 추가
        while (num >= digit) {
            sb.insert(0, num % digit);
            num /= digit;
        }
        // 남은 num을 추가
        sb.insert(0, num);
        return sb.toString();
    }
}
