package Week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1303 {
	
	static int n;
	static int m;
	static char[][] map;
//	static int dx[]= {1,-1,0,0};	// 하상우좌
//	static int dy[]= {0,0,1,-1};
	static int[] dx = {-1, 0, 1, 0}; //상우하좌
    static int[] dy = {0, 1, 0, -1};
	static boolean visited[][];
	static int w_count=0;
	static int b_count=0;
	static int w_sum=0;
	static int b_sum=0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[m][n];
		visited = new boolean[m][n];
		
		for(int i=0;i<m;i++) {
			String s = br.readLine();
			for(int j=0;j<n;j++) {
				map[i][j]=s.charAt(j);
			}
		}
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(!visited[i][j] && map[i][j]=='W') {
					w_count=bfs(i,j);
					w_sum+=Math.pow(w_count, 2);
				}else if(!visited[i][j] && map[i][j]=='B') {
					b_count=bfs(i,j);
					b_sum+=Math.pow(b_count, 2);
				}
			}
		}
		System.out.println(w_sum+" "+b_sum);
	}
	
	public static int bfs(int x, int y) {
		
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x,y));
		visited[x][y]=true;
		int count=1;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i=0;i<4;i++) {
				int new_x = node.x+dx[i];
				int new_y = node.y+dy[i];
				
				if(new_x >= 0 && new_y >= 0 && new_x<m && new_y<n) {
					if(!visited[new_x][new_y] && map[new_x][new_y] == map[node.x][node.y]) {
						count++;
						q.offer(new Node(new_x, new_y));
						visited[new_x][new_y]=true;
					}
					
				}
			}
		}
		return count;
	}
	
	public static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}

}
