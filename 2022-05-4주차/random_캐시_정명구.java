package 스터디.PS5월4주차;

import java.util.*;

public class PS0526_캐시 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.solution(0, new String[]{"La", "La"});
    }


    static private class Solution {
        static int cacheHit = 1;
        static int cacheMiss = 5;

        public int solution(int cacheSize, String[] cities) {
            int answer = 0;

            Queue<String> q = new LinkedList<>();

            LinkedList<String> list = new LinkedList<>();

            for (String city : cities) {
                city = city.toLowerCase(Locale.ROOT);


                if (list.remove(city)) {
                    list.addLast(city);
                    answer += cacheHit;
                    continue;
                }


                if (list.size() >= cacheSize && list.size() != 0) {
                    list.removeFirst();
                }

                list.addLast(city);
                answer += cacheMiss;

                if (cacheSize == 0) {
                    list.remove(city);
                }

            }

            return answer;
        }
    }
}
