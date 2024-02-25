package boj.math;
import java.io.*;
public class boj1676 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(n / 5 + n / 25 + n / 125);
    }
}

