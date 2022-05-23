import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 압축 {

    public static void main(String[] args) {
        String msg = "KAKAO";
        System.out.println(Arrays.toString(solution(msg)));
    }

    public static int[] solution(String msg) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        int idx = 1;
        for (char i = 'A'; i <= 'Z'; i++) { // 기본 알파벳 초기화
            map.put(i + "", idx++);
        }

        boolean flag = false; // 문자열의 끝인지 확인
        for (int i = 0; i < msg.length(); i++) {
            String word = String.valueOf(msg.charAt(i));

            while (map.containsKey(word)) {
                i++;
                if (i == msg.length()) { // 문자열의 끝이면
                    flag = true; // 플래그 변경후 break;
                    break;
                }
                word += msg.charAt(i);
            }
            if (flag) { // 문자열의 끝인 경우
                list.add(map.get(word));  // 리스트에 word의 idx를 넣고 break;
                break;
            }
            list.add(map.get(word.substring(0, word.length() - 1))); // 현재 word에는 지금 사전에 넣을 단어이므로 뒤에서 문자 하나를 제거해야 사전에 있는 단어이다
            map.put(word, idx++); // 사전에 단어 추가
            i--; // 단어를 만들면서 i++를 해주었기에 원복
        }

        int[] answer = new int[list.size()]; // list를 int[]로 담아 리턴
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

}
