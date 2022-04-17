import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빗물 {

    static int[] map;
    static int rain, left, right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken()); // 블록의 최대 높이
        int W = Integer.parseInt(st.nextToken()); // 블록의 개수
        map = new int[W];
        rain = left = right = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            int N = Integer.parseInt(st.nextToken());
            map[i] = N;
        }

        for (int i = 1; i < W - 1; i++) { // 물이 쌓이려면 양 옆에 블록이 있어야 하기 때문에 첫 블록과 마지막 블록은 제외
            left = right = 0;

            // 왼쪽에서 가장 높은 블록의 높이
            for (int j = 0; j < i; j++) {
                left = Math.max(map[j], left);
            }
            // 오른쪽에서 가장 높은 블록의 높이
            for (int j = i + 1; j < W; j++) {
                right = Math.max(map[j], right);
            }
            // left, right 중 더 낮은 블록보다 현재 블록의 높이가 낮다면 (더 낮은 블록 - 현재 블록) 만큼 비가 쌓임
            if (map[i] < left && map[i] < right) {
                rain += Math.min(left, right) - map[i];
            }
            /*
            ㅁ
            ㅁ ㅁ  ㅁ
            ㅁ ㅁ  ㅁ
            ㅁㅁㅁㅁㅁ

            left : 4
            right : 3
            */
        }
        System.out.println(rain);
    }
}
