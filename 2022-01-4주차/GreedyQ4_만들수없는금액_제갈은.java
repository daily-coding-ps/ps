package Week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NDB_만들수없는금액 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int coin[]=new int[n];
		
		for(int i=0;i<n;i++) {
			coin[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(coin);
		
		int target=1;
		
		for(int i=0;i<n;i++) {
			if(target < coin[i]) {
				break;
			}
			target+=coin[i];
		}
		
		System.out.println(target);
	}
}
