package Level0;

/**
 * 등차수열 또는 등비수열 다음에 올 숫자
 */

import java.io.*;
import java.util.*;
import java.lang.*;

public class NextNum {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = st.countTokens();
        int[] common = new int[N];
        for (int i=0; i<N; i++)
            common[i] = Integer.parseInt(st.nextToken());

        solution(common);

        System.out.println(answer);
    }

    public static void solution(int[] common) {
        int temp = 0;
        /** 등차수열인 경우 */
        temp = common[1] - common[0];
        if (temp == common[2] - common[1]) {
            answer = common[common.length-1] + temp;
        }
        /** 아니면 등비수열 */
        else {
            temp = common[1] / common[0];
            answer = common[common.length-1] * temp;
        }
    }
}
