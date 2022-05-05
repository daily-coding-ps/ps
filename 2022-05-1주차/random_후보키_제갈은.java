import java.util.*;
class Solution {
    
    static boolean visited[];
    static ArrayList<String> candi = new ArrayList<>();
    
    public int solution(String[][] relation) {
        int answer = 0;
        visited = new boolean[relation[0].length];
        
        for(int i=0;i<visited.length;i++){
            dfs(relation, i+1, 0);
        }
        answer=candi.size();
        return answer;
    }
    
    public static void dfs(String[][] relation, int len, int depth){
        
        if(len==depth){
            String s = "";
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0;i<visited.length;i++){
                if(visited[i]){
                    s+=String.valueOf(i);
                    list.add(i);
                }
            }
            
            HashSet<String> hash = new HashSet<>();
            
            for(int i=0;i<relation.length;i++){
                String d = "";
                for(Integer j : list){
                    d+=relation[i][j];
                }
                
                if(hash.contains(d)){
                    return;
                }else {
                    hash.add(d);
                }
            }
            
            for(String check : candi){
                int count=0;
                for(int i=0;i<s.length();i++){
                    String temp = String.valueOf(s.charAt(i));
                    if(check.contains(temp)){
                        count++;
                    }
                    if(count==check.length()) return;
                }
            }
            
            candi.add(s);
        }
        else {
            for(int i=0;i<relation[0].length;i++){
                if(!visited[i]){
                    visited[i]=true;
                    dfs(relation, len, depth+1);
                    visited[i]=false;
                }
            }
        }
    }
}
