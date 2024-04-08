package boj.math;
import java.io.*;
import java.util.*;

public class boj2163 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int ans = 0;
        ans += (n * (m - 1));
        ans += (n - 1);
        System.out.println(ans);
    }
}
