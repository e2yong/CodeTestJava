package Level0;

/**
 * 문자열 밀기
 */

import java.io.*;
import java.util.*;
import java.lang.*;

public class StringPush {

    static String A;
    static String B;
    static int answer=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = st.nextToken();
        B = st.nextToken();

        solution(A, B);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void solution(String A, String B) {
        // 처음부터 A==B인 경우
        if (A.equals(B)) {
            return;
        }
        // 오른쪽으로 밀기
        for (int i=0; i<A.length()-1; i++) {
            A = push(A);
            answer++;
            if (A.equals(B))
                break;
        }
        // 불가능한 경우
        if (!A.equals(B))
            answer = -1;
    }

    /** 오른쪽으로 한칸 밀기 */
    public static String push(String str) {
        char[] before = str.toCharArray();
        char[] after = new char[str.length()];

        // 오른쪽으로 밀기
        after[0] = before[str.length()-1];
        for (int i=0; i<str.length()-1; i++) {
            after[i+1] = before[i];
        }

        return String.valueOf(after);
    }
}
