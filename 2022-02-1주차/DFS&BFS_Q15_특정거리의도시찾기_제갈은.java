package Week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NDB_특정거리의도시찾기 {
	
	static int map[];
	static boolean visited[];
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		map = new int[300001];
		visited = new boolean[300001];
		
		for(int i=0;i<=n;i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }
	
		map[x]=0;
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		visited[x]=true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i=0;i<graph.get(now).size();i++) {
				int next = graph.get(now).get(i);
				
				if(!visited[next]) {
					map[next]=map[now]+1;
					q.offer(next);
					visited[next]=true;
				}
			}
		}
		
		boolean isTrue=false;
		
		for(int i=1;i<=n;i++) {
			if(map[i]==k) {
				System.out.println(i);
				isTrue=true;
			}
		}
		
		if(!isTrue) {
			System.out.println("-1");
		}
	}

}
