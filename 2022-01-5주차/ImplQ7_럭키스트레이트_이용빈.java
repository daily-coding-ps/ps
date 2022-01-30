public class ImplQ7_럭키스트레이트_이용빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int left = 0;
        int right = 0;
        for (int i = 0; i < array.length / 2; i++) {
            left += array[i];
            right += array[array.length - 1 - i];
        }

        if (left == right) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}