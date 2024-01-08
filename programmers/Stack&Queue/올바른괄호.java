//https://school.programmers.co.kr/learn/courses/30/lessons/12909?language=java
import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        // 1. 스택을 하나 선언 문자열 전체를 탐색
        // 2. '(' 라면 스택에 추가
        // 3. ')' 라면 스택에서 마지막 값을 가져옴, 만약 스택이 비어있다면 false 반환
        // 4. 스택에 '('가 남아 있다면 fasle 반환
        Stack <Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}