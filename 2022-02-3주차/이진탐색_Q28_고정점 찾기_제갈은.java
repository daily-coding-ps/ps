package Week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NDB_고정점찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num[] = new int[n];
		
		for(int i=0;i<n;i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		
		int index = binarySearch(num,0,n);
		System.out.println(index);
	}
	
	static int binarySearch(int[]num, int low, int high) {
		int ans=-1;
		int mid=0;
		
		while(low <= high) {
			mid = (low+high)/2;
			
			if(num[mid]==mid) return mid;
			else if(num[mid]>mid) high=mid-1;
			else if(num[mid]<mid) low=mid+1;
		}
		
		return ans;
	}

}
