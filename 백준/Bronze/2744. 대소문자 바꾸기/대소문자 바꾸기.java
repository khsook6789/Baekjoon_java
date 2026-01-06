import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String answer = "";

        for(char ch : str.toCharArray()) {
            if(Character.isLowerCase(ch)) {
                answer+=Character.toUpperCase(ch);
            }
            else if(Character.isUpperCase(ch)) {
                answer+=Character.toLowerCase(ch);
            }
        }
        System.out.println(answer);
    }
}