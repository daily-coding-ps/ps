import java.util.*;
class Solution {
    int[] dx = {1,-1,0,0};
	int[] dy = {0,0,-1,1};
	
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i=0;i<places.length;i++) {
        	answer[i]=isTrue(places[i]);
        }
        return answer;
    }
    
    public int isTrue(String[] map) {
    	for(int i=0;i<map.length;i++) {
    		for(int j=0;j<map[i].length();j++) {
    			if(map[i].charAt(j)=='P') {
    				if(!bfs(map, i,j)) return 0;
    			}
    		}
    	}
    	return 1;
    }
    
    public boolean bfs(String[] map, int x, int y) {
    	Queue<Node> q = new LinkedList<>();
    	boolean[][] visited = new boolean[map.length][map.length];
    	q.offer(new Node(x,y));
    	visited[x][y]=true;
    	
    	while(!q.isEmpty()) {
    		Node node = q.poll();
    		
    		for(int i=0;i<4;i++) {
    			int new_x = node.x+dx[i];
    			int new_y = node.y+dy[i];
    			int manhattan = Math.abs(x-new_x) + Math.abs(y-new_y);
    			
    			if(new_x < 0 || new_y < 0 || new_x >= map.length || new_y >= map.length) continue;
    			if(visited[new_x][new_y] || manhattan > 2) continue;
    			
    			visited[new_x][new_y] = true;
    			if(map[new_x].charAt(new_y)=='X') continue;
    			else if(map[new_x].charAt(new_y)=='P') return false;
    			else q.offer(new Node(new_x, new_y));
    		}
    	}
    	return true;
    }
    
    public class Node {
    	int x;
    	int y;
    	
    	public Node(int x, int y) {
    		this.x=x;
    		this.y=y;
    	}
    }
}
