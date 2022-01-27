package 이코테;
import java.io.*;

public class GreedyQ3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int ansZero = s.charAt(0) == '0' ? 1 : 0; //첫번째 수가 0일때 뒤집을 수 1증가
        int ansOne = s.charAt(0) == '1' ? 1 : 0; //첫번째 수가 1일때 뒤집을 수 1증가

        for(int i=1; i<s.length(); i++){
            if(s.charAt(i-1) != s.charAt(i)){ //이전 수와 연속이 아닐 때
                if(s.charAt(i) == '0') { // 0을 뒤집는경우
                    ansZero++;
                }
                if(s.charAt(i) == '1'){  // 1을 뒤집는경우
                    ansOne++;
                }
            }
        }
        System.out.println(Math.min(ansZero,ansOne)); //작은 수 출력

    }
}
