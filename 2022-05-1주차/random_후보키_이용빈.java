import java.util.HashSet;
import java.util.Set;

public class 후보키 {
    static int r, c;

    static String[][] table;
    static Set<Set<Integer>> candidate;

    public int solution(String[][] relation) {
        r = relation.length;
        c = relation[0].length;
        table = relation;
        candidate = new HashSet<>();

        for (int pick = 1; pick <= c; pick++) {
            getKeySet(0, pick, new HashSet<>());
        }

        return candidate.size();
    }

    public void getKeySet(int start, int pick, HashSet<Integer> set) {
        if (pick == 0) {

            // 유일성을 만족하지 않으면 후보키 될 수 없음
            if (!isUnique(set))
                return;

            // 이미 뽑힌 후보키에서 최소성 확인
            for (Set<Integer> part : candidate) {
                Set<Integer> temp = new HashSet<>(part);

                // 기존의 후보키 조합 - 뽑힌 후보키 조합
                temp.removeAll(set);

                // = 0
                // 뽑힌 후보키 조합이 기존의 조합을 포함하고 있음
                if (temp.size() == 0)
                    return;
            }

            candidate.add(set);

            return;
        }

        for (int i = start; i < c; i++) {
            HashSet<Integer> newSet = new HashSet<>(set);
            newSet.add(i);
            getKeySet(i + 1, pick - 1, newSet);
        }
    }

    public boolean isUnique(HashSet<Integer> set) {
        HashSet<String> setResult = new HashSet<>();

        for (String[] row : table) {
            String value = "";

            for (Integer idx : set) {
                value += row[idx];
            }

            // 겹치는 값이 하나라도 있으면 값들을 유일하게 식별해낼 수 없음
            if (!setResult.add(value))
                return false;
        }

        return true;
    }
}
