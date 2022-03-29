import java.util.*;

class Solution {

    static HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();
    static ArrayList<Integer> score = new ArrayList<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = {};

        //각 info가 해당되는 hashmap 전부 생성
        for (int i = 0; i < info.length; i++) {
            dfs("", 0, info[i].split(" "));
        }

        //hashmap에 저장된 list 오름차순 정렬
        for (ArrayList<Integer> list : hashMap.values()) {
            Collections.sort(list);
        }

        answer = new int[query.length];

        //query 조건에 맞는 지원자를 가져온다.
        int i = 0;
        for (String q : query) {
            String[] data = q.split(" and ");
            int target = Integer.parseInt(data[3].split(" ")[1]);
            data[3] = data[3].split(" ")[0];

            String key = String.join("", data);

            if (hashMap.containsKey(key)) {
                ArrayList<Integer> list = hashMap.get(key);
                // binary search 를 통해서 lower-bound를 찾는다.
                int left = 0;
                int right = list.size()-1;

                while (left <= right) {
                    int mid = (left + right) / 2;

                    if (list.get(mid) < target) {
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }
                answer[i] = list.size() - left;
            }
            i++;
        }

        return answer;
    }


    static void dfs(String key, int depth, String[] info){
        if(depth == 4){
            if (!hashMap.containsKey(key)) {
                score = new ArrayList<>();
                score.add(Integer.parseInt(info[4]));
                hashMap.put(key, score);
            }else{
                hashMap.get(key).add(Integer.parseInt(info[4]));
            }
            return;
        }

        dfs(key + "-", depth + 1, info);
        dfs(key + info[depth], depth + 1, info);
    }
}