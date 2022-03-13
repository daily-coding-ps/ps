import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr = null;
    static int switchAmount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        switchAmount = Integer.parseInt(br.readLine()); // 스위치 개수
        arr = new int[switchAmount + 1]; // 스위치 상태를 나타내는 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= switchAmount; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int students = Integer.parseInt(br.readLine()); // 학생 수
        for (int i = 0; i < students; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            switching(gender, num);
        }

        for (int i = 1; i <= switchAmount; i++) {
            System.out.print(arr[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }

    // 스위치 상태 전환
    static void change(int num) {
        arr[num] = arr[num] == 1 ? 0 : 1;
    }

    // 학생 성별에 따라 스위치를 변환
    static void switching(int gender, int num) {
        if (gender == 1) {
            // i는 학생의 스위치 번호만큼 증가
            for (int i = num; i <= switchAmount; i += num) {
                change(i);
            }
        } else {
            checkSymmetry(num);
        }
    }

    // 여학생 조건
    static void checkSymmetry(int num) {
        int start = num - 1;
        int end = num + 1;
        change(num);
        while (start > 0 && end <= switchAmount) {
            if (arr[start] == arr[end]) {
                change(start);
                change(end);
                start--;
                end++;
            } else {
                break;
            }
        }
    }
}
