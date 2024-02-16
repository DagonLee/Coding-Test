package boj.Implementation;

import java.io.*;

public class boj7682 {
    /*
     * start 240216 15:47
     * 
     * 문제
     * 틱택토 게임
     * 1번이 X, 2번이 O
     * 
     * 9 X 9 의 입력이 주어지고
     * 왼쪽 위부터 오른쪽 아래까지 9개의 3 X 3 맵이 주어진다.
     * 
     * 해결방법
     * 1. 3x3 맵 9개를 입력받는다.
     * 2. 3x3 맵이 유효한지 판별하는 함수를 호출하여 결과를 반환
     * 3. 9개 입력을 출력
     * 
     * 데이터
     * int[][][] mapList = new int[9][3][3] // 맵 9개
     * 
     * 유효 확인 함수
     * 1. x의 개수 -  o의 개수 의 값이 1혹은 0이 되어야한다.
     * 2. .이 있는 경우 '.'가 아닌 3개 연속 되는 경우를 탐색
     * 2-1. 3개 연속 있다면 => true;
     * 2-2. 없다면 => false;
     * 
     * 
     * '.' 등장 여부를 탐색
     * '.' 가 있다면, '.' 가 아닌 문자가 3개 연속하는 지 여부 탐색
     * 3연속 없다면 false 반환
     * 
     * x의 개수 -  o의 개수 의 값이 1혹은 0인지 여부 탐색
     * 아니면 false 반환
     * 
     * 16:10 설계완료
     * 
     * 16:50 구현 완료 => fail
     * 17:06 => fail
     * end 조건을 잘못 본것을 인지
     * 수정 후 => fail, 17:50
     * 240217 00:42 => success 
     * 맵이 꽉차있는 경우 예외 처리 수행 후 => success
     */
    static StringBuilder sb ;
    public static boolean[] success(char[][] map){
        boolean[] result = new boolean[2];// 0번 인덱스는 X의 연속여부, 1반은 O의 연속여부
        for(int i = 0; i < 3; i++){
            if(map[i][0] != '.' && map[i][0] == map[i][1] && map[i][1] == map[i][2]){
                if(map[i][0] == 'X'){
                    result[0] = true;
                }
                else{
                    result[1] = true;
                }
            }
            if(map[0][i] != '.' &&  map[0][i] == map[1][i] && map[1][i] == map[2][i]){
                if(map[0][i] == 'X'){
                    result[0] = true;
                }
                else{
                    result[1] = true;
                }
            }
        }
        if(map[0][0] != '.' && map[0][0] == map[1][1] && map[1][1] == map[2][2]){
            if(map[0][0] == 'X'){
                result[0] = true;
            }
            else{
                result[1] = true;
            }
        }
        if(map[1][1] != '.' && map[0][2] == map[1][1] && map[1][1] == map[2][0]){
            if(map[0][2] == 'X'){
                result[0] = true;
            }
            else{
                result[1] = true;
            }
        }
        return result;
    }
    public static boolean check(char[][] map){
        boolean hasDot = false;
        int xCnt = 0;
        int oCnt = 0;
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j++){
                if(map[i][j] == '.'){
                    hasDot = true;
                }
                else if(map[i][j] =='X'){
                    xCnt ++;
                }
                else if(map[i][j] == 'O'){
                    oCnt ++;
                }
            }
        }
        boolean [] result = success(map);
        if(hasDot){
            if(result[0] && result[1]){
                return false;
            }
            else if(result[0]){
                if(xCnt - oCnt != 1){
                    return false;
                }
            }
            else if(result[1]){
                if(xCnt - oCnt != 0){
                    return false;
                }
            }
            else{
                return false;
            }
        }
        else{
            // 다 차있는 상태에서 3연속인 경우가 O인 경우에는 false
            if(result[1]){
                return false;
            }
        }
        if(xCnt - oCnt != 0 && xCnt - oCnt != 1){
            return false;
        }
        return true;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        while(true){
            String data = br.readLine();
            if(data.equals("end")){
                break;
            }
            char[][] tmp = new char[3][3];
            char[] line = data.toCharArray();
            for(int j = 0; j < 9; j++){
                tmp[j / 3][j % 3] = line[j];
            }
            if(check(tmp)){
                sb.append("valid\n");
            }
            else{
                sb.append("invalid\n");
            }
        }
        System.out.println(sb.toString().substring(0, sb.length() - 1));
    }
}
