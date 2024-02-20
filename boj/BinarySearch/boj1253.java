package boj.BinarySearch;
import java.io.*;
import java.util.*;
public class boj1253 {
    /*
     * start 240220 08:31
     * 문제
     * n개의 수 중에서 어떤 수가 다른 두 수의 합으로 나타낼 수 있다면 '좋다' 라고 한다.
     * n개의 수가 주어지면 그 중에서 좋은 수의 개수를 구하라
     * 단, 수의 위치가 다르면 값이 같아도 다른 수이다.
     * 
     * 해결방법
     * 1. 모든 입력을 순회하여 맵에 수, 등장 횟수 로 저장한다.
     * 2. 다시 모든 수를 순회하며 확인하는 현재 수를 잡는다. 다른 값들을 순회하여 비교값을 잡고 현재 수 보다 작고 현재 수 - 비교 수가 맵에 잇는 경우
     *    비교값을 키로한 맵 값, 현재 수 - 비교 수를 키로한 맵 값을 곱하여 더한다.
     * 
     * 08:41 러프한 설계는 완료했으나 어떤 자료구조를 쓸지 고민중
     * 문제 발생
     * 중복되어 갯수가 추가되는 현상
     * ex)
     * 1, 8
     * 8, 1
     * check 배열을 두어 이미 확인 된 수는 제외
     * 09:03 => 문제 해결하지 못하여 문제 분류 확인
     * 투 포인터 
     * 접근방법을 생각하지 못하여 reference 참조
     * 이분 탐색으로 해결
     * 
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 0; i < n; i++){
            nums.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(nums);
        int cnt = 0;
        for(int i = 0; i < n; i++){
            int val = nums.get(i);
            int left = 0;
            int right = n - 1;
            while(left < right){
                int sum = nums.get(left) + nums.get(right);
                if(sum == val){
                    if(left != i && right != i){
                        cnt++;
                        break;
                    }
                    else if(left == i){
                        left ++;
                    }
                    else if(right == i){
                        right --;
                    }
                }
                else if(sum < val){
                    left++;
                }
                else{
                    right --;
                }
            }
        }
        System.out.println(cnt);
    }
}
