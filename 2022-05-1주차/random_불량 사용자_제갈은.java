import java.util.*;
class Solution {
    
    static boolean visited[];
    static HashSet<String> hash;
    static boolean flag;
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        visited = new boolean[user_id.length];
        hash = new HashSet<>();
        flag = false;
        dfs(user_id,banned_id, 0);
        answer=hash.size();
        return answer;
    }
    
    public static void dfs(String[] user_id, String[] banned_id, int idx) {
        
        if(idx==banned_id.length){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<user_id.length;i++){
                if(visited[i]){
                    sb.append(user_id[i]);
                }
            }
            hash.add(sb.toString());
            return;
        }else {
            for(int i=0;i<user_id.length;i++){
                if(!visited[i]){
                    if(user_id[i].length()==banned_id[idx].length()){
                        // 문자열의 길이가 같다면
                        flag=false;
                        for(int j=0;j<user_id[i].length();j++){
                            if(banned_id[idx].charAt(j)=='*') continue;
                            if(user_id[i].charAt(j)!=banned_id[idx].charAt(j)){
                                flag=true;
                                break;
                            }
                         }
                        if(!flag){
                            // 문자열이 다 같다면
                            visited[i]=true;
                            dfs(user_id, banned_id, idx+1);
                            visited[i]=false;
                        }
                    }
                }
            }
        }
    } 
}
