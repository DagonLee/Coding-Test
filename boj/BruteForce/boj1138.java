package boj.BruteForce;


import java.io.*;
import java.util.StringTokenizer;

public class boj1138 {
    /*
     * start 240207 17:15
     * 문제
     * n 명의 사람이 일렬로 줄을 슨다.
     * 사람들은 자신보다 큰 사람이 왼쪽에 몇명 있는지 기억한다.
     * 사람들의 키는 1 ~ n까지로 모두 다르다.
     * 첫째 줄에 사람의 수(n) 이 주어지고
     * 둘째 줄에는 키가 1 인 사람 부터 자기보다 큰 사람이 왼쪽에 몇명 있는지 주어진다.
     * 
     * 해결방법
     * 1. 줄 설 수 있는 모든 경우의 수를 탐색 => 17:37 구현
     * 2. 주어진 상황에 맞다면 출력
     * 구현 완료 및 예제 테스트 이상없음 =>17:43
     * 
     * 엣지 케이스 탐색
     * 입력이 1인 경우 => 완료
     * 17:45 => 성공
     */
    static int n;
    static int[] line;
    static int[] rule;
    static boolean[] checked;
    public static boolean check(){
        for(int i = 1; i <= n; i++){
            int height = line[i]; // 현재 확인할 사람의 키
            int standard = rule[height]; // 현재 확인할 사람의 왼쪽에 있어야하는 키 큰 사람의 수
            int cnt = 0;
            for(int j = 1; j < i; j++){
                if(line[j] > height){
                    cnt ++;
                }
            }
            if(cnt != standard){
                return false;
            }

        }
        return true;
    }
    public static void factorial(int cnt){
        if(cnt == n + 1){
            if(check()){
                for(int i = 1; i <=n; i++){
                    System.out.print(line[i]+" ");
                }
                System.out.println();
            }
            return;
        }
        for(int i = 1; i <= n; i++){
            if(checked[i]){
                continue;
            }
            checked[i] = true;
            line[cnt] = i;
            factorial(cnt + 1);
            checked[i] = false;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        line = new int[n + 1];
        rule = new int[n + 1];
        checked = new boolean[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<= n; i++){
            rule[i] = Integer.parseInt(st.nextToken());
        }
        factorial(1);
    }
}
