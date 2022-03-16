package 스터디;

import java.util.*;

public class PS0316_KaKao_ParkingMoney {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        sol.solution(fees, records);
    }

    static class Solution {
        public int[] solution(int[] fees, String[] records) {
            int[] answer = {};

            HashMap<String, Integer> parkingCar = new HashMap<>();
            HashMap<String, Integer> parkingTime = new HashMap<>();
            List<String> cars = new ArrayList<>();


            for (String record : records) {
                String[] rs = record.split(" ");
                int time = changeMin(rs[0]);
                String car = rs[1];

                //새로운 차 등장
                if (!cars.contains(car)) {
                    cars.add(car);
                    parkingTime .put(car, 0);
                }

                if (parkingCar.containsKey(car)) {
                    //현재 파킹이 되어있으면 출차. (주차 누적시간을 구한다)
                    parkingTime.put(car, parkingTime.get(car) + (time - parkingCar.get(car)));
                    parkingCar.remove(car); // (list 를 만든 이유)
                } else{
                    //입차를 한다.
                    parkingCar.put(car, time);
                }
            }

            answer = new int[cars.size()];
            //차번 순 정렬
            Collections.sort(cars);
            int lastTime = changeMin("23:59");

            for (int i = 0; i < cars.size(); i++) {
                answer[i] = fees[1]; //기본 요금
                String car = cars.get(i);

                int time = parkingTime.get(car) - fees[0];

                if(parkingCar.containsKey(car)){
                    time += (lastTime - parkingCar.get(car));
                }

                if (time > 0) {
                    answer[i] += (Math.ceil(time / (fees[2] * 1.0))* fees[3]);
                }
            }

            return answer;
        }

        static int changeMin(String time) {
            String[] splitTime = time.split(":");
            return Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]);
        }
    }
}
