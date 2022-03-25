import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double X = Double.parseDouble(br.readLine());
        int N = Integer.parseInt(br.readLine());
        ArrayList<Staff> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int votes = Integer.parseInt(st.nextToken());
            // 득표율 5퍼 미만인 스태프는 제외
            if (5 < votes / X * 100.0) {
                list.add(new Staff(name, votes));
            }
        }

        list.sort((Comparator.comparing(o -> o.name))); // 스태프 이름 순으로 정렬

        for (Staff staff : list) {
            for (int j = 1; j <= 14; j++) {
                staff.arr.offer(staff.votes / j);
            }
        }

        int cnt = 1;
        while (cnt <= 14) {
            int max = 0;
            int num = 0; // 가장 점수 집합이 높은 스태프를 찾기 위한 변수
            for (int i = 0; i < list.size(); i++) {
                Staff staff = list.get(i);
                int peek = staff.arr.peek();
                if (peek > max) {
                    max = peek;
                    num = i;
                }
            }
            Staff staff = list.get(num);
            staff.arr.poll(); // 점수 집합에서 제거
            staff.chip++;
            cnt++;
        }

        list.forEach(staff -> System.out.println(staff.name + " " + staff.chip));
    }

    static class Staff {
        String name;
        int votes;
        int chip = 0;
        Queue<Integer> arr = new LinkedList<>(); // 점수 집합

        public Staff(String name, int votes) {
            this.name = name;
            this.votes = votes;
        }
    }
}
