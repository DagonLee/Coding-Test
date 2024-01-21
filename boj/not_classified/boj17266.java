package boj.not_classified;

import java.io.*;
import java.util.StringTokenizer;

public class boj17266 {
    //Start : 240121 16:32
    //1st try: 16:41 => fail, didn't thinked about the edge case(start, end) 
    //2nd try: 16:45 => fail, wrong use of dividing part(line 25)
    //3rd try: 16:47 => success
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n; // 굴다리의 길이
        int m; // 가로등의 개수
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        int[] idxs = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            idxs[i] = Integer.parseInt(st.nextToken());
        }
        int dist = idxs[0]; // 가로등 사이의 거리의 최솟 값
        int now = 0; // 현재 위치
        for(int i = 1; i < m; i++){
            dist = Math.max((int)Math.ceil((double)(idxs[i] - now) / 2), dist);
            now = idxs[i];
        }

        // 굴다리의 끝과 비교
        dist = Math.max(n - idxs[m - 1], dist);
        System.out.println(dist);

    }
}
