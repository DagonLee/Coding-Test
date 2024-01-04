// https://school.programmers.co.kr/learn/courses/30/lessons/250136
import java.util.*;
class Solution {
    public int solution(int[][] land) {
        //1. 가로 크기 만큼 순회
        //2. 세로로 탐색하여 석유 덩어리 발견시 bfs로 체크
        //3. bfs로 순회 하며 석유 존재하는 칸을 세면서, 해당 열의 인덱스를 set에 저장
        //4. set에 포함된 index에 해당되는 oilCnt 배열에 카운트 더해주기 
        //3. oilCnt에서 가장 큰 값 반환
        int n = land.length;
        int m = land[0].length;
        boolean[][] check = new boolean[n][m];
        int[] oilCnt = new int[m];
        for(int j = 0; j < m; j++){
            Queue<int[]> q = new LinkedList<>();
            int cnt = 0;
            HashSet<Integer> set = new HashSet<>();
            
            for(int i = 0; i< n; i++){
                int now = land[i][j];
                set.clear();
                if(now == 1 && !check[i][j]){
                    set.add(j);
                    q.add(new int[]{i, j});
                    check[i][j] = true;
                    cnt = 1;
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        int[] dx = {-1, 0, 0, 1};
                        int[] dy = {0, -1, 1, 0};
                        for(int d = 0; d < 4; d++){
                            int nx = cur[0] + dx[d];
                            int ny = cur[1] + dy[d];
                            if(nx < 0 || n <= nx || ny < 0 || m <= ny ){
                                continue;
                            }
                            if(check[nx][ny] || land[nx][ny] == 0){
                                continue;
                            }
                            check[nx][ny] = true;
                            q.add(new int[]{nx, ny});
                            set.add(ny);
                            cnt++;
                        }
                    }
                }
                if(cnt > 0){
                    Iterator <Integer> it = set.iterator();
                    while(it.hasNext()){
                       oilCnt[it.next()] += cnt; 
                    }
                }
            }
            
        }
        return Arrays.stream(oilCnt).max().getAsInt();
    }
}