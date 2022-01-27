import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CantMakeMoney {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(String.valueOf(br.readLine()).split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        int result = 1; // 최소값인 1로 설정

        for (int i : arr) {
            // 최소값보다 i가 작은 경우 만들 수 없는 최소값이므로 종료
            if (result < i) {
                break;
            }
            result += i; // 최소값 업데이트
        }

        System.out.println(result);
    }
}
