package 이코테.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class simulQ2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        char[] arr = (br.readLine()).toCharArray();
        Arrays.sort(arr);

        int temp = 0;
        for (char c : arr) {
            if (Character.isDigit(c)) {
                temp += c - '0';
            }else{
                answer.append(c);
           }
        }

        answer.append(temp);

        System.out.println(answer);
    }
}
