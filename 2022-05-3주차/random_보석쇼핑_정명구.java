import java.util.*;

class Solution {
    static int min = Integer.MAX_VALUE;
    static ArrayList<Location> list = new ArrayList<>();
    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        Set<String> hs = new HashSet<>();
        Map<String, Integer> hm = new HashMap<>();

        for (String gem : gems) {
            hs.add(gem);
        }

        int left = 0;
        int right = 0;

        hm.put(gems[right], 1);

        while (true) {

            if (hs.size() == hm.size()) {
                int diff = right - left;

                if (min > diff) {
                    min = diff;
                    list.clear();
                    list.add(new Location(left + 1, right + 1));
                } else if (min == diff) {
                    list.add(new Location(left + 1, right + 1));
                }
                hm.put(gems[left], hm.get(gems[left]) - 1);
                if (hm.get(gems[left]) == 0) {
                    hm.remove(gems[left]);
                }
                left++;
            } else if (right == gems.length - 1) {
                break;
            } else {
                right++;
                hm.put(gems[right], hm.getOrDefault(gems[right], 0) + 1);
            }
        }

        Collections.sort(list, (o1, o2) -> o1.start - o2.start);
        answer[0] = list.get(0).start;
        answer[1] = list.get(0).end;

        return answer;
    }

    static class Location{
        int start;
        int end;

        public Location(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}