package 이코테.Simulation;

public class simulQ4 {
    public static void main(String[] args) {

        Solution sol = new Solution();

        int[][] key = {{0, 0, 0} , {1,0,0} , {0,1,1}};
        int[][] lock = {{1, 1, 1} , {1,1,0} , {1,0,1}};
        sol.solution(key, lock);
    }

    static class Solution {
        public boolean solution(int[][] key, int[][] lock) {
            boolean answer = true;
            int offset = key.length - 1;

            for (int r = 0; r < offset + lock.length; r++) {
                for (int c = 0; c < offset + lock.length; c++) {
                    for(int rot = 0; rot< 4; rot++) {  //4방향 회전
                        int[][] arr = new int[58][58]; // 입력된 값의 최대 크기

                        for (int i = 0; i < lock.length; i++) { // 자물쇠 입력값 복사
                            for (int j = 0; j < lock.length; j++) {
                                arr[offset + i][offset + j]  = lock[i][j];
                            }
                        }

                        match(arr, key, rot, r, c);
                        if(check(arr, offset, lock.length)){
                            return true;
                        }
                    }
                }
            }

            return false;
        }

        private boolean check(int[][] arr, int offset, int length) {

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if(arr[i + offset][j + offset] != 1){
                        return false;
                    }
                }
            }
            return true;
        }

        private void match(int[][] arr, int[][] key, int rot, int r, int c) {
            int n = key.length;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(rot == 0){
                        arr[r + i][c + j] += key[i][j];
                    } else if (rot == 1) {
                        arr[r + i][c + j] += key[j][n - 1 - i];
                    } else if (rot == 2) {
                        arr[r + i][c + j] += key[n - 1 - i][n - 1 - j];
                    } else {
                        arr[r + i][c + j] += key[n - 1 - j][i];
                    }
                }
            }
        }

    }
}

