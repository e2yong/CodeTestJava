package Level0;

/**
 * 7의 개수
 */
import java.io.*;
import java.util.*;
import java.lang.*;

public class Count7 {
    static int[] array;
    static int N;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = st.countTokens();
        array = new int[N];
        for (int i=0; i<N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        answer = solution(array);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static int solution(int[] array) {

        answer=0;

        for (int i=0; i<N; i++) {
            String a = String.valueOf(array[i]);
            String b = a.replace("7", "");
            answer += a.length() - b.length();
        }

        return answer;
    }
}
