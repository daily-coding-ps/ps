import java.util.*;

public class MenuRenewal {

    List<String> answerList = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        MenuRenewal menuRenewal = new MenuRenewal();
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        System.out.println(menuRenewal.solution(orders, course));
    }

    public String[] solution(String[] orders, int[] course) {
        // orders 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        // order를 기준으로 조합 만들기
        for (int length : course) {
            for (String order : orders) {
                combination("", order, length);
            }

            // 가장 많이 나온 조합을 answerList에 저장
            if (!map.isEmpty()) {
                List<Integer> countList = new ArrayList<>(map.values());
                int max = Collections.max(countList);

                if (max > 1) {
                    for (String key : map.keySet()) {
                        if (map.get(key) == max) {
                            answerList.add(key);
                        }
                    }
                }
                map.clear();
            }
        }

        Collections.sort(answerList);
        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public void combination(String order, String others, int count) {
        if (count == 0) {
            map.put(order, map.getOrDefault(order, 0) + 1);
            return;
        }

        // 0부터 length까지 조합
        for (int i = 0; i < others.length(); i++) {
            combination(order + others.charAt(i), others.substring(i + 1), count - 1);
        }
    }
}
