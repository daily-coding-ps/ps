class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String s = Integer.toBinaryString(arr1[i] | arr2[i]);
            while (s.length() < n) {
                s = "0" + s;
            }

            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == '0') {
                    sb.append(" ");
                }
                if (s.charAt(j) == '1') {
                    sb.append("#");
                }
            }
            //replaceAll 사용하면 더 깔끔하게 처리 가능

            answer[i] = sb.toString();
            sb.setLength(0);
        }

        return answer;
    }
}