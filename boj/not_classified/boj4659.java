package boj.not_classified;

import java.io.*;

public class boj4659 {
    public static boolean isVowel(char c){
        if(c == 'a' || c == 'o' ||c == 'e' || c == 'i' || c == 'u'){
            return true;
        }
        return false;
    }

    public static boolean spectate(String str){
        // 모음 하나 반드시 포함
        // 모음 3개 자음 3개 연속 x
        // 같은 글자가 연속으로 두번 오면 안된다.
        boolean ans = false;
        for(int i = 0; i < str.length(); i++){
            if (isVowel(str.charAt(i))){
                ans = true;
            }
            if(i >= 1){
                if(str.charAt(i) == str.charAt(i - 1)){
                    if(str.charAt(i) != 'e' && str.charAt(i) != 'o'){
                        return false;
                    }
                }
            }
            if(i >= 2){
                boolean first = isVowel(str.charAt(i - 2));
                boolean second = isVowel(str.charAt(i - 1));
                boolean third = isVowel(str.charAt(i));
                if(first == second && second == third){
                    return false;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) throws Exception{

        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String str = br.readLine();
            if(str.equals("end")){
                break;
            }
            System.out.print("<" + str + "> ");
            if(spectate(str)){
                System.out.println("is acceptable.");
            }
            else{
                System.out.println("is not acceptable.");
            }

        }
    }    
}
