package Week11;

import java.util.Stack;

public class Pro_괄호변환 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution s = new Solution();
		String ss = "()))((()";
		System.out.println(s.solution(ss));

	}

}

class Solution {

	StringBuilder sb = new StringBuilder();
	String answer;
	
    public String solution(String p) {
    	if(isCorrect(p)) return p;
    	answer=uv(p);
    	
    	return answer;
    }
    
    String uv(String s) {
    	int count=0;
    	
    	StringBuilder u  = new StringBuilder();
    	StringBuilder v = new StringBuilder();
    	
    	if(s.length()==0) return "";
    	
    	for(int i=0;i<s.length();i++) {
    		char c = s.charAt(i);
    		
    		if(c=='(') count++;
    		else count--;
    		
    		if(count==0) {
    			// 균형잡힌 괄호 문자열이면
    			u.append(s.substring(0,i+1));
    			v.append(s.substring(i+1, s.length()));
    			
    			//u,v 나누기
    			break;	
    		}
    	}
    	
    	if(isCorrect(u.toString())) {
    		// U가 올바른 괄호 문자열이라면
    		u.append(uv(v.toString()));
    		
    	}else {
    		// u가 올바르지 않은 괄호 문자열이라면
    		sb.append("(").append(uv(v.toString()));
    		sb.append(")");
    		String temp = u.substring(1,u.length()-1);
    		StringBuffer sbffer = new StringBuffer(temp);
    		String reverse = sbffer.reverse().toString();
    		sb.append(reverse);
    		return sb.toString();
    	}
		return u.toString();
    }
    
  //올바른 괄호 문자열 판단하는 메소드
    boolean isCorrect(String s) {
    	
    	Stack<Character> stack = new Stack<>();
    	
    	for(int i=0;i<s.length();i++) {
    		char c = s.charAt(i);
    		
    		if(c=='(') {
    			stack.push('(');
    		}else if(c==')') {
    			if(!stack.isEmpty()) stack.pop();
    		}
    	}
    	
    	if(!stack.isEmpty()) {
    		return false;
    	}else {
    		return true;
    	}

    }
    
}

