import java.util.*;
class Solution {
    static boolean visited[];
    static boolean flag=false;
    static HashSet<String> hash;
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        visited = new boolean[user_id.length];
        hash = new HashSet<>();
        dfs(user_id,banned_id, 0);
        answer=hash.size();
        return answer;
    }
    
    public static void dfs(String[] user_id, String[] banned_id, int len){
        
        if(len==banned_id.length){
            // 2개를 뽑았을 때
            String s = "";
            for(int i=0;i<user_id.length;i++){
                if(visited[i]){
                    s+=user_id[i];
                }
            }
            hash.add(s);
            return;
        }else {
            for(int i=0;i<user_id.length;i++){
                flag=false;
                if(!visited[i]){
                    if(user_id[i].length()==banned_id[len].length()){
                        // 길이가 같다면
                        for(int j=0;j<user_id[i].length();j++){
                            if(user_id[i].charAt(j)==banned_id[len].charAt(j)){
                                continue;
                            }else if(banned_id[len].charAt(j)=='*'){
                                continue;
                            }else {
                                //문자가 다를 때
                                flag=true;
                                break;
                            }
                        }
                        
                        if(!flag){
                        // 제재 아이디라면
                        visited[i]=true;
                        dfs(user_id, banned_id, len+1);
                        visited[i]=false;
                        }
                    }
                }
            }
        }
    }
}
