package ps.study_3;

import java.util.Scanner;

public class 촌수계산 {

    static int N;
    static int[][] graph;
    static int[] visit;
    static int result = -1;
    static int start, end;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        start = sc.nextInt();
        end = sc.nextInt();
        visit = new int[N + 1];
        graph = new int[N + 1][N + 1];
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            graph[s][e] = graph[e][s] = 1;
        }
        dfs(start, 0);
        System.out.println(result);

    }

    private static void dfs(int x, int depth) {
        if (x == end) {
            result = depth;
            return;
        }

        visit[x] = 1;
        for (int i = 1; i <= N; i++) {
            if (graph[x][i] == 1 && visit[i] == 0) {
                dfs(i, depth + 1);
            }
        }
    }

}
