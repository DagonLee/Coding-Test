package boj.BruteForce;
import java.io.*;
import java.util.*;
public class boj1987 {
    /*
     * start : 240220 07:22
     * 문제
     * r x c 모양의 보드 존재, 보드의 각 칸에는 알파벳이 적혀있다.
     * 0,0 좌표에 말이 놓여있다.
     * 말은 상하좌우로 이동 가능. 단, 이전에 나온 알파벳이 아니어야한다.
     * 최대로 이동가능한 칸 수를 구하라
     * 
     * 해결방법
     * dfs를 이용
     * 1. 상하좌우 네 칸을 탐색
     * 2-1. Map에 존재하지 않는다면 이동가능, 맵에 추가하고 방문 체크 후, 재귀 호출
     * 2-2. Map에 존재한다면 패스
     * 
     * 07:31 대략적인 설계 완료
     * 구현 완료 => 07:41
     */
    static int r, c;
    static boolean[][] visited;
    static char[][] map;
    static int ans = -1;
    static Map<Character, Boolean> appearMap  = new HashMap<>();
    private static void dfs(int x, int y){
        ans = Math.max(ans, appearMap.size());
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < 0 || r <= nx || ny < 0 || c <= ny){
                continue;
            }
            if(!appearMap.containsKey(map[nx][ny])){
                visited[nx][ny] = true;
                appearMap.put(map[nx][ny], true);
                dfs(nx, ny);
                visited[nx][ny] = false;
                appearMap.remove(map[nx][ny]);
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];
        for(int i = 0; i < r; i++){
            map[i] = br.readLine().toCharArray();
        }
        appearMap.put(map[0][0], true);
        visited[0][0] = true;
        dfs(0, 0);
        System.out.println(ans);
    }
}
