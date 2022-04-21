package Week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14719 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int []arr = new int[w];
		
		int result=0;
		
		for(int i=0;i<w;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		// 맨처음과 맨마지막 기둥 제외
		for(int i=1;i<w-1;i++) {
			int left = 0;
			int right = 0;
			for(int j=0;j<i;j++) {
				// 현재 인덱스 기준 왼쪽에서 가장 큰 기둥
				left = Math.max(left, arr[j]);
			}
			for(int j=i+1;j<w;j++) {
				// 현재 인덱스 기준 오른쪽에서 가장 큰 기둥
				right = Math.max(right, arr[j]);
			}
			
			if(arr[i] < left && arr[i] < right) {
				result += Math.min(left, right) - arr[i];
			}
		}
		
		System.out.println(result);

	}

}
