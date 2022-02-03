package Week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NDB_문자열재정렬 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb  = new StringBuilder();
		
		String s = br.readLine();
		ArrayList<Character> alpha = new ArrayList<>();
		int sum=0;
		
		for(int i=0;i<s.length();i++) {
			int a = s.charAt(i);
			
			if(a>= 65 && a<= 90) {
				//대문자면
				alpha.add(s.charAt(i));
			}else {
				// 숫자면
				sum+=s.charAt(i)-'0';
				
			}
		}
		
		Collections.sort(alpha, new Ascending());
		
		for(int i=0;i<alpha.size();i++) {
			sb.append(alpha.get(i));
		}

		sb.append(sum);
		
		System.out.println(sb);
	}

}

class Ascending implements Comparator<Character>{
	public int compare(Character a, Character b)
	{
		return a.compareTo(b);
	}

}