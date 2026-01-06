import java.io.IOException;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Comparator;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[]str = new String[N];

        for(int i=0;i<N;i++){
            str[i]=br.readLine();
        }

        Arrays.sort(str,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                if(s1.length()==s2.length()){
                    return s1.compareTo(s2);
                }else{
                    return s1.length() - s2.length();
                }
            }
        });
        
        //람다식으로 표현 가능
//        Arrays.sort(str, (s1, s2) -> {
//            if(s1.length()==s2.length()){
//                return s1.compareTo(s2);
//            }else{
//                return s1.length() - s2.length();
//            }
//        });
        
        System.out.println(str[0]);
        for (int i=1;i<N;i++){
            if(str[i].equals(str[i-1])){
                System.out.print("");
            }else{
                System.out.println(str[i]);
            }
        }
    }
}