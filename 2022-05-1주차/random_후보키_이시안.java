package programmers;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class CandidateKey {

    Comparator<Integer> comp = new Comparator<Integer>() {
        int countBits(int n) {
            int ret = 0;
            while (n != 0) {
                if ((n & 1) != 0) {
                    ret++;
                }
                n = n >> 1;
            }
            return ret;
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            int x = countBits(o1);
            int y = countBits(o2);

            return Integer.compare(x, y);
        }
    };

    public static void main(String[] args) {
        CandidateKey candidateKey = new CandidateKey();
        System.out.println(candidateKey.solution(new String[][]{{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}}));
    }

    public int solution(String[][] relation) {
        int answer = 0;
        int rowSize = relation.length;
        int colSize = relation[0].length;
        List<Integer> candidates = new LinkedList<>();

        // 공집합을 제외하기 위해 1부터 시작
        // 유일성을 만족하는 후보키를 List에 저장
        for (int i = 1; i < 1 << colSize; i++) {
            if (check(relation, rowSize, colSize, i)) {
                candidates.add(i);
            }
        }

        candidates.sort(comp);

        while (candidates.size() != 0) {
            int n = candidates.remove(0);
            answer++;

            candidates.removeIf(c -> (n & c) == n);
        }

        return answer;
    }

    boolean check(String[][] relation, int rowSize, int colSize, int subset) {
        // 이중 for문으로 모든 튜플 조합
        for (int i = 0; i < rowSize - 1; i++) {
            for (int j = i + 1; j < rowSize; j++) {
                boolean isSame = true;
                for (int k = 0; k < colSize; k++) {

                    // 일치하는 부분 집합이 없을 경우 유일성을 만족한다
                    if ((subset & 1 << k) == 0) {
                        continue;
                    }

                    // 두 값이 다르다면 유일성을 만족한다
                    if (!relation[i][k].equals(relation[j][k])) {
                        isSame = false;
                        break;
                    }
                }
                // 유일성을 만족하지 못한 경우 false 반환
                if (isSame) {
                    return false;
                }
            }
        }
        return true;
    }
}
