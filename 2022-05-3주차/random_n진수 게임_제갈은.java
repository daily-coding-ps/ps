import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        
        StringBuilder convert = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        for(int i=0; convert.length() <= t*m; i++){
            convert.append(Integer.toString(i,n));
            // 0부터 n진법으로 변환
        }
        
        // 튜브순서에 해당하는 숫자만 넣기
        for(int i=p-1; answer.length()<t;i+=m){
            answer.append(convert.charAt(i));
        }
        
        
        return answer.toString().toUpperCase();
    }
}
