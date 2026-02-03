import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortedArr = arr.clone();
        sortedArr = Arrays.stream(sortedArr).distinct().sorted().toArray();

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<sortedArr.length;i++){
            map.put(sortedArr[i],i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(map.get(arr[i])).append(" ");
        }

        System.out.println(sb);
    }
}