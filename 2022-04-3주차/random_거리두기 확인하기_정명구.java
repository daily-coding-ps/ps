import java.util.*;

class Solution {

	static final int dx[] = {0, 0, 1, -1};
	static final int dy[] = {1, -1, 0, 0};
	static int[][] check;
	static char[][] map;
	static int n = 5;
	static class Node{
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public int[] solution(String[][] places) {
		int[] answer = new int[n];

		int i = 0;
		for (String[] place : places) {
			answer[i] = func(place);
			i++;
		}

		return answer;
	}


	static int func(String[] place) {
		check = new int[n][n];
		map = new char[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = place[i].charAt(j);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'P') {
					if (!bfs(i, j)) {
						return 0;
					}
				}
			}
		}
		return 1;
	}

	static boolean bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		check = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(check[i], -1);
		}

		q.add(new Node(x, y));
		check[x][y] = 0;

		while (!q.isEmpty()) {
			Node now = q.poll();
			x = now.x;
			y = now.y;



			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if (0 <= nx && nx < n && 0 <= ny && ny < n) {
					if (map[nx][ny] != 'X' && check[nx][ny] == -1) {
						check[nx][ny] = check[x][y] + 1;
						if (map[nx][ny] == 'P' && check[nx][ny] <= 2) {
							return false;
						}
						q.add(new Node(nx, ny));
					}
				}
			}
		}

		return true;
	}
}