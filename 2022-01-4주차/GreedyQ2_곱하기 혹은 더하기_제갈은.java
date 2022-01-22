package Week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class NDB_곱하기혹은더하기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();

		int num[] = new int[s.length()];
		
		for(int i=0;i<num.length;i++) {
			num[i]=s.charAt(i)-'0';
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=0;i<num.length;i++) {
			queue.offer(num[i]);
		}
		
		int ans=0;
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			
			if(n<=1) {
				ans+=n;
			}else {
				if(ans==0) {
					ans++;
				}
				ans*=n;
			}
		}
		
		System.out.println(ans);
	}

}
