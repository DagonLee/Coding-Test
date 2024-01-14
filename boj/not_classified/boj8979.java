package boj.not_classified;

import java.io.*;
import java.util.*;
public class boj8979 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()) - 1;
        int[][] medals = new int[n][4];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
        
            medals[idx][0] = idx;
            medals[idx][1] = gold;
            medals[idx][2] = silver;
            medals[idx][3] = bronze;
        }
        Arrays.sort(medals, (o1, o2) ->{
            if(o1[1] == o2[1]){
                if(o1[2] == o2[2]){
                    return o2[3] - o1[3];
                }
                return o2[2] - o1[2];
            }
            return o2[1] - o1[1];
        });
       
        for(int i = 0; i < n; i++){
            if(medals[i][0] == k){
                int dest = i;
                while(dest >= 1 && medals[dest - 1][1] == medals[dest][1] && medals[dest - 1][2] == medals[dest][2] && medals[dest - 1][3] == medals[dest][3]){
                    dest --;
                }
                System.out.println(dest + 1);
                break;
            }
        }
    }
}
