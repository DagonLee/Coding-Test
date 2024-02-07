package boj.BackTracking;
import java.io.*;
import java.util.*;
public class boj1405 {
    static int n;
    static double prob;
    // 동, 남, 서, 북
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static double[] prob_list = new double[4];
    static HashMap<Integer, ArrayList<Integer>> visit = new HashMap<Integer, ArrayList<Integer>>();
    static void backTrack(int dir, int x, int y, int cnt, double tmp_prob){
        if(cnt == n){
            prob += tmp_prob;
            return;
        }
        for(int i = 0; i < 4; i++){
            if(dir != -1 && ((dir + 2) % 4) == i){
                continue;
            }
            if(prob_list[i] == 0){
                continue;
            }
            int nx = x + dx[i];
            int ny = y + dy[i];
             ArrayList<Integer> list = new ArrayList<>();
            if(visit.containsKey(nx)){
                list = visit.get(nx);
                if(list.contains(ny)){
                    continue;
                }
                else{
                    list.add(ny);
                    backTrack(i, x + dx[i], y + dy[i], cnt + 1, tmp_prob * prob_list[i]);
                    list.remove(list.size() - 1);
                }
            }
            else{
                list.add(ny);
                visit.put(nx, list);
                backTrack(i, x + dx[i], y + dy[i], cnt + 1, tmp_prob * prob_list[i]);
                visit.remove(nx);
            }
            
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < 4; i++){
            double f = Double.parseDouble(st.nextToken());
            prob_list[i] =  f / 100;
        }
        double tmp = prob_list[1];
        prob_list[1] = prob_list[2];
        prob_list[2] = tmp;
        visit.put(0, new ArrayList<>(Arrays.asList(0)));
        backTrack(-1, 0, 0, 0, 1);
        System.out.printf("%.10f", prob);
    }
    
}
