import java.io.*;
import java.util.*;

public class Main {
    public static String solve(String s){
        Stack<Character>stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            // 여는 괄호일 경우 스택에 push
            if(c=='('||c=='['){
                stack.push(c);
            }

            // 닫는 소괄호일 경우
            else if(c==')'){
                // 스택이 비어있거나, 스택의 최상단이 여는 소괄호가 아닐 경우
                if(stack.isEmpty()||stack.peek()!='('){
                    return "no";
                }
                else{
                    stack.pop();
                }
            }
            // 닫는 대괄호일 경우
            else if(c==']'){
                // 스택이 비어있거나, 스택의 최상단이 여는 대괄호가 아닐 경우
                if(stack.isEmpty()||stack.peek()!='['){
                    return "no";
                }
                else{
                    stack.pop();
                }
            }
        }
        // 스택이 비어있을 경우 yes
        if(stack.isEmpty()){
            return "yes";
        }
        // 스택에 여는 괄호가 남아있을 경우 no
        else{
            return "no";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s;

        while(true){
            s = br.readLine();
            if(s.equals(".")){
                break;
            }
            sb.append(solve(s)).append("\n");
        }
        System.out.println(sb);

        br.close();
    }
}