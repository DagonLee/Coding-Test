package boj.Graph;

import java.io.*;
import java.util.*;


public class boj2583 {
    static boolean[][] checked;
    static int m, n, k;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int calculate(int x, int y){
        int cnt = 1;
        checked[x][y] = true;
        

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int d = 0; d < 4; d++){
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                if(nx < 0 || m <= nx || ny < 0 || n <= ny){
                    continue;
                }
                if(checked[nx][ny]){
                    continue;
                }
                cnt++;
                checked[nx][ny] = true;
                q.add(new int[] {nx, ny});
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); //세로 x, m
        n = Integer.parseInt(st.nextToken()); // 가로 y, n
        k = Integer.parseInt(st.nextToken());
        
        checked = new boolean[m][n];
        for(int t = 0; t < k; t++){
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            for(int i = x1; i < x2; i++){
                for(int j = y1; j < y2; j++){
                    checked[i][j] = true;
                }
            }
        }
        ArrayList<Integer> sizes = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!checked[i][j]){
                    sizes.add(calculate(i,j));
                }
            }
        }
        Collections.sort(sizes);
        System.out.println(sizes.size());
        for(int size : sizes){
            System.out.print(size + " ");
        }
    }
}
