import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sortedArr = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sortedArr[i] = arr[i];
        }

        Arrays.sort(sortedArr);

        int idx = 0;

        for(int i=0;i<sortedArr.length;i++){
            if(!map.containsKey(sortedArr[i])){
                map.put(sortedArr[i],idx);
                idx++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(map.get(arr[i])).append(" ");
        }

        System.out.println(sb);
    }
}