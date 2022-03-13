import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static int[] solution(int[] fees, String[] records) {
        int lastTime = getMin("23:59");

        Map<String, Integer> parking = new HashMap<>();
        Map<String, Integer> times = new HashMap<>();
        List<String> cars = new ArrayList<>();

        for (String record : records) {
            String[] rc = record.split(" ");
            int time = getMin(rc[0]);
            String car = rc[1];

            if (!cars.contains(car)) {
                cars.add(car);
                times.put(car, 0);
            }

            // 현재 주차중이면 출차
            if (parking.containsKey(car)) {
                times.put(car, times.get(car) + (time - parking.get(car))); // 기존 시간 + 주차 시간
                parking.remove(car);
            } else { // 주차중이 아니면 입차
                parking.put(car, time);
            }

        }

        int[] ret = new int[cars.size()];

        // 차번 순으로 정렬
        Collections.sort(cars);

        for (int i = 0; i < cars.size(); i++) {
            // 기본요금
            ret[i] = fees[1];
            String car = cars.get(i);

            // 누적시간중 기본요금 시간 제외
            int time = times.get(car) - fees[0];
            // 아직 출차가 안되었다면 마지막시간으로 정산

            if (parking.containsKey(car)) {
                time += (lastTime - parking.get(car));
            }
            // 요금 정산
            if (time > 0) {
                ret[i] += (Math.ceil(time / (fees[2] * 1.0)) * fees[3]);
            }
        }

        return ret;
    }

    public static int getMin(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"})));
    }

}
