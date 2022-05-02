import java.util.*;
class Solution {
    
    static boolean visited[];
    static ArrayList<String> candiKey = new ArrayList<>();
    
    public int solution(String[][] relation) {
        int answer = 0;
        int size = relation[0].length;
        
        visited = new boolean[size];
        
        for(int i=0;i<size;i++) {
        	dfs(i+1,0,relation);
        }
        
        answer = candiKey.size();
        return answer;
    }
    
    public static void dfs(int len, int depth, String[][] relation) {
    	
    	if(len==depth) {
    		// 조합 만들었을 때
    		String key = "";
    		ArrayList<Integer> list = new ArrayList<>();
    		for(int i=0;i<visited.length;i++) {
    			if(visited[i]) {
    				key+=String.valueOf(i);
    				list.add(i);
    				// 0, 1, 2, 3, 01, 02, 03, ...
    			}
    		}
    		
    		HashMap<String, Integer> map = new HashMap<>();
    		
    		// 유일성 체크
    		for(int i=0;i<relation.length;i++) {
    			String s="";
    			for(Integer j : list) {
    				s+=relation[i][j];
    			}
    			if(map.containsKey(s)) {
    				return;
    			}else {
    				map.put(s,0);
    			}
    		}
    		
    		// 최소성 체크
    		for(String check : candiKey) {
    			int count = 0;
    			for(int i=0;i<key.length();i++) {
    				String temp = String.valueOf(key.charAt(i));
    				if(check.contains(temp)) {
    					count++;
    				}
    			}
    			if(count==check.length()) return;
    		}
    		candiKey.add(key);
    	}
    	
    	else {

        	// dfs
        	for(int i=0;i<visited.length;i++) {
            	if(!visited[i]) {
            		visited[i]=true;
            		dfs(len,depth+1,relation);
            		visited[i]=false;
            	}
        	}
    	}
    	
    }
    
}
