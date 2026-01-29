import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            int n = Integer.parseInt(br.readLine());
            HashMap<String,Integer> map = new HashMap<>(n);

            for(int i=0;i<n;i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                st.nextToken();
                String category = st.nextToken();

                map.put(category,map.getOrDefault(category,0)+1);
            }

            int result = 1;
            for(int value:map.values()){
                result*=(value+1);
            }
            sb.append(result-1).append("\n");
        }
        System.out.print(sb);
    }
}