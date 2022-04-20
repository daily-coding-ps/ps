import java.util.*;
class Solution {
     public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0;i<n;i++) {
        	 String s=Integer.toBinaryString(arr1[i] | arr2[i]);
        	 // OR비트연산
        	 s= String.format("%"+n+"s",s);
        	 // 글자길이를 설정하고 %s앞에 숫자가 있을경우 그 자릿수만큼 공백으로 채움
        	 s=s.replaceAll("1", "#");
        	 s=s.replaceAll("0"," ");
        	 
        	 answer[i]=s;
        }
        
        return answer;
    }
}
