import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String,String> poketmonName = new HashMap<>(n);
        HashMap<String,String> poketmonNumber = new HashMap<>(n);
        for(int i=1;i<=n;i++){
            String number = Integer.toString(i);
            String name = br.readLine();
            poketmonName.put(number,name);
            poketmonNumber.put(name,number);
        }

        for(int i=0;i<m;i++){
            String input = br.readLine();
            int num = input.charAt(0);
            if(num>48&&num<=57){
                sb.append(poketmonName.get(input)).append('\n');
            }else{
                sb.append(poketmonNumber.get(input)).append('\n');
            }
        }
        System.out.println(sb);
    }
}