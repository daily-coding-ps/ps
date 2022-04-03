package programmers;

import java.util.ArrayList;
import java.util.Locale;

public class NewsClustering {
    public static void main(String[] args) {
        NewsClustering newsClustering = new NewsClustering();
        System.out.println(newsClustering.solution("aa1+aa2", "AAAA12"));
    }

    public static ArrayList<String> addMultiSet(String str) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i + 1);
            if (Character.isAlphabetic(c1) && Character.isAlphabetic(c2)) {
                list.add(c1 + "" + c2);
            }
        }
        return list;
    }

    public int solution(String str1, String str2) {
        int answer = 0;
        String s1 = str1.toUpperCase(Locale.ROOT);
        String s2 = str2.toUpperCase(Locale.ROOT);
        ArrayList<String> list1 = addMultiSet(s1);
        ArrayList<String> list2 = addMultiSet(s2);
        ArrayList<String> union = new ArrayList<>(); // 합집합
        ArrayList<String> intersection = new ArrayList<>(); // 교집합

        for (String s : list1) {
            if (list2.contains(s)) {
                intersection.add(s); // 두번째 다중집합에 일치하는 것이 있다면 교집합에 추가
                list2.remove(s); // 두번째 다중집합에서 제거
            }
            union.add(s); // 합집합에 추가
        }

        union.addAll(list2); // 두번째 다중집합의 남은 요소들 합집합에 추가

        double jaccard = 0;
        if (union.size() == 0) {
            jaccard = 1; // 두 집합이 공집합인 경우 1
        } else {
            jaccard = (double) intersection.size() / union.size(); // 자카드 유사도 구하기
        }

        return (int) (jaccard * 65536);
    }
}
