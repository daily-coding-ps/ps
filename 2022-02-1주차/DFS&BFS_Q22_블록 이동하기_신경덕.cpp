#include <string>
#include <vector>
#include <queue>
using namespace std;
struct robot{
    int li; // 수평기준은 왼쪽, 수직기준은 위
    int lj;
    int ri; // 수평기준은 오른쪽, 수직기준은 아래
    int rj;
    bool VH;
};

bool visited[101][101][2];

int solution(vector<vector<int>> board) {
    queue<robot> q;
    robot rb = {0,0,0,1,false};
    q.push(rb);
    int answer = 0;
    int N = board.size();
    int M = board[0].size();
    visited[0][0][0] = true;

    while(!q.empty())
    {
       int q_size = q.size();
       
       for(int i=0;i< q_size;i++)
       {
          robot curr = q.front(); q.pop();
          if( (N-1 == curr.li && M-1 == curr.lj )|| (N-1 == curr.ri && M-1 == curr.rj ) ) return answer;
          if(curr.VH == false) // 수평으로 있을때
          {
             if(M > (curr.rj+1) &&!board[curr.ri][curr.rj+1]) // 우측이동
             {
                if(!visited[curr.li][curr.lj+1][0])
                {
                  robot next = {curr.li,curr.lj+1,curr.ri,curr.rj+1,false};
                  q.push(next);
                  visited[curr.li][curr.lj+1][0] = true;
                }
             }
             if(0 <= (curr.lj-1) && !board[curr.li][curr.lj-1])// 왼측이동
             {
                if(!visited[curr.li][curr.lj-1][0])
                {
                  robot next = {curr.li,curr.lj-1,curr.ri,curr.rj-1,false};
                  q.push(next);
                  visited[curr.li][curr.lj-1][0] = true;
                }
             }
             if(N > (curr.li+1) && !board[curr.li+1][curr.lj] && !board[curr.ri+1][curr.rj]) 
             {
                if(!visited[curr.li+1][curr.lj][0])
                {
                  robot next = {curr.li+1,curr.lj,curr.ri+1,curr.rj,false}; // 아래 이동
                  q.push(next);
                  visited[curr.li+1][curr.lj][0] = true;
                }
               
                if(!visited[curr.ri][curr.rj][1])
                {
                  robot next = {curr.ri,curr.rj,curr.ri+1,curr.rj,true}; // 반시계방향 90도 변경 (아래)
                  q.push(next);
                  visited[curr.ri][curr.rj][1] = true;
                }

                if(!visited[curr.li][curr.lj][1])
                {
                  robot next = {curr.li,curr.lj,curr.li+1,curr.lj,true}; // 시계방향 90도 변경 (아래)
                  q.push(next);
                  visited[curr.li][curr.lj][1] = true;
                }
             }
             if(0 <= (curr.li-1) && !board[curr.li-1][curr.lj] && !board[curr.ri-1][curr.rj])
             {
                if(!visited[curr.li-1][curr.lj][0])
                {
                  robot next = {curr.li-1,curr.lj,curr.ri-1,curr.rj,false}; // 위로 이동
                  q.push(next);
                  visited[curr.li-1][curr.lj][0] = true;
                }
                
                if(!visited[curr.ri-1][curr.rj][1])
                {
                  robot next = {curr.ri-1,curr.rj,curr.ri,curr.rj,true}; // 시계방향 90도 변경 (위)
                  q.push(next);
                  visited[curr.ri-1][curr.rj][1] = true;
                }
                if(!visited[curr.li-1][curr.lj][1])
                {
                  robot next = {curr.li-1,curr.lj,curr.li,curr.lj,true}; // 반시계방향 90도 변경 (위)
                  q.push(next);
                  visited[curr.li-1][curr.lj][1] = true;
                }
             }
          }
          else // 수직으로 있을때
          {
             if(N > (curr.ri+1) &&!board[curr.ri+1][curr.rj]) // 아래이동
             {
                if(!visited[curr.li+1][curr.lj][1])
                {
                  robot next = {curr.li+1,curr.lj,curr.ri+1,curr.rj,true};  
                  q.push(next);
                  visited[curr.li+1][curr.lj][1] = true;
                }
             }
             if(0 <= (curr.li-1) &&!board[curr.li-1][curr.lj]) // 위로이동
             {
                if(!visited[curr.li-1][curr.lj][1])
                {
                  robot next = {curr.li-1,curr.lj,curr.ri-1,curr.rj,true};
                  q.push(next);
                  visited[curr.li-1][curr.lj][1] = true;
                }
             }
             if(M > (curr.lj+1) && !board[curr.li][curr.lj+1] && !board[curr.ri][curr.rj+1])
             {
                if(!visited[curr.li][curr.lj+1][1])
                {
                  robot next = {curr.li,curr.lj+1,curr.ri,curr.rj+1,true}; // 우측 이동
                  q.push(next);
                  visited[curr.li][curr.lj+1][1] = true;
                }
                
                if(!visited[curr.ri][curr.rj][0])
                {
                  robot next = {curr.ri,curr.rj,curr.ri,curr.rj+1,false}; // 시계방향으로 90도 변경(우측)
                  q.push(next);
                  visited[curr.ri][curr.rj][0] = true;
                }
                
                if(!visited[curr.li][curr.lj][0])
                {
                  robot next = {curr.li,curr.lj,curr.li,curr.lj+1,false};// 반시계방향으로 90도 변경(우측)
                  q.push(next);
                  visited[curr.li][curr.lj][0] = true;
                }
             } 
             if(0 <= (curr.lj-1) && !board[curr.li][curr.lj-1] && !board[curr.ri][curr.rj-1])
             {
                if(!visited[curr.li][curr.lj-1][1])
                {
                  robot next = {curr.li,curr.lj-1,curr.ri,curr.rj-1,true}; // 왼측 이동
                  q.push(next);
                  visited[curr.li][curr.lj-1][1] = true;
                }
                
                if(!visited[curr.ri][curr.rj-1][0])
                {
                  robot next = {curr.ri,curr.rj-1,curr.ri,curr.rj,false}; // 반시계방향으로 90도 변경(왼측)
                  q.push(next);
                  visited[curr.ri][curr.rj-1][0] = true;
                }
                
                if(!visited[curr.li][curr.lj-1][0])
                {
                  robot next = {curr.li,curr.lj-1,curr.li,curr.lj,false}; // 시계방향으로 90도 변경(오른측)
                  q.push(next);
                  visited[curr.li][curr.lj-1][0] = true;
                }

             }


          }

       }
       answer++;

    }
    
    
    return answer;
}