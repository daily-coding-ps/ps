import java.util.*;

class Solution {
    public int[] solution(String s) {

        s = s.replaceAll("\\}", "");
        s = s.replaceAll("\\{", "");

        HashMap<String, Integer> hm = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ',') {
                sb.append(s.charAt(i));
            }else{
                hm.put(sb.toString(), hm.getOrDefault(sb.toString(), 0) + 1);
                sb.setLength(0);
            }
        }
        hm.put(sb.toString(), hm.getOrDefault(sb.toString(), 0) + 1);

        int size = hm.size();
        int[] answer = new int[size];
        for (String key : hm.keySet()) {
            answer[size - hm.get(key)] = Integer.parseInt(key);
        }

        return answer;
    }
}