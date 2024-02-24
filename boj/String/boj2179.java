package boj.String;
import java.io.*;
import java.util.*;
public class boj2179 {
    /*
     * start 240224 09:12
     * 문제
     * n개의 영단어가 주어진다.
     * 단어들을 비교하며 비슷한 정도가 가장 높은 두 단어를 구한다. 
     * 비슷한 정도는 두 단어의 접두사 길이로 평가
     * 접두사란 두 단어의 앞부분에서 공통적으로 나타나는 부분 문자열
     * 
     * 해결방법
     * 1. 단어의 길이는 100자이므로 각 순서에 알파벳 등장 횟수를 저장하는 배열을 선언
     *    appear[100][30] 
     * 2. 각 인덱스 마다 2개 이상 나오고 이전 알파벳 값이 2이상일때  알파벳 리스트를 저장
     * 3. 알파벳 리스트들을 사용하여 단어를 조합하여 저장
     * 4. 존재하는 단어 인지확인하여 
     * 
     * 틀림 => 10:04
     * 공통 부분이 0인 경우 처리
     * =>10:26분 해결 못함 
     * reference 참조
     * 일단 문자열을 모두 정렬
     * 처음 부터 차례로 최대 공통 문자열을 갱신
     * 
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] datas = new String[n];
        for(int i = 0; i < n; i++){
            datas[i] = br.readLine();
        }
        int len = 0;
        int ans1 = -1;
        int ans2 = -1;
        for(int i = 0; i < n - 1; i++){
            String source = datas[i];
            for(int j = i + 1; j < n; j++){
                String dif = datas[j];
                int cur = 0;
                while(cur < source.length() && cur < dif.length() && dif.charAt(cur) == source.charAt(cur)){
                    cur ++;
                }
                if(len < cur){
                    len = cur;
                    ans1 = i;
                    ans2 = j;
                }
            }
        }
        if(ans1 == -1){
            System.out.print(datas[0] + "\n" + datas[1]);
        }
        else{
            System.out.println(datas[ans1] + "\n" + datas[ans2] + "\n");
        }
    }
}
