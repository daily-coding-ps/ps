import java.util.*;

class Solution {
    ArrayList<String> candidateKey = new ArrayList<>();
    public int solution(String[][] relation) {

        for (int i = 0; i < relation[0].length; i++) {
            boolean[] check = new boolean[relation[0].length];
            dfs(check, 0, 0, i + 1, relation);
        }

        return candidateKey.size();
    }

    private void dfs(boolean[] check, int start, int depth, int end, String[][] relation) {
        if (depth == end) {
            ArrayList<Integer> list = new ArrayList<>();
            String key = "";
            for (int i = 0; i < check.length; i++) {
                if (check[i]) {
                    key += String.valueOf(i);
                    list.add(i);
                }
            }

            HashSet<String> hs = new HashSet<>();

            for (int i = 0; i < relation.length; i++) {
                String s = "";
                for (Integer j : list) {
                    s += relation[i][j];
                }
                if (!hs.add(s)) {
                    return;
                }
            }

            for (String s : candidateKey) {
                int count = 0;
                for (int i = 0; i < key.length(); i++) {
                    String str = String.valueOf(key.charAt(i));
                    if (s.contains(str)) {
                        count++;
                    }
                }

                if (count == s.length()) {
                    return;
                }
            }
            candidateKey.add(key);
            return;
        }

        for (int i = start; i < check.length; i++) {
            if (!check[i]) {
                check[i] = true;
                dfs(check, i, depth + 1, end, relation);
                check[i] = false;
            }
        }
    }
}