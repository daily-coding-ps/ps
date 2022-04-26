import java.util.*;

public class 튜플 {

    public static void main(String[] args) {
        System.out.println(solution("4,2,3 , 3 , 2,3,4,1 , 2,3"));
    }

    public static int[] solution(String s) {
        int[] answer = {};
        String[] arr = s.replaceAll("[{}]", " ").trim().split(" , ");
        answer = new int[arr.length];

        HashSet<Integer> hs = new HashSet<>();

        Arrays.sort(arr, Comparator.comparingInt(String::length));

        int i = 0;
        for (String str : arr) {
            for (String num : str.split(",")) {
                int a = Integer.parseInt(num);
                if (!hs.contains(a)) {
                    hs.add(a);
                    answer[i++] = a;
                }
            }
        }
        return answer;
    }
}
