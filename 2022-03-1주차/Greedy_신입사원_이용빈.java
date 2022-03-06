import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Grade> list = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.add(new Grade(a, b));
            }

            Collections.sort(list); // 서류 기준으로 오름차순 정렬

            int answer = 1; // 서류 1등은 무조건 합격
            int min = list.get(0).getB(); // 서류 1등의 면접 값
            for (int j = 1; j < N; j++) { // 서류 2등부터 시작
                if (list.get(j).getB() < min) { // 이전의 면접 등수보다 낮으면 합격
                    answer++;
                    min = list.get(j).getB(); // 최소 등수 갱신
                }
            }
            System.out.println(answer);
        }
    }

}

class Grade implements Comparable<Grade> {

    int a;
    int b;

    Grade(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    @Override
    public int compareTo(Grade o) {
        if (this.a > o.a) {
            return 1;
        } else {
            return -1;
        }
    }
}