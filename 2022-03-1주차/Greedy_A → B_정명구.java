//A->B
package 이코테.Greedy;

import java.io.*;
import java.util.*;

public class PS0304_16953 {

    static class Node{
        long x;
        int dist;
        public Node(long x, int dist) {
            this.x = x;
            this.dist = dist;
        }
    }

    static long ans, a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        ans = -1;
        bfs();

        System.out.println(ans);
    }

    static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(a ,1));

        while (!q.isEmpty()) {
            Node p = q.poll();
            long now = p.x;

            if(now == b){
                ans = p.dist;
                return;
            }

            if(now * 2 <= b){
                q.add(new Node(now * 2, p.dist + 1));
            }
            if((now * 10) + 1 <= b){
                q.add(new Node((now * 10) + 1, p.dist + 1));
            }
        }
    }
}
