package Level0;

/**
 * LV.0 옹알이(1)
 */
import java.io.*;
import java.util.*;
import java.lang.*;

public class Babbling1 {

    // 네 가지 발음
    static String[] words = {"aya", "ye", "woo", "ma"};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] babblings = br.readLine().split(" ");

        solution(babblings);

        System.out.println(answer);
    }
    public static void solution(String[] babblings) {
        // 옹알이마다
        for (int i=0; i<babblings.length; i++) {
            String temp = babblings[i];
            // 발음 존재 검사
            for (int j = 0; j < words.length; j++)
                // 발음을 " "으로 교체, 양옆이 붙어서 발음 만드는거 방지
                temp = temp.replace(words[j], " ");
            // 공백 제거
            temp = temp.replace(" ", "");
            // 만약 공백이면 answer+1
            if (temp.equals(""))
                answer++;
        }
    }
}