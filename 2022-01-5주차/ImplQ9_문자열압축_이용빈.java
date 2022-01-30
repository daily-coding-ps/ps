public class ImplQ9_문자열압축_이용빈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        System.out.println(solution(s));
    }

    private static int solution(String s) {
        int[] checkArr = new int[s.length() / 2];
        if (s.length() == 1) {
            return 1;
        }
        for (int i = 1; i <= s.length() / 2; i++) {
            int stack = 1;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j += i) {
                if (s.length() < j + i + i) {
                    if (stack != 1) {
                        sb.append(stack);
                        stack = 1;
                    }
                    sb.append(s.substring(j));
                    break;
                }
                if (s.substring(j, j + i).equals(s.substring(j + i, j + i + i))) {
                    stack++;
                } else {
                    if (stack != 1) {
                        sb.append(stack);
                        stack = 1;
                    }
                    sb.append(s.substring(j, j + i));
                }
            }
            checkArr[i - 1] = sb.length();
        }
        return Arrays.stream(checkArr).min().getAsInt();
    }
}