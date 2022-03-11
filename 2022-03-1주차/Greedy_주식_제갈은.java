import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11501 {

	public static void main(String[] args) throws NumberFormatException, IOException {
    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int j = 0; j < t; j++) {
			int cnt = Integer.parseInt(br.readLine());
			long[] s = new long[cnt];
			long max = 0;
			long ans=0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < cnt; i++) {
				s[i]=Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i <= cnt; i++) {
				if(s[cnt-i]>max) {
					max = s[cnt-i];
				}else {
					ans+=(max-s[cnt-i]);
				}
			}
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}
}
