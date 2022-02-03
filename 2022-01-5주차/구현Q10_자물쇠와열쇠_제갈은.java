package Week10;

public class NDB_자물쇠와열쇠 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution s = new Solution();
		int [][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int [][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 0}};
		
		System.out.println(s.solution(key, lock));
	
	}

}

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int point = key.length - 1; 
        // 맨처음 좌물쇠와 키가 겹치는 부분 (key의 맨 오른쪽 밑)
        for(int x = 0; x < point + lock.length; x++) { 
            for(int y = 0; y < point + lock.length; y++) {
                // key를 이동시킬 때 이동거리는 겹치는 부분 + 자물쇠의 크기
            	
                for(int r = 0; r < 4; r++) {
                	// key를 회전시킨다.
                    int[][] newLock = new int[lock.length + key.length * 2][lock.length + key.length * 2]; 
                    // 회전시키면서 새로운 arr생성해서 key의 값을 복사한다.
                    for(int i = 0; i < lock.length; i++) {
                        for(int j = 0; j < lock.length; j++) {
                            newLock[i + point][j + point] = lock[i][j]; 
                            // 새로운 arr에 lock 값 복사한다.
                        }
                    }
                    match(newLock, key, r, x, y);  //newLock배열에 key 배열을 이동, 회전하면서 더해준다.
                    if(check(newLock, point, lock.length)) return true; 
                }
            }
        }
        return false;
    }
    
    public void match(int[][] newLock, int[][] key, int rot, int x, int y) {
        int len = key.length;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(rot == 0) { 
                	// 회전하지 않았을 경우
                    newLock[x + i][y + j] += key[i][j];
                } else if(rot == 1) { //시계방향으로 90도 회전한 경우
                    newLock[x + i][y + j] += key[j][len - i - 1];
                } else if(rot == 2) { //180도 회전한 경우
                    newLock[x + i][y + j] += key[len - i - 1][len- j - 1];
                } else { //270도 회전한 경우
                    newLock[x + i][y + j] += key[len - j - 1][i];
                }
            }
        }
    }
    
    public boolean check(int[][] newLock, int point, int len) {
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(newLock[point + i][point + j] != 1) return false; 
            }
        }
        return true;
    }
}
