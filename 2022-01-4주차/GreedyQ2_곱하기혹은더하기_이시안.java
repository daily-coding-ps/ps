import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class MultiplyOrPlus {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 입력받은 정수를 배열로 변환
        // 이때 앞자리가 0이라면 정수로 변환되면서 제거된다.
        int[] arr = Stream.of(String.valueOf(N).split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        int result = arr[0]; // 배열의 맨 첫번째 값으로 초기화

        // 1번 인덱스부터
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= 1) { // 값이 0이나 1이라면 더하는 것이 이득
                result += arr[i];
            } else {
                result *= arr[i]; // 아니면 무조건 곱하는 것이 이득
            }
        }

        System.out.println(result);
    }
}
