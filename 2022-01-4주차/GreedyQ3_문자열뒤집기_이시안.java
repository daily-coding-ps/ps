import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReverseString {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        // 0과 1의 묶음을 카운트할 변수
        int zero = 0;
        int one = 0;

        // 첫 문자부터 카운트
        if (str.charAt(0) == '1') {
            one += 1;
        } else {
            zero += 1;
        }


        for (int i = 0; i < str.length() - 1; i++) {
            // 현재 인덱스와 다음 인덱스가 똑같지 않으면 카운트 추가
            if (str.charAt(i) != str.charAt(i + 1)) {
                if (str.charAt(i + 1) == '1') {
                    one += 1;
                } else {
                    zero += 1;
                }
            }
        }

        // 두 수를 비교해서 더 적은 값 출력
        System.out.println(Math.min(one, zero));
    }
}
