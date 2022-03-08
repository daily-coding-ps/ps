package 이코테.Greedy;

import java.util.*;

public class Q6_review {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{3, 1, 2}, 5));
    }

    static class foodInfo {
        int foodTime;
        int index;

        public foodInfo(int foodTime, int index) {
            this.foodTime = foodTime;
            this.index = index;
        }
    }


    static class Solution {

        public int solution(int[] food_times, long k) {

            ArrayList<foodInfo> list = new ArrayList<>();
            int foodLength = food_times.length;

            for (int i = 0; i < foodLength; i++) {
                list.add(new foodInfo(food_times[i], i + 1));
            }

            Collections.sort(list, new Comparator<foodInfo>() {
                @Override
                public int compare(foodInfo o1, foodInfo o2) {
                    return o1.foodTime - o2.foodTime;
                }
            });

            int prevTime = 0;
            int i = 0;

            for (foodInfo f : list) {
                long diff = f.foodTime - prevTime;
                if(diff != 0){
                    long spend = diff * foodLength;
                    if(spend <= k){
                        k -= spend;
                        prevTime = f.foodTime;
                    }else{
                        k %= foodLength;
                        list.subList(i, food_times.length).sort(new Comparator<foodInfo>() {
                            @Override
                            public int compare(foodInfo o1, foodInfo o2) {
                                return o1.index - o2.index;
                            }
                        });

                        return list.get(i + (int) k).index;
                    }
                }

                i++;
                foodLength--;
            }

            return -1;
        }
    }
}