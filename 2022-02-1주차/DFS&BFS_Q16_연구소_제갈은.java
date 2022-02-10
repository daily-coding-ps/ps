package Week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 {
	
	static int map[][];
	static boolean visited [][];
	static int n;
	static int m;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int zero_max=0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		System.out.println(zero_max);
	}
	
	static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	
	static void dfs(int depth) {
		
		if(depth==3) {
			// 벽 3개 세우면
			bfs();
			return;
			// 바이러스 뿌리기
		}else {
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j]==0) {
						// 0이면
						map[i][j]=1;
						// 벽 세우기
						dfs(depth+1);
						map[i][j]=0;
						// 다시 되돌리기
					}
				}
			}
		}
	}
	
	static void bfs() {
		
		int virus[][] = new int[n][m];
		int zero_cnt=0;
		
		Queue<Node> q = new LinkedList<>();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				virus[i][j]=map[i][j];
				// map 복사하기
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(virus[i][j]==2) {
					//바이러스 라면 큐에 삽입
					q.offer(new Node(i,j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i=0;i<4;i++) {
				int new_x = node.x+dx[i];
				int new_y = node.y+dy[i];
				
				if(new_x >= 0 && new_x < n && new_y >= 0 && new_y < m) {
					if(virus[new_x][new_y]==0) {
						// 범위안에 있고 다음 숫자가 0이면
						virus[new_x][new_y]=2;
						q.add(new Node(new_x, new_y));
						// 바이러스 감염
					}
				}
			}

		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(virus[i][j]==0) {
					zero_cnt++;
				}
			}
		}
		zero_max = Math.max(zero_cnt, zero_max);
		
	}

}
