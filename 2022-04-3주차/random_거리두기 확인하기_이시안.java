package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class CheckDistancing {

    // 상하좌우 좌표값
    int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            if (check(places[i])) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }

    // 거리두기를 확인하는 메서드
    boolean check(String[] place) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                // 응시자인 경우 bfs를 시행
                if (place[i].charAt(j) == 'P') {
                    // bfs 결과값이 false인 경우 거리두기가 지켜지지 않았음으로 false 반환
                    if (!bfs(place, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    boolean bfs(String[] place, int row, int col) {
        boolean[][] visited = new boolean[5][5]; // 방문처리용

        Queue<Point> queue = new LinkedList<>();
        visited[row][col] = true; // 방문처리
        queue.add(new Point(row, col, 0));

        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            // 거리가 2 이상이면 무시
            if (curr.dist > 2) {
                continue;
            }
            // 거리 2 이하의 위치에 응시자가 존재하면 false 반환
            if (curr.dist != 0 && place[curr.row].charAt(curr.col) == 'P') {
                return false;
            }
            // 그 외의 경우 확인
            for (int i = 0; i < 4; i++) {
                int nr = curr.row + D[i][0];
                int nc = curr.col + D[i][1];

                // 배열 범위를 벗어나면 무시
                if (nr < 0 || nr > 4 || nc < 0 || nc > 4) {
                    continue;
                }
                // 방문한 것은 무시
                if (visited[nr][nc]) {
                    continue;
                }
                // 파티션이 설치되있으면 무시
                if (place[nr].charAt(nc) == 'X') {
                    continue;
                }

                visited[nr][nc] = true; // 방문처리
                queue.add(new Point(nr, nc, curr.dist + 1)); // 큐에 추가
            }
        }
        return true;
    }

    class Point {
        int row;
        int col;
        int dist;

        public Point(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
}
