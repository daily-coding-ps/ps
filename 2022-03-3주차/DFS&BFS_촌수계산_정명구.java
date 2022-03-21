package 스터디.PS3월3주차;

import java.io.*;
import java.util.*;

public class PS0321_2644 {

    static class Node{
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    static ArrayList<Integer>[] list;
    static boolean check[];
    static int x,y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        check = new boolean[n + 1];
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

        bfs();

        System.out.println(-1);
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, 0));
        check[x] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();
            x = now.v;

            if(x == y) {
                System.out.println(now.cost);
                System.exit(0);
            }

            for (int next : list[x]) {
                if (!check[next]) {
                    check[next] = true;
                    q.add(new Node(next, now.cost + 1));
                }
            }
        }
    }
}
