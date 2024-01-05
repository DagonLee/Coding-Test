//문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/250134 
import java.util.*;
class Solution {
    int[] redStart = new int[2];
    int[] redTarget = new int[2];
    int[] blueStart = new int[2];
    int[] blueTarget = new int[2];
    int[][] copy;
    int[] dx = {-1, 0, 0, 1};
    int[] dy = {0, -1, 1, 0};
    int n, m;
    int ans = Integer.MAX_VALUE;
    boolean[][] redCheck;
    boolean[][] blueCheck;
    public void backTrack(int[] red, int[] blue, int cnt){
        // System.out.println("현재 상태" + cnt);
        // System.out.println("red" + red[0] +"," + red[1]);
        // System.out.println("blue" + blue[0] +"," + blue[1]);
        // System.out.println();
        if(red[0] == redTarget[0] && red[1] == redTarget[1] && blueTarget[0] == blue[0] && blue[1] == blueTarget[1]){
            ans = Math.min(ans, cnt);
            return;
        }

        if(red[0] == redTarget[0] && red[1] == redTarget[1]){
            for(int bd = 0; bd < 4; bd++){
                int nbx = blue[0] + dx[bd];
                int nby = blue[1] + dy[bd];
                if(nbx < 0 || n <= nbx || nby < 0 || m <= nby){ //범위 초과시
                    continue;
                }
                if(blueCheck[nbx][nby] || copy[nbx][nby] == 5){ // 이미 방문한 경우 혹은 벽인 경우
                    continue;
                }
                if(nbx == red[0] && nby == red[1]){ // 다른 수레가 이미 있는 경우
                    continue;
                }
                blueCheck[nbx][nby] = true;
                backTrack(new int[]{red[0], red[1]}, new int[]{nbx, nby}, cnt + 1);
                blueCheck[nbx][nby] = false;
            }                        
        }
        else if(blue[0] == blueTarget[0] && blue[1] == blueTarget[1]){
            for(int rd = 0; rd < 4; rd++){
                int nrx = red[0] + dx[rd];
                int nry = red[1] + dy[rd];
                if(nrx < 0 || n <= nrx || nry < 0 || m <= nry){ //범위 초과시
                    continue;
                }
                if(redCheck[nrx][nry] || copy[nrx][nry] == 5){ // 이미 방문한 경우 혹은 벽인 경우
                    continue;
                }
                if(nrx == blue[0] && nry == blue[1]){ // 다른 수레가 이미 있는 경우
                    continue;
                }
                redCheck[nrx][nry] = true;
                backTrack(new int[]{nrx, nry}, new int[]{blue[0], blue[1]}, cnt + 1);
                redCheck[nrx][nry] = false;
            }
        }
        else{
            for(int rd = 0; rd < 4; rd++){
                int nrx = red[0] + dx[rd];
                int nry = red[1] + dy[rd];
                if(nrx < 0 || n <= nrx || nry < 0 || m <= nry){ //범위 초과시
                    continue;
                }
                if(redCheck[nrx][nry] || copy[nrx][nry] == 5){ // 이미 방문한 경우
                    continue;
                }
                if(nrx == blue[0] && nry == blue[1]){ // 다른 수레가 이미 있는 경우
                    continue;
                }
                redCheck[nrx][nry] = true;
                for(int bd = 0; bd < 4; bd++){
                    int nbx = blue[0] + dx[bd];
                    int nby = blue[1] + dy[bd];
                    if(nbx < 0 || n <= nbx || nby < 0 || m <= nby){ //범위 초과시
                        continue;
                    }
                    if(blueCheck[nbx][nby] || copy[nbx][nby] == 5){ // 이미 방문한 경우 혹은 벽인 경우
                        continue;
                    }
                    if(nbx == nrx && nby == nry){ // 다른 수레가 이미 있는 경우
                        continue;
                    }
                    blueCheck[nbx][nby] = true;
                    backTrack(new int[]{nrx, nry}, new int[]{nbx, nby}, cnt + 1);
                    blueCheck[nbx][nby] = false;
                }
                redCheck[nrx][nry] = false;
            }
            for(int bd = 0; bd < 4; bd++){
                int nbx = blue[0] + dx[bd];
                int nby = blue[1] + dy[bd];
                if(nbx < 0 || n <= nbx || nby < 0 || m <= nby){ //범위 초과시
                    continue;
                }
                if(blueCheck[nbx][nby] || copy[nbx][nby] == 5){ // 이미 방문한 경우
                    continue;
                }
                if(nbx == red[0] && nby == red[1]){ // 다른 수레가 이미 있는 경우
                    continue;
                }
                blueCheck[nbx][nby] = true;
                for(int rd = 0; rd < 4; rd++){
                    int nrx = red[0] + dx[rd];
                    int nry = red[1] + dy[rd];
                    if(nrx < 0 || n <= nrx || nry < 0 || m <= nry){ //범위 초과시
                        continue;
                    }
                    if(redCheck[nrx][nry] || copy[nrx][nry] == 5){ // 이미 방문한 경우 혹은 벽인 경우
                        continue;
                    }
                    if(nbx == nrx && nby == nry){ // 다른 수레가 이미 있는 경우
                        continue;
                    }
                    redCheck[nrx][nry] = true;
                    backTrack(new int[]{nrx, nry}, new int[]{nbx, nby}, cnt + 1);
                    redCheck[nrx][nry] = false;
                }
                blueCheck[nbx][nby] = false;
            }
            
        }
        
        
        
        
    }
    public int solution(int[][] maze) {
        int answer = 0;
        n = maze.length;
        m = maze[0].length;
        copy = new int[n][m];
        redCheck = new boolean[n][m];
        blueCheck = new boolean[n][m];
        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[0].length; j++){
                copy[i][j] = maze[i][j];
                if(maze[i][j] == 1){
                    redStart[0] = i;
                    redStart[1] = j;
                }
                else if(maze[i][j] == 2){
                    blueStart[0] = i;
                    blueStart[1] = j;
                }
                else if(maze[i][j] == 3){
                    redTarget[0] = i;
                    redTarget[1] = j;
                }
                else if(maze[i][j] == 4){
                    blueTarget[0] = i;
                    blueTarget[1] = j;
                }
            }
        }
        redCheck[redStart[0]][redStart[1]] = true;
        blueCheck[blueStart[0]][blueStart[1]] = true;
        backTrack(redStart, blueStart, 0);
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}