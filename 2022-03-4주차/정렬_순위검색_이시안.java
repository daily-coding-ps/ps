import java.util.ArrayList;
import java.util.HashMap;

public class SearchRank {
    public int[] solution(String[] info, String[] query) {
        // info를 key, 점수를 list value로 받는 HashMap 생성
        HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();

        // HashMap에 정보 담기
        for (String i : info) {
            String[] data = i.split(" ");
            // 정보와 -를 교차해서 넣기
            String[] languages = {data[0], "-"};
            String[] jobs = {data[1], "-"};
            String[] exps = {data[2], "-"};
            String[] foods = {data[3], "-"};
            Integer value = Integer.parseInt(data[4]);
            for (String lang : languages)
                for (String job : jobs)
                    for (String exp : exps)
                        for (String food : foods) {
                            String[] keyData = {lang, job, exp, food};
                            String key = String.join(" ", keyData);
                            ArrayList<Integer> arr = hashMap.getOrDefault(key, new ArrayList<>()); // key가 있으면 ArrayList를 반환하고, 없으면 새로운 ArrayList 생성

                            arr.add(value);
                            hashMap.put(key, arr);
                        }
        }

        // 점수를 오름차순 정렬
        for (ArrayList<Integer> scoreList : hashMap.values()) {
            scoreList.sort(null);
        }

        int[] answer = new int[query.length];
        int i = 0;

        // 조건에 맞는 지원자 가져오기
        for (String q : query) {
            String[] data = q.split(" and ");
            int target = Integer.parseInt(data[3].split(" ")[1]);
            data[3] = data[3].split(" ")[0];
            String key = String.join(" ", data); // HashMap에서 조회할 key 조합

            // key가 존재하면 list에서 이분탐색
            if (hashMap.containsKey(key)) {
                ArrayList<Integer> list = hashMap.get(key);
                int left = 0;
                int right = list.size();
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (list.get(mid) >= target) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                answer[i] = list.size() - left; // 이분탐색한 결과를 결과값에 저장
            }
            i++;
        }
        return answer;
    }
}