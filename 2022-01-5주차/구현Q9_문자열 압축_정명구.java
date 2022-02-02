package 이코테.Simulation;

public class simulQ3 {

    public static void main(String[] args) {


        Solution sol = new Solution();
        System.out.println(sol.solution("abcabcabcabcdededededede"));


    }
}

class Solution {
    public int solution(String s) {
        int answer = s.length();
        int n = s.length();

        //압축하는 방법 1부터 ~ 반까지  i = 압축할 수
        for (int i = 1; i <= n / 2; i++) {
            int pos = 0; //가르키는 위치
            int len = n;

            while (pos + i <= s.length()) {
                String temp = s.substring(pos, pos + i);
                pos += i;

                int cnt =0; //압축되는 문자의 수

                //압축되는 문자가 있는지 확인
                while (pos + i <= s.length()) {
                    if (temp.equals(s.substring(pos, pos + i))) {
                        cnt++; //압축됨
                        pos += i;
                    }else{
                        break;
                    }
                }

                //압축된 문자가 있어야 길이를 조정한다.
                if (cnt > 0) {
                    len -= i * cnt; //압축한 길이 * 압축된 수

                    if (cnt < 9) {
                        len += 1;
                    } else if (cnt < 99) {
                        len += 2;
                    } else if (cnt < 999) {
                        len += 3;
                    } else{
                        len += 4;
                    }

                }
            }
            if (len < answer) {
                answer = len;
            }
        }

        return answer;
    }
}
