package Week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17485 {
	
	static int n;
	static int m;
	static int map[][];
	static int dp[][][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		dp = new int[3][n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<m;i++) {
			dp[0][0][i]=map[0][i];
			dp[1][0][i]=map[0][i];
			dp[2][0][i]=map[0][i];
			// 맨처음 채워주기
		}
		
		for(int i=0;i<n;i++) {
			dp[0][i][0]=Integer.MAX_VALUE;
			dp[2][i][m-1]=Integer.MAX_VALUE;
			// 맨왼쪽, 맨 오른쪽 채우기
		}
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(possible(j-1) && possible(j+1)) {
					// 왼, 아래, 오가 가능할 경우
					dp[0][i][j]=Math.min(dp[1][i-1][j-1], dp[2][i-1][j-1])+map[i][j];
					dp[1][i][j]=Math.min(dp[2][i-1][j], dp[0][i-1][j])+map[i][j];
					dp[2][i][j]=Math.min(dp[0][i-1][j+1], dp[1][i-1][j+1])+map[i][j];
				}else if(!possible(j-1) && possible(j+1)) {
					// 오른쪽 끝에 있는 경우
					dp[1][i][j]=Math.min(dp[2][i-1][j], dp[0][i-1][j])+map[i][j];
					dp[2][i][j]=Math.min(dp[0][i-1][j+1], dp[1][i-1][j+1])+map[i][j];
				}else if(possible(j-1) && !possible(j+1)) {
					// 왼쪽 끝에 있는 경우
					dp[0][i][j]=Math.min(dp[1][i-1][j-1], dp[2][i-1][j-1])+map[i][j];
					dp[1][i][j]=Math.min(dp[2][i-1][j], dp[0][i-1][j])+map[i][j];
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<m;j++) {
				if(min > dp[i][n-1][j]) {
					min = dp[i][n-1][j];
				}
			}
		}
		
		System.out.println(min);

	}
	
	
	static boolean possible(int y) {
		if(y >= 0 && y<m) return true;
		return false;
	}
}
