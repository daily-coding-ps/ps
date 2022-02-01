import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StringSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char temp; // 숫자인지 문자인지 판별하기 위한 변수
        int N = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            temp = str.charAt(i); // 문자 변수에 대입

            // 문자 변수가 정수가 아니라면 StringBuilder에 추가
            if (!Character.isDigit(temp)) {
                sb.append(str.charAt(i));

            } else {
                // 정수라면 더하기
                N += Integer.parseInt(String.valueOf(str.charAt(i)));
            }
        }

        // 문자열 정렬
        char[] chars = sb.toString().toCharArray();
        Arrays.sort(chars);

        // 정렬한 문자 배열에 정수값 추가
        String result = new String(chars) + N;
        System.out.println(result);
    }
}
