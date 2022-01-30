public class ImplQ8_문자열재정렬_이용빈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        int sum = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) {
                sum += Integer.parseInt(String.valueOf(S.charAt(i)));
            } else {
                list.add(String.valueOf(S.charAt(i)));
            }
        }
        list.sort(Comparator.naturalOrder());
        for (String s : list) {
            System.out.print(s);
        }
        System.out.println(sum);
    }
}