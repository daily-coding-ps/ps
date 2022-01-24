package 이코테;

import java.io.*;

public class GreedyQ2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int ans = s.charAt(0) - '0';  //문자열의 첫번째는 무조건 더하는 방법밖에 없음

        for(int i=1; i<s.length(); i++){ //문자열의 길이만큼 반복
            if(ans != 0 && s.charAt(i) -'0' != 0){  // 현재 수가 0 이거나 계산해야할 수가 0이 아니여야
                ans *= s.charAt(i) - '0'; //곱한다.
            }else{
                ans += s.charAt(i) - '0'; //그렇지 않으면 더한다.
            }
        }
        System.out.println(ans);

    }
}
