package boj.BinarySearch;
import java.io.*;
import java.util.*;
public class boj2467 {
    /*
     * start 240215 17:43
     * 
     * 문제
     * n개의 용액이 주어지고 이중 2개를 선택하여 0에 가장 가까운 수를 만드는 두 용액을 찾아라
     * 
     * 해결방법
     * 1. n개의 수를 리스트에 넣고 정렬
     * 2. 투포인터를 사용하여 탐색, ans는 최적의 용액 합, 만약 최적의 용액 합 보다 절댓값이 작디면 두 용액의 합을 저장한다.
     * 
     * 여러가지 경우를 고려해야한다.
     * 1. 모두 음수인 경우
     * 가장 큰 두 수가 0에 가까움
     * 2. 모두 양수인 경우
     * 가장 작은 두수 가 0에 가까움
     * 3. 음수, 양수가 모두 있는 경우
     * 이때는 투 포인터를 이용한 탐색이 필요
     * 왼쪽 포인터 : left
     * 오른쪽 포인터 : right
     * 
     * 
     * ans 초기값은 Integer MAX
     * left, right 값의 합의 절댓값과 ans를 비교하여 작다면 ans를 left + right로 갱신
     * 
     * left, right 값의 합이 0 보다 크다면
     * right -= 1
     * 0보다 작다면 
     * left += 1
     * left < right 일때까지 반복
     * 
     * 17:56설계 완료
     * 18:12 => 완성 => fail
     * 
     * left, right 값이 0인 경우 처리 숭정
     * 절댓값을 처리한 값을 val로 두고 비교해서 틀린것으로 에상 18:25
     * 
     * 절댓값 처리 오류 수정, 18:27 => succdss
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] liquids = new int[n];
        int ans = Integer.MAX_VALUE;
        int ansLeft = 0;
        int ansRight = n - 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            liquids[i] = Integer.parseInt(st.nextToken());
        }
        if(liquids[0] < 0 && liquids[n - 1] < 0){
            System.out.println(liquids[n - 2]+ " " + liquids[n - 1]);
        }
        else if(liquids[0] > 0 && liquids[n - 1] > 0){
            System.out.println(liquids[0]+ " " + liquids[1]);
        }
        else{
            int left = 0;
            int right = n - 1;
            while(left < right){
                int val = liquids[left] + liquids[right];
                if(Math.abs(val) < ans){
                    ans = Math.abs(val);
                    ansLeft = left;
                    ansRight = right;
                }
                if(val > 0){
                        right -= 1;
                }
                else if(val < 0){
                        left += 1;
                }
                else{
                    break;
                }
            }
            System.out.println(liquids[ansLeft] + " " + liquids[ansRight]);
        }
    }
}
