import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class 메뉴 리뉴얼 {

    static HashMap<String, Integer> map;
    static int m;

    public static void main(String[] args) {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};
        System.out.println(Arrays.toString(solution(orders, course)));
    }

    public static String[] solution(String[] orders, int[] course) {
        PriorityQueue<String> pq = new PriorityQueue<>();

        for (int i = 0; i < course.length; i++) { //  각 요리의 개수 만큼
            map = new HashMap<>();
            m = 0;
            for (int j = 0; j < orders.length; j++) {
                find(0, "", course[i], 0, orders[j]);
            }
            for (String s : map.keySet()) {
                if (map.get(s) == m && m > 1) { // 최대 값인 key를 찾아서
                    pq.offer(s); // 우선순위 큐에 넣음
                }
            }
        }
        String[] ans = new String[pq.size()];
        int k = 0;
        while (!pq.isEmpty()) {
            ans[k++] = pq.poll();
        }
        return ans;
    }

    static void find(int cnt, String str, int targetNum, int idx, String word) {
        if (cnt == targetNum) { // 요리의 개수와 일치해지면
            char[] array = str.toCharArray();
            Arrays.sort(array); // 알파벳 순 정렬

            String menu = "";
            for (char c : array) {
                menu += c;
            }
            map.put(menu, map.getOrDefault(menu, 0) + 1); // 있으면 기존 개수 + 1, 없으면 0
            m = Math.max(m, map.get(menu)); // 최대 개수 카운트 구함
            return;
        }
        for (int i = idx; i < word.length(); i++) {
            char now = word.charAt(i);
            find(cnt + 1, str + now, targetNum, i + 1, word);
        }
    }

}