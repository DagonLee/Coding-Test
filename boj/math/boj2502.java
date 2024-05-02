package boj.math;

import java.io.*;
import java.util.*;

public class boj2502 {
    /*
     * 1 : a 2
     * 2 : b 26
     * 3 : a + b 28
     * 4 : a + 2b 54
     * 5 : 2a + 3b 82
     * 6 : 3a + 5b 136
     * 7 : 5a + 8b 218
     * 8 : 8a + 13b 
     * 9 : 13a + 21b
     * 10: 21a + 39b
     * 11: 34a + 60b
     * 12: 55a + 99b
     * 
     * 
     */
    static class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d, k;
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        Pair[] days = new Pair[d + 1];
        days[1] = new Pair(1, 0);
        days[2] = new Pair(0, 1);
        for(int day = 3; day <= d; day++){
            days[day] = new Pair(days[day - 1].first + days[day - 2].first, days[day - 1].second + days[day - 2].second);
        }
        for(int i = 1; i <= k; i++){
            for(int j = 1; j<= k; j++){
                if(days[d].first * i + days[d].second * j == k){
                    System.out.println(i);
                    System.out.println(j);
                    return;
                }
            }
        }

    }
}
