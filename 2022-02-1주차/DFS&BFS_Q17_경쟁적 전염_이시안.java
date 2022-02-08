import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int K;
    public static int N;
    public static int[][] square = new int[200][200];

    // 정렬하기 위한 리스트 생성
    public static ArrayList<Virus> virusList = new ArrayList<>();

    // 바이러스가 퍼져나갈 수 있는 4가지의 위치
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                square[i][j] = Integer.parseInt(st.nextToken());

                // 바이러스가 해당 위치에 존재하는 경우
                if (square[i][j] != 0) {
                    // 해당 위치와 시간을 갖는 바이러스 생성
                    virusList.add(new Virus(square[i][j], 0, i, j));
                }
            }
        }

        // 바이러스 순서대로 정렬
        Collections.sort(virusList);

        Queue<Virus> queue = new LinkedList<>();
        for (int i = 0; i < virusList.size(); i++) {
            queue.offer(virusList.get(i));
        }

        st = new StringTokenizer(br.readLine(), " ");

        int targetS = Integer.parseInt(st.nextToken());
        int targetX = Integer.parseInt(st.nextToken());
        int targetY = Integer.parseInt(st.nextToken());

        // BFS 진행
        while (!queue.isEmpty()) {
            Virus virus = queue.poll();

            // 시간이 다되거나, 큐가 빌 때까지 반복
            if (virus.getSecond() == targetS) {
                break;
            }

            // 현재 노드에서 상하좌우 확인
            for (int i = 0; i < 4; i++) {
                int nx = virus.getX() + dx[i];
                int ny = virus.getY() + dy[i];

                // 해당 위치로 이동가능한 경우
                if (0 <= nx && nx < N && 0 <= ny && ny < N) {

                    // 방문하지 않은 위치라면 바이러스 넣기
                    if (square[nx][ny] == 0) {
                        square[nx][ny] = virus.getIndex();
                        queue.offer(new Virus(virus.getIndex(), virus.getSecond() + 1, nx, ny));
                    }
                }
            }
        }

        System.out.println(square[targetX - 1][targetY - 1]);
    }
}

class Virus implements Comparable<Virus> {
    private int index;
    private int second;
    private int x;
    private int y;

    public Virus(int index, int second, int x, int y) {
        this.index = index;
        this.second = second;
        this.x = x;
        this.y = y;
    }

    public int getIndex() {
        return this.index;
    }

    public int getSecond() {
        return this.second;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    // 정렬 기준은 '번호가 낮은 순서'
    @Override
    public int compareTo(Virus other) {
        if (this.index < other.index) {
            return -1;
        }
        return 1;
    }
}
