package Level0;

/*
 * 제곱수 판별하기
 * 제곱근 sqrt
 */

import java.io.*;
import java.util.*;
import java.lang.*;

public class Sqrt {

    static int n;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        answer = solution(n);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static int solution(int n) {
        double sqrt = Math.sqrt(n);
        if (sqrt % 1 == 0)
            answer = 1;
        else
            answer = 2;

        return answer;
    }
}
