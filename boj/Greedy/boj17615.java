package boj.Greedy;
import java.io.*;
public class boj17615 {
    /*
     * start 240211 17:46
     * 문제
     * 빨간색과 푸른 색 공이 일직선상에 있다.
     * 공을 옮겨서 같은 색끼리 인접하도록 놓이도록 하라.
     * 규칙
     * 바로 옆의 다른색 공 무더기를 한번에 넘을 수 있다.
     * 한 가지 색을 선택하여 옮겨야한다.
     * 
     * 입력
     * int n: 공 개수
     * String balls :공 문자열
     * 
     * 해결방법
     * 각 색이 인접하도록 하려면 빨 / 파 혹은 파 / 빨이 되어야한다.
     * 두가지 경우를 구분하여 이동의 최솟 값을 확인
     * 
     * 1. 빨, 파의 개수를 센다.
     * 2. 빨/파, 파/빨 두가지 경우를 구분하여 이동 최솟값 확인
     * 3. 빨/파 인 경우 뒤에서 부터 파란 색을 이동시킨다.
     * 4. 파/빨 인 경우 뒤에서 부터 빨간 색을 이동시킨다.
     * 
     * 3 - 1. 빨/파 의 경우 뒤에서 부터 빨간색을 찾는다.
     * 3-2. 최초 빨간 색 부터 앞으로 가면서 파란색을 찾아서 교환, 교환 횟수 +1
     * 3-3. 교환후 3-1,2 반복
     * 
     * 3-1 ~ 3 과정을 색을 바꿔서 진행
     * 18:38 => 15점
     * 
     * 잘못된 접근 인것 같아 다른 사람의 풀이를 참고
     * https://korean-otter.tistory.com/34
     * 
     * 요약
     * 빨/파, 파/빨 두가지 경우를 구분하는 것은 동일
     * 여기서 빨간색, 파란색 움직이는 경우도 구분하여 적용
     * 
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] balls = br.readLine().toCharArray();
        int ans =  Integer.MAX_VALUE;
        int cnt = 0;
        boolean sw = false;
        for(int i = 0; i < n; i++){
            if(balls[i] =='B'){
                sw = true;
            }
            if(sw && balls[i] == 'R'){
                cnt ++;
            }
        }
        ans = Math.min(cnt, ans);
        cnt = 0;
        sw = false;
        for(int i = n - 1; i >= 0; i--){
            if(balls[i] =='B'){
                sw = true;
            }
            if(sw && balls[i] == 'R'){
                cnt ++;
            }
        }
        ans = Math.min(cnt, ans);
        cnt = 0;
        sw = false;

        for(int i = 0; i < n; i++){
            if(balls[i] =='R'){
                sw = true;
            }
            if(sw && balls[i] == 'B'){
                cnt ++;
            }
        }
        ans = Math.min(cnt, ans);
        cnt = 0;
        sw = false;
        for(int i = n - 1; i >= 0; i--){
            if(balls[i] =='R'){
                sw = true;
            }
            if(sw && balls[i] == 'B'){
                cnt ++;
            }
        }
        ans = Math.min(cnt, ans);
        cnt = 0;
        sw = false;
        
        
        System.out.println(ans);
    }
}
