import java.io.*;
import java.util.*;

public class boj1759 {
    static int l, c;
    static char[] alphas;
    static StringBuilder sb;
    static ArrayList<Character> moList = new ArrayList<>(Arrays.asList('a','e','i','o','u'));
    public static void backTrack(int idx, String password){
        if(password.length() == l){
            int mo_cnt = 0;
            int ja_cnt = 0;
            boolean growingCheck = true;
            
            for (int i = 0; i < password.length(); i++){
                if(moList.contains(password.charAt(i))){
                    mo_cnt ++;
                }
                else{
                    ja_cnt ++;
                }
                if(i > 0){
                    int prev = password.charAt(i - 1);
                    int now = password.charAt(i);
                    if(now < prev){
                        growingCheck = false;
                        break;
                    }
                }
            }
            if(mo_cnt >= 1 && ja_cnt >= 2 && growingCheck){
               sb.append(password+"\n");
            }
            return;
        }
        if(idx == c){
            return;
        }
        for(int i = idx; i < c; i++){
            backTrack(i + 1, password + alphas[i]);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        alphas = new char[c];
        for(int i = 0; i < c; i++){
            alphas[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alphas);
        backTrack(0, "");
        System.out.println(sb.toString());
    }    
}
