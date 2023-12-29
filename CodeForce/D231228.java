package CodeForce;
import java.io.*;
public class D231228 {
    static int l;
    static String s;
    static StringBuilder sb = new StringBuilder();
    public static boolean isVowel(char c){
        return c == 'a' || c == 'e';
    }
    public static boolean isConst(char c){
        return c == 'b' || c == 'c' || c =='d';
    }
    public static void process(int idx, String ans){
        if(idx == l){
            sb.append(ans.substring(0, ans.length() - 1));
            return;
        }
        char now = s.charAt(idx);  
        if(idx < l - 1){
            char next = s.charAt(idx + 1);
            if(isConst(now) && isVowel(next)){
                process(idx + 2, ans + s.substring(idx, idx + 2) + ".");
            }
            if(idx < (l - 2)){
                char next_next = s.charAt(idx + 2);
                if(isConst(now) && isVowel(next) && isConst(next_next)){
                    process(idx + 3, ans + s.substring(idx, idx + 3) + ".");
                }
            }
        }      
        
        
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int t = 0; t < n; t ++){
            l = Integer.parseInt(br.readLine());
            s = br.readLine();
            process(0, "");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
