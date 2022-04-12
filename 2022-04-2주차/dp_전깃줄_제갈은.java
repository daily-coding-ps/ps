package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ2565 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int dp[] = new int[n+1];
		int num[][] = new int[n+1][2];
		int max=0;
		
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			num[i][0]=Integer.parseInt(st.nextToken());		//A전봇대
			num[i][1]=Integer.parseInt(st.nextToken());		//B전봇대
			
		}
		
		//  A전봇대 오름차순
		Arrays.sort(num, new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0]-o2[0];
			}
		});
		
		for(int i=1;i<=n;i++) {
			dp[i]=1;
			for(int j=1;j<i;j++) {
				if(num[j][1]<num[i][1]) {
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		// 설치가능한 경우 - 최대로 설치할 수 있는 경우
		System.out.println(n-max);
	
	}

}
