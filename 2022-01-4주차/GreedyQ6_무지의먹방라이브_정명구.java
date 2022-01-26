//답지 봤습니다
import java.util.*;

class Solution {
    class Food{
        int time;
        int idx;
        Food(int time, int idx){
            this.time = time;
            this.idx = idx;
        }
    }
    
    Comparator<Food> CompTime = new Comparator<Food>() {
        @Override
        public int compare(Food o1, Food o2) {
            return o1.time - o2.time;
        }
    };
    
    Comparator<Food> CompIdx = new Comparator<Food>() {
        @Override
        public int compare(Food o1, Food o2) {
            return o1.idx - o2.idx;
        }
    }; 
    public int solution(int[] food_times, long k) {
        List<Food> foods = new LinkedList<Food>();
        int n = food_times.length;
        
        for(int i=0; i<n ; i++){
            foods.add(new Food(food_times[i], i+1));
        }
        foods.sort(CompTime);
        
        int pretime = 0;
        int i = 0;
        
        for(Food f : foods){
            long diff = f.time - pretime;
            if(diff != 0 ){
                long spend = diff * n;
                if(spend <= k){
                    k -= spend;
                    pretime = f.time;
                }else{
                    k %= n;
                    foods.subList(i, food_times.length).sort(CompIdx);
                    return foods.get(i+(int)k).idx;
                }
            }
            i++;
            n--;
        }
        
        return -1;
    }
}