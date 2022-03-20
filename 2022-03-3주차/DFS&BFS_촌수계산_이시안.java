import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N = 0; // 전체 사람의 수
    static int start, target = 0; // 촌수를 계산해야하는 타겟
    static int M = 0; // 관계의 갯수
    static boolean[] visited = null; // 방문 처리용 배열
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean check = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        // 양방향 인접리스트 구현
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.get(x).add(y);
            list.get(y).add(x);
        }

        bfs();

        if (!check) {
            System.out.println(-1);
        }
    }

    static void bfs() {
        Queue<Person> queue = new LinkedList<>();
        queue.add(new Person(start, 0));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Person person = queue.poll();

            // 현재 위치가 타겟과 일치하면 종료
            if (person.pos == target) {
                check = true;
                System.out.println(person.distance);
                return;
            }

            for (int i : list.get(person.pos)) {
                // 방문한 적이 없으면 큐에 추가하고 방문 처리
                if (!visited[i]) {
                    queue.add(new Person(i, person.distance + 1));
                    visited[i] = true;
                }
            }
        }
    }

    static class Person {
        int pos = 0;
        int distance = 0;

        public Person(int pos, int distance) {
            this.pos = pos;
            this.distance = distance;
        }
    }
}
