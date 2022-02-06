import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 특정_거리의_도시찾기 {

    static int N, M, K, X;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[A].add(B);
        }

        bfs(X);

    }

    private static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        int[] visited = new int[N + 1];
        while (!queue.isEmpty()) {
            int tmp = queue.poll();

            list[tmp].stream()
                .filter(next -> visited[next] == 0)
                .forEach(next -> {
                    visited[next] = visited[tmp] + 1;
                    queue.add(next);
                });

        }
        boolean flag = false;

        for (int i = 1; i <= N; i++) {
            if (visited[i] == K && i != X) {
                flag = true;
                System.out.println(i);
            }
        }
        if (!flag) {
            System.out.println(-1);
        }
    }
}
