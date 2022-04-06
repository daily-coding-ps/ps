package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2805 {

	static int tree[];
	static int end=0;
	static int start=0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		tree = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			tree[i]=Integer.parseInt(st.nextToken());
			end = Math.max(end, tree[i]);
			
		}
		
		while(start <= end) {
			int mid = (start+end)/2;
			long sum=0;
			
			for(int i=0;i<n;i++) {
				if(mid<tree[i]) {
					sum+=tree[i]-mid;
				}
			}
			
			if(sum>=m) {
				start=mid+1;
			}else {
				end=mid-1;
			}
		}
		
		System.out.println(end);
		
	}

}
