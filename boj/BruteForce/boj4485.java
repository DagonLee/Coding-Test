package boj.BruteForce;
import java.io.*;
import java.util.*;
public class boj4485 {
    /*
    start 240220 07:47
    문제
    n x n 크기의 맵에서
    0,0 칸에서 n-1, n-1 칸으로 이동할때 각 칸의 값을 더해가면서 이동한다.
    칸의 합이 최소가되는 값을 구하라

    해결방법
    최소로 이동하려면 0,0에서 오른쪽 혹은 아래쪽으로만 이동해야한다.
    행이 0인 경우 열의 인덱스가 1인 값 부터 왼쪽 값을 누적해서 더해놓는다.
    열이 0인 경우 행의 인덱스가 1인 값부터 위쪽 값을 누적해서 더해놓는다.
    1,1 값부터 행, 열을 차례로 순회하면서 위쪽, 왼쪽 칸의 값을 비교하여 누적한다.

    입력
    n : 맵 크기
    이후 맵의 값이 차례로 주어진다.
    설계 완료 7:55
    => 반례가 있다. 예제 2번
    다시 설계 08:08
    
    bfs를 통해서 다음 칸의 값의 누적 합이 현재 누적 합 + 다음 칸의 값 보다 큰 경우 갱신하고 이동
    1. 누적합 맵 을 정의
    2. bfs를 통해서 갱신
    08:22=> 구현 완료
    */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        int tc = 1;
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0){
                break;
            }
            int[][] map = new int[n][n];
            int[][] val = new int[n][n];
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    val[i][j] = Integer.MAX_VALUE;
                }
            }
            val[0][0] = map[0][0];
            Deque<int[]> dq = new ArrayDeque<>();
            dq.offerLast(new int[]{0, 0, map[0][0]});
            while(!dq.isEmpty()){
                int[] now = dq.pollFirst();
                for(int d = 0; d < 4; d++){
                    int nx = now[0] + dx[d];
                    int ny = now[1] + dy[d];
                    int cur = now[2];
                    if(nx < 0 || n <= nx || ny < 0 || n <= ny){
                        continue;
                    }
                    if(cur + map[nx][ny] < val[nx][ny]){
                        val[nx][ny] = (cur + map[nx][ny]);
                        dq.offerLast(new int[]{nx, ny, val[nx][ny]});
                    }
                }
            }
            sb.append(String.format("Problem %d: %d\n",tc++, val[n - 1][n - 1]));

        }
        System.out.println(sb.toString());
    }
}
