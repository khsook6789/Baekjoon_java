import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int idx=0;
        while(n-->0){
            int value = Integer.parseInt(br.readLine());
            if(idx<value){
                for(int i=idx+1;i<=value;i++){
                    stack.push(i);
                    sb.append("+\n");
                }
                idx=value;
            }else if(value!=stack.peek()){
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append("-\n");
        }
        System.out.print(sb);
    }
}