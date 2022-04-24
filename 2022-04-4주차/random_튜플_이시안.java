class Solution {
    public int[] solution(String s) {
        // 문자열의 각 튜플을 배열에 추가
        String[] arr = s.replaceAll("[{]", " ")
                .replaceAll("[}]", " ")
                .trim()
                .split(" , ");

        // set은 순서를 보장하지 않고 중복을 허용하지 않는 자료구조
        Set<String> set = new HashSet<>();
        int[] answer = new int[arr.length];

        // 짧은 원소부터 set에 채우기 위해 정렬
        Arrays.sort(arr, Comparator.comparingInt(String::length));

        // 튜플의 원소를 하나씩 꺼내서 set에 추가되면 answer에 추가
        int idx = 0;
        for (String s1 : arr) {
            for (String s2 : s1.split(",")) {
                if (set.add(s2)) {
                    answer[idx++] = Integer.parseInt(s2);
                }
            }
        }
        return answer;
    }
}
