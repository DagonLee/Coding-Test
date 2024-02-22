package boj.BruteForce;

import java.io.*;
import java.util.*;
public class boj4179 {
    /*
     * start 240222 08:56
     * 문제
     * r x c 크기의 맵이 주어지고 j는 사람, f는 불아 난 공간이 주어진다.
     * 불에 타기 전에 맵의 끝에 도달하여 탈출 할 수 있는지를 출력하라
     * 
     * 해결방법
     * 1. 현재 지훈이의 위치에서 bfs큐에 다음에 도달할 수 있는 거리들을 추가
     *    다음으로 갈수 있는 조건
     *    0) 현재 칸이 불이 아닌 경우
     *    1) 맵 범위 안
     *    2) 벽이 아닌경우
     *    3) 불이 없는 경우
     * 2. 다음으로는 불이 확산한다. bfs를 이용
     *    1) 다음 좌표가 범위 안인 경우
     *    2) 벽이 아닌 경우
     *    다음 칸을 불로 변경 후 bfs큐에 넣어둔다.
     * 3. 
     * 09:37 => 구현 완료 ,예제 통과
     * 09:44, 예상 케이스 적용하여 수정 => fail
     * 질문 게시판 반례 참조 후 벽에 도달하면 return 하도록 수정 => success
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int r, c;
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        char[][] map = new char[r][c];
        boolean[][] visited = new boolean[r][c];
        int sx = 0;
        int sy = 0;
        ArrayList<int[]> fireList = new ArrayList<>();
        for(int i = 0; i < r; i++){
             map[i] = br.readLine().toCharArray();
             for(int j = 0; j < c; j++){
                if(map[i][j] == 'J'){
                    sx = i;
                    sy = j;
                }
                else if(map[i][j] == 'F'){
                    fireList.add(new int[]{i, j});
                }
             }
        }
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        Deque<int[]> jDeque = new ArrayDeque<>(); // 지훈 큐
        Deque<int[]> fDeque = new ArrayDeque<>(); // 불 큐
        jDeque.addLast(new int[]{sx, sy});
        for(int[] fire : fireList){
            fDeque.addLast(new int[]{fire[0], fire[1]});
        }
        boolean canEscape = false;
        int cnt = 0;
        visited[sx][sy] = true;
        while(!jDeque.isEmpty()){
            cnt++;
            ArrayList<int[]> nextJList = new ArrayList<>();
            while(!jDeque.isEmpty()){
                int[] now = jDeque.pollFirst();
                if(map[now[0]][now[1]] != 'F'){
                    for(int d = 0; d < 4; d++){
                        int nx = now[0] + dx[d];
                        int ny = now[1] + dy[d];
                        if(nx < 0 || r <= nx || ny < 0 || c <= ny ){
                            canEscape = true;
                            System.out.println(cnt);
                            return;
                        }
                        if(visited[nx][ny]){
                            continue;
                        }
                        if(map[nx][ny] =='.' || map[nx][ny] == 'J'){
                            visited[nx][ny] = true;

                            nextJList.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            for(int[] nextj : nextJList){
                jDeque.add(new int[]{nextj[0], nextj[1]});
            }
            ArrayList<int[]> nextList = new ArrayList<>();
            while(!fDeque.isEmpty()){
                int[] now = fDeque.pollFirst();
                for(int d = 0; d < 4; d++){
                    int nx = now[0] + dx[d];
                    int ny = now[1] + dy[d];
                    if(nx < 0 || r <= nx || ny < 0 || c <= ny ){
                        continue;
                    }
                    if(map[nx][ny] =='#' || map[nx][ny] == 'F'){
                        continue;
                    }
                    map[nx][ny] = 'F';
                    nextList.add(new int[]{nx, ny});
                }
            }
            for(int[] next : nextList){
                fDeque.addLast(new int[]{next[0], next[1]});
            }
        }
        if(canEscape){
            System.out.println(cnt);
        }
        else{
            System.out.println("IMPOSSIBLE");
        }
    }
}
