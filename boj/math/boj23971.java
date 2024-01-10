package boj.math;

import java.util.*;
import java.io.*;
public class boj23971 {
    public static void main(String[] args) throws Exception{
        int h, w, n, m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        // 실수 값으로 나타내기 위해 (double) 로 타입 캐스팅
        double c = Math.ceil(w / (double)(m + 1));
        double r = Math.ceil(h / (double)(n + 1));
        System.out.println((int)(r * c));
    }
}
