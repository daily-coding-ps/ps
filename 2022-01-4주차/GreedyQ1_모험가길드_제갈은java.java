package Week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class NDB_모험가길드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Integer []x=new Integer[n];
		
		for(int i=0;i<n;i++) {
			x[i]=Integer.parseInt(st.nextToken());
		}
		
		// 내림차순 정렬
		Arrays.sort(x, Collections.reverseOrder());

		int count=x[0]; // 배열에서 가장 큰 수 저장
		int result=0;
		
	
		for(int i=0;i<n;++i) {
			if(count>i) {
				// count만큼 i카운트 돌고
				continue;
			}else {
				//i가 count보다 크면 
				result++; 	// 그룹 하나 생성
				count=x[i];	// count를 다음 원소로 초기화
			}
		}
		
		System.out.println(result);
	}

}
