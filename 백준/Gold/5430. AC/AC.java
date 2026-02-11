import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static void AC(String s, ArrayDeque<Integer> deque){
        boolean isRight = true;

        for(String str : s.split("")){
            if(str.equals("R")){
                isRight = !isRight;
            }
            else if(str.equals("D")){
                if(deque.isEmpty()){
                    sb.append("error").append("\n");
                    return;
                }
                if(isRight){
                    deque.pollFirst();
                }
                else{
                    deque.pollLast();
                }
            }
        }

        sb.append("[");

        if(!deque.isEmpty()){
            if(isRight){
                sb.append(deque.pollFirst());

                while(!deque.isEmpty()){
                    sb.append(",").append(deque.pollFirst());
                }
            }
            else{
                sb.append(deque.pollLast());

                while(!deque.isEmpty()){
                    sb.append(",").append(deque.pollLast());
                }
            }
        }
        sb.append("]").append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayDeque<Integer> deque;
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            String str = br.readLine();
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), "[,]");

            deque = new ArrayDeque<>();

            for(int i=0;i<n;i++){
                deque.add(Integer.parseInt(st.nextToken()));
            }

            AC(str, deque);
        }
        System.out.println(sb);
    }
}