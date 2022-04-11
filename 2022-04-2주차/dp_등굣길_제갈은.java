class Solution3 {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int mod = 1000000007;
        int [][] street = new int[n+1][m+1];
        
        for(int i=0;i<puddles.length;i++) {
        	street[puddles[i][1]][puddles[i][0]]=-1;
        	// 웅덩이는 -1로 표시
        }
        
        street[1][1]=1;
        
        for(int i=1;i<n+1;i++) {
        	for(int j=1;j<m+1;j++) {
        		// 웅덩이라면
              	if(street[i][j]==-1) continue;
              	// 웅덩이가 아니라면
              	if(street[i-1][j]>0) street[i][j]+=street[i-1][j]%mod; // 위
              	if(street[i][j-1]>0) street[i][j]+=street[i][j-1]%mod; // 왼쪽
        	}
        }
        
        return street[n][m]%mod;
    }
}
