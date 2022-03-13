import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스위치_켜고_끄기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int K = Integer.parseInt(br.readLine());
        Queue<Student> queue = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            queue.offer(new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        while (!queue.isEmpty()) {
            Student student = queue.poll();
            int idx = student.getButton();
            if (student.getGender() == 1) {
                for (int i = idx; i < arr.length; i += idx) {
                    arr[i] = (arr[i] == 1) ? 0 : 1;
                }
            } else {
                arr[idx] = (arr[idx] == 1) ? 0 : 1;
                int stack = 1;
                while (idx - stack >= 1 && idx + stack <= N) {
                    if (arr[idx - stack] == arr[idx + stack]) {
                        arr[idx - stack] = (arr[idx - stack] == 1) ? 0 : 1;
                        arr[idx + stack] = (arr[idx + stack] == 1) ? 0 : 1;
                        stack++;
                    } else {
                        break;
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(arr[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }

    }

    static class Student {

        int gender;
        int button;

        public Student(int gender, int button) {
            this.gender = gender;
            this.button = button;
        }

        public int getGender() {
            return gender;
        }

        public int getButton() {
            return button;
        }
    }

}
