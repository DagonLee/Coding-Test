package boj.BruteForce;


import java.io.*;
import java.util.*;

public class boj14940 {
    /*
     * start 240207 22:12
     * 문제
     * 세로 n, 가로 m 인 지도가 주어지고 모든 지점에 대해서 목표지점까지의 거리를구하라
     * 0은 갈 수 없는 땅, 1은 갈 수 있는 땅, 2는 목표지점
     * 해결방법
     * 목표지점을 기준으로 bfs를 이용하여 바이러스가 퍼지듯이 거리 구하기
     * 
     * 원래 갈수 있는 땅 중 도달 할 수 없는 위치는 -1 출력
     * 구현 완료 22:36
     * 1st try => fail
     * 반례 탐색
     * 범위 초과 분기 y축을 n으로 둠 => m으로 수정
     * 2nd try => success 22:44
     */
    public static class land{
        int x;
        int y;
        int distance;
        public land(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int start_x = 0;
        int start_y = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    start_x = i;
                    start_y = j;
                }
            }
        }
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        int[][] dist = new int[n][m];
        Deque<land> q = new LinkedList<>();
        q.add(new land(start_x, start_y, 0));
        while(!q.isEmpty()){
            land now = q.poll();
            for(int i = 0; i < 4; i++){
                int next_x = now.x + dx[i];
                int next_y = now.y + dy[i];
                if(next_x < 0 || n <= next_x || next_y < 0 || m <= next_y){
                    continue;
                }
                if(next_x == start_x && next_y == start_y){
                    continue;
                }
                if(map[next_x][next_y] == 1 && dist[next_x][next_y] == 0){
                    dist[next_x][next_y] = now.distance + 1;
                    q.add(new land(next_x, next_y, now.distance + 1));
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // 원래 갈수 있는 땅 중 도달 할 수 없는 위치는 -1 출력
                if(dist[i][j] == 0 && map[i][j] == 1){
                    System.out.print(-1 + " ");
                }
                else{
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
