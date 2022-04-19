import java.util.*;
class Solution {
   public String solution(int n, int k, String[] cmd) {
        String answer = "";
        
        Stack<Integer> remove = new Stack<Integer>();
        int index = n;
        
        for(int i=0;i<cmd.length;i++) {
        	char c = cmd[i].charAt(0);
        	if(c=='D') {
        		//X칸 아래 이동
        		k+=Integer.parseInt(cmd[i].substring(2));
        	}else if(c=='U') {
        		//X칸 위로 이동
        		k-=Integer.parseInt(cmd[i].substring(2));
        	}else if(c=='C') {
        		// 삭제
        		remove.add(k);
        		index--;
        		if(k==index) {
        			// 마지막 차례라면
        			k--;
        		}
        	}
        	else if(c=='Z') {
        		//최근에 삭제한 것 복구
        		if(remove.pop()<=k) {
        			//
        			k++;
        		}
        		index++;
        	}
        }
        
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<index;i++) {
        	builder.append("O");
        }
        
        while(!remove.isEmpty()) {
        	builder.insert(remove.pop().intValue(), "X");
        }
        answer = builder.toString();
        return answer;
    }
}
