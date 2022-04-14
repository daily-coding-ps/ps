package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ915 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int max=0;
		
		int[][] map = new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			String s = br.readLine();
			
			for(int j=1;j<=m;j++) {
				int temp = s.charAt(j-1)-'0';
				
				if(temp==1) {
					map[i][j]= Math.min(map[i-1][j-1], Math.min(map[i][j-1], map[i-1][j]))+1;
					// 가장 작은 값  +1
					max = Math.max(map[i][j], max);
				}
			}
		}
		System.out.println(max*max);
	}

}
