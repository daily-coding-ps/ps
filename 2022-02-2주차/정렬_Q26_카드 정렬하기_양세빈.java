package baekjoon_silver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 카드정렬하기 {
	public static void main(String[] args) throws IOException{
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			pq.add(Integer.parseInt(br.readLine()));	
		}
		int sum_min = 0;
		while (pq.size()!=1) {
			int h1 = pq.poll();
			int h2 = pq.poll();
			sum_min += h1 + h2;
			pq.add(h1 + h2);
		}
		if(n==1) {
			System.out.println(0);
		}
		else if (n==2) {
			System.out.println(1);
		}
		else {
			System.out.println(sum_min);
		}
	}

}
