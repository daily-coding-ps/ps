import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long answer = 1;

        // A를 B로 바꿔야함 -> B를 A로 바꾸는 식으로 접근
        while (B != A) {

            String str = String.valueOf(B);

            // A가 B보다 커져버리거나 2로 나눠지지않고, 맨 뒷자리가 1이 아닌 경우 -> 더 이상 연산이 불가능 = A를 B로 바꿀 수 없음
            if (B < A || (B % 2 != 0 && str.charAt(str.length() - 1) != '1')) {
                answer = -1;
                break;
            }

            // B가 2로 나눠진다면 B를 2로 나누고
            if (B % 2 == 0) {
                B /= 2;
            } else { // 맨 뒷자리가 1이라면 1을 제거한다
                B = Long.parseLong(str.substring(0, str.length() - 1));
            }

            // 횟수 증가
            answer++;

        }

        System.out.println(answer);
    }

}

