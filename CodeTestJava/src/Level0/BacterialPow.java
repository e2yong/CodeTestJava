package Level0;

/*
 * 세균 증식
 * 거듭제곱
 */

import java.io.*;
import java.util.*;
import java.lang.*;

public class BacterialPow {

    static int n, t;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        answer = solution(n, t);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static int solution(int n, int t) {

        answer = n * (int) Math.pow(2, t);
        answer = n << t;

        return answer;
    }

}
