import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class _국영수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Student> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            list.add(new Student(new StringTokenizer(br.readLine())));
        }

        list.stream()
            .sorted(Comparator.comparing(Student::getKorean).reversed()
                .thenComparing(Student::getEnglish)
                .thenComparing(Comparator.comparing(Student::getMath).reversed()
                    .thenComparing(Student::getName)))
            .map(Student::getName)
            .forEach(System.out::println);


    }

    static class Student {

        String name;
        int korean, english, math;

        public Student(StringTokenizer st) {
            this.name = st.nextToken();
            this.korean = Integer.parseInt(st.nextToken());
            this.english = Integer.parseInt(st.nextToken());
            this.math = Integer.parseInt(st.nextToken());
        }

        public String getName() {
            return name;
        }

        public int getKorean() {
            return korean;
        }

        public int getEnglish() {
            return english;
        }

        public int getMath() {
            return math;
        }
    }
}

