package Level0;

/**
 * 문자열 정렬하기(2)
 */
import java.io.*;
import java.util.*;
import java.lang.*;

public class SortString {

    static String my_string = "";
    static String answer = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        my_string = br.readLine();

        answer = solution(my_string);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer);
        bw.flush();
        bw.close();
    }

    public static String solution(String my_string) {

        char[] c = my_string.toLowerCase().toCharArray();
        Arrays.sort(c);

        answer = new String(c);

        return answer;
    }
}
