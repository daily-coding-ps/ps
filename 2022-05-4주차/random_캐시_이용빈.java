import java.util.LinkedList;
import java.util.Queue;

public class 캐시 {

    public static void main(String[] args) {
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Queue<String> cache = new LinkedList<>();

        if (cacheSize == 0) { // 캐시 사이즈가 0이면 length * 5 (모두 cache miss)
            return cities.length * 5;
        }

        for (String city : cities) {
            city = city.toLowerCase(); // 대소문자 구분 X 이므로 임의로 다 소문자로 처리하였음

            if (cache.contains(city)) { // 캐시에 있으면
                cache.remove(city);
                cache.offer(city);
                answer += 1;
            } else {
                if (cache.size() == cacheSize) {
                    cache.poll();
                }
                cache.offer(city);
                answer += 5;
            }
        }

        return answer;
    }
}
