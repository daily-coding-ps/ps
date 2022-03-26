
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 시리얼번호 {

    static int N;
    static String[] serials;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        serials = new String[N];

        for (int i = 0; i < N; i++) {
            serials[i] = br.readLine();
        }

        Arrays.sort(serials, (o1, o2) -> {
            if (o1.length() < o2.length()) { // 길이 기준 정렬
                return -1;
            } else if (o1.length() > o2.length()) {
                return 1;
            } else {
                if (sum(o1) == sum(o2)) { // 합이 같은 경우
                    return o1.compareTo(o2); // 사전 순 정렬
                } else { // 합이 다른 경우
                    return Integer.compare(sum(o1), sum(o2)); // 합을 기준으로 오름차순 정렬
                }
            }
        });

        for (String serial : serials) {
            System.out.println(serial);
        }
    }

    private static int sum(String str) {
        int sum = 0;
        str = str.replaceAll("[^\\d]", "");
        for (char c : str.toCharArray()) {
            sum += c - '0';
        }
        return sum;
    }

}

