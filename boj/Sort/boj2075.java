package boj.Sort;

import java.io.*;
import java.util.*;

public class boj2075 {
    /*
     * start 240206 20:58
     * 문제
     * n * n 표에 수가 채워져 있다.
     * 모든 수는 자신의 한 칸 위에 있는 수 보다 크다
     * n 번째 큰수를 구하라
     * 
     * 해결 방법
     * 모든 수를 배열에 넣고 정렬 후 n번 째 수를 출력한다.
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                nums.add(Integer.parseInt(st.nextToken()));
            }
        }
        Collections.sort(nums, Collections.reverseOrder());
        System.out.println(nums.get(n - 1));
    }
}
