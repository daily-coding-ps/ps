import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int result = 1;

        while (B != A) {
            String str = String.valueOf(B);
            if (!((str.charAt(str.length() - 1) != '1' && B % 2 != 0) || A > B)) {
                if (B % 2 == 0) {
                    B /= 2;
                } else {
                    B = Long.parseLong(str.substring(0, str.length() - 1));
                }
                result += 1;
            } else {
                result = -1;
                break;
            }
        }
        System.out.println(result);
    }
}
