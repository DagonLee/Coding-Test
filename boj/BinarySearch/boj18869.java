package boj.BinarySearch;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
public class boj18869 {
    /*
     * 문제
     * m개의 우주가 있고 각 우주에는 1~N 까지 번호가 매겨진 행성 N개가 있다.ㄴ
     * 두 행성의 크기가 
     * 모든 1 ≤ i, j ≤ N에 대해서 아래와 같은 조건을 만족한다면, 두 우주를 균등하다고 한다.
        Ai < Aj → Bi < Bj
        Ai = Aj → Bi = Bj
        Ai > Aj → Bi > Bj
     * 균등한 우주의 쌍이 몇개인지 구하라
     * 
     * 해결방법
     * 1. 각 행성별로 인덱스와 값을 저장하고 값을 기준으로 정렬
     * 2. 1번 데이터에서 행성간 인덱스 비교를 통해 균등한 우주쌍의 개수를 알아낸다.
     * 
     * => 시간 초과
     * 문제 분류 확인, 좌표 압축
     * 
     * 좌표 압축 알고리즘 요약
     * 1. 입력 받은 배열을 정렬한 별도의 압축 배열 저장
     * 2. 압축 배열에서 배열에서 중복된 요소를 제거
     * 3. 압축 배열에서 입력 배열의 위치 인덱스를 찾고 저장하여 반환
     */
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int[][] universes = new int[m][n];
        int[] arr = new int[n];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int val = Integer.parseInt(st.nextToken());
                arr[j] = val;
            }
            int[] sorted = Arrays.stream(arr)
                                    .distinct()
                                    .sorted()
                                    .toArray();
            for(int j = 0; j < n; j++){
                universes[i][j] = Arrays.binarySearch(sorted, arr[j]);
            }
        }
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = i + 1; j < m; j++){
                if(Arrays.equals(universes[i], universes[j])){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
