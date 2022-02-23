package Week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NDB_정렬된배열에서특정수의개수구하기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int num []=new int[n];
		
		for(int i=0;i<n;i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		
		int cnt = countByRange(num, x, x);
		
		// 값이 존재하지 않다면
		if (cnt == 0) System.out.println(-1);
        //  값이 존재한다면
        else System.out.println(cnt);
	}
	
	static int countByRange(int[] num, int left, int right) {
        int rightIndex = upper(num, right, 0, num.length);
        int leftIndex = lower(num, left, 0, num.length);
        return rightIndex - leftIndex;
    }
	
	static int lower(int []num, int target, int low, int high) {
		while(low<high) {
			int mid = (low+high)/2;
			
			if(num[mid]>=target) high=mid;
			else low = mid+1;
		}
		return high;
	}
	
	static int upper(int []num, int target, int low, int high) {
		while(low < high) {
			int mid = (low+high)/2;
			
			if(num[mid]>target) high=low;
			else low=mid+1;
		}
		return high;
	}

}
