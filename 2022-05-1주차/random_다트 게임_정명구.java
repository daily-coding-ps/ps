class Solution {
    static String s = "";
    public int solution(String dartResult) {
        int answer = 0;
        int count = 0;
        int[] dart = new int[3];


        for (int i = 0; i < dartResult.length(); i++) {
            if ('0' <= dartResult.charAt(i) && dartResult.charAt(i) <= '9') {
                s += dartResult.charAt(i);
            }
            if (dartResult.charAt(i) == 'S') {
                dart[count] = Integer.parseInt(s);
                count++;
                s = "";
            }
            if (dartResult.charAt(i) == 'D') {
                dart[count] = (int) Math.pow(Integer.parseInt(s), 2);
                count++;
                s = "";
            }
            if (dartResult.charAt(i) == 'T') {
                dart[count] = (int) Math.pow(Integer.parseInt(s), 3);
                count++;
                s = "";
            }
            if (dartResult.charAt(i) == '*') {
                if (count > 1) {
                    dart[count -2] *= 2;
                }
                dart[count - 1] *= 2;
            }
            if (dartResult.charAt(i) == '#') {
                dart[count - 1] *= -1;
            }

        }

        for (int i = 0; i < 3; i++) {
            answer += dart[i];
        }
        return answer;
    }
}