package boj.not_classified;
import java.io.*;
import java.util.*;
public class boj10431 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1.학생 배열을 받는다
        // 2. 줄을 세울 동적 배열을 선언
        // 3. 학생배열을 순회
        // 3-1. 만약 줄 배열이 비어있다면 그냥 추가
        // 3-2. 비어있지않다면 줄 배열을 순회 자신보다 큰 학생이 있다면 그 자리에 삽입
        // 3-3. 줄 배열의 크기 - 삽입된 인덱스로 => 뒤로 물러서는 횟수
        // 물러서는 횟수를 더해준다.
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i = 1; i <= t; i++){
            int[] students = new int[20];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for(int j = 0; j < 20; j++){
                students[j] = Integer.parseInt(st.nextToken());
            }
            ArrayList<Integer> line = new ArrayList<>();
            int moves = 0;
            for(int j = 0; j < 20; j++){
                int now = students[j];
                if(line.isEmpty()){
                    line.add(now);
                }
                else{
                    boolean added = false;
                    for(int k = 0; k < line.size(); k++){
                        if(line.get(k) > now){
                            moves += (line.size() - k);
                            added = true;
                            line.add(k, now);
                            break;
                        }
                    }
                    if(!added){
                        line.add(now);
                    }
                }
            }
            sb.append(n + " "+ moves + "\n");
        }
        System.out.println(sb.toString());
    }
}
