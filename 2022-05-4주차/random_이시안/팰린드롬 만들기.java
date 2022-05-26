import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] arr = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();

        for (char c : str) {
            arr[c - 65] += 1;
        }

        if (!isAvailable(str.length)) {
            return;
        }

        solution(str);
    }

    public static void solution(char[] str) {
        int center = Integer.MIN_VALUE;
        int start = 0;
        int end = str.length - 1;
        char[] result = new char[str.length];

        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] % 2) != 0) {
                center = i;
                arr[i] -= 1;
            }
            if ((arr[i] % 2) == 0) {
                for (int j = 0; j < arr[i]; j += 2) {
                    result[start] = (char) (i + 65);
                    result[end] = (char) (i + 65);
                    start += 1;
                    end -= 1;
                }
            }
        }

        if (center >= 0) {
            result[result.length / 2] = (char) (center + 65);
        }

        System.out.println(String.valueOf(result));
    }

    public static boolean isAvailable(int length) {
        long count = Arrays.stream(arr)
                .filter(value -> value % 2 != 0)
                .count();

        if ((length % 2 == 0 && count >= 1) || count > 1) {
            System.out.println("I'm Sorry Hansoo");
            return false;
        }

        return true;
    }
}
