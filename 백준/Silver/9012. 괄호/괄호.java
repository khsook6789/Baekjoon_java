import java.io.*;
import java.util.Stack;

public class Main {
    public static String VPS(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c =='('){
                stack.push(c);
            }
            else if(stack.isEmpty()){
                return "NO";
            }
            else{
                stack.pop();
            }
        }

        if(stack.isEmpty()){
            return "YES";
        }else{
            return "NO";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++){
            sb.append(VPS(br.readLine())).append('\n');
        }
        System.out.println(sb);
    }
}