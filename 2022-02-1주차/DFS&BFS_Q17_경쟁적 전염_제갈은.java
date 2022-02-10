package Week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18405 {
	
	static int map[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int n;
	static int k;
	static int s;
	static int x;
	static int y;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		s = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		boolean isTrue=false;
		
		for(int i=0;i<s;i++) {
			for(int j=0;j<k;j++) {
				bfs(j+1);
				if(map[x-1][y-1]!=0) {
					isTrue=true;
					break;
				}
			}
			if(isTrue) {
				break;
			}
		}
		
		System.out.println(map[x-1][y-1]);
		
	}
	
	static class Node {
		int x;
		int y;
		
		public Node (int x,int y) {
			this.x=x;
			this.y=y;
		}
	}
	
	static void bfs(int num) {
		
		Queue<Node> q = new LinkedList<>();
			
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
					if(map[i][j]==num) {
						q.offer(new Node(i,j));
				}
			}
		}
			
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int z=0;z<4;z++) {
				int new_x = node.x+dx[z];
				int new_y = node.y+dy[z];
				
				if(new_x >= 0 && new_x < n && new_y >=0 && new_y < n) {
					if(map[new_x][new_y]==0) {
						map[new_x][new_y]=num;
					}
				}
			}
		}
	}
}
