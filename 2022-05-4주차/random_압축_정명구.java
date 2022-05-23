import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        HashMap<String, Integer> dictionary = new HashMap<>();

        makeDictionary(dictionary);

        ArrayList<Integer> list = new ArrayList<>();
        boolean isEnd = false;

        for(int i = 0 ; i < msg.length() ; i++) {
            String word = msg.charAt(i) + "";

            while(dictionary.containsKey(word)){
                i++;
                if(i == msg.length()) {
                    isEnd = true;
                    break;
                }
                word += msg.charAt(i);
            }

            if(isEnd) {
                list.add(dictionary.get(word));
                break;
            }

            list.add(dictionary.get(word.substring(0, word.length() - 1)));
            dictionary.put(word, dictionary.size() + 1);
            i--;
        }

        answer = new int[list.size()];
        for(int i = 0 ; i < answer.length ; i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

    private void makeDictionary(HashMap<String, Integer> zip) {
        char ch = 'A';
        for (int i = 0; i < 26; i++) {
            zip.put(ch + "", i + 1);
            ch++;
        }
    }
}