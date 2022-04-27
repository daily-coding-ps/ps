import java.util.*;

class Solution {
    static StringBuilder sb = new StringBuilder();

    public int solution(int n, int k) {
        int answer = 0;

        String s = "";
        while (n > 0) {
            s = (n % k) + s;
            n /= k;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                sb.append(s.charAt(i));
            }

            if (s.charAt(i) == '0') {
                answer = getAnswer(answer);
                sb.setLength(0);
            }
        }
        answer = getAnswer(answer);


        return answer;
    }

    static int getAnswer(int answer) {
        if (sb.length() != 0) {
            if (prime(Long.parseLong(sb.toString()))) {
                answer++;
            }
        }
        return answer;
    }


    static boolean prime(long n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}