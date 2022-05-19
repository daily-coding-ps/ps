import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        dfs(1);

        int answer = 0;

        for (int i = 2; i < visited.length; i++) {
            if (visited[i]) {
                answer++;
            }
        }
        
        System.out.println(answer);
    }

    static void dfs(int target) {
        visited[target] = true;

        for (int i : graph[target]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}
