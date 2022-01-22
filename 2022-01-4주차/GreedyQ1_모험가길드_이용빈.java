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
        Integer[] list = new Integer[N]; // 각 모험가의 공포도 값 ( 보통 int[]을 쓰지만 역순 정렬을 위해 Integer[] 사용 )

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken()); // 공포도의 값을 입력받음
        }

        Arrays.sort(list, Collections.reverseOrder()); // 역순 정렬

        int party = 0; // 파티 개수
        int i = 0;
        while (i < N) {
            // 현재 파티에 참가한 인원 + 다음 사람의 공포도 > 전체 인원 인지 확인
            // ex) 총 파티원이 4명이고 현재 참가자가 3명인데 남은 1명의 공포도가 2 이상인 경우 // (3 3 2) / (2 ?)
            if (i + list[i] > N) {
                break; // 파티를 만들지 않고 반복 종료
            }
            i += list[i]; // 파티인원을 공포도가 제일 큰 사람 만큼 생성
            party++; // 파티 개수 증가
        }

        System.out.println(party);

    }

}
