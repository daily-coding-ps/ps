import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private static int n, k;
    private static int[][] graph = new int[200][200];
    private static ArrayList<Virus> viruses = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        n = sc.nextInt();
        k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] != 0) {
                    viruses.add(new Virus(graph[i][j], 0, i, j));
                }
            }
        }

        Collections.sort(viruses);
        bfs();
    }

    private static void bfs() {
        Queue<Virus> q = new LinkedList<>();
        for (int i = 0; i < viruses.size(); i++) {
            q.offer(viruses.get(i));
        }

        int S = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();

        while (!q.isEmpty()) {
            Virus virus = q.poll();
            if (virus.getSecond() == S) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = virus.getX() + dx[i];
                int ny = virus.getY() + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (graph[nx][ny] == 0) {
                        graph[nx][ny] = virus.getIndex();
                        q.offer(new Virus(virus.getIndex(), virus.getSecond() + 1, nx, ny));
                    }
                }
            }
        }

        System.out.println(graph[X - 1][Y - 1]);

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
        return index;
    }

    public int getSecond() {
        return second;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    @Override
    public int compareTo(Virus o) {
        if (this.index < o.index) {
            return -1;
        }
        return 1;
    }
}
