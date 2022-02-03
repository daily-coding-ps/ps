package Week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NDB_럭키스트레이트 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String n = br.readLine();
		int sum=0;
		int sum2=0;
		
		for (int i=0;i<n.length()/2;i++) {
			int num = n.charAt(i)-'0';
			sum+=num;
		}
		
		for(int i=n.length()/2;i<n.length();i++) {
			int num = n.charAt(i)-'0';
			sum2+=num;
		}
		
		if(sum==sum2) {
			System.out.println("LUCKY");
		}else {
			System.out.println("READY");
		}
			
		
	}

}
