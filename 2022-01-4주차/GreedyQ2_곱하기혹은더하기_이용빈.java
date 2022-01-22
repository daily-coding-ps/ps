package 이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GreedyQ2_LYB {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열을 입력받은 후 split을 통해 각 자릿값이 담긴 문자열 배열을 만든 뒤 Stream을 통해 int[]로 바꿔줌
        int[] array = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        int answer = 0; // 최초값은 0
        // 입력값이 1 2 3 4 일때 -> 0 1 2 3 4 라고 가정한뒤 0 + 1 을 하면서 시작
        for (int num : array) {
            answer = (num == 0 || answer == 0) ? answer + num : answer * num; // 두 수 중 0이 있으면 더하고 아닐 경우 곱을 한다
        }
        System.out.println(answer);
    }
}
