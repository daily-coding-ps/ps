import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LuckyStraight {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb1 = new StringBuilder(br.readLine());
        StringBuilder sb2 = new StringBuilder();
        int i = 0;

        // 입력값을 반으로 나누기
        while (sb1.length() != sb2.length()) {
            sb2.append(sb1.charAt(i));
            sb1.deleteCharAt(i);
        }

        int A = 0;
        int B = 0;
        // 각각 문자열의 값을 정수로 변환하여 더하기
        for (int j = 0; j < sb1.length(); j++) {
            A += Integer.parseInt(String.valueOf(sb1.charAt(j)));
            B += Integer.parseInt(String.valueOf(sb2.charAt(j)));
        }
        
        // 결과 반환
        if (A == B) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}
