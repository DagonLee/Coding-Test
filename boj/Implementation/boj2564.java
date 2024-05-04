package boj.Implementation;

import java.io.*;
import java.util.*;

public class boj2564 {
    static int d_dir;
    static int d_dist;
    static int n, m;
    static int calculate(int dir, int dist){
        if(dir == d_dir){
            return Math.abs(dist - d_dist);
        }

        if(d_dir == 1){
            if(dir == 2){
                return Math.min(dist + d_dist, (m - dist) + (m - d_dist)) + n;
            }
            else if(dir == 3){
                return dist + d_dist;
            }
            else if(dir == 4){
                return m - d_dist + dist;
            }
        }
        else if(d_dir == 2){
            if(dir == 1){
                return Math.min(dist + d_dist, (m - dist) + (m - d_dist)) + n;
            }
            else if(dir == 3){
                return d_dist + (n - dist);
            }
            else if(dir == 4){
                return m - d_dist + n - dist;
            }
        }
        else if(d_dir == 3){
            if(dir == 1){
                return dist + d_dist;
            }
            else if(dir == 2){
                return n - d_dist + dist;
            }
            else if(dir == 4){
                return Math.min(dist + d_dist, (n - dist) + (n - d_dist)) + m;
            }
        }
        else if(d_dir == 4){
            if(dir == 1){
                return d_dist + (m - dist);
            }
            else if(dir == 2){
                return (n - d_dist) + (m - dist);
            }
            else if(dir == 3){
                return Math.min(dist + d_dist, (n - dist) + (n - d_dist)) + m;
            }
        }
        return -1;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        //1 : 북, 2: 남, 3 : 서, 4 : 동

        int t = Integer.parseInt(br.readLine());
        int[][] shops = new int[t][2];
        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            shops[i][0] = dir;
            shops[i][1] = dist;
        }
        st = new StringTokenizer(br.readLine());
        d_dir = Integer.parseInt(st.nextToken());
        d_dist = Integer.parseInt(st.nextToken());
        int ans = 0;
        for(int i = 0; i < t; i++){
            int val = calculate(shops[i][0], shops[i][1]);
            ans += val;
        }
        System.out.println(ans);
    }
}
