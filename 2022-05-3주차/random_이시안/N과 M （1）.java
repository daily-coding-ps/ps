import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        arr = new int[M];

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int count) {
        if (count == M) {
            for (int num : arr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[count] = i + 1;
                dfs(count + 1);
                visited[i] = false;
            }
        }
    }
}
