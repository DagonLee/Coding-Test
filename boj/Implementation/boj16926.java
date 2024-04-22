package boj.Implementation;
import java.io.*;
import java.util.*;
public class boj16926 {
    static int[][] data;
    static int n, m;
    static void rotate(int start, int rowEnd, int colEnd, int r){
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        for(int i = 0; i < r; i++){
            int x = start;
            int y = start;
            int cnt = 0;
            int tmp = data[x][y];
            while(cnt != 4){
                int nx = x + dx[cnt];
                int ny = y + dy[cnt];
                if(nx < start || nx >= rowEnd || ny < start || ny >= colEnd){
                    cnt++;
                    continue;
                }
                data[x][y] = data[nx][ny];
                x = nx;
                y = ny;
            }
            data[x + 1][y] = tmp;
            
        }
        // for(int i = 0; i < n; i++){
        //     System.out.println(Arrays.toString(data[i]));
        // }
        // System.out.println();
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int r;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        data = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < Math.min(n, m)/ 2; i++){
            rotate(i, n - i, m - i, r);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}
