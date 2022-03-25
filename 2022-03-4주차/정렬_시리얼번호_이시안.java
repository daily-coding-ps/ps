import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        list.sort((a, b) -> {
            // 1. 길이가 짧은 것
            if (a.length() < b.length()) {
                return -1;
            }
            // 2. 길이가 같을 때
            if (a.length() == b.length()) {
                if (add(a) == add(b)) {
                    return a.compareTo(b); // 사전순으로 비교
                } else {
                    return Integer.compare(add(a), add(b)); // 자릿수의 합으로 비교
                }
            }
            return 1; // a가 b보다 길이가 긴 경우
        });

        list.forEach(System.out::println);
    }

    // 문자열의 자릿수 합을 구하는 메서드
    static int add(String str) {
        int sum = 0;
        String s = str.replaceAll("[^\\d]", "");
        for (char c : s.toCharArray()) {
            sum += c - '0';
        }
        return sum;
    }
}
