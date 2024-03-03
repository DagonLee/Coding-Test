package boj.Implementation;
import java.io.*;
public class boj1475 {
    /*
    240303 14:43
     * 문제
     * 방번호가 주어지고 방번호를 플라스틱 숫자로 만들어야한다.
     * 숫자는 0~9 한세트로 주어진다.단,6과 9는 서로 뒤집어서 이용가능)
     * 필요한 세트 개수의 최솟값을 출력하시오
     * 
     * 해결방법
     * 1. 각 숫자별 등장횟수를 저장
     * 2. 가장 많이 나오는 숫자를 기준으로 세트의 개수를 식별
     *    단, 가장 많이 나오는 수가 6또는 9라면 서로의 등장 횟수 차이를 식별
     *    6 : 2번 9 : 4번 =>  4 - 2 / 2
     *    6또는 9중 등장 횟수의 최대 - 등장 횟수의 최소 / 2 의 올림
     * 
     * 1차 시도 틀림 =>
     * 반례 찾음 : 6666777799
     * 
     * 6,9가 같다고 생각하고 풀면 된다.
     * 77779999 반례 찾음 => 다시 풀이 완료 
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] nums = br.readLine().toCharArray();
        int[] cnt = new int[10];
        for(char c : nums){
            cnt[c - '0'] += 1;
        }
        cnt[6] = cnt[9] = Math.min(cnt[6], cnt[9]) + (int)Math.ceil((double)(Math.max(cnt[6], cnt[9]) - Math.min(cnt[6], cnt[9])) / 2);

        int idx = -1;
        int max = -1;
        for(int i = 0; i < 10; i++){
            if(max < cnt[i]){
                max = cnt[i];
                idx = i;
            }
        }

        System.out.println(max);
    }
}
