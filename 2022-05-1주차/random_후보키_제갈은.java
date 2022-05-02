import java.util.*;
class Solution {
    
    static boolean visited[];
    static ArrayList<String> candiKey = new ArrayList<>();
    
    public int solution(String[][] relation) {
        int answer = 0;
        int size = relation[0].length;
        
        for(int i=0;i<size;i++){
            visited = new boolean[size];
            dfs(0,i+1, relation);
        }
        answer=candiKey.size();
        
        return answer;
    }
    
    public static void dfs(int depth, int len, String[][] relation) {
    	if(depth == len) {
    		ArrayList<Integer> list = new ArrayList<>();
    		String key="";
    		for(int i=0;i<visited.length;i++) {
    			// 조합 만들기
    			if(visited[i]) {
    				key+=String.valueOf(i);
    				list.add(i);
    				// 0, 1, 2, 3, 01, 02, 03, 12, 13, 23 , 012, 013 ...
    			}
    		}
    		
    		Map<String, Integer> map = new HashMap<>();
    		
    		for(int i=0;i<relation.length;i++) {
    			String s= "";
    			for(int j=0;j<list.size();j++) {
    				int index = list.get(j);
    				s+=relation[i][index];
    			}
    			
    			if(map.containsKey(s)) {
    				//값이 유일하지 않을 경우
    				//유일성 만족 x
    				return;
    			}else {
    				// 후보키 설정
    				// key, value
    				map.put(s,0);	
    			}
    		}
    		
    		for(String s : candiKey) {
    			int count=0;
    			for(int i=0;i<key.length();i++) {
    				String temp = String.valueOf(key.charAt(i));
    				if(s.contains(temp)) count++;
    			}
    			if(count==s.length()) return;
    			// 후보키가 이미 있으면 return;
    		}
    		candiKey.add(key);
    		return;
    	}
    	
    	for(int i=0;i<visited.length;i++) {
    		if(!visited[i]) {
    			visited[i]=true;
    			dfs(depth+1, len, relation);
    			visited[i]=false;
    		}
    	}
    }
    
}
