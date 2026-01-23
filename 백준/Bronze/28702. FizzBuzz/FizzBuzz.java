import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        for(int i=0;i<3;i++){
            String str = br.readLine();
            char c = str.charAt(0);
            if(c!='F' && c!='B'){
                answer = Integer.parseInt(str);
            }
            if(answer!=0){
                answer++;
            }
        }

        if(answer%3==0 && answer%5==0){
            System.out.println("FizzBuzz");
        }else if(answer%3==0){
            System.out.println("Fizz");
        }else if(answer%5==0){
            System.out.println("Buzz");
        }else{
            System.out.println(answer);
        }
    }
}