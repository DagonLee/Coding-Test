import java.io.*;

public class boj2661 {
    static int n;
    static char[] nums = {'1', '2', '3'};
    static boolean printed = false;
    static void backTrack(int idx, String ans){
        if(printed){
            return;
        }
        if(idx == n){
            System.out.println(ans);
            printed = true;
            return;
        }
        for(int i = 0; i < 3; i++){
            String str = ans + nums[i];
            boolean sameCheck = false;
            for(int j = 1; j <= (str.length() / 2); j++){
                String prev = str.substring(str.length() - (j * 2), str.length() - j);
                String next = str.substring(str.length() - j);
                if(prev.equals(next)){
                    sameCheck = true;
                    break;
                }
            }
            if(!sameCheck){
                backTrack(idx + 1, str);
            }
        }
        
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        backTrack(0, "");
    }
}
