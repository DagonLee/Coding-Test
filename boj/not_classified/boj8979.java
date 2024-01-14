package boj.not_classified;

import java.io.*;
import java.util.*;
public class boj8979 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()) - 1;
        int[][] medals = new int[n - 1][3];
        int[] stand = new int[3];
        int index = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            if(idx == k){
                stand[0] = gold;
                stand[1] = silver;
                stand[2] = bronze;
                continue;
            }
            medals[index][0] = gold;
            medals[index][1] = silver;
            medals[index][2] = bronze;
            index++;
        }
        int ans = 0;
        for(int i = 0; i < n - 1; i++){
            if(medals[i][0] > stand[0]){
                ans++;
            }
            else if(medals[i][0] == stand[0]){
                if(medals[i][1] > stand[1]){
                    ans++;
                }
                else if(medals[i][1] == stand[1]){
                    if(medals[i][2] > stand[2]){
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans + 1);
    }
}
