package thisiscote.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FindCity {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 도시의 개수
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수
        int K = Integer.parseInt(st.nextToken()); // 거리 정보
        int X = Integer.parseInt(st.nextToken()) - 1; // 출발 도시 번호 0번부터 시작하기 위해 -1

        List<List<Integer>> adj = new ArrayList<>(); // 갈 수 있는 도시
        int[] visited = new int[300001]; // 거리는 최대 300,000개

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
            visited[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            // 0번부터 시작하기 때문에 -1
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            adj.get(A).add(B);
        }

        visited[X] = 0; // 출발 도시는 방문한 것으로 설정

        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);

        while (!queue.isEmpty()) {
            int now = queue.poll(); // 현재 도시

            adj.get(now).stream()
                    .filter(next -> visited[next] == -1) // 방문하지 않은 도시만 필터링
                    .forEach(next -> {
                        visited[next] = visited[now] + 1; // 거리 값 추가
                        queue.add(next); // 큐에 추가
                    });
        }

        // 최단 거리의 도시를 찾은 경우
        boolean check = true;
        for (int i = 0; i < N; i++) {
            if (visited[i] == K) {
                System.out.println(i + 1);
                check = false;
            }
        }

        if (check) {
            System.out.println(-1);
        }
    }
}
