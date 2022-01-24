package 이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class GreedyQ1_LYB {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 모험가의 수
        int[] list = new int[N]; // 각 모험가의 공포도 값

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken()); // 공포도의 값을 입력받음
        }

        Arrays.sort(list); // 최대한 많은 파티를 만들기 위해 오름차순 정렬
        /*
        5 1 1 1 1의 경우 내림차순 정렬해서 파티를 만들면 5를 기준으로 (5 1 1 1 1)이 되지만
        오름차순 정렬으로 1 1 1 1 5 를 하면 (1) (1) (1) (1) 5 와 같이 4파티가 만들어진다
         */

        int party = 0; // 파티 개수
        int member = 0;
        for (int i = 0; i < N; i++) {
            member += 1;
            if (list[i] == member) { // 공포도와 멤버수가 일치하는지 확인, 일치한다면 파티를 만들 최소조건이 되서 만들 수 있음
                party++;
                member = 0;
            }
        }

        System.out.println(party);

    }

}
