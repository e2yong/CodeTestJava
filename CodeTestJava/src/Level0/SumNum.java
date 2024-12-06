package Level0;

/**
 * 연속된 수의 합
 */
import java.io.*;
import java.util.*;
import java.lang.*;

public class SumNum {

    static int num;         // 연속된 수 num 개
    static int total;       // 연속된 수의 합
    static int[] answer;    // 정답, 연속된 정수 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        num = Integer.parseInt(st.nextToken());
        total = Integer.parseInt(st.nextToken());

        solution(num, total);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i=0; i<answer.length; i++) {
            bw.write(String.valueOf(answer[i]) + " ");
        }
        bw.flush();
        bw.close();
    }

    public static void solution(int num, int total) {
        answer = new int[num];

        int start = (2 * total / num - num + 1) / 2;
        for (int i=0; i<num; i++) {
            answer[i] = start++;
        }
    }
}
