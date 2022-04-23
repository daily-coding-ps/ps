class Solution{
    public static int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n + 1];

        // 체육복이 없는 학생은 -1
        // 체육복 여분이 있는 학생은 +1
        for (int i : lost) {
            students[i]--;
        }
        for (int i : reserve) {
            students[i]++;
        }

        // 처음 학생과 마지막 학생은 i-1, i+1로 조회
        for (int i = 1; i < students.length - 1; i++) {
            if (students[i] == -1) {
                // 이전 학생이 여벌이 있는 경우
                if (students[i - 1] == 1) {
                    students[i - 1]--;
                    students[i]++;

                    // 다음 학생이 여벌이 있는 경우
                } else if (students[i + 1] == 1) {
                    students[i + 1]--;
                    students[i]++;
                }
            }
        }

        // 빌리지 못한 학생의 수를 전체 학생에서 빼기
        return (int) (n - Arrays.stream(students)
                .filter(value -> value == -1)
                .count());
    }
}
