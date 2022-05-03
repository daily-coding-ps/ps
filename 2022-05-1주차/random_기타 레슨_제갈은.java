package Week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2343 {

	static int arr[];
	static boolean visited[];
	static int n;
	static int m;
	static int left=0;
	static int right=0;
	static int min=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n+1];
		visited = new boolean[n+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			right += arr[i];
			left = Math.max(arr[i], left);
		}
		
		System.out.println(Bineary());
		
	}
	
	static int Bineary() {
		
		while(left<=right) {
			int mid = (left+right)/2;
			
			int count=1;
			int sum=0;
			for(int i=0;i<n;i++) {
				sum+=arr[i];
				
				if(sum>mid) {
					sum=arr[i];
					count++;
				}
			}
			
			if(count>m) {
				// 블루레이 크기를 크게 해야한다.
				left = mid+1;
			}else {
				// 블루레이 크기를 작게 해야한다.
				right = mid-1;
			}
			
		}
		return left;
	}
	
}
