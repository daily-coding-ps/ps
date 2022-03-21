package ps.study_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS {

    static List<Integer>[] list;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            // 양방향 연결
            list[U].add(V);
            list[V].add(U);
        }

        // 정점이 낮은 곳 부터 방문
        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }

        check = new boolean[N + 1];
        dfs(start);
        System.out.println();

        check = new boolean[N + 1];
        bfs(start);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        check[start] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            System.out.print(x + " ");
            for (int y : list[x]) {
                if (!check[y]) {
                    check[y] = true;
                    queue.add(y);
                }
            }
        }
    }

    private static void dfs(int x) {

        if (check[x]) {
            return;
        }

        check[x] = true;
        System.out.print(x + " ");
        for (int y : list[x]) {
            if (!check[y]) {
                dfs(y);
            }
        }
    }
}