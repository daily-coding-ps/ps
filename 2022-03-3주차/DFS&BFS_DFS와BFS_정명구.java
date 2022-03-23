package 스터디.PS3월3주차;

import java.util.*;
import java.io.*;

public class PS0323_1260 {
    static ArrayList<Integer>[] list;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        visit = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(list[i]);
        }

        dfs(start);
        sb.append("\n");

        visit = new boolean[n + 1];
        bfs(start);

        System.out.println(sb);
    }

    static void dfs(int start) {
        if(visit[start]){
            return;
        }
        visit[start] = true; //방문처리
        sb.append(start + " ");

        for (int next : list[start]) {
            if (!visit[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = true;

        while (!q.isEmpty()) {
            Integer now = q.poll();
            sb.append(now + " ");
            for (int next : list[now]) {
                if (!visit[next]) {
                    visit[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
