package boj.Graph;

import java.io.*;
import java.util.*;

public class boj1926 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] picture = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                picture[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[][] checked = new boolean[n][m];
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(picture[i][j] == 1 && !checked[i][j]){
                    checked[i][j] = true;
                    int cnt = 0;
                    ArrayDeque<int[]> q = new ArrayDeque<>();
                    q.addLast(new int[]{i ,j });
                    while(!q.isEmpty()){
                        int[] now = q.pollFirst();
                        cnt++;
                        for(int d = 0; d < 4; d++){
                            int nx = now[0] + dx[d];
                            int ny = now[1] + dy[d];
                            if(nx < 0 || n <= nx || ny < 0 || m <= ny){
                                continue;
                            }
                            if(picture[nx][ny] == 0){
                                continue;
                            }
                            if(checked[nx][ny]){
                                continue;
                            }
                            checked[nx][ny] = true;
                            q.addLast(new int[] {nx, ny});
                        }
                    }
                    lst.add(cnt);
                }
            }
        }
        Collections.sort(lst);
        System.out.println(lst.size());
        if(lst.size() != 0){
            System.out.println(lst.get(lst.size() - 1));
        }
        else{
            System.out.println(0);
        }
    }
}
