//백준 1244 스위치 켜고 끄기
package 스터디;

import java.io.*;
import java.util.*;

public class PS0314_1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n + 1];
        list[0] = -1; //0이 들어가면 안되기 때문에

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int person = Integer.parseInt(st.nextToken());
            int point = Integer.parseInt(st.nextToken());

            if(person == 1){ //남학생
                for (int i = point; i <= n; i += point) {
                    list[i] = (list[i] == 0 ? 1 : 0);
                }
            }else{
                list[point] = (list[point] == 0 ? 1 : 0);
                for (int i = 1; i <= n; i++) {
                    if (point - i > 0 && point + i <= n) {
                        if (list[point - i] == list[point + i]) {
                            list[point - i] = (list[point - i] == 0 ? 1 : 0);
                            list[point + i] = (list[point + i] == 0 ? 1 : 0);
                        }else{
                            break; //대칭이 아님.
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(list[i] + " ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }

        System.out.println(sb);

    }
}
