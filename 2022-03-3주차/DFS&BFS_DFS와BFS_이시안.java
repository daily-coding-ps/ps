import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer>[] list;
    static int N;
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        // 출력이 편하도록 + 1
        list = new ArrayList[N + 1];
        checked = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 양방향 연결
            list[a].add(b);
            list[b].add(a);
        }

        bfs(V);
        checked = new boolean[N + 1];
        dfs(V);
    }

    public static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.offer(x);

        while (!q.isEmpty()) {
            int poll = q.poll();
            checked[poll] = true;
            sb.append(poll).append(" ");

            for (int i : list[poll]) {
                if (!checked[i]) {
                    q.offer(i);
                    checked[i] = true;
                }
            }
        }
        System.out.println(sb);
    }

    public static void dfs(int x) {
        if (checked[x]) {
            return;
        }

        checked[x] = true;
        System.out.print(x + " ");

        for (int i : list[x]) {
            if (!checked[i]) {
                dfs(i);
            }
        }
    }

}
