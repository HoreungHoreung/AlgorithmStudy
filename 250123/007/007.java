import java.util.*;

class Code {
        String secret_code;
        char meeting_point;
        int time;
        public Code(String secret_code, char meeting_point, int time) {
            this.secret_code = secret_code;
            this.meeting_point = meeting_point;
            this.time = time;
        }
    }
public class Main {
    
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char m = sc.next().charAt(0);
        int t = sc.nextInt();
        Code code = new Code(s, m, t);

        System.out.println("secret code : " + code.secret_code);
        System.out.println("meeting point : " + code.meeting_point);
        System.out.println("time : " + code.time);
    }
}