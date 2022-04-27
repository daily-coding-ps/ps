package Week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2615_real {
	
	static int map[][] = new int[19][19];
	static boolean visited[][] = new boolean[19][19];
	static int[] dx = {1,0,1,-1};
	static int[] dy = {1,1,0,1};
	// 대각선 아래, 가로, 세로, 대각선 위

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<19;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<19;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) {
				if(map[i][j]!='0') {
					for(int index=0;index<4;i++) {
						int cnt = bfs(i,j,index);
						if(cnt==5) {
							System.out.println(map[i][j]);
							System.out.println((i+1)+" "+(j+1));
							return;
						}
					}
				}
			}
		}

		System.out.println("0");
	}
	
	public static int bfs(int x, int y, int index) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x,y));
		visited = new boolean[19][19];
		int cnt=0;
		visited[x][y]= true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			int new_x = node.x+dx[index];
			int new_y = node.y+dy[index];
			if(new_x >= 0 && new_x<19 && new_y>=0 && new_y<19) {
				if(map[new_x][new_y]==map[node.x][node.y]) {
					// 범위 안에 있고 같은 바둑이라면
					q.offer(new Node(new_x, new_y));
					cnt++;
					visited[new_x][new_y]=true;
				}
			}
		}
		if(cnt==5) {
			int new_x = x-dx[index];
			int new_y = y-dy[index];
			if(new_x>=0 && new_y >= 0 && new_x<19 && new_y<19 && map[new_x][new_y]== map[x][y]) {
				cnt++;
			}
		}
		return cnt;
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
