import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[] arr = new long[100];

        for (int i = 0; i < arr.length; i++) {
            if (i < 3) {
                arr[i] = 1;
                continue;
            }
            arr[i] = arr[i - 2] + arr[i - 3];
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(arr[N - 1]);
        }
    }
}