package Level0;
/**
 * 종이 자르기
 */
import java.io.*;
import java.util.*;
import java.lang.*;

public class CutPaper {

    static int M;   // 가로 길이
    static int N;   // 세로 길이
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        solution(M, N);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void solution(int M, int N) {
        answer = M*N-1;
    }
}
