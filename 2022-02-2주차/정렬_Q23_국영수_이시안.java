import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());

        // N 크기의 List 생성
        List<Student> list = new ArrayList<>(N);

        // 입력값으로 Student를 생성하여 List에 추가
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            list.add(new Student(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()));
        }

        list.stream()
                // 국어점수 내림차순 -> 영어점수 오름차순 -> 수학점수 내림차순 -> 이름 오름차순
                .sorted(Comparator.comparing(Student::getKorean, Comparator.reverseOrder())
                        .thenComparing(Student::getEnglish)
                        .thenComparing(Student::getMath, Comparator.reverseOrder())
                        .thenComparing(Student::getName)
                ).forEach(student -> System.out.println(student.getName()));
    }
}

class Student{
    String name;
    int korean;
    int english;
    int math;

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

    public Student(String name, String korean, String english, String math) {
        this.name = name;
        this.korean = Integer.parseInt(korean);
        this.english = Integer.parseInt(english);
        this.math = Integer.parseInt(math);
    }
}
