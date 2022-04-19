import java.util.Arrays;

public class 비밀지도 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5,
            new int[]{46, 33, 33, 22, 31, 50},
            new int[]{27, 56, 19, 14, 14, 10}
        )));
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = String.format("%" + n + "s", Integer.toBinaryString(arr1[i] | arr2[i]))
                .replaceAll("1", "#")
                .replaceAll("0", " ");
        }
        return result;
    }

}
