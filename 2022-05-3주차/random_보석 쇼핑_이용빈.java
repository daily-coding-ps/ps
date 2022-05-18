import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class 보석 쇼핑 {

    static Set<String> set = new HashSet<>(); // 보석의 종류를 기록
    static Map<String, Integer> map = new HashMap<>(); // 보석의 종류별 개수를 기록

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}));
    }

    public static int[] solution(String[] gems) {
        set.addAll(Arrays.asList(gems));

        int start = 0;
        int tempStart = 0;
        int length = gems.length;
        Queue<String> queue = new LinkedList<>();
        for (String gem : gems) {
            map.put(gem, map.getOrDefault(gem, 0) + 1);

            queue.add(gem);
            while (true) {
                String peek = queue.peek();
                if (map.get(peek) > 1) {
                    map.put(peek, map.get(peek) - 1);
                    queue.poll();
                    tempStart++;
                } else {
                    break;
                }
            }

            if (map.size() == set.size()) {
                if (length > queue.size()) {
                    length = queue.size();
                    start = tempStart;
                }
            }
        }
        return new int[]{start + 1, start + length};
    }

}
