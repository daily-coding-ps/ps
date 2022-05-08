import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

class Solution {
    HashSet<HashSet<String>> result;

    int solution(String[] user_id, String[] banned_id) {
        result = new HashSet<>();
        dfs(user_id, banned_id, new LinkedHashSet<>());
        return result.size();
    }

    void dfs(String[] user_id, String[] banned_id, Set<String> set) {
        if (set.size() == banned_id.length) {
            if (isBannedUsers(set, banned_id)) {
                result.add(new HashSet<>(set));
            }
            return;
        }

        for (String userId : user_id) {
            if (!set.contains(userId)) {
                set.add(userId);
                dfs(user_id, banned_id, set);
                set.remove(userId);
            }
        }
    }

    boolean isBannedUsers(Set<String> set, String[] banned_id) {
        int i = 0;
        for (String user : set) {
            if (!isSameString(user, banned_id[i++])) {
                return false;
            }
        }
        return true;
    }

    boolean isSameString(String user, String bannedId) {
        if (user.length() != bannedId.length()) {
            return false;
        }

        for (int i = 0; i < user.length(); i++) {
            if (bannedId.charAt(i) == '*') {
                continue;
            }
            if (user.charAt(i) != bannedId.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
