import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t <T; t++){
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for(int i=0;i<k;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                String cmd = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if(cmd.equals("I")){
                    map.put(n, map.getOrDefault(n, 0) + 1);
                }else if(cmd.equals("D")){
                    if(map.isEmpty()){
                        continue;
                    }
                    if(n==1){
                        map.put(map.lastKey(),map.getOrDefault(map.lastKey(),0) - 1);
                        if(map.get(map.lastKey())<1){
                            map.remove(map.lastKey());
                        }
                    }else if(n==-1){
                        map.put(map.firstKey(),map.getOrDefault(map.firstKey(),0) -1);
                        if(map.get(map.firstKey())<1){
                            map.remove(map.firstKey());
                        }
                    }
                }
            }

            if(map.isEmpty()){
                System.out.println("EMPTY");
            }else{
                System.out.println(map.lastKey()+" "+map.firstKey());
            }
        }
    }
}