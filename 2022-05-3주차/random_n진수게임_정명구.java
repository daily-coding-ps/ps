import java.util.Locale;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int maxNum = t * m;

        int idx = 0;
        while (sb.length() < maxNum) {
            sb.append(Integer.toString(idx, n));
            idx++;
        }
        String change = sb.toString().toUpperCase(Locale.ROOT);
        sb.setLength(0);

        for (int i = 0; i < change.length(); i++) {
            if (i % m == p - 1) {
                sb.append(change.charAt(i));
            }
        }
        sb.setLength(t);

        System.out.println(sb.length());
        return sb.toString();
    }
}