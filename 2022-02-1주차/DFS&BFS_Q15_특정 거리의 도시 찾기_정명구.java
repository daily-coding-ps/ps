package 이코테.DFS_BFS;

import java.io.*;
import java.util.*;

public class Q15 {

    static ArrayList<Integer>[] city;
    static int[] dist; //방문 처리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];
        city = (ArrayList<Integer>[]) new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            city[i] = new ArrayList<>();
            dist[i] = -1;
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            city[u].add(v);
//            city[v].add(u); 양방향 연결이 아님
        }

        bfs(x); //출발

        boolean check = false;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == k) {
                check = true;
                System.out.println(i);
            }
        }

        if(!check) System.out.println(-1);

    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : city[now]) {
                if (dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    q.add(next);
                }
            }

        }

    }
}
