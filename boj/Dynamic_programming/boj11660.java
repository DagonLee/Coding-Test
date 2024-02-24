package boj.Dynamic_programming;
import java.io.*;
import java.util.*;
public class boj11660 {
    /*
     * 240224 11:31
     * 
     * 1 3 6
     * 3 9 19
     * 6 19 43
     * 
     * 증복을 빼주는 아이디어를 생각하지 못함 
     * 풀이 참고하여 해결 => 12:12
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][n + 1];
        StringBuilder sb = new StringBuilder();
        int[][] accum = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                accum[i][j] = arr[i][j];
                accum[i][j] += accum[i][j - 1];
                accum[i][j] += accum[i - 1][j];
                accum[i][j] -= accum[i - 1][j - 1];
            }
        }
        // for(int i = 1; i<= n; i++){
        //     for(int j = 1; j <= n; j++){
        //         System.out.print(accum[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int val = accum[x2][y2] - accum[x2][y1 - 1] - accum[x1 - 1][y2] + accum[x1 - 1][y1 - 1] ;
            // System.out.println("끝값: "+  arr[x2][y2]);
            // System.out.println("왼쪽: " + arr[x2][y1 - 1]);
            // System.out.println("오른쪽: " + arr[x1 - 1][y2]);

            sb.append(val+"\n");
        }
        System.out.println(sb.toString());
    }
}
