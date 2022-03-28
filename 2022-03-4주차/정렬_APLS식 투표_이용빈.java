import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class ALPS식 투표 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        List<Staff> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int vote = Integer.parseInt(st.nextToken());

            if (vote > X / 100.0 * 5) { // 득표율 5퍼 미만 제외
                Staff staff = new Staff(name, vote);

                for (int j = 1; j <= 14; j++) {
                    staff.scores.add(vote / j); // 받은 득표수를 1~14로 나눈 값(점수)를 구함
                }
                list.add(staff);
            }
        }

        for (int i = 0; i < 14; i++) {
            int max = 0;
            int maxStaff = 0;
            for (int j = 0; j < list.size(); j++) {
                int score = list.get(j).scores.get(0);
                if (score > max) {
                    max = score;
                    maxStaff = j;
                }
            }
            Staff staff = list.get(maxStaff);
            staff.chip++;
            staff.scores.remove(0);
        }

        list.sort(Comparator.comparing(s -> s.name));

        for (Staff staff : list) {
            System.out.println(staff.name + " " + staff.chip);
        }

    }

    static class Staff {

        String name;
        int vote;
        int chip = 0;
        List<Integer> scores = new ArrayList<>();

        public Staff(String name, int vote) {
            this.name = name;
            this.vote = vote;
        }
    }
}
