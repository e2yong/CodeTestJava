package Level0;

/**
 * 잘라서 배열로 저장하기
 */
import java.io.*;
import java.util.*;
import java.lang.*;

public class CutString {

    static String[] answer;
    static String my_str;   // 문자열
    static int n;           // 자를 길이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        my_str = st.nextToken();
        n = Integer.parseInt(st.nextToken());

        answer = solution(my_str, n);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i=0; i<answer.length; i++)
            bw.write(answer[i] + " ");
        bw.flush();
        bw.close();
    }

    public static String[] solution(String my_str, int n) {
        int N = my_str.length() / n;
        if (my_str.length() % n != 0)
            N++;
        answer = new String[N];

        int start = 0;
        int end = n;
        for (int i=0; i<N-1; i++) {
            answer[i] = my_str.substring(start, end);
            start = start + n;
            end = end + n;
        }
        answer[N-1] = my_str.substring(start);

        return answer;
    }

}
