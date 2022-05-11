import java.util.HashSet;
import java.util.Set;

public class 불량 사용자 {

    private static final Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}));
    }
    public static int solution(String[] user_id, String[] banned_id) {
        boolean[] visited = new boolean[user_id.length];
        dfs(user_id, banned_id, 0, visited);
        return set.size();
    }

    private static void dfs(String[] user_id, String[] banned_id, int ban_idx, boolean[] visited) {
        if (ban_idx == banned_id.length) { // ban된 id 모두 선택
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < user_id.length; i++) {
                if (visited[i]) {
                    sb.append(i); // 모든 idx 이어붙이고
                }
            }
            set.add(sb.toString()); // 중복제거된 set insert
            return;
        }
        for (int i = 0; i < user_id.length; i++) {
            if (visited[i]) { // 이미 방문된 경우 제외
                continue;
            }
            boolean flag = false;
            // 유저와 밴 된 유저의 길이가 같은 경우만 체크
            if (user_id[i].length() == banned_id[ban_idx].length()) {
                for (int s = 0; s < user_id[i].length(); s++) {
                    if (banned_id[ban_idx].charAt(s) == '*') {
                        continue;
                    }
                    // 하나라도 다른 글자가 포함되어 있다면 멈추고 다음 유저로 이동
                    if (user_id[i].charAt(s) != banned_id[ban_idx].charAt(s)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) { // 모든 글자가 맞았으면
                    visited[i] = true;
                    dfs(user_id, banned_id, ban_idx + 1, visited); // 다음 탐색
                    visited[i] = false;
                }
            }
        }
    }
}
